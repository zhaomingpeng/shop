// pages/index/index.js
const util = require('../../utils/util.js');
const api = require('../../config/api.js');
const user = require('../../services/user.js');

//获取应用实例
const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
      banner: [],
      groupGoods:[]
  },

  getIndexData:function () {
      let that = this;
      var data = new Object();
      util.request(api.IndexUrlBanner).then(function (res) {

          if (res.errno === 0) {
              data.banner = res.data.banner
              that.setData(data);
          }
      });

    util.request(api.IndexUrlGroup).then(function (res) {

      if (res.errno === 0) {
        data.groupGoods = res.data.groupGoodsList
        that.setData(data);
      }
    });
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
        this.getIndexData();
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