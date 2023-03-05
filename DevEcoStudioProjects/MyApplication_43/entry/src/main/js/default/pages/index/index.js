export default {
    swipeTo() {
        this.$element('swiper').swipeTo({index: 2});
    },
    showNext() {
        this.$element('swiper').showNext();
    },
    showPrevious() {
        this.$element('swiper').showPrevious();
    }
}