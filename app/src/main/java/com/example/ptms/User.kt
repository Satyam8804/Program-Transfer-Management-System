package com.example.ptms

class User(private var Name:String, private var Email:String, private var regNo: String, private var cgpa:Float, private var program:String, private var contactNo:String){
  fun getName():String{
      return Name;
  }
    fun getRegNo() :String{
        return regNo
    }
    fun getCgpa():Float{
        return cgpa;
    }
    fun getProgram():String{
        return program
    }
    fun getContactNo():String{
        return contactNo
    }
    fun getEmail():String{
        return Email
    }














}