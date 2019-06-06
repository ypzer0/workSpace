<template v-text = 'name'>

</template>

<script type="text/ecmascript-6">
export default {
    data(){
        return{
            name: "VFWs6ecdlScbAQEY",
        }
    },
 
  methods:{
   ToText(vue)
  {
      var input = vue;
      return input.replace(/<(style|script|iframe)[^>]*?>[\s\S]+?<\/\1\s*>/gi,'').replace(/<[^>]+?>/g,'').replace(/\s+/g,' ').replace(/ /g,' ').replace(/>/g,' ');  
  }
  },

}
</script>