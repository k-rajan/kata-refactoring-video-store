package kata.refactoring.video.store

class Movie(var title: String?,
            var priceCode: Int) {
    companion object {
        val CHILDRENS = 2;
        val REGULAR = 0;
        val NEW_RELEASE = 1;
    }
}