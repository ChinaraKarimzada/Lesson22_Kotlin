//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    //Task1
//    val myList= listOf(2,3,5,7,15)
//    val result=single(myList,{ it%3==0 && it%5==0},-1)
//    if(result!=-1) {
//        println(result)
//    }
//    else{
//        println("List doesn\'t have containing match element")
//
//    }

    // TASK 2
//    val myList = listOf(2, 3, 5, 10, 20, 30, 35, 60)
//    val result=findLast(myList,{it%10==0},-1)
//    if (result != -1) {
//        println(result)
//    } else {
//        println("No element found that matches the predicate.")
//    }


    // Task3
//    val customers= mutableListOf(
//        Person("Chinara",20,1.68),
//        Person("Kamran",25,1.90),
//        Person("Raksana",20,1.58),
//        Person("Khadija",21,1.71)
//    )
//    val result=count(customers) {
//        it.age > 20 && it.height > 1.70 && it.height < 1.90
//    }
//    println("Count of Customer:$result")


    // TASK 4
//    val myList= mutableListOf(
//        Customer(1,"Chinara"),
//        Customer(2,"Raksana"),
//        Customer(3,"Xadica"),
//        Customer(4,"Chinara"),
//    )
//    val result=distinctBy(myList){
//        it.id
//    }
//    println(result)

    // Task 5
//    val myList=listOf(2,4,5,6,7,8,9)
//    val result=dropWhile(myList){
//        it%2==0
//    }
//    println(result)


     // TASK 6
//    val myList=listOf("Hello", "World", "Hi", "House", "Tree", "Apple")
//    val result=find(myList){
//        it.startsWith("H")
//    }
//    result.forEach {
//        println(it)
//    }


    // TASK 7
    val myList= mutableListOf(10,20,30,40,50,60,20,60)
    myList.removeAll {
        it%50==0
    }
    myList.forEach {
        println(it)
    }


}



// TASK 1.single funksiyasinin analoqunu yazmaq.Cagirilan hissede 5 ve 3 bölünen ededi tapmaq
fun <T>single(myList:List<T>,condition:(T)->Boolean,defaultValue: T):T{
    var singleElement:T=defaultValue
    var count=0
    for(item in myList){
        if(condition(item)){
            singleElement=item
            count++
        }
    }
    return if(count==1) singleElement else defaultValue
}


// TASK 2.findlast funksiyasinin analoqunu yazmaq.Cagirilan hissede 10 bölünen ededlerin icinden en
// sonuncusunu tapm

fun <T>findLast(myList:List<T>,condition:(T)->Boolean, defaultValue:T):T{
    for(item in myList.size-1 downTo 0){
        if(condition(myList[item])){
            return myList[item]
        }
    }
    return defaultValue
}


// TASK 3.count funksiyasinin analoqunu yazmaq.Customer(name,age,height) modeli olsun.
// List bu tipde olsun.Yasi 20-den boyuk boyu ise 170-den boyuk 190-dan kicik müşterinin sayini tapsın.
data class Person(val name:String,
    val age:Int,
    val height:Double
)

fun <T> count(myList:MutableList<T>, selector:(T)->Boolean):Int{
    var count=0
    for(item in myList){
        if(selector(item)){
            count++
        }
    }
    return count
}


//TASK 4.distinctBy funksiyasinin analoqunu yazmaq.Person(id,name) modeli olsun.
// List bu tipde olsun.Cagirilan hissede name gore distinct etmek mümkün olsun.
data class Customer(val id:Int,val name:String)

fun<T,K> distinctBy(myList:MutableList<T>, selector:(T)->K):MutableList<T>{
    val controlSet= mutableSetOf<K>()
    val resultList= mutableListOf<T>()
    for(item in myList){
        val mySelect=selector(item)
        if(controlSet.add(mySelect)){
            resultList.add(item)
        }
    }
    return resultList
}



//TASK 5.dropWhile funkasiyasinin analoqunu yazmak.Cagirilan hissede cut ededi silmek.
fun <T> dropWhile(myList:List<T>,condition:(T)->Boolean):MutableList<T>{
    val newList= mutableListOf<T>()
    var control=true

    for(item in myList){
        if( control && condition(item)){
            continue
        }
        else{
            control=false
            newList.add(item)
        }
    }
    return newList
}

// TASK 6 Find funksiyasinin analoqun yazmaq
fun <T>find(myList:List<T>,search:(T)->Boolean):MutableList<T>{
    val result= mutableListOf<T>()
    for(item in myList){
        if(search(item)){
            result.add(item)
        }
    }
    return result
}

// TASK 7 RemoveAll funksiyasinin analoqun yazmaq

fun <T> myRemoveAl(inputList:MutableList<T>, predicate:(T)->Boolean):Boolean{
    var control=false
    var element:T
    val iterator=inputList.iterator()
    while(iterator.hasNext()){
        element=iterator.next()
        println(element)
        if(predicate(element)){
            iterator.remove()
            control=true
        }
    }
    return control
}











