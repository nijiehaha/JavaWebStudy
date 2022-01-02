// pages/page1/page1.js
Page({

    /**
     * 页面的初始数据
     */
    data: {
        text:'hello',
        arr:[]
    },

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function (options) {

        var tempArr = []
        for (let index = 0; index < 10; index++) {
            tempArr.push({
                id:index,
                name:'hello'
            });
        }

        this.setData({
            text:'222222',
            temp:'11111',
            arr: tempArr,
        })

        console.log(this.data.arr);

        wx.showToast({
          title: 'success!',
        })

        wx.request({
          url: 'http://127.0.0.1:8080/api/test/hello',
          method: 'GET',
          success(r){
              console.log(r.data)
          }
        })

        wx.request({
            url: 'http://127.0.0.1:8080/api/test/upload',
            method: 'POST',
            data:{
                num1:5,
                num2:199
            },
            success(r){
                var jsonStr = r.data;
                console.log(jsonStr.result);
            }
        })

        wx.request({
            url: 'http://127.0.0.1:8080/api/sql/register',
            method: 'POST',
            data:{
                name:"lufei",
                password:"123"
            },
            success(r){
                console.log(r.data);
            }
        })

        wx.request({
            url: 'http://127.0.0.1:8080/api/redis/add',
            method: 'POST',
            data:{
                key:"lufei",
                value:"123"
            },
            success(r){
                console.log(r.data);
            }
        })
    },

    /**
     * 生命周期函数--监听页面初次渲染完成
     */
    onReady: function () {

    },

    /**
     * 生命周期函数--监听页面显示
     */
    onShow: function () {

    },

    /**
     * 生命周期函数--监听页面隐藏
     */
    onHide: function () {

    },

    /**
     * 生命周期函数--监听页面卸载
     */
    onUnload: function () {

    },

    /**
     * 页面相关事件处理函数--监听用户下拉动作
     */
    onPullDownRefresh: function () {

    },

    /**
     * 页面上拉触底事件的处理函数
     */
    onReachBottom: function () {

    },

    /**
     * 用户点击右上角分享
     */
    onShareAppMessage: function () {

    }
})