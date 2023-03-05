export default {
    data: {
        books : [
            {name:"鲁滨逊漂流记",another:"丹尼尔·笛福",number:0},
            {name:"格列佛游记",another:"乔纳森·斯威夫特",number:30},
            {name:"汤姆索亚历险记",another:"马克·吐温",number:30}
        ]
    },
    onInit() {
        this.title = this.$t('strings.world');
    }
}