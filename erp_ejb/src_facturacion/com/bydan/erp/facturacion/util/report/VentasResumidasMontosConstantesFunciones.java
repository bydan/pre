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


import com.bydan.erp.facturacion.util.report.VentasResumidasMontosConstantesFunciones;
import com.bydan.erp.facturacion.util.report.VentasResumidasMontosParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.report.VentasResumidasMontosParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.facturacion.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.comisiones.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class VentasResumidasMontosConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="VentasResumidasMontos";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="VentasResumidasMontos"+VentasResumidasMontosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="VentasResumidasMontosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="VentasResumidasMontosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=VentasResumidasMontosConstantesFunciones.SCHEMA+"_"+VentasResumidasMontosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/VentasResumidasMontosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=VentasResumidasMontosConstantesFunciones.SCHEMA+"_"+VentasResumidasMontosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=VentasResumidasMontosConstantesFunciones.SCHEMA+"_"+VentasResumidasMontosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/VentasResumidasMontosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=VentasResumidasMontosConstantesFunciones.SCHEMA+"_"+VentasResumidasMontosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VentasResumidasMontosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/VentasResumidasMontosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VentasResumidasMontosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VentasResumidasMontosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/VentasResumidasMontosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VentasResumidasMontosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=VentasResumidasMontosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+VentasResumidasMontosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=VentasResumidasMontosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+VentasResumidasMontosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Ventas Resumidas Montoses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Ventas Resumidas Montos";
	public static final String SCLASSWEBTITULO_LOWER="Ventas Resumidas Montos";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="VentasResumidasMontos";
	public static final String OBJECTNAME="ventasresumidasmontos";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="ventas_resumidas_montos";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select ventasresumidasmontos from "+VentasResumidasMontosConstantesFunciones.SPERSISTENCENAME+" ventasresumidasmontos";
	public static String QUERYSELECTNATIVE="select "+VentasResumidasMontosConstantesFunciones.SCHEMA+"."+VentasResumidasMontosConstantesFunciones.TABLENAME+".id,"+VentasResumidasMontosConstantesFunciones.SCHEMA+"."+VentasResumidasMontosConstantesFunciones.TABLENAME+".version_row,"+VentasResumidasMontosConstantesFunciones.SCHEMA+"."+VentasResumidasMontosConstantesFunciones.TABLENAME+".id_empresa,"+VentasResumidasMontosConstantesFunciones.SCHEMA+"."+VentasResumidasMontosConstantesFunciones.TABLENAME+".id_sucursal,"+VentasResumidasMontosConstantesFunciones.SCHEMA+"."+VentasResumidasMontosConstantesFunciones.TABLENAME+".id_vendedor,"+VentasResumidasMontosConstantesFunciones.SCHEMA+"."+VentasResumidasMontosConstantesFunciones.TABLENAME+".fecha_emision_desde,"+VentasResumidasMontosConstantesFunciones.SCHEMA+"."+VentasResumidasMontosConstantesFunciones.TABLENAME+".fecha_emision_hasta,"+VentasResumidasMontosConstantesFunciones.SCHEMA+"."+VentasResumidasMontosConstantesFunciones.TABLENAME+".nombre_completo,"+VentasResumidasMontosConstantesFunciones.SCHEMA+"."+VentasResumidasMontosConstantesFunciones.TABLENAME+".nombre_vendedor,"+VentasResumidasMontosConstantesFunciones.SCHEMA+"."+VentasResumidasMontosConstantesFunciones.TABLENAME+".nombre_tipo_factura,"+VentasResumidasMontosConstantesFunciones.SCHEMA+"."+VentasResumidasMontosConstantesFunciones.TABLENAME+".fecha_emision,"+VentasResumidasMontosConstantesFunciones.SCHEMA+"."+VentasResumidasMontosConstantesFunciones.TABLENAME+".fecha_vencimiento,"+VentasResumidasMontosConstantesFunciones.SCHEMA+"."+VentasResumidasMontosConstantesFunciones.TABLENAME+".numero_pre_impreso,"+VentasResumidasMontosConstantesFunciones.SCHEMA+"."+VentasResumidasMontosConstantesFunciones.TABLENAME+".total_iva,"+VentasResumidasMontosConstantesFunciones.SCHEMA+"."+VentasResumidasMontosConstantesFunciones.TABLENAME+".total_sin_iva,"+VentasResumidasMontosConstantesFunciones.SCHEMA+"."+VentasResumidasMontosConstantesFunciones.TABLENAME+".total_descuento,"+VentasResumidasMontosConstantesFunciones.SCHEMA+"."+VentasResumidasMontosConstantesFunciones.TABLENAME+".total_otro,"+VentasResumidasMontosConstantesFunciones.SCHEMA+"."+VentasResumidasMontosConstantesFunciones.TABLENAME+".sub_total,"+VentasResumidasMontosConstantesFunciones.SCHEMA+"."+VentasResumidasMontosConstantesFunciones.TABLENAME+".total,"+VentasResumidasMontosConstantesFunciones.SCHEMA+"."+VentasResumidasMontosConstantesFunciones.TABLENAME+".iva,"+VentasResumidasMontosConstantesFunciones.SCHEMA+"."+VentasResumidasMontosConstantesFunciones.TABLENAME+".descripcion from "+VentasResumidasMontosConstantesFunciones.SCHEMA+"."+VentasResumidasMontosConstantesFunciones.TABLENAME;//+" as "+VentasResumidasMontosConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDVENDEDOR= "id_vendedor";
    public static final String FECHAEMISIONDESDE= "fecha_emision_desde";
    public static final String FECHAEMISIONHASTA= "fecha_emision_hasta";
    public static final String NOMBRECOMPLETO= "nombre_completo";
    public static final String NOMBREVENDEDOR= "nombre_vendedor";
    public static final String NOMBRETIPOFACTURA= "nombre_tipo_factura";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String FECHAVENCIMIENTO= "fecha_vencimiento";
    public static final String NUMEROPREIMPRESO= "numero_pre_impreso";
    public static final String TOTALIVA= "total_iva";
    public static final String TOTALSINIVA= "total_sin_iva";
    public static final String TOTALDESCUENTO= "total_descuento";
    public static final String TOTALOTRO= "total_otro";
    public static final String SUBTOTAL= "sub_total";
    public static final String TOTAL= "total";
    public static final String IVA= "iva";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDVENDEDOR= "Vendedor";
		public static final String LABEL_IDVENDEDOR_LOWER= "Vendedor";
    	public static final String LABEL_FECHAEMISIONDESDE= "Fecha Emision Desde";
		public static final String LABEL_FECHAEMISIONDESDE_LOWER= "Fecha Emision Desde";
    	public static final String LABEL_FECHAEMISIONHASTA= "Fecha Emision Hasta";
		public static final String LABEL_FECHAEMISIONHASTA_LOWER= "Fecha Emision Hasta";
    	public static final String LABEL_NOMBRECOMPLETO= "Nombre Completo";
		public static final String LABEL_NOMBRECOMPLETO_LOWER= "Nombre Completo";
    	public static final String LABEL_NOMBREVENDEDOR= "Nombre Vendedor";
		public static final String LABEL_NOMBREVENDEDOR_LOWER= "Nombre Vendedor";
    	public static final String LABEL_NOMBRETIPOFACTURA= "Nombre Tipo Factura";
		public static final String LABEL_NOMBRETIPOFACTURA_LOWER= "Nombre Tipo Factura";
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
    	public static final String LABEL_FECHAVENCIMIENTO= "Fecha Vencimiento";
		public static final String LABEL_FECHAVENCIMIENTO_LOWER= "Fecha Vencimiento";
    	public static final String LABEL_NUMEROPREIMPRESO= "Numero Pre Impreso";
		public static final String LABEL_NUMEROPREIMPRESO_LOWER= "Numero Pre Impreso";
    	public static final String LABEL_TOTALIVA= "Total Iva";
		public static final String LABEL_TOTALIVA_LOWER= "Total Iva";
    	public static final String LABEL_TOTALSINIVA= "Total Sin Iva";
		public static final String LABEL_TOTALSINIVA_LOWER= "Total Sin Iva";
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
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
		
		
	public static final String SREGEXNOMBRE_COMPLETO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_COMPLETO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_VENDEDOR=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_VENDEDOR=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_TIPO_FACTURA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_TIPO_FACTURA=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXNUMERO_PRE_IMPRESO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_PRE_IMPRESO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getVentasResumidasMontosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(VentasResumidasMontosConstantesFunciones.IDEMPRESA)) {sLabelColumna=VentasResumidasMontosConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(VentasResumidasMontosConstantesFunciones.IDSUCURSAL)) {sLabelColumna=VentasResumidasMontosConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(VentasResumidasMontosConstantesFunciones.IDVENDEDOR)) {sLabelColumna=VentasResumidasMontosConstantesFunciones.LABEL_IDVENDEDOR;}
		if(sNombreColumna.equals(VentasResumidasMontosConstantesFunciones.FECHAEMISIONDESDE)) {sLabelColumna=VentasResumidasMontosConstantesFunciones.LABEL_FECHAEMISIONDESDE;}
		if(sNombreColumna.equals(VentasResumidasMontosConstantesFunciones.FECHAEMISIONHASTA)) {sLabelColumna=VentasResumidasMontosConstantesFunciones.LABEL_FECHAEMISIONHASTA;}
		if(sNombreColumna.equals(VentasResumidasMontosConstantesFunciones.NOMBRECOMPLETO)) {sLabelColumna=VentasResumidasMontosConstantesFunciones.LABEL_NOMBRECOMPLETO;}
		if(sNombreColumna.equals(VentasResumidasMontosConstantesFunciones.NOMBREVENDEDOR)) {sLabelColumna=VentasResumidasMontosConstantesFunciones.LABEL_NOMBREVENDEDOR;}
		if(sNombreColumna.equals(VentasResumidasMontosConstantesFunciones.NOMBRETIPOFACTURA)) {sLabelColumna=VentasResumidasMontosConstantesFunciones.LABEL_NOMBRETIPOFACTURA;}
		if(sNombreColumna.equals(VentasResumidasMontosConstantesFunciones.FECHAEMISION)) {sLabelColumna=VentasResumidasMontosConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(VentasResumidasMontosConstantesFunciones.FECHAVENCIMIENTO)) {sLabelColumna=VentasResumidasMontosConstantesFunciones.LABEL_FECHAVENCIMIENTO;}
		if(sNombreColumna.equals(VentasResumidasMontosConstantesFunciones.NUMEROPREIMPRESO)) {sLabelColumna=VentasResumidasMontosConstantesFunciones.LABEL_NUMEROPREIMPRESO;}
		if(sNombreColumna.equals(VentasResumidasMontosConstantesFunciones.TOTALIVA)) {sLabelColumna=VentasResumidasMontosConstantesFunciones.LABEL_TOTALIVA;}
		if(sNombreColumna.equals(VentasResumidasMontosConstantesFunciones.TOTALSINIVA)) {sLabelColumna=VentasResumidasMontosConstantesFunciones.LABEL_TOTALSINIVA;}
		if(sNombreColumna.equals(VentasResumidasMontosConstantesFunciones.TOTALDESCUENTO)) {sLabelColumna=VentasResumidasMontosConstantesFunciones.LABEL_TOTALDESCUENTO;}
		if(sNombreColumna.equals(VentasResumidasMontosConstantesFunciones.TOTALOTRO)) {sLabelColumna=VentasResumidasMontosConstantesFunciones.LABEL_TOTALOTRO;}
		if(sNombreColumna.equals(VentasResumidasMontosConstantesFunciones.SUBTOTAL)) {sLabelColumna=VentasResumidasMontosConstantesFunciones.LABEL_SUBTOTAL;}
		if(sNombreColumna.equals(VentasResumidasMontosConstantesFunciones.TOTAL)) {sLabelColumna=VentasResumidasMontosConstantesFunciones.LABEL_TOTAL;}
		if(sNombreColumna.equals(VentasResumidasMontosConstantesFunciones.IVA)) {sLabelColumna=VentasResumidasMontosConstantesFunciones.LABEL_IVA;}
		if(sNombreColumna.equals(VentasResumidasMontosConstantesFunciones.DESCRIPCION)) {sLabelColumna=VentasResumidasMontosConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getVentasResumidasMontosDescripcion(VentasResumidasMontos ventasresumidasmontos) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(ventasresumidasmontos !=null/* && ventasresumidasmontos.getId()!=0*/) {
			if(ventasresumidasmontos.getId()!=null) {
				sDescripcion=ventasresumidasmontos.getId().toString();
			}//ventasresumidasmontosventasresumidasmontos.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getVentasResumidasMontosDescripcionDetallado(VentasResumidasMontos ventasresumidasmontos) {
		String sDescripcion="";
			
		sDescripcion+=VentasResumidasMontosConstantesFunciones.ID+"=";
		sDescripcion+=ventasresumidasmontos.getId().toString()+",";
		sDescripcion+=VentasResumidasMontosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=ventasresumidasmontos.getVersionRow().toString()+",";
		sDescripcion+=VentasResumidasMontosConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=ventasresumidasmontos.getid_empresa().toString()+",";
		sDescripcion+=VentasResumidasMontosConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=ventasresumidasmontos.getid_sucursal().toString()+",";
		sDescripcion+=VentasResumidasMontosConstantesFunciones.IDVENDEDOR+"=";
		sDescripcion+=ventasresumidasmontos.getid_vendedor().toString()+",";
		sDescripcion+=VentasResumidasMontosConstantesFunciones.FECHAEMISIONDESDE+"=";
		sDescripcion+=ventasresumidasmontos.getfecha_emision_desde().toString()+",";
		sDescripcion+=VentasResumidasMontosConstantesFunciones.FECHAEMISIONHASTA+"=";
		sDescripcion+=ventasresumidasmontos.getfecha_emision_hasta().toString()+",";
		sDescripcion+=VentasResumidasMontosConstantesFunciones.NOMBRECOMPLETO+"=";
		sDescripcion+=ventasresumidasmontos.getnombre_completo()+",";
		sDescripcion+=VentasResumidasMontosConstantesFunciones.NOMBREVENDEDOR+"=";
		sDescripcion+=ventasresumidasmontos.getnombre_vendedor()+",";
		sDescripcion+=VentasResumidasMontosConstantesFunciones.NOMBRETIPOFACTURA+"=";
		sDescripcion+=ventasresumidasmontos.getnombre_tipo_factura()+",";
		sDescripcion+=VentasResumidasMontosConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=ventasresumidasmontos.getfecha_emision().toString()+",";
		sDescripcion+=VentasResumidasMontosConstantesFunciones.FECHAVENCIMIENTO+"=";
		sDescripcion+=ventasresumidasmontos.getfecha_vencimiento().toString()+",";
		sDescripcion+=VentasResumidasMontosConstantesFunciones.NUMEROPREIMPRESO+"=";
		sDescripcion+=ventasresumidasmontos.getnumero_pre_impreso()+",";
		sDescripcion+=VentasResumidasMontosConstantesFunciones.TOTALIVA+"=";
		sDescripcion+=ventasresumidasmontos.gettotal_iva().toString()+",";
		sDescripcion+=VentasResumidasMontosConstantesFunciones.TOTALSINIVA+"=";
		sDescripcion+=ventasresumidasmontos.gettotal_sin_iva().toString()+",";
		sDescripcion+=VentasResumidasMontosConstantesFunciones.TOTALDESCUENTO+"=";
		sDescripcion+=ventasresumidasmontos.gettotal_descuento().toString()+",";
		sDescripcion+=VentasResumidasMontosConstantesFunciones.TOTALOTRO+"=";
		sDescripcion+=ventasresumidasmontos.gettotal_otro().toString()+",";
		sDescripcion+=VentasResumidasMontosConstantesFunciones.SUBTOTAL+"=";
		sDescripcion+=ventasresumidasmontos.getsub_total().toString()+",";
		sDescripcion+=VentasResumidasMontosConstantesFunciones.TOTAL+"=";
		sDescripcion+=ventasresumidasmontos.gettotal().toString()+",";
		sDescripcion+=VentasResumidasMontosConstantesFunciones.IVA+"=";
		sDescripcion+=ventasresumidasmontos.getiva().toString()+",";
		sDescripcion+=VentasResumidasMontosConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=ventasresumidasmontos.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setVentasResumidasMontosDescripcion(VentasResumidasMontos ventasresumidasmontos,String sValor) throws Exception {			
		if(ventasresumidasmontos !=null) {
			//ventasresumidasmontosventasresumidasmontos.getId().toString();
		}		
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

	public static String getVendedorDescripcion(Vendedor vendedor) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(vendedor!=null/*&&vendedor.getId()>0*/) {
			sDescripcion=VendedorConstantesFunciones.getVendedorDescripcion(vendedor);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaVentasResumidasMontos")) {
			sNombreIndice="Tipo=  Por Vendedor Por Fecha Emision Desde Por Fecha Emision Hasta";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdVendedor")) {
			sNombreIndice="Tipo=  Por Vendedor";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaVentasResumidasMontos(Long id_vendedor,Date fecha_emision_desde,Date fecha_emision_hasta) {
		String sDetalleIndice=" Parametros->";
		if(id_vendedor!=null) {sDetalleIndice+=" Codigo Unico De Vendedor="+id_vendedor.toString();}
		if(fecha_emision_desde!=null) {sDetalleIndice+=" Fecha Emision Desde="+fecha_emision_desde.toString();}
		if(fecha_emision_hasta!=null) {sDetalleIndice+=" Fecha Emision Hasta="+fecha_emision_hasta.toString();} 

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

	public static String getDetalleIndiceFK_IdVendedor(Long id_vendedor) {
		String sDetalleIndice=" Parametros->";
		if(id_vendedor!=null) {sDetalleIndice+=" Codigo Unico De Vendedor="+id_vendedor.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosVentasResumidasMontos(VentasResumidasMontos ventasresumidasmontos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ventasresumidasmontos.setnombre_completo(ventasresumidasmontos.getnombre_completo().trim());
		ventasresumidasmontos.setnombre_vendedor(ventasresumidasmontos.getnombre_vendedor().trim());
		ventasresumidasmontos.setnombre_tipo_factura(ventasresumidasmontos.getnombre_tipo_factura().trim());
		ventasresumidasmontos.setnumero_pre_impreso(ventasresumidasmontos.getnumero_pre_impreso().trim());
		ventasresumidasmontos.setdescripcion(ventasresumidasmontos.getdescripcion().trim());
	}
	
	public static void quitarEspaciosVentasResumidasMontoss(List<VentasResumidasMontos> ventasresumidasmontoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(VentasResumidasMontos ventasresumidasmontos: ventasresumidasmontoss) {
			ventasresumidasmontos.setnombre_completo(ventasresumidasmontos.getnombre_completo().trim());
			ventasresumidasmontos.setnombre_vendedor(ventasresumidasmontos.getnombre_vendedor().trim());
			ventasresumidasmontos.setnombre_tipo_factura(ventasresumidasmontos.getnombre_tipo_factura().trim());
			ventasresumidasmontos.setnumero_pre_impreso(ventasresumidasmontos.getnumero_pre_impreso().trim());
			ventasresumidasmontos.setdescripcion(ventasresumidasmontos.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresVentasResumidasMontos(VentasResumidasMontos ventasresumidasmontos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && ventasresumidasmontos.getConCambioAuxiliar()) {
			ventasresumidasmontos.setIsDeleted(ventasresumidasmontos.getIsDeletedAuxiliar());	
			ventasresumidasmontos.setIsNew(ventasresumidasmontos.getIsNewAuxiliar());	
			ventasresumidasmontos.setIsChanged(ventasresumidasmontos.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			ventasresumidasmontos.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			ventasresumidasmontos.setIsDeletedAuxiliar(false);	
			ventasresumidasmontos.setIsNewAuxiliar(false);	
			ventasresumidasmontos.setIsChangedAuxiliar(false);
			
			ventasresumidasmontos.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresVentasResumidasMontoss(List<VentasResumidasMontos> ventasresumidasmontoss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(VentasResumidasMontos ventasresumidasmontos : ventasresumidasmontoss) {
			if(conAsignarBase && ventasresumidasmontos.getConCambioAuxiliar()) {
				ventasresumidasmontos.setIsDeleted(ventasresumidasmontos.getIsDeletedAuxiliar());	
				ventasresumidasmontos.setIsNew(ventasresumidasmontos.getIsNewAuxiliar());	
				ventasresumidasmontos.setIsChanged(ventasresumidasmontos.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				ventasresumidasmontos.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				ventasresumidasmontos.setIsDeletedAuxiliar(false);	
				ventasresumidasmontos.setIsNewAuxiliar(false);	
				ventasresumidasmontos.setIsChangedAuxiliar(false);
				
				ventasresumidasmontos.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresVentasResumidasMontos(VentasResumidasMontos ventasresumidasmontos,Boolean conEnteros) throws Exception  {
		ventasresumidasmontos.settotal_iva(0.0);
		ventasresumidasmontos.settotal_sin_iva(0.0);
		ventasresumidasmontos.settotal_descuento(0.0);
		ventasresumidasmontos.settotal_otro(0.0);
		ventasresumidasmontos.setsub_total(0.0);
		ventasresumidasmontos.settotal(0.0);
		ventasresumidasmontos.setiva(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresVentasResumidasMontoss(List<VentasResumidasMontos> ventasresumidasmontoss,Boolean conEnteros) throws Exception  {
		
		for(VentasResumidasMontos ventasresumidasmontos: ventasresumidasmontoss) {
			ventasresumidasmontos.settotal_iva(0.0);
			ventasresumidasmontos.settotal_sin_iva(0.0);
			ventasresumidasmontos.settotal_descuento(0.0);
			ventasresumidasmontos.settotal_otro(0.0);
			ventasresumidasmontos.setsub_total(0.0);
			ventasresumidasmontos.settotal(0.0);
			ventasresumidasmontos.setiva(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaVentasResumidasMontos(List<VentasResumidasMontos> ventasresumidasmontoss,VentasResumidasMontos ventasresumidasmontosAux) throws Exception  {
		VentasResumidasMontosConstantesFunciones.InicializarValoresVentasResumidasMontos(ventasresumidasmontosAux,true);
		
		for(VentasResumidasMontos ventasresumidasmontos: ventasresumidasmontoss) {
			if(ventasresumidasmontos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			ventasresumidasmontosAux.settotal_iva(ventasresumidasmontosAux.gettotal_iva()+ventasresumidasmontos.gettotal_iva());			
			ventasresumidasmontosAux.settotal_sin_iva(ventasresumidasmontosAux.gettotal_sin_iva()+ventasresumidasmontos.gettotal_sin_iva());			
			ventasresumidasmontosAux.settotal_descuento(ventasresumidasmontosAux.gettotal_descuento()+ventasresumidasmontos.gettotal_descuento());			
			ventasresumidasmontosAux.settotal_otro(ventasresumidasmontosAux.gettotal_otro()+ventasresumidasmontos.gettotal_otro());			
			ventasresumidasmontosAux.setsub_total(ventasresumidasmontosAux.getsub_total()+ventasresumidasmontos.getsub_total());			
			ventasresumidasmontosAux.settotal(ventasresumidasmontosAux.gettotal()+ventasresumidasmontos.gettotal());			
			ventasresumidasmontosAux.setiva(ventasresumidasmontosAux.getiva()+ventasresumidasmontos.getiva());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesVentasResumidasMontos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=VentasResumidasMontosConstantesFunciones.getArrayColumnasGlobalesVentasResumidasMontos(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesVentasResumidasMontos(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(VentasResumidasMontosConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(VentasResumidasMontosConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(VentasResumidasMontosConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(VentasResumidasMontosConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoVentasResumidasMontos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<VentasResumidasMontos> ventasresumidasmontoss,VentasResumidasMontos ventasresumidasmontos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(VentasResumidasMontos ventasresumidasmontosAux: ventasresumidasmontoss) {
			if(ventasresumidasmontosAux!=null && ventasresumidasmontos!=null) {
				if((ventasresumidasmontosAux.getId()==null && ventasresumidasmontos.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(ventasresumidasmontosAux.getId()!=null && ventasresumidasmontos.getId()!=null){
					if(ventasresumidasmontosAux.getId().equals(ventasresumidasmontos.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaVentasResumidasMontos(List<VentasResumidasMontos> ventasresumidasmontoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double total_ivaTotal=0.0;
		Double total_sin_ivaTotal=0.0;
		Double total_descuentoTotal=0.0;
		Double total_otroTotal=0.0;
		Double sub_totalTotal=0.0;
		Double totalTotal=0.0;
		Double ivaTotal=0.0;
	
		for(VentasResumidasMontos ventasresumidasmontos: ventasresumidasmontoss) {			
			if(ventasresumidasmontos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			total_ivaTotal+=ventasresumidasmontos.gettotal_iva();
			total_sin_ivaTotal+=ventasresumidasmontos.gettotal_sin_iva();
			total_descuentoTotal+=ventasresumidasmontos.gettotal_descuento();
			total_otroTotal+=ventasresumidasmontos.gettotal_otro();
			sub_totalTotal+=ventasresumidasmontos.getsub_total();
			totalTotal+=ventasresumidasmontos.gettotal();
			ivaTotal+=ventasresumidasmontos.getiva();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasResumidasMontosConstantesFunciones.TOTALIVA);
		datoGeneral.setsDescripcion(VentasResumidasMontosConstantesFunciones.LABEL_TOTALIVA);
		datoGeneral.setdValorDouble(total_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasResumidasMontosConstantesFunciones.TOTALSINIVA);
		datoGeneral.setsDescripcion(VentasResumidasMontosConstantesFunciones.LABEL_TOTALSINIVA);
		datoGeneral.setdValorDouble(total_sin_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasResumidasMontosConstantesFunciones.TOTALDESCUENTO);
		datoGeneral.setsDescripcion(VentasResumidasMontosConstantesFunciones.LABEL_TOTALDESCUENTO);
		datoGeneral.setdValorDouble(total_descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasResumidasMontosConstantesFunciones.TOTALOTRO);
		datoGeneral.setsDescripcion(VentasResumidasMontosConstantesFunciones.LABEL_TOTALOTRO);
		datoGeneral.setdValorDouble(total_otroTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasResumidasMontosConstantesFunciones.SUBTOTAL);
		datoGeneral.setsDescripcion(VentasResumidasMontosConstantesFunciones.LABEL_SUBTOTAL);
		datoGeneral.setdValorDouble(sub_totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasResumidasMontosConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(VentasResumidasMontosConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasResumidasMontosConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(VentasResumidasMontosConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaVentasResumidasMontos() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,VentasResumidasMontosConstantesFunciones.LABEL_ID, VentasResumidasMontosConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasResumidasMontosConstantesFunciones.LABEL_VERSIONROW, VentasResumidasMontosConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasResumidasMontosConstantesFunciones.LABEL_NOMBRECOMPLETO, VentasResumidasMontosConstantesFunciones.NOMBRECOMPLETO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasResumidasMontosConstantesFunciones.LABEL_NOMBREVENDEDOR, VentasResumidasMontosConstantesFunciones.NOMBREVENDEDOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasResumidasMontosConstantesFunciones.LABEL_NOMBRETIPOFACTURA, VentasResumidasMontosConstantesFunciones.NOMBRETIPOFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasResumidasMontosConstantesFunciones.LABEL_FECHAEMISION, VentasResumidasMontosConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasResumidasMontosConstantesFunciones.LABEL_FECHAVENCIMIENTO, VentasResumidasMontosConstantesFunciones.FECHAVENCIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasResumidasMontosConstantesFunciones.LABEL_NUMEROPREIMPRESO, VentasResumidasMontosConstantesFunciones.NUMEROPREIMPRESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasResumidasMontosConstantesFunciones.LABEL_TOTALIVA, VentasResumidasMontosConstantesFunciones.TOTALIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasResumidasMontosConstantesFunciones.LABEL_TOTALSINIVA, VentasResumidasMontosConstantesFunciones.TOTALSINIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasResumidasMontosConstantesFunciones.LABEL_TOTALDESCUENTO, VentasResumidasMontosConstantesFunciones.TOTALDESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasResumidasMontosConstantesFunciones.LABEL_TOTALOTRO, VentasResumidasMontosConstantesFunciones.TOTALOTRO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasResumidasMontosConstantesFunciones.LABEL_SUBTOTAL, VentasResumidasMontosConstantesFunciones.SUBTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasResumidasMontosConstantesFunciones.LABEL_TOTAL, VentasResumidasMontosConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasResumidasMontosConstantesFunciones.LABEL_IVA, VentasResumidasMontosConstantesFunciones.IVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasResumidasMontosConstantesFunciones.LABEL_DESCRIPCION, VentasResumidasMontosConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasVentasResumidasMontos() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=VentasResumidasMontosConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasResumidasMontosConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasResumidasMontosConstantesFunciones.NOMBRECOMPLETO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasResumidasMontosConstantesFunciones.NOMBREVENDEDOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasResumidasMontosConstantesFunciones.NOMBRETIPOFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasResumidasMontosConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasResumidasMontosConstantesFunciones.FECHAVENCIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasResumidasMontosConstantesFunciones.NUMEROPREIMPRESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasResumidasMontosConstantesFunciones.TOTALIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasResumidasMontosConstantesFunciones.TOTALSINIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasResumidasMontosConstantesFunciones.TOTALDESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasResumidasMontosConstantesFunciones.TOTALOTRO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasResumidasMontosConstantesFunciones.SUBTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasResumidasMontosConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasResumidasMontosConstantesFunciones.IVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasResumidasMontosConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVentasResumidasMontos() throws Exception  {
		return VentasResumidasMontosConstantesFunciones.getTiposSeleccionarVentasResumidasMontos(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVentasResumidasMontos(Boolean conFk) throws Exception  {
		return VentasResumidasMontosConstantesFunciones.getTiposSeleccionarVentasResumidasMontos(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVentasResumidasMontos(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasResumidasMontosConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(VentasResumidasMontosConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasResumidasMontosConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(VentasResumidasMontosConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasResumidasMontosConstantesFunciones.LABEL_IDVENDEDOR);
			reporte.setsDescripcion(VentasResumidasMontosConstantesFunciones.LABEL_IDVENDEDOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasResumidasMontosConstantesFunciones.LABEL_FECHAEMISIONDESDE);
			reporte.setsDescripcion(VentasResumidasMontosConstantesFunciones.LABEL_FECHAEMISIONDESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasResumidasMontosConstantesFunciones.LABEL_FECHAEMISIONHASTA);
			reporte.setsDescripcion(VentasResumidasMontosConstantesFunciones.LABEL_FECHAEMISIONHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasResumidasMontosConstantesFunciones.LABEL_NOMBRECOMPLETO);
			reporte.setsDescripcion(VentasResumidasMontosConstantesFunciones.LABEL_NOMBRECOMPLETO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasResumidasMontosConstantesFunciones.LABEL_NOMBREVENDEDOR);
			reporte.setsDescripcion(VentasResumidasMontosConstantesFunciones.LABEL_NOMBREVENDEDOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasResumidasMontosConstantesFunciones.LABEL_NOMBRETIPOFACTURA);
			reporte.setsDescripcion(VentasResumidasMontosConstantesFunciones.LABEL_NOMBRETIPOFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasResumidasMontosConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(VentasResumidasMontosConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasResumidasMontosConstantesFunciones.LABEL_FECHAVENCIMIENTO);
			reporte.setsDescripcion(VentasResumidasMontosConstantesFunciones.LABEL_FECHAVENCIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasResumidasMontosConstantesFunciones.LABEL_NUMEROPREIMPRESO);
			reporte.setsDescripcion(VentasResumidasMontosConstantesFunciones.LABEL_NUMEROPREIMPRESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasResumidasMontosConstantesFunciones.LABEL_TOTALIVA);
			reporte.setsDescripcion(VentasResumidasMontosConstantesFunciones.LABEL_TOTALIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasResumidasMontosConstantesFunciones.LABEL_TOTALSINIVA);
			reporte.setsDescripcion(VentasResumidasMontosConstantesFunciones.LABEL_TOTALSINIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasResumidasMontosConstantesFunciones.LABEL_TOTALDESCUENTO);
			reporte.setsDescripcion(VentasResumidasMontosConstantesFunciones.LABEL_TOTALDESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasResumidasMontosConstantesFunciones.LABEL_TOTALOTRO);
			reporte.setsDescripcion(VentasResumidasMontosConstantesFunciones.LABEL_TOTALOTRO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasResumidasMontosConstantesFunciones.LABEL_SUBTOTAL);
			reporte.setsDescripcion(VentasResumidasMontosConstantesFunciones.LABEL_SUBTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasResumidasMontosConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(VentasResumidasMontosConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasResumidasMontosConstantesFunciones.LABEL_IVA);
			reporte.setsDescripcion(VentasResumidasMontosConstantesFunciones.LABEL_IVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasResumidasMontosConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(VentasResumidasMontosConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesVentasResumidasMontos(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesVentasResumidasMontos(VentasResumidasMontos ventasresumidasmontosAux) throws Exception {
		
			ventasresumidasmontosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(ventasresumidasmontosAux.getEmpresa()));
			ventasresumidasmontosAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(ventasresumidasmontosAux.getSucursal()));
			ventasresumidasmontosAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(ventasresumidasmontosAux.getVendedor()));		
	}
	
	public static void refrescarForeignKeysDescripcionesVentasResumidasMontos(List<VentasResumidasMontos> ventasresumidasmontossTemp) throws Exception {
		for(VentasResumidasMontos ventasresumidasmontosAux:ventasresumidasmontossTemp) {
			
			ventasresumidasmontosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(ventasresumidasmontosAux.getEmpresa()));
			ventasresumidasmontosAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(ventasresumidasmontosAux.getSucursal()));
			ventasresumidasmontosAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(ventasresumidasmontosAux.getVendedor()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfVentasResumidasMontos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Vendedor.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
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
					if(clas.clas.equals(Vendedor.class)) {
						classes.add(new Classe(Vendedor.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfVentasResumidasMontos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Vendedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vendedor.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Vendedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vendedor.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfVentasResumidasMontos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return VentasResumidasMontosConstantesFunciones.getClassesRelationshipsOfVentasResumidasMontos(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfVentasResumidasMontos(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfVentasResumidasMontos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return VentasResumidasMontosConstantesFunciones.getClassesRelationshipsFromStringsOfVentasResumidasMontos(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfVentasResumidasMontos(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(VentasResumidasMontos ventasresumidasmontos,List<VentasResumidasMontos> ventasresumidasmontoss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(VentasResumidasMontos ventasresumidasmontos,List<VentasResumidasMontos> ventasresumidasmontoss) throws Exception {
		try	{			
			for(VentasResumidasMontos ventasresumidasmontosLocal:ventasresumidasmontoss) {
				if(ventasresumidasmontosLocal.getId().equals(ventasresumidasmontos.getId())) {
					ventasresumidasmontosLocal.setIsSelected(ventasresumidasmontos.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesVentasResumidasMontos(List<VentasResumidasMontos> ventasresumidasmontossAux) throws Exception {
		//this.ventasresumidasmontossAux=ventasresumidasmontossAux;
		
		for(VentasResumidasMontos ventasresumidasmontosAux:ventasresumidasmontossAux) {
			if(ventasresumidasmontosAux.getIsChanged()) {
				ventasresumidasmontosAux.setIsChanged(false);
			}		
			
			if(ventasresumidasmontosAux.getIsNew()) {
				ventasresumidasmontosAux.setIsNew(false);
			}	
			
			if(ventasresumidasmontosAux.getIsDeleted()) {
				ventasresumidasmontosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesVentasResumidasMontos(VentasResumidasMontos ventasresumidasmontosAux) throws Exception {
		//this.ventasresumidasmontosAux=ventasresumidasmontosAux;
		
			if(ventasresumidasmontosAux.getIsChanged()) {
				ventasresumidasmontosAux.setIsChanged(false);
			}		
			
			if(ventasresumidasmontosAux.getIsNew()) {
				ventasresumidasmontosAux.setIsNew(false);
			}	
			
			if(ventasresumidasmontosAux.getIsDeleted()) {
				ventasresumidasmontosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(VentasResumidasMontos ventasresumidasmontosAsignar,VentasResumidasMontos ventasresumidasmontos) throws Exception {
		ventasresumidasmontosAsignar.setId(ventasresumidasmontos.getId());	
		ventasresumidasmontosAsignar.setVersionRow(ventasresumidasmontos.getVersionRow());	
		ventasresumidasmontosAsignar.setnombre_completo(ventasresumidasmontos.getnombre_completo());	
		ventasresumidasmontosAsignar.setnombre_vendedor(ventasresumidasmontos.getnombre_vendedor());	
		ventasresumidasmontosAsignar.setnombre_tipo_factura(ventasresumidasmontos.getnombre_tipo_factura());	
		ventasresumidasmontosAsignar.setfecha_emision(ventasresumidasmontos.getfecha_emision());	
		ventasresumidasmontosAsignar.setfecha_vencimiento(ventasresumidasmontos.getfecha_vencimiento());	
		ventasresumidasmontosAsignar.setnumero_pre_impreso(ventasresumidasmontos.getnumero_pre_impreso());	
		ventasresumidasmontosAsignar.settotal_iva(ventasresumidasmontos.gettotal_iva());	
		ventasresumidasmontosAsignar.settotal_sin_iva(ventasresumidasmontos.gettotal_sin_iva());	
		ventasresumidasmontosAsignar.settotal_descuento(ventasresumidasmontos.gettotal_descuento());	
		ventasresumidasmontosAsignar.settotal_otro(ventasresumidasmontos.gettotal_otro());	
		ventasresumidasmontosAsignar.setsub_total(ventasresumidasmontos.getsub_total());	
		ventasresumidasmontosAsignar.settotal(ventasresumidasmontos.gettotal());	
		ventasresumidasmontosAsignar.setiva(ventasresumidasmontos.getiva());	
		ventasresumidasmontosAsignar.setdescripcion(ventasresumidasmontos.getdescripcion());	
	}
	
	public static void inicializarVentasResumidasMontos(VentasResumidasMontos ventasresumidasmontos) throws Exception {
		try {
				ventasresumidasmontos.setId(0L);	
					
				ventasresumidasmontos.setnombre_completo("");	
				ventasresumidasmontos.setnombre_vendedor("");	
				ventasresumidasmontos.setnombre_tipo_factura("");	
				ventasresumidasmontos.setfecha_emision(new Date());	
				ventasresumidasmontos.setfecha_vencimiento(new Date());	
				ventasresumidasmontos.setnumero_pre_impreso("");	
				ventasresumidasmontos.settotal_iva(0.0);	
				ventasresumidasmontos.settotal_sin_iva(0.0);	
				ventasresumidasmontos.settotal_descuento(0.0);	
				ventasresumidasmontos.settotal_otro(0.0);	
				ventasresumidasmontos.setsub_total(0.0);	
				ventasresumidasmontos.settotal(0.0);	
				ventasresumidasmontos.setiva(0.0);	
				ventasresumidasmontos.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderVentasResumidasMontos(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasResumidasMontosConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasResumidasMontosConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasResumidasMontosConstantesFunciones.LABEL_IDVENDEDOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasResumidasMontosConstantesFunciones.LABEL_FECHAEMISIONDESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasResumidasMontosConstantesFunciones.LABEL_FECHAEMISIONHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasResumidasMontosConstantesFunciones.LABEL_NOMBRECOMPLETO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasResumidasMontosConstantesFunciones.LABEL_NOMBREVENDEDOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasResumidasMontosConstantesFunciones.LABEL_NOMBRETIPOFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasResumidasMontosConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasResumidasMontosConstantesFunciones.LABEL_FECHAVENCIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasResumidasMontosConstantesFunciones.LABEL_NUMEROPREIMPRESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasResumidasMontosConstantesFunciones.LABEL_TOTALIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasResumidasMontosConstantesFunciones.LABEL_TOTALSINIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasResumidasMontosConstantesFunciones.LABEL_TOTALDESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasResumidasMontosConstantesFunciones.LABEL_TOTALOTRO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasResumidasMontosConstantesFunciones.LABEL_SUBTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasResumidasMontosConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasResumidasMontosConstantesFunciones.LABEL_IVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasResumidasMontosConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataVentasResumidasMontos(String sTipo,Row row,Workbook workbook,VentasResumidasMontos ventasresumidasmontos,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(ventasresumidasmontos.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventasresumidasmontos.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventasresumidasmontos.getvendedor_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventasresumidasmontos.getfecha_emision_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventasresumidasmontos.getfecha_emision_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventasresumidasmontos.getnombre_completo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventasresumidasmontos.getnombre_vendedor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventasresumidasmontos.getnombre_tipo_factura());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventasresumidasmontos.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventasresumidasmontos.getfecha_vencimiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventasresumidasmontos.getnumero_pre_impreso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventasresumidasmontos.gettotal_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventasresumidasmontos.gettotal_sin_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventasresumidasmontos.gettotal_descuento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventasresumidasmontos.gettotal_otro());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventasresumidasmontos.getsub_total());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventasresumidasmontos.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventasresumidasmontos.getiva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventasresumidasmontos.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryVentasResumidasMontos="";
	
	public String getsFinalQueryVentasResumidasMontos() {
		return this.sFinalQueryVentasResumidasMontos;
	}
	
	public void setsFinalQueryVentasResumidasMontos(String sFinalQueryVentasResumidasMontos) {
		this.sFinalQueryVentasResumidasMontos= sFinalQueryVentasResumidasMontos;
	}
	
	public Border resaltarSeleccionarVentasResumidasMontos=null;
	
	public Border setResaltarSeleccionarVentasResumidasMontos(ParametroGeneralUsuario parametroGeneralUsuario/*VentasResumidasMontosBeanSwingJInternalFrame ventasresumidasmontosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//ventasresumidasmontosBeanSwingJInternalFrame.jTtoolBarVentasResumidasMontos.setBorder(borderResaltar);
		
		this.resaltarSeleccionarVentasResumidasMontos= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarVentasResumidasMontos() {
		return this.resaltarSeleccionarVentasResumidasMontos;
	}
	
	public void setResaltarSeleccionarVentasResumidasMontos(Border borderResaltarSeleccionarVentasResumidasMontos) {
		this.resaltarSeleccionarVentasResumidasMontos= borderResaltarSeleccionarVentasResumidasMontos;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridVentasResumidasMontos=null;
	public Boolean mostraridVentasResumidasMontos=true;
	public Boolean activaridVentasResumidasMontos=true;

	public Border resaltarid_empresaVentasResumidasMontos=null;
	public Boolean mostrarid_empresaVentasResumidasMontos=true;
	public Boolean activarid_empresaVentasResumidasMontos=true;
	public Boolean cargarid_empresaVentasResumidasMontos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaVentasResumidasMontos=false;//ConEventDepend=true

	public Border resaltarid_sucursalVentasResumidasMontos=null;
	public Boolean mostrarid_sucursalVentasResumidasMontos=true;
	public Boolean activarid_sucursalVentasResumidasMontos=true;
	public Boolean cargarid_sucursalVentasResumidasMontos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalVentasResumidasMontos=false;//ConEventDepend=true

	public Border resaltarid_vendedorVentasResumidasMontos=null;
	public Boolean mostrarid_vendedorVentasResumidasMontos=true;
	public Boolean activarid_vendedorVentasResumidasMontos=true;
	public Boolean cargarid_vendedorVentasResumidasMontos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_vendedorVentasResumidasMontos=false;//ConEventDepend=true

	public Border resaltarfecha_emision_desdeVentasResumidasMontos=null;
	public Boolean mostrarfecha_emision_desdeVentasResumidasMontos=true;
	public Boolean activarfecha_emision_desdeVentasResumidasMontos=true;

	public Border resaltarfecha_emision_hastaVentasResumidasMontos=null;
	public Boolean mostrarfecha_emision_hastaVentasResumidasMontos=true;
	public Boolean activarfecha_emision_hastaVentasResumidasMontos=true;

	public Border resaltarnombre_completoVentasResumidasMontos=null;
	public Boolean mostrarnombre_completoVentasResumidasMontos=true;
	public Boolean activarnombre_completoVentasResumidasMontos=true;

	public Border resaltarnombre_vendedorVentasResumidasMontos=null;
	public Boolean mostrarnombre_vendedorVentasResumidasMontos=true;
	public Boolean activarnombre_vendedorVentasResumidasMontos=true;

	public Border resaltarnombre_tipo_facturaVentasResumidasMontos=null;
	public Boolean mostrarnombre_tipo_facturaVentasResumidasMontos=true;
	public Boolean activarnombre_tipo_facturaVentasResumidasMontos=true;

	public Border resaltarfecha_emisionVentasResumidasMontos=null;
	public Boolean mostrarfecha_emisionVentasResumidasMontos=true;
	public Boolean activarfecha_emisionVentasResumidasMontos=true;

	public Border resaltarfecha_vencimientoVentasResumidasMontos=null;
	public Boolean mostrarfecha_vencimientoVentasResumidasMontos=true;
	public Boolean activarfecha_vencimientoVentasResumidasMontos=true;

	public Border resaltarnumero_pre_impresoVentasResumidasMontos=null;
	public Boolean mostrarnumero_pre_impresoVentasResumidasMontos=true;
	public Boolean activarnumero_pre_impresoVentasResumidasMontos=true;

	public Border resaltartotal_ivaVentasResumidasMontos=null;
	public Boolean mostrartotal_ivaVentasResumidasMontos=true;
	public Boolean activartotal_ivaVentasResumidasMontos=true;

	public Border resaltartotal_sin_ivaVentasResumidasMontos=null;
	public Boolean mostrartotal_sin_ivaVentasResumidasMontos=true;
	public Boolean activartotal_sin_ivaVentasResumidasMontos=true;

	public Border resaltartotal_descuentoVentasResumidasMontos=null;
	public Boolean mostrartotal_descuentoVentasResumidasMontos=true;
	public Boolean activartotal_descuentoVentasResumidasMontos=true;

	public Border resaltartotal_otroVentasResumidasMontos=null;
	public Boolean mostrartotal_otroVentasResumidasMontos=true;
	public Boolean activartotal_otroVentasResumidasMontos=true;

	public Border resaltarsub_totalVentasResumidasMontos=null;
	public Boolean mostrarsub_totalVentasResumidasMontos=true;
	public Boolean activarsub_totalVentasResumidasMontos=true;

	public Border resaltartotalVentasResumidasMontos=null;
	public Boolean mostrartotalVentasResumidasMontos=true;
	public Boolean activartotalVentasResumidasMontos=true;

	public Border resaltarivaVentasResumidasMontos=null;
	public Boolean mostrarivaVentasResumidasMontos=true;
	public Boolean activarivaVentasResumidasMontos=true;

	public Border resaltardescripcionVentasResumidasMontos=null;
	public Boolean mostrardescripcionVentasResumidasMontos=true;
	public Boolean activardescripcionVentasResumidasMontos=true;

	
	

	public Border setResaltaridVentasResumidasMontos(ParametroGeneralUsuario parametroGeneralUsuario/*VentasResumidasMontosBeanSwingJInternalFrame ventasresumidasmontosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasresumidasmontosBeanSwingJInternalFrame.jTtoolBarVentasResumidasMontos.setBorder(borderResaltar);
		
		this.resaltaridVentasResumidasMontos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridVentasResumidasMontos() {
		return this.resaltaridVentasResumidasMontos;
	}

	public void setResaltaridVentasResumidasMontos(Border borderResaltar) {
		this.resaltaridVentasResumidasMontos= borderResaltar;
	}

	public Boolean getMostraridVentasResumidasMontos() {
		return this.mostraridVentasResumidasMontos;
	}

	public void setMostraridVentasResumidasMontos(Boolean mostraridVentasResumidasMontos) {
		this.mostraridVentasResumidasMontos= mostraridVentasResumidasMontos;
	}

	public Boolean getActivaridVentasResumidasMontos() {
		return this.activaridVentasResumidasMontos;
	}

	public void setActivaridVentasResumidasMontos(Boolean activaridVentasResumidasMontos) {
		this.activaridVentasResumidasMontos= activaridVentasResumidasMontos;
	}

	public Border setResaltarid_empresaVentasResumidasMontos(ParametroGeneralUsuario parametroGeneralUsuario/*VentasResumidasMontosBeanSwingJInternalFrame ventasresumidasmontosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasresumidasmontosBeanSwingJInternalFrame.jTtoolBarVentasResumidasMontos.setBorder(borderResaltar);
		
		this.resaltarid_empresaVentasResumidasMontos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaVentasResumidasMontos() {
		return this.resaltarid_empresaVentasResumidasMontos;
	}

	public void setResaltarid_empresaVentasResumidasMontos(Border borderResaltar) {
		this.resaltarid_empresaVentasResumidasMontos= borderResaltar;
	}

	public Boolean getMostrarid_empresaVentasResumidasMontos() {
		return this.mostrarid_empresaVentasResumidasMontos;
	}

	public void setMostrarid_empresaVentasResumidasMontos(Boolean mostrarid_empresaVentasResumidasMontos) {
		this.mostrarid_empresaVentasResumidasMontos= mostrarid_empresaVentasResumidasMontos;
	}

	public Boolean getActivarid_empresaVentasResumidasMontos() {
		return this.activarid_empresaVentasResumidasMontos;
	}

	public void setActivarid_empresaVentasResumidasMontos(Boolean activarid_empresaVentasResumidasMontos) {
		this.activarid_empresaVentasResumidasMontos= activarid_empresaVentasResumidasMontos;
	}

	public Boolean getCargarid_empresaVentasResumidasMontos() {
		return this.cargarid_empresaVentasResumidasMontos;
	}

	public void setCargarid_empresaVentasResumidasMontos(Boolean cargarid_empresaVentasResumidasMontos) {
		this.cargarid_empresaVentasResumidasMontos= cargarid_empresaVentasResumidasMontos;
	}

	public Border setResaltarid_sucursalVentasResumidasMontos(ParametroGeneralUsuario parametroGeneralUsuario/*VentasResumidasMontosBeanSwingJInternalFrame ventasresumidasmontosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasresumidasmontosBeanSwingJInternalFrame.jTtoolBarVentasResumidasMontos.setBorder(borderResaltar);
		
		this.resaltarid_sucursalVentasResumidasMontos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalVentasResumidasMontos() {
		return this.resaltarid_sucursalVentasResumidasMontos;
	}

	public void setResaltarid_sucursalVentasResumidasMontos(Border borderResaltar) {
		this.resaltarid_sucursalVentasResumidasMontos= borderResaltar;
	}

	public Boolean getMostrarid_sucursalVentasResumidasMontos() {
		return this.mostrarid_sucursalVentasResumidasMontos;
	}

	public void setMostrarid_sucursalVentasResumidasMontos(Boolean mostrarid_sucursalVentasResumidasMontos) {
		this.mostrarid_sucursalVentasResumidasMontos= mostrarid_sucursalVentasResumidasMontos;
	}

	public Boolean getActivarid_sucursalVentasResumidasMontos() {
		return this.activarid_sucursalVentasResumidasMontos;
	}

	public void setActivarid_sucursalVentasResumidasMontos(Boolean activarid_sucursalVentasResumidasMontos) {
		this.activarid_sucursalVentasResumidasMontos= activarid_sucursalVentasResumidasMontos;
	}

	public Boolean getCargarid_sucursalVentasResumidasMontos() {
		return this.cargarid_sucursalVentasResumidasMontos;
	}

	public void setCargarid_sucursalVentasResumidasMontos(Boolean cargarid_sucursalVentasResumidasMontos) {
		this.cargarid_sucursalVentasResumidasMontos= cargarid_sucursalVentasResumidasMontos;
	}

	public Border setResaltarid_vendedorVentasResumidasMontos(ParametroGeneralUsuario parametroGeneralUsuario/*VentasResumidasMontosBeanSwingJInternalFrame ventasresumidasmontosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasresumidasmontosBeanSwingJInternalFrame.jTtoolBarVentasResumidasMontos.setBorder(borderResaltar);
		
		this.resaltarid_vendedorVentasResumidasMontos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_vendedorVentasResumidasMontos() {
		return this.resaltarid_vendedorVentasResumidasMontos;
	}

	public void setResaltarid_vendedorVentasResumidasMontos(Border borderResaltar) {
		this.resaltarid_vendedorVentasResumidasMontos= borderResaltar;
	}

	public Boolean getMostrarid_vendedorVentasResumidasMontos() {
		return this.mostrarid_vendedorVentasResumidasMontos;
	}

	public void setMostrarid_vendedorVentasResumidasMontos(Boolean mostrarid_vendedorVentasResumidasMontos) {
		this.mostrarid_vendedorVentasResumidasMontos= mostrarid_vendedorVentasResumidasMontos;
	}

	public Boolean getActivarid_vendedorVentasResumidasMontos() {
		return this.activarid_vendedorVentasResumidasMontos;
	}

	public void setActivarid_vendedorVentasResumidasMontos(Boolean activarid_vendedorVentasResumidasMontos) {
		this.activarid_vendedorVentasResumidasMontos= activarid_vendedorVentasResumidasMontos;
	}

	public Boolean getCargarid_vendedorVentasResumidasMontos() {
		return this.cargarid_vendedorVentasResumidasMontos;
	}

	public void setCargarid_vendedorVentasResumidasMontos(Boolean cargarid_vendedorVentasResumidasMontos) {
		this.cargarid_vendedorVentasResumidasMontos= cargarid_vendedorVentasResumidasMontos;
	}

	public Border setResaltarfecha_emision_desdeVentasResumidasMontos(ParametroGeneralUsuario parametroGeneralUsuario/*VentasResumidasMontosBeanSwingJInternalFrame ventasresumidasmontosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasresumidasmontosBeanSwingJInternalFrame.jTtoolBarVentasResumidasMontos.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_desdeVentasResumidasMontos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_desdeVentasResumidasMontos() {
		return this.resaltarfecha_emision_desdeVentasResumidasMontos;
	}

	public void setResaltarfecha_emision_desdeVentasResumidasMontos(Border borderResaltar) {
		this.resaltarfecha_emision_desdeVentasResumidasMontos= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_desdeVentasResumidasMontos() {
		return this.mostrarfecha_emision_desdeVentasResumidasMontos;
	}

	public void setMostrarfecha_emision_desdeVentasResumidasMontos(Boolean mostrarfecha_emision_desdeVentasResumidasMontos) {
		this.mostrarfecha_emision_desdeVentasResumidasMontos= mostrarfecha_emision_desdeVentasResumidasMontos;
	}

	public Boolean getActivarfecha_emision_desdeVentasResumidasMontos() {
		return this.activarfecha_emision_desdeVentasResumidasMontos;
	}

	public void setActivarfecha_emision_desdeVentasResumidasMontos(Boolean activarfecha_emision_desdeVentasResumidasMontos) {
		this.activarfecha_emision_desdeVentasResumidasMontos= activarfecha_emision_desdeVentasResumidasMontos;
	}

	public Border setResaltarfecha_emision_hastaVentasResumidasMontos(ParametroGeneralUsuario parametroGeneralUsuario/*VentasResumidasMontosBeanSwingJInternalFrame ventasresumidasmontosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasresumidasmontosBeanSwingJInternalFrame.jTtoolBarVentasResumidasMontos.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_hastaVentasResumidasMontos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_hastaVentasResumidasMontos() {
		return this.resaltarfecha_emision_hastaVentasResumidasMontos;
	}

	public void setResaltarfecha_emision_hastaVentasResumidasMontos(Border borderResaltar) {
		this.resaltarfecha_emision_hastaVentasResumidasMontos= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_hastaVentasResumidasMontos() {
		return this.mostrarfecha_emision_hastaVentasResumidasMontos;
	}

	public void setMostrarfecha_emision_hastaVentasResumidasMontos(Boolean mostrarfecha_emision_hastaVentasResumidasMontos) {
		this.mostrarfecha_emision_hastaVentasResumidasMontos= mostrarfecha_emision_hastaVentasResumidasMontos;
	}

	public Boolean getActivarfecha_emision_hastaVentasResumidasMontos() {
		return this.activarfecha_emision_hastaVentasResumidasMontos;
	}

	public void setActivarfecha_emision_hastaVentasResumidasMontos(Boolean activarfecha_emision_hastaVentasResumidasMontos) {
		this.activarfecha_emision_hastaVentasResumidasMontos= activarfecha_emision_hastaVentasResumidasMontos;
	}

	public Border setResaltarnombre_completoVentasResumidasMontos(ParametroGeneralUsuario parametroGeneralUsuario/*VentasResumidasMontosBeanSwingJInternalFrame ventasresumidasmontosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasresumidasmontosBeanSwingJInternalFrame.jTtoolBarVentasResumidasMontos.setBorder(borderResaltar);
		
		this.resaltarnombre_completoVentasResumidasMontos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_completoVentasResumidasMontos() {
		return this.resaltarnombre_completoVentasResumidasMontos;
	}

	public void setResaltarnombre_completoVentasResumidasMontos(Border borderResaltar) {
		this.resaltarnombre_completoVentasResumidasMontos= borderResaltar;
	}

	public Boolean getMostrarnombre_completoVentasResumidasMontos() {
		return this.mostrarnombre_completoVentasResumidasMontos;
	}

	public void setMostrarnombre_completoVentasResumidasMontos(Boolean mostrarnombre_completoVentasResumidasMontos) {
		this.mostrarnombre_completoVentasResumidasMontos= mostrarnombre_completoVentasResumidasMontos;
	}

	public Boolean getActivarnombre_completoVentasResumidasMontos() {
		return this.activarnombre_completoVentasResumidasMontos;
	}

	public void setActivarnombre_completoVentasResumidasMontos(Boolean activarnombre_completoVentasResumidasMontos) {
		this.activarnombre_completoVentasResumidasMontos= activarnombre_completoVentasResumidasMontos;
	}

	public Border setResaltarnombre_vendedorVentasResumidasMontos(ParametroGeneralUsuario parametroGeneralUsuario/*VentasResumidasMontosBeanSwingJInternalFrame ventasresumidasmontosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasresumidasmontosBeanSwingJInternalFrame.jTtoolBarVentasResumidasMontos.setBorder(borderResaltar);
		
		this.resaltarnombre_vendedorVentasResumidasMontos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_vendedorVentasResumidasMontos() {
		return this.resaltarnombre_vendedorVentasResumidasMontos;
	}

	public void setResaltarnombre_vendedorVentasResumidasMontos(Border borderResaltar) {
		this.resaltarnombre_vendedorVentasResumidasMontos= borderResaltar;
	}

	public Boolean getMostrarnombre_vendedorVentasResumidasMontos() {
		return this.mostrarnombre_vendedorVentasResumidasMontos;
	}

	public void setMostrarnombre_vendedorVentasResumidasMontos(Boolean mostrarnombre_vendedorVentasResumidasMontos) {
		this.mostrarnombre_vendedorVentasResumidasMontos= mostrarnombre_vendedorVentasResumidasMontos;
	}

	public Boolean getActivarnombre_vendedorVentasResumidasMontos() {
		return this.activarnombre_vendedorVentasResumidasMontos;
	}

	public void setActivarnombre_vendedorVentasResumidasMontos(Boolean activarnombre_vendedorVentasResumidasMontos) {
		this.activarnombre_vendedorVentasResumidasMontos= activarnombre_vendedorVentasResumidasMontos;
	}

	public Border setResaltarnombre_tipo_facturaVentasResumidasMontos(ParametroGeneralUsuario parametroGeneralUsuario/*VentasResumidasMontosBeanSwingJInternalFrame ventasresumidasmontosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasresumidasmontosBeanSwingJInternalFrame.jTtoolBarVentasResumidasMontos.setBorder(borderResaltar);
		
		this.resaltarnombre_tipo_facturaVentasResumidasMontos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_tipo_facturaVentasResumidasMontos() {
		return this.resaltarnombre_tipo_facturaVentasResumidasMontos;
	}

	public void setResaltarnombre_tipo_facturaVentasResumidasMontos(Border borderResaltar) {
		this.resaltarnombre_tipo_facturaVentasResumidasMontos= borderResaltar;
	}

	public Boolean getMostrarnombre_tipo_facturaVentasResumidasMontos() {
		return this.mostrarnombre_tipo_facturaVentasResumidasMontos;
	}

	public void setMostrarnombre_tipo_facturaVentasResumidasMontos(Boolean mostrarnombre_tipo_facturaVentasResumidasMontos) {
		this.mostrarnombre_tipo_facturaVentasResumidasMontos= mostrarnombre_tipo_facturaVentasResumidasMontos;
	}

	public Boolean getActivarnombre_tipo_facturaVentasResumidasMontos() {
		return this.activarnombre_tipo_facturaVentasResumidasMontos;
	}

	public void setActivarnombre_tipo_facturaVentasResumidasMontos(Boolean activarnombre_tipo_facturaVentasResumidasMontos) {
		this.activarnombre_tipo_facturaVentasResumidasMontos= activarnombre_tipo_facturaVentasResumidasMontos;
	}

	public Border setResaltarfecha_emisionVentasResumidasMontos(ParametroGeneralUsuario parametroGeneralUsuario/*VentasResumidasMontosBeanSwingJInternalFrame ventasresumidasmontosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasresumidasmontosBeanSwingJInternalFrame.jTtoolBarVentasResumidasMontos.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionVentasResumidasMontos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionVentasResumidasMontos() {
		return this.resaltarfecha_emisionVentasResumidasMontos;
	}

	public void setResaltarfecha_emisionVentasResumidasMontos(Border borderResaltar) {
		this.resaltarfecha_emisionVentasResumidasMontos= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionVentasResumidasMontos() {
		return this.mostrarfecha_emisionVentasResumidasMontos;
	}

	public void setMostrarfecha_emisionVentasResumidasMontos(Boolean mostrarfecha_emisionVentasResumidasMontos) {
		this.mostrarfecha_emisionVentasResumidasMontos= mostrarfecha_emisionVentasResumidasMontos;
	}

	public Boolean getActivarfecha_emisionVentasResumidasMontos() {
		return this.activarfecha_emisionVentasResumidasMontos;
	}

	public void setActivarfecha_emisionVentasResumidasMontos(Boolean activarfecha_emisionVentasResumidasMontos) {
		this.activarfecha_emisionVentasResumidasMontos= activarfecha_emisionVentasResumidasMontos;
	}

	public Border setResaltarfecha_vencimientoVentasResumidasMontos(ParametroGeneralUsuario parametroGeneralUsuario/*VentasResumidasMontosBeanSwingJInternalFrame ventasresumidasmontosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasresumidasmontosBeanSwingJInternalFrame.jTtoolBarVentasResumidasMontos.setBorder(borderResaltar);
		
		this.resaltarfecha_vencimientoVentasResumidasMontos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_vencimientoVentasResumidasMontos() {
		return this.resaltarfecha_vencimientoVentasResumidasMontos;
	}

	public void setResaltarfecha_vencimientoVentasResumidasMontos(Border borderResaltar) {
		this.resaltarfecha_vencimientoVentasResumidasMontos= borderResaltar;
	}

	public Boolean getMostrarfecha_vencimientoVentasResumidasMontos() {
		return this.mostrarfecha_vencimientoVentasResumidasMontos;
	}

	public void setMostrarfecha_vencimientoVentasResumidasMontos(Boolean mostrarfecha_vencimientoVentasResumidasMontos) {
		this.mostrarfecha_vencimientoVentasResumidasMontos= mostrarfecha_vencimientoVentasResumidasMontos;
	}

	public Boolean getActivarfecha_vencimientoVentasResumidasMontos() {
		return this.activarfecha_vencimientoVentasResumidasMontos;
	}

	public void setActivarfecha_vencimientoVentasResumidasMontos(Boolean activarfecha_vencimientoVentasResumidasMontos) {
		this.activarfecha_vencimientoVentasResumidasMontos= activarfecha_vencimientoVentasResumidasMontos;
	}

	public Border setResaltarnumero_pre_impresoVentasResumidasMontos(ParametroGeneralUsuario parametroGeneralUsuario/*VentasResumidasMontosBeanSwingJInternalFrame ventasresumidasmontosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasresumidasmontosBeanSwingJInternalFrame.jTtoolBarVentasResumidasMontos.setBorder(borderResaltar);
		
		this.resaltarnumero_pre_impresoVentasResumidasMontos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_pre_impresoVentasResumidasMontos() {
		return this.resaltarnumero_pre_impresoVentasResumidasMontos;
	}

	public void setResaltarnumero_pre_impresoVentasResumidasMontos(Border borderResaltar) {
		this.resaltarnumero_pre_impresoVentasResumidasMontos= borderResaltar;
	}

	public Boolean getMostrarnumero_pre_impresoVentasResumidasMontos() {
		return this.mostrarnumero_pre_impresoVentasResumidasMontos;
	}

	public void setMostrarnumero_pre_impresoVentasResumidasMontos(Boolean mostrarnumero_pre_impresoVentasResumidasMontos) {
		this.mostrarnumero_pre_impresoVentasResumidasMontos= mostrarnumero_pre_impresoVentasResumidasMontos;
	}

	public Boolean getActivarnumero_pre_impresoVentasResumidasMontos() {
		return this.activarnumero_pre_impresoVentasResumidasMontos;
	}

	public void setActivarnumero_pre_impresoVentasResumidasMontos(Boolean activarnumero_pre_impresoVentasResumidasMontos) {
		this.activarnumero_pre_impresoVentasResumidasMontos= activarnumero_pre_impresoVentasResumidasMontos;
	}

	public Border setResaltartotal_ivaVentasResumidasMontos(ParametroGeneralUsuario parametroGeneralUsuario/*VentasResumidasMontosBeanSwingJInternalFrame ventasresumidasmontosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasresumidasmontosBeanSwingJInternalFrame.jTtoolBarVentasResumidasMontos.setBorder(borderResaltar);
		
		this.resaltartotal_ivaVentasResumidasMontos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_ivaVentasResumidasMontos() {
		return this.resaltartotal_ivaVentasResumidasMontos;
	}

	public void setResaltartotal_ivaVentasResumidasMontos(Border borderResaltar) {
		this.resaltartotal_ivaVentasResumidasMontos= borderResaltar;
	}

	public Boolean getMostrartotal_ivaVentasResumidasMontos() {
		return this.mostrartotal_ivaVentasResumidasMontos;
	}

	public void setMostrartotal_ivaVentasResumidasMontos(Boolean mostrartotal_ivaVentasResumidasMontos) {
		this.mostrartotal_ivaVentasResumidasMontos= mostrartotal_ivaVentasResumidasMontos;
	}

	public Boolean getActivartotal_ivaVentasResumidasMontos() {
		return this.activartotal_ivaVentasResumidasMontos;
	}

	public void setActivartotal_ivaVentasResumidasMontos(Boolean activartotal_ivaVentasResumidasMontos) {
		this.activartotal_ivaVentasResumidasMontos= activartotal_ivaVentasResumidasMontos;
	}

	public Border setResaltartotal_sin_ivaVentasResumidasMontos(ParametroGeneralUsuario parametroGeneralUsuario/*VentasResumidasMontosBeanSwingJInternalFrame ventasresumidasmontosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasresumidasmontosBeanSwingJInternalFrame.jTtoolBarVentasResumidasMontos.setBorder(borderResaltar);
		
		this.resaltartotal_sin_ivaVentasResumidasMontos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_sin_ivaVentasResumidasMontos() {
		return this.resaltartotal_sin_ivaVentasResumidasMontos;
	}

	public void setResaltartotal_sin_ivaVentasResumidasMontos(Border borderResaltar) {
		this.resaltartotal_sin_ivaVentasResumidasMontos= borderResaltar;
	}

	public Boolean getMostrartotal_sin_ivaVentasResumidasMontos() {
		return this.mostrartotal_sin_ivaVentasResumidasMontos;
	}

	public void setMostrartotal_sin_ivaVentasResumidasMontos(Boolean mostrartotal_sin_ivaVentasResumidasMontos) {
		this.mostrartotal_sin_ivaVentasResumidasMontos= mostrartotal_sin_ivaVentasResumidasMontos;
	}

	public Boolean getActivartotal_sin_ivaVentasResumidasMontos() {
		return this.activartotal_sin_ivaVentasResumidasMontos;
	}

	public void setActivartotal_sin_ivaVentasResumidasMontos(Boolean activartotal_sin_ivaVentasResumidasMontos) {
		this.activartotal_sin_ivaVentasResumidasMontos= activartotal_sin_ivaVentasResumidasMontos;
	}

	public Border setResaltartotal_descuentoVentasResumidasMontos(ParametroGeneralUsuario parametroGeneralUsuario/*VentasResumidasMontosBeanSwingJInternalFrame ventasresumidasmontosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasresumidasmontosBeanSwingJInternalFrame.jTtoolBarVentasResumidasMontos.setBorder(borderResaltar);
		
		this.resaltartotal_descuentoVentasResumidasMontos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_descuentoVentasResumidasMontos() {
		return this.resaltartotal_descuentoVentasResumidasMontos;
	}

	public void setResaltartotal_descuentoVentasResumidasMontos(Border borderResaltar) {
		this.resaltartotal_descuentoVentasResumidasMontos= borderResaltar;
	}

	public Boolean getMostrartotal_descuentoVentasResumidasMontos() {
		return this.mostrartotal_descuentoVentasResumidasMontos;
	}

	public void setMostrartotal_descuentoVentasResumidasMontos(Boolean mostrartotal_descuentoVentasResumidasMontos) {
		this.mostrartotal_descuentoVentasResumidasMontos= mostrartotal_descuentoVentasResumidasMontos;
	}

	public Boolean getActivartotal_descuentoVentasResumidasMontos() {
		return this.activartotal_descuentoVentasResumidasMontos;
	}

	public void setActivartotal_descuentoVentasResumidasMontos(Boolean activartotal_descuentoVentasResumidasMontos) {
		this.activartotal_descuentoVentasResumidasMontos= activartotal_descuentoVentasResumidasMontos;
	}

	public Border setResaltartotal_otroVentasResumidasMontos(ParametroGeneralUsuario parametroGeneralUsuario/*VentasResumidasMontosBeanSwingJInternalFrame ventasresumidasmontosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasresumidasmontosBeanSwingJInternalFrame.jTtoolBarVentasResumidasMontos.setBorder(borderResaltar);
		
		this.resaltartotal_otroVentasResumidasMontos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_otroVentasResumidasMontos() {
		return this.resaltartotal_otroVentasResumidasMontos;
	}

	public void setResaltartotal_otroVentasResumidasMontos(Border borderResaltar) {
		this.resaltartotal_otroVentasResumidasMontos= borderResaltar;
	}

	public Boolean getMostrartotal_otroVentasResumidasMontos() {
		return this.mostrartotal_otroVentasResumidasMontos;
	}

	public void setMostrartotal_otroVentasResumidasMontos(Boolean mostrartotal_otroVentasResumidasMontos) {
		this.mostrartotal_otroVentasResumidasMontos= mostrartotal_otroVentasResumidasMontos;
	}

	public Boolean getActivartotal_otroVentasResumidasMontos() {
		return this.activartotal_otroVentasResumidasMontos;
	}

	public void setActivartotal_otroVentasResumidasMontos(Boolean activartotal_otroVentasResumidasMontos) {
		this.activartotal_otroVentasResumidasMontos= activartotal_otroVentasResumidasMontos;
	}

	public Border setResaltarsub_totalVentasResumidasMontos(ParametroGeneralUsuario parametroGeneralUsuario/*VentasResumidasMontosBeanSwingJInternalFrame ventasresumidasmontosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasresumidasmontosBeanSwingJInternalFrame.jTtoolBarVentasResumidasMontos.setBorder(borderResaltar);
		
		this.resaltarsub_totalVentasResumidasMontos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsub_totalVentasResumidasMontos() {
		return this.resaltarsub_totalVentasResumidasMontos;
	}

	public void setResaltarsub_totalVentasResumidasMontos(Border borderResaltar) {
		this.resaltarsub_totalVentasResumidasMontos= borderResaltar;
	}

	public Boolean getMostrarsub_totalVentasResumidasMontos() {
		return this.mostrarsub_totalVentasResumidasMontos;
	}

	public void setMostrarsub_totalVentasResumidasMontos(Boolean mostrarsub_totalVentasResumidasMontos) {
		this.mostrarsub_totalVentasResumidasMontos= mostrarsub_totalVentasResumidasMontos;
	}

	public Boolean getActivarsub_totalVentasResumidasMontos() {
		return this.activarsub_totalVentasResumidasMontos;
	}

	public void setActivarsub_totalVentasResumidasMontos(Boolean activarsub_totalVentasResumidasMontos) {
		this.activarsub_totalVentasResumidasMontos= activarsub_totalVentasResumidasMontos;
	}

	public Border setResaltartotalVentasResumidasMontos(ParametroGeneralUsuario parametroGeneralUsuario/*VentasResumidasMontosBeanSwingJInternalFrame ventasresumidasmontosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasresumidasmontosBeanSwingJInternalFrame.jTtoolBarVentasResumidasMontos.setBorder(borderResaltar);
		
		this.resaltartotalVentasResumidasMontos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalVentasResumidasMontos() {
		return this.resaltartotalVentasResumidasMontos;
	}

	public void setResaltartotalVentasResumidasMontos(Border borderResaltar) {
		this.resaltartotalVentasResumidasMontos= borderResaltar;
	}

	public Boolean getMostrartotalVentasResumidasMontos() {
		return this.mostrartotalVentasResumidasMontos;
	}

	public void setMostrartotalVentasResumidasMontos(Boolean mostrartotalVentasResumidasMontos) {
		this.mostrartotalVentasResumidasMontos= mostrartotalVentasResumidasMontos;
	}

	public Boolean getActivartotalVentasResumidasMontos() {
		return this.activartotalVentasResumidasMontos;
	}

	public void setActivartotalVentasResumidasMontos(Boolean activartotalVentasResumidasMontos) {
		this.activartotalVentasResumidasMontos= activartotalVentasResumidasMontos;
	}

	public Border setResaltarivaVentasResumidasMontos(ParametroGeneralUsuario parametroGeneralUsuario/*VentasResumidasMontosBeanSwingJInternalFrame ventasresumidasmontosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasresumidasmontosBeanSwingJInternalFrame.jTtoolBarVentasResumidasMontos.setBorder(borderResaltar);
		
		this.resaltarivaVentasResumidasMontos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarivaVentasResumidasMontos() {
		return this.resaltarivaVentasResumidasMontos;
	}

	public void setResaltarivaVentasResumidasMontos(Border borderResaltar) {
		this.resaltarivaVentasResumidasMontos= borderResaltar;
	}

	public Boolean getMostrarivaVentasResumidasMontos() {
		return this.mostrarivaVentasResumidasMontos;
	}

	public void setMostrarivaVentasResumidasMontos(Boolean mostrarivaVentasResumidasMontos) {
		this.mostrarivaVentasResumidasMontos= mostrarivaVentasResumidasMontos;
	}

	public Boolean getActivarivaVentasResumidasMontos() {
		return this.activarivaVentasResumidasMontos;
	}

	public void setActivarivaVentasResumidasMontos(Boolean activarivaVentasResumidasMontos) {
		this.activarivaVentasResumidasMontos= activarivaVentasResumidasMontos;
	}

	public Border setResaltardescripcionVentasResumidasMontos(ParametroGeneralUsuario parametroGeneralUsuario/*VentasResumidasMontosBeanSwingJInternalFrame ventasresumidasmontosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasresumidasmontosBeanSwingJInternalFrame.jTtoolBarVentasResumidasMontos.setBorder(borderResaltar);
		
		this.resaltardescripcionVentasResumidasMontos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionVentasResumidasMontos() {
		return this.resaltardescripcionVentasResumidasMontos;
	}

	public void setResaltardescripcionVentasResumidasMontos(Border borderResaltar) {
		this.resaltardescripcionVentasResumidasMontos= borderResaltar;
	}

	public Boolean getMostrardescripcionVentasResumidasMontos() {
		return this.mostrardescripcionVentasResumidasMontos;
	}

	public void setMostrardescripcionVentasResumidasMontos(Boolean mostrardescripcionVentasResumidasMontos) {
		this.mostrardescripcionVentasResumidasMontos= mostrardescripcionVentasResumidasMontos;
	}

	public Boolean getActivardescripcionVentasResumidasMontos() {
		return this.activardescripcionVentasResumidasMontos;
	}

	public void setActivardescripcionVentasResumidasMontos(Boolean activardescripcionVentasResumidasMontos) {
		this.activardescripcionVentasResumidasMontos= activardescripcionVentasResumidasMontos;
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
		
		
		this.setMostraridVentasResumidasMontos(esInicial);
		this.setMostrarid_empresaVentasResumidasMontos(esInicial);
		this.setMostrarid_sucursalVentasResumidasMontos(esInicial);
		this.setMostrarid_vendedorVentasResumidasMontos(esInicial);
		this.setMostrarfecha_emision_desdeVentasResumidasMontos(esInicial);
		this.setMostrarfecha_emision_hastaVentasResumidasMontos(esInicial);
		this.setMostrarnombre_completoVentasResumidasMontos(esInicial);
		this.setMostrarnombre_vendedorVentasResumidasMontos(esInicial);
		this.setMostrarnombre_tipo_facturaVentasResumidasMontos(esInicial);
		this.setMostrarfecha_emisionVentasResumidasMontos(esInicial);
		this.setMostrarfecha_vencimientoVentasResumidasMontos(esInicial);
		this.setMostrarnumero_pre_impresoVentasResumidasMontos(esInicial);
		this.setMostrartotal_ivaVentasResumidasMontos(esInicial);
		this.setMostrartotal_sin_ivaVentasResumidasMontos(esInicial);
		this.setMostrartotal_descuentoVentasResumidasMontos(esInicial);
		this.setMostrartotal_otroVentasResumidasMontos(esInicial);
		this.setMostrarsub_totalVentasResumidasMontos(esInicial);
		this.setMostrartotalVentasResumidasMontos(esInicial);
		this.setMostrarivaVentasResumidasMontos(esInicial);
		this.setMostrardescripcionVentasResumidasMontos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VentasResumidasMontosConstantesFunciones.ID)) {
				this.setMostraridVentasResumidasMontos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidasMontosConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaVentasResumidasMontos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidasMontosConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalVentasResumidasMontos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidasMontosConstantesFunciones.IDVENDEDOR)) {
				this.setMostrarid_vendedorVentasResumidasMontos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidasMontosConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setMostrarfecha_emision_desdeVentasResumidasMontos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidasMontosConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setMostrarfecha_emision_hastaVentasResumidasMontos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidasMontosConstantesFunciones.NOMBRECOMPLETO)) {
				this.setMostrarnombre_completoVentasResumidasMontos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidasMontosConstantesFunciones.NOMBREVENDEDOR)) {
				this.setMostrarnombre_vendedorVentasResumidasMontos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidasMontosConstantesFunciones.NOMBRETIPOFACTURA)) {
				this.setMostrarnombre_tipo_facturaVentasResumidasMontos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidasMontosConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionVentasResumidasMontos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidasMontosConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setMostrarfecha_vencimientoVentasResumidasMontos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidasMontosConstantesFunciones.NUMEROPREIMPRESO)) {
				this.setMostrarnumero_pre_impresoVentasResumidasMontos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidasMontosConstantesFunciones.TOTALIVA)) {
				this.setMostrartotal_ivaVentasResumidasMontos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidasMontosConstantesFunciones.TOTALSINIVA)) {
				this.setMostrartotal_sin_ivaVentasResumidasMontos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidasMontosConstantesFunciones.TOTALDESCUENTO)) {
				this.setMostrartotal_descuentoVentasResumidasMontos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidasMontosConstantesFunciones.TOTALOTRO)) {
				this.setMostrartotal_otroVentasResumidasMontos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidasMontosConstantesFunciones.SUBTOTAL)) {
				this.setMostrarsub_totalVentasResumidasMontos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidasMontosConstantesFunciones.TOTAL)) {
				this.setMostrartotalVentasResumidasMontos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidasMontosConstantesFunciones.IVA)) {
				this.setMostrarivaVentasResumidasMontos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidasMontosConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionVentasResumidasMontos(esAsigna);
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
		
		
		this.setActivaridVentasResumidasMontos(esInicial);
		this.setActivarid_empresaVentasResumidasMontos(esInicial);
		this.setActivarid_sucursalVentasResumidasMontos(esInicial);
		this.setActivarid_vendedorVentasResumidasMontos(esInicial);
		this.setActivarfecha_emision_desdeVentasResumidasMontos(esInicial);
		this.setActivarfecha_emision_hastaVentasResumidasMontos(esInicial);
		this.setActivarnombre_completoVentasResumidasMontos(esInicial);
		this.setActivarnombre_vendedorVentasResumidasMontos(esInicial);
		this.setActivarnombre_tipo_facturaVentasResumidasMontos(esInicial);
		this.setActivarfecha_emisionVentasResumidasMontos(esInicial);
		this.setActivarfecha_vencimientoVentasResumidasMontos(esInicial);
		this.setActivarnumero_pre_impresoVentasResumidasMontos(esInicial);
		this.setActivartotal_ivaVentasResumidasMontos(esInicial);
		this.setActivartotal_sin_ivaVentasResumidasMontos(esInicial);
		this.setActivartotal_descuentoVentasResumidasMontos(esInicial);
		this.setActivartotal_otroVentasResumidasMontos(esInicial);
		this.setActivarsub_totalVentasResumidasMontos(esInicial);
		this.setActivartotalVentasResumidasMontos(esInicial);
		this.setActivarivaVentasResumidasMontos(esInicial);
		this.setActivardescripcionVentasResumidasMontos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VentasResumidasMontosConstantesFunciones.ID)) {
				this.setActivaridVentasResumidasMontos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidasMontosConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaVentasResumidasMontos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidasMontosConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalVentasResumidasMontos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidasMontosConstantesFunciones.IDVENDEDOR)) {
				this.setActivarid_vendedorVentasResumidasMontos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidasMontosConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setActivarfecha_emision_desdeVentasResumidasMontos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidasMontosConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setActivarfecha_emision_hastaVentasResumidasMontos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidasMontosConstantesFunciones.NOMBRECOMPLETO)) {
				this.setActivarnombre_completoVentasResumidasMontos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidasMontosConstantesFunciones.NOMBREVENDEDOR)) {
				this.setActivarnombre_vendedorVentasResumidasMontos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidasMontosConstantesFunciones.NOMBRETIPOFACTURA)) {
				this.setActivarnombre_tipo_facturaVentasResumidasMontos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidasMontosConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionVentasResumidasMontos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidasMontosConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setActivarfecha_vencimientoVentasResumidasMontos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidasMontosConstantesFunciones.NUMEROPREIMPRESO)) {
				this.setActivarnumero_pre_impresoVentasResumidasMontos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidasMontosConstantesFunciones.TOTALIVA)) {
				this.setActivartotal_ivaVentasResumidasMontos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidasMontosConstantesFunciones.TOTALSINIVA)) {
				this.setActivartotal_sin_ivaVentasResumidasMontos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidasMontosConstantesFunciones.TOTALDESCUENTO)) {
				this.setActivartotal_descuentoVentasResumidasMontos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidasMontosConstantesFunciones.TOTALOTRO)) {
				this.setActivartotal_otroVentasResumidasMontos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidasMontosConstantesFunciones.SUBTOTAL)) {
				this.setActivarsub_totalVentasResumidasMontos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidasMontosConstantesFunciones.TOTAL)) {
				this.setActivartotalVentasResumidasMontos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidasMontosConstantesFunciones.IVA)) {
				this.setActivarivaVentasResumidasMontos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidasMontosConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionVentasResumidasMontos(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,VentasResumidasMontosBeanSwingJInternalFrame ventasresumidasmontosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridVentasResumidasMontos(esInicial);
		this.setResaltarid_empresaVentasResumidasMontos(esInicial);
		this.setResaltarid_sucursalVentasResumidasMontos(esInicial);
		this.setResaltarid_vendedorVentasResumidasMontos(esInicial);
		this.setResaltarfecha_emision_desdeVentasResumidasMontos(esInicial);
		this.setResaltarfecha_emision_hastaVentasResumidasMontos(esInicial);
		this.setResaltarnombre_completoVentasResumidasMontos(esInicial);
		this.setResaltarnombre_vendedorVentasResumidasMontos(esInicial);
		this.setResaltarnombre_tipo_facturaVentasResumidasMontos(esInicial);
		this.setResaltarfecha_emisionVentasResumidasMontos(esInicial);
		this.setResaltarfecha_vencimientoVentasResumidasMontos(esInicial);
		this.setResaltarnumero_pre_impresoVentasResumidasMontos(esInicial);
		this.setResaltartotal_ivaVentasResumidasMontos(esInicial);
		this.setResaltartotal_sin_ivaVentasResumidasMontos(esInicial);
		this.setResaltartotal_descuentoVentasResumidasMontos(esInicial);
		this.setResaltartotal_otroVentasResumidasMontos(esInicial);
		this.setResaltarsub_totalVentasResumidasMontos(esInicial);
		this.setResaltartotalVentasResumidasMontos(esInicial);
		this.setResaltarivaVentasResumidasMontos(esInicial);
		this.setResaltardescripcionVentasResumidasMontos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VentasResumidasMontosConstantesFunciones.ID)) {
				this.setResaltaridVentasResumidasMontos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidasMontosConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaVentasResumidasMontos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidasMontosConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalVentasResumidasMontos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidasMontosConstantesFunciones.IDVENDEDOR)) {
				this.setResaltarid_vendedorVentasResumidasMontos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidasMontosConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setResaltarfecha_emision_desdeVentasResumidasMontos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidasMontosConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setResaltarfecha_emision_hastaVentasResumidasMontos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidasMontosConstantesFunciones.NOMBRECOMPLETO)) {
				this.setResaltarnombre_completoVentasResumidasMontos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidasMontosConstantesFunciones.NOMBREVENDEDOR)) {
				this.setResaltarnombre_vendedorVentasResumidasMontos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidasMontosConstantesFunciones.NOMBRETIPOFACTURA)) {
				this.setResaltarnombre_tipo_facturaVentasResumidasMontos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidasMontosConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionVentasResumidasMontos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidasMontosConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setResaltarfecha_vencimientoVentasResumidasMontos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidasMontosConstantesFunciones.NUMEROPREIMPRESO)) {
				this.setResaltarnumero_pre_impresoVentasResumidasMontos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidasMontosConstantesFunciones.TOTALIVA)) {
				this.setResaltartotal_ivaVentasResumidasMontos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidasMontosConstantesFunciones.TOTALSINIVA)) {
				this.setResaltartotal_sin_ivaVentasResumidasMontos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidasMontosConstantesFunciones.TOTALDESCUENTO)) {
				this.setResaltartotal_descuentoVentasResumidasMontos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidasMontosConstantesFunciones.TOTALOTRO)) {
				this.setResaltartotal_otroVentasResumidasMontos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidasMontosConstantesFunciones.SUBTOTAL)) {
				this.setResaltarsub_totalVentasResumidasMontos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidasMontosConstantesFunciones.TOTAL)) {
				this.setResaltartotalVentasResumidasMontos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidasMontosConstantesFunciones.IVA)) {
				this.setResaltarivaVentasResumidasMontos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidasMontosConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionVentasResumidasMontos(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,VentasResumidasMontosBeanSwingJInternalFrame ventasresumidasmontosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaVentasResumidasMontosVentasResumidasMontos=true;

	public Boolean getMostrarBusquedaVentasResumidasMontosVentasResumidasMontos() {
		return this.mostrarBusquedaVentasResumidasMontosVentasResumidasMontos;
	}

	public void setMostrarBusquedaVentasResumidasMontosVentasResumidasMontos(Boolean visibilidadResaltar) {
		this.mostrarBusquedaVentasResumidasMontosVentasResumidasMontos= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaVentasResumidasMontosVentasResumidasMontos=true;

	public Boolean getActivarBusquedaVentasResumidasMontosVentasResumidasMontos() {
		return this.activarBusquedaVentasResumidasMontosVentasResumidasMontos;
	}

	public void setActivarBusquedaVentasResumidasMontosVentasResumidasMontos(Boolean habilitarResaltar) {
		this.activarBusquedaVentasResumidasMontosVentasResumidasMontos= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaVentasResumidasMontosVentasResumidasMontos=null;

	public Border getResaltarBusquedaVentasResumidasMontosVentasResumidasMontos() {
		return this.resaltarBusquedaVentasResumidasMontosVentasResumidasMontos;
	}

	public void setResaltarBusquedaVentasResumidasMontosVentasResumidasMontos(Border borderResaltar) {
		this.resaltarBusquedaVentasResumidasMontosVentasResumidasMontos= borderResaltar;
	}

	public void setResaltarBusquedaVentasResumidasMontosVentasResumidasMontos(ParametroGeneralUsuario parametroGeneralUsuario/*VentasResumidasMontosBeanSwingJInternalFrame ventasresumidasmontosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaVentasResumidasMontosVentasResumidasMontos= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}