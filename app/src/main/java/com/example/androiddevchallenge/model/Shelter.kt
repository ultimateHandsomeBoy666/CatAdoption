package com.example.androiddevchallenge.model

object Shelter {
    val name = "Gulf Coast Humane Society"
    val phone = "(361)225-0845"
    val website = "http://gchscc.org"
    val address = "3118 Cabaniss, Corpus Christi, TX 78415"

    @ExperimentalStdlibApi
    val adoptionProcess = buildMap<String, String> {
        put("Additional Adoption Info", "Adoption fees for dogs start at \$150 and vary depending on medical expenses, length of stay at GCHS, and breed.\n" +
                "\n" +
                "For all dogs who have been here for over 1 year, our board of directors has waved the adoption fee! All we ask is that you purchase their first 6 months of heartworm prevention (ranges from \$30-\$50 depending on weight) as well.\n" +
                "\n" +
                "The adoption fee for adult cats start at \$50 and vary depending on medical expenses, length of stay at GCHS, and breed. The adoption fee for kittens start at \$60 and vary depending on medical expenses, length of stay at GCHS, and breed. .\n" +
                "\n" +
                "For all cats who have been here for over 1 year, our board of directors has waved the adoption fee!\n" +
                "\n" +
                "You must be at least 21 years old to adopt.\n" +
                "\n" +
                "We are open 7 days a week, 11-6pm Monday-Saturday and 12-5 Sundays.")
        put("More About This Shelter", "GCHS- Helping hands helping homeless animals since 1945.")
    }
}


