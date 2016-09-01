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
package com.bydan.erp.facturacion.util.report;

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


import com.bydan.erp.facturacion.util.report.FacturasGeneralesConstantesFunciones;
import com.bydan.erp.facturacion.util.report.FacturasGeneralesParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.report.FacturasGeneralesParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.facturacion.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class FacturasGeneralesConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="FacturasGenerales";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="FacturasGenerales"+FacturasGeneralesConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="FacturasGeneralesHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="FacturasGeneralesHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=FacturasGeneralesConstantesFunciones.SCHEMA+"_"+FacturasGeneralesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/FacturasGeneralesHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=FacturasGeneralesConstantesFunciones.SCHEMA+"_"+FacturasGeneralesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=FacturasGeneralesConstantesFunciones.SCHEMA+"_"+FacturasGeneralesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/FacturasGeneralesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=FacturasGeneralesConstantesFunciones.SCHEMA+"_"+FacturasGeneralesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FacturasGeneralesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/FacturasGeneralesHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FacturasGeneralesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FacturasGeneralesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/FacturasGeneralesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FacturasGeneralesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=FacturasGeneralesConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+FacturasGeneralesConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=FacturasGeneralesConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+FacturasGeneralesConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Facturas Generaleses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Facturas Generales";
	public static final String SCLASSWEBTITULO_LOWER="Facturas Generales";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="FacturasGenerales";
	public static final String OBJECTNAME="facturasgenerales";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="facturas_generales";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select facturasgenerales from "+FacturasGeneralesConstantesFunciones.SPERSISTENCENAME+" facturasgenerales";
	public static String QUERYSELECTNATIVE="select "+FacturasGeneralesConstantesFunciones.SCHEMA+"."+FacturasGeneralesConstantesFunciones.TABLENAME+".id,"+FacturasGeneralesConstantesFunciones.SCHEMA+"."+FacturasGeneralesConstantesFunciones.TABLENAME+".version_row,"+FacturasGeneralesConstantesFunciones.SCHEMA+"."+FacturasGeneralesConstantesFunciones.TABLENAME+".id_zona,"+FacturasGeneralesConstantesFunciones.SCHEMA+"."+FacturasGeneralesConstantesFunciones.TABLENAME+".id_tipo_cliente,"+FacturasGeneralesConstantesFunciones.SCHEMA+"."+FacturasGeneralesConstantesFunciones.TABLENAME+".id_empresa,"+FacturasGeneralesConstantesFunciones.SCHEMA+"."+FacturasGeneralesConstantesFunciones.TABLENAME+".id_sucursal,"+FacturasGeneralesConstantesFunciones.SCHEMA+"."+FacturasGeneralesConstantesFunciones.TABLENAME+".id_cliente,"+FacturasGeneralesConstantesFunciones.SCHEMA+"."+FacturasGeneralesConstantesFunciones.TABLENAME+".id_tipo_factura,"+FacturasGeneralesConstantesFunciones.SCHEMA+"."+FacturasGeneralesConstantesFunciones.TABLENAME+".fecha_emision_desde,"+FacturasGeneralesConstantesFunciones.SCHEMA+"."+FacturasGeneralesConstantesFunciones.TABLENAME+".fecha_emision_hasta,"+FacturasGeneralesConstantesFunciones.SCHEMA+"."+FacturasGeneralesConstantesFunciones.TABLENAME+".nombre_zona,"+FacturasGeneralesConstantesFunciones.SCHEMA+"."+FacturasGeneralesConstantesFunciones.TABLENAME+".nombre_completo_cliente,"+FacturasGeneralesConstantesFunciones.SCHEMA+"."+FacturasGeneralesConstantesFunciones.TABLENAME+".nombre_tipo_factura,"+FacturasGeneralesConstantesFunciones.SCHEMA+"."+FacturasGeneralesConstantesFunciones.TABLENAME+".fecha_emision,"+FacturasGeneralesConstantesFunciones.SCHEMA+"."+FacturasGeneralesConstantesFunciones.TABLENAME+".fecha_vencimiento,"+FacturasGeneralesConstantesFunciones.SCHEMA+"."+FacturasGeneralesConstantesFunciones.TABLENAME+".numero_pre_impreso,"+FacturasGeneralesConstantesFunciones.SCHEMA+"."+FacturasGeneralesConstantesFunciones.TABLENAME+".total_descuento,"+FacturasGeneralesConstantesFunciones.SCHEMA+"."+FacturasGeneralesConstantesFunciones.TABLENAME+".total_otro,"+FacturasGeneralesConstantesFunciones.SCHEMA+"."+FacturasGeneralesConstantesFunciones.TABLENAME+".sub_total,"+FacturasGeneralesConstantesFunciones.SCHEMA+"."+FacturasGeneralesConstantesFunciones.TABLENAME+".total,"+FacturasGeneralesConstantesFunciones.SCHEMA+"."+FacturasGeneralesConstantesFunciones.TABLENAME+".iva from "+FacturasGeneralesConstantesFunciones.SCHEMA+"."+FacturasGeneralesConstantesFunciones.TABLENAME;//+" as "+FacturasGeneralesConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDZONA= "id_zona";
    public static final String IDTIPOCLIENTE= "id_tipo_cliente";
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDCLIENTE= "id_cliente";
    public static final String IDTIPOFACTURA= "id_tipo_factura";
    public static final String FECHAEMISIONDESDE= "fecha_emision_desde";
    public static final String FECHAEMISIONHASTA= "fecha_emision_hasta";
    public static final String NOMBREZONA= "nombre_zona";
    public static final String NOMBRECOMPLETOCLIENTE= "nombre_completo_cliente";
    public static final String NOMBRETIPOFACTURA= "nombre_tipo_factura";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String FECHAVENCIMIENTO= "fecha_vencimiento";
    public static final String NUMEROPREIMPRESO= "numero_pre_impreso";
    public static final String TOTALDESCUENTO= "total_descuento";
    public static final String TOTALOTRO= "total_otro";
    public static final String SUBTOTAL= "sub_total";
    public static final String TOTAL= "total";
    public static final String IVA= "iva";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDZONA= "Zona";
		public static final String LABEL_IDZONA_LOWER= "Zona";
    	public static final String LABEL_IDTIPOCLIENTE= "Tipo Cliente";
		public static final String LABEL_IDTIPOCLIENTE_LOWER= "id Tipo Cliente";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_IDTIPOFACTURA= "Tipo Factura";
		public static final String LABEL_IDTIPOFACTURA_LOWER= "Tipo Factura";
    	public static final String LABEL_FECHAEMISIONDESDE= "Fecha Emision Desde";
		public static final String LABEL_FECHAEMISIONDESDE_LOWER= "Fecha Emision Desde";
    	public static final String LABEL_FECHAEMISIONHASTA= "Fecha Emision Hasta";
		public static final String LABEL_FECHAEMISIONHASTA_LOWER= "Fecha Emision Hasta";
    	public static final String LABEL_NOMBREZONA= "Nombre Zona";
		public static final String LABEL_NOMBREZONA_LOWER= "Nombre Zona";
    	public static final String LABEL_NOMBRECOMPLETOCLIENTE= "Nombre Completo Cliente";
		public static final String LABEL_NOMBRECOMPLETOCLIENTE_LOWER= "Nombre Completo Cliente";
    	public static final String LABEL_NOMBRETIPOFACTURA= "Nombre Tipo Factura";
		public static final String LABEL_NOMBRETIPOFACTURA_LOWER= "Nombre Tipo Factura";
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
    	public static final String LABEL_FECHAVENCIMIENTO= "Fecha Vencimiento";
		public static final String LABEL_FECHAVENCIMIENTO_LOWER= "Fecha Vencimiento";
    	public static final String LABEL_NUMEROPREIMPRESO= "Numero Pre Impreso";
		public static final String LABEL_NUMEROPREIMPRESO_LOWER= "Numero Pre Impreso";
    	public static final String LABEL_TOTALDESCUENTO= "Total Descuento";
		public static final String LABEL_TOTALDESCUENTO_LOWER= "Total Descuento";
    	public static final String LABEL_TOTALOTRO= "Total Otro";
		public static final String LABEL_TOTALOTRO_LOWER= "Total Otro";
    	public static final String LABEL_SUBTOTAL= "Sub Total";
		public static final String LABEL_SUBTOTAL_LOWER= "Sub Total";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
    	public static final String LABEL_IVA= "Iva";
		public static final String LABEL_IVA_LOWER= "Iva";
	
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNOMBRE_ZONA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_ZONA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_COMPLETO_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_COMPLETO_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_TIPO_FACTURA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_TIPO_FACTURA=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXNUMERO_PRE_IMPRESO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_PRE_IMPRESO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
	
	public static String getFacturasGeneralesLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(FacturasGeneralesConstantesFunciones.IDZONA)) {sLabelColumna=FacturasGeneralesConstantesFunciones.LABEL_IDZONA;}
		if(sNombreColumna.equals(FacturasGeneralesConstantesFunciones.IDTIPOCLIENTE)) {sLabelColumna=FacturasGeneralesConstantesFunciones.LABEL_IDTIPOCLIENTE;}
		if(sNombreColumna.equals(FacturasGeneralesConstantesFunciones.IDEMPRESA)) {sLabelColumna=FacturasGeneralesConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(FacturasGeneralesConstantesFunciones.IDSUCURSAL)) {sLabelColumna=FacturasGeneralesConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(FacturasGeneralesConstantesFunciones.IDCLIENTE)) {sLabelColumna=FacturasGeneralesConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(FacturasGeneralesConstantesFunciones.IDTIPOFACTURA)) {sLabelColumna=FacturasGeneralesConstantesFunciones.LABEL_IDTIPOFACTURA;}
		if(sNombreColumna.equals(FacturasGeneralesConstantesFunciones.FECHAEMISIONDESDE)) {sLabelColumna=FacturasGeneralesConstantesFunciones.LABEL_FECHAEMISIONDESDE;}
		if(sNombreColumna.equals(FacturasGeneralesConstantesFunciones.FECHAEMISIONHASTA)) {sLabelColumna=FacturasGeneralesConstantesFunciones.LABEL_FECHAEMISIONHASTA;}
		if(sNombreColumna.equals(FacturasGeneralesConstantesFunciones.NOMBREZONA)) {sLabelColumna=FacturasGeneralesConstantesFunciones.LABEL_NOMBREZONA;}
		if(sNombreColumna.equals(FacturasGeneralesConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {sLabelColumna=FacturasGeneralesConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE;}
		if(sNombreColumna.equals(FacturasGeneralesConstantesFunciones.NOMBRETIPOFACTURA)) {sLabelColumna=FacturasGeneralesConstantesFunciones.LABEL_NOMBRETIPOFACTURA;}
		if(sNombreColumna.equals(FacturasGeneralesConstantesFunciones.FECHAEMISION)) {sLabelColumna=FacturasGeneralesConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(FacturasGeneralesConstantesFunciones.FECHAVENCIMIENTO)) {sLabelColumna=FacturasGeneralesConstantesFunciones.LABEL_FECHAVENCIMIENTO;}
		if(sNombreColumna.equals(FacturasGeneralesConstantesFunciones.NUMEROPREIMPRESO)) {sLabelColumna=FacturasGeneralesConstantesFunciones.LABEL_NUMEROPREIMPRESO;}
		if(sNombreColumna.equals(FacturasGeneralesConstantesFunciones.TOTALDESCUENTO)) {sLabelColumna=FacturasGeneralesConstantesFunciones.LABEL_TOTALDESCUENTO;}
		if(sNombreColumna.equals(FacturasGeneralesConstantesFunciones.TOTALOTRO)) {sLabelColumna=FacturasGeneralesConstantesFunciones.LABEL_TOTALOTRO;}
		if(sNombreColumna.equals(FacturasGeneralesConstantesFunciones.SUBTOTAL)) {sLabelColumna=FacturasGeneralesConstantesFunciones.LABEL_SUBTOTAL;}
		if(sNombreColumna.equals(FacturasGeneralesConstantesFunciones.TOTAL)) {sLabelColumna=FacturasGeneralesConstantesFunciones.LABEL_TOTAL;}
		if(sNombreColumna.equals(FacturasGeneralesConstantesFunciones.IVA)) {sLabelColumna=FacturasGeneralesConstantesFunciones.LABEL_IVA;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getFacturasGeneralesDescripcion(FacturasGenerales facturasgenerales) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(facturasgenerales !=null/* && facturasgenerales.getId()!=0*/) {
			if(facturasgenerales.getId()!=null) {
				sDescripcion=facturasgenerales.getId().toString();
			}//facturasgeneralesfacturasgenerales.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getFacturasGeneralesDescripcionDetallado(FacturasGenerales facturasgenerales) {
		String sDescripcion="";
			
		sDescripcion+=FacturasGeneralesConstantesFunciones.ID+"=";
		sDescripcion+=facturasgenerales.getId().toString()+",";
		sDescripcion+=FacturasGeneralesConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=facturasgenerales.getVersionRow().toString()+",";
		sDescripcion+=FacturasGeneralesConstantesFunciones.IDZONA+"=";
		sDescripcion+=facturasgenerales.getid_zona().toString()+",";
		sDescripcion+=FacturasGeneralesConstantesFunciones.IDTIPOCLIENTE+"=";
		sDescripcion+=facturasgenerales.getid_tipo_cliente().toString()+",";
		sDescripcion+=FacturasGeneralesConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=facturasgenerales.getid_empresa().toString()+",";
		sDescripcion+=FacturasGeneralesConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=facturasgenerales.getid_sucursal().toString()+",";
		sDescripcion+=FacturasGeneralesConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=facturasgenerales.getid_cliente().toString()+",";
		sDescripcion+=FacturasGeneralesConstantesFunciones.IDTIPOFACTURA+"=";
		sDescripcion+=facturasgenerales.getid_tipo_factura().toString()+",";
		sDescripcion+=FacturasGeneralesConstantesFunciones.FECHAEMISIONDESDE+"=";
		sDescripcion+=facturasgenerales.getfecha_emision_desde().toString()+",";
		sDescripcion+=FacturasGeneralesConstantesFunciones.FECHAEMISIONHASTA+"=";
		sDescripcion+=facturasgenerales.getfecha_emision_hasta().toString()+",";
		sDescripcion+=FacturasGeneralesConstantesFunciones.NOMBREZONA+"=";
		sDescripcion+=facturasgenerales.getnombre_zona()+",";
		sDescripcion+=FacturasGeneralesConstantesFunciones.NOMBRECOMPLETOCLIENTE+"=";
		sDescripcion+=facturasgenerales.getnombre_completo_cliente()+",";
		sDescripcion+=FacturasGeneralesConstantesFunciones.NOMBRETIPOFACTURA+"=";
		sDescripcion+=facturasgenerales.getnombre_tipo_factura()+",";
		sDescripcion+=FacturasGeneralesConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=facturasgenerales.getfecha_emision().toString()+",";
		sDescripcion+=FacturasGeneralesConstantesFunciones.FECHAVENCIMIENTO+"=";
		sDescripcion+=facturasgenerales.getfecha_vencimiento().toString()+",";
		sDescripcion+=FacturasGeneralesConstantesFunciones.NUMEROPREIMPRESO+"=";
		sDescripcion+=facturasgenerales.getnumero_pre_impreso()+",";
		sDescripcion+=FacturasGeneralesConstantesFunciones.TOTALDESCUENTO+"=";
		sDescripcion+=facturasgenerales.gettotal_descuento().toString()+",";
		sDescripcion+=FacturasGeneralesConstantesFunciones.TOTALOTRO+"=";
		sDescripcion+=facturasgenerales.gettotal_otro().toString()+",";
		sDescripcion+=FacturasGeneralesConstantesFunciones.SUBTOTAL+"=";
		sDescripcion+=facturasgenerales.getsub_total().toString()+",";
		sDescripcion+=FacturasGeneralesConstantesFunciones.TOTAL+"=";
		sDescripcion+=facturasgenerales.gettotal().toString()+",";
		sDescripcion+=FacturasGeneralesConstantesFunciones.IVA+"=";
		sDescripcion+=facturasgenerales.getiva().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setFacturasGeneralesDescripcion(FacturasGenerales facturasgenerales,String sValor) throws Exception {			
		if(facturasgenerales !=null) {
			//facturasgeneralesfacturasgenerales.getId().toString();
		}		
	}
	
		

	public static String getZonaDescripcion(Zona zona) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(zona!=null/*&&zona.getId()>0*/) {
			sDescripcion=ZonaConstantesFunciones.getZonaDescripcion(zona);
		}

		return sDescripcion;
	}

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getSucursalDescripcion(Sucursal sucursal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(sucursal!=null/*&&sucursal.getId()>0*/) {
			sDescripcion=SucursalConstantesFunciones.getSucursalDescripcion(sucursal);
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

	public static String getTipoFacturaDescripcion(TipoFactura tipofactura) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipofactura!=null/*&&tipofactura.getId()>0*/) {
			sDescripcion=TipoFacturaConstantesFunciones.getTipoFacturaDescripcion(tipofactura);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaFacturasGenerales")) {
			sNombreIndice="Tipo=  Por Zona Por Tipo Cliente Por Tipo Factura Por Fecha Emision Desde Por Fecha Emision Hasta";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoFactura")) {
			sNombreIndice="Tipo=  Por Tipo Factura";
		} else if(sNombreIndice.equals("FK_IdZona")) {
			sNombreIndice="Tipo=  Por Zona";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaFacturasGenerales(Long id_zona,Long id_tipo_cliente,Long id_tipo_factura,Date fecha_emision_desde,Date fecha_emision_hasta) {
		String sDetalleIndice=" Parametros->";
		if(id_zona!=null) {sDetalleIndice+=" Codigo Unico De Zona="+id_zona.toString();}
		if(id_tipo_cliente!=null) {sDetalleIndice+=" Tipo Cliente="+id_tipo_cliente.toString();}
		if(id_tipo_factura!=null) {sDetalleIndice+=" Codigo Unico De Tipo Factura="+id_tipo_factura.toString();}
		if(fecha_emision_desde!=null) {sDetalleIndice+=" Fecha Emision Desde="+fecha_emision_desde.toString();}
		if(fecha_emision_hasta!=null) {sDetalleIndice+=" Fecha Emision Hasta="+fecha_emision_hasta.toString();} 

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

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoFactura(Long id_tipo_factura) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_factura!=null) {sDetalleIndice+=" Codigo Unico De Tipo Factura="+id_tipo_factura.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdZona(Long id_zona) {
		String sDetalleIndice=" Parametros->";
		if(id_zona!=null) {sDetalleIndice+=" Codigo Unico De Zona="+id_zona.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosFacturasGenerales(FacturasGenerales facturasgenerales,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		facturasgenerales.setnombre_zona(facturasgenerales.getnombre_zona().trim());
		facturasgenerales.setnombre_completo_cliente(facturasgenerales.getnombre_completo_cliente().trim());
		facturasgenerales.setnombre_tipo_factura(facturasgenerales.getnombre_tipo_factura().trim());
		facturasgenerales.setnumero_pre_impreso(facturasgenerales.getnumero_pre_impreso().trim());
	}
	
	public static void quitarEspaciosFacturasGeneraless(List<FacturasGenerales> facturasgeneraless,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(FacturasGenerales facturasgenerales: facturasgeneraless) {
			facturasgenerales.setnombre_zona(facturasgenerales.getnombre_zona().trim());
			facturasgenerales.setnombre_completo_cliente(facturasgenerales.getnombre_completo_cliente().trim());
			facturasgenerales.setnombre_tipo_factura(facturasgenerales.getnombre_tipo_factura().trim());
			facturasgenerales.setnumero_pre_impreso(facturasgenerales.getnumero_pre_impreso().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresFacturasGenerales(FacturasGenerales facturasgenerales,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && facturasgenerales.getConCambioAuxiliar()) {
			facturasgenerales.setIsDeleted(facturasgenerales.getIsDeletedAuxiliar());	
			facturasgenerales.setIsNew(facturasgenerales.getIsNewAuxiliar());	
			facturasgenerales.setIsChanged(facturasgenerales.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			facturasgenerales.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			facturasgenerales.setIsDeletedAuxiliar(false);	
			facturasgenerales.setIsNewAuxiliar(false);	
			facturasgenerales.setIsChangedAuxiliar(false);
			
			facturasgenerales.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresFacturasGeneraless(List<FacturasGenerales> facturasgeneraless,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(FacturasGenerales facturasgenerales : facturasgeneraless) {
			if(conAsignarBase && facturasgenerales.getConCambioAuxiliar()) {
				facturasgenerales.setIsDeleted(facturasgenerales.getIsDeletedAuxiliar());	
				facturasgenerales.setIsNew(facturasgenerales.getIsNewAuxiliar());	
				facturasgenerales.setIsChanged(facturasgenerales.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				facturasgenerales.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				facturasgenerales.setIsDeletedAuxiliar(false);	
				facturasgenerales.setIsNewAuxiliar(false);	
				facturasgenerales.setIsChangedAuxiliar(false);
				
				facturasgenerales.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresFacturasGenerales(FacturasGenerales facturasgenerales,Boolean conEnteros) throws Exception  {
		facturasgenerales.settotal_descuento(0.0);
		facturasgenerales.settotal_otro(0.0);
		facturasgenerales.setsub_total(0.0);
		facturasgenerales.settotal(0.0);
		facturasgenerales.setiva(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresFacturasGeneraless(List<FacturasGenerales> facturasgeneraless,Boolean conEnteros) throws Exception  {
		
		for(FacturasGenerales facturasgenerales: facturasgeneraless) {
			facturasgenerales.settotal_descuento(0.0);
			facturasgenerales.settotal_otro(0.0);
			facturasgenerales.setsub_total(0.0);
			facturasgenerales.settotal(0.0);
			facturasgenerales.setiva(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaFacturasGenerales(List<FacturasGenerales> facturasgeneraless,FacturasGenerales facturasgeneralesAux) throws Exception  {
		FacturasGeneralesConstantesFunciones.InicializarValoresFacturasGenerales(facturasgeneralesAux,true);
		
		for(FacturasGenerales facturasgenerales: facturasgeneraless) {
			if(facturasgenerales.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			facturasgeneralesAux.settotal_descuento(facturasgeneralesAux.gettotal_descuento()+facturasgenerales.gettotal_descuento());			
			facturasgeneralesAux.settotal_otro(facturasgeneralesAux.gettotal_otro()+facturasgenerales.gettotal_otro());			
			facturasgeneralesAux.setsub_total(facturasgeneralesAux.getsub_total()+facturasgenerales.getsub_total());			
			facturasgeneralesAux.settotal(facturasgeneralesAux.gettotal()+facturasgenerales.gettotal());			
			facturasgeneralesAux.setiva(facturasgeneralesAux.getiva()+facturasgenerales.getiva());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesFacturasGenerales(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=FacturasGeneralesConstantesFunciones.getArrayColumnasGlobalesFacturasGenerales(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesFacturasGenerales(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FacturasGeneralesConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FacturasGeneralesConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FacturasGeneralesConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FacturasGeneralesConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoFacturasGenerales(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<FacturasGenerales> facturasgeneraless,FacturasGenerales facturasgenerales,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(FacturasGenerales facturasgeneralesAux: facturasgeneraless) {
			if(facturasgeneralesAux!=null && facturasgenerales!=null) {
				if((facturasgeneralesAux.getId()==null && facturasgenerales.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(facturasgeneralesAux.getId()!=null && facturasgenerales.getId()!=null){
					if(facturasgeneralesAux.getId().equals(facturasgenerales.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaFacturasGenerales(List<FacturasGenerales> facturasgeneraless) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double total_descuentoTotal=0.0;
		Double total_otroTotal=0.0;
		Double sub_totalTotal=0.0;
		Double totalTotal=0.0;
		Double ivaTotal=0.0;
	
		for(FacturasGenerales facturasgenerales: facturasgeneraless) {			
			if(facturasgenerales.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			total_descuentoTotal+=facturasgenerales.gettotal_descuento();
			total_otroTotal+=facturasgenerales.gettotal_otro();
			sub_totalTotal+=facturasgenerales.getsub_total();
			totalTotal+=facturasgenerales.gettotal();
			ivaTotal+=facturasgenerales.getiva();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturasGeneralesConstantesFunciones.TOTALDESCUENTO);
		datoGeneral.setsDescripcion(FacturasGeneralesConstantesFunciones.LABEL_TOTALDESCUENTO);
		datoGeneral.setdValorDouble(total_descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturasGeneralesConstantesFunciones.TOTALOTRO);
		datoGeneral.setsDescripcion(FacturasGeneralesConstantesFunciones.LABEL_TOTALOTRO);
		datoGeneral.setdValorDouble(total_otroTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturasGeneralesConstantesFunciones.SUBTOTAL);
		datoGeneral.setsDescripcion(FacturasGeneralesConstantesFunciones.LABEL_SUBTOTAL);
		datoGeneral.setdValorDouble(sub_totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturasGeneralesConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(FacturasGeneralesConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturasGeneralesConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(FacturasGeneralesConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaFacturasGenerales() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,FacturasGeneralesConstantesFunciones.LABEL_ID, FacturasGeneralesConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturasGeneralesConstantesFunciones.LABEL_VERSIONROW, FacturasGeneralesConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturasGeneralesConstantesFunciones.LABEL_NOMBREZONA, FacturasGeneralesConstantesFunciones.NOMBREZONA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturasGeneralesConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE, FacturasGeneralesConstantesFunciones.NOMBRECOMPLETOCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturasGeneralesConstantesFunciones.LABEL_NOMBRETIPOFACTURA, FacturasGeneralesConstantesFunciones.NOMBRETIPOFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturasGeneralesConstantesFunciones.LABEL_FECHAEMISION, FacturasGeneralesConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturasGeneralesConstantesFunciones.LABEL_FECHAVENCIMIENTO, FacturasGeneralesConstantesFunciones.FECHAVENCIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturasGeneralesConstantesFunciones.LABEL_NUMEROPREIMPRESO, FacturasGeneralesConstantesFunciones.NUMEROPREIMPRESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturasGeneralesConstantesFunciones.LABEL_TOTALDESCUENTO, FacturasGeneralesConstantesFunciones.TOTALDESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturasGeneralesConstantesFunciones.LABEL_TOTALOTRO, FacturasGeneralesConstantesFunciones.TOTALOTRO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturasGeneralesConstantesFunciones.LABEL_SUBTOTAL, FacturasGeneralesConstantesFunciones.SUBTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturasGeneralesConstantesFunciones.LABEL_TOTAL, FacturasGeneralesConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturasGeneralesConstantesFunciones.LABEL_IVA, FacturasGeneralesConstantesFunciones.IVA,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasFacturasGenerales() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=FacturasGeneralesConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturasGeneralesConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturasGeneralesConstantesFunciones.NOMBREZONA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturasGeneralesConstantesFunciones.NOMBRECOMPLETOCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturasGeneralesConstantesFunciones.NOMBRETIPOFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturasGeneralesConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturasGeneralesConstantesFunciones.FECHAVENCIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturasGeneralesConstantesFunciones.NUMEROPREIMPRESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturasGeneralesConstantesFunciones.TOTALDESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturasGeneralesConstantesFunciones.TOTALOTRO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturasGeneralesConstantesFunciones.SUBTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturasGeneralesConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturasGeneralesConstantesFunciones.IVA;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFacturasGenerales() throws Exception  {
		return FacturasGeneralesConstantesFunciones.getTiposSeleccionarFacturasGenerales(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFacturasGenerales(Boolean conFk) throws Exception  {
		return FacturasGeneralesConstantesFunciones.getTiposSeleccionarFacturasGenerales(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFacturasGenerales(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturasGeneralesConstantesFunciones.LABEL_IDZONA);
			reporte.setsDescripcion(FacturasGeneralesConstantesFunciones.LABEL_IDZONA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturasGeneralesConstantesFunciones.LABEL_IDTIPOCLIENTE);
			reporte.setsDescripcion(FacturasGeneralesConstantesFunciones.LABEL_IDTIPOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturasGeneralesConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(FacturasGeneralesConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturasGeneralesConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(FacturasGeneralesConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturasGeneralesConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(FacturasGeneralesConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturasGeneralesConstantesFunciones.LABEL_IDTIPOFACTURA);
			reporte.setsDescripcion(FacturasGeneralesConstantesFunciones.LABEL_IDTIPOFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturasGeneralesConstantesFunciones.LABEL_FECHAEMISIONDESDE);
			reporte.setsDescripcion(FacturasGeneralesConstantesFunciones.LABEL_FECHAEMISIONDESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturasGeneralesConstantesFunciones.LABEL_FECHAEMISIONHASTA);
			reporte.setsDescripcion(FacturasGeneralesConstantesFunciones.LABEL_FECHAEMISIONHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturasGeneralesConstantesFunciones.LABEL_NOMBREZONA);
			reporte.setsDescripcion(FacturasGeneralesConstantesFunciones.LABEL_NOMBREZONA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturasGeneralesConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);
			reporte.setsDescripcion(FacturasGeneralesConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturasGeneralesConstantesFunciones.LABEL_NOMBRETIPOFACTURA);
			reporte.setsDescripcion(FacturasGeneralesConstantesFunciones.LABEL_NOMBRETIPOFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturasGeneralesConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(FacturasGeneralesConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturasGeneralesConstantesFunciones.LABEL_FECHAVENCIMIENTO);
			reporte.setsDescripcion(FacturasGeneralesConstantesFunciones.LABEL_FECHAVENCIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturasGeneralesConstantesFunciones.LABEL_NUMEROPREIMPRESO);
			reporte.setsDescripcion(FacturasGeneralesConstantesFunciones.LABEL_NUMEROPREIMPRESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturasGeneralesConstantesFunciones.LABEL_TOTALDESCUENTO);
			reporte.setsDescripcion(FacturasGeneralesConstantesFunciones.LABEL_TOTALDESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturasGeneralesConstantesFunciones.LABEL_TOTALOTRO);
			reporte.setsDescripcion(FacturasGeneralesConstantesFunciones.LABEL_TOTALOTRO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturasGeneralesConstantesFunciones.LABEL_SUBTOTAL);
			reporte.setsDescripcion(FacturasGeneralesConstantesFunciones.LABEL_SUBTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturasGeneralesConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(FacturasGeneralesConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturasGeneralesConstantesFunciones.LABEL_IVA);
			reporte.setsDescripcion(FacturasGeneralesConstantesFunciones.LABEL_IVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesFacturasGenerales(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesFacturasGenerales(FacturasGenerales facturasgeneralesAux) throws Exception {
		
			facturasgeneralesAux.setzona_descripcion(ZonaConstantesFunciones.getZonaDescripcion(facturasgeneralesAux.getZona()));
			facturasgeneralesAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(facturasgeneralesAux.getEmpresa()));
			facturasgeneralesAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(facturasgeneralesAux.getSucursal()));
			facturasgeneralesAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(facturasgeneralesAux.getCliente()));
			facturasgeneralesAux.settipofactura_descripcion(TipoFacturaConstantesFunciones.getTipoFacturaDescripcion(facturasgeneralesAux.getTipoFactura()));		
	}
	
	public static void refrescarForeignKeysDescripcionesFacturasGenerales(List<FacturasGenerales> facturasgeneralessTemp) throws Exception {
		for(FacturasGenerales facturasgeneralesAux:facturasgeneralessTemp) {
			
			facturasgeneralesAux.setzona_descripcion(ZonaConstantesFunciones.getZonaDescripcion(facturasgeneralesAux.getZona()));
			facturasgeneralesAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(facturasgeneralesAux.getEmpresa()));
			facturasgeneralesAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(facturasgeneralesAux.getSucursal()));
			facturasgeneralesAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(facturasgeneralesAux.getCliente()));
			facturasgeneralesAux.settipofactura_descripcion(TipoFacturaConstantesFunciones.getTipoFacturaDescripcion(facturasgeneralesAux.getTipoFactura()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfFacturasGenerales(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Zona.class));
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(TipoFactura.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Zona.class)) {
						classes.add(new Classe(Zona.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Sucursal.class)) {
						classes.add(new Classe(Sucursal.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoFactura.class)) {
						classes.add(new Classe(TipoFactura.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfFacturasGenerales(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Zona.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Zona.class)); continue;
					}

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(TipoFactura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoFactura.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Zona.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Zona.class)); continue;
					}

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(TipoFactura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoFactura.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfFacturasGenerales(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return FacturasGeneralesConstantesFunciones.getClassesRelationshipsOfFacturasGenerales(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfFacturasGenerales(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfFacturasGenerales(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return FacturasGeneralesConstantesFunciones.getClassesRelationshipsFromStringsOfFacturasGenerales(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfFacturasGenerales(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(FacturasGenerales facturasgenerales,List<FacturasGenerales> facturasgeneraless,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(FacturasGenerales facturasgenerales,List<FacturasGenerales> facturasgeneraless) throws Exception {
		try	{			
			for(FacturasGenerales facturasgeneralesLocal:facturasgeneraless) {
				if(facturasgeneralesLocal.getId().equals(facturasgenerales.getId())) {
					facturasgeneralesLocal.setIsSelected(facturasgenerales.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesFacturasGenerales(List<FacturasGenerales> facturasgeneralessAux) throws Exception {
		//this.facturasgeneralessAux=facturasgeneralessAux;
		
		for(FacturasGenerales facturasgeneralesAux:facturasgeneralessAux) {
			if(facturasgeneralesAux.getIsChanged()) {
				facturasgeneralesAux.setIsChanged(false);
			}		
			
			if(facturasgeneralesAux.getIsNew()) {
				facturasgeneralesAux.setIsNew(false);
			}	
			
			if(facturasgeneralesAux.getIsDeleted()) {
				facturasgeneralesAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesFacturasGenerales(FacturasGenerales facturasgeneralesAux) throws Exception {
		//this.facturasgeneralesAux=facturasgeneralesAux;
		
			if(facturasgeneralesAux.getIsChanged()) {
				facturasgeneralesAux.setIsChanged(false);
			}		
			
			if(facturasgeneralesAux.getIsNew()) {
				facturasgeneralesAux.setIsNew(false);
			}	
			
			if(facturasgeneralesAux.getIsDeleted()) {
				facturasgeneralesAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(FacturasGenerales facturasgeneralesAsignar,FacturasGenerales facturasgenerales) throws Exception {
		facturasgeneralesAsignar.setId(facturasgenerales.getId());	
		facturasgeneralesAsignar.setVersionRow(facturasgenerales.getVersionRow());	
		facturasgeneralesAsignar.setnombre_zona(facturasgenerales.getnombre_zona());	
		facturasgeneralesAsignar.setnombre_completo_cliente(facturasgenerales.getnombre_completo_cliente());	
		facturasgeneralesAsignar.setnombre_tipo_factura(facturasgenerales.getnombre_tipo_factura());	
		facturasgeneralesAsignar.setfecha_emision(facturasgenerales.getfecha_emision());	
		facturasgeneralesAsignar.setfecha_vencimiento(facturasgenerales.getfecha_vencimiento());	
		facturasgeneralesAsignar.setnumero_pre_impreso(facturasgenerales.getnumero_pre_impreso());	
		facturasgeneralesAsignar.settotal_descuento(facturasgenerales.gettotal_descuento());	
		facturasgeneralesAsignar.settotal_otro(facturasgenerales.gettotal_otro());	
		facturasgeneralesAsignar.setsub_total(facturasgenerales.getsub_total());	
		facturasgeneralesAsignar.settotal(facturasgenerales.gettotal());	
		facturasgeneralesAsignar.setiva(facturasgenerales.getiva());	
	}
	
	public static void inicializarFacturasGenerales(FacturasGenerales facturasgenerales) throws Exception {
		try {
				facturasgenerales.setId(0L);	
					
				facturasgenerales.setnombre_zona("");	
				facturasgenerales.setnombre_completo_cliente("");	
				facturasgenerales.setnombre_tipo_factura("");	
				facturasgenerales.setfecha_emision(new Date());	
				facturasgenerales.setfecha_vencimiento(new Date());	
				facturasgenerales.setnumero_pre_impreso("");	
				facturasgenerales.settotal_descuento(0.0);	
				facturasgenerales.settotal_otro(0.0);	
				facturasgenerales.setsub_total(0.0);	
				facturasgenerales.settotal(0.0);	
				facturasgenerales.setiva(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderFacturasGenerales(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturasGeneralesConstantesFunciones.LABEL_IDZONA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturasGeneralesConstantesFunciones.LABEL_IDTIPOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturasGeneralesConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturasGeneralesConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturasGeneralesConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturasGeneralesConstantesFunciones.LABEL_IDTIPOFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturasGeneralesConstantesFunciones.LABEL_FECHAEMISIONDESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturasGeneralesConstantesFunciones.LABEL_FECHAEMISIONHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturasGeneralesConstantesFunciones.LABEL_NOMBREZONA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturasGeneralesConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturasGeneralesConstantesFunciones.LABEL_NOMBRETIPOFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturasGeneralesConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturasGeneralesConstantesFunciones.LABEL_FECHAVENCIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturasGeneralesConstantesFunciones.LABEL_NUMEROPREIMPRESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturasGeneralesConstantesFunciones.LABEL_TOTALDESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturasGeneralesConstantesFunciones.LABEL_TOTALOTRO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturasGeneralesConstantesFunciones.LABEL_SUBTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturasGeneralesConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturasGeneralesConstantesFunciones.LABEL_IVA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataFacturasGenerales(String sTipo,Row row,Workbook workbook,FacturasGenerales facturasgenerales,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(facturasgenerales.getzona_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturasgenerales.getid_tipo_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturasgenerales.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturasgenerales.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturasgenerales.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturasgenerales.gettipofactura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturasgenerales.getfecha_emision_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturasgenerales.getfecha_emision_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturasgenerales.getnombre_zona());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturasgenerales.getnombre_completo_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturasgenerales.getnombre_tipo_factura());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturasgenerales.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturasgenerales.getfecha_vencimiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturasgenerales.getnumero_pre_impreso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturasgenerales.gettotal_descuento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturasgenerales.gettotal_otro());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturasgenerales.getsub_total());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturasgenerales.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturasgenerales.getiva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryFacturasGenerales="";
	
	public String getsFinalQueryFacturasGenerales() {
		return this.sFinalQueryFacturasGenerales;
	}
	
	public void setsFinalQueryFacturasGenerales(String sFinalQueryFacturasGenerales) {
		this.sFinalQueryFacturasGenerales= sFinalQueryFacturasGenerales;
	}
	
	public Border resaltarSeleccionarFacturasGenerales=null;
	
	public Border setResaltarSeleccionarFacturasGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasGeneralesBeanSwingJInternalFrame facturasgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//facturasgeneralesBeanSwingJInternalFrame.jTtoolBarFacturasGenerales.setBorder(borderResaltar);
		
		this.resaltarSeleccionarFacturasGenerales= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarFacturasGenerales() {
		return this.resaltarSeleccionarFacturasGenerales;
	}
	
	public void setResaltarSeleccionarFacturasGenerales(Border borderResaltarSeleccionarFacturasGenerales) {
		this.resaltarSeleccionarFacturasGenerales= borderResaltarSeleccionarFacturasGenerales;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridFacturasGenerales=null;
	public Boolean mostraridFacturasGenerales=true;
	public Boolean activaridFacturasGenerales=true;

	public Border resaltarid_zonaFacturasGenerales=null;
	public Boolean mostrarid_zonaFacturasGenerales=true;
	public Boolean activarid_zonaFacturasGenerales=true;
	public Boolean cargarid_zonaFacturasGenerales=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_zonaFacturasGenerales=false;//ConEventDepend=true

	public Border resaltarid_tipo_clienteFacturasGenerales=null;
	public Boolean mostrarid_tipo_clienteFacturasGenerales=true;
	public Boolean activarid_tipo_clienteFacturasGenerales=true;

	public Border resaltarid_empresaFacturasGenerales=null;
	public Boolean mostrarid_empresaFacturasGenerales=true;
	public Boolean activarid_empresaFacturasGenerales=true;
	public Boolean cargarid_empresaFacturasGenerales=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaFacturasGenerales=false;//ConEventDepend=true

	public Border resaltarid_sucursalFacturasGenerales=null;
	public Boolean mostrarid_sucursalFacturasGenerales=true;
	public Boolean activarid_sucursalFacturasGenerales=true;
	public Boolean cargarid_sucursalFacturasGenerales=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalFacturasGenerales=false;//ConEventDepend=true

	public Border resaltarid_clienteFacturasGenerales=null;
	public Boolean mostrarid_clienteFacturasGenerales=true;
	public Boolean activarid_clienteFacturasGenerales=true;
	public Boolean cargarid_clienteFacturasGenerales=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteFacturasGenerales=false;//ConEventDepend=true

	public Border resaltarid_tipo_facturaFacturasGenerales=null;
	public Boolean mostrarid_tipo_facturaFacturasGenerales=true;
	public Boolean activarid_tipo_facturaFacturasGenerales=true;
	public Boolean cargarid_tipo_facturaFacturasGenerales=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_facturaFacturasGenerales=false;//ConEventDepend=true

	public Border resaltarfecha_emision_desdeFacturasGenerales=null;
	public Boolean mostrarfecha_emision_desdeFacturasGenerales=true;
	public Boolean activarfecha_emision_desdeFacturasGenerales=true;

	public Border resaltarfecha_emision_hastaFacturasGenerales=null;
	public Boolean mostrarfecha_emision_hastaFacturasGenerales=true;
	public Boolean activarfecha_emision_hastaFacturasGenerales=true;

	public Border resaltarnombre_zonaFacturasGenerales=null;
	public Boolean mostrarnombre_zonaFacturasGenerales=true;
	public Boolean activarnombre_zonaFacturasGenerales=true;

	public Border resaltarnombre_completo_clienteFacturasGenerales=null;
	public Boolean mostrarnombre_completo_clienteFacturasGenerales=true;
	public Boolean activarnombre_completo_clienteFacturasGenerales=true;

	public Border resaltarnombre_tipo_facturaFacturasGenerales=null;
	public Boolean mostrarnombre_tipo_facturaFacturasGenerales=true;
	public Boolean activarnombre_tipo_facturaFacturasGenerales=true;

	public Border resaltarfecha_emisionFacturasGenerales=null;
	public Boolean mostrarfecha_emisionFacturasGenerales=true;
	public Boolean activarfecha_emisionFacturasGenerales=true;

	public Border resaltarfecha_vencimientoFacturasGenerales=null;
	public Boolean mostrarfecha_vencimientoFacturasGenerales=true;
	public Boolean activarfecha_vencimientoFacturasGenerales=true;

	public Border resaltarnumero_pre_impresoFacturasGenerales=null;
	public Boolean mostrarnumero_pre_impresoFacturasGenerales=true;
	public Boolean activarnumero_pre_impresoFacturasGenerales=true;

	public Border resaltartotal_descuentoFacturasGenerales=null;
	public Boolean mostrartotal_descuentoFacturasGenerales=true;
	public Boolean activartotal_descuentoFacturasGenerales=true;

	public Border resaltartotal_otroFacturasGenerales=null;
	public Boolean mostrartotal_otroFacturasGenerales=true;
	public Boolean activartotal_otroFacturasGenerales=true;

	public Border resaltarsub_totalFacturasGenerales=null;
	public Boolean mostrarsub_totalFacturasGenerales=true;
	public Boolean activarsub_totalFacturasGenerales=true;

	public Border resaltartotalFacturasGenerales=null;
	public Boolean mostrartotalFacturasGenerales=true;
	public Boolean activartotalFacturasGenerales=true;

	public Border resaltarivaFacturasGenerales=null;
	public Boolean mostrarivaFacturasGenerales=true;
	public Boolean activarivaFacturasGenerales=true;

	
	

	public Border setResaltaridFacturasGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasGeneralesBeanSwingJInternalFrame facturasgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturasgeneralesBeanSwingJInternalFrame.jTtoolBarFacturasGenerales.setBorder(borderResaltar);
		
		this.resaltaridFacturasGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridFacturasGenerales() {
		return this.resaltaridFacturasGenerales;
	}

	public void setResaltaridFacturasGenerales(Border borderResaltar) {
		this.resaltaridFacturasGenerales= borderResaltar;
	}

	public Boolean getMostraridFacturasGenerales() {
		return this.mostraridFacturasGenerales;
	}

	public void setMostraridFacturasGenerales(Boolean mostraridFacturasGenerales) {
		this.mostraridFacturasGenerales= mostraridFacturasGenerales;
	}

	public Boolean getActivaridFacturasGenerales() {
		return this.activaridFacturasGenerales;
	}

	public void setActivaridFacturasGenerales(Boolean activaridFacturasGenerales) {
		this.activaridFacturasGenerales= activaridFacturasGenerales;
	}

	public Border setResaltarid_zonaFacturasGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasGeneralesBeanSwingJInternalFrame facturasgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturasgeneralesBeanSwingJInternalFrame.jTtoolBarFacturasGenerales.setBorder(borderResaltar);
		
		this.resaltarid_zonaFacturasGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_zonaFacturasGenerales() {
		return this.resaltarid_zonaFacturasGenerales;
	}

	public void setResaltarid_zonaFacturasGenerales(Border borderResaltar) {
		this.resaltarid_zonaFacturasGenerales= borderResaltar;
	}

	public Boolean getMostrarid_zonaFacturasGenerales() {
		return this.mostrarid_zonaFacturasGenerales;
	}

	public void setMostrarid_zonaFacturasGenerales(Boolean mostrarid_zonaFacturasGenerales) {
		this.mostrarid_zonaFacturasGenerales= mostrarid_zonaFacturasGenerales;
	}

	public Boolean getActivarid_zonaFacturasGenerales() {
		return this.activarid_zonaFacturasGenerales;
	}

	public void setActivarid_zonaFacturasGenerales(Boolean activarid_zonaFacturasGenerales) {
		this.activarid_zonaFacturasGenerales= activarid_zonaFacturasGenerales;
	}

	public Boolean getCargarid_zonaFacturasGenerales() {
		return this.cargarid_zonaFacturasGenerales;
	}

	public void setCargarid_zonaFacturasGenerales(Boolean cargarid_zonaFacturasGenerales) {
		this.cargarid_zonaFacturasGenerales= cargarid_zonaFacturasGenerales;
	}

	public Border setResaltarid_tipo_clienteFacturasGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasGeneralesBeanSwingJInternalFrame facturasgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturasgeneralesBeanSwingJInternalFrame.jTtoolBarFacturasGenerales.setBorder(borderResaltar);
		
		this.resaltarid_tipo_clienteFacturasGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_clienteFacturasGenerales() {
		return this.resaltarid_tipo_clienteFacturasGenerales;
	}

	public void setResaltarid_tipo_clienteFacturasGenerales(Border borderResaltar) {
		this.resaltarid_tipo_clienteFacturasGenerales= borderResaltar;
	}

	public Boolean getMostrarid_tipo_clienteFacturasGenerales() {
		return this.mostrarid_tipo_clienteFacturasGenerales;
	}

	public void setMostrarid_tipo_clienteFacturasGenerales(Boolean mostrarid_tipo_clienteFacturasGenerales) {
		this.mostrarid_tipo_clienteFacturasGenerales= mostrarid_tipo_clienteFacturasGenerales;
	}

	public Boolean getActivarid_tipo_clienteFacturasGenerales() {
		return this.activarid_tipo_clienteFacturasGenerales;
	}

	public void setActivarid_tipo_clienteFacturasGenerales(Boolean activarid_tipo_clienteFacturasGenerales) {
		this.activarid_tipo_clienteFacturasGenerales= activarid_tipo_clienteFacturasGenerales;
	}

	public Border setResaltarid_empresaFacturasGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasGeneralesBeanSwingJInternalFrame facturasgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturasgeneralesBeanSwingJInternalFrame.jTtoolBarFacturasGenerales.setBorder(borderResaltar);
		
		this.resaltarid_empresaFacturasGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaFacturasGenerales() {
		return this.resaltarid_empresaFacturasGenerales;
	}

	public void setResaltarid_empresaFacturasGenerales(Border borderResaltar) {
		this.resaltarid_empresaFacturasGenerales= borderResaltar;
	}

	public Boolean getMostrarid_empresaFacturasGenerales() {
		return this.mostrarid_empresaFacturasGenerales;
	}

	public void setMostrarid_empresaFacturasGenerales(Boolean mostrarid_empresaFacturasGenerales) {
		this.mostrarid_empresaFacturasGenerales= mostrarid_empresaFacturasGenerales;
	}

	public Boolean getActivarid_empresaFacturasGenerales() {
		return this.activarid_empresaFacturasGenerales;
	}

	public void setActivarid_empresaFacturasGenerales(Boolean activarid_empresaFacturasGenerales) {
		this.activarid_empresaFacturasGenerales= activarid_empresaFacturasGenerales;
	}

	public Boolean getCargarid_empresaFacturasGenerales() {
		return this.cargarid_empresaFacturasGenerales;
	}

	public void setCargarid_empresaFacturasGenerales(Boolean cargarid_empresaFacturasGenerales) {
		this.cargarid_empresaFacturasGenerales= cargarid_empresaFacturasGenerales;
	}

	public Border setResaltarid_sucursalFacturasGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasGeneralesBeanSwingJInternalFrame facturasgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturasgeneralesBeanSwingJInternalFrame.jTtoolBarFacturasGenerales.setBorder(borderResaltar);
		
		this.resaltarid_sucursalFacturasGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalFacturasGenerales() {
		return this.resaltarid_sucursalFacturasGenerales;
	}

	public void setResaltarid_sucursalFacturasGenerales(Border borderResaltar) {
		this.resaltarid_sucursalFacturasGenerales= borderResaltar;
	}

	public Boolean getMostrarid_sucursalFacturasGenerales() {
		return this.mostrarid_sucursalFacturasGenerales;
	}

	public void setMostrarid_sucursalFacturasGenerales(Boolean mostrarid_sucursalFacturasGenerales) {
		this.mostrarid_sucursalFacturasGenerales= mostrarid_sucursalFacturasGenerales;
	}

	public Boolean getActivarid_sucursalFacturasGenerales() {
		return this.activarid_sucursalFacturasGenerales;
	}

	public void setActivarid_sucursalFacturasGenerales(Boolean activarid_sucursalFacturasGenerales) {
		this.activarid_sucursalFacturasGenerales= activarid_sucursalFacturasGenerales;
	}

	public Boolean getCargarid_sucursalFacturasGenerales() {
		return this.cargarid_sucursalFacturasGenerales;
	}

	public void setCargarid_sucursalFacturasGenerales(Boolean cargarid_sucursalFacturasGenerales) {
		this.cargarid_sucursalFacturasGenerales= cargarid_sucursalFacturasGenerales;
	}

	public Border setResaltarid_clienteFacturasGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasGeneralesBeanSwingJInternalFrame facturasgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturasgeneralesBeanSwingJInternalFrame.jTtoolBarFacturasGenerales.setBorder(borderResaltar);
		
		this.resaltarid_clienteFacturasGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteFacturasGenerales() {
		return this.resaltarid_clienteFacturasGenerales;
	}

	public void setResaltarid_clienteFacturasGenerales(Border borderResaltar) {
		this.resaltarid_clienteFacturasGenerales= borderResaltar;
	}

	public Boolean getMostrarid_clienteFacturasGenerales() {
		return this.mostrarid_clienteFacturasGenerales;
	}

	public void setMostrarid_clienteFacturasGenerales(Boolean mostrarid_clienteFacturasGenerales) {
		this.mostrarid_clienteFacturasGenerales= mostrarid_clienteFacturasGenerales;
	}

	public Boolean getActivarid_clienteFacturasGenerales() {
		return this.activarid_clienteFacturasGenerales;
	}

	public void setActivarid_clienteFacturasGenerales(Boolean activarid_clienteFacturasGenerales) {
		this.activarid_clienteFacturasGenerales= activarid_clienteFacturasGenerales;
	}

	public Boolean getCargarid_clienteFacturasGenerales() {
		return this.cargarid_clienteFacturasGenerales;
	}

	public void setCargarid_clienteFacturasGenerales(Boolean cargarid_clienteFacturasGenerales) {
		this.cargarid_clienteFacturasGenerales= cargarid_clienteFacturasGenerales;
	}

	public Border setResaltarid_tipo_facturaFacturasGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasGeneralesBeanSwingJInternalFrame facturasgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturasgeneralesBeanSwingJInternalFrame.jTtoolBarFacturasGenerales.setBorder(borderResaltar);
		
		this.resaltarid_tipo_facturaFacturasGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_facturaFacturasGenerales() {
		return this.resaltarid_tipo_facturaFacturasGenerales;
	}

	public void setResaltarid_tipo_facturaFacturasGenerales(Border borderResaltar) {
		this.resaltarid_tipo_facturaFacturasGenerales= borderResaltar;
	}

	public Boolean getMostrarid_tipo_facturaFacturasGenerales() {
		return this.mostrarid_tipo_facturaFacturasGenerales;
	}

	public void setMostrarid_tipo_facturaFacturasGenerales(Boolean mostrarid_tipo_facturaFacturasGenerales) {
		this.mostrarid_tipo_facturaFacturasGenerales= mostrarid_tipo_facturaFacturasGenerales;
	}

	public Boolean getActivarid_tipo_facturaFacturasGenerales() {
		return this.activarid_tipo_facturaFacturasGenerales;
	}

	public void setActivarid_tipo_facturaFacturasGenerales(Boolean activarid_tipo_facturaFacturasGenerales) {
		this.activarid_tipo_facturaFacturasGenerales= activarid_tipo_facturaFacturasGenerales;
	}

	public Boolean getCargarid_tipo_facturaFacturasGenerales() {
		return this.cargarid_tipo_facturaFacturasGenerales;
	}

	public void setCargarid_tipo_facturaFacturasGenerales(Boolean cargarid_tipo_facturaFacturasGenerales) {
		this.cargarid_tipo_facturaFacturasGenerales= cargarid_tipo_facturaFacturasGenerales;
	}

	public Border setResaltarfecha_emision_desdeFacturasGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasGeneralesBeanSwingJInternalFrame facturasgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturasgeneralesBeanSwingJInternalFrame.jTtoolBarFacturasGenerales.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_desdeFacturasGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_desdeFacturasGenerales() {
		return this.resaltarfecha_emision_desdeFacturasGenerales;
	}

	public void setResaltarfecha_emision_desdeFacturasGenerales(Border borderResaltar) {
		this.resaltarfecha_emision_desdeFacturasGenerales= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_desdeFacturasGenerales() {
		return this.mostrarfecha_emision_desdeFacturasGenerales;
	}

	public void setMostrarfecha_emision_desdeFacturasGenerales(Boolean mostrarfecha_emision_desdeFacturasGenerales) {
		this.mostrarfecha_emision_desdeFacturasGenerales= mostrarfecha_emision_desdeFacturasGenerales;
	}

	public Boolean getActivarfecha_emision_desdeFacturasGenerales() {
		return this.activarfecha_emision_desdeFacturasGenerales;
	}

	public void setActivarfecha_emision_desdeFacturasGenerales(Boolean activarfecha_emision_desdeFacturasGenerales) {
		this.activarfecha_emision_desdeFacturasGenerales= activarfecha_emision_desdeFacturasGenerales;
	}

	public Border setResaltarfecha_emision_hastaFacturasGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasGeneralesBeanSwingJInternalFrame facturasgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturasgeneralesBeanSwingJInternalFrame.jTtoolBarFacturasGenerales.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_hastaFacturasGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_hastaFacturasGenerales() {
		return this.resaltarfecha_emision_hastaFacturasGenerales;
	}

	public void setResaltarfecha_emision_hastaFacturasGenerales(Border borderResaltar) {
		this.resaltarfecha_emision_hastaFacturasGenerales= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_hastaFacturasGenerales() {
		return this.mostrarfecha_emision_hastaFacturasGenerales;
	}

	public void setMostrarfecha_emision_hastaFacturasGenerales(Boolean mostrarfecha_emision_hastaFacturasGenerales) {
		this.mostrarfecha_emision_hastaFacturasGenerales= mostrarfecha_emision_hastaFacturasGenerales;
	}

	public Boolean getActivarfecha_emision_hastaFacturasGenerales() {
		return this.activarfecha_emision_hastaFacturasGenerales;
	}

	public void setActivarfecha_emision_hastaFacturasGenerales(Boolean activarfecha_emision_hastaFacturasGenerales) {
		this.activarfecha_emision_hastaFacturasGenerales= activarfecha_emision_hastaFacturasGenerales;
	}

	public Border setResaltarnombre_zonaFacturasGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasGeneralesBeanSwingJInternalFrame facturasgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturasgeneralesBeanSwingJInternalFrame.jTtoolBarFacturasGenerales.setBorder(borderResaltar);
		
		this.resaltarnombre_zonaFacturasGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_zonaFacturasGenerales() {
		return this.resaltarnombre_zonaFacturasGenerales;
	}

	public void setResaltarnombre_zonaFacturasGenerales(Border borderResaltar) {
		this.resaltarnombre_zonaFacturasGenerales= borderResaltar;
	}

	public Boolean getMostrarnombre_zonaFacturasGenerales() {
		return this.mostrarnombre_zonaFacturasGenerales;
	}

	public void setMostrarnombre_zonaFacturasGenerales(Boolean mostrarnombre_zonaFacturasGenerales) {
		this.mostrarnombre_zonaFacturasGenerales= mostrarnombre_zonaFacturasGenerales;
	}

	public Boolean getActivarnombre_zonaFacturasGenerales() {
		return this.activarnombre_zonaFacturasGenerales;
	}

	public void setActivarnombre_zonaFacturasGenerales(Boolean activarnombre_zonaFacturasGenerales) {
		this.activarnombre_zonaFacturasGenerales= activarnombre_zonaFacturasGenerales;
	}

	public Border setResaltarnombre_completo_clienteFacturasGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasGeneralesBeanSwingJInternalFrame facturasgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturasgeneralesBeanSwingJInternalFrame.jTtoolBarFacturasGenerales.setBorder(borderResaltar);
		
		this.resaltarnombre_completo_clienteFacturasGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_completo_clienteFacturasGenerales() {
		return this.resaltarnombre_completo_clienteFacturasGenerales;
	}

	public void setResaltarnombre_completo_clienteFacturasGenerales(Border borderResaltar) {
		this.resaltarnombre_completo_clienteFacturasGenerales= borderResaltar;
	}

	public Boolean getMostrarnombre_completo_clienteFacturasGenerales() {
		return this.mostrarnombre_completo_clienteFacturasGenerales;
	}

	public void setMostrarnombre_completo_clienteFacturasGenerales(Boolean mostrarnombre_completo_clienteFacturasGenerales) {
		this.mostrarnombre_completo_clienteFacturasGenerales= mostrarnombre_completo_clienteFacturasGenerales;
	}

	public Boolean getActivarnombre_completo_clienteFacturasGenerales() {
		return this.activarnombre_completo_clienteFacturasGenerales;
	}

	public void setActivarnombre_completo_clienteFacturasGenerales(Boolean activarnombre_completo_clienteFacturasGenerales) {
		this.activarnombre_completo_clienteFacturasGenerales= activarnombre_completo_clienteFacturasGenerales;
	}

	public Border setResaltarnombre_tipo_facturaFacturasGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasGeneralesBeanSwingJInternalFrame facturasgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturasgeneralesBeanSwingJInternalFrame.jTtoolBarFacturasGenerales.setBorder(borderResaltar);
		
		this.resaltarnombre_tipo_facturaFacturasGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_tipo_facturaFacturasGenerales() {
		return this.resaltarnombre_tipo_facturaFacturasGenerales;
	}

	public void setResaltarnombre_tipo_facturaFacturasGenerales(Border borderResaltar) {
		this.resaltarnombre_tipo_facturaFacturasGenerales= borderResaltar;
	}

	public Boolean getMostrarnombre_tipo_facturaFacturasGenerales() {
		return this.mostrarnombre_tipo_facturaFacturasGenerales;
	}

	public void setMostrarnombre_tipo_facturaFacturasGenerales(Boolean mostrarnombre_tipo_facturaFacturasGenerales) {
		this.mostrarnombre_tipo_facturaFacturasGenerales= mostrarnombre_tipo_facturaFacturasGenerales;
	}

	public Boolean getActivarnombre_tipo_facturaFacturasGenerales() {
		return this.activarnombre_tipo_facturaFacturasGenerales;
	}

	public void setActivarnombre_tipo_facturaFacturasGenerales(Boolean activarnombre_tipo_facturaFacturasGenerales) {
		this.activarnombre_tipo_facturaFacturasGenerales= activarnombre_tipo_facturaFacturasGenerales;
	}

	public Border setResaltarfecha_emisionFacturasGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasGeneralesBeanSwingJInternalFrame facturasgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturasgeneralesBeanSwingJInternalFrame.jTtoolBarFacturasGenerales.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionFacturasGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionFacturasGenerales() {
		return this.resaltarfecha_emisionFacturasGenerales;
	}

	public void setResaltarfecha_emisionFacturasGenerales(Border borderResaltar) {
		this.resaltarfecha_emisionFacturasGenerales= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionFacturasGenerales() {
		return this.mostrarfecha_emisionFacturasGenerales;
	}

	public void setMostrarfecha_emisionFacturasGenerales(Boolean mostrarfecha_emisionFacturasGenerales) {
		this.mostrarfecha_emisionFacturasGenerales= mostrarfecha_emisionFacturasGenerales;
	}

	public Boolean getActivarfecha_emisionFacturasGenerales() {
		return this.activarfecha_emisionFacturasGenerales;
	}

	public void setActivarfecha_emisionFacturasGenerales(Boolean activarfecha_emisionFacturasGenerales) {
		this.activarfecha_emisionFacturasGenerales= activarfecha_emisionFacturasGenerales;
	}

	public Border setResaltarfecha_vencimientoFacturasGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasGeneralesBeanSwingJInternalFrame facturasgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturasgeneralesBeanSwingJInternalFrame.jTtoolBarFacturasGenerales.setBorder(borderResaltar);
		
		this.resaltarfecha_vencimientoFacturasGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_vencimientoFacturasGenerales() {
		return this.resaltarfecha_vencimientoFacturasGenerales;
	}

	public void setResaltarfecha_vencimientoFacturasGenerales(Border borderResaltar) {
		this.resaltarfecha_vencimientoFacturasGenerales= borderResaltar;
	}

	public Boolean getMostrarfecha_vencimientoFacturasGenerales() {
		return this.mostrarfecha_vencimientoFacturasGenerales;
	}

	public void setMostrarfecha_vencimientoFacturasGenerales(Boolean mostrarfecha_vencimientoFacturasGenerales) {
		this.mostrarfecha_vencimientoFacturasGenerales= mostrarfecha_vencimientoFacturasGenerales;
	}

	public Boolean getActivarfecha_vencimientoFacturasGenerales() {
		return this.activarfecha_vencimientoFacturasGenerales;
	}

	public void setActivarfecha_vencimientoFacturasGenerales(Boolean activarfecha_vencimientoFacturasGenerales) {
		this.activarfecha_vencimientoFacturasGenerales= activarfecha_vencimientoFacturasGenerales;
	}

	public Border setResaltarnumero_pre_impresoFacturasGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasGeneralesBeanSwingJInternalFrame facturasgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturasgeneralesBeanSwingJInternalFrame.jTtoolBarFacturasGenerales.setBorder(borderResaltar);
		
		this.resaltarnumero_pre_impresoFacturasGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_pre_impresoFacturasGenerales() {
		return this.resaltarnumero_pre_impresoFacturasGenerales;
	}

	public void setResaltarnumero_pre_impresoFacturasGenerales(Border borderResaltar) {
		this.resaltarnumero_pre_impresoFacturasGenerales= borderResaltar;
	}

	public Boolean getMostrarnumero_pre_impresoFacturasGenerales() {
		return this.mostrarnumero_pre_impresoFacturasGenerales;
	}

	public void setMostrarnumero_pre_impresoFacturasGenerales(Boolean mostrarnumero_pre_impresoFacturasGenerales) {
		this.mostrarnumero_pre_impresoFacturasGenerales= mostrarnumero_pre_impresoFacturasGenerales;
	}

	public Boolean getActivarnumero_pre_impresoFacturasGenerales() {
		return this.activarnumero_pre_impresoFacturasGenerales;
	}

	public void setActivarnumero_pre_impresoFacturasGenerales(Boolean activarnumero_pre_impresoFacturasGenerales) {
		this.activarnumero_pre_impresoFacturasGenerales= activarnumero_pre_impresoFacturasGenerales;
	}

	public Border setResaltartotal_descuentoFacturasGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasGeneralesBeanSwingJInternalFrame facturasgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturasgeneralesBeanSwingJInternalFrame.jTtoolBarFacturasGenerales.setBorder(borderResaltar);
		
		this.resaltartotal_descuentoFacturasGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_descuentoFacturasGenerales() {
		return this.resaltartotal_descuentoFacturasGenerales;
	}

	public void setResaltartotal_descuentoFacturasGenerales(Border borderResaltar) {
		this.resaltartotal_descuentoFacturasGenerales= borderResaltar;
	}

	public Boolean getMostrartotal_descuentoFacturasGenerales() {
		return this.mostrartotal_descuentoFacturasGenerales;
	}

	public void setMostrartotal_descuentoFacturasGenerales(Boolean mostrartotal_descuentoFacturasGenerales) {
		this.mostrartotal_descuentoFacturasGenerales= mostrartotal_descuentoFacturasGenerales;
	}

	public Boolean getActivartotal_descuentoFacturasGenerales() {
		return this.activartotal_descuentoFacturasGenerales;
	}

	public void setActivartotal_descuentoFacturasGenerales(Boolean activartotal_descuentoFacturasGenerales) {
		this.activartotal_descuentoFacturasGenerales= activartotal_descuentoFacturasGenerales;
	}

	public Border setResaltartotal_otroFacturasGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasGeneralesBeanSwingJInternalFrame facturasgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturasgeneralesBeanSwingJInternalFrame.jTtoolBarFacturasGenerales.setBorder(borderResaltar);
		
		this.resaltartotal_otroFacturasGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_otroFacturasGenerales() {
		return this.resaltartotal_otroFacturasGenerales;
	}

	public void setResaltartotal_otroFacturasGenerales(Border borderResaltar) {
		this.resaltartotal_otroFacturasGenerales= borderResaltar;
	}

	public Boolean getMostrartotal_otroFacturasGenerales() {
		return this.mostrartotal_otroFacturasGenerales;
	}

	public void setMostrartotal_otroFacturasGenerales(Boolean mostrartotal_otroFacturasGenerales) {
		this.mostrartotal_otroFacturasGenerales= mostrartotal_otroFacturasGenerales;
	}

	public Boolean getActivartotal_otroFacturasGenerales() {
		return this.activartotal_otroFacturasGenerales;
	}

	public void setActivartotal_otroFacturasGenerales(Boolean activartotal_otroFacturasGenerales) {
		this.activartotal_otroFacturasGenerales= activartotal_otroFacturasGenerales;
	}

	public Border setResaltarsub_totalFacturasGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasGeneralesBeanSwingJInternalFrame facturasgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturasgeneralesBeanSwingJInternalFrame.jTtoolBarFacturasGenerales.setBorder(borderResaltar);
		
		this.resaltarsub_totalFacturasGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsub_totalFacturasGenerales() {
		return this.resaltarsub_totalFacturasGenerales;
	}

	public void setResaltarsub_totalFacturasGenerales(Border borderResaltar) {
		this.resaltarsub_totalFacturasGenerales= borderResaltar;
	}

	public Boolean getMostrarsub_totalFacturasGenerales() {
		return this.mostrarsub_totalFacturasGenerales;
	}

	public void setMostrarsub_totalFacturasGenerales(Boolean mostrarsub_totalFacturasGenerales) {
		this.mostrarsub_totalFacturasGenerales= mostrarsub_totalFacturasGenerales;
	}

	public Boolean getActivarsub_totalFacturasGenerales() {
		return this.activarsub_totalFacturasGenerales;
	}

	public void setActivarsub_totalFacturasGenerales(Boolean activarsub_totalFacturasGenerales) {
		this.activarsub_totalFacturasGenerales= activarsub_totalFacturasGenerales;
	}

	public Border setResaltartotalFacturasGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasGeneralesBeanSwingJInternalFrame facturasgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturasgeneralesBeanSwingJInternalFrame.jTtoolBarFacturasGenerales.setBorder(borderResaltar);
		
		this.resaltartotalFacturasGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalFacturasGenerales() {
		return this.resaltartotalFacturasGenerales;
	}

	public void setResaltartotalFacturasGenerales(Border borderResaltar) {
		this.resaltartotalFacturasGenerales= borderResaltar;
	}

	public Boolean getMostrartotalFacturasGenerales() {
		return this.mostrartotalFacturasGenerales;
	}

	public void setMostrartotalFacturasGenerales(Boolean mostrartotalFacturasGenerales) {
		this.mostrartotalFacturasGenerales= mostrartotalFacturasGenerales;
	}

	public Boolean getActivartotalFacturasGenerales() {
		return this.activartotalFacturasGenerales;
	}

	public void setActivartotalFacturasGenerales(Boolean activartotalFacturasGenerales) {
		this.activartotalFacturasGenerales= activartotalFacturasGenerales;
	}

	public Border setResaltarivaFacturasGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasGeneralesBeanSwingJInternalFrame facturasgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturasgeneralesBeanSwingJInternalFrame.jTtoolBarFacturasGenerales.setBorder(borderResaltar);
		
		this.resaltarivaFacturasGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarivaFacturasGenerales() {
		return this.resaltarivaFacturasGenerales;
	}

	public void setResaltarivaFacturasGenerales(Border borderResaltar) {
		this.resaltarivaFacturasGenerales= borderResaltar;
	}

	public Boolean getMostrarivaFacturasGenerales() {
		return this.mostrarivaFacturasGenerales;
	}

	public void setMostrarivaFacturasGenerales(Boolean mostrarivaFacturasGenerales) {
		this.mostrarivaFacturasGenerales= mostrarivaFacturasGenerales;
	}

	public Boolean getActivarivaFacturasGenerales() {
		return this.activarivaFacturasGenerales;
	}

	public void setActivarivaFacturasGenerales(Boolean activarivaFacturasGenerales) {
		this.activarivaFacturasGenerales= activarivaFacturasGenerales;
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
		
		
		this.setMostraridFacturasGenerales(esInicial);
		this.setMostrarid_zonaFacturasGenerales(esInicial);
		this.setMostrarid_tipo_clienteFacturasGenerales(esInicial);
		this.setMostrarid_empresaFacturasGenerales(esInicial);
		this.setMostrarid_sucursalFacturasGenerales(esInicial);
		this.setMostrarid_clienteFacturasGenerales(esInicial);
		this.setMostrarid_tipo_facturaFacturasGenerales(esInicial);
		this.setMostrarfecha_emision_desdeFacturasGenerales(esInicial);
		this.setMostrarfecha_emision_hastaFacturasGenerales(esInicial);
		this.setMostrarnombre_zonaFacturasGenerales(esInicial);
		this.setMostrarnombre_completo_clienteFacturasGenerales(esInicial);
		this.setMostrarnombre_tipo_facturaFacturasGenerales(esInicial);
		this.setMostrarfecha_emisionFacturasGenerales(esInicial);
		this.setMostrarfecha_vencimientoFacturasGenerales(esInicial);
		this.setMostrarnumero_pre_impresoFacturasGenerales(esInicial);
		this.setMostrartotal_descuentoFacturasGenerales(esInicial);
		this.setMostrartotal_otroFacturasGenerales(esInicial);
		this.setMostrarsub_totalFacturasGenerales(esInicial);
		this.setMostrartotalFacturasGenerales(esInicial);
		this.setMostrarivaFacturasGenerales(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FacturasGeneralesConstantesFunciones.ID)) {
				this.setMostraridFacturasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasGeneralesConstantesFunciones.IDZONA)) {
				this.setMostrarid_zonaFacturasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasGeneralesConstantesFunciones.IDTIPOCLIENTE)) {
				this.setMostrarid_tipo_clienteFacturasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasGeneralesConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaFacturasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasGeneralesConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalFacturasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasGeneralesConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteFacturasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasGeneralesConstantesFunciones.IDTIPOFACTURA)) {
				this.setMostrarid_tipo_facturaFacturasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasGeneralesConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setMostrarfecha_emision_desdeFacturasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasGeneralesConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setMostrarfecha_emision_hastaFacturasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasGeneralesConstantesFunciones.NOMBREZONA)) {
				this.setMostrarnombre_zonaFacturasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasGeneralesConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setMostrarnombre_completo_clienteFacturasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasGeneralesConstantesFunciones.NOMBRETIPOFACTURA)) {
				this.setMostrarnombre_tipo_facturaFacturasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasGeneralesConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionFacturasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasGeneralesConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setMostrarfecha_vencimientoFacturasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasGeneralesConstantesFunciones.NUMEROPREIMPRESO)) {
				this.setMostrarnumero_pre_impresoFacturasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasGeneralesConstantesFunciones.TOTALDESCUENTO)) {
				this.setMostrartotal_descuentoFacturasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasGeneralesConstantesFunciones.TOTALOTRO)) {
				this.setMostrartotal_otroFacturasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasGeneralesConstantesFunciones.SUBTOTAL)) {
				this.setMostrarsub_totalFacturasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasGeneralesConstantesFunciones.TOTAL)) {
				this.setMostrartotalFacturasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasGeneralesConstantesFunciones.IVA)) {
				this.setMostrarivaFacturasGenerales(esAsigna);
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
		
		
		this.setActivaridFacturasGenerales(esInicial);
		this.setActivarid_zonaFacturasGenerales(esInicial);
		this.setActivarid_tipo_clienteFacturasGenerales(esInicial);
		this.setActivarid_empresaFacturasGenerales(esInicial);
		this.setActivarid_sucursalFacturasGenerales(esInicial);
		this.setActivarid_clienteFacturasGenerales(esInicial);
		this.setActivarid_tipo_facturaFacturasGenerales(esInicial);
		this.setActivarfecha_emision_desdeFacturasGenerales(esInicial);
		this.setActivarfecha_emision_hastaFacturasGenerales(esInicial);
		this.setActivarnombre_zonaFacturasGenerales(esInicial);
		this.setActivarnombre_completo_clienteFacturasGenerales(esInicial);
		this.setActivarnombre_tipo_facturaFacturasGenerales(esInicial);
		this.setActivarfecha_emisionFacturasGenerales(esInicial);
		this.setActivarfecha_vencimientoFacturasGenerales(esInicial);
		this.setActivarnumero_pre_impresoFacturasGenerales(esInicial);
		this.setActivartotal_descuentoFacturasGenerales(esInicial);
		this.setActivartotal_otroFacturasGenerales(esInicial);
		this.setActivarsub_totalFacturasGenerales(esInicial);
		this.setActivartotalFacturasGenerales(esInicial);
		this.setActivarivaFacturasGenerales(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FacturasGeneralesConstantesFunciones.ID)) {
				this.setActivaridFacturasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasGeneralesConstantesFunciones.IDZONA)) {
				this.setActivarid_zonaFacturasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasGeneralesConstantesFunciones.IDTIPOCLIENTE)) {
				this.setActivarid_tipo_clienteFacturasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasGeneralesConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaFacturasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasGeneralesConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalFacturasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasGeneralesConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteFacturasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasGeneralesConstantesFunciones.IDTIPOFACTURA)) {
				this.setActivarid_tipo_facturaFacturasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasGeneralesConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setActivarfecha_emision_desdeFacturasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasGeneralesConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setActivarfecha_emision_hastaFacturasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasGeneralesConstantesFunciones.NOMBREZONA)) {
				this.setActivarnombre_zonaFacturasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasGeneralesConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setActivarnombre_completo_clienteFacturasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasGeneralesConstantesFunciones.NOMBRETIPOFACTURA)) {
				this.setActivarnombre_tipo_facturaFacturasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasGeneralesConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionFacturasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasGeneralesConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setActivarfecha_vencimientoFacturasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasGeneralesConstantesFunciones.NUMEROPREIMPRESO)) {
				this.setActivarnumero_pre_impresoFacturasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasGeneralesConstantesFunciones.TOTALDESCUENTO)) {
				this.setActivartotal_descuentoFacturasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasGeneralesConstantesFunciones.TOTALOTRO)) {
				this.setActivartotal_otroFacturasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasGeneralesConstantesFunciones.SUBTOTAL)) {
				this.setActivarsub_totalFacturasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasGeneralesConstantesFunciones.TOTAL)) {
				this.setActivartotalFacturasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasGeneralesConstantesFunciones.IVA)) {
				this.setActivarivaFacturasGenerales(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,FacturasGeneralesBeanSwingJInternalFrame facturasgeneralesBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridFacturasGenerales(esInicial);
		this.setResaltarid_zonaFacturasGenerales(esInicial);
		this.setResaltarid_tipo_clienteFacturasGenerales(esInicial);
		this.setResaltarid_empresaFacturasGenerales(esInicial);
		this.setResaltarid_sucursalFacturasGenerales(esInicial);
		this.setResaltarid_clienteFacturasGenerales(esInicial);
		this.setResaltarid_tipo_facturaFacturasGenerales(esInicial);
		this.setResaltarfecha_emision_desdeFacturasGenerales(esInicial);
		this.setResaltarfecha_emision_hastaFacturasGenerales(esInicial);
		this.setResaltarnombre_zonaFacturasGenerales(esInicial);
		this.setResaltarnombre_completo_clienteFacturasGenerales(esInicial);
		this.setResaltarnombre_tipo_facturaFacturasGenerales(esInicial);
		this.setResaltarfecha_emisionFacturasGenerales(esInicial);
		this.setResaltarfecha_vencimientoFacturasGenerales(esInicial);
		this.setResaltarnumero_pre_impresoFacturasGenerales(esInicial);
		this.setResaltartotal_descuentoFacturasGenerales(esInicial);
		this.setResaltartotal_otroFacturasGenerales(esInicial);
		this.setResaltarsub_totalFacturasGenerales(esInicial);
		this.setResaltartotalFacturasGenerales(esInicial);
		this.setResaltarivaFacturasGenerales(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FacturasGeneralesConstantesFunciones.ID)) {
				this.setResaltaridFacturasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasGeneralesConstantesFunciones.IDZONA)) {
				this.setResaltarid_zonaFacturasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasGeneralesConstantesFunciones.IDTIPOCLIENTE)) {
				this.setResaltarid_tipo_clienteFacturasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasGeneralesConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaFacturasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasGeneralesConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalFacturasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasGeneralesConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteFacturasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasGeneralesConstantesFunciones.IDTIPOFACTURA)) {
				this.setResaltarid_tipo_facturaFacturasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasGeneralesConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setResaltarfecha_emision_desdeFacturasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasGeneralesConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setResaltarfecha_emision_hastaFacturasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasGeneralesConstantesFunciones.NOMBREZONA)) {
				this.setResaltarnombre_zonaFacturasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasGeneralesConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setResaltarnombre_completo_clienteFacturasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasGeneralesConstantesFunciones.NOMBRETIPOFACTURA)) {
				this.setResaltarnombre_tipo_facturaFacturasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasGeneralesConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionFacturasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasGeneralesConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setResaltarfecha_vencimientoFacturasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasGeneralesConstantesFunciones.NUMEROPREIMPRESO)) {
				this.setResaltarnumero_pre_impresoFacturasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasGeneralesConstantesFunciones.TOTALDESCUENTO)) {
				this.setResaltartotal_descuentoFacturasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasGeneralesConstantesFunciones.TOTALOTRO)) {
				this.setResaltartotal_otroFacturasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasGeneralesConstantesFunciones.SUBTOTAL)) {
				this.setResaltarsub_totalFacturasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasGeneralesConstantesFunciones.TOTAL)) {
				this.setResaltartotalFacturasGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasGeneralesConstantesFunciones.IVA)) {
				this.setResaltarivaFacturasGenerales(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,FacturasGeneralesBeanSwingJInternalFrame facturasgeneralesBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaFacturasGeneralesFacturasGenerales=true;

	public Boolean getMostrarBusquedaFacturasGeneralesFacturasGenerales() {
		return this.mostrarBusquedaFacturasGeneralesFacturasGenerales;
	}

	public void setMostrarBusquedaFacturasGeneralesFacturasGenerales(Boolean visibilidadResaltar) {
		this.mostrarBusquedaFacturasGeneralesFacturasGenerales= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaFacturasGeneralesFacturasGenerales=true;

	public Boolean getActivarBusquedaFacturasGeneralesFacturasGenerales() {
		return this.activarBusquedaFacturasGeneralesFacturasGenerales;
	}

	public void setActivarBusquedaFacturasGeneralesFacturasGenerales(Boolean habilitarResaltar) {
		this.activarBusquedaFacturasGeneralesFacturasGenerales= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaFacturasGeneralesFacturasGenerales=null;

	public Border getResaltarBusquedaFacturasGeneralesFacturasGenerales() {
		return this.resaltarBusquedaFacturasGeneralesFacturasGenerales;
	}

	public void setResaltarBusquedaFacturasGeneralesFacturasGenerales(Border borderResaltar) {
		this.resaltarBusquedaFacturasGeneralesFacturasGenerales= borderResaltar;
	}

	public void setResaltarBusquedaFacturasGeneralesFacturasGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasGeneralesBeanSwingJInternalFrame facturasgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaFacturasGeneralesFacturasGenerales= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}