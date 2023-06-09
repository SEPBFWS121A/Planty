import { forEach } from 'cypress/types/lodash';
describe('Category Page button test', () => {
    before(() => {
        cy.visit('http://localhost:4200/category');
    });

    it('fill out form, submits and deletes the category', () => {
        cy.get('input[placeholder="Name"]').type('Category Name');
        cy.get('input[placeholder="Description"]').type('Category Description');
        cy.get('input[placeholder="Min Humidity Level"]').type('10');

        cy.get('button').contains('Add Category').click();

        // Find the button within the last <td> element
        cy.get('td.mat-cell.cdk-column-delete button.mat-button').click();
        ;
    });
});
