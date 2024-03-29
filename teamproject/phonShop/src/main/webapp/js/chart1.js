const ctx = document.getElementById('myChart'); //ctx 변수이름 중복되면 안됩니다. chart2와




var name = "<%= name %>" ;


//json형식을 배열로 담고, 그다음에 그 배열을 for문 돌려서 뿌려주는 법



new Chart(ctx, {    
  type: 'bar', //bar,doughnut, line, radar, pie, polarArea, bubble //이외는 플러그인추가
  data: {
	  
	
	  
    labels: ['Diamond', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'], //각 데이터 포인트에 대한 레이블
    datasets: [{    //차트표시되는 데이터 정의
      label: '회원수',  //데이터셋의 레이블
      data: [12, 19, 3, 5, 2, 3],   //차트에 표시할 실제 데이터값
      backgroundColor: [
        'rgba(255, 99, 132, 0.2)',
        'rgba(54, 162, 235, 0.2)',
        'rgba(255, 206, 86, 0.2)',
        'rgba(75, 192, 192, 0.2)',
        'rgba(153, 102, 255, 0.2)',
        'rgba(255, 159, 64, 0.2)',
      ],
      borderColor: [
        'rgba(255, 99, 132, 0.2)',
        'rgba(54, 162, 235, 0.2)',
        'rgba(255, 206, 86, 0.2)',
        'rgba(75, 192, 192, 0.2)',
        'rgba(153, 102, 255, 0.2)',
        'rgba(255, 159, 64, 0.2)',
      ],
      borderWidth: 1 
    }]
  },
  options: {
    scales: {
      y: {
        beginAtZero: true
      }
    }
  }
});
