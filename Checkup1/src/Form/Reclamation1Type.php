<?php

namespace App\Form;

use App\Controller\CategoryController;
use App\Entity\Category;
use App\Entity\Reclamation;
use phpDocumentor\Reflection\Types\String_;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\Extension\Core\Type\ChoiceType;
use Symfony\Component\Form\Extension\Core\Type\TextareaType;
use Symfony\Component\Form\Extension\Core\Type\TextType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;

class Reclamation1Type extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options): void
    {
        $builder
            ->add('object',TextType::class, [ 'attr'=>[ 'placeholder'=>"Saisir l'objet de reclamation"]])
            ->add('description',TextareaType::class,[ 'attr'=>[ 'placeholder'=>"Saisir Description"]])
            ->add('screenshot')
            ->add('category', ChoiceType::class , [
                'choices'  => [
                    'Bug' => 'Bug',
                    'Event' => 'Event',
                    'Other' => 'Other',
                ],
            ]);
        ;
    }

    public function configureOptions(OptionsResolver $resolver): void
    {
        $resolver->setDefaults([
            'data_class' => Reclamation::class,
        ]);
    }
}
