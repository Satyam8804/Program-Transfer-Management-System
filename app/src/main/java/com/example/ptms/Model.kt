package com.example.ptms

class Model{
    private var title: String? = null
    private var image: Int? = null
    private var desc:String? =null
    var isExpandable :Boolean? =false
    fun getTitle(): String? {
        return title
    }

    fun setTitle(title: String) {
        this.title = title
    }

    fun getImage(): Int? {
        return image
    }

    fun setImage(image: Int) {
        this.image = image
    }

    fun getDesc():String?{
        return desc
    }

    fun getIsExpandable():Boolean?{
        return isExpandable
    }
    fun setDesc(desc:String){
        this.desc = desc
    }

    fun setIsExpandable(isExpandable:Boolean){
        this.isExpandable = isExpandable
    }
}
