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
package com.bydan.erp.puntoventa.util.report;

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


import com.bydan.erp.puntoventa.util.report.ComprobanteFacturaConstantesFunciones;
import com.bydan.erp.puntoventa.util.report.ComprobanteFacturaParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.report.ComprobanteFacturaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.cartera.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ComprobanteFacturaConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ComprobanteFactura";
	public static final String SPATHOPCION="PuntoVenta";	
	public static final String SPATHMODULO="puntoventa/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ComprobanteFactura"+ComprobanteFacturaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ComprobanteFacturaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ComprobanteFacturaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ComprobanteFacturaConstantesFunciones.SCHEMA+"_"+ComprobanteFacturaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ComprobanteFacturaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ComprobanteFacturaConstantesFunciones.SCHEMA+"_"+ComprobanteFacturaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ComprobanteFacturaConstantesFunciones.SCHEMA+"_"+ComprobanteFacturaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ComprobanteFacturaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ComprobanteFacturaConstantesFunciones.SCHEMA+"_"+ComprobanteFacturaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ComprobanteFacturaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ComprobanteFacturaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ComprobanteFacturaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ComprobanteFacturaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ComprobanteFacturaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ComprobanteFacturaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ComprobanteFacturaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ComprobanteFacturaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ComprobanteFacturaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ComprobanteFacturaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Comprobante Facturas";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Comprobante Factura";
	public static final String SCLASSWEBTITULO_LOWER="Comprobante Factura";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ComprobanteFactura";
	public static final String OBJECTNAME="comprobantefactura";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PUNTOVENTA;	
	public static final String TABLENAME="comprobante_factura";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select comprobantefactura from "+ComprobanteFacturaConstantesFunciones.SPERSISTENCENAME+" comprobantefactura";
	public static String QUERYSELECTNATIVE="select "+ComprobanteFacturaConstantesFunciones.SCHEMA+"."+ComprobanteFacturaConstantesFunciones.TABLENAME+".id,"+ComprobanteFacturaConstantesFunciones.SCHEMA+"."+ComprobanteFacturaConstantesFunciones.TABLENAME+".version_row,"+ComprobanteFacturaConstantesFunciones.SCHEMA+"."+ComprobanteFacturaConstantesFunciones.TABLENAME+".id_empresa,"+ComprobanteFacturaConstantesFunciones.SCHEMA+"."+ComprobanteFacturaConstantesFunciones.TABLENAME+".id_vendedor,"+ComprobanteFacturaConstantesFunciones.SCHEMA+"."+ComprobanteFacturaConstantesFunciones.TABLENAME+".fecha_inicio,"+ComprobanteFacturaConstantesFunciones.SCHEMA+"."+ComprobanteFacturaConstantesFunciones.TABLENAME+".fecha_fin,"+ComprobanteFacturaConstantesFunciones.SCHEMA+"."+ComprobanteFacturaConstantesFunciones.TABLENAME+".id_caja,"+ComprobanteFacturaConstantesFunciones.SCHEMA+"."+ComprobanteFacturaConstantesFunciones.TABLENAME+".id_cliente,"+ComprobanteFacturaConstantesFunciones.SCHEMA+"."+ComprobanteFacturaConstantesFunciones.TABLENAME+".nombre_caja,"+ComprobanteFacturaConstantesFunciones.SCHEMA+"."+ComprobanteFacturaConstantesFunciones.TABLENAME+".secuencial,"+ComprobanteFacturaConstantesFunciones.SCHEMA+"."+ComprobanteFacturaConstantesFunciones.TABLENAME+".fecha,"+ComprobanteFacturaConstantesFunciones.SCHEMA+"."+ComprobanteFacturaConstantesFunciones.TABLENAME+".codigo_cliente,"+ComprobanteFacturaConstantesFunciones.SCHEMA+"."+ComprobanteFacturaConstantesFunciones.TABLENAME+".nombre_cliente,"+ComprobanteFacturaConstantesFunciones.SCHEMA+"."+ComprobanteFacturaConstantesFunciones.TABLENAME+".subtotal,"+ComprobanteFacturaConstantesFunciones.SCHEMA+"."+ComprobanteFacturaConstantesFunciones.TABLENAME+".iva,"+ComprobanteFacturaConstantesFunciones.SCHEMA+"."+ComprobanteFacturaConstantesFunciones.TABLENAME+".descuento,"+ComprobanteFacturaConstantesFunciones.SCHEMA+"."+ComprobanteFacturaConstantesFunciones.TABLENAME+".financiamiento,"+ComprobanteFacturaConstantesFunciones.SCHEMA+"."+ComprobanteFacturaConstantesFunciones.TABLENAME+".flete,"+ComprobanteFacturaConstantesFunciones.SCHEMA+"."+ComprobanteFacturaConstantesFunciones.TABLENAME+".ice,"+ComprobanteFacturaConstantesFunciones.SCHEMA+"."+ComprobanteFacturaConstantesFunciones.TABLENAME+".total,"+ComprobanteFacturaConstantesFunciones.SCHEMA+"."+ComprobanteFacturaConstantesFunciones.TABLENAME+".cantidad_formas_pago,"+ComprobanteFacturaConstantesFunciones.SCHEMA+"."+ComprobanteFacturaConstantesFunciones.TABLENAME+".descuento_real from "+ComprobanteFacturaConstantesFunciones.SCHEMA+"."+ComprobanteFacturaConstantesFunciones.TABLENAME;//+" as "+ComprobanteFacturaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDVENDEDOR= "id_vendedor";
    public static final String FECHAINICIO= "fecha_inicio";
    public static final String FECHAFIN= "fecha_fin";
    public static final String IDCAJA= "id_caja";
    public static final String IDCLIENTE= "id_cliente";
    public static final String NOMBRECAJA= "nombre_caja";
    public static final String SECUENCIAL= "secuencial";
    public static final String FECHA= "fecha";
    public static final String CODIGOCLIENTE= "codigo_cliente";
    public static final String NOMBRECLIENTE= "nombre_cliente";
    public static final String SUBTOTAL= "subtotal";
    public static final String IVA= "iva";
    public static final String DESCUENTO= "descuento";
    public static final String FINANCIAMIENTO= "financiamiento";
    public static final String FLETE= "flete";
    public static final String ICE= "ice";
    public static final String TOTAL= "total";
    public static final String CANTIDADFORMASPAGO= "cantidad_formas_pago";
    public static final String DESCUENTOREAL= "descuento_real";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDVENDEDOR= "Vendedor";
		public static final String LABEL_IDVENDEDOR_LOWER= "Vendedor";
    	public static final String LABEL_FECHAINICIO= "Fecha Inicio";
		public static final String LABEL_FECHAINICIO_LOWER= "Fecha Inicio";
    	public static final String LABEL_FECHAFIN= "Fecha Fin";
		public static final String LABEL_FECHAFIN_LOWER= "Fecha Fin";
    	public static final String LABEL_IDCAJA= "Caja";
		public static final String LABEL_IDCAJA_LOWER= "Caja";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_NOMBRECAJA= "Nombre Caja";
		public static final String LABEL_NOMBRECAJA_LOWER= "Nombre Caja";
    	public static final String LABEL_SECUENCIAL= "Secuencial";
		public static final String LABEL_SECUENCIAL_LOWER= "Secuencial";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_CODIGOCLIENTE= "Codigo Cliente";
		public static final String LABEL_CODIGOCLIENTE_LOWER= "Codigo Cliente";
    	public static final String LABEL_NOMBRECLIENTE= "Nombre Cliente";
		public static final String LABEL_NOMBRECLIENTE_LOWER= "Nombre Cliente";
    	public static final String LABEL_SUBTOTAL= "Subtotal";
		public static final String LABEL_SUBTOTAL_LOWER= "Subtotal";
    	public static final String LABEL_IVA= "Iva";
		public static final String LABEL_IVA_LOWER= "Iva";
    	public static final String LABEL_DESCUENTO= "Descuento";
		public static final String LABEL_DESCUENTO_LOWER= "Descuento";
    	public static final String LABEL_FINANCIAMIENTO= "Financiamiento";
		public static final String LABEL_FINANCIAMIENTO_LOWER= "Financiamiento";
    	public static final String LABEL_FLETE= "Flete";
		public static final String LABEL_FLETE_LOWER= "Flete";
    	public static final String LABEL_ICE= "Ice";
		public static final String LABEL_ICE_LOWER= "Ice";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
    	public static final String LABEL_CANTIDADFORMASPAGO= "Cantad Formas Pago";
		public static final String LABEL_CANTIDADFORMASPAGO_LOWER= "Cantidad Formas Pago";
    	public static final String LABEL_DESCUENTOREAL= "Descuento Real";
		public static final String LABEL_DESCUENTOREAL_LOWER= "Descuento Real";
	
		
		
		
		
		
		
		
		
	public static final String SREGEXNOMBRE_CAJA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_CAJA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXSECUENCIAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSECUENCIAL=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXCODIGO_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
	
	public static String getComprobanteFacturaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ComprobanteFacturaConstantesFunciones.IDEMPRESA)) {sLabelColumna=ComprobanteFacturaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ComprobanteFacturaConstantesFunciones.IDVENDEDOR)) {sLabelColumna=ComprobanteFacturaConstantesFunciones.LABEL_IDVENDEDOR;}
		if(sNombreColumna.equals(ComprobanteFacturaConstantesFunciones.FECHAINICIO)) {sLabelColumna=ComprobanteFacturaConstantesFunciones.LABEL_FECHAINICIO;}
		if(sNombreColumna.equals(ComprobanteFacturaConstantesFunciones.FECHAFIN)) {sLabelColumna=ComprobanteFacturaConstantesFunciones.LABEL_FECHAFIN;}
		if(sNombreColumna.equals(ComprobanteFacturaConstantesFunciones.IDCAJA)) {sLabelColumna=ComprobanteFacturaConstantesFunciones.LABEL_IDCAJA;}
		if(sNombreColumna.equals(ComprobanteFacturaConstantesFunciones.IDCLIENTE)) {sLabelColumna=ComprobanteFacturaConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(ComprobanteFacturaConstantesFunciones.NOMBRECAJA)) {sLabelColumna=ComprobanteFacturaConstantesFunciones.LABEL_NOMBRECAJA;}
		if(sNombreColumna.equals(ComprobanteFacturaConstantesFunciones.SECUENCIAL)) {sLabelColumna=ComprobanteFacturaConstantesFunciones.LABEL_SECUENCIAL;}
		if(sNombreColumna.equals(ComprobanteFacturaConstantesFunciones.FECHA)) {sLabelColumna=ComprobanteFacturaConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(ComprobanteFacturaConstantesFunciones.CODIGOCLIENTE)) {sLabelColumna=ComprobanteFacturaConstantesFunciones.LABEL_CODIGOCLIENTE;}
		if(sNombreColumna.equals(ComprobanteFacturaConstantesFunciones.NOMBRECLIENTE)) {sLabelColumna=ComprobanteFacturaConstantesFunciones.LABEL_NOMBRECLIENTE;}
		if(sNombreColumna.equals(ComprobanteFacturaConstantesFunciones.SUBTOTAL)) {sLabelColumna=ComprobanteFacturaConstantesFunciones.LABEL_SUBTOTAL;}
		if(sNombreColumna.equals(ComprobanteFacturaConstantesFunciones.IVA)) {sLabelColumna=ComprobanteFacturaConstantesFunciones.LABEL_IVA;}
		if(sNombreColumna.equals(ComprobanteFacturaConstantesFunciones.DESCUENTO)) {sLabelColumna=ComprobanteFacturaConstantesFunciones.LABEL_DESCUENTO;}
		if(sNombreColumna.equals(ComprobanteFacturaConstantesFunciones.FINANCIAMIENTO)) {sLabelColumna=ComprobanteFacturaConstantesFunciones.LABEL_FINANCIAMIENTO;}
		if(sNombreColumna.equals(ComprobanteFacturaConstantesFunciones.FLETE)) {sLabelColumna=ComprobanteFacturaConstantesFunciones.LABEL_FLETE;}
		if(sNombreColumna.equals(ComprobanteFacturaConstantesFunciones.ICE)) {sLabelColumna=ComprobanteFacturaConstantesFunciones.LABEL_ICE;}
		if(sNombreColumna.equals(ComprobanteFacturaConstantesFunciones.TOTAL)) {sLabelColumna=ComprobanteFacturaConstantesFunciones.LABEL_TOTAL;}
		if(sNombreColumna.equals(ComprobanteFacturaConstantesFunciones.CANTIDADFORMASPAGO)) {sLabelColumna=ComprobanteFacturaConstantesFunciones.LABEL_CANTIDADFORMASPAGO;}
		if(sNombreColumna.equals(ComprobanteFacturaConstantesFunciones.DESCUENTOREAL)) {sLabelColumna=ComprobanteFacturaConstantesFunciones.LABEL_DESCUENTOREAL;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getComprobanteFacturaDescripcion(ComprobanteFactura comprobantefactura) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(comprobantefactura !=null/* && comprobantefactura.getId()!=0*/) {
			sDescripcion=comprobantefactura.getfecha_inicio().toString();//comprobantefacturacomprobantefactura.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getComprobanteFacturaDescripcionDetallado(ComprobanteFactura comprobantefactura) {
		String sDescripcion="";
			
		sDescripcion+=ComprobanteFacturaConstantesFunciones.ID+"=";
		sDescripcion+=comprobantefactura.getId().toString()+",";
		sDescripcion+=ComprobanteFacturaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=comprobantefactura.getVersionRow().toString()+",";
		sDescripcion+=ComprobanteFacturaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=comprobantefactura.getid_empresa().toString()+",";
		sDescripcion+=ComprobanteFacturaConstantesFunciones.IDVENDEDOR+"=";
		sDescripcion+=comprobantefactura.getid_vendedor().toString()+",";
		sDescripcion+=ComprobanteFacturaConstantesFunciones.FECHAINICIO+"=";
		sDescripcion+=comprobantefactura.getfecha_inicio().toString()+",";
		sDescripcion+=ComprobanteFacturaConstantesFunciones.FECHAFIN+"=";
		sDescripcion+=comprobantefactura.getfecha_fin().toString()+",";
		sDescripcion+=ComprobanteFacturaConstantesFunciones.IDCAJA+"=";
		sDescripcion+=comprobantefactura.getid_caja().toString()+",";
		sDescripcion+=ComprobanteFacturaConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=comprobantefactura.getid_cliente().toString()+",";
		sDescripcion+=ComprobanteFacturaConstantesFunciones.NOMBRECAJA+"=";
		sDescripcion+=comprobantefactura.getnombre_caja()+",";
		sDescripcion+=ComprobanteFacturaConstantesFunciones.SECUENCIAL+"=";
		sDescripcion+=comprobantefactura.getsecuencial()+",";
		sDescripcion+=ComprobanteFacturaConstantesFunciones.FECHA+"=";
		sDescripcion+=comprobantefactura.getfecha().toString()+",";
		sDescripcion+=ComprobanteFacturaConstantesFunciones.CODIGOCLIENTE+"=";
		sDescripcion+=comprobantefactura.getcodigo_cliente()+",";
		sDescripcion+=ComprobanteFacturaConstantesFunciones.NOMBRECLIENTE+"=";
		sDescripcion+=comprobantefactura.getnombre_cliente()+",";
		sDescripcion+=ComprobanteFacturaConstantesFunciones.SUBTOTAL+"=";
		sDescripcion+=comprobantefactura.getsubtotal().toString()+",";
		sDescripcion+=ComprobanteFacturaConstantesFunciones.IVA+"=";
		sDescripcion+=comprobantefactura.getiva().toString()+",";
		sDescripcion+=ComprobanteFacturaConstantesFunciones.DESCUENTO+"=";
		sDescripcion+=comprobantefactura.getdescuento().toString()+",";
		sDescripcion+=ComprobanteFacturaConstantesFunciones.FINANCIAMIENTO+"=";
		sDescripcion+=comprobantefactura.getfinanciamiento().toString()+",";
		sDescripcion+=ComprobanteFacturaConstantesFunciones.FLETE+"=";
		sDescripcion+=comprobantefactura.getflete().toString()+",";
		sDescripcion+=ComprobanteFacturaConstantesFunciones.ICE+"=";
		sDescripcion+=comprobantefactura.getice().toString()+",";
		sDescripcion+=ComprobanteFacturaConstantesFunciones.TOTAL+"=";
		sDescripcion+=comprobantefactura.gettotal().toString()+",";
		sDescripcion+=ComprobanteFacturaConstantesFunciones.CANTIDADFORMASPAGO+"=";
		sDescripcion+=comprobantefactura.getcantidad_formas_pago().toString()+",";
		sDescripcion+=ComprobanteFacturaConstantesFunciones.DESCUENTOREAL+"=";
		sDescripcion+=comprobantefactura.getdescuento_real().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setComprobanteFacturaDescripcion(ComprobanteFactura comprobantefactura,String sValor) throws Exception {			
		if(comprobantefactura !=null) {
			//comprobantefacturacomprobantefactura.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getVendedorDescripcion(Vendedor vendedor) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(vendedor!=null/*&&vendedor.getId()>0*/) {
			sDescripcion=VendedorConstantesFunciones.getVendedorDescripcion(vendedor);
		}

		return sDescripcion;
	}

	public static String getCajaDescripcion(Caja caja) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(caja!=null/*&&caja.getId()>0*/) {
			sDescripcion=CajaConstantesFunciones.getCajaDescripcion(caja);
		}

		return sDescripcion;
	}

	public static String getClienteDescripcion(Cliente cliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cliente!=null/*&&cliente.getId()>0*/) {
			sDescripcion=ClienteConstantesFunciones.getClienteDescripcion(cliente);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaComprobanteFactura")) {
			sNombreIndice="Tipo=  Por Vendedor Por Fecha Inicio Por Fecha Fin";
		} else if(sNombreIndice.equals("FK_IdCaja")) {
			sNombreIndice="Tipo=  Por Caja";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdVendedor")) {
			sNombreIndice="Tipo=  Por Vendedor";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaComprobanteFactura(Long id_vendedor,Date fecha_inicio,Date fecha_fin) {
		String sDetalleIndice=" Parametros->";
		if(id_vendedor!=null) {sDetalleIndice+=" Codigo Unico De Vendedor="+id_vendedor.toString();}
		if(fecha_inicio!=null) {sDetalleIndice+=" Fecha Inicio="+fecha_inicio.toString();}
		if(fecha_fin!=null) {sDetalleIndice+=" Fecha Fin="+fecha_fin.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCaja(Long id_caja) {
		String sDetalleIndice=" Parametros->";
		if(id_caja!=null) {sDetalleIndice+=" Codigo Unico De Caja="+id_caja.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCliente(Long id_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+id_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdVendedor(Long id_vendedor) {
		String sDetalleIndice=" Parametros->";
		if(id_vendedor!=null) {sDetalleIndice+=" Codigo Unico De Vendedor="+id_vendedor.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosComprobanteFactura(ComprobanteFactura comprobantefactura,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		comprobantefactura.setnombre_caja(comprobantefactura.getnombre_caja().trim());
		comprobantefactura.setsecuencial(comprobantefactura.getsecuencial().trim());
		comprobantefactura.setcodigo_cliente(comprobantefactura.getcodigo_cliente().trim());
		comprobantefactura.setnombre_cliente(comprobantefactura.getnombre_cliente().trim());
	}
	
	public static void quitarEspaciosComprobanteFacturas(List<ComprobanteFactura> comprobantefacturas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ComprobanteFactura comprobantefactura: comprobantefacturas) {
			comprobantefactura.setnombre_caja(comprobantefactura.getnombre_caja().trim());
			comprobantefactura.setsecuencial(comprobantefactura.getsecuencial().trim());
			comprobantefactura.setcodigo_cliente(comprobantefactura.getcodigo_cliente().trim());
			comprobantefactura.setnombre_cliente(comprobantefactura.getnombre_cliente().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresComprobanteFactura(ComprobanteFactura comprobantefactura,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && comprobantefactura.getConCambioAuxiliar()) {
			comprobantefactura.setIsDeleted(comprobantefactura.getIsDeletedAuxiliar());	
			comprobantefactura.setIsNew(comprobantefactura.getIsNewAuxiliar());	
			comprobantefactura.setIsChanged(comprobantefactura.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			comprobantefactura.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			comprobantefactura.setIsDeletedAuxiliar(false);	
			comprobantefactura.setIsNewAuxiliar(false);	
			comprobantefactura.setIsChangedAuxiliar(false);
			
			comprobantefactura.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresComprobanteFacturas(List<ComprobanteFactura> comprobantefacturas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ComprobanteFactura comprobantefactura : comprobantefacturas) {
			if(conAsignarBase && comprobantefactura.getConCambioAuxiliar()) {
				comprobantefactura.setIsDeleted(comprobantefactura.getIsDeletedAuxiliar());	
				comprobantefactura.setIsNew(comprobantefactura.getIsNewAuxiliar());	
				comprobantefactura.setIsChanged(comprobantefactura.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				comprobantefactura.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				comprobantefactura.setIsDeletedAuxiliar(false);	
				comprobantefactura.setIsNewAuxiliar(false);	
				comprobantefactura.setIsChangedAuxiliar(false);
				
				comprobantefactura.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresComprobanteFactura(ComprobanteFactura comprobantefactura,Boolean conEnteros) throws Exception  {
		comprobantefactura.setsubtotal(0.0);
		comprobantefactura.setiva(0.0);
		comprobantefactura.setdescuento(0.0);
		comprobantefactura.setfinanciamiento(0.0);
		comprobantefactura.setflete(0.0);
		comprobantefactura.setice(0.0);
		comprobantefactura.settotal(0.0);
		comprobantefactura.setdescuento_real(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			comprobantefactura.setcantidad_formas_pago(0);
		}
	}		
	
	public static void InicializarValoresComprobanteFacturas(List<ComprobanteFactura> comprobantefacturas,Boolean conEnteros) throws Exception  {
		
		for(ComprobanteFactura comprobantefactura: comprobantefacturas) {
			comprobantefactura.setsubtotal(0.0);
			comprobantefactura.setiva(0.0);
			comprobantefactura.setdescuento(0.0);
			comprobantefactura.setfinanciamiento(0.0);
			comprobantefactura.setflete(0.0);
			comprobantefactura.setice(0.0);
			comprobantefactura.settotal(0.0);
			comprobantefactura.setdescuento_real(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				comprobantefactura.setcantidad_formas_pago(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaComprobanteFactura(List<ComprobanteFactura> comprobantefacturas,ComprobanteFactura comprobantefacturaAux) throws Exception  {
		ComprobanteFacturaConstantesFunciones.InicializarValoresComprobanteFactura(comprobantefacturaAux,true);
		
		for(ComprobanteFactura comprobantefactura: comprobantefacturas) {
			if(comprobantefactura.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			comprobantefacturaAux.setsubtotal(comprobantefacturaAux.getsubtotal()+comprobantefactura.getsubtotal());			
			comprobantefacturaAux.setiva(comprobantefacturaAux.getiva()+comprobantefactura.getiva());			
			comprobantefacturaAux.setdescuento(comprobantefacturaAux.getdescuento()+comprobantefactura.getdescuento());			
			comprobantefacturaAux.setfinanciamiento(comprobantefacturaAux.getfinanciamiento()+comprobantefactura.getfinanciamiento());			
			comprobantefacturaAux.setflete(comprobantefacturaAux.getflete()+comprobantefactura.getflete());			
			comprobantefacturaAux.setice(comprobantefacturaAux.getice()+comprobantefactura.getice());			
			comprobantefacturaAux.settotal(comprobantefacturaAux.gettotal()+comprobantefactura.gettotal());			
			comprobantefacturaAux.setcantidad_formas_pago(comprobantefacturaAux.getcantidad_formas_pago()+comprobantefactura.getcantidad_formas_pago());			
			comprobantefacturaAux.setdescuento_real(comprobantefacturaAux.getdescuento_real()+comprobantefactura.getdescuento_real());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesComprobanteFactura(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ComprobanteFacturaConstantesFunciones.getArrayColumnasGlobalesComprobanteFactura(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesComprobanteFactura(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ComprobanteFacturaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ComprobanteFacturaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoComprobanteFactura(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ComprobanteFactura> comprobantefacturas,ComprobanteFactura comprobantefactura,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ComprobanteFactura comprobantefacturaAux: comprobantefacturas) {
			if(comprobantefacturaAux!=null && comprobantefactura!=null) {
				if((comprobantefacturaAux.getId()==null && comprobantefactura.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(comprobantefacturaAux.getId()!=null && comprobantefactura.getId()!=null){
					if(comprobantefacturaAux.getId().equals(comprobantefactura.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaComprobanteFactura(List<ComprobanteFactura> comprobantefacturas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double subtotalTotal=0.0;
		Double ivaTotal=0.0;
		Double descuentoTotal=0.0;
		Double financiamientoTotal=0.0;
		Double fleteTotal=0.0;
		Double iceTotal=0.0;
		Double totalTotal=0.0;
		Double descuento_realTotal=0.0;
	
		for(ComprobanteFactura comprobantefactura: comprobantefacturas) {			
			if(comprobantefactura.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			subtotalTotal+=comprobantefactura.getsubtotal();
			ivaTotal+=comprobantefactura.getiva();
			descuentoTotal+=comprobantefactura.getdescuento();
			financiamientoTotal+=comprobantefactura.getfinanciamiento();
			fleteTotal+=comprobantefactura.getflete();
			iceTotal+=comprobantefactura.getice();
			totalTotal+=comprobantefactura.gettotal();
			descuento_realTotal+=comprobantefactura.getdescuento_real();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobanteFacturaConstantesFunciones.SUBTOTAL);
		datoGeneral.setsDescripcion(ComprobanteFacturaConstantesFunciones.LABEL_SUBTOTAL);
		datoGeneral.setdValorDouble(subtotalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobanteFacturaConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(ComprobanteFacturaConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobanteFacturaConstantesFunciones.DESCUENTO);
		datoGeneral.setsDescripcion(ComprobanteFacturaConstantesFunciones.LABEL_DESCUENTO);
		datoGeneral.setdValorDouble(descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobanteFacturaConstantesFunciones.FINANCIAMIENTO);
		datoGeneral.setsDescripcion(ComprobanteFacturaConstantesFunciones.LABEL_FINANCIAMIENTO);
		datoGeneral.setdValorDouble(financiamientoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobanteFacturaConstantesFunciones.FLETE);
		datoGeneral.setsDescripcion(ComprobanteFacturaConstantesFunciones.LABEL_FLETE);
		datoGeneral.setdValorDouble(fleteTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobanteFacturaConstantesFunciones.ICE);
		datoGeneral.setsDescripcion(ComprobanteFacturaConstantesFunciones.LABEL_ICE);
		datoGeneral.setdValorDouble(iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobanteFacturaConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(ComprobanteFacturaConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ComprobanteFacturaConstantesFunciones.DESCUENTOREAL);
		datoGeneral.setsDescripcion(ComprobanteFacturaConstantesFunciones.LABEL_DESCUENTOREAL);
		datoGeneral.setdValorDouble(descuento_realTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaComprobanteFactura() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ComprobanteFacturaConstantesFunciones.LABEL_ID, ComprobanteFacturaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteFacturaConstantesFunciones.LABEL_VERSIONROW, ComprobanteFacturaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteFacturaConstantesFunciones.LABEL_IDCAJA, ComprobanteFacturaConstantesFunciones.IDCAJA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteFacturaConstantesFunciones.LABEL_IDCLIENTE, ComprobanteFacturaConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteFacturaConstantesFunciones.LABEL_NOMBRECAJA, ComprobanteFacturaConstantesFunciones.NOMBRECAJA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteFacturaConstantesFunciones.LABEL_SECUENCIAL, ComprobanteFacturaConstantesFunciones.SECUENCIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteFacturaConstantesFunciones.LABEL_FECHA, ComprobanteFacturaConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteFacturaConstantesFunciones.LABEL_CODIGOCLIENTE, ComprobanteFacturaConstantesFunciones.CODIGOCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteFacturaConstantesFunciones.LABEL_NOMBRECLIENTE, ComprobanteFacturaConstantesFunciones.NOMBRECLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteFacturaConstantesFunciones.LABEL_SUBTOTAL, ComprobanteFacturaConstantesFunciones.SUBTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteFacturaConstantesFunciones.LABEL_IVA, ComprobanteFacturaConstantesFunciones.IVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteFacturaConstantesFunciones.LABEL_DESCUENTO, ComprobanteFacturaConstantesFunciones.DESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteFacturaConstantesFunciones.LABEL_FINANCIAMIENTO, ComprobanteFacturaConstantesFunciones.FINANCIAMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteFacturaConstantesFunciones.LABEL_FLETE, ComprobanteFacturaConstantesFunciones.FLETE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteFacturaConstantesFunciones.LABEL_ICE, ComprobanteFacturaConstantesFunciones.ICE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteFacturaConstantesFunciones.LABEL_TOTAL, ComprobanteFacturaConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteFacturaConstantesFunciones.LABEL_CANTIDADFORMASPAGO, ComprobanteFacturaConstantesFunciones.CANTIDADFORMASPAGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ComprobanteFacturaConstantesFunciones.LABEL_DESCUENTOREAL, ComprobanteFacturaConstantesFunciones.DESCUENTOREAL,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasComprobanteFactura() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ComprobanteFacturaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteFacturaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteFacturaConstantesFunciones.IDCAJA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteFacturaConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteFacturaConstantesFunciones.NOMBRECAJA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteFacturaConstantesFunciones.SECUENCIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteFacturaConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteFacturaConstantesFunciones.CODIGOCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteFacturaConstantesFunciones.NOMBRECLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteFacturaConstantesFunciones.SUBTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteFacturaConstantesFunciones.IVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteFacturaConstantesFunciones.DESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteFacturaConstantesFunciones.FINANCIAMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteFacturaConstantesFunciones.FLETE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteFacturaConstantesFunciones.ICE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteFacturaConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteFacturaConstantesFunciones.CANTIDADFORMASPAGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ComprobanteFacturaConstantesFunciones.DESCUENTOREAL;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarComprobanteFactura() throws Exception  {
		return ComprobanteFacturaConstantesFunciones.getTiposSeleccionarComprobanteFactura(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarComprobanteFactura(Boolean conFk) throws Exception  {
		return ComprobanteFacturaConstantesFunciones.getTiposSeleccionarComprobanteFactura(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarComprobanteFactura(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFacturaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ComprobanteFacturaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFacturaConstantesFunciones.LABEL_IDVENDEDOR);
			reporte.setsDescripcion(ComprobanteFacturaConstantesFunciones.LABEL_IDVENDEDOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFacturaConstantesFunciones.LABEL_FECHAINICIO);
			reporte.setsDescripcion(ComprobanteFacturaConstantesFunciones.LABEL_FECHAINICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFacturaConstantesFunciones.LABEL_FECHAFIN);
			reporte.setsDescripcion(ComprobanteFacturaConstantesFunciones.LABEL_FECHAFIN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFacturaConstantesFunciones.LABEL_IDCAJA);
			reporte.setsDescripcion(ComprobanteFacturaConstantesFunciones.LABEL_IDCAJA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFacturaConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(ComprobanteFacturaConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFacturaConstantesFunciones.LABEL_NOMBRECAJA);
			reporte.setsDescripcion(ComprobanteFacturaConstantesFunciones.LABEL_NOMBRECAJA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFacturaConstantesFunciones.LABEL_SECUENCIAL);
			reporte.setsDescripcion(ComprobanteFacturaConstantesFunciones.LABEL_SECUENCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFacturaConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(ComprobanteFacturaConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFacturaConstantesFunciones.LABEL_CODIGOCLIENTE);
			reporte.setsDescripcion(ComprobanteFacturaConstantesFunciones.LABEL_CODIGOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFacturaConstantesFunciones.LABEL_NOMBRECLIENTE);
			reporte.setsDescripcion(ComprobanteFacturaConstantesFunciones.LABEL_NOMBRECLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFacturaConstantesFunciones.LABEL_SUBTOTAL);
			reporte.setsDescripcion(ComprobanteFacturaConstantesFunciones.LABEL_SUBTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFacturaConstantesFunciones.LABEL_IVA);
			reporte.setsDescripcion(ComprobanteFacturaConstantesFunciones.LABEL_IVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFacturaConstantesFunciones.LABEL_DESCUENTO);
			reporte.setsDescripcion(ComprobanteFacturaConstantesFunciones.LABEL_DESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFacturaConstantesFunciones.LABEL_FINANCIAMIENTO);
			reporte.setsDescripcion(ComprobanteFacturaConstantesFunciones.LABEL_FINANCIAMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFacturaConstantesFunciones.LABEL_FLETE);
			reporte.setsDescripcion(ComprobanteFacturaConstantesFunciones.LABEL_FLETE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFacturaConstantesFunciones.LABEL_ICE);
			reporte.setsDescripcion(ComprobanteFacturaConstantesFunciones.LABEL_ICE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFacturaConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(ComprobanteFacturaConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFacturaConstantesFunciones.LABEL_CANTIDADFORMASPAGO);
			reporte.setsDescripcion(ComprobanteFacturaConstantesFunciones.LABEL_CANTIDADFORMASPAGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ComprobanteFacturaConstantesFunciones.LABEL_DESCUENTOREAL);
			reporte.setsDescripcion(ComprobanteFacturaConstantesFunciones.LABEL_DESCUENTOREAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesComprobanteFactura(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesComprobanteFactura(ComprobanteFactura comprobantefacturaAux) throws Exception {
		
			comprobantefacturaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(comprobantefacturaAux.getEmpresa()));
			comprobantefacturaAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(comprobantefacturaAux.getVendedor()));
			comprobantefacturaAux.setcaja_descripcion(CajaConstantesFunciones.getCajaDescripcion(comprobantefacturaAux.getCaja()));
			comprobantefacturaAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(comprobantefacturaAux.getCliente()));		
	}
	
	public static void refrescarForeignKeysDescripcionesComprobanteFactura(List<ComprobanteFactura> comprobantefacturasTemp) throws Exception {
		for(ComprobanteFactura comprobantefacturaAux:comprobantefacturasTemp) {
			
			comprobantefacturaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(comprobantefacturaAux.getEmpresa()));
			comprobantefacturaAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(comprobantefacturaAux.getVendedor()));
			comprobantefacturaAux.setcaja_descripcion(CajaConstantesFunciones.getCajaDescripcion(comprobantefacturaAux.getCaja()));
			comprobantefacturaAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(comprobantefacturaAux.getCliente()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfComprobanteFactura(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Vendedor.class));
				classes.add(new Classe(Caja.class));
				classes.add(new Classe(Cliente.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Vendedor.class)) {
						classes.add(new Classe(Vendedor.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Caja.class)) {
						classes.add(new Classe(Caja.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfComprobanteFactura(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Vendedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vendedor.class)); continue;
					}

					if(Caja.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Caja.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Vendedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vendedor.class)); continue;
					}

					if(Caja.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Caja.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfComprobanteFactura(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ComprobanteFacturaConstantesFunciones.getClassesRelationshipsOfComprobanteFactura(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfComprobanteFactura(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfComprobanteFactura(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ComprobanteFacturaConstantesFunciones.getClassesRelationshipsFromStringsOfComprobanteFactura(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfComprobanteFactura(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ComprobanteFactura comprobantefactura,List<ComprobanteFactura> comprobantefacturas,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ComprobanteFactura comprobantefactura,List<ComprobanteFactura> comprobantefacturas) throws Exception {
		try	{			
			for(ComprobanteFactura comprobantefacturaLocal:comprobantefacturas) {
				if(comprobantefacturaLocal.getId().equals(comprobantefactura.getId())) {
					comprobantefacturaLocal.setIsSelected(comprobantefactura.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesComprobanteFactura(List<ComprobanteFactura> comprobantefacturasAux) throws Exception {
		//this.comprobantefacturasAux=comprobantefacturasAux;
		
		for(ComprobanteFactura comprobantefacturaAux:comprobantefacturasAux) {
			if(comprobantefacturaAux.getIsChanged()) {
				comprobantefacturaAux.setIsChanged(false);
			}		
			
			if(comprobantefacturaAux.getIsNew()) {
				comprobantefacturaAux.setIsNew(false);
			}	
			
			if(comprobantefacturaAux.getIsDeleted()) {
				comprobantefacturaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesComprobanteFactura(ComprobanteFactura comprobantefacturaAux) throws Exception {
		//this.comprobantefacturaAux=comprobantefacturaAux;
		
			if(comprobantefacturaAux.getIsChanged()) {
				comprobantefacturaAux.setIsChanged(false);
			}		
			
			if(comprobantefacturaAux.getIsNew()) {
				comprobantefacturaAux.setIsNew(false);
			}	
			
			if(comprobantefacturaAux.getIsDeleted()) {
				comprobantefacturaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ComprobanteFactura comprobantefacturaAsignar,ComprobanteFactura comprobantefactura) throws Exception {
		comprobantefacturaAsignar.setId(comprobantefactura.getId());	
		comprobantefacturaAsignar.setVersionRow(comprobantefactura.getVersionRow());	
		comprobantefacturaAsignar.setid_caja(comprobantefactura.getid_caja());
		comprobantefacturaAsignar.setcaja_descripcion(comprobantefactura.getcaja_descripcion());	
		comprobantefacturaAsignar.setid_cliente(comprobantefactura.getid_cliente());
		comprobantefacturaAsignar.setcliente_descripcion(comprobantefactura.getcliente_descripcion());	
		comprobantefacturaAsignar.setnombre_caja(comprobantefactura.getnombre_caja());	
		comprobantefacturaAsignar.setsecuencial(comprobantefactura.getsecuencial());	
		comprobantefacturaAsignar.setfecha(comprobantefactura.getfecha());	
		comprobantefacturaAsignar.setcodigo_cliente(comprobantefactura.getcodigo_cliente());	
		comprobantefacturaAsignar.setnombre_cliente(comprobantefactura.getnombre_cliente());	
		comprobantefacturaAsignar.setsubtotal(comprobantefactura.getsubtotal());	
		comprobantefacturaAsignar.setiva(comprobantefactura.getiva());	
		comprobantefacturaAsignar.setdescuento(comprobantefactura.getdescuento());	
		comprobantefacturaAsignar.setfinanciamiento(comprobantefactura.getfinanciamiento());	
		comprobantefacturaAsignar.setflete(comprobantefactura.getflete());	
		comprobantefacturaAsignar.setice(comprobantefactura.getice());	
		comprobantefacturaAsignar.settotal(comprobantefactura.gettotal());	
		comprobantefacturaAsignar.setcantidad_formas_pago(comprobantefactura.getcantidad_formas_pago());	
		comprobantefacturaAsignar.setdescuento_real(comprobantefactura.getdescuento_real());	
	}
	
	public static void inicializarComprobanteFactura(ComprobanteFactura comprobantefactura) throws Exception {
		try {
				comprobantefactura.setId(0L);	
					
				comprobantefactura.setid_caja(-1L);	
				comprobantefactura.setid_cliente(-1L);	
				comprobantefactura.setnombre_caja("");	
				comprobantefactura.setsecuencial("");	
				comprobantefactura.setfecha(new Date());	
				comprobantefactura.setcodigo_cliente("");	
				comprobantefactura.setnombre_cliente("");	
				comprobantefactura.setsubtotal(0.0);	
				comprobantefactura.setiva(0.0);	
				comprobantefactura.setdescuento(0.0);	
				comprobantefactura.setfinanciamiento(0.0);	
				comprobantefactura.setflete(0.0);	
				comprobantefactura.setice(0.0);	
				comprobantefactura.settotal(0.0);	
				comprobantefactura.setcantidad_formas_pago(0);	
				comprobantefactura.setdescuento_real(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderComprobanteFactura(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFacturaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFacturaConstantesFunciones.LABEL_IDVENDEDOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFacturaConstantesFunciones.LABEL_FECHAINICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFacturaConstantesFunciones.LABEL_FECHAFIN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFacturaConstantesFunciones.LABEL_IDCAJA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFacturaConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFacturaConstantesFunciones.LABEL_NOMBRECAJA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFacturaConstantesFunciones.LABEL_SECUENCIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFacturaConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFacturaConstantesFunciones.LABEL_CODIGOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFacturaConstantesFunciones.LABEL_NOMBRECLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFacturaConstantesFunciones.LABEL_SUBTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFacturaConstantesFunciones.LABEL_IVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFacturaConstantesFunciones.LABEL_DESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFacturaConstantesFunciones.LABEL_FINANCIAMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFacturaConstantesFunciones.LABEL_FLETE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFacturaConstantesFunciones.LABEL_ICE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFacturaConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFacturaConstantesFunciones.LABEL_CANTIDADFORMASPAGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ComprobanteFacturaConstantesFunciones.LABEL_DESCUENTOREAL);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataComprobanteFactura(String sTipo,Row row,Workbook workbook,ComprobanteFactura comprobantefactura,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantefactura.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantefactura.getvendedor_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantefactura.getfecha_inicio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantefactura.getfecha_fin());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantefactura.getcaja_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantefactura.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantefactura.getnombre_caja());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantefactura.getsecuencial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantefactura.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantefactura.getcodigo_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantefactura.getnombre_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantefactura.getsubtotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantefactura.getiva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantefactura.getdescuento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantefactura.getfinanciamiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantefactura.getflete());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantefactura.getice());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantefactura.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantefactura.getcantidad_formas_pago());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(comprobantefactura.getdescuento_real());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryComprobanteFactura="";
	
	public String getsFinalQueryComprobanteFactura() {
		return this.sFinalQueryComprobanteFactura;
	}
	
	public void setsFinalQueryComprobanteFactura(String sFinalQueryComprobanteFactura) {
		this.sFinalQueryComprobanteFactura= sFinalQueryComprobanteFactura;
	}
	
	public Border resaltarSeleccionarComprobanteFactura=null;
	
	public Border setResaltarSeleccionarComprobanteFactura(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFacturaBeanSwingJInternalFrame comprobantefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//comprobantefacturaBeanSwingJInternalFrame.jTtoolBarComprobanteFactura.setBorder(borderResaltar);
		
		this.resaltarSeleccionarComprobanteFactura= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarComprobanteFactura() {
		return this.resaltarSeleccionarComprobanteFactura;
	}
	
	public void setResaltarSeleccionarComprobanteFactura(Border borderResaltarSeleccionarComprobanteFactura) {
		this.resaltarSeleccionarComprobanteFactura= borderResaltarSeleccionarComprobanteFactura;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridComprobanteFactura=null;
	public Boolean mostraridComprobanteFactura=true;
	public Boolean activaridComprobanteFactura=true;

	public Border resaltarid_empresaComprobanteFactura=null;
	public Boolean mostrarid_empresaComprobanteFactura=true;
	public Boolean activarid_empresaComprobanteFactura=true;
	public Boolean cargarid_empresaComprobanteFactura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaComprobanteFactura=false;//ConEventDepend=true

	public Border resaltarid_vendedorComprobanteFactura=null;
	public Boolean mostrarid_vendedorComprobanteFactura=true;
	public Boolean activarid_vendedorComprobanteFactura=true;
	public Boolean cargarid_vendedorComprobanteFactura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_vendedorComprobanteFactura=false;//ConEventDepend=true

	public Border resaltarfecha_inicioComprobanteFactura=null;
	public Boolean mostrarfecha_inicioComprobanteFactura=true;
	public Boolean activarfecha_inicioComprobanteFactura=true;

	public Border resaltarfecha_finComprobanteFactura=null;
	public Boolean mostrarfecha_finComprobanteFactura=true;
	public Boolean activarfecha_finComprobanteFactura=true;

	public Border resaltarid_cajaComprobanteFactura=null;
	public Boolean mostrarid_cajaComprobanteFactura=true;
	public Boolean activarid_cajaComprobanteFactura=false;
	public Boolean cargarid_cajaComprobanteFactura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cajaComprobanteFactura=false;//ConEventDepend=true

	public Border resaltarid_clienteComprobanteFactura=null;
	public Boolean mostrarid_clienteComprobanteFactura=true;
	public Boolean activarid_clienteComprobanteFactura=false;
	public Boolean cargarid_clienteComprobanteFactura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteComprobanteFactura=false;//ConEventDepend=true

	public Border resaltarnombre_cajaComprobanteFactura=null;
	public Boolean mostrarnombre_cajaComprobanteFactura=true;
	public Boolean activarnombre_cajaComprobanteFactura=true;

	public Border resaltarsecuencialComprobanteFactura=null;
	public Boolean mostrarsecuencialComprobanteFactura=true;
	public Boolean activarsecuencialComprobanteFactura=true;

	public Border resaltarfechaComprobanteFactura=null;
	public Boolean mostrarfechaComprobanteFactura=true;
	public Boolean activarfechaComprobanteFactura=true;

	public Border resaltarcodigo_clienteComprobanteFactura=null;
	public Boolean mostrarcodigo_clienteComprobanteFactura=true;
	public Boolean activarcodigo_clienteComprobanteFactura=true;

	public Border resaltarnombre_clienteComprobanteFactura=null;
	public Boolean mostrarnombre_clienteComprobanteFactura=true;
	public Boolean activarnombre_clienteComprobanteFactura=true;

	public Border resaltarsubtotalComprobanteFactura=null;
	public Boolean mostrarsubtotalComprobanteFactura=true;
	public Boolean activarsubtotalComprobanteFactura=true;

	public Border resaltarivaComprobanteFactura=null;
	public Boolean mostrarivaComprobanteFactura=true;
	public Boolean activarivaComprobanteFactura=true;

	public Border resaltardescuentoComprobanteFactura=null;
	public Boolean mostrardescuentoComprobanteFactura=true;
	public Boolean activardescuentoComprobanteFactura=true;

	public Border resaltarfinanciamientoComprobanteFactura=null;
	public Boolean mostrarfinanciamientoComprobanteFactura=true;
	public Boolean activarfinanciamientoComprobanteFactura=true;

	public Border resaltarfleteComprobanteFactura=null;
	public Boolean mostrarfleteComprobanteFactura=true;
	public Boolean activarfleteComprobanteFactura=true;

	public Border resaltariceComprobanteFactura=null;
	public Boolean mostrariceComprobanteFactura=true;
	public Boolean activariceComprobanteFactura=true;

	public Border resaltartotalComprobanteFactura=null;
	public Boolean mostrartotalComprobanteFactura=true;
	public Boolean activartotalComprobanteFactura=true;

	public Border resaltarcantidad_formas_pagoComprobanteFactura=null;
	public Boolean mostrarcantidad_formas_pagoComprobanteFactura=true;
	public Boolean activarcantidad_formas_pagoComprobanteFactura=true;

	public Border resaltardescuento_realComprobanteFactura=null;
	public Boolean mostrardescuento_realComprobanteFactura=true;
	public Boolean activardescuento_realComprobanteFactura=true;

	
	

	public Border setResaltaridComprobanteFactura(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFacturaBeanSwingJInternalFrame comprobantefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantefacturaBeanSwingJInternalFrame.jTtoolBarComprobanteFactura.setBorder(borderResaltar);
		
		this.resaltaridComprobanteFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridComprobanteFactura() {
		return this.resaltaridComprobanteFactura;
	}

	public void setResaltaridComprobanteFactura(Border borderResaltar) {
		this.resaltaridComprobanteFactura= borderResaltar;
	}

	public Boolean getMostraridComprobanteFactura() {
		return this.mostraridComprobanteFactura;
	}

	public void setMostraridComprobanteFactura(Boolean mostraridComprobanteFactura) {
		this.mostraridComprobanteFactura= mostraridComprobanteFactura;
	}

	public Boolean getActivaridComprobanteFactura() {
		return this.activaridComprobanteFactura;
	}

	public void setActivaridComprobanteFactura(Boolean activaridComprobanteFactura) {
		this.activaridComprobanteFactura= activaridComprobanteFactura;
	}

	public Border setResaltarid_empresaComprobanteFactura(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFacturaBeanSwingJInternalFrame comprobantefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantefacturaBeanSwingJInternalFrame.jTtoolBarComprobanteFactura.setBorder(borderResaltar);
		
		this.resaltarid_empresaComprobanteFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaComprobanteFactura() {
		return this.resaltarid_empresaComprobanteFactura;
	}

	public void setResaltarid_empresaComprobanteFactura(Border borderResaltar) {
		this.resaltarid_empresaComprobanteFactura= borderResaltar;
	}

	public Boolean getMostrarid_empresaComprobanteFactura() {
		return this.mostrarid_empresaComprobanteFactura;
	}

	public void setMostrarid_empresaComprobanteFactura(Boolean mostrarid_empresaComprobanteFactura) {
		this.mostrarid_empresaComprobanteFactura= mostrarid_empresaComprobanteFactura;
	}

	public Boolean getActivarid_empresaComprobanteFactura() {
		return this.activarid_empresaComprobanteFactura;
	}

	public void setActivarid_empresaComprobanteFactura(Boolean activarid_empresaComprobanteFactura) {
		this.activarid_empresaComprobanteFactura= activarid_empresaComprobanteFactura;
	}

	public Boolean getCargarid_empresaComprobanteFactura() {
		return this.cargarid_empresaComprobanteFactura;
	}

	public void setCargarid_empresaComprobanteFactura(Boolean cargarid_empresaComprobanteFactura) {
		this.cargarid_empresaComprobanteFactura= cargarid_empresaComprobanteFactura;
	}

	public Border setResaltarid_vendedorComprobanteFactura(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFacturaBeanSwingJInternalFrame comprobantefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantefacturaBeanSwingJInternalFrame.jTtoolBarComprobanteFactura.setBorder(borderResaltar);
		
		this.resaltarid_vendedorComprobanteFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_vendedorComprobanteFactura() {
		return this.resaltarid_vendedorComprobanteFactura;
	}

	public void setResaltarid_vendedorComprobanteFactura(Border borderResaltar) {
		this.resaltarid_vendedorComprobanteFactura= borderResaltar;
	}

	public Boolean getMostrarid_vendedorComprobanteFactura() {
		return this.mostrarid_vendedorComprobanteFactura;
	}

	public void setMostrarid_vendedorComprobanteFactura(Boolean mostrarid_vendedorComprobanteFactura) {
		this.mostrarid_vendedorComprobanteFactura= mostrarid_vendedorComprobanteFactura;
	}

	public Boolean getActivarid_vendedorComprobanteFactura() {
		return this.activarid_vendedorComprobanteFactura;
	}

	public void setActivarid_vendedorComprobanteFactura(Boolean activarid_vendedorComprobanteFactura) {
		this.activarid_vendedorComprobanteFactura= activarid_vendedorComprobanteFactura;
	}

	public Boolean getCargarid_vendedorComprobanteFactura() {
		return this.cargarid_vendedorComprobanteFactura;
	}

	public void setCargarid_vendedorComprobanteFactura(Boolean cargarid_vendedorComprobanteFactura) {
		this.cargarid_vendedorComprobanteFactura= cargarid_vendedorComprobanteFactura;
	}

	public Border setResaltarfecha_inicioComprobanteFactura(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFacturaBeanSwingJInternalFrame comprobantefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantefacturaBeanSwingJInternalFrame.jTtoolBarComprobanteFactura.setBorder(borderResaltar);
		
		this.resaltarfecha_inicioComprobanteFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_inicioComprobanteFactura() {
		return this.resaltarfecha_inicioComprobanteFactura;
	}

	public void setResaltarfecha_inicioComprobanteFactura(Border borderResaltar) {
		this.resaltarfecha_inicioComprobanteFactura= borderResaltar;
	}

	public Boolean getMostrarfecha_inicioComprobanteFactura() {
		return this.mostrarfecha_inicioComprobanteFactura;
	}

	public void setMostrarfecha_inicioComprobanteFactura(Boolean mostrarfecha_inicioComprobanteFactura) {
		this.mostrarfecha_inicioComprobanteFactura= mostrarfecha_inicioComprobanteFactura;
	}

	public Boolean getActivarfecha_inicioComprobanteFactura() {
		return this.activarfecha_inicioComprobanteFactura;
	}

	public void setActivarfecha_inicioComprobanteFactura(Boolean activarfecha_inicioComprobanteFactura) {
		this.activarfecha_inicioComprobanteFactura= activarfecha_inicioComprobanteFactura;
	}

	public Border setResaltarfecha_finComprobanteFactura(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFacturaBeanSwingJInternalFrame comprobantefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantefacturaBeanSwingJInternalFrame.jTtoolBarComprobanteFactura.setBorder(borderResaltar);
		
		this.resaltarfecha_finComprobanteFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_finComprobanteFactura() {
		return this.resaltarfecha_finComprobanteFactura;
	}

	public void setResaltarfecha_finComprobanteFactura(Border borderResaltar) {
		this.resaltarfecha_finComprobanteFactura= borderResaltar;
	}

	public Boolean getMostrarfecha_finComprobanteFactura() {
		return this.mostrarfecha_finComprobanteFactura;
	}

	public void setMostrarfecha_finComprobanteFactura(Boolean mostrarfecha_finComprobanteFactura) {
		this.mostrarfecha_finComprobanteFactura= mostrarfecha_finComprobanteFactura;
	}

	public Boolean getActivarfecha_finComprobanteFactura() {
		return this.activarfecha_finComprobanteFactura;
	}

	public void setActivarfecha_finComprobanteFactura(Boolean activarfecha_finComprobanteFactura) {
		this.activarfecha_finComprobanteFactura= activarfecha_finComprobanteFactura;
	}

	public Border setResaltarid_cajaComprobanteFactura(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFacturaBeanSwingJInternalFrame comprobantefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantefacturaBeanSwingJInternalFrame.jTtoolBarComprobanteFactura.setBorder(borderResaltar);
		
		this.resaltarid_cajaComprobanteFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cajaComprobanteFactura() {
		return this.resaltarid_cajaComprobanteFactura;
	}

	public void setResaltarid_cajaComprobanteFactura(Border borderResaltar) {
		this.resaltarid_cajaComprobanteFactura= borderResaltar;
	}

	public Boolean getMostrarid_cajaComprobanteFactura() {
		return this.mostrarid_cajaComprobanteFactura;
	}

	public void setMostrarid_cajaComprobanteFactura(Boolean mostrarid_cajaComprobanteFactura) {
		this.mostrarid_cajaComprobanteFactura= mostrarid_cajaComprobanteFactura;
	}

	public Boolean getActivarid_cajaComprobanteFactura() {
		return this.activarid_cajaComprobanteFactura;
	}

	public void setActivarid_cajaComprobanteFactura(Boolean activarid_cajaComprobanteFactura) {
		this.activarid_cajaComprobanteFactura= activarid_cajaComprobanteFactura;
	}

	public Boolean getCargarid_cajaComprobanteFactura() {
		return this.cargarid_cajaComprobanteFactura;
	}

	public void setCargarid_cajaComprobanteFactura(Boolean cargarid_cajaComprobanteFactura) {
		this.cargarid_cajaComprobanteFactura= cargarid_cajaComprobanteFactura;
	}

	public Border setResaltarid_clienteComprobanteFactura(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFacturaBeanSwingJInternalFrame comprobantefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantefacturaBeanSwingJInternalFrame.jTtoolBarComprobanteFactura.setBorder(borderResaltar);
		
		this.resaltarid_clienteComprobanteFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteComprobanteFactura() {
		return this.resaltarid_clienteComprobanteFactura;
	}

	public void setResaltarid_clienteComprobanteFactura(Border borderResaltar) {
		this.resaltarid_clienteComprobanteFactura= borderResaltar;
	}

	public Boolean getMostrarid_clienteComprobanteFactura() {
		return this.mostrarid_clienteComprobanteFactura;
	}

	public void setMostrarid_clienteComprobanteFactura(Boolean mostrarid_clienteComprobanteFactura) {
		this.mostrarid_clienteComprobanteFactura= mostrarid_clienteComprobanteFactura;
	}

	public Boolean getActivarid_clienteComprobanteFactura() {
		return this.activarid_clienteComprobanteFactura;
	}

	public void setActivarid_clienteComprobanteFactura(Boolean activarid_clienteComprobanteFactura) {
		this.activarid_clienteComprobanteFactura= activarid_clienteComprobanteFactura;
	}

	public Boolean getCargarid_clienteComprobanteFactura() {
		return this.cargarid_clienteComprobanteFactura;
	}

	public void setCargarid_clienteComprobanteFactura(Boolean cargarid_clienteComprobanteFactura) {
		this.cargarid_clienteComprobanteFactura= cargarid_clienteComprobanteFactura;
	}

	public Border setResaltarnombre_cajaComprobanteFactura(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFacturaBeanSwingJInternalFrame comprobantefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantefacturaBeanSwingJInternalFrame.jTtoolBarComprobanteFactura.setBorder(borderResaltar);
		
		this.resaltarnombre_cajaComprobanteFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_cajaComprobanteFactura() {
		return this.resaltarnombre_cajaComprobanteFactura;
	}

	public void setResaltarnombre_cajaComprobanteFactura(Border borderResaltar) {
		this.resaltarnombre_cajaComprobanteFactura= borderResaltar;
	}

	public Boolean getMostrarnombre_cajaComprobanteFactura() {
		return this.mostrarnombre_cajaComprobanteFactura;
	}

	public void setMostrarnombre_cajaComprobanteFactura(Boolean mostrarnombre_cajaComprobanteFactura) {
		this.mostrarnombre_cajaComprobanteFactura= mostrarnombre_cajaComprobanteFactura;
	}

	public Boolean getActivarnombre_cajaComprobanteFactura() {
		return this.activarnombre_cajaComprobanteFactura;
	}

	public void setActivarnombre_cajaComprobanteFactura(Boolean activarnombre_cajaComprobanteFactura) {
		this.activarnombre_cajaComprobanteFactura= activarnombre_cajaComprobanteFactura;
	}

	public Border setResaltarsecuencialComprobanteFactura(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFacturaBeanSwingJInternalFrame comprobantefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantefacturaBeanSwingJInternalFrame.jTtoolBarComprobanteFactura.setBorder(borderResaltar);
		
		this.resaltarsecuencialComprobanteFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsecuencialComprobanteFactura() {
		return this.resaltarsecuencialComprobanteFactura;
	}

	public void setResaltarsecuencialComprobanteFactura(Border borderResaltar) {
		this.resaltarsecuencialComprobanteFactura= borderResaltar;
	}

	public Boolean getMostrarsecuencialComprobanteFactura() {
		return this.mostrarsecuencialComprobanteFactura;
	}

	public void setMostrarsecuencialComprobanteFactura(Boolean mostrarsecuencialComprobanteFactura) {
		this.mostrarsecuencialComprobanteFactura= mostrarsecuencialComprobanteFactura;
	}

	public Boolean getActivarsecuencialComprobanteFactura() {
		return this.activarsecuencialComprobanteFactura;
	}

	public void setActivarsecuencialComprobanteFactura(Boolean activarsecuencialComprobanteFactura) {
		this.activarsecuencialComprobanteFactura= activarsecuencialComprobanteFactura;
	}

	public Border setResaltarfechaComprobanteFactura(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFacturaBeanSwingJInternalFrame comprobantefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantefacturaBeanSwingJInternalFrame.jTtoolBarComprobanteFactura.setBorder(borderResaltar);
		
		this.resaltarfechaComprobanteFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaComprobanteFactura() {
		return this.resaltarfechaComprobanteFactura;
	}

	public void setResaltarfechaComprobanteFactura(Border borderResaltar) {
		this.resaltarfechaComprobanteFactura= borderResaltar;
	}

	public Boolean getMostrarfechaComprobanteFactura() {
		return this.mostrarfechaComprobanteFactura;
	}

	public void setMostrarfechaComprobanteFactura(Boolean mostrarfechaComprobanteFactura) {
		this.mostrarfechaComprobanteFactura= mostrarfechaComprobanteFactura;
	}

	public Boolean getActivarfechaComprobanteFactura() {
		return this.activarfechaComprobanteFactura;
	}

	public void setActivarfechaComprobanteFactura(Boolean activarfechaComprobanteFactura) {
		this.activarfechaComprobanteFactura= activarfechaComprobanteFactura;
	}

	public Border setResaltarcodigo_clienteComprobanteFactura(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFacturaBeanSwingJInternalFrame comprobantefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantefacturaBeanSwingJInternalFrame.jTtoolBarComprobanteFactura.setBorder(borderResaltar);
		
		this.resaltarcodigo_clienteComprobanteFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_clienteComprobanteFactura() {
		return this.resaltarcodigo_clienteComprobanteFactura;
	}

	public void setResaltarcodigo_clienteComprobanteFactura(Border borderResaltar) {
		this.resaltarcodigo_clienteComprobanteFactura= borderResaltar;
	}

	public Boolean getMostrarcodigo_clienteComprobanteFactura() {
		return this.mostrarcodigo_clienteComprobanteFactura;
	}

	public void setMostrarcodigo_clienteComprobanteFactura(Boolean mostrarcodigo_clienteComprobanteFactura) {
		this.mostrarcodigo_clienteComprobanteFactura= mostrarcodigo_clienteComprobanteFactura;
	}

	public Boolean getActivarcodigo_clienteComprobanteFactura() {
		return this.activarcodigo_clienteComprobanteFactura;
	}

	public void setActivarcodigo_clienteComprobanteFactura(Boolean activarcodigo_clienteComprobanteFactura) {
		this.activarcodigo_clienteComprobanteFactura= activarcodigo_clienteComprobanteFactura;
	}

	public Border setResaltarnombre_clienteComprobanteFactura(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFacturaBeanSwingJInternalFrame comprobantefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantefacturaBeanSwingJInternalFrame.jTtoolBarComprobanteFactura.setBorder(borderResaltar);
		
		this.resaltarnombre_clienteComprobanteFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_clienteComprobanteFactura() {
		return this.resaltarnombre_clienteComprobanteFactura;
	}

	public void setResaltarnombre_clienteComprobanteFactura(Border borderResaltar) {
		this.resaltarnombre_clienteComprobanteFactura= borderResaltar;
	}

	public Boolean getMostrarnombre_clienteComprobanteFactura() {
		return this.mostrarnombre_clienteComprobanteFactura;
	}

	public void setMostrarnombre_clienteComprobanteFactura(Boolean mostrarnombre_clienteComprobanteFactura) {
		this.mostrarnombre_clienteComprobanteFactura= mostrarnombre_clienteComprobanteFactura;
	}

	public Boolean getActivarnombre_clienteComprobanteFactura() {
		return this.activarnombre_clienteComprobanteFactura;
	}

	public void setActivarnombre_clienteComprobanteFactura(Boolean activarnombre_clienteComprobanteFactura) {
		this.activarnombre_clienteComprobanteFactura= activarnombre_clienteComprobanteFactura;
	}

	public Border setResaltarsubtotalComprobanteFactura(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFacturaBeanSwingJInternalFrame comprobantefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantefacturaBeanSwingJInternalFrame.jTtoolBarComprobanteFactura.setBorder(borderResaltar);
		
		this.resaltarsubtotalComprobanteFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsubtotalComprobanteFactura() {
		return this.resaltarsubtotalComprobanteFactura;
	}

	public void setResaltarsubtotalComprobanteFactura(Border borderResaltar) {
		this.resaltarsubtotalComprobanteFactura= borderResaltar;
	}

	public Boolean getMostrarsubtotalComprobanteFactura() {
		return this.mostrarsubtotalComprobanteFactura;
	}

	public void setMostrarsubtotalComprobanteFactura(Boolean mostrarsubtotalComprobanteFactura) {
		this.mostrarsubtotalComprobanteFactura= mostrarsubtotalComprobanteFactura;
	}

	public Boolean getActivarsubtotalComprobanteFactura() {
		return this.activarsubtotalComprobanteFactura;
	}

	public void setActivarsubtotalComprobanteFactura(Boolean activarsubtotalComprobanteFactura) {
		this.activarsubtotalComprobanteFactura= activarsubtotalComprobanteFactura;
	}

	public Border setResaltarivaComprobanteFactura(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFacturaBeanSwingJInternalFrame comprobantefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantefacturaBeanSwingJInternalFrame.jTtoolBarComprobanteFactura.setBorder(borderResaltar);
		
		this.resaltarivaComprobanteFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarivaComprobanteFactura() {
		return this.resaltarivaComprobanteFactura;
	}

	public void setResaltarivaComprobanteFactura(Border borderResaltar) {
		this.resaltarivaComprobanteFactura= borderResaltar;
	}

	public Boolean getMostrarivaComprobanteFactura() {
		return this.mostrarivaComprobanteFactura;
	}

	public void setMostrarivaComprobanteFactura(Boolean mostrarivaComprobanteFactura) {
		this.mostrarivaComprobanteFactura= mostrarivaComprobanteFactura;
	}

	public Boolean getActivarivaComprobanteFactura() {
		return this.activarivaComprobanteFactura;
	}

	public void setActivarivaComprobanteFactura(Boolean activarivaComprobanteFactura) {
		this.activarivaComprobanteFactura= activarivaComprobanteFactura;
	}

	public Border setResaltardescuentoComprobanteFactura(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFacturaBeanSwingJInternalFrame comprobantefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantefacturaBeanSwingJInternalFrame.jTtoolBarComprobanteFactura.setBorder(borderResaltar);
		
		this.resaltardescuentoComprobanteFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuentoComprobanteFactura() {
		return this.resaltardescuentoComprobanteFactura;
	}

	public void setResaltardescuentoComprobanteFactura(Border borderResaltar) {
		this.resaltardescuentoComprobanteFactura= borderResaltar;
	}

	public Boolean getMostrardescuentoComprobanteFactura() {
		return this.mostrardescuentoComprobanteFactura;
	}

	public void setMostrardescuentoComprobanteFactura(Boolean mostrardescuentoComprobanteFactura) {
		this.mostrardescuentoComprobanteFactura= mostrardescuentoComprobanteFactura;
	}

	public Boolean getActivardescuentoComprobanteFactura() {
		return this.activardescuentoComprobanteFactura;
	}

	public void setActivardescuentoComprobanteFactura(Boolean activardescuentoComprobanteFactura) {
		this.activardescuentoComprobanteFactura= activardescuentoComprobanteFactura;
	}

	public Border setResaltarfinanciamientoComprobanteFactura(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFacturaBeanSwingJInternalFrame comprobantefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantefacturaBeanSwingJInternalFrame.jTtoolBarComprobanteFactura.setBorder(borderResaltar);
		
		this.resaltarfinanciamientoComprobanteFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfinanciamientoComprobanteFactura() {
		return this.resaltarfinanciamientoComprobanteFactura;
	}

	public void setResaltarfinanciamientoComprobanteFactura(Border borderResaltar) {
		this.resaltarfinanciamientoComprobanteFactura= borderResaltar;
	}

	public Boolean getMostrarfinanciamientoComprobanteFactura() {
		return this.mostrarfinanciamientoComprobanteFactura;
	}

	public void setMostrarfinanciamientoComprobanteFactura(Boolean mostrarfinanciamientoComprobanteFactura) {
		this.mostrarfinanciamientoComprobanteFactura= mostrarfinanciamientoComprobanteFactura;
	}

	public Boolean getActivarfinanciamientoComprobanteFactura() {
		return this.activarfinanciamientoComprobanteFactura;
	}

	public void setActivarfinanciamientoComprobanteFactura(Boolean activarfinanciamientoComprobanteFactura) {
		this.activarfinanciamientoComprobanteFactura= activarfinanciamientoComprobanteFactura;
	}

	public Border setResaltarfleteComprobanteFactura(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFacturaBeanSwingJInternalFrame comprobantefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantefacturaBeanSwingJInternalFrame.jTtoolBarComprobanteFactura.setBorder(borderResaltar);
		
		this.resaltarfleteComprobanteFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfleteComprobanteFactura() {
		return this.resaltarfleteComprobanteFactura;
	}

	public void setResaltarfleteComprobanteFactura(Border borderResaltar) {
		this.resaltarfleteComprobanteFactura= borderResaltar;
	}

	public Boolean getMostrarfleteComprobanteFactura() {
		return this.mostrarfleteComprobanteFactura;
	}

	public void setMostrarfleteComprobanteFactura(Boolean mostrarfleteComprobanteFactura) {
		this.mostrarfleteComprobanteFactura= mostrarfleteComprobanteFactura;
	}

	public Boolean getActivarfleteComprobanteFactura() {
		return this.activarfleteComprobanteFactura;
	}

	public void setActivarfleteComprobanteFactura(Boolean activarfleteComprobanteFactura) {
		this.activarfleteComprobanteFactura= activarfleteComprobanteFactura;
	}

	public Border setResaltariceComprobanteFactura(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFacturaBeanSwingJInternalFrame comprobantefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantefacturaBeanSwingJInternalFrame.jTtoolBarComprobanteFactura.setBorder(borderResaltar);
		
		this.resaltariceComprobanteFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltariceComprobanteFactura() {
		return this.resaltariceComprobanteFactura;
	}

	public void setResaltariceComprobanteFactura(Border borderResaltar) {
		this.resaltariceComprobanteFactura= borderResaltar;
	}

	public Boolean getMostrariceComprobanteFactura() {
		return this.mostrariceComprobanteFactura;
	}

	public void setMostrariceComprobanteFactura(Boolean mostrariceComprobanteFactura) {
		this.mostrariceComprobanteFactura= mostrariceComprobanteFactura;
	}

	public Boolean getActivariceComprobanteFactura() {
		return this.activariceComprobanteFactura;
	}

	public void setActivariceComprobanteFactura(Boolean activariceComprobanteFactura) {
		this.activariceComprobanteFactura= activariceComprobanteFactura;
	}

	public Border setResaltartotalComprobanteFactura(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFacturaBeanSwingJInternalFrame comprobantefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantefacturaBeanSwingJInternalFrame.jTtoolBarComprobanteFactura.setBorder(borderResaltar);
		
		this.resaltartotalComprobanteFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalComprobanteFactura() {
		return this.resaltartotalComprobanteFactura;
	}

	public void setResaltartotalComprobanteFactura(Border borderResaltar) {
		this.resaltartotalComprobanteFactura= borderResaltar;
	}

	public Boolean getMostrartotalComprobanteFactura() {
		return this.mostrartotalComprobanteFactura;
	}

	public void setMostrartotalComprobanteFactura(Boolean mostrartotalComprobanteFactura) {
		this.mostrartotalComprobanteFactura= mostrartotalComprobanteFactura;
	}

	public Boolean getActivartotalComprobanteFactura() {
		return this.activartotalComprobanteFactura;
	}

	public void setActivartotalComprobanteFactura(Boolean activartotalComprobanteFactura) {
		this.activartotalComprobanteFactura= activartotalComprobanteFactura;
	}

	public Border setResaltarcantidad_formas_pagoComprobanteFactura(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFacturaBeanSwingJInternalFrame comprobantefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantefacturaBeanSwingJInternalFrame.jTtoolBarComprobanteFactura.setBorder(borderResaltar);
		
		this.resaltarcantidad_formas_pagoComprobanteFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidad_formas_pagoComprobanteFactura() {
		return this.resaltarcantidad_formas_pagoComprobanteFactura;
	}

	public void setResaltarcantidad_formas_pagoComprobanteFactura(Border borderResaltar) {
		this.resaltarcantidad_formas_pagoComprobanteFactura= borderResaltar;
	}

	public Boolean getMostrarcantidad_formas_pagoComprobanteFactura() {
		return this.mostrarcantidad_formas_pagoComprobanteFactura;
	}

	public void setMostrarcantidad_formas_pagoComprobanteFactura(Boolean mostrarcantidad_formas_pagoComprobanteFactura) {
		this.mostrarcantidad_formas_pagoComprobanteFactura= mostrarcantidad_formas_pagoComprobanteFactura;
	}

	public Boolean getActivarcantidad_formas_pagoComprobanteFactura() {
		return this.activarcantidad_formas_pagoComprobanteFactura;
	}

	public void setActivarcantidad_formas_pagoComprobanteFactura(Boolean activarcantidad_formas_pagoComprobanteFactura) {
		this.activarcantidad_formas_pagoComprobanteFactura= activarcantidad_formas_pagoComprobanteFactura;
	}

	public Border setResaltardescuento_realComprobanteFactura(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFacturaBeanSwingJInternalFrame comprobantefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//comprobantefacturaBeanSwingJInternalFrame.jTtoolBarComprobanteFactura.setBorder(borderResaltar);
		
		this.resaltardescuento_realComprobanteFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuento_realComprobanteFactura() {
		return this.resaltardescuento_realComprobanteFactura;
	}

	public void setResaltardescuento_realComprobanteFactura(Border borderResaltar) {
		this.resaltardescuento_realComprobanteFactura= borderResaltar;
	}

	public Boolean getMostrardescuento_realComprobanteFactura() {
		return this.mostrardescuento_realComprobanteFactura;
	}

	public void setMostrardescuento_realComprobanteFactura(Boolean mostrardescuento_realComprobanteFactura) {
		this.mostrardescuento_realComprobanteFactura= mostrardescuento_realComprobanteFactura;
	}

	public Boolean getActivardescuento_realComprobanteFactura() {
		return this.activardescuento_realComprobanteFactura;
	}

	public void setActivardescuento_realComprobanteFactura(Boolean activardescuento_realComprobanteFactura) {
		this.activardescuento_realComprobanteFactura= activardescuento_realComprobanteFactura;
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
		
		
		this.setMostraridComprobanteFactura(esInicial);
		this.setMostrarid_empresaComprobanteFactura(esInicial);
		this.setMostrarid_vendedorComprobanteFactura(esInicial);
		this.setMostrarfecha_inicioComprobanteFactura(esInicial);
		this.setMostrarfecha_finComprobanteFactura(esInicial);
		this.setMostrarid_cajaComprobanteFactura(esInicial);
		this.setMostrarid_clienteComprobanteFactura(esInicial);
		this.setMostrarnombre_cajaComprobanteFactura(esInicial);
		this.setMostrarsecuencialComprobanteFactura(esInicial);
		this.setMostrarfechaComprobanteFactura(esInicial);
		this.setMostrarcodigo_clienteComprobanteFactura(esInicial);
		this.setMostrarnombre_clienteComprobanteFactura(esInicial);
		this.setMostrarsubtotalComprobanteFactura(esInicial);
		this.setMostrarivaComprobanteFactura(esInicial);
		this.setMostrardescuentoComprobanteFactura(esInicial);
		this.setMostrarfinanciamientoComprobanteFactura(esInicial);
		this.setMostrarfleteComprobanteFactura(esInicial);
		this.setMostrariceComprobanteFactura(esInicial);
		this.setMostrartotalComprobanteFactura(esInicial);
		this.setMostrarcantidad_formas_pagoComprobanteFactura(esInicial);
		this.setMostrardescuento_realComprobanteFactura(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.ID)) {
				this.setMostraridComprobanteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaComprobanteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.IDVENDEDOR)) {
				this.setMostrarid_vendedorComprobanteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.FECHAINICIO)) {
				this.setMostrarfecha_inicioComprobanteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.FECHAFIN)) {
				this.setMostrarfecha_finComprobanteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.IDCAJA)) {
				this.setMostrarid_cajaComprobanteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteComprobanteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.NOMBRECAJA)) {
				this.setMostrarnombre_cajaComprobanteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.SECUENCIAL)) {
				this.setMostrarsecuencialComprobanteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.FECHA)) {
				this.setMostrarfechaComprobanteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.CODIGOCLIENTE)) {
				this.setMostrarcodigo_clienteComprobanteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.NOMBRECLIENTE)) {
				this.setMostrarnombre_clienteComprobanteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.SUBTOTAL)) {
				this.setMostrarsubtotalComprobanteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.IVA)) {
				this.setMostrarivaComprobanteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.DESCUENTO)) {
				this.setMostrardescuentoComprobanteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.FINANCIAMIENTO)) {
				this.setMostrarfinanciamientoComprobanteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.FLETE)) {
				this.setMostrarfleteComprobanteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.ICE)) {
				this.setMostrariceComprobanteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.TOTAL)) {
				this.setMostrartotalComprobanteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.CANTIDADFORMASPAGO)) {
				this.setMostrarcantidad_formas_pagoComprobanteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.DESCUENTOREAL)) {
				this.setMostrardescuento_realComprobanteFactura(esAsigna);
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
		
		
		this.setActivaridComprobanteFactura(esInicial);
		this.setActivarid_empresaComprobanteFactura(esInicial);
		this.setActivarid_vendedorComprobanteFactura(esInicial);
		this.setActivarfecha_inicioComprobanteFactura(esInicial);
		this.setActivarfecha_finComprobanteFactura(esInicial);
		this.setActivarid_cajaComprobanteFactura(esInicial);
		this.setActivarid_clienteComprobanteFactura(esInicial);
		this.setActivarnombre_cajaComprobanteFactura(esInicial);
		this.setActivarsecuencialComprobanteFactura(esInicial);
		this.setActivarfechaComprobanteFactura(esInicial);
		this.setActivarcodigo_clienteComprobanteFactura(esInicial);
		this.setActivarnombre_clienteComprobanteFactura(esInicial);
		this.setActivarsubtotalComprobanteFactura(esInicial);
		this.setActivarivaComprobanteFactura(esInicial);
		this.setActivardescuentoComprobanteFactura(esInicial);
		this.setActivarfinanciamientoComprobanteFactura(esInicial);
		this.setActivarfleteComprobanteFactura(esInicial);
		this.setActivariceComprobanteFactura(esInicial);
		this.setActivartotalComprobanteFactura(esInicial);
		this.setActivarcantidad_formas_pagoComprobanteFactura(esInicial);
		this.setActivardescuento_realComprobanteFactura(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.ID)) {
				this.setActivaridComprobanteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaComprobanteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.IDVENDEDOR)) {
				this.setActivarid_vendedorComprobanteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.FECHAINICIO)) {
				this.setActivarfecha_inicioComprobanteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.FECHAFIN)) {
				this.setActivarfecha_finComprobanteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.IDCAJA)) {
				this.setActivarid_cajaComprobanteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteComprobanteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.NOMBRECAJA)) {
				this.setActivarnombre_cajaComprobanteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.SECUENCIAL)) {
				this.setActivarsecuencialComprobanteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.FECHA)) {
				this.setActivarfechaComprobanteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.CODIGOCLIENTE)) {
				this.setActivarcodigo_clienteComprobanteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.NOMBRECLIENTE)) {
				this.setActivarnombre_clienteComprobanteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.SUBTOTAL)) {
				this.setActivarsubtotalComprobanteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.IVA)) {
				this.setActivarivaComprobanteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.DESCUENTO)) {
				this.setActivardescuentoComprobanteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.FINANCIAMIENTO)) {
				this.setActivarfinanciamientoComprobanteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.FLETE)) {
				this.setActivarfleteComprobanteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.ICE)) {
				this.setActivariceComprobanteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.TOTAL)) {
				this.setActivartotalComprobanteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.CANTIDADFORMASPAGO)) {
				this.setActivarcantidad_formas_pagoComprobanteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.DESCUENTOREAL)) {
				this.setActivardescuento_realComprobanteFactura(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ComprobanteFacturaBeanSwingJInternalFrame comprobantefacturaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridComprobanteFactura(esInicial);
		this.setResaltarid_empresaComprobanteFactura(esInicial);
		this.setResaltarid_vendedorComprobanteFactura(esInicial);
		this.setResaltarfecha_inicioComprobanteFactura(esInicial);
		this.setResaltarfecha_finComprobanteFactura(esInicial);
		this.setResaltarid_cajaComprobanteFactura(esInicial);
		this.setResaltarid_clienteComprobanteFactura(esInicial);
		this.setResaltarnombre_cajaComprobanteFactura(esInicial);
		this.setResaltarsecuencialComprobanteFactura(esInicial);
		this.setResaltarfechaComprobanteFactura(esInicial);
		this.setResaltarcodigo_clienteComprobanteFactura(esInicial);
		this.setResaltarnombre_clienteComprobanteFactura(esInicial);
		this.setResaltarsubtotalComprobanteFactura(esInicial);
		this.setResaltarivaComprobanteFactura(esInicial);
		this.setResaltardescuentoComprobanteFactura(esInicial);
		this.setResaltarfinanciamientoComprobanteFactura(esInicial);
		this.setResaltarfleteComprobanteFactura(esInicial);
		this.setResaltariceComprobanteFactura(esInicial);
		this.setResaltartotalComprobanteFactura(esInicial);
		this.setResaltarcantidad_formas_pagoComprobanteFactura(esInicial);
		this.setResaltardescuento_realComprobanteFactura(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.ID)) {
				this.setResaltaridComprobanteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaComprobanteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.IDVENDEDOR)) {
				this.setResaltarid_vendedorComprobanteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.FECHAINICIO)) {
				this.setResaltarfecha_inicioComprobanteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.FECHAFIN)) {
				this.setResaltarfecha_finComprobanteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.IDCAJA)) {
				this.setResaltarid_cajaComprobanteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteComprobanteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.NOMBRECAJA)) {
				this.setResaltarnombre_cajaComprobanteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.SECUENCIAL)) {
				this.setResaltarsecuencialComprobanteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.FECHA)) {
				this.setResaltarfechaComprobanteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.CODIGOCLIENTE)) {
				this.setResaltarcodigo_clienteComprobanteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.NOMBRECLIENTE)) {
				this.setResaltarnombre_clienteComprobanteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.SUBTOTAL)) {
				this.setResaltarsubtotalComprobanteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.IVA)) {
				this.setResaltarivaComprobanteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.DESCUENTO)) {
				this.setResaltardescuentoComprobanteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.FINANCIAMIENTO)) {
				this.setResaltarfinanciamientoComprobanteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.FLETE)) {
				this.setResaltarfleteComprobanteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.ICE)) {
				this.setResaltariceComprobanteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.TOTAL)) {
				this.setResaltartotalComprobanteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.CANTIDADFORMASPAGO)) {
				this.setResaltarcantidad_formas_pagoComprobanteFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(ComprobanteFacturaConstantesFunciones.DESCUENTOREAL)) {
				this.setResaltardescuento_realComprobanteFactura(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ComprobanteFacturaBeanSwingJInternalFrame comprobantefacturaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaComprobanteFacturaComprobanteFactura=true;

	public Boolean getMostrarBusquedaComprobanteFacturaComprobanteFactura() {
		return this.mostrarBusquedaComprobanteFacturaComprobanteFactura;
	}

	public void setMostrarBusquedaComprobanteFacturaComprobanteFactura(Boolean visibilidadResaltar) {
		this.mostrarBusquedaComprobanteFacturaComprobanteFactura= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaComprobanteFacturaComprobanteFactura=true;

	public Boolean getActivarBusquedaComprobanteFacturaComprobanteFactura() {
		return this.activarBusquedaComprobanteFacturaComprobanteFactura;
	}

	public void setActivarBusquedaComprobanteFacturaComprobanteFactura(Boolean habilitarResaltar) {
		this.activarBusquedaComprobanteFacturaComprobanteFactura= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaComprobanteFacturaComprobanteFactura=null;

	public Border getResaltarBusquedaComprobanteFacturaComprobanteFactura() {
		return this.resaltarBusquedaComprobanteFacturaComprobanteFactura;
	}

	public void setResaltarBusquedaComprobanteFacturaComprobanteFactura(Border borderResaltar) {
		this.resaltarBusquedaComprobanteFacturaComprobanteFactura= borderResaltar;
	}

	public void setResaltarBusquedaComprobanteFacturaComprobanteFactura(ParametroGeneralUsuario parametroGeneralUsuario/*ComprobanteFacturaBeanSwingJInternalFrame comprobantefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaComprobanteFacturaComprobanteFactura= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}