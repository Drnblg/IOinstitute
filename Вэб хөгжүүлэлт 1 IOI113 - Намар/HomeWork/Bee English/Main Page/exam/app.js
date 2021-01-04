


const questionNumber = document.querySelector(".quistion-number");
const questionText = document.querySelector(".quistion-text");
const optionContainer = document.querySelector(".option-container");
const answerIndicatorContainer = document.querySelector(".answer-indicator");
const homeBox = document.querySelector(".home-box")
const quizBox = document.querySelector(".quiz-box")
const resultBox = document.querySelector(".result-box")


let quistionCounter = 0;
let currentQuistion;
let availableQuistions = [];
let availableOptions = [];
let correctAnswers = 0
let attempt = 0;


// push the quistions into a  setAvailableQuistions array
function setAvailableQuistions(){
    const totalQuestion = quiz.length;
    for(let i = 0; i < totalQuestion; i++){
        availableQuistions.push(quiz[i])
    }
}

//set quistion number and quistion and options
function getNewQuistion(){
    //set quistion number
    questionNumber.innerHTML = "Quistion " + (quistionCounter + 1) + " of " + quiz.length;

    //set quistion text
    //get random quistion
    const questionIndex = availableQuistions[Math.floor(Math.random() * availableQuistions.length)]
    currentQuistion = questionIndex;
    questionText.innerHTML = currentQuistion.q;
    //get the position of 'quistionIndex' from the availableQuistions array
    const index1 = availableQuistions.indexOf(questionIndex);
    //remove the 'quistionIndex' from the availableQuistions array,so that the quistion does not repeat
    availableQuistions.splice(index1,1);
    
    //set optioms
    //set the length of options
    const optionLen = currentQuistion.options.length
    //push options intio availableOptions array
    for(let i = 0; i < optionLen; i++){
        availableOptions.push(i)
    }
    optionContainer.innerHTML = '';
    let animationDelay = 0.2;
    //create options in html
    for(let i = 0; i < optionLen; i++){
        //random option
        const optionIndex = availableOptions[Math.floor(Math.random() * availableOptions.length)];
        //get the position of optionIndex from the availableOptions
        const index2 = availableOptions.indexOf(optionIndex);
        // remove the option index, so that the option does not repeat
        availableOptions.splice(index2,1);
        const option = document.createElement("div");
        option.innerHTML = currentQuistion.options[optionIndex];
        option.id = optionIndex;
        option.style.animationDelay = animationDelay + 's';
        animationDelay = animationDelay + 0.15;
        option.className = "option";
        optionContainer.appendChild(option)
        option.setAttribute("onclick","getResult(this)");

    }
    quistionCounter++
}
//get the result of current attempt quistion
function getResult(element){
    const id = parseInt(element.id);
   // get the answer by comparing the id of clicked option
    if(id === currentQuistion.answer){
        //set the green color to th correct option
        element.classList.add("correct");
        //add the indicator to correct mark
        updateAnswerIndicator("correct");
        correctAnswers++;
        
    }
    else{
        //set the red color to th wrong option
        element.classList.add("wrong");
        updateAnswerIndicator("wrong");

// if the answer is incorrect the show the correct option by adding green color
        const optionLen = optionContainer.children.length;
        for(let i = 0; i < optionLen; i++){
            if(parseInt(optionContainer.children[i].id) === currentQuistion.answer){
                optionContainer.children[i].classList.add("correct");
            }
        }

    }
    attempt++; //!!!!!!!!!!!!!!!!!!!!!!
    unclickableOptions()
}
//make all th options uncklickable once the user select an option
function unclickableOptions(){
    const optionlen = optionContainer.children.length;
    for(let i = 0; i<optionlen ; i++){
        optionContainer.children[i].classList.add("already-answered");
    }
}

function answerIndicator(){
    answerIndicatorContainer.innerHTML = '';
    const totalQuestion = quiz.length;
    for(let i = 0 ; i<totalQuestion; i++){
        const indicator = document.createElement("div");
        answerIndicatorContainer.appendChild(indicator);
    }
}
function updateAnswerIndicator(markType){
    answerIndicatorContainer.children[quistionCounter-1].classList.add(markType)

}

function next(){
    if(quistionCounter === quiz.length){
        
        quizOver();

    }
    else{
        getNewQuistion();
    }
}

function quizOver(){
    //hide quiz box
    quizBox.classList.add("hide");
    //show result box
    resultBox.classList.remove("hide");
    quizResult();

}
//get the quiz result
function quizResult(){
    resultBox.querySelector(".total-quistion").innerHTML = quiz.length;
    resultBox.querySelector(".total-attempt").innerHTML = attempt;
    resultBox.querySelector(".total-correct").innerHTML = correctAnswers;
    resultBox.querySelector(".total-wrong").innerHTML = attempt - correctAnswers;
    const percentage = (correctAnswers/quiz.length)*100;
    resultBox.querySelector(".percentage").innerHTML = percentage.toFixed(2) + "%";
    resultBox.querySelector(".total-score").innerHTML = correctAnswers + "/" + quiz.length;
}



// ######### starting point ###########

function startQuiz(){
//hide home box
homeBox.classList.add("hide");
//show quiz Box
quizBox.classList.remove("hide");
    //first we will set all quistions in getNewQuistion array
    setAvailableQuistions();
    //second we will call getNewQuistion() function
    getNewQuistion();
    // to create indicator of answers
    answerIndicator();
}

window.onload = function(){
    homeBox.querySelector(".total-question").innerHTML = quiz.length;
}