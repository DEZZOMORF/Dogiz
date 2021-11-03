package com.lampa.dogiz.util.custom_view

data class CardModel(
    val label: String? = null,
    val title: String? = null,
    val subtitle: String? = null,
    val text: String? = null,
    val buttonText: String? = null,
    val btnImg: String? = null,
    val img: String? = null,
    val onClickListener: (()->Unit)? = null
)

