package com.lampa.dogiz.util.custom_view

data class CardModel(
    val title: String?,
    val text: String?,
    val buttonText: String? = null,
    val btnImg: String? = null,
    val img: String? = null,
    val onClickListener: (()->Unit)? = null
)

