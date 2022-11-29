# -Channel-UNet
The fault detection method of the seismic image is based on semantic segmentation.
## introduce
Traditional fault detection requires manual interpretation, limited by inefficiency and subjectivity. Nowadays, deep learning methods have significantly improved segmentation tasks, but most of these methods were supported by multitudinous seismic data. However, the semantic segmentation method achieves better performance in insufficient data.Channel-UNet, a novel U-Net architecture, integrates the channel attention module to recalibrate feature weight adaptively. Simultaneously, you can synthesize a dataset containing apparent fault features and corresponding labels by this project. 

## Usage
/Obtain actual seismic data includes a platform for acquiring real seismic data;
/Synthetic seismic data generation platform represents the process of obtaining synthetic data sets;
/neural network represents includes the Channel-UNet dataset (train, validation, test) and the network code related to the experiment. Relevant prediction results can be viewed in the subfolder —— saved_predict

Most importantly, we can obtain the saved Channel-UNet model under the master branch(myChannelUnet_4_seg_21 and myChannelUnet_8_seg_21)，which can be used as a quick-test.

Hardware requirements: Intel(R) Core(TM) i5-10300 CPU and NVIDIA GeForce GTX 1650 GPU

Software required: PyTorch 1.1.0 and Python 3.6.5
