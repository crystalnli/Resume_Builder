package com.example.resumebuilder.models

data class Resume (val p:PersonalInfo,val edu:Education,val skillList:List<Skill>,val expList:List<Experience>,val refList:List<Reference>)