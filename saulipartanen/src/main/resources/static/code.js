let list = document.querySelector('#ul1')
let list2 = document.querySelector('#ul2')
let list3 = document.querySelector('#ul3')

getBlogs()
getCourses()

// Täältä lähtee koululaitoksen ohjelmalogiikka. Code.js vastaa
// HTTP-pyynnöistä. Itse verkkosivun käyttöliittymä on index.html-tiedostossa

// Button-elementtejä haetaan getElementById-nimellä. Buttonit on html-tiedostossa

document.getElementById("buttonStudent").addEventListener("click", e => {
    e.preventDefault()

    let blog = {
        student: document.getElementById("auth").value,
        email: document.getElementById("email").value,
        classYear: document.getElementById("classId").value
    }

    // tiedot haetaan blog-olioon html-tiedostosta, jossa input-kenttiin on syötetty
    // halutut datat. Tämä sama ketju toistuu koko JS-osiossa
    // tiedot fetchataan javascriptin omalla toiminnolla rajapinnasta
    // tässä lähetetään pyyntö paikalliseen palvelimeen, johon lisätään yksi blogi

    fetch("http://localhost:8080/addblog",
    {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: "POST",
        body: JSON.stringify(blog)
    }).then(resp => getBlogs())
    document.getElementById("myStudentForm").reset();
})

// tässä määritellään kaksi nappia, joilla voi hakea kaikki opiskelijat / kurssit

document.getElementById("buttonSearchOne").addEventListener("click", e => {
    e.preventDefault()
    getBlogs();
})
document.getElementById("buttonSearchTwo").addEventListener("click", e => {
    e.preventDefault()
    getCourses();
})

// tämä on funktio, jota kutsumalla haetaan tiedot blogeista, eli opiskelijoista

function getBlogs(){
    list.innerHTML = ""

    fetch("http://localhost:8080/blogs")
    .then(response => response.json())
    .then(data => 
        {
            data.forEach(i => {
                let li = document.createElement("li")
                li.id = "::courseStyle";
                li.style.cssText='border-style:solid;border-width:thin;border-color:black;margin-top:5px;background-color:white;padding:2px;'
                li.innerText = "Student ID: " + i.userId + "\nName: " + i.student + "\nEmail: " + i.email + "\nYear: " + i.classYear
                list.appendChild(li)
            }) // kaikki saatu data käydään läpi for each -toiminnolla ja printataan käyttäen innerTextiä
        })
}
document.getElementById("buttonSearchStudent").addEventListener("click", e => {
    e.preventDefault()
    getStudentsById();
})

function getStudentsById(){
    list.innerHTML = "";

    let student = document.getElementById("studentSearch");
    console.log(student.value);

    if(student.value !== ''){
        fetch("http://localhost:8080/blogs/" + student.value)
        .then(response =>  response.json())
        .then(data => 
        {
            let li = document.createElement("li")
            li.id = "::courseStyle";
                li.style.cssText='border-style:solid;border-width:thin;border-color:black;margin-top:5px;background-color:white;padding:2px;'
            li.innerText = "Student ID: " + data.userId + "\nName: " + data.student + "\nEmail: " + data.email + "\nYear: " + data.classYear
            list.appendChild(li);
        })
    }
    return;
}

document.getElementById("buttonCourse").addEventListener("click", e => {
    e.preventDefault()

    let courseBlog = {
        courseName: document.getElementById("course").value,
        teacherName: document.getElementById("teacher").value
    }

    fetch("http://localhost:8080/addcourse",
    {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: "POST",
        body: JSON.stringify(courseBlog)
    }).then(resp => getCourses())
    document.getElementById("myCourseForm").reset();
})

function getCourses(){
    list2.innerHTML = ""

    fetch("http://localhost:8080/courses")
    .then(response => response.json())
    .then(data => 
        {
            data.forEach(i => {
                let li = document.createElement("li")
                li.id = "::courseStyle";
                li.style.cssText='border-style:solid;border-width:thin;border-color:black;margin-top:5px;background-color:white;padding:2px;'
                li.innerText = "Course ID:" + i.courseId + "\nName: " + i.courseName + "\nTeacher: " + i.teacherName 
                list2.appendChild(li)
            })
        })
}
document.getElementById("buttonSearchCourse").addEventListener("click", e => {
    e.preventDefault()
    getCoursesById();
})

function getCoursesById(){
    list2.innerHTML = "";

    let course = document.getElementById("courseSearch");

    if(course.value !== ''){
        fetch("http://localhost:8080/courses/" + course.value)
        .then(response =>  response.json())
        .then(data => 
        {
            let li = document.createElement("li")
            li.id = "::courseStyle";
                li.style.cssText='border-style:solid;border-width:thin;border-color:black;margin-top:5px;background-color:white;padding:2px;'
                li.innerText = "Course ID:" + data.courseId + "\nName: " + data.courseName + "\nTeacher: " + data.teacherName 
            list2.appendChild(li);
        })
    }
    return;
}

// tässä määritetään event-toiminto napille, joka vahtii opiskelijoiden lisäyksestä
// kursseille. Tiedot otetaan käyttäjän syöttämistä arvoista ja ne lähetetään jälleen
// eteenpäin. Tällä kertaa tiedot syötetään välitauluun nimeltä StudentCourse 
document.getElementById("buttonStudentCourse").addEventListener("click", e => {
    e.preventDefault()

    let studentCourse = {
        userId: document.getElementById("studentId").value,
        courseId: document.getElementById("courseId").value
    }

    fetch("http://localhost:8080/addcoursestudent",
    {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: "POST",
        body: JSON.stringify(studentCourse)
    }).then(resp => getStudentCourses(studentCourse.userId))
    document.getElementById("myStudentCourseForm").reset();
})

//lopuksi opiskelijaa ja hänen kurssejaan voi hakea
function getStudentCourses(userId){
    list3.innerHTML = "";
    
        fetch("http://localhost:8080/studentcourses/" + userId)
        .then(response => response.json())
        .then(data => 
            {
                data.forEach(i => {
                    fetch("http://localhost:8080/courses/" + i)
                    .then(response => response.json())
                    .then(data2 => {
                        let li = document.createElement("li")
                        li.id = "::courseStyle";
                        li.style.cssText='border-style:solid;border-width:thin;border-color:black;margin-top:5px;background-color:white;padding:2px;list-style-type:none;margin-left:10px'
                        li.innerText = "Student ID:" + userId + "\nCourse ID:" + data2.courseId + "\nCourse name:"+ data2.courseName
                        list3.appendChild(li)
                    })  
                })
            })
    }