package com.rapidzz.garageapp.Models.DataModels.GeneralModels

data class AllUserInfo(
    val created_at: String,
    val deleted_at: Any,
    val father_annual_income: String,
    val father_contact_number: String,
    val father_designation: String,
    val father_email: String,
    val father_name: String,
    val father_pan_number: String,
    val father_profession_id: Int,
    val father_qualification_id: Int,
    val id: Int,
    val mother_annual_income: String,
    val mother_contact_number: String,
    val mother_designation: String,
    val mother_email: String,
    val mother_name: String,
    val mother_pan_number: String,
    val mother_profession_id: Int,
    val mother_qualification_id: Int,
    val parent_id: Int,
    val updated_at: String
)