package com.example.fakeapply

import android.annotation.SuppressLint
import android.graphics.Typeface
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.google.android.material.textview.MaterialTextView
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContentView(R.layout.activity_main)
        init()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("CutPasteId", "SetTextI18n", "DiscouragedApi")
    fun init() {
        val names = arrayOf(
            "陈思思", "李小明", "张美丽", "王伟", "刘强", "赵静", "黄宇航", "周雪峰", "吴雨萌", "冯磊",
            "许婷婷", "何超", "孙鹏", "马丽娜", "高飞", "林波", "徐婷婷", "梁浩", "宋洋", "郑小红",
            "唐琳", "韩磊", "曾晓华", "姚鑫", "谢玉霞", "苏鹏", "彭小峰", "董丽丽", "余浩", "邓杨",
            "范静静", "龚伟", "于涛", "秦芳芳", "白娜", "田亮", "潘丽丽", "毛刚", "魏艳艳", "陶超",
            "秦梦梦", "何洋", "施明明", "卢红", "付刚", "姜明", "崔丽", "钟华", "袁小飞", "余文",
            "叶文静", "邱红", "岳伟", "雷梦琳", "龙海", "黄丽", "何萌萌", "汪鑫", "段婷婷", "谭飞",
            "康波", "蔡丽丽", "严鑫", "温雨婷", "钮霞", "邹林", "龚婷婷", "阳小伟", "石静", "鲁杨",
            "孔琳琳", "魏翔", "华秀英", "秦伟", "江芳芳", "万华", "范雪", "乔峰", "梅晓丽", "蒋瑞",
            "方佳佳", "赵莉莉", "钱华", "熊超", "裴丽丽", "吕伟", "韦娜", "沈丽", "卓小青", "郭帅",
            "姚晨", "冯春燕", "贺鑫", "曹娜", "金磊", "邹娜", "程峰", "苏琳琳", "潘博", "董慧",
            "余亚", "邓小军", "肖敏", "郑杰"
        )
        val imgs = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)
        val index = Random.nextInt(names.size)
        val indexAnother = Random.nextInt(names.size)
        val indexImg = Random.nextInt(imgs.size)
        val filename = "a" + imgs[indexImg]
        val name = names[index]
        val nameImmer = names[indexAnother]
        val title = name + "的学生请假"
        val titleTextView = findViewById<MaterialTextView>(R.id.titleTextView)
        titleTextView.text = title
        val now = LocalDateTime.now().plusHours(-1)
        val formatterId = DateTimeFormatter.ofPattern("yyyyMMddHHmm")
        val formatterDate = DateTimeFormatter.ofPattern("yyyy/M/d H:mm")
        val formatterStatus = DateTimeFormatter.ofPattern("M/d H:mm")
        val dateTimeString = now.format(formatterId)
        val dateTime = now.format(formatterDate)
        val startTime = now.format(formatterDate)
        val endTime = now.plusHours(5).format(formatterDate)
        val imageRes = resources.getIdentifier(filename, "drawable", packageName)
        findViewById<ImageView>(R.id.headImg).setImageResource(imageRes)
        findViewById<View>(R.id.teacher).findViewById<ImageView>(R.id.complexHead).setImageResource(R.drawable.teacher)
        findViewById<View>(R.id.user).findViewById<ImageView>(R.id.complexHead).setImageResource(imageRes)
        findViewById<View>(R.id.userAction).findViewById<ImageView>(R.id.complexHead).setImageResource(imageRes)
        findViewById<View>(R.id.admin).findViewById<ImageView>(R.id.complexHead).setImageResource(R.drawable.admin)
        findViewById<View>(R.id.id).findViewById<MaterialTextView>(R.id.key).text = "审批编号"
        findViewById<View>(R.id.id).findViewById<MaterialTextView>(R.id.value).text = dateTimeString
        findViewById<View>(R.id.time).findViewById<MaterialTextView>(R.id.key).text = "提交时间"
        findViewById<View>(R.id.time).findViewById<MaterialTextView>(R.id.value).text = dateTime
        findViewById<View>(R.id.dep).findViewById<MaterialTextView>(R.id.key).text = "所在部门"
        findViewById<View>(R.id.dep).findViewById<MaterialTextView>(R.id.value).text = "计科61905"
        findViewById<View>(R.id.type).findViewById<MaterialTextView>(R.id.key).text = "请假类型"
        findViewById<View>(R.id.type).findViewById<MaterialTextView>(R.id.value).text = "事假"
        findViewById<View>(R.id.start).findViewById<MaterialTextView>(R.id.key).text = "开始时间"
        findViewById<View>(R.id.start).findViewById<MaterialTextView>(R.id.value).text = startTime
        findViewById<View>(R.id.end).findViewById<MaterialTextView>(R.id.key).text = "结束时间"
        findViewById<View>(R.id.end).findViewById<MaterialTextView>(R.id.value).text = endTime
        findViewById<View>(R.id.dur).findViewById<MaterialTextView>(R.id.key).text = "请假时长"
        findViewById<View>(R.id.dur).findViewById<MaterialTextView>(R.id.hint).visibility = View.VISIBLE
        findViewById<View>(R.id.dur).findViewById<MaterialTextView>(R.id.hint).text = "当前请假时长为自动计算，查看时长明细"
        findViewById<View>(R.id.dur).findViewById<MaterialTextView>(R.id.value).text = "5小时"
        findViewById<View>(R.id.isOut).findViewById<MaterialTextView>(R.id.key).text = "是否出省"
        findViewById<View>(R.id.isOut).findViewById<MaterialTextView>(R.id.value).text = "否"
        findViewById<View>(R.id.due).findViewById<MaterialTextView>(R.id.key).text = "请假事由"
        findViewById<View>(R.id.due).findViewById<MaterialTextView>(R.id.value).text = "老师好，我想去拿快递，望批假，非常感谢"
        findViewById<View>(R.id.immer).findViewById<MaterialTextView>(R.id.key).text = "紧急联系人姓名"
        findViewById<View>(R.id.immer).findViewById<MaterialTextView>(R.id.value).text = nameImmer
        findViewById<View>(R.id.tel).findViewById<MaterialTextView>(R.id.key).text = "紧急联系人电话"
        findViewById<View>(R.id.tel).findViewById<MaterialTextView>(R.id.value).text = generateChinesePhoneNumber()
        findViewById<View>(R.id.ext).findViewById<MaterialTextView>(R.id.key).text = "说明附件"
        findViewById<View>(R.id.ext).findViewById<MaterialTextView>(R.id.value).text = "无"
        findViewById<View>(R.id.clo).findViewById<MaterialTextView>(R.id.key).text = "是否销假"
        findViewById<View>(R.id.clo).findViewById<MaterialTextView>(R.id.value).text = "无"
        findViewById<MaterialTextView>(R.id.stream).text = "审批流程"
        findViewById<MaterialTextView>(R.id.stream).typeface = Typeface.DEFAULT_BOLD
        findViewById<View>(R.id.teacher).findViewById<ImageView>(R.id.complexIcon).setImageResource(R.drawable.print)
        findViewById<View>(R.id.teacher).findViewById<MaterialTextView>(R.id.complexTitle).text = "辅导员 • 已同意"
        findViewById<View>(R.id.teacher).findViewById<MaterialTextView>(R.id.complexName).text = "陈春燕"
        findViewById<View>(R.id.teacher).findViewById<MaterialTextView>(R.id.complexStatus).text = "已同意 • " + now.plusMinutes(23).format(formatterStatus)

        findViewById<View>(R.id.user).findViewById<ImageView>(R.id.complexIcon).setImageResource(R.drawable.fly)
        findViewById<View>(R.id.user).findViewById<MaterialTextView>(R.id.complexTitle).text = "请假成功 • 已抄送"
        findViewById<View>(R.id.user).findViewById<MaterialTextView>(R.id.complexName).text = name
        findViewById<View>(R.id.user).findViewById<MaterialTextView>(R.id.complexStatus).text = "已抄送 • " + now.plusMinutes(31).format(formatterStatus)

        findViewById<View>(R.id.userAction).findViewById<ImageView>(R.id.complexIcon).setImageResource(R.drawable.print)
        findViewById<View>(R.id.userAction).findViewById<MaterialTextView>(R.id.complexTitle).text = "销假 • 已同意"
        findViewById<View>(R.id.userAction).findViewById<MaterialTextView>(R.id.complexName).text = name
        findViewById<View>(R.id.userAction).findViewById<MaterialTextView>(R.id.complexStatus).text = "已同意 • " + now.plusMinutes(36).format(formatterStatus)

        findViewById<View>(R.id.admin).findViewById<ImageView>(R.id.complexIcon).setImageResource(R.drawable.fly)
        findViewById<View>(R.id.admin).findViewById<MaterialTextView>(R.id.complexTitle).text = "学生处 • 已抄送"
        findViewById<View>(R.id.admin).findViewById<MaterialTextView>(R.id.complexName).text = "肖魏"
        findViewById<View>(R.id.admin).findViewById<MaterialTextView>(R.id.complexStatus).text = "已抄送 • " + now.plusMinutes(39).format(formatterStatus)
    }

    fun generateChinesePhoneNumber(): String {
        val prefixList = listOf("133", "149", "153", "173", "177", "180", "181", "189", "191", "199", "130", "131", "132", "145", "155", "156", "166", "171", "175", "176", "185", "186", "166", "134", "135", "136", "137", "138", "139", "147", "150", "151", "152", "157", "158", "159", "172", "178", "182", "183", "184", "187", "188", "198")
        val prefix = prefixList.random()
        val middle = Random.nextInt(1000, 10000).toString()
        val end = Random.nextInt(1000, 10000).toString()
        return "$prefix$middle$end"
    }

}
