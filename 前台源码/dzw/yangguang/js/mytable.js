Vue.component("mytable",{
props:{
	title:{
		type:Array,
		default:[],
		required:true
	},
	list:{
		type:Array,
		default:[],
		required:false
	}
},
template:`<table border=1>
			<tr>
				<td v-for="item in title">{{item}}</td>
				<td>
					操作
				</td>
			</tr>
			<tr v-for="item,index in list">
				<td v-for="attr in item">{{attr}}</td>
				<td><button @click="remove(item,index)">删除</button></td>
				<td>
					<slot :student="item"></slot>
				</td>
			</tr>
		  </table>`,
data(){
	return {
	}
},
methods:{
	remove(item,index){
		this.list.splice(index,1);
		this.$emit("remove",item,index);
		}
	}
})