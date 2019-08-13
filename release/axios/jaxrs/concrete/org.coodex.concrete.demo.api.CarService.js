/* eslint-disable */
import {argumentsError, execute, overload} from '../concrete'

const module = 'concrete'

const CarService = {
    'getCarById': function (id) {
        return execute(module, `/Cars/${id}`, 'json', 'GET');
    }, 
    'warningExample': function () {
        return execute(module, `/Cars/warningExample`, 'json', 'GET');
    }, 
    'getCarNumberById': function (id) {
        return execute(module, `/Cars/${id}/PlateCode`, 'text', 'GET');
    }
}

export default CarService


