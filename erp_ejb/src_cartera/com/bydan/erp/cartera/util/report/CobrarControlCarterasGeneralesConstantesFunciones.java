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


import com.bydan.erp.cartera.util.report.CobrarControlCarterasGeneralesConstantesFunciones;
import com.bydan.erp.cartera.util.report.CobrarControlCarterasGeneralesParameterReturnGeneral;
//import com.bydan.erp.cartera.util.report.CobrarControlCarterasGeneralesParameterGeneral;

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
final public class CobrarControlCarterasGeneralesConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="CobrarControlCarterasGenerales";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="CobrarControlCarterasGenerales"+CobrarControlCarterasGeneralesConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CobrarControlCarterasGeneralesHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CobrarControlCarterasGeneralesHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CobrarControlCarterasGeneralesConstantesFunciones.SCHEMA+"_"+CobrarControlCarterasGeneralesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CobrarControlCarterasGeneralesHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CobrarControlCarterasGeneralesConstantesFunciones.SCHEMA+"_"+CobrarControlCarterasGeneralesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CobrarControlCarterasGeneralesConstantesFunciones.SCHEMA+"_"+CobrarControlCarterasGeneralesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CobrarControlCarterasGeneralesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CobrarControlCarterasGeneralesConstantesFunciones.SCHEMA+"_"+CobrarControlCarterasGeneralesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobrarControlCarterasGeneralesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CobrarControlCarterasGeneralesHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobrarControlCarterasGeneralesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobrarControlCarterasGeneralesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CobrarControlCarterasGeneralesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobrarControlCarterasGeneralesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CobrarControlCarterasGeneralesConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CobrarControlCarterasGeneralesConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CobrarControlCarterasGeneralesConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CobrarControlCarterasGeneralesConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Cobrar Control Carteras Generaleses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Cobrar Control Carteras Generales";
	public static final String SCLASSWEBTITULO_LOWER="Cobrar Control Carteras Generales";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="CobrarControlCarterasGenerales";
	public static final String OBJECTNAME="cobrarcontrolcarterasgenerales";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="cobrar_control_carteras_generales";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select cobrarcontrolcarterasgenerales from "+CobrarControlCarterasGeneralesConstantesFunciones.SPERSISTENCENAME+" cobrarcontrolcarterasgenerales";
	public static String QUERYSELECTNATIVE="select "+CobrarControlCarterasGeneralesConstantesFunciones.SCHEMA+"."+CobrarControlCarterasGeneralesConstantesFunciones.TABLENAME+".id,"+CobrarControlCarterasGeneralesConstantesFunciones.SCHEMA+"."+CobrarControlCarterasGeneralesConstantesFunciones.TABLENAME+".version_row,"+CobrarControlCarterasGeneralesConstantesFunciones.SCHEMA+"."+CobrarControlCarterasGeneralesConstantesFunciones.TABLENAME+".id_empresa,"+CobrarControlCarterasGeneralesConstantesFunciones.SCHEMA+"."+CobrarControlCarterasGeneralesConstantesFunciones.TABLENAME+".fecha_emision_hasta,"+CobrarControlCarterasGeneralesConstantesFunciones.SCHEMA+"."+CobrarControlCarterasGeneralesConstantesFunciones.TABLENAME+".nombre_ciudad,"+CobrarControlCarterasGeneralesConstantesFunciones.SCHEMA+"."+CobrarControlCarterasGeneralesConstantesFunciones.TABLENAME+".nombre_zona,"+CobrarControlCarterasGeneralesConstantesFunciones.SCHEMA+"."+CobrarControlCarterasGeneralesConstantesFunciones.TABLENAME+".nombre_vendedor,"+CobrarControlCarterasGeneralesConstantesFunciones.SCHEMA+"."+CobrarControlCarterasGeneralesConstantesFunciones.TABLENAME+".codigo,"+CobrarControlCarterasGeneralesConstantesFunciones.SCHEMA+"."+CobrarControlCarterasGeneralesConstantesFunciones.TABLENAME+".nombre_completo,"+CobrarControlCarterasGeneralesConstantesFunciones.SCHEMA+"."+CobrarControlCarterasGeneralesConstantesFunciones.TABLENAME+".limite_credito,"+CobrarControlCarterasGeneralesConstantesFunciones.SCHEMA+"."+CobrarControlCarterasGeneralesConstantesFunciones.TABLENAME+".representante,"+CobrarControlCarterasGeneralesConstantesFunciones.SCHEMA+"."+CobrarControlCarterasGeneralesConstantesFunciones.TABLENAME+".dia_pago,"+CobrarControlCarterasGeneralesConstantesFunciones.SCHEMA+"."+CobrarControlCarterasGeneralesConstantesFunciones.TABLENAME+".numero_comprobante,"+CobrarControlCarterasGeneralesConstantesFunciones.SCHEMA+"."+CobrarControlCarterasGeneralesConstantesFunciones.TABLENAME+".numero_factura,"+CobrarControlCarterasGeneralesConstantesFunciones.SCHEMA+"."+CobrarControlCarterasGeneralesConstantesFunciones.TABLENAME+".direccion_direccion,"+CobrarControlCarterasGeneralesConstantesFunciones.SCHEMA+"."+CobrarControlCarterasGeneralesConstantesFunciones.TABLENAME+".telefono_telefono,"+CobrarControlCarterasGeneralesConstantesFunciones.SCHEMA+"."+CobrarControlCarterasGeneralesConstantesFunciones.TABLENAME+".fecha_emisio,"+CobrarControlCarterasGeneralesConstantesFunciones.SCHEMA+"."+CobrarControlCarterasGeneralesConstantesFunciones.TABLENAME+".fecha_vence,"+CobrarControlCarterasGeneralesConstantesFunciones.SCHEMA+"."+CobrarControlCarterasGeneralesConstantesFunciones.TABLENAME+".dias,"+CobrarControlCarterasGeneralesConstantesFunciones.SCHEMA+"."+CobrarControlCarterasGeneralesConstantesFunciones.TABLENAME+".saldo,"+CobrarControlCarterasGeneralesConstantesFunciones.SCHEMA+"."+CobrarControlCarterasGeneralesConstantesFunciones.TABLENAME+".debito_mone_local,"+CobrarControlCarterasGeneralesConstantesFunciones.SCHEMA+"."+CobrarControlCarterasGeneralesConstantesFunciones.TABLENAME+".credito_mone_local,"+CobrarControlCarterasGeneralesConstantesFunciones.SCHEMA+"."+CobrarControlCarterasGeneralesConstantesFunciones.TABLENAME+".hora_pago from "+CobrarControlCarterasGeneralesConstantesFunciones.SCHEMA+"."+CobrarControlCarterasGeneralesConstantesFunciones.TABLENAME;//+" as "+CobrarControlCarterasGeneralesConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String FECHAEMISIONHASTA= "fecha_emision_hasta";
    public static final String NOMBRECIUDAD= "nombre_ciudad";
    public static final String NOMBREZONA= "nombre_zona";
    public static final String NOMBREVENDEDOR= "nombre_vendedor";
    public static final String CODIGO= "codigo";
    public static final String NOMBRECOMPLETO= "nombre_completo";
    public static final String LIMITECREDITO= "limite_credito";
    public static final String REPRESENTANTE= "representante";
    public static final String DIAPAGO= "dia_pago";
    public static final String NUMEROCOMPROBANTE= "numero_comprobante";
    public static final String NUMEROFACTURA= "numero_factura";
    public static final String DIRECCIONDIRECCION= "direccion_direccion";
    public static final String TELEFONOTELEFONO= "telefono_telefono";
    public static final String FECHAEMISIO= "fecha_emisio";
    public static final String FECHAVENCE= "fecha_vence";
    public static final String DIAS= "dias";
    public static final String SALDO= "saldo";
    public static final String DEBITOMONELOCAL= "debito_mone_local";
    public static final String CREDITOMONELOCAL= "credito_mone_local";
    public static final String HORAPAGO= "hora_pago";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_FECHAEMISIONHASTA= "Fecha Emision Hasta";
		public static final String LABEL_FECHAEMISIONHASTA_LOWER= "Fecha Emision Hasta";
    	public static final String LABEL_NOMBRECIUDAD= "Nombre Ciudad";
		public static final String LABEL_NOMBRECIUDAD_LOWER= "Nombre Ciudad";
    	public static final String LABEL_NOMBREZONA= "Nombre Zona";
		public static final String LABEL_NOMBREZONA_LOWER= "Nombre Zona";
    	public static final String LABEL_NOMBREVENDEDOR= "Nombre Vendedor";
		public static final String LABEL_NOMBREVENDEDOR_LOWER= "Nombre Vendedor";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRECOMPLETO= "Nombre Completo";
		public static final String LABEL_NOMBRECOMPLETO_LOWER= "Nombre Completo";
    	public static final String LABEL_LIMITECREDITO= "Limite Credito";
		public static final String LABEL_LIMITECREDITO_LOWER= "Limite Credito";
    	public static final String LABEL_REPRESENTANTE= "Representante";
		public static final String LABEL_REPRESENTANTE_LOWER= "Representante";
    	public static final String LABEL_DIAPAGO= "Dia Pago";
		public static final String LABEL_DIAPAGO_LOWER= "Dia Pago";
    	public static final String LABEL_NUMEROCOMPROBANTE= "Numero Comprobante";
		public static final String LABEL_NUMEROCOMPROBANTE_LOWER= "Numero Comprobante";
    	public static final String LABEL_NUMEROFACTURA= "Numero Factura";
		public static final String LABEL_NUMEROFACTURA_LOWER= "Numero Factura";
    	public static final String LABEL_DIRECCIONDIRECCION= "Direccion Direccion";
		public static final String LABEL_DIRECCIONDIRECCION_LOWER= "Direccion Direccion";
    	public static final String LABEL_TELEFONOTELEFONO= "Telefono Telefono";
		public static final String LABEL_TELEFONOTELEFONO_LOWER= "Telefono Telefono";
    	public static final String LABEL_FECHAEMISIO= "Fecha Emisio";
		public static final String LABEL_FECHAEMISIO_LOWER= "Fecha Emisio";
    	public static final String LABEL_FECHAVENCE= "Fecha Vence";
		public static final String LABEL_FECHAVENCE_LOWER= "Fecha Vence";
    	public static final String LABEL_DIAS= "Dias";
		public static final String LABEL_DIAS_LOWER= "Dias";
    	public static final String LABEL_SALDO= "Saldo";
		public static final String LABEL_SALDO_LOWER= "Saldo";
    	public static final String LABEL_DEBITOMONELOCAL= "Debito Mone Local";
		public static final String LABEL_DEBITOMONELOCAL_LOWER= "Debito Mone Local";
    	public static final String LABEL_CREDITOMONELOCAL= "Credito Mone Local";
		public static final String LABEL_CREDITOMONELOCAL_LOWER= "Credito Mone Local";
    	public static final String LABEL_HORAPAGO= "Hora Pago";
		public static final String LABEL_HORAPAGO_LOWER= "Hora Pago";
	
		
		
		
		
	public static final String SREGEXNOMBRE_CIUDAD=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_CIUDAD=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_ZONA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_ZONA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_VENDEDOR=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_VENDEDOR=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_COMPLETO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_COMPLETO=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXREPRESENTANTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXREPRESENTANTE=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXNUMERO_COMPROBANTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_COMPROBANTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_FACTURA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_FACTURA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDIRECCION_DIRECCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDIRECCION_DIRECCION=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXTELEFONO_TELEFONO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXTELEFONO_TELEFONO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
	
	public static String getCobrarControlCarterasGeneralesLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CobrarControlCarterasGeneralesConstantesFunciones.IDEMPRESA)) {sLabelColumna=CobrarControlCarterasGeneralesConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(CobrarControlCarterasGeneralesConstantesFunciones.FECHAEMISIONHASTA)) {sLabelColumna=CobrarControlCarterasGeneralesConstantesFunciones.LABEL_FECHAEMISIONHASTA;}
		if(sNombreColumna.equals(CobrarControlCarterasGeneralesConstantesFunciones.NOMBRECIUDAD)) {sLabelColumna=CobrarControlCarterasGeneralesConstantesFunciones.LABEL_NOMBRECIUDAD;}
		if(sNombreColumna.equals(CobrarControlCarterasGeneralesConstantesFunciones.NOMBREZONA)) {sLabelColumna=CobrarControlCarterasGeneralesConstantesFunciones.LABEL_NOMBREZONA;}
		if(sNombreColumna.equals(CobrarControlCarterasGeneralesConstantesFunciones.NOMBREVENDEDOR)) {sLabelColumna=CobrarControlCarterasGeneralesConstantesFunciones.LABEL_NOMBREVENDEDOR;}
		if(sNombreColumna.equals(CobrarControlCarterasGeneralesConstantesFunciones.CODIGO)) {sLabelColumna=CobrarControlCarterasGeneralesConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(CobrarControlCarterasGeneralesConstantesFunciones.NOMBRECOMPLETO)) {sLabelColumna=CobrarControlCarterasGeneralesConstantesFunciones.LABEL_NOMBRECOMPLETO;}
		if(sNombreColumna.equals(CobrarControlCarterasGeneralesConstantesFunciones.LIMITECREDITO)) {sLabelColumna=CobrarControlCarterasGeneralesConstantesFunciones.LABEL_LIMITECREDITO;}
		if(sNombreColumna.equals(CobrarControlCarterasGeneralesConstantesFunciones.REPRESENTANTE)) {sLabelColumna=CobrarControlCarterasGeneralesConstantesFunciones.LABEL_REPRESENTANTE;}
		if(sNombreColumna.equals(CobrarControlCarterasGeneralesConstantesFunciones.DIAPAGO)) {sLabelColumna=CobrarControlCarterasGeneralesConstantesFunciones.LABEL_DIAPAGO;}
		if(sNombreColumna.equals(CobrarControlCarterasGeneralesConstantesFunciones.NUMEROCOMPROBANTE)) {sLabelColumna=CobrarControlCarterasGeneralesConstantesFunciones.LABEL_NUMEROCOMPROBANTE;}
		if(sNombreColumna.equals(CobrarControlCarterasGeneralesConstantesFunciones.NUMEROFACTURA)) {sLabelColumna=CobrarControlCarterasGeneralesConstantesFunciones.LABEL_NUMEROFACTURA;}
		if(sNombreColumna.equals(CobrarControlCarterasGeneralesConstantesFunciones.DIRECCIONDIRECCION)) {sLabelColumna=CobrarControlCarterasGeneralesConstantesFunciones.LABEL_DIRECCIONDIRECCION;}
		if(sNombreColumna.equals(CobrarControlCarterasGeneralesConstantesFunciones.TELEFONOTELEFONO)) {sLabelColumna=CobrarControlCarterasGeneralesConstantesFunciones.LABEL_TELEFONOTELEFONO;}
		if(sNombreColumna.equals(CobrarControlCarterasGeneralesConstantesFunciones.FECHAEMISIO)) {sLabelColumna=CobrarControlCarterasGeneralesConstantesFunciones.LABEL_FECHAEMISIO;}
		if(sNombreColumna.equals(CobrarControlCarterasGeneralesConstantesFunciones.FECHAVENCE)) {sLabelColumna=CobrarControlCarterasGeneralesConstantesFunciones.LABEL_FECHAVENCE;}
		if(sNombreColumna.equals(CobrarControlCarterasGeneralesConstantesFunciones.DIAS)) {sLabelColumna=CobrarControlCarterasGeneralesConstantesFunciones.LABEL_DIAS;}
		if(sNombreColumna.equals(CobrarControlCarterasGeneralesConstantesFunciones.SALDO)) {sLabelColumna=CobrarControlCarterasGeneralesConstantesFunciones.LABEL_SALDO;}
		if(sNombreColumna.equals(CobrarControlCarterasGeneralesConstantesFunciones.DEBITOMONELOCAL)) {sLabelColumna=CobrarControlCarterasGeneralesConstantesFunciones.LABEL_DEBITOMONELOCAL;}
		if(sNombreColumna.equals(CobrarControlCarterasGeneralesConstantesFunciones.CREDITOMONELOCAL)) {sLabelColumna=CobrarControlCarterasGeneralesConstantesFunciones.LABEL_CREDITOMONELOCAL;}
		if(sNombreColumna.equals(CobrarControlCarterasGeneralesConstantesFunciones.HORAPAGO)) {sLabelColumna=CobrarControlCarterasGeneralesConstantesFunciones.LABEL_HORAPAGO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getCobrarControlCarterasGeneralesDescripcion(CobrarControlCarterasGenerales cobrarcontrolcarterasgenerales) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(cobrarcontrolcarterasgenerales !=null/* && cobrarcontrolcarterasgenerales.getId()!=0*/) {
			sDescripcion=cobrarcontrolcarterasgenerales.getcodigo();//cobrarcontrolcarterasgeneralescobrarcontrolcarterasgenerales.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getCobrarControlCarterasGeneralesDescripcionDetallado(CobrarControlCarterasGenerales cobrarcontrolcarterasgenerales) {
		String sDescripcion="";
			
		sDescripcion+=CobrarControlCarterasGeneralesConstantesFunciones.ID+"=";
		sDescripcion+=cobrarcontrolcarterasgenerales.getId().toString()+",";
		sDescripcion+=CobrarControlCarterasGeneralesConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=cobrarcontrolcarterasgenerales.getVersionRow().toString()+",";
		sDescripcion+=CobrarControlCarterasGeneralesConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=cobrarcontrolcarterasgenerales.getid_empresa().toString()+",";
		sDescripcion+=CobrarControlCarterasGeneralesConstantesFunciones.FECHAEMISIONHASTA+"=";
		sDescripcion+=cobrarcontrolcarterasgenerales.getfecha_emision_hasta().toString()+",";
		sDescripcion+=CobrarControlCarterasGeneralesConstantesFunciones.NOMBRECIUDAD+"=";
		sDescripcion+=cobrarcontrolcarterasgenerales.getnombre_ciudad()+",";
		sDescripcion+=CobrarControlCarterasGeneralesConstantesFunciones.NOMBREZONA+"=";
		sDescripcion+=cobrarcontrolcarterasgenerales.getnombre_zona()+",";
		sDescripcion+=CobrarControlCarterasGeneralesConstantesFunciones.NOMBREVENDEDOR+"=";
		sDescripcion+=cobrarcontrolcarterasgenerales.getnombre_vendedor()+",";
		sDescripcion+=CobrarControlCarterasGeneralesConstantesFunciones.CODIGO+"=";
		sDescripcion+=cobrarcontrolcarterasgenerales.getcodigo()+",";
		sDescripcion+=CobrarControlCarterasGeneralesConstantesFunciones.NOMBRECOMPLETO+"=";
		sDescripcion+=cobrarcontrolcarterasgenerales.getnombre_completo()+",";
		sDescripcion+=CobrarControlCarterasGeneralesConstantesFunciones.LIMITECREDITO+"=";
		sDescripcion+=cobrarcontrolcarterasgenerales.getlimite_credito().toString()+",";
		sDescripcion+=CobrarControlCarterasGeneralesConstantesFunciones.REPRESENTANTE+"=";
		sDescripcion+=cobrarcontrolcarterasgenerales.getrepresentante()+",";
		sDescripcion+=CobrarControlCarterasGeneralesConstantesFunciones.DIAPAGO+"=";
		sDescripcion+=cobrarcontrolcarterasgenerales.getdia_pago().toString()+",";
		sDescripcion+=CobrarControlCarterasGeneralesConstantesFunciones.NUMEROCOMPROBANTE+"=";
		sDescripcion+=cobrarcontrolcarterasgenerales.getnumero_comprobante()+",";
		sDescripcion+=CobrarControlCarterasGeneralesConstantesFunciones.NUMEROFACTURA+"=";
		sDescripcion+=cobrarcontrolcarterasgenerales.getnumero_factura()+",";
		sDescripcion+=CobrarControlCarterasGeneralesConstantesFunciones.DIRECCIONDIRECCION+"=";
		sDescripcion+=cobrarcontrolcarterasgenerales.getdireccion_direccion()+",";
		sDescripcion+=CobrarControlCarterasGeneralesConstantesFunciones.TELEFONOTELEFONO+"=";
		sDescripcion+=cobrarcontrolcarterasgenerales.gettelefono_telefono()+",";
		sDescripcion+=CobrarControlCarterasGeneralesConstantesFunciones.FECHAEMISIO+"=";
		sDescripcion+=cobrarcontrolcarterasgenerales.getfecha_emisio().toString()+",";
		sDescripcion+=CobrarControlCarterasGeneralesConstantesFunciones.FECHAVENCE+"=";
		sDescripcion+=cobrarcontrolcarterasgenerales.getfecha_vence().toString()+",";
		sDescripcion+=CobrarControlCarterasGeneralesConstantesFunciones.DIAS+"=";
		sDescripcion+=cobrarcontrolcarterasgenerales.getdias().toString()+",";
		sDescripcion+=CobrarControlCarterasGeneralesConstantesFunciones.SALDO+"=";
		sDescripcion+=cobrarcontrolcarterasgenerales.getsaldo().toString()+",";
		sDescripcion+=CobrarControlCarterasGeneralesConstantesFunciones.DEBITOMONELOCAL+"=";
		sDescripcion+=cobrarcontrolcarterasgenerales.getdebito_mone_local().toString()+",";
		sDescripcion+=CobrarControlCarterasGeneralesConstantesFunciones.CREDITOMONELOCAL+"=";
		sDescripcion+=cobrarcontrolcarterasgenerales.getcredito_mone_local().toString()+",";
		sDescripcion+=CobrarControlCarterasGeneralesConstantesFunciones.HORAPAGO+"=";
		sDescripcion+=cobrarcontrolcarterasgenerales.gethora_pago().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setCobrarControlCarterasGeneralesDescripcion(CobrarControlCarterasGenerales cobrarcontrolcarterasgenerales,String sValor) throws Exception {			
		if(cobrarcontrolcarterasgenerales !=null) {
			cobrarcontrolcarterasgenerales.setcodigo(sValor);;//cobrarcontrolcarterasgeneralescobrarcontrolcarterasgenerales.getcodigo().trim();
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
		} else if(sNombreIndice.equals("BusquedaCobrarControlCarterasGenerales")) {
			sNombreIndice="Tipo=  Por Fecha Emision Hasta";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaCobrarControlCarterasGenerales(Date fecha_emision_hasta) {
		String sDetalleIndice=" Parametros->";
		if(fecha_emision_hasta!=null) {sDetalleIndice+=" Fecha Emision Hasta="+fecha_emision_hasta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosCobrarControlCarterasGenerales(CobrarControlCarterasGenerales cobrarcontrolcarterasgenerales,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		cobrarcontrolcarterasgenerales.setnombre_ciudad(cobrarcontrolcarterasgenerales.getnombre_ciudad().trim());
		cobrarcontrolcarterasgenerales.setnombre_zona(cobrarcontrolcarterasgenerales.getnombre_zona().trim());
		cobrarcontrolcarterasgenerales.setnombre_vendedor(cobrarcontrolcarterasgenerales.getnombre_vendedor().trim());
		cobrarcontrolcarterasgenerales.setcodigo(cobrarcontrolcarterasgenerales.getcodigo().trim());
		cobrarcontrolcarterasgenerales.setnombre_completo(cobrarcontrolcarterasgenerales.getnombre_completo().trim());
		cobrarcontrolcarterasgenerales.setrepresentante(cobrarcontrolcarterasgenerales.getrepresentante().trim());
		cobrarcontrolcarterasgenerales.setnumero_comprobante(cobrarcontrolcarterasgenerales.getnumero_comprobante().trim());
		cobrarcontrolcarterasgenerales.setnumero_factura(cobrarcontrolcarterasgenerales.getnumero_factura().trim());
		cobrarcontrolcarterasgenerales.setdireccion_direccion(cobrarcontrolcarterasgenerales.getdireccion_direccion().trim());
		cobrarcontrolcarterasgenerales.settelefono_telefono(cobrarcontrolcarterasgenerales.gettelefono_telefono().trim());
	}
	
	public static void quitarEspaciosCobrarControlCarterasGeneraless(List<CobrarControlCarterasGenerales> cobrarcontrolcarterasgeneraless,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CobrarControlCarterasGenerales cobrarcontrolcarterasgenerales: cobrarcontrolcarterasgeneraless) {
			cobrarcontrolcarterasgenerales.setnombre_ciudad(cobrarcontrolcarterasgenerales.getnombre_ciudad().trim());
			cobrarcontrolcarterasgenerales.setnombre_zona(cobrarcontrolcarterasgenerales.getnombre_zona().trim());
			cobrarcontrolcarterasgenerales.setnombre_vendedor(cobrarcontrolcarterasgenerales.getnombre_vendedor().trim());
			cobrarcontrolcarterasgenerales.setcodigo(cobrarcontrolcarterasgenerales.getcodigo().trim());
			cobrarcontrolcarterasgenerales.setnombre_completo(cobrarcontrolcarterasgenerales.getnombre_completo().trim());
			cobrarcontrolcarterasgenerales.setrepresentante(cobrarcontrolcarterasgenerales.getrepresentante().trim());
			cobrarcontrolcarterasgenerales.setnumero_comprobante(cobrarcontrolcarterasgenerales.getnumero_comprobante().trim());
			cobrarcontrolcarterasgenerales.setnumero_factura(cobrarcontrolcarterasgenerales.getnumero_factura().trim());
			cobrarcontrolcarterasgenerales.setdireccion_direccion(cobrarcontrolcarterasgenerales.getdireccion_direccion().trim());
			cobrarcontrolcarterasgenerales.settelefono_telefono(cobrarcontrolcarterasgenerales.gettelefono_telefono().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCobrarControlCarterasGenerales(CobrarControlCarterasGenerales cobrarcontrolcarterasgenerales,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && cobrarcontrolcarterasgenerales.getConCambioAuxiliar()) {
			cobrarcontrolcarterasgenerales.setIsDeleted(cobrarcontrolcarterasgenerales.getIsDeletedAuxiliar());	
			cobrarcontrolcarterasgenerales.setIsNew(cobrarcontrolcarterasgenerales.getIsNewAuxiliar());	
			cobrarcontrolcarterasgenerales.setIsChanged(cobrarcontrolcarterasgenerales.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			cobrarcontrolcarterasgenerales.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			cobrarcontrolcarterasgenerales.setIsDeletedAuxiliar(false);	
			cobrarcontrolcarterasgenerales.setIsNewAuxiliar(false);	
			cobrarcontrolcarterasgenerales.setIsChangedAuxiliar(false);
			
			cobrarcontrolcarterasgenerales.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCobrarControlCarterasGeneraless(List<CobrarControlCarterasGenerales> cobrarcontrolcarterasgeneraless,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(CobrarControlCarterasGenerales cobrarcontrolcarterasgenerales : cobrarcontrolcarterasgeneraless) {
			if(conAsignarBase && cobrarcontrolcarterasgenerales.getConCambioAuxiliar()) {
				cobrarcontrolcarterasgenerales.setIsDeleted(cobrarcontrolcarterasgenerales.getIsDeletedAuxiliar());	
				cobrarcontrolcarterasgenerales.setIsNew(cobrarcontrolcarterasgenerales.getIsNewAuxiliar());	
				cobrarcontrolcarterasgenerales.setIsChanged(cobrarcontrolcarterasgenerales.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				cobrarcontrolcarterasgenerales.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				cobrarcontrolcarterasgenerales.setIsDeletedAuxiliar(false);	
				cobrarcontrolcarterasgenerales.setIsNewAuxiliar(false);	
				cobrarcontrolcarterasgenerales.setIsChangedAuxiliar(false);
				
				cobrarcontrolcarterasgenerales.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCobrarControlCarterasGenerales(CobrarControlCarterasGenerales cobrarcontrolcarterasgenerales,Boolean conEnteros) throws Exception  {
		cobrarcontrolcarterasgenerales.setlimite_credito(0.0);
		cobrarcontrolcarterasgenerales.setsaldo(0.0);
		cobrarcontrolcarterasgenerales.setdebito_mone_local(0.0);
		cobrarcontrolcarterasgenerales.setcredito_mone_local(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			cobrarcontrolcarterasgenerales.setdia_pago(0);
			cobrarcontrolcarterasgenerales.setdias(0);
		}
	}		
	
	public static void InicializarValoresCobrarControlCarterasGeneraless(List<CobrarControlCarterasGenerales> cobrarcontrolcarterasgeneraless,Boolean conEnteros) throws Exception  {
		
		for(CobrarControlCarterasGenerales cobrarcontrolcarterasgenerales: cobrarcontrolcarterasgeneraless) {
			cobrarcontrolcarterasgenerales.setlimite_credito(0.0);
			cobrarcontrolcarterasgenerales.setsaldo(0.0);
			cobrarcontrolcarterasgenerales.setdebito_mone_local(0.0);
			cobrarcontrolcarterasgenerales.setcredito_mone_local(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				cobrarcontrolcarterasgenerales.setdia_pago(0);
				cobrarcontrolcarterasgenerales.setdias(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaCobrarControlCarterasGenerales(List<CobrarControlCarterasGenerales> cobrarcontrolcarterasgeneraless,CobrarControlCarterasGenerales cobrarcontrolcarterasgeneralesAux) throws Exception  {
		CobrarControlCarterasGeneralesConstantesFunciones.InicializarValoresCobrarControlCarterasGenerales(cobrarcontrolcarterasgeneralesAux,true);
		
		for(CobrarControlCarterasGenerales cobrarcontrolcarterasgenerales: cobrarcontrolcarterasgeneraless) {
			if(cobrarcontrolcarterasgenerales.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			cobrarcontrolcarterasgeneralesAux.setlimite_credito(cobrarcontrolcarterasgeneralesAux.getlimite_credito()+cobrarcontrolcarterasgenerales.getlimite_credito());			
			cobrarcontrolcarterasgeneralesAux.setdia_pago(cobrarcontrolcarterasgeneralesAux.getdia_pago()+cobrarcontrolcarterasgenerales.getdia_pago());			
			cobrarcontrolcarterasgeneralesAux.setdias(cobrarcontrolcarterasgeneralesAux.getdias()+cobrarcontrolcarterasgenerales.getdias());			
			cobrarcontrolcarterasgeneralesAux.setsaldo(cobrarcontrolcarterasgeneralesAux.getsaldo()+cobrarcontrolcarterasgenerales.getsaldo());			
			cobrarcontrolcarterasgeneralesAux.setdebito_mone_local(cobrarcontrolcarterasgeneralesAux.getdebito_mone_local()+cobrarcontrolcarterasgenerales.getdebito_mone_local());			
			cobrarcontrolcarterasgeneralesAux.setcredito_mone_local(cobrarcontrolcarterasgeneralesAux.getcredito_mone_local()+cobrarcontrolcarterasgenerales.getcredito_mone_local());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCobrarControlCarterasGenerales(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CobrarControlCarterasGeneralesConstantesFunciones.getArrayColumnasGlobalesCobrarControlCarterasGenerales(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCobrarControlCarterasGenerales(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CobrarControlCarterasGeneralesConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CobrarControlCarterasGeneralesConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCobrarControlCarterasGenerales(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CobrarControlCarterasGenerales> cobrarcontrolcarterasgeneraless,CobrarControlCarterasGenerales cobrarcontrolcarterasgenerales,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CobrarControlCarterasGenerales cobrarcontrolcarterasgeneralesAux: cobrarcontrolcarterasgeneraless) {
			if(cobrarcontrolcarterasgeneralesAux!=null && cobrarcontrolcarterasgenerales!=null) {
				if((cobrarcontrolcarterasgeneralesAux.getId()==null && cobrarcontrolcarterasgenerales.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(cobrarcontrolcarterasgeneralesAux.getId()!=null && cobrarcontrolcarterasgenerales.getId()!=null){
					if(cobrarcontrolcarterasgeneralesAux.getId().equals(cobrarcontrolcarterasgenerales.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCobrarControlCarterasGenerales(List<CobrarControlCarterasGenerales> cobrarcontrolcarterasgeneraless) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double limite_creditoTotal=0.0;
		Double saldoTotal=0.0;
		Double debito_mone_localTotal=0.0;
		Double credito_mone_localTotal=0.0;
	
		for(CobrarControlCarterasGenerales cobrarcontrolcarterasgenerales: cobrarcontrolcarterasgeneraless) {			
			if(cobrarcontrolcarterasgenerales.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			limite_creditoTotal+=cobrarcontrolcarterasgenerales.getlimite_credito();
			saldoTotal+=cobrarcontrolcarterasgenerales.getsaldo();
			debito_mone_localTotal+=cobrarcontrolcarterasgenerales.getdebito_mone_local();
			credito_mone_localTotal+=cobrarcontrolcarterasgenerales.getcredito_mone_local();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CobrarControlCarterasGeneralesConstantesFunciones.LIMITECREDITO);
		datoGeneral.setsDescripcion(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_LIMITECREDITO);
		datoGeneral.setdValorDouble(limite_creditoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CobrarControlCarterasGeneralesConstantesFunciones.SALDO);
		datoGeneral.setsDescripcion(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_SALDO);
		datoGeneral.setdValorDouble(saldoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CobrarControlCarterasGeneralesConstantesFunciones.DEBITOMONELOCAL);
		datoGeneral.setsDescripcion(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_DEBITOMONELOCAL);
		datoGeneral.setdValorDouble(debito_mone_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CobrarControlCarterasGeneralesConstantesFunciones.CREDITOMONELOCAL);
		datoGeneral.setsDescripcion(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_CREDITOMONELOCAL);
		datoGeneral.setdValorDouble(credito_mone_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCobrarControlCarterasGenerales() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CobrarControlCarterasGeneralesConstantesFunciones.LABEL_ID, CobrarControlCarterasGeneralesConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarControlCarterasGeneralesConstantesFunciones.LABEL_VERSIONROW, CobrarControlCarterasGeneralesConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarControlCarterasGeneralesConstantesFunciones.LABEL_NOMBRECIUDAD, CobrarControlCarterasGeneralesConstantesFunciones.NOMBRECIUDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarControlCarterasGeneralesConstantesFunciones.LABEL_NOMBREZONA, CobrarControlCarterasGeneralesConstantesFunciones.NOMBREZONA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarControlCarterasGeneralesConstantesFunciones.LABEL_NOMBREVENDEDOR, CobrarControlCarterasGeneralesConstantesFunciones.NOMBREVENDEDOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarControlCarterasGeneralesConstantesFunciones.LABEL_CODIGO, CobrarControlCarterasGeneralesConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarControlCarterasGeneralesConstantesFunciones.LABEL_NOMBRECOMPLETO, CobrarControlCarterasGeneralesConstantesFunciones.NOMBRECOMPLETO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarControlCarterasGeneralesConstantesFunciones.LABEL_LIMITECREDITO, CobrarControlCarterasGeneralesConstantesFunciones.LIMITECREDITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarControlCarterasGeneralesConstantesFunciones.LABEL_REPRESENTANTE, CobrarControlCarterasGeneralesConstantesFunciones.REPRESENTANTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarControlCarterasGeneralesConstantesFunciones.LABEL_DIAPAGO, CobrarControlCarterasGeneralesConstantesFunciones.DIAPAGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarControlCarterasGeneralesConstantesFunciones.LABEL_NUMEROCOMPROBANTE, CobrarControlCarterasGeneralesConstantesFunciones.NUMEROCOMPROBANTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarControlCarterasGeneralesConstantesFunciones.LABEL_NUMEROFACTURA, CobrarControlCarterasGeneralesConstantesFunciones.NUMEROFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarControlCarterasGeneralesConstantesFunciones.LABEL_DIRECCIONDIRECCION, CobrarControlCarterasGeneralesConstantesFunciones.DIRECCIONDIRECCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarControlCarterasGeneralesConstantesFunciones.LABEL_TELEFONOTELEFONO, CobrarControlCarterasGeneralesConstantesFunciones.TELEFONOTELEFONO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarControlCarterasGeneralesConstantesFunciones.LABEL_FECHAEMISIO, CobrarControlCarterasGeneralesConstantesFunciones.FECHAEMISIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarControlCarterasGeneralesConstantesFunciones.LABEL_FECHAVENCE, CobrarControlCarterasGeneralesConstantesFunciones.FECHAVENCE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarControlCarterasGeneralesConstantesFunciones.LABEL_DIAS, CobrarControlCarterasGeneralesConstantesFunciones.DIAS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarControlCarterasGeneralesConstantesFunciones.LABEL_SALDO, CobrarControlCarterasGeneralesConstantesFunciones.SALDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarControlCarterasGeneralesConstantesFunciones.LABEL_DEBITOMONELOCAL, CobrarControlCarterasGeneralesConstantesFunciones.DEBITOMONELOCAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarControlCarterasGeneralesConstantesFunciones.LABEL_CREDITOMONELOCAL, CobrarControlCarterasGeneralesConstantesFunciones.CREDITOMONELOCAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarControlCarterasGeneralesConstantesFunciones.LABEL_HORAPAGO, CobrarControlCarterasGeneralesConstantesFunciones.HORAPAGO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCobrarControlCarterasGenerales() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CobrarControlCarterasGeneralesConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarControlCarterasGeneralesConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarControlCarterasGeneralesConstantesFunciones.NOMBRECIUDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarControlCarterasGeneralesConstantesFunciones.NOMBREZONA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarControlCarterasGeneralesConstantesFunciones.NOMBREVENDEDOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarControlCarterasGeneralesConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarControlCarterasGeneralesConstantesFunciones.NOMBRECOMPLETO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarControlCarterasGeneralesConstantesFunciones.LIMITECREDITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarControlCarterasGeneralesConstantesFunciones.REPRESENTANTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarControlCarterasGeneralesConstantesFunciones.DIAPAGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarControlCarterasGeneralesConstantesFunciones.NUMEROCOMPROBANTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarControlCarterasGeneralesConstantesFunciones.NUMEROFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarControlCarterasGeneralesConstantesFunciones.DIRECCIONDIRECCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarControlCarterasGeneralesConstantesFunciones.TELEFONOTELEFONO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarControlCarterasGeneralesConstantesFunciones.FECHAEMISIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarControlCarterasGeneralesConstantesFunciones.FECHAVENCE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarControlCarterasGeneralesConstantesFunciones.DIAS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarControlCarterasGeneralesConstantesFunciones.SALDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarControlCarterasGeneralesConstantesFunciones.DEBITOMONELOCAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarControlCarterasGeneralesConstantesFunciones.CREDITOMONELOCAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarControlCarterasGeneralesConstantesFunciones.HORAPAGO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCobrarControlCarterasGenerales() throws Exception  {
		return CobrarControlCarterasGeneralesConstantesFunciones.getTiposSeleccionarCobrarControlCarterasGenerales(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCobrarControlCarterasGenerales(Boolean conFk) throws Exception  {
		return CobrarControlCarterasGeneralesConstantesFunciones.getTiposSeleccionarCobrarControlCarterasGenerales(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCobrarControlCarterasGenerales(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_FECHAEMISIONHASTA);
			reporte.setsDescripcion(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_FECHAEMISIONHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_NOMBRECIUDAD);
			reporte.setsDescripcion(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_NOMBRECIUDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_NOMBREZONA);
			reporte.setsDescripcion(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_NOMBREZONA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_NOMBREVENDEDOR);
			reporte.setsDescripcion(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_NOMBREVENDEDOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_NOMBRECOMPLETO);
			reporte.setsDescripcion(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_NOMBRECOMPLETO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_LIMITECREDITO);
			reporte.setsDescripcion(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_LIMITECREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_REPRESENTANTE);
			reporte.setsDescripcion(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_REPRESENTANTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_DIAPAGO);
			reporte.setsDescripcion(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_DIAPAGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_NUMEROCOMPROBANTE);
			reporte.setsDescripcion(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_NUMEROCOMPROBANTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_NUMEROFACTURA);
			reporte.setsDescripcion(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_NUMEROFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_DIRECCIONDIRECCION);
			reporte.setsDescripcion(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_DIRECCIONDIRECCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_TELEFONOTELEFONO);
			reporte.setsDescripcion(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_TELEFONOTELEFONO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_FECHAEMISIO);
			reporte.setsDescripcion(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_FECHAEMISIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_FECHAVENCE);
			reporte.setsDescripcion(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_FECHAVENCE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_DIAS);
			reporte.setsDescripcion(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_DIAS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_SALDO);
			reporte.setsDescripcion(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_SALDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_DEBITOMONELOCAL);
			reporte.setsDescripcion(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_DEBITOMONELOCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_CREDITOMONELOCAL);
			reporte.setsDescripcion(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_CREDITOMONELOCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		reporte=new Reporte();
		reporte.setsCodigo(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_HORAPAGO);
		reporte.setsDescripcion(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_HORAPAGO);

		arrTiposSeleccionarTodos.add(reporte);
		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCobrarControlCarterasGenerales(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCobrarControlCarterasGenerales(CobrarControlCarterasGenerales cobrarcontrolcarterasgeneralesAux) throws Exception {
		
			cobrarcontrolcarterasgeneralesAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cobrarcontrolcarterasgeneralesAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesCobrarControlCarterasGenerales(List<CobrarControlCarterasGenerales> cobrarcontrolcarterasgeneralessTemp) throws Exception {
		for(CobrarControlCarterasGenerales cobrarcontrolcarterasgeneralesAux:cobrarcontrolcarterasgeneralessTemp) {
			
			cobrarcontrolcarterasgeneralesAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cobrarcontrolcarterasgeneralesAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCobrarControlCarterasGenerales(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCobrarControlCarterasGenerales(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfCobrarControlCarterasGenerales(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CobrarControlCarterasGeneralesConstantesFunciones.getClassesRelationshipsOfCobrarControlCarterasGenerales(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCobrarControlCarterasGenerales(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCobrarControlCarterasGenerales(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CobrarControlCarterasGeneralesConstantesFunciones.getClassesRelationshipsFromStringsOfCobrarControlCarterasGenerales(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCobrarControlCarterasGenerales(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(CobrarControlCarterasGenerales cobrarcontrolcarterasgenerales,List<CobrarControlCarterasGenerales> cobrarcontrolcarterasgeneraless,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(CobrarControlCarterasGenerales cobrarcontrolcarterasgenerales,List<CobrarControlCarterasGenerales> cobrarcontrolcarterasgeneraless) throws Exception {
		try	{			
			for(CobrarControlCarterasGenerales cobrarcontrolcarterasgeneralesLocal:cobrarcontrolcarterasgeneraless) {
				if(cobrarcontrolcarterasgeneralesLocal.getId().equals(cobrarcontrolcarterasgenerales.getId())) {
					cobrarcontrolcarterasgeneralesLocal.setIsSelected(cobrarcontrolcarterasgenerales.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCobrarControlCarterasGenerales(List<CobrarControlCarterasGenerales> cobrarcontrolcarterasgeneralessAux) throws Exception {
		//this.cobrarcontrolcarterasgeneralessAux=cobrarcontrolcarterasgeneralessAux;
		
		for(CobrarControlCarterasGenerales cobrarcontrolcarterasgeneralesAux:cobrarcontrolcarterasgeneralessAux) {
			if(cobrarcontrolcarterasgeneralesAux.getIsChanged()) {
				cobrarcontrolcarterasgeneralesAux.setIsChanged(false);
			}		
			
			if(cobrarcontrolcarterasgeneralesAux.getIsNew()) {
				cobrarcontrolcarterasgeneralesAux.setIsNew(false);
			}	
			
			if(cobrarcontrolcarterasgeneralesAux.getIsDeleted()) {
				cobrarcontrolcarterasgeneralesAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCobrarControlCarterasGenerales(CobrarControlCarterasGenerales cobrarcontrolcarterasgeneralesAux) throws Exception {
		//this.cobrarcontrolcarterasgeneralesAux=cobrarcontrolcarterasgeneralesAux;
		
			if(cobrarcontrolcarterasgeneralesAux.getIsChanged()) {
				cobrarcontrolcarterasgeneralesAux.setIsChanged(false);
			}		
			
			if(cobrarcontrolcarterasgeneralesAux.getIsNew()) {
				cobrarcontrolcarterasgeneralesAux.setIsNew(false);
			}	
			
			if(cobrarcontrolcarterasgeneralesAux.getIsDeleted()) {
				cobrarcontrolcarterasgeneralesAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(CobrarControlCarterasGenerales cobrarcontrolcarterasgeneralesAsignar,CobrarControlCarterasGenerales cobrarcontrolcarterasgenerales) throws Exception {
		cobrarcontrolcarterasgeneralesAsignar.setId(cobrarcontrolcarterasgenerales.getId());	
		cobrarcontrolcarterasgeneralesAsignar.setVersionRow(cobrarcontrolcarterasgenerales.getVersionRow());	
		cobrarcontrolcarterasgeneralesAsignar.setnombre_ciudad(cobrarcontrolcarterasgenerales.getnombre_ciudad());	
		cobrarcontrolcarterasgeneralesAsignar.setnombre_zona(cobrarcontrolcarterasgenerales.getnombre_zona());	
		cobrarcontrolcarterasgeneralesAsignar.setnombre_vendedor(cobrarcontrolcarterasgenerales.getnombre_vendedor());	
		cobrarcontrolcarterasgeneralesAsignar.setcodigo(cobrarcontrolcarterasgenerales.getcodigo());	
		cobrarcontrolcarterasgeneralesAsignar.setnombre_completo(cobrarcontrolcarterasgenerales.getnombre_completo());	
		cobrarcontrolcarterasgeneralesAsignar.setlimite_credito(cobrarcontrolcarterasgenerales.getlimite_credito());	
		cobrarcontrolcarterasgeneralesAsignar.setrepresentante(cobrarcontrolcarterasgenerales.getrepresentante());	
		cobrarcontrolcarterasgeneralesAsignar.setdia_pago(cobrarcontrolcarterasgenerales.getdia_pago());	
		cobrarcontrolcarterasgeneralesAsignar.setnumero_comprobante(cobrarcontrolcarterasgenerales.getnumero_comprobante());	
		cobrarcontrolcarterasgeneralesAsignar.setnumero_factura(cobrarcontrolcarterasgenerales.getnumero_factura());	
		cobrarcontrolcarterasgeneralesAsignar.setdireccion_direccion(cobrarcontrolcarterasgenerales.getdireccion_direccion());	
		cobrarcontrolcarterasgeneralesAsignar.settelefono_telefono(cobrarcontrolcarterasgenerales.gettelefono_telefono());	
		cobrarcontrolcarterasgeneralesAsignar.setfecha_emisio(cobrarcontrolcarterasgenerales.getfecha_emisio());	
		cobrarcontrolcarterasgeneralesAsignar.setfecha_vence(cobrarcontrolcarterasgenerales.getfecha_vence());	
		cobrarcontrolcarterasgeneralesAsignar.setdias(cobrarcontrolcarterasgenerales.getdias());	
		cobrarcontrolcarterasgeneralesAsignar.setsaldo(cobrarcontrolcarterasgenerales.getsaldo());	
		cobrarcontrolcarterasgeneralesAsignar.setdebito_mone_local(cobrarcontrolcarterasgenerales.getdebito_mone_local());	
		cobrarcontrolcarterasgeneralesAsignar.setcredito_mone_local(cobrarcontrolcarterasgenerales.getcredito_mone_local());	
		cobrarcontrolcarterasgeneralesAsignar.sethora_pago(cobrarcontrolcarterasgenerales.gethora_pago());	
	}
	
	public static void inicializarCobrarControlCarterasGenerales(CobrarControlCarterasGenerales cobrarcontrolcarterasgenerales) throws Exception {
		try {
				cobrarcontrolcarterasgenerales.setId(0L);	
					
				cobrarcontrolcarterasgenerales.setnombre_ciudad("");	
				cobrarcontrolcarterasgenerales.setnombre_zona("");	
				cobrarcontrolcarterasgenerales.setnombre_vendedor("");	
				cobrarcontrolcarterasgenerales.setcodigo("");	
				cobrarcontrolcarterasgenerales.setnombre_completo("");	
				cobrarcontrolcarterasgenerales.setlimite_credito(0.0);	
				cobrarcontrolcarterasgenerales.setrepresentante("");	
				cobrarcontrolcarterasgenerales.setdia_pago(0);	
				cobrarcontrolcarterasgenerales.setnumero_comprobante("");	
				cobrarcontrolcarterasgenerales.setnumero_factura("");	
				cobrarcontrolcarterasgenerales.setdireccion_direccion("");	
				cobrarcontrolcarterasgenerales.settelefono_telefono("");	
				cobrarcontrolcarterasgenerales.setfecha_emisio(new Date());	
				cobrarcontrolcarterasgenerales.setfecha_vence(new Date());	
				cobrarcontrolcarterasgenerales.setdias(0);	
				cobrarcontrolcarterasgenerales.setsaldo(0.0);	
				cobrarcontrolcarterasgenerales.setdebito_mone_local(0.0);	
				cobrarcontrolcarterasgenerales.setcredito_mone_local(0.0);	
				cobrarcontrolcarterasgenerales.sethora_pago(new Time((new Date()).getTime()));	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCobrarControlCarterasGenerales(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_FECHAEMISIONHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_NOMBRECIUDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_NOMBREZONA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_NOMBREVENDEDOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_NOMBRECOMPLETO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_LIMITECREDITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_REPRESENTANTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_DIAPAGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_NUMEROCOMPROBANTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_NUMEROFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_DIRECCIONDIRECCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_TELEFONOTELEFONO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_FECHAEMISIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_FECHAVENCE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_DIAS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_SALDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_DEBITOMONELOCAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_CREDITOMONELOCAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarControlCarterasGeneralesConstantesFunciones.LABEL_HORAPAGO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCobrarControlCarterasGenerales(String sTipo,Row row,Workbook workbook,CobrarControlCarterasGenerales cobrarcontrolcarterasgenerales,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarcontrolcarterasgenerales.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarcontrolcarterasgenerales.getfecha_emision_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarcontrolcarterasgenerales.getnombre_ciudad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarcontrolcarterasgenerales.getnombre_zona());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarcontrolcarterasgenerales.getnombre_vendedor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarcontrolcarterasgenerales.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarcontrolcarterasgenerales.getnombre_completo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarcontrolcarterasgenerales.getlimite_credito());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarcontrolcarterasgenerales.getrepresentante());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarcontrolcarterasgenerales.getdia_pago());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarcontrolcarterasgenerales.getnumero_comprobante());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarcontrolcarterasgenerales.getnumero_factura());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarcontrolcarterasgenerales.getdireccion_direccion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarcontrolcarterasgenerales.gettelefono_telefono());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarcontrolcarterasgenerales.getfecha_emisio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarcontrolcarterasgenerales.getfecha_vence());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarcontrolcarterasgenerales.getdias());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarcontrolcarterasgenerales.getsaldo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarcontrolcarterasgenerales.getdebito_mone_local());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarcontrolcarterasgenerales.getcredito_mone_local());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarcontrolcarterasgenerales.gethora_pago());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCobrarControlCarterasGenerales="";
	
	public String getsFinalQueryCobrarControlCarterasGenerales() {
		return this.sFinalQueryCobrarControlCarterasGenerales;
	}
	
	public void setsFinalQueryCobrarControlCarterasGenerales(String sFinalQueryCobrarControlCarterasGenerales) {
		this.sFinalQueryCobrarControlCarterasGenerales= sFinalQueryCobrarControlCarterasGenerales;
	}
	
	public Border resaltarSeleccionarCobrarControlCarterasGenerales=null;
	
	public Border setResaltarSeleccionarCobrarControlCarterasGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarControlCarterasGeneralesBeanSwingJInternalFrame cobrarcontrolcarterasgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//cobrarcontrolcarterasgeneralesBeanSwingJInternalFrame.jTtoolBarCobrarControlCarterasGenerales.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCobrarControlCarterasGenerales= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCobrarControlCarterasGenerales() {
		return this.resaltarSeleccionarCobrarControlCarterasGenerales;
	}
	
	public void setResaltarSeleccionarCobrarControlCarterasGenerales(Border borderResaltarSeleccionarCobrarControlCarterasGenerales) {
		this.resaltarSeleccionarCobrarControlCarterasGenerales= borderResaltarSeleccionarCobrarControlCarterasGenerales;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCobrarControlCarterasGenerales=null;
	public Boolean mostraridCobrarControlCarterasGenerales=true;
	public Boolean activaridCobrarControlCarterasGenerales=true;

	public Border resaltarid_empresaCobrarControlCarterasGenerales=null;
	public Boolean mostrarid_empresaCobrarControlCarterasGenerales=true;
	public Boolean activarid_empresaCobrarControlCarterasGenerales=true;
	public Boolean cargarid_empresaCobrarControlCarterasGenerales=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaCobrarControlCarterasGenerales=false;//ConEventDepend=true

	public Border resaltarfecha_emision_hastaCobrarControlCarterasGenerales=null;
	public Boolean mostrarfecha_emision_hastaCobrarControlCarterasGenerales=true;
	public Boolean activarfecha_emision_hastaCobrarControlCarterasGenerales=true;

	public Border resaltarnombre_ciudadCobrarControlCarterasGenerales=null;
	public Boolean mostrarnombre_ciudadCobrarControlCarterasGenerales=true;
	public Boolean activarnombre_ciudadCobrarControlCarterasGenerales=true;

	public Border resaltarnombre_zonaCobrarControlCarterasGenerales=null;
	public Boolean mostrarnombre_zonaCobrarControlCarterasGenerales=true;
	public Boolean activarnombre_zonaCobrarControlCarterasGenerales=true;

	public Border resaltarnombre_vendedorCobrarControlCarterasGenerales=null;
	public Boolean mostrarnombre_vendedorCobrarControlCarterasGenerales=true;
	public Boolean activarnombre_vendedorCobrarControlCarterasGenerales=true;

	public Border resaltarcodigoCobrarControlCarterasGenerales=null;
	public Boolean mostrarcodigoCobrarControlCarterasGenerales=true;
	public Boolean activarcodigoCobrarControlCarterasGenerales=true;

	public Border resaltarnombre_completoCobrarControlCarterasGenerales=null;
	public Boolean mostrarnombre_completoCobrarControlCarterasGenerales=true;
	public Boolean activarnombre_completoCobrarControlCarterasGenerales=true;

	public Border resaltarlimite_creditoCobrarControlCarterasGenerales=null;
	public Boolean mostrarlimite_creditoCobrarControlCarterasGenerales=true;
	public Boolean activarlimite_creditoCobrarControlCarterasGenerales=true;

	public Border resaltarrepresentanteCobrarControlCarterasGenerales=null;
	public Boolean mostrarrepresentanteCobrarControlCarterasGenerales=true;
	public Boolean activarrepresentanteCobrarControlCarterasGenerales=true;

	public Border resaltardia_pagoCobrarControlCarterasGenerales=null;
	public Boolean mostrardia_pagoCobrarControlCarterasGenerales=true;
	public Boolean activardia_pagoCobrarControlCarterasGenerales=true;

	public Border resaltarnumero_comprobanteCobrarControlCarterasGenerales=null;
	public Boolean mostrarnumero_comprobanteCobrarControlCarterasGenerales=true;
	public Boolean activarnumero_comprobanteCobrarControlCarterasGenerales=true;

	public Border resaltarnumero_facturaCobrarControlCarterasGenerales=null;
	public Boolean mostrarnumero_facturaCobrarControlCarterasGenerales=true;
	public Boolean activarnumero_facturaCobrarControlCarterasGenerales=true;

	public Border resaltardireccion_direccionCobrarControlCarterasGenerales=null;
	public Boolean mostrardireccion_direccionCobrarControlCarterasGenerales=true;
	public Boolean activardireccion_direccionCobrarControlCarterasGenerales=true;

	public Border resaltartelefono_telefonoCobrarControlCarterasGenerales=null;
	public Boolean mostrartelefono_telefonoCobrarControlCarterasGenerales=true;
	public Boolean activartelefono_telefonoCobrarControlCarterasGenerales=true;

	public Border resaltarfecha_emisioCobrarControlCarterasGenerales=null;
	public Boolean mostrarfecha_emisioCobrarControlCarterasGenerales=true;
	public Boolean activarfecha_emisioCobrarControlCarterasGenerales=true;

	public Border resaltarfecha_venceCobrarControlCarterasGenerales=null;
	public Boolean mostrarfecha_venceCobrarControlCarterasGenerales=true;
	public Boolean activarfecha_venceCobrarControlCarterasGenerales=true;

	public Border resaltardiasCobrarControlCarterasGenerales=null;
	public Boolean mostrardiasCobrarControlCarterasGenerales=true;
	public Boolean activardiasCobrarControlCarterasGenerales=true;

	public Border resaltarsaldoCobrarControlCarterasGenerales=null;
	public Boolean mostrarsaldoCobrarControlCarterasGenerales=true;
	public Boolean activarsaldoCobrarControlCarterasGenerales=true;

	public Border resaltardebito_mone_localCobrarControlCarterasGenerales=null;
	public Boolean mostrardebito_mone_localCobrarControlCarterasGenerales=true;
	public Boolean activardebito_mone_localCobrarControlCarterasGenerales=true;

	public Border resaltarcredito_mone_localCobrarControlCarterasGenerales=null;
	public Boolean mostrarcredito_mone_localCobrarControlCarterasGenerales=true;
	public Boolean activarcredito_mone_localCobrarControlCarterasGenerales=true;

	public Border resaltarhora_pagoCobrarControlCarterasGenerales=null;
	public Boolean mostrarhora_pagoCobrarControlCarterasGenerales=true;
	public Boolean activarhora_pagoCobrarControlCarterasGenerales=true;

	
	

	public Border setResaltaridCobrarControlCarterasGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarControlCarterasGeneralesBeanSwingJInternalFrame cobrarcontrolcarterasgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarcontrolcarterasgeneralesBeanSwingJInternalFrame.jTtoolBarCobrarControlCarterasGenerales.setBorder(borderResaltar);
		
		this.resaltaridCobrarControlCarterasGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCobrarControlCarterasGenerales() {
		return this.resaltaridCobrarControlCarterasGenerales;
	}

	public void setResaltaridCobrarControlCarterasGenerales(Border borderResaltar) {
		this.resaltaridCobrarControlCarterasGenerales= borderResaltar;
	}

	public Boolean getMostraridCobrarControlCarterasGenerales() {
		return this.mostraridCobrarControlCarterasGenerales;
	}

	public void setMostraridCobrarControlCarterasGenerales(Boolean mostraridCobrarControlCarterasGenerales) {
		this.mostraridCobrarControlCarterasGenerales= mostraridCobrarControlCarterasGenerales;
	}

	public Boolean getActivaridCobrarControlCarterasGenerales() {
		return this.activaridCobrarControlCarterasGenerales;
	}

	public void setActivaridCobrarControlCarterasGenerales(Boolean activaridCobrarControlCarterasGenerales) {
		this.activaridCobrarControlCarterasGenerales= activaridCobrarControlCarterasGenerales;
	}

	public Border setResaltarid_empresaCobrarControlCarterasGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarControlCarterasGeneralesBeanSwingJInternalFrame cobrarcontrolcarterasgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarcontrolcarterasgeneralesBeanSwingJInternalFrame.jTtoolBarCobrarControlCarterasGenerales.setBorder(borderResaltar);
		
		this.resaltarid_empresaCobrarControlCarterasGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaCobrarControlCarterasGenerales() {
		return this.resaltarid_empresaCobrarControlCarterasGenerales;
	}

	public void setResaltarid_empresaCobrarControlCarterasGenerales(Border borderResaltar) {
		this.resaltarid_empresaCobrarControlCarterasGenerales= borderResaltar;
	}

	public Boolean getMostrarid_empresaCobrarControlCarterasGenerales() {
		return this.mostrarid_empresaCobrarControlCarterasGenerales;
	}

	public void setMostrarid_empresaCobrarControlCarterasGenerales(Boolean mostrarid_empresaCobrarControlCarterasGenerales) {
		this.mostrarid_empresaCobrarControlCarterasGenerales= mostrarid_empresaCobrarControlCarterasGenerales;
	}

	public Boolean getActivarid_empresaCobrarControlCarterasGenerales() {
		return this.activarid_empresaCobrarControlCarterasGenerales;
	}

	public void setActivarid_empresaCobrarControlCarterasGenerales(Boolean activarid_empresaCobrarControlCarterasGenerales) {
		this.activarid_empresaCobrarControlCarterasGenerales= activarid_empresaCobrarControlCarterasGenerales;
	}

	public Boolean getCargarid_empresaCobrarControlCarterasGenerales() {
		return this.cargarid_empresaCobrarControlCarterasGenerales;
	}

	public void setCargarid_empresaCobrarControlCarterasGenerales(Boolean cargarid_empresaCobrarControlCarterasGenerales) {
		this.cargarid_empresaCobrarControlCarterasGenerales= cargarid_empresaCobrarControlCarterasGenerales;
	}

	public Border setResaltarfecha_emision_hastaCobrarControlCarterasGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarControlCarterasGeneralesBeanSwingJInternalFrame cobrarcontrolcarterasgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarcontrolcarterasgeneralesBeanSwingJInternalFrame.jTtoolBarCobrarControlCarterasGenerales.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_hastaCobrarControlCarterasGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_hastaCobrarControlCarterasGenerales() {
		return this.resaltarfecha_emision_hastaCobrarControlCarterasGenerales;
	}

	public void setResaltarfecha_emision_hastaCobrarControlCarterasGenerales(Border borderResaltar) {
		this.resaltarfecha_emision_hastaCobrarControlCarterasGenerales= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_hastaCobrarControlCarterasGenerales() {
		return this.mostrarfecha_emision_hastaCobrarControlCarterasGenerales;
	}

	public void setMostrarfecha_emision_hastaCobrarControlCarterasGenerales(Boolean mostrarfecha_emision_hastaCobrarControlCarterasGenerales) {
		this.mostrarfecha_emision_hastaCobrarControlCarterasGenerales= mostrarfecha_emision_hastaCobrarControlCarterasGenerales;
	}

	public Boolean getActivarfecha_emision_hastaCobrarControlCarterasGenerales() {
		return this.activarfecha_emision_hastaCobrarControlCarterasGenerales;
	}

	public void setActivarfecha_emision_hastaCobrarControlCarterasGenerales(Boolean activarfecha_emision_hastaCobrarControlCarterasGenerales) {
		this.activarfecha_emision_hastaCobrarControlCarterasGenerales= activarfecha_emision_hastaCobrarControlCarterasGenerales;
	}

	public Border setResaltarnombre_ciudadCobrarControlCarterasGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarControlCarterasGeneralesBeanSwingJInternalFrame cobrarcontrolcarterasgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarcontrolcarterasgeneralesBeanSwingJInternalFrame.jTtoolBarCobrarControlCarterasGenerales.setBorder(borderResaltar);
		
		this.resaltarnombre_ciudadCobrarControlCarterasGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_ciudadCobrarControlCarterasGenerales() {
		return this.resaltarnombre_ciudadCobrarControlCarterasGenerales;
	}

	public void setResaltarnombre_ciudadCobrarControlCarterasGenerales(Border borderResaltar) {
		this.resaltarnombre_ciudadCobrarControlCarterasGenerales= borderResaltar;
	}

	public Boolean getMostrarnombre_ciudadCobrarControlCarterasGenerales() {
		return this.mostrarnombre_ciudadCobrarControlCarterasGenerales;
	}

	public void setMostrarnombre_ciudadCobrarControlCarterasGenerales(Boolean mostrarnombre_ciudadCobrarControlCarterasGenerales) {
		this.mostrarnombre_ciudadCobrarControlCarterasGenerales= mostrarnombre_ciudadCobrarControlCarterasGenerales;
	}

	public Boolean getActivarnombre_ciudadCobrarControlCarterasGenerales() {
		return this.activarnombre_ciudadCobrarControlCarterasGenerales;
	}

	public void setActivarnombre_ciudadCobrarControlCarterasGenerales(Boolean activarnombre_ciudadCobrarControlCarterasGenerales) {
		this.activarnombre_ciudadCobrarControlCarterasGenerales= activarnombre_ciudadCobrarControlCarterasGenerales;
	}

	public Border setResaltarnombre_zonaCobrarControlCarterasGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarControlCarterasGeneralesBeanSwingJInternalFrame cobrarcontrolcarterasgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarcontrolcarterasgeneralesBeanSwingJInternalFrame.jTtoolBarCobrarControlCarterasGenerales.setBorder(borderResaltar);
		
		this.resaltarnombre_zonaCobrarControlCarterasGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_zonaCobrarControlCarterasGenerales() {
		return this.resaltarnombre_zonaCobrarControlCarterasGenerales;
	}

	public void setResaltarnombre_zonaCobrarControlCarterasGenerales(Border borderResaltar) {
		this.resaltarnombre_zonaCobrarControlCarterasGenerales= borderResaltar;
	}

	public Boolean getMostrarnombre_zonaCobrarControlCarterasGenerales() {
		return this.mostrarnombre_zonaCobrarControlCarterasGenerales;
	}

	public void setMostrarnombre_zonaCobrarControlCarterasGenerales(Boolean mostrarnombre_zonaCobrarControlCarterasGenerales) {
		this.mostrarnombre_zonaCobrarControlCarterasGenerales= mostrarnombre_zonaCobrarControlCarterasGenerales;
	}

	public Boolean getActivarnombre_zonaCobrarControlCarterasGenerales() {
		return this.activarnombre_zonaCobrarControlCarterasGenerales;
	}

	public void setActivarnombre_zonaCobrarControlCarterasGenerales(Boolean activarnombre_zonaCobrarControlCarterasGenerales) {
		this.activarnombre_zonaCobrarControlCarterasGenerales= activarnombre_zonaCobrarControlCarterasGenerales;
	}

	public Border setResaltarnombre_vendedorCobrarControlCarterasGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarControlCarterasGeneralesBeanSwingJInternalFrame cobrarcontrolcarterasgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarcontrolcarterasgeneralesBeanSwingJInternalFrame.jTtoolBarCobrarControlCarterasGenerales.setBorder(borderResaltar);
		
		this.resaltarnombre_vendedorCobrarControlCarterasGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_vendedorCobrarControlCarterasGenerales() {
		return this.resaltarnombre_vendedorCobrarControlCarterasGenerales;
	}

	public void setResaltarnombre_vendedorCobrarControlCarterasGenerales(Border borderResaltar) {
		this.resaltarnombre_vendedorCobrarControlCarterasGenerales= borderResaltar;
	}

	public Boolean getMostrarnombre_vendedorCobrarControlCarterasGenerales() {
		return this.mostrarnombre_vendedorCobrarControlCarterasGenerales;
	}

	public void setMostrarnombre_vendedorCobrarControlCarterasGenerales(Boolean mostrarnombre_vendedorCobrarControlCarterasGenerales) {
		this.mostrarnombre_vendedorCobrarControlCarterasGenerales= mostrarnombre_vendedorCobrarControlCarterasGenerales;
	}

	public Boolean getActivarnombre_vendedorCobrarControlCarterasGenerales() {
		return this.activarnombre_vendedorCobrarControlCarterasGenerales;
	}

	public void setActivarnombre_vendedorCobrarControlCarterasGenerales(Boolean activarnombre_vendedorCobrarControlCarterasGenerales) {
		this.activarnombre_vendedorCobrarControlCarterasGenerales= activarnombre_vendedorCobrarControlCarterasGenerales;
	}

	public Border setResaltarcodigoCobrarControlCarterasGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarControlCarterasGeneralesBeanSwingJInternalFrame cobrarcontrolcarterasgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarcontrolcarterasgeneralesBeanSwingJInternalFrame.jTtoolBarCobrarControlCarterasGenerales.setBorder(borderResaltar);
		
		this.resaltarcodigoCobrarControlCarterasGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoCobrarControlCarterasGenerales() {
		return this.resaltarcodigoCobrarControlCarterasGenerales;
	}

	public void setResaltarcodigoCobrarControlCarterasGenerales(Border borderResaltar) {
		this.resaltarcodigoCobrarControlCarterasGenerales= borderResaltar;
	}

	public Boolean getMostrarcodigoCobrarControlCarterasGenerales() {
		return this.mostrarcodigoCobrarControlCarterasGenerales;
	}

	public void setMostrarcodigoCobrarControlCarterasGenerales(Boolean mostrarcodigoCobrarControlCarterasGenerales) {
		this.mostrarcodigoCobrarControlCarterasGenerales= mostrarcodigoCobrarControlCarterasGenerales;
	}

	public Boolean getActivarcodigoCobrarControlCarterasGenerales() {
		return this.activarcodigoCobrarControlCarterasGenerales;
	}

	public void setActivarcodigoCobrarControlCarterasGenerales(Boolean activarcodigoCobrarControlCarterasGenerales) {
		this.activarcodigoCobrarControlCarterasGenerales= activarcodigoCobrarControlCarterasGenerales;
	}

	public Border setResaltarnombre_completoCobrarControlCarterasGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarControlCarterasGeneralesBeanSwingJInternalFrame cobrarcontrolcarterasgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarcontrolcarterasgeneralesBeanSwingJInternalFrame.jTtoolBarCobrarControlCarterasGenerales.setBorder(borderResaltar);
		
		this.resaltarnombre_completoCobrarControlCarterasGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_completoCobrarControlCarterasGenerales() {
		return this.resaltarnombre_completoCobrarControlCarterasGenerales;
	}

	public void setResaltarnombre_completoCobrarControlCarterasGenerales(Border borderResaltar) {
		this.resaltarnombre_completoCobrarControlCarterasGenerales= borderResaltar;
	}

	public Boolean getMostrarnombre_completoCobrarControlCarterasGenerales() {
		return this.mostrarnombre_completoCobrarControlCarterasGenerales;
	}

	public void setMostrarnombre_completoCobrarControlCarterasGenerales(Boolean mostrarnombre_completoCobrarControlCarterasGenerales) {
		this.mostrarnombre_completoCobrarControlCarterasGenerales= mostrarnombre_completoCobrarControlCarterasGenerales;
	}

	public Boolean getActivarnombre_completoCobrarControlCarterasGenerales() {
		return this.activarnombre_completoCobrarControlCarterasGenerales;
	}

	public void setActivarnombre_completoCobrarControlCarterasGenerales(Boolean activarnombre_completoCobrarControlCarterasGenerales) {
		this.activarnombre_completoCobrarControlCarterasGenerales= activarnombre_completoCobrarControlCarterasGenerales;
	}

	public Border setResaltarlimite_creditoCobrarControlCarterasGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarControlCarterasGeneralesBeanSwingJInternalFrame cobrarcontrolcarterasgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarcontrolcarterasgeneralesBeanSwingJInternalFrame.jTtoolBarCobrarControlCarterasGenerales.setBorder(borderResaltar);
		
		this.resaltarlimite_creditoCobrarControlCarterasGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarlimite_creditoCobrarControlCarterasGenerales() {
		return this.resaltarlimite_creditoCobrarControlCarterasGenerales;
	}

	public void setResaltarlimite_creditoCobrarControlCarterasGenerales(Border borderResaltar) {
		this.resaltarlimite_creditoCobrarControlCarterasGenerales= borderResaltar;
	}

	public Boolean getMostrarlimite_creditoCobrarControlCarterasGenerales() {
		return this.mostrarlimite_creditoCobrarControlCarterasGenerales;
	}

	public void setMostrarlimite_creditoCobrarControlCarterasGenerales(Boolean mostrarlimite_creditoCobrarControlCarterasGenerales) {
		this.mostrarlimite_creditoCobrarControlCarterasGenerales= mostrarlimite_creditoCobrarControlCarterasGenerales;
	}

	public Boolean getActivarlimite_creditoCobrarControlCarterasGenerales() {
		return this.activarlimite_creditoCobrarControlCarterasGenerales;
	}

	public void setActivarlimite_creditoCobrarControlCarterasGenerales(Boolean activarlimite_creditoCobrarControlCarterasGenerales) {
		this.activarlimite_creditoCobrarControlCarterasGenerales= activarlimite_creditoCobrarControlCarterasGenerales;
	}

	public Border setResaltarrepresentanteCobrarControlCarterasGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarControlCarterasGeneralesBeanSwingJInternalFrame cobrarcontrolcarterasgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarcontrolcarterasgeneralesBeanSwingJInternalFrame.jTtoolBarCobrarControlCarterasGenerales.setBorder(borderResaltar);
		
		this.resaltarrepresentanteCobrarControlCarterasGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarrepresentanteCobrarControlCarterasGenerales() {
		return this.resaltarrepresentanteCobrarControlCarterasGenerales;
	}

	public void setResaltarrepresentanteCobrarControlCarterasGenerales(Border borderResaltar) {
		this.resaltarrepresentanteCobrarControlCarterasGenerales= borderResaltar;
	}

	public Boolean getMostrarrepresentanteCobrarControlCarterasGenerales() {
		return this.mostrarrepresentanteCobrarControlCarterasGenerales;
	}

	public void setMostrarrepresentanteCobrarControlCarterasGenerales(Boolean mostrarrepresentanteCobrarControlCarterasGenerales) {
		this.mostrarrepresentanteCobrarControlCarterasGenerales= mostrarrepresentanteCobrarControlCarterasGenerales;
	}

	public Boolean getActivarrepresentanteCobrarControlCarterasGenerales() {
		return this.activarrepresentanteCobrarControlCarterasGenerales;
	}

	public void setActivarrepresentanteCobrarControlCarterasGenerales(Boolean activarrepresentanteCobrarControlCarterasGenerales) {
		this.activarrepresentanteCobrarControlCarterasGenerales= activarrepresentanteCobrarControlCarterasGenerales;
	}

	public Border setResaltardia_pagoCobrarControlCarterasGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarControlCarterasGeneralesBeanSwingJInternalFrame cobrarcontrolcarterasgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarcontrolcarterasgeneralesBeanSwingJInternalFrame.jTtoolBarCobrarControlCarterasGenerales.setBorder(borderResaltar);
		
		this.resaltardia_pagoCobrarControlCarterasGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardia_pagoCobrarControlCarterasGenerales() {
		return this.resaltardia_pagoCobrarControlCarterasGenerales;
	}

	public void setResaltardia_pagoCobrarControlCarterasGenerales(Border borderResaltar) {
		this.resaltardia_pagoCobrarControlCarterasGenerales= borderResaltar;
	}

	public Boolean getMostrardia_pagoCobrarControlCarterasGenerales() {
		return this.mostrardia_pagoCobrarControlCarterasGenerales;
	}

	public void setMostrardia_pagoCobrarControlCarterasGenerales(Boolean mostrardia_pagoCobrarControlCarterasGenerales) {
		this.mostrardia_pagoCobrarControlCarterasGenerales= mostrardia_pagoCobrarControlCarterasGenerales;
	}

	public Boolean getActivardia_pagoCobrarControlCarterasGenerales() {
		return this.activardia_pagoCobrarControlCarterasGenerales;
	}

	public void setActivardia_pagoCobrarControlCarterasGenerales(Boolean activardia_pagoCobrarControlCarterasGenerales) {
		this.activardia_pagoCobrarControlCarterasGenerales= activardia_pagoCobrarControlCarterasGenerales;
	}

	public Border setResaltarnumero_comprobanteCobrarControlCarterasGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarControlCarterasGeneralesBeanSwingJInternalFrame cobrarcontrolcarterasgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarcontrolcarterasgeneralesBeanSwingJInternalFrame.jTtoolBarCobrarControlCarterasGenerales.setBorder(borderResaltar);
		
		this.resaltarnumero_comprobanteCobrarControlCarterasGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_comprobanteCobrarControlCarterasGenerales() {
		return this.resaltarnumero_comprobanteCobrarControlCarterasGenerales;
	}

	public void setResaltarnumero_comprobanteCobrarControlCarterasGenerales(Border borderResaltar) {
		this.resaltarnumero_comprobanteCobrarControlCarterasGenerales= borderResaltar;
	}

	public Boolean getMostrarnumero_comprobanteCobrarControlCarterasGenerales() {
		return this.mostrarnumero_comprobanteCobrarControlCarterasGenerales;
	}

	public void setMostrarnumero_comprobanteCobrarControlCarterasGenerales(Boolean mostrarnumero_comprobanteCobrarControlCarterasGenerales) {
		this.mostrarnumero_comprobanteCobrarControlCarterasGenerales= mostrarnumero_comprobanteCobrarControlCarterasGenerales;
	}

	public Boolean getActivarnumero_comprobanteCobrarControlCarterasGenerales() {
		return this.activarnumero_comprobanteCobrarControlCarterasGenerales;
	}

	public void setActivarnumero_comprobanteCobrarControlCarterasGenerales(Boolean activarnumero_comprobanteCobrarControlCarterasGenerales) {
		this.activarnumero_comprobanteCobrarControlCarterasGenerales= activarnumero_comprobanteCobrarControlCarterasGenerales;
	}

	public Border setResaltarnumero_facturaCobrarControlCarterasGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarControlCarterasGeneralesBeanSwingJInternalFrame cobrarcontrolcarterasgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarcontrolcarterasgeneralesBeanSwingJInternalFrame.jTtoolBarCobrarControlCarterasGenerales.setBorder(borderResaltar);
		
		this.resaltarnumero_facturaCobrarControlCarterasGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_facturaCobrarControlCarterasGenerales() {
		return this.resaltarnumero_facturaCobrarControlCarterasGenerales;
	}

	public void setResaltarnumero_facturaCobrarControlCarterasGenerales(Border borderResaltar) {
		this.resaltarnumero_facturaCobrarControlCarterasGenerales= borderResaltar;
	}

	public Boolean getMostrarnumero_facturaCobrarControlCarterasGenerales() {
		return this.mostrarnumero_facturaCobrarControlCarterasGenerales;
	}

	public void setMostrarnumero_facturaCobrarControlCarterasGenerales(Boolean mostrarnumero_facturaCobrarControlCarterasGenerales) {
		this.mostrarnumero_facturaCobrarControlCarterasGenerales= mostrarnumero_facturaCobrarControlCarterasGenerales;
	}

	public Boolean getActivarnumero_facturaCobrarControlCarterasGenerales() {
		return this.activarnumero_facturaCobrarControlCarterasGenerales;
	}

	public void setActivarnumero_facturaCobrarControlCarterasGenerales(Boolean activarnumero_facturaCobrarControlCarterasGenerales) {
		this.activarnumero_facturaCobrarControlCarterasGenerales= activarnumero_facturaCobrarControlCarterasGenerales;
	}

	public Border setResaltardireccion_direccionCobrarControlCarterasGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarControlCarterasGeneralesBeanSwingJInternalFrame cobrarcontrolcarterasgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarcontrolcarterasgeneralesBeanSwingJInternalFrame.jTtoolBarCobrarControlCarterasGenerales.setBorder(borderResaltar);
		
		this.resaltardireccion_direccionCobrarControlCarterasGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardireccion_direccionCobrarControlCarterasGenerales() {
		return this.resaltardireccion_direccionCobrarControlCarterasGenerales;
	}

	public void setResaltardireccion_direccionCobrarControlCarterasGenerales(Border borderResaltar) {
		this.resaltardireccion_direccionCobrarControlCarterasGenerales= borderResaltar;
	}

	public Boolean getMostrardireccion_direccionCobrarControlCarterasGenerales() {
		return this.mostrardireccion_direccionCobrarControlCarterasGenerales;
	}

	public void setMostrardireccion_direccionCobrarControlCarterasGenerales(Boolean mostrardireccion_direccionCobrarControlCarterasGenerales) {
		this.mostrardireccion_direccionCobrarControlCarterasGenerales= mostrardireccion_direccionCobrarControlCarterasGenerales;
	}

	public Boolean getActivardireccion_direccionCobrarControlCarterasGenerales() {
		return this.activardireccion_direccionCobrarControlCarterasGenerales;
	}

	public void setActivardireccion_direccionCobrarControlCarterasGenerales(Boolean activardireccion_direccionCobrarControlCarterasGenerales) {
		this.activardireccion_direccionCobrarControlCarterasGenerales= activardireccion_direccionCobrarControlCarterasGenerales;
	}

	public Border setResaltartelefono_telefonoCobrarControlCarterasGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarControlCarterasGeneralesBeanSwingJInternalFrame cobrarcontrolcarterasgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarcontrolcarterasgeneralesBeanSwingJInternalFrame.jTtoolBarCobrarControlCarterasGenerales.setBorder(borderResaltar);
		
		this.resaltartelefono_telefonoCobrarControlCarterasGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefono_telefonoCobrarControlCarterasGenerales() {
		return this.resaltartelefono_telefonoCobrarControlCarterasGenerales;
	}

	public void setResaltartelefono_telefonoCobrarControlCarterasGenerales(Border borderResaltar) {
		this.resaltartelefono_telefonoCobrarControlCarterasGenerales= borderResaltar;
	}

	public Boolean getMostrartelefono_telefonoCobrarControlCarterasGenerales() {
		return this.mostrartelefono_telefonoCobrarControlCarterasGenerales;
	}

	public void setMostrartelefono_telefonoCobrarControlCarterasGenerales(Boolean mostrartelefono_telefonoCobrarControlCarterasGenerales) {
		this.mostrartelefono_telefonoCobrarControlCarterasGenerales= mostrartelefono_telefonoCobrarControlCarterasGenerales;
	}

	public Boolean getActivartelefono_telefonoCobrarControlCarterasGenerales() {
		return this.activartelefono_telefonoCobrarControlCarterasGenerales;
	}

	public void setActivartelefono_telefonoCobrarControlCarterasGenerales(Boolean activartelefono_telefonoCobrarControlCarterasGenerales) {
		this.activartelefono_telefonoCobrarControlCarterasGenerales= activartelefono_telefonoCobrarControlCarterasGenerales;
	}

	public Border setResaltarfecha_emisioCobrarControlCarterasGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarControlCarterasGeneralesBeanSwingJInternalFrame cobrarcontrolcarterasgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarcontrolcarterasgeneralesBeanSwingJInternalFrame.jTtoolBarCobrarControlCarterasGenerales.setBorder(borderResaltar);
		
		this.resaltarfecha_emisioCobrarControlCarterasGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisioCobrarControlCarterasGenerales() {
		return this.resaltarfecha_emisioCobrarControlCarterasGenerales;
	}

	public void setResaltarfecha_emisioCobrarControlCarterasGenerales(Border borderResaltar) {
		this.resaltarfecha_emisioCobrarControlCarterasGenerales= borderResaltar;
	}

	public Boolean getMostrarfecha_emisioCobrarControlCarterasGenerales() {
		return this.mostrarfecha_emisioCobrarControlCarterasGenerales;
	}

	public void setMostrarfecha_emisioCobrarControlCarterasGenerales(Boolean mostrarfecha_emisioCobrarControlCarterasGenerales) {
		this.mostrarfecha_emisioCobrarControlCarterasGenerales= mostrarfecha_emisioCobrarControlCarterasGenerales;
	}

	public Boolean getActivarfecha_emisioCobrarControlCarterasGenerales() {
		return this.activarfecha_emisioCobrarControlCarterasGenerales;
	}

	public void setActivarfecha_emisioCobrarControlCarterasGenerales(Boolean activarfecha_emisioCobrarControlCarterasGenerales) {
		this.activarfecha_emisioCobrarControlCarterasGenerales= activarfecha_emisioCobrarControlCarterasGenerales;
	}

	public Border setResaltarfecha_venceCobrarControlCarterasGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarControlCarterasGeneralesBeanSwingJInternalFrame cobrarcontrolcarterasgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarcontrolcarterasgeneralesBeanSwingJInternalFrame.jTtoolBarCobrarControlCarterasGenerales.setBorder(borderResaltar);
		
		this.resaltarfecha_venceCobrarControlCarterasGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_venceCobrarControlCarterasGenerales() {
		return this.resaltarfecha_venceCobrarControlCarterasGenerales;
	}

	public void setResaltarfecha_venceCobrarControlCarterasGenerales(Border borderResaltar) {
		this.resaltarfecha_venceCobrarControlCarterasGenerales= borderResaltar;
	}

	public Boolean getMostrarfecha_venceCobrarControlCarterasGenerales() {
		return this.mostrarfecha_venceCobrarControlCarterasGenerales;
	}

	public void setMostrarfecha_venceCobrarControlCarterasGenerales(Boolean mostrarfecha_venceCobrarControlCarterasGenerales) {
		this.mostrarfecha_venceCobrarControlCarterasGenerales= mostrarfecha_venceCobrarControlCarterasGenerales;
	}

	public Boolean getActivarfecha_venceCobrarControlCarterasGenerales() {
		return this.activarfecha_venceCobrarControlCarterasGenerales;
	}

	public void setActivarfecha_venceCobrarControlCarterasGenerales(Boolean activarfecha_venceCobrarControlCarterasGenerales) {
		this.activarfecha_venceCobrarControlCarterasGenerales= activarfecha_venceCobrarControlCarterasGenerales;
	}

	public Border setResaltardiasCobrarControlCarterasGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarControlCarterasGeneralesBeanSwingJInternalFrame cobrarcontrolcarterasgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarcontrolcarterasgeneralesBeanSwingJInternalFrame.jTtoolBarCobrarControlCarterasGenerales.setBorder(borderResaltar);
		
		this.resaltardiasCobrarControlCarterasGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardiasCobrarControlCarterasGenerales() {
		return this.resaltardiasCobrarControlCarterasGenerales;
	}

	public void setResaltardiasCobrarControlCarterasGenerales(Border borderResaltar) {
		this.resaltardiasCobrarControlCarterasGenerales= borderResaltar;
	}

	public Boolean getMostrardiasCobrarControlCarterasGenerales() {
		return this.mostrardiasCobrarControlCarterasGenerales;
	}

	public void setMostrardiasCobrarControlCarterasGenerales(Boolean mostrardiasCobrarControlCarterasGenerales) {
		this.mostrardiasCobrarControlCarterasGenerales= mostrardiasCobrarControlCarterasGenerales;
	}

	public Boolean getActivardiasCobrarControlCarterasGenerales() {
		return this.activardiasCobrarControlCarterasGenerales;
	}

	public void setActivardiasCobrarControlCarterasGenerales(Boolean activardiasCobrarControlCarterasGenerales) {
		this.activardiasCobrarControlCarterasGenerales= activardiasCobrarControlCarterasGenerales;
	}

	public Border setResaltarsaldoCobrarControlCarterasGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarControlCarterasGeneralesBeanSwingJInternalFrame cobrarcontrolcarterasgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarcontrolcarterasgeneralesBeanSwingJInternalFrame.jTtoolBarCobrarControlCarterasGenerales.setBorder(borderResaltar);
		
		this.resaltarsaldoCobrarControlCarterasGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsaldoCobrarControlCarterasGenerales() {
		return this.resaltarsaldoCobrarControlCarterasGenerales;
	}

	public void setResaltarsaldoCobrarControlCarterasGenerales(Border borderResaltar) {
		this.resaltarsaldoCobrarControlCarterasGenerales= borderResaltar;
	}

	public Boolean getMostrarsaldoCobrarControlCarterasGenerales() {
		return this.mostrarsaldoCobrarControlCarterasGenerales;
	}

	public void setMostrarsaldoCobrarControlCarterasGenerales(Boolean mostrarsaldoCobrarControlCarterasGenerales) {
		this.mostrarsaldoCobrarControlCarterasGenerales= mostrarsaldoCobrarControlCarterasGenerales;
	}

	public Boolean getActivarsaldoCobrarControlCarterasGenerales() {
		return this.activarsaldoCobrarControlCarterasGenerales;
	}

	public void setActivarsaldoCobrarControlCarterasGenerales(Boolean activarsaldoCobrarControlCarterasGenerales) {
		this.activarsaldoCobrarControlCarterasGenerales= activarsaldoCobrarControlCarterasGenerales;
	}

	public Border setResaltardebito_mone_localCobrarControlCarterasGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarControlCarterasGeneralesBeanSwingJInternalFrame cobrarcontrolcarterasgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarcontrolcarterasgeneralesBeanSwingJInternalFrame.jTtoolBarCobrarControlCarterasGenerales.setBorder(borderResaltar);
		
		this.resaltardebito_mone_localCobrarControlCarterasGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardebito_mone_localCobrarControlCarterasGenerales() {
		return this.resaltardebito_mone_localCobrarControlCarterasGenerales;
	}

	public void setResaltardebito_mone_localCobrarControlCarterasGenerales(Border borderResaltar) {
		this.resaltardebito_mone_localCobrarControlCarterasGenerales= borderResaltar;
	}

	public Boolean getMostrardebito_mone_localCobrarControlCarterasGenerales() {
		return this.mostrardebito_mone_localCobrarControlCarterasGenerales;
	}

	public void setMostrardebito_mone_localCobrarControlCarterasGenerales(Boolean mostrardebito_mone_localCobrarControlCarterasGenerales) {
		this.mostrardebito_mone_localCobrarControlCarterasGenerales= mostrardebito_mone_localCobrarControlCarterasGenerales;
	}

	public Boolean getActivardebito_mone_localCobrarControlCarterasGenerales() {
		return this.activardebito_mone_localCobrarControlCarterasGenerales;
	}

	public void setActivardebito_mone_localCobrarControlCarterasGenerales(Boolean activardebito_mone_localCobrarControlCarterasGenerales) {
		this.activardebito_mone_localCobrarControlCarterasGenerales= activardebito_mone_localCobrarControlCarterasGenerales;
	}

	public Border setResaltarcredito_mone_localCobrarControlCarterasGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarControlCarterasGeneralesBeanSwingJInternalFrame cobrarcontrolcarterasgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarcontrolcarterasgeneralesBeanSwingJInternalFrame.jTtoolBarCobrarControlCarterasGenerales.setBorder(borderResaltar);
		
		this.resaltarcredito_mone_localCobrarControlCarterasGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcredito_mone_localCobrarControlCarterasGenerales() {
		return this.resaltarcredito_mone_localCobrarControlCarterasGenerales;
	}

	public void setResaltarcredito_mone_localCobrarControlCarterasGenerales(Border borderResaltar) {
		this.resaltarcredito_mone_localCobrarControlCarterasGenerales= borderResaltar;
	}

	public Boolean getMostrarcredito_mone_localCobrarControlCarterasGenerales() {
		return this.mostrarcredito_mone_localCobrarControlCarterasGenerales;
	}

	public void setMostrarcredito_mone_localCobrarControlCarterasGenerales(Boolean mostrarcredito_mone_localCobrarControlCarterasGenerales) {
		this.mostrarcredito_mone_localCobrarControlCarterasGenerales= mostrarcredito_mone_localCobrarControlCarterasGenerales;
	}

	public Boolean getActivarcredito_mone_localCobrarControlCarterasGenerales() {
		return this.activarcredito_mone_localCobrarControlCarterasGenerales;
	}

	public void setActivarcredito_mone_localCobrarControlCarterasGenerales(Boolean activarcredito_mone_localCobrarControlCarterasGenerales) {
		this.activarcredito_mone_localCobrarControlCarterasGenerales= activarcredito_mone_localCobrarControlCarterasGenerales;
	}

	public Border setResaltarhora_pagoCobrarControlCarterasGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarControlCarterasGeneralesBeanSwingJInternalFrame cobrarcontrolcarterasgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarcontrolcarterasgeneralesBeanSwingJInternalFrame.jTtoolBarCobrarControlCarterasGenerales.setBorder(borderResaltar);
		
		this.resaltarhora_pagoCobrarControlCarterasGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhora_pagoCobrarControlCarterasGenerales() {
		return this.resaltarhora_pagoCobrarControlCarterasGenerales;
	}

	public void setResaltarhora_pagoCobrarControlCarterasGenerales(Border borderResaltar) {
		this.resaltarhora_pagoCobrarControlCarterasGenerales= borderResaltar;
	}

	public Boolean getMostrarhora_pagoCobrarControlCarterasGenerales() {
		return this.mostrarhora_pagoCobrarControlCarterasGenerales;
	}

	public void setMostrarhora_pagoCobrarControlCarterasGenerales(Boolean mostrarhora_pagoCobrarControlCarterasGenerales) {
		this.mostrarhora_pagoCobrarControlCarterasGenerales= mostrarhora_pagoCobrarControlCarterasGenerales;
	}

	public Boolean getActivarhora_pagoCobrarControlCarterasGenerales() {
		return this.activarhora_pagoCobrarControlCarterasGenerales;
	}

	public void setActivarhora_pagoCobrarControlCarterasGenerales(Boolean activarhora_pagoCobrarControlCarterasGenerales) {
		this.activarhora_pagoCobrarControlCarterasGenerales= activarhora_pagoCobrarControlCarterasGenerales;
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
		
		
		this.setMostraridCobrarControlCarterasGenerales(esInicial);
		this.setMostrarid_empresaCobrarControlCarterasGenerales(esInicial);
		this.setMostrarfecha_emision_hastaCobrarControlCarterasGenerales(esInicial);
		this.setMostrarnombre_ciudadCobrarControlCarterasGenerales(esInicial);
		this.setMostrarnombre_zonaCobrarControlCarterasGenerales(esInicial);
		this.setMostrarnombre_vendedorCobrarControlCarterasGenerales(esInicial);
		this.setMostrarcodigoCobrarControlCarterasGenerales(esInicial);
		this.setMostrarnombre_completoCobrarControlCarterasGenerales(esInicial);
		this.setMostrarlimite_creditoCobrarControlCarterasGenerales(esInicial);
		this.setMostrarrepresentanteCobrarControlCarterasGenerales(esInicial);
		this.setMostrardia_pagoCobrarControlCarterasGenerales(esInicial);
		this.setMostrarnumero_comprobanteCobrarControlCarterasGenerales(esInicial);
		this.setMostrarnumero_facturaCobrarControlCarterasGenerales(esInicial);
		this.setMostrardireccion_direccionCobrarControlCarterasGenerales(esInicial);
		this.setMostrartelefono_telefonoCobrarControlCarterasGenerales(esInicial);
		this.setMostrarfecha_emisioCobrarControlCarterasGenerales(esInicial);
		this.setMostrarfecha_venceCobrarControlCarterasGenerales(esInicial);
		this.setMostrardiasCobrarControlCarterasGenerales(esInicial);
		this.setMostrarsaldoCobrarControlCarterasGenerales(esInicial);
		this.setMostrardebito_mone_localCobrarControlCarterasGenerales(esInicial);
		this.setMostrarcredito_mone_localCobrarControlCarterasGenerales(esInicial);
		this.setMostrarhora_pagoCobrarControlCarterasGenerales(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.ID)) {
				this.setMostraridCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setMostrarfecha_emision_hastaCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.NOMBRECIUDAD)) {
				this.setMostrarnombre_ciudadCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.NOMBREZONA)) {
				this.setMostrarnombre_zonaCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.NOMBREVENDEDOR)) {
				this.setMostrarnombre_vendedorCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.NOMBRECOMPLETO)) {
				this.setMostrarnombre_completoCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.LIMITECREDITO)) {
				this.setMostrarlimite_creditoCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.REPRESENTANTE)) {
				this.setMostrarrepresentanteCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.DIAPAGO)) {
				this.setMostrardia_pagoCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setMostrarnumero_comprobanteCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.NUMEROFACTURA)) {
				this.setMostrarnumero_facturaCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.DIRECCIONDIRECCION)) {
				this.setMostrardireccion_direccionCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.TELEFONOTELEFONO)) {
				this.setMostrartelefono_telefonoCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.FECHAEMISIO)) {
				this.setMostrarfecha_emisioCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.FECHAVENCE)) {
				this.setMostrarfecha_venceCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.DIAS)) {
				this.setMostrardiasCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.SALDO)) {
				this.setMostrarsaldoCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.DEBITOMONELOCAL)) {
				this.setMostrardebito_mone_localCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.CREDITOMONELOCAL)) {
				this.setMostrarcredito_mone_localCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.HORAPAGO)) {
				this.setMostrarhora_pagoCobrarControlCarterasGenerales(esAsigna);
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
		
		
		this.setActivaridCobrarControlCarterasGenerales(esInicial);
		this.setActivarid_empresaCobrarControlCarterasGenerales(esInicial);
		this.setActivarfecha_emision_hastaCobrarControlCarterasGenerales(esInicial);
		this.setActivarnombre_ciudadCobrarControlCarterasGenerales(esInicial);
		this.setActivarnombre_zonaCobrarControlCarterasGenerales(esInicial);
		this.setActivarnombre_vendedorCobrarControlCarterasGenerales(esInicial);
		this.setActivarcodigoCobrarControlCarterasGenerales(esInicial);
		this.setActivarnombre_completoCobrarControlCarterasGenerales(esInicial);
		this.setActivarlimite_creditoCobrarControlCarterasGenerales(esInicial);
		this.setActivarrepresentanteCobrarControlCarterasGenerales(esInicial);
		this.setActivardia_pagoCobrarControlCarterasGenerales(esInicial);
		this.setActivarnumero_comprobanteCobrarControlCarterasGenerales(esInicial);
		this.setActivarnumero_facturaCobrarControlCarterasGenerales(esInicial);
		this.setActivardireccion_direccionCobrarControlCarterasGenerales(esInicial);
		this.setActivartelefono_telefonoCobrarControlCarterasGenerales(esInicial);
		this.setActivarfecha_emisioCobrarControlCarterasGenerales(esInicial);
		this.setActivarfecha_venceCobrarControlCarterasGenerales(esInicial);
		this.setActivardiasCobrarControlCarterasGenerales(esInicial);
		this.setActivarsaldoCobrarControlCarterasGenerales(esInicial);
		this.setActivardebito_mone_localCobrarControlCarterasGenerales(esInicial);
		this.setActivarcredito_mone_localCobrarControlCarterasGenerales(esInicial);
		this.setActivarhora_pagoCobrarControlCarterasGenerales(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.ID)) {
				this.setActivaridCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setActivarfecha_emision_hastaCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.NOMBRECIUDAD)) {
				this.setActivarnombre_ciudadCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.NOMBREZONA)) {
				this.setActivarnombre_zonaCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.NOMBREVENDEDOR)) {
				this.setActivarnombre_vendedorCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.CODIGO)) {
				this.setActivarcodigoCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.NOMBRECOMPLETO)) {
				this.setActivarnombre_completoCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.LIMITECREDITO)) {
				this.setActivarlimite_creditoCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.REPRESENTANTE)) {
				this.setActivarrepresentanteCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.DIAPAGO)) {
				this.setActivardia_pagoCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setActivarnumero_comprobanteCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.NUMEROFACTURA)) {
				this.setActivarnumero_facturaCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.DIRECCIONDIRECCION)) {
				this.setActivardireccion_direccionCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.TELEFONOTELEFONO)) {
				this.setActivartelefono_telefonoCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.FECHAEMISIO)) {
				this.setActivarfecha_emisioCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.FECHAVENCE)) {
				this.setActivarfecha_venceCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.DIAS)) {
				this.setActivardiasCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.SALDO)) {
				this.setActivarsaldoCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.DEBITOMONELOCAL)) {
				this.setActivardebito_mone_localCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.CREDITOMONELOCAL)) {
				this.setActivarcredito_mone_localCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.HORAPAGO)) {
				this.setActivarhora_pagoCobrarControlCarterasGenerales(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CobrarControlCarterasGeneralesBeanSwingJInternalFrame cobrarcontrolcarterasgeneralesBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCobrarControlCarterasGenerales(esInicial);
		this.setResaltarid_empresaCobrarControlCarterasGenerales(esInicial);
		this.setResaltarfecha_emision_hastaCobrarControlCarterasGenerales(esInicial);
		this.setResaltarnombre_ciudadCobrarControlCarterasGenerales(esInicial);
		this.setResaltarnombre_zonaCobrarControlCarterasGenerales(esInicial);
		this.setResaltarnombre_vendedorCobrarControlCarterasGenerales(esInicial);
		this.setResaltarcodigoCobrarControlCarterasGenerales(esInicial);
		this.setResaltarnombre_completoCobrarControlCarterasGenerales(esInicial);
		this.setResaltarlimite_creditoCobrarControlCarterasGenerales(esInicial);
		this.setResaltarrepresentanteCobrarControlCarterasGenerales(esInicial);
		this.setResaltardia_pagoCobrarControlCarterasGenerales(esInicial);
		this.setResaltarnumero_comprobanteCobrarControlCarterasGenerales(esInicial);
		this.setResaltarnumero_facturaCobrarControlCarterasGenerales(esInicial);
		this.setResaltardireccion_direccionCobrarControlCarterasGenerales(esInicial);
		this.setResaltartelefono_telefonoCobrarControlCarterasGenerales(esInicial);
		this.setResaltarfecha_emisioCobrarControlCarterasGenerales(esInicial);
		this.setResaltarfecha_venceCobrarControlCarterasGenerales(esInicial);
		this.setResaltardiasCobrarControlCarterasGenerales(esInicial);
		this.setResaltarsaldoCobrarControlCarterasGenerales(esInicial);
		this.setResaltardebito_mone_localCobrarControlCarterasGenerales(esInicial);
		this.setResaltarcredito_mone_localCobrarControlCarterasGenerales(esInicial);
		this.setResaltarhora_pagoCobrarControlCarterasGenerales(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.ID)) {
				this.setResaltaridCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setResaltarfecha_emision_hastaCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.NOMBRECIUDAD)) {
				this.setResaltarnombre_ciudadCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.NOMBREZONA)) {
				this.setResaltarnombre_zonaCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.NOMBREVENDEDOR)) {
				this.setResaltarnombre_vendedorCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.NOMBRECOMPLETO)) {
				this.setResaltarnombre_completoCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.LIMITECREDITO)) {
				this.setResaltarlimite_creditoCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.REPRESENTANTE)) {
				this.setResaltarrepresentanteCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.DIAPAGO)) {
				this.setResaltardia_pagoCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setResaltarnumero_comprobanteCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.NUMEROFACTURA)) {
				this.setResaltarnumero_facturaCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.DIRECCIONDIRECCION)) {
				this.setResaltardireccion_direccionCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.TELEFONOTELEFONO)) {
				this.setResaltartelefono_telefonoCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.FECHAEMISIO)) {
				this.setResaltarfecha_emisioCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.FECHAVENCE)) {
				this.setResaltarfecha_venceCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.DIAS)) {
				this.setResaltardiasCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.SALDO)) {
				this.setResaltarsaldoCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.DEBITOMONELOCAL)) {
				this.setResaltardebito_mone_localCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.CREDITOMONELOCAL)) {
				this.setResaltarcredito_mone_localCobrarControlCarterasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarControlCarterasGeneralesConstantesFunciones.HORAPAGO)) {
				this.setResaltarhora_pagoCobrarControlCarterasGenerales(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CobrarControlCarterasGeneralesBeanSwingJInternalFrame cobrarcontrolcarterasgeneralesBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaCobrarControlCarterasGeneralesCobrarControlCarterasGenerales=true;

	public Boolean getMostrarBusquedaCobrarControlCarterasGeneralesCobrarControlCarterasGenerales() {
		return this.mostrarBusquedaCobrarControlCarterasGeneralesCobrarControlCarterasGenerales;
	}

	public void setMostrarBusquedaCobrarControlCarterasGeneralesCobrarControlCarterasGenerales(Boolean visibilidadResaltar) {
		this.mostrarBusquedaCobrarControlCarterasGeneralesCobrarControlCarterasGenerales= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaCobrarControlCarterasGeneralesCobrarControlCarterasGenerales=true;

	public Boolean getActivarBusquedaCobrarControlCarterasGeneralesCobrarControlCarterasGenerales() {
		return this.activarBusquedaCobrarControlCarterasGeneralesCobrarControlCarterasGenerales;
	}

	public void setActivarBusquedaCobrarControlCarterasGeneralesCobrarControlCarterasGenerales(Boolean habilitarResaltar) {
		this.activarBusquedaCobrarControlCarterasGeneralesCobrarControlCarterasGenerales= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaCobrarControlCarterasGeneralesCobrarControlCarterasGenerales=null;

	public Border getResaltarBusquedaCobrarControlCarterasGeneralesCobrarControlCarterasGenerales() {
		return this.resaltarBusquedaCobrarControlCarterasGeneralesCobrarControlCarterasGenerales;
	}

	public void setResaltarBusquedaCobrarControlCarterasGeneralesCobrarControlCarterasGenerales(Border borderResaltar) {
		this.resaltarBusquedaCobrarControlCarterasGeneralesCobrarControlCarterasGenerales= borderResaltar;
	}

	public void setResaltarBusquedaCobrarControlCarterasGeneralesCobrarControlCarterasGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarControlCarterasGeneralesBeanSwingJInternalFrame cobrarcontrolcarterasgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaCobrarControlCarterasGeneralesCobrarControlCarterasGenerales= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}