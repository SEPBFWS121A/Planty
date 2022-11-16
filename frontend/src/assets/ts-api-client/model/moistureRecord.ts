/**
 * Planty API
 * API for communication between frontend, microcontroller and backend.
 *
 * The version of the OpenAPI document: 0.0.3
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


export interface MoistureRecord { 
    /**
     * The ID schema used for most database entities.
     */
    id?: number;
    /**
     * A timestamp containing date and time.
     */
    timestamp?: Date;
    /**
     * Humidity level reported by a sensor scaled from 0 to 100.
     */
    humidityLevel?: number;
    /**
     * The ID schema used for most database entities.
     */
    plantId?: number;
}
