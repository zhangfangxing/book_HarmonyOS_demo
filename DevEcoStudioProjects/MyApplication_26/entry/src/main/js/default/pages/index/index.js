export default {
    data: {
        books : [
            {name:"鲁滨逊漂流记",another:"丹尼尔·笛福"},
            {name:"格列佛游记",another:"乔纳森·斯威夫特"},
            {name:"汤姆索亚历险记",another:"马克·吐温"}
        ]
    },
    onInit() {
        this.title = this.$t('strings.world');
    }
}