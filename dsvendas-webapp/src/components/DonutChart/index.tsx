import axios from 'axios';
import Chart from 'react-apexcharts';
import { BASE_URL } from 'service/requests';
import { SalesSum } from 'types/sale';

type ChartData = {
    labels: string[],
    series: number[]
}



function DonutChart(){

    // FORMA ERRADA -> PROVISORIA
    let chartData : ChartData = { labels: [], series: [] };

    // const mockData = {
    //     series: [477138, 499928, 444867, 220426, 473088],
    //     labels: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
    // }

    axios.get(`${BASE_URL}/sales/amount-by-seller`)
        .then(response => {
            const data = response.data as SalesSum[];
            const dataLabels = data.map(x => x.sellerName);
            const dataSeries = data.map(x => x.sum);

            chartData = { labels: dataLabels, series: dataSeries };
        });
    
    const options = {
        legend: {
            show: true
        }
    }

    return (
        <Chart 
            options={{...options, labels: chartData.labels}}
            series={chartData.series}
            type="donut"
            height="240"
        />
    );
}

export default DonutChart;