package com.bw.movie.net;

/**
 * 魏天祥
 * 2018/11/27
 */
public class HttpUrl {
    //注册
    public static final String STRING_REG="";
    //登录
    public static final String STRING_LOGIN="user/v1/login";
    //查询用户首页信息
    public static final String STRING_SELECT="";
    //修改用户信息
    public static final String STRING_UPDATA_USER="";
    //上传用户头像
    public static final String STRING_BTN_HEAD="";
    //修改密码
    public static final String STRING_UPDATA="";
    //根据用户ID查询用户信息
    public static final String STRING_ID_SELECT="";
    //用户签到
    public static final String STRING_SIGN_IN="";
    //用户购票记录查询列表
    public static final String STRING_RECORD_SELECT="";
    //微信登录
    public static final String STRING_WECHAT_LOGIN="";
    //绑定微信账号
    public static final String STRING_BINDING_WECHAT="";
    //是否绑定微信账号
    //查询热门电影列表

    //查询正在热映电影列表
    //查询正在上映电影列表

    public static final String STRING_HOT_MOVIE="movie/v1/findHotMovieList";
    //查询正在热映电影列表
    public static final String STRING_SHOW_MOVIE="movie/v1/findReleaseMovieList";
    //查询正在上映电影列表
    public static final String STRING_WILL_MOVIE="movie/v1/findComingSoonMovieList";

    //根据电影ID查询电影信息
    //查看电影详情
    //查询用户关注的影片列表
    public static final String STRING_ATTENTION_CINEMA = "cinema/v1/verify/findCinemaPageList";
    //关注电影
    //取消关注电影
    //查询影片评论列表
    //添加用户对影片的评论
    //查询影片评论回复
    //添加用户对评论的回复
    //电影评论点赞
    //根据影院ID查询该影院当前排期的电影列表
    //根据电影ID和影院ID查询电影排期列表
    //根据电影ID查询当前排片该电影的影院列表
    //购票下单
    //支付【支持微信和支付宝支付】
    //根据影院ID查询该影院下即将上映的电影列表
    //查询推荐影院信息
    public static final String RECOMMEND_CINEMA="cinema/v1/findRecommendCinemas";
    //查询电影信息明细
    public static final String CINEMA_INFO = "cinema/v1/findCinemaInfo";
    //查询所有电影院
    //查询用户关注的影院信息
    //关注影院
    //取消关注影院
    //查询影院用户评论列表
    //影院评论
    //影院评论点赞
    //意见反馈
    //查询新版本
    public static final String APP_VERSION_CODE = "tool/v1/findNewVersion";
    //查询系统消息列表
    //系统消息读取状态修改
    //查询用户当前未读消息数量
    //上传信鸽推送token
    //微信分享

}
