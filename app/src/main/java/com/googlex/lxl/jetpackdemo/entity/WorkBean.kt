package com.googlex.lxl.jetpackdemo.entity

import android.text.TextUtils


import java.io.Serializable

/**
 * Created by xiaolong.liu on 2018/1/24.
 */

class WorkBean {
    var size: Int = 0
    var total: Int = 0
    var list: List<ListBean>? = null
    var uploadShareImage: WorkBean.ListBean? = null

    var jumpMenuId: String? = null //好友动态里 没数据时跳转到推荐用户列表 menuId
    var jumpUrl: String? = null //跳转的链接
    var jumpMenuName: String? = null

    class ListBean : Serializable {
        var id: String? = null //作品教程id
        var name: String? = null //作品或者教程名称
        var level: String? = null
        var step: String? = null
        var isNew: String? = null
        var useCnt: Int = 0//教程使用次数
        var likeCnt: Int = 0              //点赞数
        var shareCnt: Int = 0             //分享数
        var downloadCnt: Int = 0          //下载数
        var createTime: String? = null        //作品教程创建时间
        var updateTime: String? = null
        var status = "1"  //0 正在审核中  1 审核通过 2 未通过审核
        var isSuccess: String? = null
        var createCustId: String? = null
        var labels: String? = null            //标签
        var isFavorited: Boolean = false    //是否已收藏
        var image: String? = null             //用户头像图片
        var clickCnt: Int = 0//作品点击数
        var referWorksName: String? = null
        var referWorksUrl: String? = null
        var referRoleName: String? = null
        var worksBrief: String? = null          //作品简介
        var fileName: String? = null            //原始图片文件
        var tutorialType: String? = null
        var appType: String? = null
        var userName: String? = null
        var isFollow: Boolean = false           //关注
        var height: Double = 0.toDouble()              //原始图片高度
        var width: Double = 0.toDouble()           //原始图片宽度
        var isFollowIsVisable = true //是否显示收藏五角星按钮   个人中心界面用户作品不要显示五角星  所以添加此字段
        var isBigPic: Boolean = false
        var minWidth: Double = 0.toDouble()        //列表缩略图宽度
        var minHeight: Double = 0.toDouble()       //列表缩略图高度
        var minFileName: String? = null     //列表缩略图文件
        var midFileName: String? = null     //作品详情展示图
        var midHeight: Double = 0.toDouble()       //详情展示图高度
        var midWidth: Double = 0.toDouble()        //详情展示图宽度
        var commentCnt: Int = 0         //评论数
        var borderColor: String? = null    //边框颜色
        var isVip: String? = null           //1 是VIP 0 不是vip
        var pendant = ""       //用户头像挂件的url
        var isLiked: Boolean = false        //是否点赞
        var isDelete: Boolean = false       //标记删除   在个人作品删除时用到
        var collectCnt: Int = 0      //收藏次数
        var unzip: String? = null
        var zipFileName: String? = null
        var createCustName: String? = null
        var referName: String? = null
        var referUrl: String? = null
        var appTypes: String? = null
        var downLoadPath: String? = null
        var localPath: String? = null
        var subName: String? = null
        var snapshotPath: String? = null
        var thumbnailPath: String? = null
        var tutorialCount: Int = 0
        var favoritedCnt: Int = 0
        var intervalTime: String? = null //转换后的时间  日月年

        var followRank: String? = null
        var uploadRank: String? = null
        var likeRank: String? = null

        /**
         * 是否包含教程
         * @return
         */
        fun hasTutorial(): Boolean {
            return "1" == unzip && !TextUtils.isEmpty(zipFileName)
        }

    }

}
