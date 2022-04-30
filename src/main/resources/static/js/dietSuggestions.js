const units = document.querySelector('#units')
const targetWeight = document.querySelector('#target')

function setTargetWeightToMetricSystem() {
    targetWeight.setAttribute('max', '0.9')
}

function setTargetWeightToImperialSystem() {
    targetWeight.setAttribute('max', '2')
}

units.addEventListener('change', () => {
    targetWeight.value = 0
    if(units.value === 'METRIC') {
        setTargetWeightToMetricSystem()
    }
    if(units.value === 'IMPERIAL') {
        setTargetWeightToImperialSystem()
    }
});

setTargetWeightToMetricSystem()

