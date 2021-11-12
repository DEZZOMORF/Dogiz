package com.lampa.dogiz.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.lampa.dogiz.R
import com.lampa.dogiz.adapter.DogProfilesViewPagerAdapter
import com.lampa.dogiz.adapter.JourneyAdapter
import com.lampa.dogiz.databinding.FragmentHubBinding
import com.lampa.dogiz.retrofit.hub.mapper.ContentJourneyMapper
import com.lampa.dogiz.util.Logger
import com.lampa.dogiz.util.ProfileSliderTransformer
import com.lampa.dogiz.util.UiState
import com.lampa.dogiz.util.custom_view.CardModel
import com.lampa.dogiz.viewmodel.HubViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HubFragment : Fragment() {

    @Inject
    lateinit var dogProfilesViewPagerAdapter: DogProfilesViewPagerAdapter

    @Inject
    lateinit var journeyAdapter: JourneyAdapter

    private val viewModel: HubViewModel by viewModels()
    private val binding: FragmentHubBinding get() = _binding!!
    private var _binding: FragmentHubBinding? = null

    private val notificationList: MutableList<CardModel> = mutableListOf()
    private val scheduleList: MutableList<CardModel> = mutableListOf()
    private val faqList: MutableList<CardModel> = mutableListOf()
    private val recommendList: MutableList<CardModel> = mutableListOf()
    private val moodList: MutableList<CardModel> = mutableListOf()
    private val rewardList: MutableList<CardModel> = mutableListOf()
    private val drPoopList: MutableList<CardModel> = mutableListOf()
    private val activityList: MutableList<CardModel> = mutableListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentHubBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //val loginResponse = requireArguments().getParcelable<LoginCheckCodeResponse>("data")

        /////////////////Hardcode//////////////////////
        with(scheduleList) {
            add(
                CardModel(
                    title = "Vet service",
                    text = "17:00",
                    img = "https://upload.wikimedia.org/wikipedia/commons/thumb/1/13/United-kingdom_flag_icon_round.svg/2048px-United-kingdom_flag_icon_round.svg.png"
                )
            )
            add(CardModel(title = "Title", text = "time"))
            add(CardModel(title = "Title2", text = "time2"))
            add(CardModel(title = "Title2", text = "time2"))
            add(CardModel(title = "Title2", text = "time2"))
            add(CardModel(title = "Title2", text = "time2"))
        }
        faqList.add(
            CardModel(
                title = "Loosing dog aleart",
                text = "Notify neigbourhood about your dog, so they can help you to find it",
                buttonText = "Help"
            )
        )
        notificationList.add(CardModel(title = "Don't forget about vaccines", text = "Vaccination due in 2 days"))
        with(recommendList) {
            add(
                CardModel(
                    title = "Lorem ipsum dolor sit amet",
                    text = "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur",
                    img = "https://pbs.twimg.com/media/EKvrgoOX0AM1_oz.jpg"
                )
            )
            add(
                CardModel(
                    title = "Lorem ipsum dolor sit amet",
                    text = "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur",
                    img = "https://pbs.twimg.com/media/EKvrgoOX0AM1_oz.jpg"
                )
            )
            add(
                CardModel(
                    title = "Lorem ipsum dolor sit amet",
                    text = "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur",
                    img = "https://pbs.twimg.com/media/EKvrgoOX0AM1_oz.jpg"
                )
            )
        }
        moodList.add(
            CardModel(
                title = "Great mood",
                text = "Updated 57 min ago",
                buttonText = "Update mood",
                onClickListener = { Toast.makeText(requireContext(), "upd", Toast.LENGTH_SHORT).show() })
        )
        rewardList.add(
            CardModel(
                title = "First walk",
                text = "Do your first self walk",
                buttonText = "+10",
                btnImg = "https://www.iconpacks.net/icons/2/free-coin-icon-2159-thumb.png"
            )
        )
        drPoopList.add(
            CardModel(
                title = "Hesitating about your dog’s health?",
                text = "Dr. Poop will answer the relevant dog's owners questions",
                buttonText = "Examinate",
                img = "https://pbs.twimg.com/media/EKvrgoOX0AM1_oz.jpg",
                onClickListener = { Toast.makeText(requireContext(), "exmnt", Toast.LENGTH_SHORT).show() })
        )
        activityList.add(
            CardModel(
                label = "Label",
                title = "3.54 km",
                subtitle = "35 min • 19:03 - 19:38",
                text = "Self walking",
                buttonText = "Do the walk",
                img = "https://clipart-best.com/img/gps-icon/gps-icon-clip-art-13.png",
                onClickListener = { Toast.makeText(requireContext(), "start/end the walk", Toast.LENGTH_SHORT).show() })
        )
        ////////////////////////////////////////////////

        setHubObserver()
        viewModel.getData()
        initViewPagers()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setHubObserver() {
        viewModel.hubUiState.observe(viewLifecycleOwner) { state ->
            when (state) {
                is UiState.Loading -> displayProgressBar(true)
                is UiState.Success -> {
                    displayProgressBar(false)
                    state.data?.let { data ->
                        data.dogs?.content?.let {
                            dogProfilesViewPagerAdapter.list = it
                            dogProfilesViewPagerAdapter.notifyItemRangeInserted(0, it.size)
                        }
                        data.journey?.content?.let {
                            journeyAdapter.list = (ContentJourneyMapper().mapFromEntityList(it))
                            journeyAdapter.notifyItemRangeInserted(0, it.size)
                        }
                    }
                }
                is UiState.Error -> {
                    displayProgressBar(false)
                    displayError(state.error.message)
                }
            }
        }
    }

    private fun displayProgressBar(isDisplayed: Boolean) {
        binding.progressBar.visibility = if (isDisplayed) View.VISIBLE else View.GONE
    }

    private fun displayError(message: String?) {
        if (message != null) {
            Toast.makeText(context, message, Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(context, resources.getString(R.string.default_error_message), Toast.LENGTH_LONG).show()
        }
    }

    private fun initViewPagers() {
        with(binding.dogsViewPager) {
            dogProfilesViewPagerAdapter.onItemClickListener = { setCurrentItem(it, true) }
            adapter = dogProfilesViewPagerAdapter
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
            offscreenPageLimit = 3
            setPageTransformer(ProfileSliderTransformer(3))
            registerOnPageChangeCallback(object : OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    binding.dog = dogProfilesViewPagerAdapter.list[position]
                }
            })
        }
        with(binding.journey.rv) {
            layoutManager = object : LinearLayoutManager(requireContext()){ override fun canScrollVertically(): Boolean { return false } }
            adapter = journeyAdapter
        }
        with(binding) {
            scheduleViewPager.cardList = scheduleList
            scheduleViewPager.button.setOnClickListener { Toast.makeText(requireContext(), "click", Toast.LENGTH_SHORT).show() }
            faqViewPager.cardList = faqList
            notificationViewPager.cardList = notificationList
            recommendViewPager.cardList = recommendList
            moodViewPager.cardList = moodList
            rewardViewPager.cardList = rewardList
            drPoopViewPager.cardList = drPoopList
            activityViewPager.cardList = activityList
        }
    }
}