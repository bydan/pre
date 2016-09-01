/*
*AVISO LEGAL
© Copyright
*Este programa esta protegido por la ley de derechos de autor.
*La reproduccion o distribucion ilicita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y seran objeto de todas las sanciones legales que correspondan.

*Su contenido no puede copiarse para fines comerciales o de otras,
*ni puede mostrarse, incluso en una version modificada, en otros sitios Web.
Solo esta permitido colocar hipervinculos al sitio web.
*/
package com.bydan.erp.cartera.util.report;

import org.apache.log4j.Logger;
import java.sql.Time;
import java.sql.Timestamp;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.swing.border.Border;
import java.io.InputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;
//import java.util.ArrayList;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.GeneralEntityReturnGeneral;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.OrderBy;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.entity.Reporte;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;


import com.bydan.erp.cartera.util.report.CobrarEstadosCuentasPorFacturaConstantesFunciones;
import com.bydan.erp.cartera.util.report.CobrarEstadosCuentasPorFacturaParameterReturnGeneral;
//import com.bydan.erp.cartera.util.report.CobrarEstadosCuentasPorFacturaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class CobrarEstadosCuentasPorFacturaConstantesFunciones{		
	
	
	
	public static String S_TIPOREPORTE_EXTRA="";
	
	//USADO MAS EN RELACIONADO PARA MANTENIMIENTO MAESTRO-DETALLE
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOS=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOS;
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOS=Constantes.ISWING_TAMANIOMINIMO_TABLADATOS;
	
	//PARA TABLA RELACIONES(DESCRIPCION HEIGHTPE_REL_TAB)
	public static Integer ALTO_TABPANE_RELACIONES=Constantes.ISWING_ALTO_TABPANE + Funciones2.getValorProporcion(Constantes.ISWING_ALTO_TABPANE,0);
	
	//PARA TABLA RELACIONADO(DESCRIPTION HEIGHTPE_REL)
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL,0);		
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL,0);	
	
	//PARA CAMBIAR TODO--> SE CAMBIA EN TABLA RELACIONES Y TABLAS RELACIONADOS
	/*
	PARA MANEJAR EL TAB RELACIONES CON TABLA DE DATOS SE DEBE MODIFICAR Y VERIFICAR LOS VALORES CONTANTES:	
		final public static Integer ISWING_TAMANIOMAXIMO_TABLADATOSREL=240;//230;350;		
		final public static Integer ISWING_TAMANIOMINIMO_TABLADATOSREL=240;//230;260
		
		final public static Integer ISWING_ALTO_TABPANE=375;//375;400;260;
	CASO CONTRARIO, ESTOS VALORES SERIAN PARA CADA CASO (NO CONSTANTES)
	
	NOTA:
	* LA ALINEACION HORIZONTAL,FALTA
	*/
	
	
	public static final String SFINALQUERY="";	
	public static final String SNOMBREOPCION="CobrarEstadosCuentasPorFactura";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="CobrarEstadosCuentasPorFactura"+CobrarEstadosCuentasPorFacturaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CobrarEstadosCuentasPorFacturaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CobrarEstadosCuentasPorFacturaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CobrarEstadosCuentasPorFacturaConstantesFunciones.SCHEMA+"_"+CobrarEstadosCuentasPorFacturaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CobrarEstadosCuentasPorFacturaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CobrarEstadosCuentasPorFacturaConstantesFunciones.SCHEMA+"_"+CobrarEstadosCuentasPorFacturaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CobrarEstadosCuentasPorFacturaConstantesFunciones.SCHEMA+"_"+CobrarEstadosCuentasPorFacturaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CobrarEstadosCuentasPorFacturaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CobrarEstadosCuentasPorFacturaConstantesFunciones.SCHEMA+"_"+CobrarEstadosCuentasPorFacturaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobrarEstadosCuentasPorFacturaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CobrarEstadosCuentasPorFacturaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobrarEstadosCuentasPorFacturaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobrarEstadosCuentasPorFacturaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CobrarEstadosCuentasPorFacturaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobrarEstadosCuentasPorFacturaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CobrarEstadosCuentasPorFacturaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CobrarEstadosCuentasPorFacturaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CobrarEstadosCuentasPorFacturaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CobrarEstadosCuentasPorFacturaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Cobrar Estados Cuentas Por Facturas";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Cobrar Estados Cuentas Por Factura";
	public static final String SCLASSWEBTITULO_LOWER="Cobrar Estados Cuentas Por Factura";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="CobrarEstadosCuentasPorFactura";
	public static final String OBJECTNAME="cobrarestadoscuentasporfactura";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="cobrar_estados_cuentas_por_factura";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select cobrarestadoscuentasporfactura from "+CobrarEstadosCuentasPorFacturaConstantesFunciones.SPERSISTENCENAME+" cobrarestadoscuentasporfactura";
	public static String QUERYSELECTNATIVE="select "+CobrarEstadosCuentasPorFacturaConstantesFunciones.SCHEMA+"."+CobrarEstadosCuentasPorFacturaConstantesFunciones.TABLENAME+".id,"+CobrarEstadosCuentasPorFacturaConstantesFunciones.SCHEMA+"."+CobrarEstadosCuentasPorFacturaConstantesFunciones.TABLENAME+".version_row,"+CobrarEstadosCuentasPorFacturaConstantesFunciones.SCHEMA+"."+CobrarEstadosCuentasPorFacturaConstantesFunciones.TABLENAME+".id_empresa,"+CobrarEstadosCuentasPorFacturaConstantesFunciones.SCHEMA+"."+CobrarEstadosCuentasPorFacturaConstantesFunciones.TABLENAME+".fecha_emision_desde,"+CobrarEstadosCuentasPorFacturaConstantesFunciones.SCHEMA+"."+CobrarEstadosCuentasPorFacturaConstantesFunciones.TABLENAME+".fecha_emision_hasta,"+CobrarEstadosCuentasPorFacturaConstantesFunciones.SCHEMA+"."+CobrarEstadosCuentasPorFacturaConstantesFunciones.TABLENAME+".fecha_vence_desde,"+CobrarEstadosCuentasPorFacturaConstantesFunciones.SCHEMA+"."+CobrarEstadosCuentasPorFacturaConstantesFunciones.TABLENAME+".fecha_vence_hasta,"+CobrarEstadosCuentasPorFacturaConstantesFunciones.SCHEMA+"."+CobrarEstadosCuentasPorFacturaConstantesFunciones.TABLENAME+".nombre_cuenta_contable,"+CobrarEstadosCuentasPorFacturaConstantesFunciones.SCHEMA+"."+CobrarEstadosCuentasPorFacturaConstantesFunciones.TABLENAME+".nombre_ciudad,"+CobrarEstadosCuentasPorFacturaConstantesFunciones.SCHEMA+"."+CobrarEstadosCuentasPorFacturaConstantesFunciones.TABLENAME+".nombre_zona,"+CobrarEstadosCuentasPorFacturaConstantesFunciones.SCHEMA+"."+CobrarEstadosCuentasPorFacturaConstantesFunciones.TABLENAME+".nombre_completo,"+CobrarEstadosCuentasPorFacturaConstantesFunciones.SCHEMA+"."+CobrarEstadosCuentasPorFacturaConstantesFunciones.TABLENAME+".ruc,"+CobrarEstadosCuentasPorFacturaConstantesFunciones.SCHEMA+"."+CobrarEstadosCuentasPorFacturaConstantesFunciones.TABLENAME+".representante,"+CobrarEstadosCuentasPorFacturaConstantesFunciones.SCHEMA+"."+CobrarEstadosCuentasPorFacturaConstantesFunciones.TABLENAME+".dia_pago,"+CobrarEstadosCuentasPorFacturaConstantesFunciones.SCHEMA+"."+CobrarEstadosCuentasPorFacturaConstantesFunciones.TABLENAME+".hora_pago,"+CobrarEstadosCuentasPorFacturaConstantesFunciones.SCHEMA+"."+CobrarEstadosCuentasPorFacturaConstantesFunciones.TABLENAME+".observacion,"+CobrarEstadosCuentasPorFacturaConstantesFunciones.SCHEMA+"."+CobrarEstadosCuentasPorFacturaConstantesFunciones.TABLENAME+".nombre_transaccion,"+CobrarEstadosCuentasPorFacturaConstantesFunciones.SCHEMA+"."+CobrarEstadosCuentasPorFacturaConstantesFunciones.TABLENAME+".fecha_vence,"+CobrarEstadosCuentasPorFacturaConstantesFunciones.SCHEMA+"."+CobrarEstadosCuentasPorFacturaConstantesFunciones.TABLENAME+".fecha_emision,"+CobrarEstadosCuentasPorFacturaConstantesFunciones.SCHEMA+"."+CobrarEstadosCuentasPorFacturaConstantesFunciones.TABLENAME+".numero_comprobante,"+CobrarEstadosCuentasPorFacturaConstantesFunciones.SCHEMA+"."+CobrarEstadosCuentasPorFacturaConstantesFunciones.TABLENAME+".numero_factura,"+CobrarEstadosCuentasPorFacturaConstantesFunciones.SCHEMA+"."+CobrarEstadosCuentasPorFacturaConstantesFunciones.TABLENAME+".debito_mone_local,"+CobrarEstadosCuentasPorFacturaConstantesFunciones.SCHEMA+"."+CobrarEstadosCuentasPorFacturaConstantesFunciones.TABLENAME+".credito_mone_local,"+CobrarEstadosCuentasPorFacturaConstantesFunciones.SCHEMA+"."+CobrarEstadosCuentasPorFacturaConstantesFunciones.TABLENAME+".direccion_direccion,"+CobrarEstadosCuentasPorFacturaConstantesFunciones.SCHEMA+"."+CobrarEstadosCuentasPorFacturaConstantesFunciones.TABLENAME+".telefono_telefono from "+CobrarEstadosCuentasPorFacturaConstantesFunciones.SCHEMA+"."+CobrarEstadosCuentasPorFacturaConstantesFunciones.TABLENAME;//+" as "+CobrarEstadosCuentasPorFacturaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String FECHAEMISIONDESDE= "fecha_emision_desde";
    public static final String FECHAEMISIONHASTA= "fecha_emision_hasta";
    public static final String FECHAVENCEDESDE= "fecha_vence_desde";
    public static final String FECHAVENCEHASTA= "fecha_vence_hasta";
    public static final String NOMBRECUENTACONTABLE= "nombre_cuenta_contable";
    public static final String NOMBRECIUDAD= "nombre_ciudad";
    public static final String NOMBREZONA= "nombre_zona";
    public static final String NOMBRECOMPLETO= "nombre_completo";
    public static final String RUC= "ruc";
    public static final String REPRESENTANTE= "representante";
    public static final String DIAPAGO= "dia_pago";
    public static final String HORAPAGO= "hora_pago";
    public static final String OBSERVACION= "observacion";
    public static final String NOMBRETRANSACCION= "nombre_transaccion";
    public static final String FECHAVENCE= "fecha_vence";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String NUMEROCOMPROBANTE= "numero_comprobante";
    public static final String NUMEROFACTURA= "numero_factura";
    public static final String DEBITOMONELOCAL= "debito_mone_local";
    public static final String CREDITOMONELOCAL= "credito_mone_local";
    public static final String DIRECCIONDIRECCION= "direccion_direccion";
    public static final String TELEFONOTELEFONO= "telefono_telefono";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_FECHAEMISIONDESDE= "Fecha Emision Desde";
		public static final String LABEL_FECHAEMISIONDESDE_LOWER= "Fecha Emision Desde";
    	public static final String LABEL_FECHAEMISIONHASTA= "Fecha Emision Hasta";
		public static final String LABEL_FECHAEMISIONHASTA_LOWER= "Fecha Emision Hasta";
    	public static final String LABEL_FECHAVENCEDESDE= "Fecha Vence Desde";
		public static final String LABEL_FECHAVENCEDESDE_LOWER= "Fecha Vence Desde";
    	public static final String LABEL_FECHAVENCEHASTA= "Fecha Vence Hasta";
		public static final String LABEL_FECHAVENCEHASTA_LOWER= "Fecha Vence Hasta";
    	public static final String LABEL_NOMBRECUENTACONTABLE= "Nombre Cuenta Contable";
		public static final String LABEL_NOMBRECUENTACONTABLE_LOWER= "Nombre Cuenta Contable";
    	public static final String LABEL_NOMBRECIUDAD= "Nombre Ciudad";
		public static final String LABEL_NOMBRECIUDAD_LOWER= "Nombre Ciudad";
    	public static final String LABEL_NOMBREZONA= "Nombre Zona";
		public static final String LABEL_NOMBREZONA_LOWER= "Nombre Zona";
    	public static final String LABEL_NOMBRECOMPLETO= "Nombre Completo";
		public static final String LABEL_NOMBRECOMPLETO_LOWER= "Nombre Completo";
    	public static final String LABEL_RUC= "Ruc";
		public static final String LABEL_RUC_LOWER= "Ruc";
    	public static final String LABEL_REPRESENTANTE= "Representante";
		public static final String LABEL_REPRESENTANTE_LOWER= "Representante";
    	public static final String LABEL_DIAPAGO= "Dia Pago";
		public static final String LABEL_DIAPAGO_LOWER= "Dia Pago";
    	public static final String LABEL_HORAPAGO= "Hora Pago";
		public static final String LABEL_HORAPAGO_LOWER= "Hora Pago";
    	public static final String LABEL_OBSERVACION= "Observacion";
		public static final String LABEL_OBSERVACION_LOWER= "Observacion";
    	public static final String LABEL_NOMBRETRANSACCION= "Nombre Transaccion";
		public static final String LABEL_NOMBRETRANSACCION_LOWER= "Nombre Transaccion";
    	public static final String LABEL_FECHAVENCE= "Fecha Vence";
		public static final String LABEL_FECHAVENCE_LOWER= "Fecha Vence";
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
    	public static final String LABEL_NUMEROCOMPROBANTE= "Numero Comprobante";
		public static final String LABEL_NUMEROCOMPROBANTE_LOWER= "Numero Comprobante";
    	public static final String LABEL_NUMEROFACTURA= "Numero Factura";
		public static final String LABEL_NUMEROFACTURA_LOWER= "Numero Factura";
    	public static final String LABEL_DEBITOMONELOCAL= "Debito Mone Local";
		public static final String LABEL_DEBITOMONELOCAL_LOWER= "Debito Mone Local";
    	public static final String LABEL_CREDITOMONELOCAL= "Credito Mone Local";
		public static final String LABEL_CREDITOMONELOCAL_LOWER= "Credito Mone Local";
    	public static final String LABEL_DIRECCIONDIRECCION= "Direccion Direccion";
		public static final String LABEL_DIRECCIONDIRECCION_LOWER= "Direccion Direccion";
    	public static final String LABEL_TELEFONOTELEFONO= "Telefono Telefono";
		public static final String LABEL_TELEFONOTELEFONO_LOWER= "Telefono Telefono";
	
		
		
		
		
		
		
		
	public static final String SREGEXNOMBRE_CUENTA_CONTABLE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_CUENTA_CONTABLE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_CIUDAD=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_CIUDAD=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_ZONA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_ZONA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_COMPLETO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_COMPLETO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXRUC=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRUC=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXREPRESENTANTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXREPRESENTANTE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXOBSERVACION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXOBSERVACION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_TRANSACCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_TRANSACCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXNUMERO_COMPROBANTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_COMPROBANTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_FACTURA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_FACTURA=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXDIRECCION_DIRECCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDIRECCION_DIRECCION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXTELEFONO_TELEFONO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXTELEFONO_TELEFONO=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getCobrarEstadosCuentasPorFacturaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.IDEMPRESA)) {sLabelColumna=CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.FECHAEMISIONDESDE)) {sLabelColumna=CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_FECHAEMISIONDESDE;}
		if(sNombreColumna.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.FECHAEMISIONHASTA)) {sLabelColumna=CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_FECHAEMISIONHASTA;}
		if(sNombreColumna.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.FECHAVENCEDESDE)) {sLabelColumna=CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_FECHAVENCEDESDE;}
		if(sNombreColumna.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.FECHAVENCEHASTA)) {sLabelColumna=CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_FECHAVENCEHASTA;}
		if(sNombreColumna.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.NOMBRECUENTACONTABLE)) {sLabelColumna=CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_NOMBRECUENTACONTABLE;}
		if(sNombreColumna.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.NOMBRECIUDAD)) {sLabelColumna=CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_NOMBRECIUDAD;}
		if(sNombreColumna.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.NOMBREZONA)) {sLabelColumna=CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_NOMBREZONA;}
		if(sNombreColumna.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.NOMBRECOMPLETO)) {sLabelColumna=CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_NOMBRECOMPLETO;}
		if(sNombreColumna.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.RUC)) {sLabelColumna=CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_RUC;}
		if(sNombreColumna.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.REPRESENTANTE)) {sLabelColumna=CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_REPRESENTANTE;}
		if(sNombreColumna.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.DIAPAGO)) {sLabelColumna=CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_DIAPAGO;}
		if(sNombreColumna.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.HORAPAGO)) {sLabelColumna=CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_HORAPAGO;}
		if(sNombreColumna.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.OBSERVACION)) {sLabelColumna=CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_OBSERVACION;}
		if(sNombreColumna.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.NOMBRETRANSACCION)) {sLabelColumna=CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_NOMBRETRANSACCION;}
		if(sNombreColumna.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.FECHAVENCE)) {sLabelColumna=CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_FECHAVENCE;}
		if(sNombreColumna.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.FECHAEMISION)) {sLabelColumna=CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.NUMEROCOMPROBANTE)) {sLabelColumna=CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_NUMEROCOMPROBANTE;}
		if(sNombreColumna.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.NUMEROFACTURA)) {sLabelColumna=CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_NUMEROFACTURA;}
		if(sNombreColumna.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.DEBITOMONELOCAL)) {sLabelColumna=CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_DEBITOMONELOCAL;}
		if(sNombreColumna.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.CREDITOMONELOCAL)) {sLabelColumna=CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_CREDITOMONELOCAL;}
		if(sNombreColumna.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.DIRECCIONDIRECCION)) {sLabelColumna=CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_DIRECCIONDIRECCION;}
		if(sNombreColumna.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.TELEFONOTELEFONO)) {sLabelColumna=CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_TELEFONOTELEFONO;}
		
		if(sLabelColumna.equals("")) {
			sLabelColumna=sNombreColumna;	
		}
		return sLabelColumna;
	}
	
	
	
	public static String getNombreEjb_JBoss81(String sAplicacion,String sModule,String sClaseEjb,String sInterfaceEjb) throws Exception {
		String sDescripcion="";

		sDescripcion="ejb:"+sAplicacion+"/"+sModule+"/"+sClaseEjb+"!" + sInterfaceEjb;
		
		return sDescripcion;
	}
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getCobrarEstadosCuentasPorFacturaDescripcion(CobrarEstadosCuentasPorFactura cobrarestadoscuentasporfactura) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(cobrarestadoscuentasporfactura !=null/* && cobrarestadoscuentasporfactura.getId()!=0*/) {
			sDescripcion=cobrarestadoscuentasporfactura.getfecha_emision_hasta().toString();//cobrarestadoscuentasporfacturacobrarestadoscuentasporfactura.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getCobrarEstadosCuentasPorFacturaDescripcionDetallado(CobrarEstadosCuentasPorFactura cobrarestadoscuentasporfactura) {
		String sDescripcion="";
			
		sDescripcion+=CobrarEstadosCuentasPorFacturaConstantesFunciones.ID+"=";
		sDescripcion+=cobrarestadoscuentasporfactura.getId().toString()+",";
		sDescripcion+=CobrarEstadosCuentasPorFacturaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=cobrarestadoscuentasporfactura.getVersionRow().toString()+",";
		sDescripcion+=CobrarEstadosCuentasPorFacturaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=cobrarestadoscuentasporfactura.getid_empresa().toString()+",";
		sDescripcion+=CobrarEstadosCuentasPorFacturaConstantesFunciones.FECHAEMISIONDESDE+"=";
		sDescripcion+=cobrarestadoscuentasporfactura.getfecha_emision_desde().toString()+",";
		sDescripcion+=CobrarEstadosCuentasPorFacturaConstantesFunciones.FECHAEMISIONHASTA+"=";
		sDescripcion+=cobrarestadoscuentasporfactura.getfecha_emision_hasta().toString()+",";
		sDescripcion+=CobrarEstadosCuentasPorFacturaConstantesFunciones.FECHAVENCEDESDE+"=";
		sDescripcion+=cobrarestadoscuentasporfactura.getfecha_vence_desde().toString()+",";
		sDescripcion+=CobrarEstadosCuentasPorFacturaConstantesFunciones.FECHAVENCEHASTA+"=";
		sDescripcion+=cobrarestadoscuentasporfactura.getfecha_vence_hasta().toString()+",";
		sDescripcion+=CobrarEstadosCuentasPorFacturaConstantesFunciones.NOMBRECUENTACONTABLE+"=";
		sDescripcion+=cobrarestadoscuentasporfactura.getnombre_cuenta_contable()+",";
		sDescripcion+=CobrarEstadosCuentasPorFacturaConstantesFunciones.NOMBRECIUDAD+"=";
		sDescripcion+=cobrarestadoscuentasporfactura.getnombre_ciudad()+",";
		sDescripcion+=CobrarEstadosCuentasPorFacturaConstantesFunciones.NOMBREZONA+"=";
		sDescripcion+=cobrarestadoscuentasporfactura.getnombre_zona()+",";
		sDescripcion+=CobrarEstadosCuentasPorFacturaConstantesFunciones.NOMBRECOMPLETO+"=";
		sDescripcion+=cobrarestadoscuentasporfactura.getnombre_completo()+",";
		sDescripcion+=CobrarEstadosCuentasPorFacturaConstantesFunciones.RUC+"=";
		sDescripcion+=cobrarestadoscuentasporfactura.getruc()+",";
		sDescripcion+=CobrarEstadosCuentasPorFacturaConstantesFunciones.REPRESENTANTE+"=";
		sDescripcion+=cobrarestadoscuentasporfactura.getrepresentante()+",";
		sDescripcion+=CobrarEstadosCuentasPorFacturaConstantesFunciones.DIAPAGO+"=";
		sDescripcion+=cobrarestadoscuentasporfactura.getdia_pago().toString()+",";
		sDescripcion+=CobrarEstadosCuentasPorFacturaConstantesFunciones.HORAPAGO+"=";
		sDescripcion+=cobrarestadoscuentasporfactura.gethora_pago().toString()+",";
		sDescripcion+=CobrarEstadosCuentasPorFacturaConstantesFunciones.OBSERVACION+"=";
		sDescripcion+=cobrarestadoscuentasporfactura.getobservacion()+",";
		sDescripcion+=CobrarEstadosCuentasPorFacturaConstantesFunciones.NOMBRETRANSACCION+"=";
		sDescripcion+=cobrarestadoscuentasporfactura.getnombre_transaccion()+",";
		sDescripcion+=CobrarEstadosCuentasPorFacturaConstantesFunciones.FECHAVENCE+"=";
		sDescripcion+=cobrarestadoscuentasporfactura.getfecha_vence().toString()+",";
		sDescripcion+=CobrarEstadosCuentasPorFacturaConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=cobrarestadoscuentasporfactura.getfecha_emision().toString()+",";
		sDescripcion+=CobrarEstadosCuentasPorFacturaConstantesFunciones.NUMEROCOMPROBANTE+"=";
		sDescripcion+=cobrarestadoscuentasporfactura.getnumero_comprobante()+",";
		sDescripcion+=CobrarEstadosCuentasPorFacturaConstantesFunciones.NUMEROFACTURA+"=";
		sDescripcion+=cobrarestadoscuentasporfactura.getnumero_factura()+",";
		sDescripcion+=CobrarEstadosCuentasPorFacturaConstantesFunciones.DEBITOMONELOCAL+"=";
		sDescripcion+=cobrarestadoscuentasporfactura.getdebito_mone_local().toString()+",";
		sDescripcion+=CobrarEstadosCuentasPorFacturaConstantesFunciones.CREDITOMONELOCAL+"=";
		sDescripcion+=cobrarestadoscuentasporfactura.getcredito_mone_local().toString()+",";
		sDescripcion+=CobrarEstadosCuentasPorFacturaConstantesFunciones.DIRECCIONDIRECCION+"=";
		sDescripcion+=cobrarestadoscuentasporfactura.getdireccion_direccion()+",";
		sDescripcion+=CobrarEstadosCuentasPorFacturaConstantesFunciones.TELEFONOTELEFONO+"=";
		sDescripcion+=cobrarestadoscuentasporfactura.gettelefono_telefono()+",";
			
		return sDescripcion;
	}
	
	public static void setCobrarEstadosCuentasPorFacturaDescripcion(CobrarEstadosCuentasPorFactura cobrarestadoscuentasporfactura,String sValor) throws Exception {			
		if(cobrarestadoscuentasporfactura !=null) {
			//cobrarestadoscuentasporfacturacobrarestadoscuentasporfactura.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaCobrarEstadosCuentasPorFactura")) {
			sNombreIndice="Tipo=  Por Fecha Emision Desde Por Fecha Emision Hasta";
		} else if(sNombreIndice.equals("BusquedaCobrarEstadosCuentasPorFactura2")) {
			sNombreIndice="Tipo=  Por Fecha Vence Desde Por Fecha Vence Hasta";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaCobrarEstadosCuentasPorFactura(Date fecha_emision_desde,Date fecha_emision_hasta) {
		String sDetalleIndice=" Parametros->";
		if(fecha_emision_desde!=null) {sDetalleIndice+=" Fecha Emision Desde="+fecha_emision_desde.toString();}
		if(fecha_emision_hasta!=null) {sDetalleIndice+=" Fecha Emision Hasta="+fecha_emision_hasta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaCobrarEstadosCuentasPorFactura2(Date fecha_vence_desde,Date fecha_vence_hasta) {
		String sDetalleIndice=" Parametros->";
		if(fecha_vence_desde!=null) {sDetalleIndice+=" Fecha Vence Desde="+fecha_vence_desde.toString();}
		if(fecha_vence_hasta!=null) {sDetalleIndice+=" Fecha Vence Hasta="+fecha_vence_hasta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosCobrarEstadosCuentasPorFactura(CobrarEstadosCuentasPorFactura cobrarestadoscuentasporfactura,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		cobrarestadoscuentasporfactura.setnombre_cuenta_contable(cobrarestadoscuentasporfactura.getnombre_cuenta_contable().trim());
		cobrarestadoscuentasporfactura.setnombre_ciudad(cobrarestadoscuentasporfactura.getnombre_ciudad().trim());
		cobrarestadoscuentasporfactura.setnombre_zona(cobrarestadoscuentasporfactura.getnombre_zona().trim());
		cobrarestadoscuentasporfactura.setnombre_completo(cobrarestadoscuentasporfactura.getnombre_completo().trim());
		cobrarestadoscuentasporfactura.setruc(cobrarestadoscuentasporfactura.getruc().trim());
		cobrarestadoscuentasporfactura.setrepresentante(cobrarestadoscuentasporfactura.getrepresentante().trim());
		cobrarestadoscuentasporfactura.setobservacion(cobrarestadoscuentasporfactura.getobservacion().trim());
		cobrarestadoscuentasporfactura.setnombre_transaccion(cobrarestadoscuentasporfactura.getnombre_transaccion().trim());
		cobrarestadoscuentasporfactura.setnumero_comprobante(cobrarestadoscuentasporfactura.getnumero_comprobante().trim());
		cobrarestadoscuentasporfactura.setnumero_factura(cobrarestadoscuentasporfactura.getnumero_factura().trim());
		cobrarestadoscuentasporfactura.setdireccion_direccion(cobrarestadoscuentasporfactura.getdireccion_direccion().trim());
		cobrarestadoscuentasporfactura.settelefono_telefono(cobrarestadoscuentasporfactura.gettelefono_telefono().trim());
	}
	
	public static void quitarEspaciosCobrarEstadosCuentasPorFacturas(List<CobrarEstadosCuentasPorFactura> cobrarestadoscuentasporfacturas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CobrarEstadosCuentasPorFactura cobrarestadoscuentasporfactura: cobrarestadoscuentasporfacturas) {
			cobrarestadoscuentasporfactura.setnombre_cuenta_contable(cobrarestadoscuentasporfactura.getnombre_cuenta_contable().trim());
			cobrarestadoscuentasporfactura.setnombre_ciudad(cobrarestadoscuentasporfactura.getnombre_ciudad().trim());
			cobrarestadoscuentasporfactura.setnombre_zona(cobrarestadoscuentasporfactura.getnombre_zona().trim());
			cobrarestadoscuentasporfactura.setnombre_completo(cobrarestadoscuentasporfactura.getnombre_completo().trim());
			cobrarestadoscuentasporfactura.setruc(cobrarestadoscuentasporfactura.getruc().trim());
			cobrarestadoscuentasporfactura.setrepresentante(cobrarestadoscuentasporfactura.getrepresentante().trim());
			cobrarestadoscuentasporfactura.setobservacion(cobrarestadoscuentasporfactura.getobservacion().trim());
			cobrarestadoscuentasporfactura.setnombre_transaccion(cobrarestadoscuentasporfactura.getnombre_transaccion().trim());
			cobrarestadoscuentasporfactura.setnumero_comprobante(cobrarestadoscuentasporfactura.getnumero_comprobante().trim());
			cobrarestadoscuentasporfactura.setnumero_factura(cobrarestadoscuentasporfactura.getnumero_factura().trim());
			cobrarestadoscuentasporfactura.setdireccion_direccion(cobrarestadoscuentasporfactura.getdireccion_direccion().trim());
			cobrarestadoscuentasporfactura.settelefono_telefono(cobrarestadoscuentasporfactura.gettelefono_telefono().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCobrarEstadosCuentasPorFactura(CobrarEstadosCuentasPorFactura cobrarestadoscuentasporfactura,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && cobrarestadoscuentasporfactura.getConCambioAuxiliar()) {
			cobrarestadoscuentasporfactura.setIsDeleted(cobrarestadoscuentasporfactura.getIsDeletedAuxiliar());	
			cobrarestadoscuentasporfactura.setIsNew(cobrarestadoscuentasporfactura.getIsNewAuxiliar());	
			cobrarestadoscuentasporfactura.setIsChanged(cobrarestadoscuentasporfactura.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			cobrarestadoscuentasporfactura.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			cobrarestadoscuentasporfactura.setIsDeletedAuxiliar(false);	
			cobrarestadoscuentasporfactura.setIsNewAuxiliar(false);	
			cobrarestadoscuentasporfactura.setIsChangedAuxiliar(false);
			
			cobrarestadoscuentasporfactura.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCobrarEstadosCuentasPorFacturas(List<CobrarEstadosCuentasPorFactura> cobrarestadoscuentasporfacturas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(CobrarEstadosCuentasPorFactura cobrarestadoscuentasporfactura : cobrarestadoscuentasporfacturas) {
			if(conAsignarBase && cobrarestadoscuentasporfactura.getConCambioAuxiliar()) {
				cobrarestadoscuentasporfactura.setIsDeleted(cobrarestadoscuentasporfactura.getIsDeletedAuxiliar());	
				cobrarestadoscuentasporfactura.setIsNew(cobrarestadoscuentasporfactura.getIsNewAuxiliar());	
				cobrarestadoscuentasporfactura.setIsChanged(cobrarestadoscuentasporfactura.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				cobrarestadoscuentasporfactura.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				cobrarestadoscuentasporfactura.setIsDeletedAuxiliar(false);	
				cobrarestadoscuentasporfactura.setIsNewAuxiliar(false);	
				cobrarestadoscuentasporfactura.setIsChangedAuxiliar(false);
				
				cobrarestadoscuentasporfactura.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCobrarEstadosCuentasPorFactura(CobrarEstadosCuentasPorFactura cobrarestadoscuentasporfactura,Boolean conEnteros) throws Exception  {
		cobrarestadoscuentasporfactura.setdebito_mone_local(0.0);
		cobrarestadoscuentasporfactura.setcredito_mone_local(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			cobrarestadoscuentasporfactura.setdia_pago(0);
		}
	}		
	
	public static void InicializarValoresCobrarEstadosCuentasPorFacturas(List<CobrarEstadosCuentasPorFactura> cobrarestadoscuentasporfacturas,Boolean conEnteros) throws Exception  {
		
		for(CobrarEstadosCuentasPorFactura cobrarestadoscuentasporfactura: cobrarestadoscuentasporfacturas) {
			cobrarestadoscuentasporfactura.setdebito_mone_local(0.0);
			cobrarestadoscuentasporfactura.setcredito_mone_local(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				cobrarestadoscuentasporfactura.setdia_pago(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaCobrarEstadosCuentasPorFactura(List<CobrarEstadosCuentasPorFactura> cobrarestadoscuentasporfacturas,CobrarEstadosCuentasPorFactura cobrarestadoscuentasporfacturaAux) throws Exception  {
		CobrarEstadosCuentasPorFacturaConstantesFunciones.InicializarValoresCobrarEstadosCuentasPorFactura(cobrarestadoscuentasporfacturaAux,true);
		
		for(CobrarEstadosCuentasPorFactura cobrarestadoscuentasporfactura: cobrarestadoscuentasporfacturas) {
			if(cobrarestadoscuentasporfactura.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			cobrarestadoscuentasporfacturaAux.setdia_pago(cobrarestadoscuentasporfacturaAux.getdia_pago()+cobrarestadoscuentasporfactura.getdia_pago());			
			cobrarestadoscuentasporfacturaAux.setdebito_mone_local(cobrarestadoscuentasporfacturaAux.getdebito_mone_local()+cobrarestadoscuentasporfactura.getdebito_mone_local());			
			cobrarestadoscuentasporfacturaAux.setcredito_mone_local(cobrarestadoscuentasporfacturaAux.getcredito_mone_local()+cobrarestadoscuentasporfactura.getcredito_mone_local());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCobrarEstadosCuentasPorFactura(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CobrarEstadosCuentasPorFacturaConstantesFunciones.getArrayColumnasGlobalesCobrarEstadosCuentasPorFactura(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCobrarEstadosCuentasPorFactura(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CobrarEstadosCuentasPorFacturaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCobrarEstadosCuentasPorFactura(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CobrarEstadosCuentasPorFactura> cobrarestadoscuentasporfacturas,CobrarEstadosCuentasPorFactura cobrarestadoscuentasporfactura,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CobrarEstadosCuentasPorFactura cobrarestadoscuentasporfacturaAux: cobrarestadoscuentasporfacturas) {
			if(cobrarestadoscuentasporfacturaAux!=null && cobrarestadoscuentasporfactura!=null) {
				if((cobrarestadoscuentasporfacturaAux.getId()==null && cobrarestadoscuentasporfactura.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(cobrarestadoscuentasporfacturaAux.getId()!=null && cobrarestadoscuentasporfactura.getId()!=null){
					if(cobrarestadoscuentasporfacturaAux.getId().equals(cobrarestadoscuentasporfactura.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCobrarEstadosCuentasPorFactura(List<CobrarEstadosCuentasPorFactura> cobrarestadoscuentasporfacturas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double debito_mone_localTotal=0.0;
		Double credito_mone_localTotal=0.0;
	
		for(CobrarEstadosCuentasPorFactura cobrarestadoscuentasporfactura: cobrarestadoscuentasporfacturas) {			
			if(cobrarestadoscuentasporfactura.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			debito_mone_localTotal+=cobrarestadoscuentasporfactura.getdebito_mone_local();
			credito_mone_localTotal+=cobrarestadoscuentasporfactura.getcredito_mone_local();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CobrarEstadosCuentasPorFacturaConstantesFunciones.DEBITOMONELOCAL);
		datoGeneral.setsDescripcion(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_DEBITOMONELOCAL);
		datoGeneral.setdValorDouble(debito_mone_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CobrarEstadosCuentasPorFacturaConstantesFunciones.CREDITOMONELOCAL);
		datoGeneral.setsDescripcion(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_CREDITOMONELOCAL);
		datoGeneral.setdValorDouble(credito_mone_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCobrarEstadosCuentasPorFactura() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_ID, CobrarEstadosCuentasPorFacturaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_VERSIONROW, CobrarEstadosCuentasPorFacturaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_NOMBRECUENTACONTABLE, CobrarEstadosCuentasPorFacturaConstantesFunciones.NOMBRECUENTACONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_NOMBRECIUDAD, CobrarEstadosCuentasPorFacturaConstantesFunciones.NOMBRECIUDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_NOMBREZONA, CobrarEstadosCuentasPorFacturaConstantesFunciones.NOMBREZONA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_NOMBRECOMPLETO, CobrarEstadosCuentasPorFacturaConstantesFunciones.NOMBRECOMPLETO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_RUC, CobrarEstadosCuentasPorFacturaConstantesFunciones.RUC,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_REPRESENTANTE, CobrarEstadosCuentasPorFacturaConstantesFunciones.REPRESENTANTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_DIAPAGO, CobrarEstadosCuentasPorFacturaConstantesFunciones.DIAPAGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_HORAPAGO, CobrarEstadosCuentasPorFacturaConstantesFunciones.HORAPAGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_OBSERVACION, CobrarEstadosCuentasPorFacturaConstantesFunciones.OBSERVACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_NOMBRETRANSACCION, CobrarEstadosCuentasPorFacturaConstantesFunciones.NOMBRETRANSACCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_FECHAVENCE, CobrarEstadosCuentasPorFacturaConstantesFunciones.FECHAVENCE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_FECHAEMISION, CobrarEstadosCuentasPorFacturaConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_NUMEROCOMPROBANTE, CobrarEstadosCuentasPorFacturaConstantesFunciones.NUMEROCOMPROBANTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_NUMEROFACTURA, CobrarEstadosCuentasPorFacturaConstantesFunciones.NUMEROFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_DEBITOMONELOCAL, CobrarEstadosCuentasPorFacturaConstantesFunciones.DEBITOMONELOCAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_CREDITOMONELOCAL, CobrarEstadosCuentasPorFacturaConstantesFunciones.CREDITOMONELOCAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_DIRECCIONDIRECCION, CobrarEstadosCuentasPorFacturaConstantesFunciones.DIRECCIONDIRECCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_TELEFONOTELEFONO, CobrarEstadosCuentasPorFacturaConstantesFunciones.TELEFONOTELEFONO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCobrarEstadosCuentasPorFactura() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CobrarEstadosCuentasPorFacturaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarEstadosCuentasPorFacturaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarEstadosCuentasPorFacturaConstantesFunciones.NOMBRECUENTACONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarEstadosCuentasPorFacturaConstantesFunciones.NOMBRECIUDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarEstadosCuentasPorFacturaConstantesFunciones.NOMBREZONA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarEstadosCuentasPorFacturaConstantesFunciones.NOMBRECOMPLETO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarEstadosCuentasPorFacturaConstantesFunciones.RUC;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarEstadosCuentasPorFacturaConstantesFunciones.REPRESENTANTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarEstadosCuentasPorFacturaConstantesFunciones.DIAPAGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarEstadosCuentasPorFacturaConstantesFunciones.HORAPAGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarEstadosCuentasPorFacturaConstantesFunciones.OBSERVACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarEstadosCuentasPorFacturaConstantesFunciones.NOMBRETRANSACCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarEstadosCuentasPorFacturaConstantesFunciones.FECHAVENCE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarEstadosCuentasPorFacturaConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarEstadosCuentasPorFacturaConstantesFunciones.NUMEROCOMPROBANTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarEstadosCuentasPorFacturaConstantesFunciones.NUMEROFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarEstadosCuentasPorFacturaConstantesFunciones.DEBITOMONELOCAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarEstadosCuentasPorFacturaConstantesFunciones.CREDITOMONELOCAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarEstadosCuentasPorFacturaConstantesFunciones.DIRECCIONDIRECCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarEstadosCuentasPorFacturaConstantesFunciones.TELEFONOTELEFONO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCobrarEstadosCuentasPorFactura() throws Exception  {
		return CobrarEstadosCuentasPorFacturaConstantesFunciones.getTiposSeleccionarCobrarEstadosCuentasPorFactura(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCobrarEstadosCuentasPorFactura(Boolean conFk) throws Exception  {
		return CobrarEstadosCuentasPorFacturaConstantesFunciones.getTiposSeleccionarCobrarEstadosCuentasPorFactura(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCobrarEstadosCuentasPorFactura(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_FECHAEMISIONDESDE);
			reporte.setsDescripcion(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_FECHAEMISIONDESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_FECHAEMISIONHASTA);
			reporte.setsDescripcion(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_FECHAEMISIONHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_FECHAVENCEDESDE);
			reporte.setsDescripcion(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_FECHAVENCEDESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_FECHAVENCEHASTA);
			reporte.setsDescripcion(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_FECHAVENCEHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_NOMBRECUENTACONTABLE);
			reporte.setsDescripcion(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_NOMBRECUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_NOMBRECIUDAD);
			reporte.setsDescripcion(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_NOMBRECIUDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_NOMBREZONA);
			reporte.setsDescripcion(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_NOMBREZONA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_NOMBRECOMPLETO);
			reporte.setsDescripcion(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_NOMBRECOMPLETO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_RUC);
			reporte.setsDescripcion(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_RUC);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_REPRESENTANTE);
			reporte.setsDescripcion(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_REPRESENTANTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_DIAPAGO);
			reporte.setsDescripcion(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_DIAPAGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		reporte=new Reporte();
		reporte.setsCodigo(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_HORAPAGO);
		reporte.setsDescripcion(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_HORAPAGO);

		arrTiposSeleccionarTodos.add(reporte);
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_OBSERVACION);
			reporte.setsDescripcion(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_OBSERVACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_NOMBRETRANSACCION);
			reporte.setsDescripcion(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_NOMBRETRANSACCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_FECHAVENCE);
			reporte.setsDescripcion(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_FECHAVENCE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_NUMEROCOMPROBANTE);
			reporte.setsDescripcion(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_NUMEROCOMPROBANTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_NUMEROFACTURA);
			reporte.setsDescripcion(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_NUMEROFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_DEBITOMONELOCAL);
			reporte.setsDescripcion(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_DEBITOMONELOCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_CREDITOMONELOCAL);
			reporte.setsDescripcion(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_CREDITOMONELOCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_DIRECCIONDIRECCION);
			reporte.setsDescripcion(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_DIRECCIONDIRECCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_TELEFONOTELEFONO);
			reporte.setsDescripcion(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_TELEFONOTELEFONO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCobrarEstadosCuentasPorFactura(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCobrarEstadosCuentasPorFactura(CobrarEstadosCuentasPorFactura cobrarestadoscuentasporfacturaAux) throws Exception {
		
			cobrarestadoscuentasporfacturaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cobrarestadoscuentasporfacturaAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesCobrarEstadosCuentasPorFactura(List<CobrarEstadosCuentasPorFactura> cobrarestadoscuentasporfacturasTemp) throws Exception {
		for(CobrarEstadosCuentasPorFactura cobrarestadoscuentasporfacturaAux:cobrarestadoscuentasporfacturasTemp) {
			
			cobrarestadoscuentasporfacturaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cobrarestadoscuentasporfacturaAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCobrarEstadosCuentasPorFactura(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCobrarEstadosCuentasPorFactura(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCobrarEstadosCuentasPorFactura(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CobrarEstadosCuentasPorFacturaConstantesFunciones.getClassesRelationshipsOfCobrarEstadosCuentasPorFactura(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCobrarEstadosCuentasPorFactura(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCobrarEstadosCuentasPorFactura(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CobrarEstadosCuentasPorFacturaConstantesFunciones.getClassesRelationshipsFromStringsOfCobrarEstadosCuentasPorFactura(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCobrarEstadosCuentasPorFactura(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}		
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(CobrarEstadosCuentasPorFactura cobrarestadoscuentasporfactura,List<CobrarEstadosCuentasPorFactura> cobrarestadoscuentasporfacturas,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(CobrarEstadosCuentasPorFactura cobrarestadoscuentasporfactura,List<CobrarEstadosCuentasPorFactura> cobrarestadoscuentasporfacturas) throws Exception {
		try	{			
			for(CobrarEstadosCuentasPorFactura cobrarestadoscuentasporfacturaLocal:cobrarestadoscuentasporfacturas) {
				if(cobrarestadoscuentasporfacturaLocal.getId().equals(cobrarestadoscuentasporfactura.getId())) {
					cobrarestadoscuentasporfacturaLocal.setIsSelected(cobrarestadoscuentasporfactura.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCobrarEstadosCuentasPorFactura(List<CobrarEstadosCuentasPorFactura> cobrarestadoscuentasporfacturasAux) throws Exception {
		//this.cobrarestadoscuentasporfacturasAux=cobrarestadoscuentasporfacturasAux;
		
		for(CobrarEstadosCuentasPorFactura cobrarestadoscuentasporfacturaAux:cobrarestadoscuentasporfacturasAux) {
			if(cobrarestadoscuentasporfacturaAux.getIsChanged()) {
				cobrarestadoscuentasporfacturaAux.setIsChanged(false);
			}		
			
			if(cobrarestadoscuentasporfacturaAux.getIsNew()) {
				cobrarestadoscuentasporfacturaAux.setIsNew(false);
			}	
			
			if(cobrarestadoscuentasporfacturaAux.getIsDeleted()) {
				cobrarestadoscuentasporfacturaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCobrarEstadosCuentasPorFactura(CobrarEstadosCuentasPorFactura cobrarestadoscuentasporfacturaAux) throws Exception {
		//this.cobrarestadoscuentasporfacturaAux=cobrarestadoscuentasporfacturaAux;
		
			if(cobrarestadoscuentasporfacturaAux.getIsChanged()) {
				cobrarestadoscuentasporfacturaAux.setIsChanged(false);
			}		
			
			if(cobrarestadoscuentasporfacturaAux.getIsNew()) {
				cobrarestadoscuentasporfacturaAux.setIsNew(false);
			}	
			
			if(cobrarestadoscuentasporfacturaAux.getIsDeleted()) {
				cobrarestadoscuentasporfacturaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(CobrarEstadosCuentasPorFactura cobrarestadoscuentasporfacturaAsignar,CobrarEstadosCuentasPorFactura cobrarestadoscuentasporfactura) throws Exception {
		cobrarestadoscuentasporfacturaAsignar.setId(cobrarestadoscuentasporfactura.getId());	
		cobrarestadoscuentasporfacturaAsignar.setVersionRow(cobrarestadoscuentasporfactura.getVersionRow());	
		cobrarestadoscuentasporfacturaAsignar.setnombre_cuenta_contable(cobrarestadoscuentasporfactura.getnombre_cuenta_contable());	
		cobrarestadoscuentasporfacturaAsignar.setnombre_ciudad(cobrarestadoscuentasporfactura.getnombre_ciudad());	
		cobrarestadoscuentasporfacturaAsignar.setnombre_zona(cobrarestadoscuentasporfactura.getnombre_zona());	
		cobrarestadoscuentasporfacturaAsignar.setnombre_completo(cobrarestadoscuentasporfactura.getnombre_completo());	
		cobrarestadoscuentasporfacturaAsignar.setruc(cobrarestadoscuentasporfactura.getruc());	
		cobrarestadoscuentasporfacturaAsignar.setrepresentante(cobrarestadoscuentasporfactura.getrepresentante());	
		cobrarestadoscuentasporfacturaAsignar.setdia_pago(cobrarestadoscuentasporfactura.getdia_pago());	
		cobrarestadoscuentasporfacturaAsignar.sethora_pago(cobrarestadoscuentasporfactura.gethora_pago());	
		cobrarestadoscuentasporfacturaAsignar.setobservacion(cobrarestadoscuentasporfactura.getobservacion());	
		cobrarestadoscuentasporfacturaAsignar.setnombre_transaccion(cobrarestadoscuentasporfactura.getnombre_transaccion());	
		cobrarestadoscuentasporfacturaAsignar.setfecha_vence(cobrarestadoscuentasporfactura.getfecha_vence());	
		cobrarestadoscuentasporfacturaAsignar.setfecha_emision(cobrarestadoscuentasporfactura.getfecha_emision());	
		cobrarestadoscuentasporfacturaAsignar.setnumero_comprobante(cobrarestadoscuentasporfactura.getnumero_comprobante());	
		cobrarestadoscuentasporfacturaAsignar.setnumero_factura(cobrarestadoscuentasporfactura.getnumero_factura());	
		cobrarestadoscuentasporfacturaAsignar.setdebito_mone_local(cobrarestadoscuentasporfactura.getdebito_mone_local());	
		cobrarestadoscuentasporfacturaAsignar.setcredito_mone_local(cobrarestadoscuentasporfactura.getcredito_mone_local());	
		cobrarestadoscuentasporfacturaAsignar.setdireccion_direccion(cobrarestadoscuentasporfactura.getdireccion_direccion());	
		cobrarestadoscuentasporfacturaAsignar.settelefono_telefono(cobrarestadoscuentasporfactura.gettelefono_telefono());	
	}
	
	public static void inicializarCobrarEstadosCuentasPorFactura(CobrarEstadosCuentasPorFactura cobrarestadoscuentasporfactura) throws Exception {
		try {
				cobrarestadoscuentasporfactura.setId(0L);	
					
				cobrarestadoscuentasporfactura.setnombre_cuenta_contable("");	
				cobrarestadoscuentasporfactura.setnombre_ciudad("");	
				cobrarestadoscuentasporfactura.setnombre_zona("");	
				cobrarestadoscuentasporfactura.setnombre_completo("");	
				cobrarestadoscuentasporfactura.setruc("");	
				cobrarestadoscuentasporfactura.setrepresentante("");	
				cobrarestadoscuentasporfactura.setdia_pago(0);	
				cobrarestadoscuentasporfactura.sethora_pago(new Time((new Date()).getTime()));	
				cobrarestadoscuentasporfactura.setobservacion("");	
				cobrarestadoscuentasporfactura.setnombre_transaccion("");	
				cobrarestadoscuentasporfactura.setfecha_vence(new Date());	
				cobrarestadoscuentasporfactura.setfecha_emision(new Date());	
				cobrarestadoscuentasporfactura.setnumero_comprobante("");	
				cobrarestadoscuentasporfactura.setnumero_factura("");	
				cobrarestadoscuentasporfactura.setdebito_mone_local(0.0);	
				cobrarestadoscuentasporfactura.setcredito_mone_local(0.0);	
				cobrarestadoscuentasporfactura.setdireccion_direccion("");	
				cobrarestadoscuentasporfactura.settelefono_telefono("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCobrarEstadosCuentasPorFactura(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_FECHAEMISIONDESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_FECHAEMISIONHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_FECHAVENCEDESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_FECHAVENCEHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_NOMBRECUENTACONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_NOMBRECIUDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_NOMBREZONA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_NOMBRECOMPLETO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_RUC);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_REPRESENTANTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_DIAPAGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_HORAPAGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_OBSERVACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_NOMBRETRANSACCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_FECHAVENCE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_NUMEROCOMPROBANTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_NUMEROFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_DEBITOMONELOCAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_CREDITOMONELOCAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_DIRECCIONDIRECCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarEstadosCuentasPorFacturaConstantesFunciones.LABEL_TELEFONOTELEFONO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCobrarEstadosCuentasPorFactura(String sTipo,Row row,Workbook workbook,CobrarEstadosCuentasPorFactura cobrarestadoscuentasporfactura,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarestadoscuentasporfactura.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarestadoscuentasporfactura.getfecha_emision_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarestadoscuentasporfactura.getfecha_emision_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarestadoscuentasporfactura.getfecha_vence_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarestadoscuentasporfactura.getfecha_vence_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarestadoscuentasporfactura.getnombre_cuenta_contable());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarestadoscuentasporfactura.getnombre_ciudad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarestadoscuentasporfactura.getnombre_zona());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarestadoscuentasporfactura.getnombre_completo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarestadoscuentasporfactura.getruc());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarestadoscuentasporfactura.getrepresentante());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarestadoscuentasporfactura.getdia_pago());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarestadoscuentasporfactura.gethora_pago());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarestadoscuentasporfactura.getobservacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarestadoscuentasporfactura.getnombre_transaccion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarestadoscuentasporfactura.getfecha_vence());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarestadoscuentasporfactura.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarestadoscuentasporfactura.getnumero_comprobante());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarestadoscuentasporfactura.getnumero_factura());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarestadoscuentasporfactura.getdebito_mone_local());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarestadoscuentasporfactura.getcredito_mone_local());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarestadoscuentasporfactura.getdireccion_direccion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarestadoscuentasporfactura.gettelefono_telefono());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCobrarEstadosCuentasPorFactura="";
	
	public String getsFinalQueryCobrarEstadosCuentasPorFactura() {
		return this.sFinalQueryCobrarEstadosCuentasPorFactura;
	}
	
	public void setsFinalQueryCobrarEstadosCuentasPorFactura(String sFinalQueryCobrarEstadosCuentasPorFactura) {
		this.sFinalQueryCobrarEstadosCuentasPorFactura= sFinalQueryCobrarEstadosCuentasPorFactura;
	}
	
	public Border resaltarSeleccionarCobrarEstadosCuentasPorFactura=null;
	
	public Border setResaltarSeleccionarCobrarEstadosCuentasPorFactura(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarEstadosCuentasPorFacturaBeanSwingJInternalFrame cobrarestadoscuentasporfacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//cobrarestadoscuentasporfacturaBeanSwingJInternalFrame.jTtoolBarCobrarEstadosCuentasPorFactura.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCobrarEstadosCuentasPorFactura= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCobrarEstadosCuentasPorFactura() {
		return this.resaltarSeleccionarCobrarEstadosCuentasPorFactura;
	}
	
	public void setResaltarSeleccionarCobrarEstadosCuentasPorFactura(Border borderResaltarSeleccionarCobrarEstadosCuentasPorFactura) {
		this.resaltarSeleccionarCobrarEstadosCuentasPorFactura= borderResaltarSeleccionarCobrarEstadosCuentasPorFactura;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCobrarEstadosCuentasPorFactura=null;
	public Boolean mostraridCobrarEstadosCuentasPorFactura=true;
	public Boolean activaridCobrarEstadosCuentasPorFactura=true;

	public Border resaltarid_empresaCobrarEstadosCuentasPorFactura=null;
	public Boolean mostrarid_empresaCobrarEstadosCuentasPorFactura=true;
	public Boolean activarid_empresaCobrarEstadosCuentasPorFactura=true;
	public Boolean cargarid_empresaCobrarEstadosCuentasPorFactura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaCobrarEstadosCuentasPorFactura=false;//ConEventDepend=true

	public Border resaltarfecha_emision_desdeCobrarEstadosCuentasPorFactura=null;
	public Boolean mostrarfecha_emision_desdeCobrarEstadosCuentasPorFactura=true;
	public Boolean activarfecha_emision_desdeCobrarEstadosCuentasPorFactura=true;

	public Border resaltarfecha_emision_hastaCobrarEstadosCuentasPorFactura=null;
	public Boolean mostrarfecha_emision_hastaCobrarEstadosCuentasPorFactura=true;
	public Boolean activarfecha_emision_hastaCobrarEstadosCuentasPorFactura=true;

	public Border resaltarfecha_vence_desdeCobrarEstadosCuentasPorFactura=null;
	public Boolean mostrarfecha_vence_desdeCobrarEstadosCuentasPorFactura=true;
	public Boolean activarfecha_vence_desdeCobrarEstadosCuentasPorFactura=true;

	public Border resaltarfecha_vence_hastaCobrarEstadosCuentasPorFactura=null;
	public Boolean mostrarfecha_vence_hastaCobrarEstadosCuentasPorFactura=true;
	public Boolean activarfecha_vence_hastaCobrarEstadosCuentasPorFactura=true;

	public Border resaltarnombre_cuenta_contableCobrarEstadosCuentasPorFactura=null;
	public Boolean mostrarnombre_cuenta_contableCobrarEstadosCuentasPorFactura=true;
	public Boolean activarnombre_cuenta_contableCobrarEstadosCuentasPorFactura=true;

	public Border resaltarnombre_ciudadCobrarEstadosCuentasPorFactura=null;
	public Boolean mostrarnombre_ciudadCobrarEstadosCuentasPorFactura=true;
	public Boolean activarnombre_ciudadCobrarEstadosCuentasPorFactura=true;

	public Border resaltarnombre_zonaCobrarEstadosCuentasPorFactura=null;
	public Boolean mostrarnombre_zonaCobrarEstadosCuentasPorFactura=true;
	public Boolean activarnombre_zonaCobrarEstadosCuentasPorFactura=true;

	public Border resaltarnombre_completoCobrarEstadosCuentasPorFactura=null;
	public Boolean mostrarnombre_completoCobrarEstadosCuentasPorFactura=true;
	public Boolean activarnombre_completoCobrarEstadosCuentasPorFactura=true;

	public Border resaltarrucCobrarEstadosCuentasPorFactura=null;
	public Boolean mostrarrucCobrarEstadosCuentasPorFactura=true;
	public Boolean activarrucCobrarEstadosCuentasPorFactura=true;

	public Border resaltarrepresentanteCobrarEstadosCuentasPorFactura=null;
	public Boolean mostrarrepresentanteCobrarEstadosCuentasPorFactura=true;
	public Boolean activarrepresentanteCobrarEstadosCuentasPorFactura=true;

	public Border resaltardia_pagoCobrarEstadosCuentasPorFactura=null;
	public Boolean mostrardia_pagoCobrarEstadosCuentasPorFactura=true;
	public Boolean activardia_pagoCobrarEstadosCuentasPorFactura=true;

	public Border resaltarhora_pagoCobrarEstadosCuentasPorFactura=null;
	public Boolean mostrarhora_pagoCobrarEstadosCuentasPorFactura=true;
	public Boolean activarhora_pagoCobrarEstadosCuentasPorFactura=true;

	public Border resaltarobservacionCobrarEstadosCuentasPorFactura=null;
	public Boolean mostrarobservacionCobrarEstadosCuentasPorFactura=true;
	public Boolean activarobservacionCobrarEstadosCuentasPorFactura=true;

	public Border resaltarnombre_transaccionCobrarEstadosCuentasPorFactura=null;
	public Boolean mostrarnombre_transaccionCobrarEstadosCuentasPorFactura=true;
	public Boolean activarnombre_transaccionCobrarEstadosCuentasPorFactura=true;

	public Border resaltarfecha_venceCobrarEstadosCuentasPorFactura=null;
	public Boolean mostrarfecha_venceCobrarEstadosCuentasPorFactura=true;
	public Boolean activarfecha_venceCobrarEstadosCuentasPorFactura=true;

	public Border resaltarfecha_emisionCobrarEstadosCuentasPorFactura=null;
	public Boolean mostrarfecha_emisionCobrarEstadosCuentasPorFactura=true;
	public Boolean activarfecha_emisionCobrarEstadosCuentasPorFactura=true;

	public Border resaltarnumero_comprobanteCobrarEstadosCuentasPorFactura=null;
	public Boolean mostrarnumero_comprobanteCobrarEstadosCuentasPorFactura=true;
	public Boolean activarnumero_comprobanteCobrarEstadosCuentasPorFactura=true;

	public Border resaltarnumero_facturaCobrarEstadosCuentasPorFactura=null;
	public Boolean mostrarnumero_facturaCobrarEstadosCuentasPorFactura=true;
	public Boolean activarnumero_facturaCobrarEstadosCuentasPorFactura=true;

	public Border resaltardebito_mone_localCobrarEstadosCuentasPorFactura=null;
	public Boolean mostrardebito_mone_localCobrarEstadosCuentasPorFactura=true;
	public Boolean activardebito_mone_localCobrarEstadosCuentasPorFactura=true;

	public Border resaltarcredito_mone_localCobrarEstadosCuentasPorFactura=null;
	public Boolean mostrarcredito_mone_localCobrarEstadosCuentasPorFactura=true;
	public Boolean activarcredito_mone_localCobrarEstadosCuentasPorFactura=true;

	public Border resaltardireccion_direccionCobrarEstadosCuentasPorFactura=null;
	public Boolean mostrardireccion_direccionCobrarEstadosCuentasPorFactura=true;
	public Boolean activardireccion_direccionCobrarEstadosCuentasPorFactura=true;

	public Border resaltartelefono_telefonoCobrarEstadosCuentasPorFactura=null;
	public Boolean mostrartelefono_telefonoCobrarEstadosCuentasPorFactura=true;
	public Boolean activartelefono_telefonoCobrarEstadosCuentasPorFactura=true;

	
	

	public Border setResaltaridCobrarEstadosCuentasPorFactura(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarEstadosCuentasPorFacturaBeanSwingJInternalFrame cobrarestadoscuentasporfacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarestadoscuentasporfacturaBeanSwingJInternalFrame.jTtoolBarCobrarEstadosCuentasPorFactura.setBorder(borderResaltar);
		
		this.resaltaridCobrarEstadosCuentasPorFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCobrarEstadosCuentasPorFactura() {
		return this.resaltaridCobrarEstadosCuentasPorFactura;
	}

	public void setResaltaridCobrarEstadosCuentasPorFactura(Border borderResaltar) {
		this.resaltaridCobrarEstadosCuentasPorFactura= borderResaltar;
	}

	public Boolean getMostraridCobrarEstadosCuentasPorFactura() {
		return this.mostraridCobrarEstadosCuentasPorFactura;
	}

	public void setMostraridCobrarEstadosCuentasPorFactura(Boolean mostraridCobrarEstadosCuentasPorFactura) {
		this.mostraridCobrarEstadosCuentasPorFactura= mostraridCobrarEstadosCuentasPorFactura;
	}

	public Boolean getActivaridCobrarEstadosCuentasPorFactura() {
		return this.activaridCobrarEstadosCuentasPorFactura;
	}

	public void setActivaridCobrarEstadosCuentasPorFactura(Boolean activaridCobrarEstadosCuentasPorFactura) {
		this.activaridCobrarEstadosCuentasPorFactura= activaridCobrarEstadosCuentasPorFactura;
	}

	public Border setResaltarid_empresaCobrarEstadosCuentasPorFactura(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarEstadosCuentasPorFacturaBeanSwingJInternalFrame cobrarestadoscuentasporfacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarestadoscuentasporfacturaBeanSwingJInternalFrame.jTtoolBarCobrarEstadosCuentasPorFactura.setBorder(borderResaltar);
		
		this.resaltarid_empresaCobrarEstadosCuentasPorFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaCobrarEstadosCuentasPorFactura() {
		return this.resaltarid_empresaCobrarEstadosCuentasPorFactura;
	}

	public void setResaltarid_empresaCobrarEstadosCuentasPorFactura(Border borderResaltar) {
		this.resaltarid_empresaCobrarEstadosCuentasPorFactura= borderResaltar;
	}

	public Boolean getMostrarid_empresaCobrarEstadosCuentasPorFactura() {
		return this.mostrarid_empresaCobrarEstadosCuentasPorFactura;
	}

	public void setMostrarid_empresaCobrarEstadosCuentasPorFactura(Boolean mostrarid_empresaCobrarEstadosCuentasPorFactura) {
		this.mostrarid_empresaCobrarEstadosCuentasPorFactura= mostrarid_empresaCobrarEstadosCuentasPorFactura;
	}

	public Boolean getActivarid_empresaCobrarEstadosCuentasPorFactura() {
		return this.activarid_empresaCobrarEstadosCuentasPorFactura;
	}

	public void setActivarid_empresaCobrarEstadosCuentasPorFactura(Boolean activarid_empresaCobrarEstadosCuentasPorFactura) {
		this.activarid_empresaCobrarEstadosCuentasPorFactura= activarid_empresaCobrarEstadosCuentasPorFactura;
	}

	public Boolean getCargarid_empresaCobrarEstadosCuentasPorFactura() {
		return this.cargarid_empresaCobrarEstadosCuentasPorFactura;
	}

	public void setCargarid_empresaCobrarEstadosCuentasPorFactura(Boolean cargarid_empresaCobrarEstadosCuentasPorFactura) {
		this.cargarid_empresaCobrarEstadosCuentasPorFactura= cargarid_empresaCobrarEstadosCuentasPorFactura;
	}

	public Border setResaltarfecha_emision_desdeCobrarEstadosCuentasPorFactura(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarEstadosCuentasPorFacturaBeanSwingJInternalFrame cobrarestadoscuentasporfacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarestadoscuentasporfacturaBeanSwingJInternalFrame.jTtoolBarCobrarEstadosCuentasPorFactura.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_desdeCobrarEstadosCuentasPorFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_desdeCobrarEstadosCuentasPorFactura() {
		return this.resaltarfecha_emision_desdeCobrarEstadosCuentasPorFactura;
	}

	public void setResaltarfecha_emision_desdeCobrarEstadosCuentasPorFactura(Border borderResaltar) {
		this.resaltarfecha_emision_desdeCobrarEstadosCuentasPorFactura= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_desdeCobrarEstadosCuentasPorFactura() {
		return this.mostrarfecha_emision_desdeCobrarEstadosCuentasPorFactura;
	}

	public void setMostrarfecha_emision_desdeCobrarEstadosCuentasPorFactura(Boolean mostrarfecha_emision_desdeCobrarEstadosCuentasPorFactura) {
		this.mostrarfecha_emision_desdeCobrarEstadosCuentasPorFactura= mostrarfecha_emision_desdeCobrarEstadosCuentasPorFactura;
	}

	public Boolean getActivarfecha_emision_desdeCobrarEstadosCuentasPorFactura() {
		return this.activarfecha_emision_desdeCobrarEstadosCuentasPorFactura;
	}

	public void setActivarfecha_emision_desdeCobrarEstadosCuentasPorFactura(Boolean activarfecha_emision_desdeCobrarEstadosCuentasPorFactura) {
		this.activarfecha_emision_desdeCobrarEstadosCuentasPorFactura= activarfecha_emision_desdeCobrarEstadosCuentasPorFactura;
	}

	public Border setResaltarfecha_emision_hastaCobrarEstadosCuentasPorFactura(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarEstadosCuentasPorFacturaBeanSwingJInternalFrame cobrarestadoscuentasporfacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarestadoscuentasporfacturaBeanSwingJInternalFrame.jTtoolBarCobrarEstadosCuentasPorFactura.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_hastaCobrarEstadosCuentasPorFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_hastaCobrarEstadosCuentasPorFactura() {
		return this.resaltarfecha_emision_hastaCobrarEstadosCuentasPorFactura;
	}

	public void setResaltarfecha_emision_hastaCobrarEstadosCuentasPorFactura(Border borderResaltar) {
		this.resaltarfecha_emision_hastaCobrarEstadosCuentasPorFactura= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_hastaCobrarEstadosCuentasPorFactura() {
		return this.mostrarfecha_emision_hastaCobrarEstadosCuentasPorFactura;
	}

	public void setMostrarfecha_emision_hastaCobrarEstadosCuentasPorFactura(Boolean mostrarfecha_emision_hastaCobrarEstadosCuentasPorFactura) {
		this.mostrarfecha_emision_hastaCobrarEstadosCuentasPorFactura= mostrarfecha_emision_hastaCobrarEstadosCuentasPorFactura;
	}

	public Boolean getActivarfecha_emision_hastaCobrarEstadosCuentasPorFactura() {
		return this.activarfecha_emision_hastaCobrarEstadosCuentasPorFactura;
	}

	public void setActivarfecha_emision_hastaCobrarEstadosCuentasPorFactura(Boolean activarfecha_emision_hastaCobrarEstadosCuentasPorFactura) {
		this.activarfecha_emision_hastaCobrarEstadosCuentasPorFactura= activarfecha_emision_hastaCobrarEstadosCuentasPorFactura;
	}

	public Border setResaltarfecha_vence_desdeCobrarEstadosCuentasPorFactura(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarEstadosCuentasPorFacturaBeanSwingJInternalFrame cobrarestadoscuentasporfacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarestadoscuentasporfacturaBeanSwingJInternalFrame.jTtoolBarCobrarEstadosCuentasPorFactura.setBorder(borderResaltar);
		
		this.resaltarfecha_vence_desdeCobrarEstadosCuentasPorFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_vence_desdeCobrarEstadosCuentasPorFactura() {
		return this.resaltarfecha_vence_desdeCobrarEstadosCuentasPorFactura;
	}

	public void setResaltarfecha_vence_desdeCobrarEstadosCuentasPorFactura(Border borderResaltar) {
		this.resaltarfecha_vence_desdeCobrarEstadosCuentasPorFactura= borderResaltar;
	}

	public Boolean getMostrarfecha_vence_desdeCobrarEstadosCuentasPorFactura() {
		return this.mostrarfecha_vence_desdeCobrarEstadosCuentasPorFactura;
	}

	public void setMostrarfecha_vence_desdeCobrarEstadosCuentasPorFactura(Boolean mostrarfecha_vence_desdeCobrarEstadosCuentasPorFactura) {
		this.mostrarfecha_vence_desdeCobrarEstadosCuentasPorFactura= mostrarfecha_vence_desdeCobrarEstadosCuentasPorFactura;
	}

	public Boolean getActivarfecha_vence_desdeCobrarEstadosCuentasPorFactura() {
		return this.activarfecha_vence_desdeCobrarEstadosCuentasPorFactura;
	}

	public void setActivarfecha_vence_desdeCobrarEstadosCuentasPorFactura(Boolean activarfecha_vence_desdeCobrarEstadosCuentasPorFactura) {
		this.activarfecha_vence_desdeCobrarEstadosCuentasPorFactura= activarfecha_vence_desdeCobrarEstadosCuentasPorFactura;
	}

	public Border setResaltarfecha_vence_hastaCobrarEstadosCuentasPorFactura(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarEstadosCuentasPorFacturaBeanSwingJInternalFrame cobrarestadoscuentasporfacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarestadoscuentasporfacturaBeanSwingJInternalFrame.jTtoolBarCobrarEstadosCuentasPorFactura.setBorder(borderResaltar);
		
		this.resaltarfecha_vence_hastaCobrarEstadosCuentasPorFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_vence_hastaCobrarEstadosCuentasPorFactura() {
		return this.resaltarfecha_vence_hastaCobrarEstadosCuentasPorFactura;
	}

	public void setResaltarfecha_vence_hastaCobrarEstadosCuentasPorFactura(Border borderResaltar) {
		this.resaltarfecha_vence_hastaCobrarEstadosCuentasPorFactura= borderResaltar;
	}

	public Boolean getMostrarfecha_vence_hastaCobrarEstadosCuentasPorFactura() {
		return this.mostrarfecha_vence_hastaCobrarEstadosCuentasPorFactura;
	}

	public void setMostrarfecha_vence_hastaCobrarEstadosCuentasPorFactura(Boolean mostrarfecha_vence_hastaCobrarEstadosCuentasPorFactura) {
		this.mostrarfecha_vence_hastaCobrarEstadosCuentasPorFactura= mostrarfecha_vence_hastaCobrarEstadosCuentasPorFactura;
	}

	public Boolean getActivarfecha_vence_hastaCobrarEstadosCuentasPorFactura() {
		return this.activarfecha_vence_hastaCobrarEstadosCuentasPorFactura;
	}

	public void setActivarfecha_vence_hastaCobrarEstadosCuentasPorFactura(Boolean activarfecha_vence_hastaCobrarEstadosCuentasPorFactura) {
		this.activarfecha_vence_hastaCobrarEstadosCuentasPorFactura= activarfecha_vence_hastaCobrarEstadosCuentasPorFactura;
	}

	public Border setResaltarnombre_cuenta_contableCobrarEstadosCuentasPorFactura(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarEstadosCuentasPorFacturaBeanSwingJInternalFrame cobrarestadoscuentasporfacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarestadoscuentasporfacturaBeanSwingJInternalFrame.jTtoolBarCobrarEstadosCuentasPorFactura.setBorder(borderResaltar);
		
		this.resaltarnombre_cuenta_contableCobrarEstadosCuentasPorFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_cuenta_contableCobrarEstadosCuentasPorFactura() {
		return this.resaltarnombre_cuenta_contableCobrarEstadosCuentasPorFactura;
	}

	public void setResaltarnombre_cuenta_contableCobrarEstadosCuentasPorFactura(Border borderResaltar) {
		this.resaltarnombre_cuenta_contableCobrarEstadosCuentasPorFactura= borderResaltar;
	}

	public Boolean getMostrarnombre_cuenta_contableCobrarEstadosCuentasPorFactura() {
		return this.mostrarnombre_cuenta_contableCobrarEstadosCuentasPorFactura;
	}

	public void setMostrarnombre_cuenta_contableCobrarEstadosCuentasPorFactura(Boolean mostrarnombre_cuenta_contableCobrarEstadosCuentasPorFactura) {
		this.mostrarnombre_cuenta_contableCobrarEstadosCuentasPorFactura= mostrarnombre_cuenta_contableCobrarEstadosCuentasPorFactura;
	}

	public Boolean getActivarnombre_cuenta_contableCobrarEstadosCuentasPorFactura() {
		return this.activarnombre_cuenta_contableCobrarEstadosCuentasPorFactura;
	}

	public void setActivarnombre_cuenta_contableCobrarEstadosCuentasPorFactura(Boolean activarnombre_cuenta_contableCobrarEstadosCuentasPorFactura) {
		this.activarnombre_cuenta_contableCobrarEstadosCuentasPorFactura= activarnombre_cuenta_contableCobrarEstadosCuentasPorFactura;
	}

	public Border setResaltarnombre_ciudadCobrarEstadosCuentasPorFactura(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarEstadosCuentasPorFacturaBeanSwingJInternalFrame cobrarestadoscuentasporfacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarestadoscuentasporfacturaBeanSwingJInternalFrame.jTtoolBarCobrarEstadosCuentasPorFactura.setBorder(borderResaltar);
		
		this.resaltarnombre_ciudadCobrarEstadosCuentasPorFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_ciudadCobrarEstadosCuentasPorFactura() {
		return this.resaltarnombre_ciudadCobrarEstadosCuentasPorFactura;
	}

	public void setResaltarnombre_ciudadCobrarEstadosCuentasPorFactura(Border borderResaltar) {
		this.resaltarnombre_ciudadCobrarEstadosCuentasPorFactura= borderResaltar;
	}

	public Boolean getMostrarnombre_ciudadCobrarEstadosCuentasPorFactura() {
		return this.mostrarnombre_ciudadCobrarEstadosCuentasPorFactura;
	}

	public void setMostrarnombre_ciudadCobrarEstadosCuentasPorFactura(Boolean mostrarnombre_ciudadCobrarEstadosCuentasPorFactura) {
		this.mostrarnombre_ciudadCobrarEstadosCuentasPorFactura= mostrarnombre_ciudadCobrarEstadosCuentasPorFactura;
	}

	public Boolean getActivarnombre_ciudadCobrarEstadosCuentasPorFactura() {
		return this.activarnombre_ciudadCobrarEstadosCuentasPorFactura;
	}

	public void setActivarnombre_ciudadCobrarEstadosCuentasPorFactura(Boolean activarnombre_ciudadCobrarEstadosCuentasPorFactura) {
		this.activarnombre_ciudadCobrarEstadosCuentasPorFactura= activarnombre_ciudadCobrarEstadosCuentasPorFactura;
	}

	public Border setResaltarnombre_zonaCobrarEstadosCuentasPorFactura(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarEstadosCuentasPorFacturaBeanSwingJInternalFrame cobrarestadoscuentasporfacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarestadoscuentasporfacturaBeanSwingJInternalFrame.jTtoolBarCobrarEstadosCuentasPorFactura.setBorder(borderResaltar);
		
		this.resaltarnombre_zonaCobrarEstadosCuentasPorFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_zonaCobrarEstadosCuentasPorFactura() {
		return this.resaltarnombre_zonaCobrarEstadosCuentasPorFactura;
	}

	public void setResaltarnombre_zonaCobrarEstadosCuentasPorFactura(Border borderResaltar) {
		this.resaltarnombre_zonaCobrarEstadosCuentasPorFactura= borderResaltar;
	}

	public Boolean getMostrarnombre_zonaCobrarEstadosCuentasPorFactura() {
		return this.mostrarnombre_zonaCobrarEstadosCuentasPorFactura;
	}

	public void setMostrarnombre_zonaCobrarEstadosCuentasPorFactura(Boolean mostrarnombre_zonaCobrarEstadosCuentasPorFactura) {
		this.mostrarnombre_zonaCobrarEstadosCuentasPorFactura= mostrarnombre_zonaCobrarEstadosCuentasPorFactura;
	}

	public Boolean getActivarnombre_zonaCobrarEstadosCuentasPorFactura() {
		return this.activarnombre_zonaCobrarEstadosCuentasPorFactura;
	}

	public void setActivarnombre_zonaCobrarEstadosCuentasPorFactura(Boolean activarnombre_zonaCobrarEstadosCuentasPorFactura) {
		this.activarnombre_zonaCobrarEstadosCuentasPorFactura= activarnombre_zonaCobrarEstadosCuentasPorFactura;
	}

	public Border setResaltarnombre_completoCobrarEstadosCuentasPorFactura(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarEstadosCuentasPorFacturaBeanSwingJInternalFrame cobrarestadoscuentasporfacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarestadoscuentasporfacturaBeanSwingJInternalFrame.jTtoolBarCobrarEstadosCuentasPorFactura.setBorder(borderResaltar);
		
		this.resaltarnombre_completoCobrarEstadosCuentasPorFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_completoCobrarEstadosCuentasPorFactura() {
		return this.resaltarnombre_completoCobrarEstadosCuentasPorFactura;
	}

	public void setResaltarnombre_completoCobrarEstadosCuentasPorFactura(Border borderResaltar) {
		this.resaltarnombre_completoCobrarEstadosCuentasPorFactura= borderResaltar;
	}

	public Boolean getMostrarnombre_completoCobrarEstadosCuentasPorFactura() {
		return this.mostrarnombre_completoCobrarEstadosCuentasPorFactura;
	}

	public void setMostrarnombre_completoCobrarEstadosCuentasPorFactura(Boolean mostrarnombre_completoCobrarEstadosCuentasPorFactura) {
		this.mostrarnombre_completoCobrarEstadosCuentasPorFactura= mostrarnombre_completoCobrarEstadosCuentasPorFactura;
	}

	public Boolean getActivarnombre_completoCobrarEstadosCuentasPorFactura() {
		return this.activarnombre_completoCobrarEstadosCuentasPorFactura;
	}

	public void setActivarnombre_completoCobrarEstadosCuentasPorFactura(Boolean activarnombre_completoCobrarEstadosCuentasPorFactura) {
		this.activarnombre_completoCobrarEstadosCuentasPorFactura= activarnombre_completoCobrarEstadosCuentasPorFactura;
	}

	public Border setResaltarrucCobrarEstadosCuentasPorFactura(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarEstadosCuentasPorFacturaBeanSwingJInternalFrame cobrarestadoscuentasporfacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarestadoscuentasporfacturaBeanSwingJInternalFrame.jTtoolBarCobrarEstadosCuentasPorFactura.setBorder(borderResaltar);
		
		this.resaltarrucCobrarEstadosCuentasPorFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarrucCobrarEstadosCuentasPorFactura() {
		return this.resaltarrucCobrarEstadosCuentasPorFactura;
	}

	public void setResaltarrucCobrarEstadosCuentasPorFactura(Border borderResaltar) {
		this.resaltarrucCobrarEstadosCuentasPorFactura= borderResaltar;
	}

	public Boolean getMostrarrucCobrarEstadosCuentasPorFactura() {
		return this.mostrarrucCobrarEstadosCuentasPorFactura;
	}

	public void setMostrarrucCobrarEstadosCuentasPorFactura(Boolean mostrarrucCobrarEstadosCuentasPorFactura) {
		this.mostrarrucCobrarEstadosCuentasPorFactura= mostrarrucCobrarEstadosCuentasPorFactura;
	}

	public Boolean getActivarrucCobrarEstadosCuentasPorFactura() {
		return this.activarrucCobrarEstadosCuentasPorFactura;
	}

	public void setActivarrucCobrarEstadosCuentasPorFactura(Boolean activarrucCobrarEstadosCuentasPorFactura) {
		this.activarrucCobrarEstadosCuentasPorFactura= activarrucCobrarEstadosCuentasPorFactura;
	}

	public Border setResaltarrepresentanteCobrarEstadosCuentasPorFactura(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarEstadosCuentasPorFacturaBeanSwingJInternalFrame cobrarestadoscuentasporfacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarestadoscuentasporfacturaBeanSwingJInternalFrame.jTtoolBarCobrarEstadosCuentasPorFactura.setBorder(borderResaltar);
		
		this.resaltarrepresentanteCobrarEstadosCuentasPorFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarrepresentanteCobrarEstadosCuentasPorFactura() {
		return this.resaltarrepresentanteCobrarEstadosCuentasPorFactura;
	}

	public void setResaltarrepresentanteCobrarEstadosCuentasPorFactura(Border borderResaltar) {
		this.resaltarrepresentanteCobrarEstadosCuentasPorFactura= borderResaltar;
	}

	public Boolean getMostrarrepresentanteCobrarEstadosCuentasPorFactura() {
		return this.mostrarrepresentanteCobrarEstadosCuentasPorFactura;
	}

	public void setMostrarrepresentanteCobrarEstadosCuentasPorFactura(Boolean mostrarrepresentanteCobrarEstadosCuentasPorFactura) {
		this.mostrarrepresentanteCobrarEstadosCuentasPorFactura= mostrarrepresentanteCobrarEstadosCuentasPorFactura;
	}

	public Boolean getActivarrepresentanteCobrarEstadosCuentasPorFactura() {
		return this.activarrepresentanteCobrarEstadosCuentasPorFactura;
	}

	public void setActivarrepresentanteCobrarEstadosCuentasPorFactura(Boolean activarrepresentanteCobrarEstadosCuentasPorFactura) {
		this.activarrepresentanteCobrarEstadosCuentasPorFactura= activarrepresentanteCobrarEstadosCuentasPorFactura;
	}

	public Border setResaltardia_pagoCobrarEstadosCuentasPorFactura(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarEstadosCuentasPorFacturaBeanSwingJInternalFrame cobrarestadoscuentasporfacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarestadoscuentasporfacturaBeanSwingJInternalFrame.jTtoolBarCobrarEstadosCuentasPorFactura.setBorder(borderResaltar);
		
		this.resaltardia_pagoCobrarEstadosCuentasPorFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardia_pagoCobrarEstadosCuentasPorFactura() {
		return this.resaltardia_pagoCobrarEstadosCuentasPorFactura;
	}

	public void setResaltardia_pagoCobrarEstadosCuentasPorFactura(Border borderResaltar) {
		this.resaltardia_pagoCobrarEstadosCuentasPorFactura= borderResaltar;
	}

	public Boolean getMostrardia_pagoCobrarEstadosCuentasPorFactura() {
		return this.mostrardia_pagoCobrarEstadosCuentasPorFactura;
	}

	public void setMostrardia_pagoCobrarEstadosCuentasPorFactura(Boolean mostrardia_pagoCobrarEstadosCuentasPorFactura) {
		this.mostrardia_pagoCobrarEstadosCuentasPorFactura= mostrardia_pagoCobrarEstadosCuentasPorFactura;
	}

	public Boolean getActivardia_pagoCobrarEstadosCuentasPorFactura() {
		return this.activardia_pagoCobrarEstadosCuentasPorFactura;
	}

	public void setActivardia_pagoCobrarEstadosCuentasPorFactura(Boolean activardia_pagoCobrarEstadosCuentasPorFactura) {
		this.activardia_pagoCobrarEstadosCuentasPorFactura= activardia_pagoCobrarEstadosCuentasPorFactura;
	}

	public Border setResaltarhora_pagoCobrarEstadosCuentasPorFactura(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarEstadosCuentasPorFacturaBeanSwingJInternalFrame cobrarestadoscuentasporfacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarestadoscuentasporfacturaBeanSwingJInternalFrame.jTtoolBarCobrarEstadosCuentasPorFactura.setBorder(borderResaltar);
		
		this.resaltarhora_pagoCobrarEstadosCuentasPorFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhora_pagoCobrarEstadosCuentasPorFactura() {
		return this.resaltarhora_pagoCobrarEstadosCuentasPorFactura;
	}

	public void setResaltarhora_pagoCobrarEstadosCuentasPorFactura(Border borderResaltar) {
		this.resaltarhora_pagoCobrarEstadosCuentasPorFactura= borderResaltar;
	}

	public Boolean getMostrarhora_pagoCobrarEstadosCuentasPorFactura() {
		return this.mostrarhora_pagoCobrarEstadosCuentasPorFactura;
	}

	public void setMostrarhora_pagoCobrarEstadosCuentasPorFactura(Boolean mostrarhora_pagoCobrarEstadosCuentasPorFactura) {
		this.mostrarhora_pagoCobrarEstadosCuentasPorFactura= mostrarhora_pagoCobrarEstadosCuentasPorFactura;
	}

	public Boolean getActivarhora_pagoCobrarEstadosCuentasPorFactura() {
		return this.activarhora_pagoCobrarEstadosCuentasPorFactura;
	}

	public void setActivarhora_pagoCobrarEstadosCuentasPorFactura(Boolean activarhora_pagoCobrarEstadosCuentasPorFactura) {
		this.activarhora_pagoCobrarEstadosCuentasPorFactura= activarhora_pagoCobrarEstadosCuentasPorFactura;
	}

	public Border setResaltarobservacionCobrarEstadosCuentasPorFactura(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarEstadosCuentasPorFacturaBeanSwingJInternalFrame cobrarestadoscuentasporfacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarestadoscuentasporfacturaBeanSwingJInternalFrame.jTtoolBarCobrarEstadosCuentasPorFactura.setBorder(borderResaltar);
		
		this.resaltarobservacionCobrarEstadosCuentasPorFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarobservacionCobrarEstadosCuentasPorFactura() {
		return this.resaltarobservacionCobrarEstadosCuentasPorFactura;
	}

	public void setResaltarobservacionCobrarEstadosCuentasPorFactura(Border borderResaltar) {
		this.resaltarobservacionCobrarEstadosCuentasPorFactura= borderResaltar;
	}

	public Boolean getMostrarobservacionCobrarEstadosCuentasPorFactura() {
		return this.mostrarobservacionCobrarEstadosCuentasPorFactura;
	}

	public void setMostrarobservacionCobrarEstadosCuentasPorFactura(Boolean mostrarobservacionCobrarEstadosCuentasPorFactura) {
		this.mostrarobservacionCobrarEstadosCuentasPorFactura= mostrarobservacionCobrarEstadosCuentasPorFactura;
	}

	public Boolean getActivarobservacionCobrarEstadosCuentasPorFactura() {
		return this.activarobservacionCobrarEstadosCuentasPorFactura;
	}

	public void setActivarobservacionCobrarEstadosCuentasPorFactura(Boolean activarobservacionCobrarEstadosCuentasPorFactura) {
		this.activarobservacionCobrarEstadosCuentasPorFactura= activarobservacionCobrarEstadosCuentasPorFactura;
	}

	public Border setResaltarnombre_transaccionCobrarEstadosCuentasPorFactura(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarEstadosCuentasPorFacturaBeanSwingJInternalFrame cobrarestadoscuentasporfacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarestadoscuentasporfacturaBeanSwingJInternalFrame.jTtoolBarCobrarEstadosCuentasPorFactura.setBorder(borderResaltar);
		
		this.resaltarnombre_transaccionCobrarEstadosCuentasPorFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_transaccionCobrarEstadosCuentasPorFactura() {
		return this.resaltarnombre_transaccionCobrarEstadosCuentasPorFactura;
	}

	public void setResaltarnombre_transaccionCobrarEstadosCuentasPorFactura(Border borderResaltar) {
		this.resaltarnombre_transaccionCobrarEstadosCuentasPorFactura= borderResaltar;
	}

	public Boolean getMostrarnombre_transaccionCobrarEstadosCuentasPorFactura() {
		return this.mostrarnombre_transaccionCobrarEstadosCuentasPorFactura;
	}

	public void setMostrarnombre_transaccionCobrarEstadosCuentasPorFactura(Boolean mostrarnombre_transaccionCobrarEstadosCuentasPorFactura) {
		this.mostrarnombre_transaccionCobrarEstadosCuentasPorFactura= mostrarnombre_transaccionCobrarEstadosCuentasPorFactura;
	}

	public Boolean getActivarnombre_transaccionCobrarEstadosCuentasPorFactura() {
		return this.activarnombre_transaccionCobrarEstadosCuentasPorFactura;
	}

	public void setActivarnombre_transaccionCobrarEstadosCuentasPorFactura(Boolean activarnombre_transaccionCobrarEstadosCuentasPorFactura) {
		this.activarnombre_transaccionCobrarEstadosCuentasPorFactura= activarnombre_transaccionCobrarEstadosCuentasPorFactura;
	}

	public Border setResaltarfecha_venceCobrarEstadosCuentasPorFactura(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarEstadosCuentasPorFacturaBeanSwingJInternalFrame cobrarestadoscuentasporfacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarestadoscuentasporfacturaBeanSwingJInternalFrame.jTtoolBarCobrarEstadosCuentasPorFactura.setBorder(borderResaltar);
		
		this.resaltarfecha_venceCobrarEstadosCuentasPorFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_venceCobrarEstadosCuentasPorFactura() {
		return this.resaltarfecha_venceCobrarEstadosCuentasPorFactura;
	}

	public void setResaltarfecha_venceCobrarEstadosCuentasPorFactura(Border borderResaltar) {
		this.resaltarfecha_venceCobrarEstadosCuentasPorFactura= borderResaltar;
	}

	public Boolean getMostrarfecha_venceCobrarEstadosCuentasPorFactura() {
		return this.mostrarfecha_venceCobrarEstadosCuentasPorFactura;
	}

	public void setMostrarfecha_venceCobrarEstadosCuentasPorFactura(Boolean mostrarfecha_venceCobrarEstadosCuentasPorFactura) {
		this.mostrarfecha_venceCobrarEstadosCuentasPorFactura= mostrarfecha_venceCobrarEstadosCuentasPorFactura;
	}

	public Boolean getActivarfecha_venceCobrarEstadosCuentasPorFactura() {
		return this.activarfecha_venceCobrarEstadosCuentasPorFactura;
	}

	public void setActivarfecha_venceCobrarEstadosCuentasPorFactura(Boolean activarfecha_venceCobrarEstadosCuentasPorFactura) {
		this.activarfecha_venceCobrarEstadosCuentasPorFactura= activarfecha_venceCobrarEstadosCuentasPorFactura;
	}

	public Border setResaltarfecha_emisionCobrarEstadosCuentasPorFactura(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarEstadosCuentasPorFacturaBeanSwingJInternalFrame cobrarestadoscuentasporfacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarestadoscuentasporfacturaBeanSwingJInternalFrame.jTtoolBarCobrarEstadosCuentasPorFactura.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionCobrarEstadosCuentasPorFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionCobrarEstadosCuentasPorFactura() {
		return this.resaltarfecha_emisionCobrarEstadosCuentasPorFactura;
	}

	public void setResaltarfecha_emisionCobrarEstadosCuentasPorFactura(Border borderResaltar) {
		this.resaltarfecha_emisionCobrarEstadosCuentasPorFactura= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionCobrarEstadosCuentasPorFactura() {
		return this.mostrarfecha_emisionCobrarEstadosCuentasPorFactura;
	}

	public void setMostrarfecha_emisionCobrarEstadosCuentasPorFactura(Boolean mostrarfecha_emisionCobrarEstadosCuentasPorFactura) {
		this.mostrarfecha_emisionCobrarEstadosCuentasPorFactura= mostrarfecha_emisionCobrarEstadosCuentasPorFactura;
	}

	public Boolean getActivarfecha_emisionCobrarEstadosCuentasPorFactura() {
		return this.activarfecha_emisionCobrarEstadosCuentasPorFactura;
	}

	public void setActivarfecha_emisionCobrarEstadosCuentasPorFactura(Boolean activarfecha_emisionCobrarEstadosCuentasPorFactura) {
		this.activarfecha_emisionCobrarEstadosCuentasPorFactura= activarfecha_emisionCobrarEstadosCuentasPorFactura;
	}

	public Border setResaltarnumero_comprobanteCobrarEstadosCuentasPorFactura(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarEstadosCuentasPorFacturaBeanSwingJInternalFrame cobrarestadoscuentasporfacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarestadoscuentasporfacturaBeanSwingJInternalFrame.jTtoolBarCobrarEstadosCuentasPorFactura.setBorder(borderResaltar);
		
		this.resaltarnumero_comprobanteCobrarEstadosCuentasPorFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_comprobanteCobrarEstadosCuentasPorFactura() {
		return this.resaltarnumero_comprobanteCobrarEstadosCuentasPorFactura;
	}

	public void setResaltarnumero_comprobanteCobrarEstadosCuentasPorFactura(Border borderResaltar) {
		this.resaltarnumero_comprobanteCobrarEstadosCuentasPorFactura= borderResaltar;
	}

	public Boolean getMostrarnumero_comprobanteCobrarEstadosCuentasPorFactura() {
		return this.mostrarnumero_comprobanteCobrarEstadosCuentasPorFactura;
	}

	public void setMostrarnumero_comprobanteCobrarEstadosCuentasPorFactura(Boolean mostrarnumero_comprobanteCobrarEstadosCuentasPorFactura) {
		this.mostrarnumero_comprobanteCobrarEstadosCuentasPorFactura= mostrarnumero_comprobanteCobrarEstadosCuentasPorFactura;
	}

	public Boolean getActivarnumero_comprobanteCobrarEstadosCuentasPorFactura() {
		return this.activarnumero_comprobanteCobrarEstadosCuentasPorFactura;
	}

	public void setActivarnumero_comprobanteCobrarEstadosCuentasPorFactura(Boolean activarnumero_comprobanteCobrarEstadosCuentasPorFactura) {
		this.activarnumero_comprobanteCobrarEstadosCuentasPorFactura= activarnumero_comprobanteCobrarEstadosCuentasPorFactura;
	}

	public Border setResaltarnumero_facturaCobrarEstadosCuentasPorFactura(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarEstadosCuentasPorFacturaBeanSwingJInternalFrame cobrarestadoscuentasporfacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarestadoscuentasporfacturaBeanSwingJInternalFrame.jTtoolBarCobrarEstadosCuentasPorFactura.setBorder(borderResaltar);
		
		this.resaltarnumero_facturaCobrarEstadosCuentasPorFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_facturaCobrarEstadosCuentasPorFactura() {
		return this.resaltarnumero_facturaCobrarEstadosCuentasPorFactura;
	}

	public void setResaltarnumero_facturaCobrarEstadosCuentasPorFactura(Border borderResaltar) {
		this.resaltarnumero_facturaCobrarEstadosCuentasPorFactura= borderResaltar;
	}

	public Boolean getMostrarnumero_facturaCobrarEstadosCuentasPorFactura() {
		return this.mostrarnumero_facturaCobrarEstadosCuentasPorFactura;
	}

	public void setMostrarnumero_facturaCobrarEstadosCuentasPorFactura(Boolean mostrarnumero_facturaCobrarEstadosCuentasPorFactura) {
		this.mostrarnumero_facturaCobrarEstadosCuentasPorFactura= mostrarnumero_facturaCobrarEstadosCuentasPorFactura;
	}

	public Boolean getActivarnumero_facturaCobrarEstadosCuentasPorFactura() {
		return this.activarnumero_facturaCobrarEstadosCuentasPorFactura;
	}

	public void setActivarnumero_facturaCobrarEstadosCuentasPorFactura(Boolean activarnumero_facturaCobrarEstadosCuentasPorFactura) {
		this.activarnumero_facturaCobrarEstadosCuentasPorFactura= activarnumero_facturaCobrarEstadosCuentasPorFactura;
	}

	public Border setResaltardebito_mone_localCobrarEstadosCuentasPorFactura(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarEstadosCuentasPorFacturaBeanSwingJInternalFrame cobrarestadoscuentasporfacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarestadoscuentasporfacturaBeanSwingJInternalFrame.jTtoolBarCobrarEstadosCuentasPorFactura.setBorder(borderResaltar);
		
		this.resaltardebito_mone_localCobrarEstadosCuentasPorFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardebito_mone_localCobrarEstadosCuentasPorFactura() {
		return this.resaltardebito_mone_localCobrarEstadosCuentasPorFactura;
	}

	public void setResaltardebito_mone_localCobrarEstadosCuentasPorFactura(Border borderResaltar) {
		this.resaltardebito_mone_localCobrarEstadosCuentasPorFactura= borderResaltar;
	}

	public Boolean getMostrardebito_mone_localCobrarEstadosCuentasPorFactura() {
		return this.mostrardebito_mone_localCobrarEstadosCuentasPorFactura;
	}

	public void setMostrardebito_mone_localCobrarEstadosCuentasPorFactura(Boolean mostrardebito_mone_localCobrarEstadosCuentasPorFactura) {
		this.mostrardebito_mone_localCobrarEstadosCuentasPorFactura= mostrardebito_mone_localCobrarEstadosCuentasPorFactura;
	}

	public Boolean getActivardebito_mone_localCobrarEstadosCuentasPorFactura() {
		return this.activardebito_mone_localCobrarEstadosCuentasPorFactura;
	}

	public void setActivardebito_mone_localCobrarEstadosCuentasPorFactura(Boolean activardebito_mone_localCobrarEstadosCuentasPorFactura) {
		this.activardebito_mone_localCobrarEstadosCuentasPorFactura= activardebito_mone_localCobrarEstadosCuentasPorFactura;
	}

	public Border setResaltarcredito_mone_localCobrarEstadosCuentasPorFactura(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarEstadosCuentasPorFacturaBeanSwingJInternalFrame cobrarestadoscuentasporfacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarestadoscuentasporfacturaBeanSwingJInternalFrame.jTtoolBarCobrarEstadosCuentasPorFactura.setBorder(borderResaltar);
		
		this.resaltarcredito_mone_localCobrarEstadosCuentasPorFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcredito_mone_localCobrarEstadosCuentasPorFactura() {
		return this.resaltarcredito_mone_localCobrarEstadosCuentasPorFactura;
	}

	public void setResaltarcredito_mone_localCobrarEstadosCuentasPorFactura(Border borderResaltar) {
		this.resaltarcredito_mone_localCobrarEstadosCuentasPorFactura= borderResaltar;
	}

	public Boolean getMostrarcredito_mone_localCobrarEstadosCuentasPorFactura() {
		return this.mostrarcredito_mone_localCobrarEstadosCuentasPorFactura;
	}

	public void setMostrarcredito_mone_localCobrarEstadosCuentasPorFactura(Boolean mostrarcredito_mone_localCobrarEstadosCuentasPorFactura) {
		this.mostrarcredito_mone_localCobrarEstadosCuentasPorFactura= mostrarcredito_mone_localCobrarEstadosCuentasPorFactura;
	}

	public Boolean getActivarcredito_mone_localCobrarEstadosCuentasPorFactura() {
		return this.activarcredito_mone_localCobrarEstadosCuentasPorFactura;
	}

	public void setActivarcredito_mone_localCobrarEstadosCuentasPorFactura(Boolean activarcredito_mone_localCobrarEstadosCuentasPorFactura) {
		this.activarcredito_mone_localCobrarEstadosCuentasPorFactura= activarcredito_mone_localCobrarEstadosCuentasPorFactura;
	}

	public Border setResaltardireccion_direccionCobrarEstadosCuentasPorFactura(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarEstadosCuentasPorFacturaBeanSwingJInternalFrame cobrarestadoscuentasporfacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarestadoscuentasporfacturaBeanSwingJInternalFrame.jTtoolBarCobrarEstadosCuentasPorFactura.setBorder(borderResaltar);
		
		this.resaltardireccion_direccionCobrarEstadosCuentasPorFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardireccion_direccionCobrarEstadosCuentasPorFactura() {
		return this.resaltardireccion_direccionCobrarEstadosCuentasPorFactura;
	}

	public void setResaltardireccion_direccionCobrarEstadosCuentasPorFactura(Border borderResaltar) {
		this.resaltardireccion_direccionCobrarEstadosCuentasPorFactura= borderResaltar;
	}

	public Boolean getMostrardireccion_direccionCobrarEstadosCuentasPorFactura() {
		return this.mostrardireccion_direccionCobrarEstadosCuentasPorFactura;
	}

	public void setMostrardireccion_direccionCobrarEstadosCuentasPorFactura(Boolean mostrardireccion_direccionCobrarEstadosCuentasPorFactura) {
		this.mostrardireccion_direccionCobrarEstadosCuentasPorFactura= mostrardireccion_direccionCobrarEstadosCuentasPorFactura;
	}

	public Boolean getActivardireccion_direccionCobrarEstadosCuentasPorFactura() {
		return this.activardireccion_direccionCobrarEstadosCuentasPorFactura;
	}

	public void setActivardireccion_direccionCobrarEstadosCuentasPorFactura(Boolean activardireccion_direccionCobrarEstadosCuentasPorFactura) {
		this.activardireccion_direccionCobrarEstadosCuentasPorFactura= activardireccion_direccionCobrarEstadosCuentasPorFactura;
	}

	public Border setResaltartelefono_telefonoCobrarEstadosCuentasPorFactura(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarEstadosCuentasPorFacturaBeanSwingJInternalFrame cobrarestadoscuentasporfacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarestadoscuentasporfacturaBeanSwingJInternalFrame.jTtoolBarCobrarEstadosCuentasPorFactura.setBorder(borderResaltar);
		
		this.resaltartelefono_telefonoCobrarEstadosCuentasPorFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefono_telefonoCobrarEstadosCuentasPorFactura() {
		return this.resaltartelefono_telefonoCobrarEstadosCuentasPorFactura;
	}

	public void setResaltartelefono_telefonoCobrarEstadosCuentasPorFactura(Border borderResaltar) {
		this.resaltartelefono_telefonoCobrarEstadosCuentasPorFactura= borderResaltar;
	}

	public Boolean getMostrartelefono_telefonoCobrarEstadosCuentasPorFactura() {
		return this.mostrartelefono_telefonoCobrarEstadosCuentasPorFactura;
	}

	public void setMostrartelefono_telefonoCobrarEstadosCuentasPorFactura(Boolean mostrartelefono_telefonoCobrarEstadosCuentasPorFactura) {
		this.mostrartelefono_telefonoCobrarEstadosCuentasPorFactura= mostrartelefono_telefonoCobrarEstadosCuentasPorFactura;
	}

	public Boolean getActivartelefono_telefonoCobrarEstadosCuentasPorFactura() {
		return this.activartelefono_telefonoCobrarEstadosCuentasPorFactura;
	}

	public void setActivartelefono_telefonoCobrarEstadosCuentasPorFactura(Boolean activartelefono_telefonoCobrarEstadosCuentasPorFactura) {
		this.activartelefono_telefonoCobrarEstadosCuentasPorFactura= activartelefono_telefonoCobrarEstadosCuentasPorFactura;
	}
	
	public void setMostrarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setMostraridCobrarEstadosCuentasPorFactura(esInicial);
		this.setMostrarid_empresaCobrarEstadosCuentasPorFactura(esInicial);
		this.setMostrarfecha_emision_desdeCobrarEstadosCuentasPorFactura(esInicial);
		this.setMostrarfecha_emision_hastaCobrarEstadosCuentasPorFactura(esInicial);
		this.setMostrarfecha_vence_desdeCobrarEstadosCuentasPorFactura(esInicial);
		this.setMostrarfecha_vence_hastaCobrarEstadosCuentasPorFactura(esInicial);
		this.setMostrarnombre_cuenta_contableCobrarEstadosCuentasPorFactura(esInicial);
		this.setMostrarnombre_ciudadCobrarEstadosCuentasPorFactura(esInicial);
		this.setMostrarnombre_zonaCobrarEstadosCuentasPorFactura(esInicial);
		this.setMostrarnombre_completoCobrarEstadosCuentasPorFactura(esInicial);
		this.setMostrarrucCobrarEstadosCuentasPorFactura(esInicial);
		this.setMostrarrepresentanteCobrarEstadosCuentasPorFactura(esInicial);
		this.setMostrardia_pagoCobrarEstadosCuentasPorFactura(esInicial);
		this.setMostrarhora_pagoCobrarEstadosCuentasPorFactura(esInicial);
		this.setMostrarobservacionCobrarEstadosCuentasPorFactura(esInicial);
		this.setMostrarnombre_transaccionCobrarEstadosCuentasPorFactura(esInicial);
		this.setMostrarfecha_venceCobrarEstadosCuentasPorFactura(esInicial);
		this.setMostrarfecha_emisionCobrarEstadosCuentasPorFactura(esInicial);
		this.setMostrarnumero_comprobanteCobrarEstadosCuentasPorFactura(esInicial);
		this.setMostrarnumero_facturaCobrarEstadosCuentasPorFactura(esInicial);
		this.setMostrardebito_mone_localCobrarEstadosCuentasPorFactura(esInicial);
		this.setMostrarcredito_mone_localCobrarEstadosCuentasPorFactura(esInicial);
		this.setMostrardireccion_direccionCobrarEstadosCuentasPorFactura(esInicial);
		this.setMostrartelefono_telefonoCobrarEstadosCuentasPorFactura(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.ID)) {
				this.setMostraridCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setMostrarfecha_emision_desdeCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setMostrarfecha_emision_hastaCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.FECHAVENCEDESDE)) {
				this.setMostrarfecha_vence_desdeCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.FECHAVENCEHASTA)) {
				this.setMostrarfecha_vence_hastaCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.NOMBRECUENTACONTABLE)) {
				this.setMostrarnombre_cuenta_contableCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.NOMBRECIUDAD)) {
				this.setMostrarnombre_ciudadCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.NOMBREZONA)) {
				this.setMostrarnombre_zonaCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.NOMBRECOMPLETO)) {
				this.setMostrarnombre_completoCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.RUC)) {
				this.setMostrarrucCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.REPRESENTANTE)) {
				this.setMostrarrepresentanteCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.DIAPAGO)) {
				this.setMostrardia_pagoCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.HORAPAGO)) {
				this.setMostrarhora_pagoCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.OBSERVACION)) {
				this.setMostrarobservacionCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.NOMBRETRANSACCION)) {
				this.setMostrarnombre_transaccionCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.FECHAVENCE)) {
				this.setMostrarfecha_venceCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setMostrarnumero_comprobanteCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.NUMEROFACTURA)) {
				this.setMostrarnumero_facturaCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.DEBITOMONELOCAL)) {
				this.setMostrardebito_mone_localCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.CREDITOMONELOCAL)) {
				this.setMostrarcredito_mone_localCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.DIRECCIONDIRECCION)) {
				this.setMostrardireccion_direccionCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.TELEFONOTELEFONO)) {
				this.setMostrartelefono_telefonoCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}
		}
	}
	
	public void setActivarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setActivaridCobrarEstadosCuentasPorFactura(esInicial);
		this.setActivarid_empresaCobrarEstadosCuentasPorFactura(esInicial);
		this.setActivarfecha_emision_desdeCobrarEstadosCuentasPorFactura(esInicial);
		this.setActivarfecha_emision_hastaCobrarEstadosCuentasPorFactura(esInicial);
		this.setActivarfecha_vence_desdeCobrarEstadosCuentasPorFactura(esInicial);
		this.setActivarfecha_vence_hastaCobrarEstadosCuentasPorFactura(esInicial);
		this.setActivarnombre_cuenta_contableCobrarEstadosCuentasPorFactura(esInicial);
		this.setActivarnombre_ciudadCobrarEstadosCuentasPorFactura(esInicial);
		this.setActivarnombre_zonaCobrarEstadosCuentasPorFactura(esInicial);
		this.setActivarnombre_completoCobrarEstadosCuentasPorFactura(esInicial);
		this.setActivarrucCobrarEstadosCuentasPorFactura(esInicial);
		this.setActivarrepresentanteCobrarEstadosCuentasPorFactura(esInicial);
		this.setActivardia_pagoCobrarEstadosCuentasPorFactura(esInicial);
		this.setActivarhora_pagoCobrarEstadosCuentasPorFactura(esInicial);
		this.setActivarobservacionCobrarEstadosCuentasPorFactura(esInicial);
		this.setActivarnombre_transaccionCobrarEstadosCuentasPorFactura(esInicial);
		this.setActivarfecha_venceCobrarEstadosCuentasPorFactura(esInicial);
		this.setActivarfecha_emisionCobrarEstadosCuentasPorFactura(esInicial);
		this.setActivarnumero_comprobanteCobrarEstadosCuentasPorFactura(esInicial);
		this.setActivarnumero_facturaCobrarEstadosCuentasPorFactura(esInicial);
		this.setActivardebito_mone_localCobrarEstadosCuentasPorFactura(esInicial);
		this.setActivarcredito_mone_localCobrarEstadosCuentasPorFactura(esInicial);
		this.setActivardireccion_direccionCobrarEstadosCuentasPorFactura(esInicial);
		this.setActivartelefono_telefonoCobrarEstadosCuentasPorFactura(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.ID)) {
				this.setActivaridCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setActivarfecha_emision_desdeCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setActivarfecha_emision_hastaCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.FECHAVENCEDESDE)) {
				this.setActivarfecha_vence_desdeCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.FECHAVENCEHASTA)) {
				this.setActivarfecha_vence_hastaCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.NOMBRECUENTACONTABLE)) {
				this.setActivarnombre_cuenta_contableCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.NOMBRECIUDAD)) {
				this.setActivarnombre_ciudadCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.NOMBREZONA)) {
				this.setActivarnombre_zonaCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.NOMBRECOMPLETO)) {
				this.setActivarnombre_completoCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.RUC)) {
				this.setActivarrucCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.REPRESENTANTE)) {
				this.setActivarrepresentanteCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.DIAPAGO)) {
				this.setActivardia_pagoCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.HORAPAGO)) {
				this.setActivarhora_pagoCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.OBSERVACION)) {
				this.setActivarobservacionCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.NOMBRETRANSACCION)) {
				this.setActivarnombre_transaccionCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.FECHAVENCE)) {
				this.setActivarfecha_venceCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setActivarnumero_comprobanteCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.NUMEROFACTURA)) {
				this.setActivarnumero_facturaCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.DEBITOMONELOCAL)) {
				this.setActivardebito_mone_localCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.CREDITOMONELOCAL)) {
				this.setActivarcredito_mone_localCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.DIRECCIONDIRECCION)) {
				this.setActivardireccion_direccionCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.TELEFONOTELEFONO)) {
				this.setActivartelefono_telefonoCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CobrarEstadosCuentasPorFacturaBeanSwingJInternalFrame cobrarestadoscuentasporfacturaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCobrarEstadosCuentasPorFactura(esInicial);
		this.setResaltarid_empresaCobrarEstadosCuentasPorFactura(esInicial);
		this.setResaltarfecha_emision_desdeCobrarEstadosCuentasPorFactura(esInicial);
		this.setResaltarfecha_emision_hastaCobrarEstadosCuentasPorFactura(esInicial);
		this.setResaltarfecha_vence_desdeCobrarEstadosCuentasPorFactura(esInicial);
		this.setResaltarfecha_vence_hastaCobrarEstadosCuentasPorFactura(esInicial);
		this.setResaltarnombre_cuenta_contableCobrarEstadosCuentasPorFactura(esInicial);
		this.setResaltarnombre_ciudadCobrarEstadosCuentasPorFactura(esInicial);
		this.setResaltarnombre_zonaCobrarEstadosCuentasPorFactura(esInicial);
		this.setResaltarnombre_completoCobrarEstadosCuentasPorFactura(esInicial);
		this.setResaltarrucCobrarEstadosCuentasPorFactura(esInicial);
		this.setResaltarrepresentanteCobrarEstadosCuentasPorFactura(esInicial);
		this.setResaltardia_pagoCobrarEstadosCuentasPorFactura(esInicial);
		this.setResaltarhora_pagoCobrarEstadosCuentasPorFactura(esInicial);
		this.setResaltarobservacionCobrarEstadosCuentasPorFactura(esInicial);
		this.setResaltarnombre_transaccionCobrarEstadosCuentasPorFactura(esInicial);
		this.setResaltarfecha_venceCobrarEstadosCuentasPorFactura(esInicial);
		this.setResaltarfecha_emisionCobrarEstadosCuentasPorFactura(esInicial);
		this.setResaltarnumero_comprobanteCobrarEstadosCuentasPorFactura(esInicial);
		this.setResaltarnumero_facturaCobrarEstadosCuentasPorFactura(esInicial);
		this.setResaltardebito_mone_localCobrarEstadosCuentasPorFactura(esInicial);
		this.setResaltarcredito_mone_localCobrarEstadosCuentasPorFactura(esInicial);
		this.setResaltardireccion_direccionCobrarEstadosCuentasPorFactura(esInicial);
		this.setResaltartelefono_telefonoCobrarEstadosCuentasPorFactura(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.ID)) {
				this.setResaltaridCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setResaltarfecha_emision_desdeCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setResaltarfecha_emision_hastaCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.FECHAVENCEDESDE)) {
				this.setResaltarfecha_vence_desdeCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.FECHAVENCEHASTA)) {
				this.setResaltarfecha_vence_hastaCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.NOMBRECUENTACONTABLE)) {
				this.setResaltarnombre_cuenta_contableCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.NOMBRECIUDAD)) {
				this.setResaltarnombre_ciudadCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.NOMBREZONA)) {
				this.setResaltarnombre_zonaCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.NOMBRECOMPLETO)) {
				this.setResaltarnombre_completoCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.RUC)) {
				this.setResaltarrucCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.REPRESENTANTE)) {
				this.setResaltarrepresentanteCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.DIAPAGO)) {
				this.setResaltardia_pagoCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.HORAPAGO)) {
				this.setResaltarhora_pagoCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.OBSERVACION)) {
				this.setResaltarobservacionCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.NOMBRETRANSACCION)) {
				this.setResaltarnombre_transaccionCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.FECHAVENCE)) {
				this.setResaltarfecha_venceCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setResaltarnumero_comprobanteCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.NUMEROFACTURA)) {
				this.setResaltarnumero_facturaCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.DEBITOMONELOCAL)) {
				this.setResaltardebito_mone_localCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.CREDITOMONELOCAL)) {
				this.setResaltarcredito_mone_localCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.DIRECCIONDIRECCION)) {
				this.setResaltardireccion_direccionCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarEstadosCuentasPorFacturaConstantesFunciones.TELEFONOTELEFONO)) {
				this.setResaltartelefono_telefonoCobrarEstadosCuentasPorFactura(esAsigna);
				continue;
			}
		}
	}
	
			
		
	public void setMostrarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}


		for(Classe clase:clases) {
		}		
	}
	
	public void setActivarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}


		for(Classe clase:clases) {
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CobrarEstadosCuentasPorFacturaBeanSwingJInternalFrame cobrarestadoscuentasporfacturaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}


		for(Classe clase:clases) {
		}		
	}
	
	


	public Boolean mostrarBusquedaCobrarEstadosCuentasPorFacturaCobrarEstadosCuentasPorFactura=true;

	public Boolean getMostrarBusquedaCobrarEstadosCuentasPorFacturaCobrarEstadosCuentasPorFactura() {
		return this.mostrarBusquedaCobrarEstadosCuentasPorFacturaCobrarEstadosCuentasPorFactura;
	}

	public void setMostrarBusquedaCobrarEstadosCuentasPorFacturaCobrarEstadosCuentasPorFactura(Boolean visibilidadResaltar) {
		this.mostrarBusquedaCobrarEstadosCuentasPorFacturaCobrarEstadosCuentasPorFactura= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaCobrarEstadosCuentasPorFactura2CobrarEstadosCuentasPorFactura=true;

	public Boolean getMostrarBusquedaCobrarEstadosCuentasPorFactura2CobrarEstadosCuentasPorFactura() {
		return this.mostrarBusquedaCobrarEstadosCuentasPorFactura2CobrarEstadosCuentasPorFactura;
	}

	public void setMostrarBusquedaCobrarEstadosCuentasPorFactura2CobrarEstadosCuentasPorFactura(Boolean visibilidadResaltar) {
		this.mostrarBusquedaCobrarEstadosCuentasPorFactura2CobrarEstadosCuentasPorFactura= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaCobrarEstadosCuentasPorFacturaCobrarEstadosCuentasPorFactura=true;

	public Boolean getActivarBusquedaCobrarEstadosCuentasPorFacturaCobrarEstadosCuentasPorFactura() {
		return this.activarBusquedaCobrarEstadosCuentasPorFacturaCobrarEstadosCuentasPorFactura;
	}

	public void setActivarBusquedaCobrarEstadosCuentasPorFacturaCobrarEstadosCuentasPorFactura(Boolean habilitarResaltar) {
		this.activarBusquedaCobrarEstadosCuentasPorFacturaCobrarEstadosCuentasPorFactura= habilitarResaltar;
	}

	public Boolean activarBusquedaCobrarEstadosCuentasPorFactura2CobrarEstadosCuentasPorFactura=true;

	public Boolean getActivarBusquedaCobrarEstadosCuentasPorFactura2CobrarEstadosCuentasPorFactura() {
		return this.activarBusquedaCobrarEstadosCuentasPorFactura2CobrarEstadosCuentasPorFactura;
	}

	public void setActivarBusquedaCobrarEstadosCuentasPorFactura2CobrarEstadosCuentasPorFactura(Boolean habilitarResaltar) {
		this.activarBusquedaCobrarEstadosCuentasPorFactura2CobrarEstadosCuentasPorFactura= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaCobrarEstadosCuentasPorFacturaCobrarEstadosCuentasPorFactura=null;

	public Border getResaltarBusquedaCobrarEstadosCuentasPorFacturaCobrarEstadosCuentasPorFactura() {
		return this.resaltarBusquedaCobrarEstadosCuentasPorFacturaCobrarEstadosCuentasPorFactura;
	}

	public void setResaltarBusquedaCobrarEstadosCuentasPorFacturaCobrarEstadosCuentasPorFactura(Border borderResaltar) {
		this.resaltarBusquedaCobrarEstadosCuentasPorFacturaCobrarEstadosCuentasPorFactura= borderResaltar;
	}

	public void setResaltarBusquedaCobrarEstadosCuentasPorFacturaCobrarEstadosCuentasPorFactura(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarEstadosCuentasPorFacturaBeanSwingJInternalFrame cobrarestadoscuentasporfacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaCobrarEstadosCuentasPorFacturaCobrarEstadosCuentasPorFactura= borderResaltar;
	}

	public Border resaltarBusquedaCobrarEstadosCuentasPorFactura2CobrarEstadosCuentasPorFactura=null;

	public Border getResaltarBusquedaCobrarEstadosCuentasPorFactura2CobrarEstadosCuentasPorFactura() {
		return this.resaltarBusquedaCobrarEstadosCuentasPorFactura2CobrarEstadosCuentasPorFactura;
	}

	public void setResaltarBusquedaCobrarEstadosCuentasPorFactura2CobrarEstadosCuentasPorFactura(Border borderResaltar) {
		this.resaltarBusquedaCobrarEstadosCuentasPorFactura2CobrarEstadosCuentasPorFactura= borderResaltar;
	}

	public void setResaltarBusquedaCobrarEstadosCuentasPorFactura2CobrarEstadosCuentasPorFactura(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarEstadosCuentasPorFacturaBeanSwingJInternalFrame cobrarestadoscuentasporfacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaCobrarEstadosCuentasPorFactura2CobrarEstadosCuentasPorFactura= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}