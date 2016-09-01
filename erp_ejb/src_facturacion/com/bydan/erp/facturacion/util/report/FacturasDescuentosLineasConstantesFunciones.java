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


import com.bydan.erp.facturacion.util.report.FacturasDescuentosLineasConstantesFunciones;
import com.bydan.erp.facturacion.util.report.FacturasDescuentosLineasParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.report.FacturasDescuentosLineasParameterGeneral;

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
final public class FacturasDescuentosLineasConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="FacturasDescuentosLineas";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="FacturasDescuentosLineas"+FacturasDescuentosLineasConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="FacturasDescuentosLineasHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="FacturasDescuentosLineasHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=FacturasDescuentosLineasConstantesFunciones.SCHEMA+"_"+FacturasDescuentosLineasConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/FacturasDescuentosLineasHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=FacturasDescuentosLineasConstantesFunciones.SCHEMA+"_"+FacturasDescuentosLineasConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=FacturasDescuentosLineasConstantesFunciones.SCHEMA+"_"+FacturasDescuentosLineasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/FacturasDescuentosLineasHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=FacturasDescuentosLineasConstantesFunciones.SCHEMA+"_"+FacturasDescuentosLineasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FacturasDescuentosLineasConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/FacturasDescuentosLineasHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FacturasDescuentosLineasConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FacturasDescuentosLineasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/FacturasDescuentosLineasHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+FacturasDescuentosLineasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=FacturasDescuentosLineasConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+FacturasDescuentosLineasConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=FacturasDescuentosLineasConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+FacturasDescuentosLineasConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Facturas Descuentos Lineases";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Facturas Descuentos Lineas";
	public static final String SCLASSWEBTITULO_LOWER="Facturas Descuentos Lineas";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="FacturasDescuentosLineas";
	public static final String OBJECTNAME="facturasdescuentoslineas";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="facturas_descuentos_lineas";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select facturasdescuentoslineas from "+FacturasDescuentosLineasConstantesFunciones.SPERSISTENCENAME+" facturasdescuentoslineas";
	public static String QUERYSELECTNATIVE="select "+FacturasDescuentosLineasConstantesFunciones.SCHEMA+"."+FacturasDescuentosLineasConstantesFunciones.TABLENAME+".id,"+FacturasDescuentosLineasConstantesFunciones.SCHEMA+"."+FacturasDescuentosLineasConstantesFunciones.TABLENAME+".version_row,"+FacturasDescuentosLineasConstantesFunciones.SCHEMA+"."+FacturasDescuentosLineasConstantesFunciones.TABLENAME+".id_empresa,"+FacturasDescuentosLineasConstantesFunciones.SCHEMA+"."+FacturasDescuentosLineasConstantesFunciones.TABLENAME+".id_sucursal,"+FacturasDescuentosLineasConstantesFunciones.SCHEMA+"."+FacturasDescuentosLineasConstantesFunciones.TABLENAME+".id_vendedor,"+FacturasDescuentosLineasConstantesFunciones.SCHEMA+"."+FacturasDescuentosLineasConstantesFunciones.TABLENAME+".fecha_emision_desde,"+FacturasDescuentosLineasConstantesFunciones.SCHEMA+"."+FacturasDescuentosLineasConstantesFunciones.TABLENAME+".fecha_emision_hasta,"+FacturasDescuentosLineasConstantesFunciones.SCHEMA+"."+FacturasDescuentosLineasConstantesFunciones.TABLENAME+".nombre,"+FacturasDescuentosLineasConstantesFunciones.SCHEMA+"."+FacturasDescuentosLineasConstantesFunciones.TABLENAME+".nombre_completo_cliente,"+FacturasDescuentosLineasConstantesFunciones.SCHEMA+"."+FacturasDescuentosLineasConstantesFunciones.TABLENAME+".nombre_tipo_factura,"+FacturasDescuentosLineasConstantesFunciones.SCHEMA+"."+FacturasDescuentosLineasConstantesFunciones.TABLENAME+".fecha_emision,"+FacturasDescuentosLineasConstantesFunciones.SCHEMA+"."+FacturasDescuentosLineasConstantesFunciones.TABLENAME+".fecha_vencimiento,"+FacturasDescuentosLineasConstantesFunciones.SCHEMA+"."+FacturasDescuentosLineasConstantesFunciones.TABLENAME+".numero_pre_impreso,"+FacturasDescuentosLineasConstantesFunciones.SCHEMA+"."+FacturasDescuentosLineasConstantesFunciones.TABLENAME+".total_descuento,"+FacturasDescuentosLineasConstantesFunciones.SCHEMA+"."+FacturasDescuentosLineasConstantesFunciones.TABLENAME+".total_otro,"+FacturasDescuentosLineasConstantesFunciones.SCHEMA+"."+FacturasDescuentosLineasConstantesFunciones.TABLENAME+".sub_total,"+FacturasDescuentosLineasConstantesFunciones.SCHEMA+"."+FacturasDescuentosLineasConstantesFunciones.TABLENAME+".total,"+FacturasDescuentosLineasConstantesFunciones.SCHEMA+"."+FacturasDescuentosLineasConstantesFunciones.TABLENAME+".iva from "+FacturasDescuentosLineasConstantesFunciones.SCHEMA+"."+FacturasDescuentosLineasConstantesFunciones.TABLENAME;//+" as "+FacturasDescuentosLineasConstantesFunciones.TABLENAME;
	
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
    public static final String NOMBRE= "nombre";
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
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
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
	
		
		
		
		
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_COMPLETO_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_COMPLETO_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_TIPO_FACTURA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_TIPO_FACTURA=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXNUMERO_PRE_IMPRESO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_PRE_IMPRESO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
	
	public static String getFacturasDescuentosLineasLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(FacturasDescuentosLineasConstantesFunciones.IDEMPRESA)) {sLabelColumna=FacturasDescuentosLineasConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(FacturasDescuentosLineasConstantesFunciones.IDSUCURSAL)) {sLabelColumna=FacturasDescuentosLineasConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(FacturasDescuentosLineasConstantesFunciones.IDVENDEDOR)) {sLabelColumna=FacturasDescuentosLineasConstantesFunciones.LABEL_IDVENDEDOR;}
		if(sNombreColumna.equals(FacturasDescuentosLineasConstantesFunciones.FECHAEMISIONDESDE)) {sLabelColumna=FacturasDescuentosLineasConstantesFunciones.LABEL_FECHAEMISIONDESDE;}
		if(sNombreColumna.equals(FacturasDescuentosLineasConstantesFunciones.FECHAEMISIONHASTA)) {sLabelColumna=FacturasDescuentosLineasConstantesFunciones.LABEL_FECHAEMISIONHASTA;}
		if(sNombreColumna.equals(FacturasDescuentosLineasConstantesFunciones.NOMBRE)) {sLabelColumna=FacturasDescuentosLineasConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(FacturasDescuentosLineasConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {sLabelColumna=FacturasDescuentosLineasConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE;}
		if(sNombreColumna.equals(FacturasDescuentosLineasConstantesFunciones.NOMBRETIPOFACTURA)) {sLabelColumna=FacturasDescuentosLineasConstantesFunciones.LABEL_NOMBRETIPOFACTURA;}
		if(sNombreColumna.equals(FacturasDescuentosLineasConstantesFunciones.FECHAEMISION)) {sLabelColumna=FacturasDescuentosLineasConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(FacturasDescuentosLineasConstantesFunciones.FECHAVENCIMIENTO)) {sLabelColumna=FacturasDescuentosLineasConstantesFunciones.LABEL_FECHAVENCIMIENTO;}
		if(sNombreColumna.equals(FacturasDescuentosLineasConstantesFunciones.NUMEROPREIMPRESO)) {sLabelColumna=FacturasDescuentosLineasConstantesFunciones.LABEL_NUMEROPREIMPRESO;}
		if(sNombreColumna.equals(FacturasDescuentosLineasConstantesFunciones.TOTALDESCUENTO)) {sLabelColumna=FacturasDescuentosLineasConstantesFunciones.LABEL_TOTALDESCUENTO;}
		if(sNombreColumna.equals(FacturasDescuentosLineasConstantesFunciones.TOTALOTRO)) {sLabelColumna=FacturasDescuentosLineasConstantesFunciones.LABEL_TOTALOTRO;}
		if(sNombreColumna.equals(FacturasDescuentosLineasConstantesFunciones.SUBTOTAL)) {sLabelColumna=FacturasDescuentosLineasConstantesFunciones.LABEL_SUBTOTAL;}
		if(sNombreColumna.equals(FacturasDescuentosLineasConstantesFunciones.TOTAL)) {sLabelColumna=FacturasDescuentosLineasConstantesFunciones.LABEL_TOTAL;}
		if(sNombreColumna.equals(FacturasDescuentosLineasConstantesFunciones.IVA)) {sLabelColumna=FacturasDescuentosLineasConstantesFunciones.LABEL_IVA;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getFacturasDescuentosLineasDescripcion(FacturasDescuentosLineas facturasdescuentoslineas) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(facturasdescuentoslineas !=null/* && facturasdescuentoslineas.getId()!=0*/) {
			sDescripcion=facturasdescuentoslineas.getnombre();//facturasdescuentoslineasfacturasdescuentoslineas.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getFacturasDescuentosLineasDescripcionDetallado(FacturasDescuentosLineas facturasdescuentoslineas) {
		String sDescripcion="";
			
		sDescripcion+=FacturasDescuentosLineasConstantesFunciones.ID+"=";
		sDescripcion+=facturasdescuentoslineas.getId().toString()+",";
		sDescripcion+=FacturasDescuentosLineasConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=facturasdescuentoslineas.getVersionRow().toString()+",";
		sDescripcion+=FacturasDescuentosLineasConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=facturasdescuentoslineas.getid_empresa().toString()+",";
		sDescripcion+=FacturasDescuentosLineasConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=facturasdescuentoslineas.getid_sucursal().toString()+",";
		sDescripcion+=FacturasDescuentosLineasConstantesFunciones.IDVENDEDOR+"=";
		sDescripcion+=facturasdescuentoslineas.getid_vendedor().toString()+",";
		sDescripcion+=FacturasDescuentosLineasConstantesFunciones.FECHAEMISIONDESDE+"=";
		sDescripcion+=facturasdescuentoslineas.getfecha_emision_desde().toString()+",";
		sDescripcion+=FacturasDescuentosLineasConstantesFunciones.FECHAEMISIONHASTA+"=";
		sDescripcion+=facturasdescuentoslineas.getfecha_emision_hasta().toString()+",";
		sDescripcion+=FacturasDescuentosLineasConstantesFunciones.NOMBRE+"=";
		sDescripcion+=facturasdescuentoslineas.getnombre()+",";
		sDescripcion+=FacturasDescuentosLineasConstantesFunciones.NOMBRECOMPLETOCLIENTE+"=";
		sDescripcion+=facturasdescuentoslineas.getnombre_completo_cliente()+",";
		sDescripcion+=FacturasDescuentosLineasConstantesFunciones.NOMBRETIPOFACTURA+"=";
		sDescripcion+=facturasdescuentoslineas.getnombre_tipo_factura()+",";
		sDescripcion+=FacturasDescuentosLineasConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=facturasdescuentoslineas.getfecha_emision().toString()+",";
		sDescripcion+=FacturasDescuentosLineasConstantesFunciones.FECHAVENCIMIENTO+"=";
		sDescripcion+=facturasdescuentoslineas.getfecha_vencimiento().toString()+",";
		sDescripcion+=FacturasDescuentosLineasConstantesFunciones.NUMEROPREIMPRESO+"=";
		sDescripcion+=facturasdescuentoslineas.getnumero_pre_impreso()+",";
		sDescripcion+=FacturasDescuentosLineasConstantesFunciones.TOTALDESCUENTO+"=";
		sDescripcion+=facturasdescuentoslineas.gettotal_descuento().toString()+",";
		sDescripcion+=FacturasDescuentosLineasConstantesFunciones.TOTALOTRO+"=";
		sDescripcion+=facturasdescuentoslineas.gettotal_otro().toString()+",";
		sDescripcion+=FacturasDescuentosLineasConstantesFunciones.SUBTOTAL+"=";
		sDescripcion+=facturasdescuentoslineas.getsub_total().toString()+",";
		sDescripcion+=FacturasDescuentosLineasConstantesFunciones.TOTAL+"=";
		sDescripcion+=facturasdescuentoslineas.gettotal().toString()+",";
		sDescripcion+=FacturasDescuentosLineasConstantesFunciones.IVA+"=";
		sDescripcion+=facturasdescuentoslineas.getiva().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setFacturasDescuentosLineasDescripcion(FacturasDescuentosLineas facturasdescuentoslineas,String sValor) throws Exception {			
		if(facturasdescuentoslineas !=null) {
			facturasdescuentoslineas.setnombre(sValor);;//facturasdescuentoslineasfacturasdescuentoslineas.getnombre().trim();
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
		} else if(sNombreIndice.equals("BusquedaFacturasDescuentosLineas")) {
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

	public static String getDetalleIndiceBusquedaFacturasDescuentosLineas(Long id_vendedor,Date fecha_emision_desde,Date fecha_emision_hasta) {
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
	
	
	
	
	
	
	public static void quitarEspaciosFacturasDescuentosLineas(FacturasDescuentosLineas facturasdescuentoslineas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		facturasdescuentoslineas.setnombre(facturasdescuentoslineas.getnombre().trim());
		facturasdescuentoslineas.setnombre_completo_cliente(facturasdescuentoslineas.getnombre_completo_cliente().trim());
		facturasdescuentoslineas.setnombre_tipo_factura(facturasdescuentoslineas.getnombre_tipo_factura().trim());
		facturasdescuentoslineas.setnumero_pre_impreso(facturasdescuentoslineas.getnumero_pre_impreso().trim());
	}
	
	public static void quitarEspaciosFacturasDescuentosLineass(List<FacturasDescuentosLineas> facturasdescuentoslineass,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(FacturasDescuentosLineas facturasdescuentoslineas: facturasdescuentoslineass) {
			facturasdescuentoslineas.setnombre(facturasdescuentoslineas.getnombre().trim());
			facturasdescuentoslineas.setnombre_completo_cliente(facturasdescuentoslineas.getnombre_completo_cliente().trim());
			facturasdescuentoslineas.setnombre_tipo_factura(facturasdescuentoslineas.getnombre_tipo_factura().trim());
			facturasdescuentoslineas.setnumero_pre_impreso(facturasdescuentoslineas.getnumero_pre_impreso().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresFacturasDescuentosLineas(FacturasDescuentosLineas facturasdescuentoslineas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && facturasdescuentoslineas.getConCambioAuxiliar()) {
			facturasdescuentoslineas.setIsDeleted(facturasdescuentoslineas.getIsDeletedAuxiliar());	
			facturasdescuentoslineas.setIsNew(facturasdescuentoslineas.getIsNewAuxiliar());	
			facturasdescuentoslineas.setIsChanged(facturasdescuentoslineas.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			facturasdescuentoslineas.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			facturasdescuentoslineas.setIsDeletedAuxiliar(false);	
			facturasdescuentoslineas.setIsNewAuxiliar(false);	
			facturasdescuentoslineas.setIsChangedAuxiliar(false);
			
			facturasdescuentoslineas.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresFacturasDescuentosLineass(List<FacturasDescuentosLineas> facturasdescuentoslineass,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(FacturasDescuentosLineas facturasdescuentoslineas : facturasdescuentoslineass) {
			if(conAsignarBase && facturasdescuentoslineas.getConCambioAuxiliar()) {
				facturasdescuentoslineas.setIsDeleted(facturasdescuentoslineas.getIsDeletedAuxiliar());	
				facturasdescuentoslineas.setIsNew(facturasdescuentoslineas.getIsNewAuxiliar());	
				facturasdescuentoslineas.setIsChanged(facturasdescuentoslineas.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				facturasdescuentoslineas.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				facturasdescuentoslineas.setIsDeletedAuxiliar(false);	
				facturasdescuentoslineas.setIsNewAuxiliar(false);	
				facturasdescuentoslineas.setIsChangedAuxiliar(false);
				
				facturasdescuentoslineas.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresFacturasDescuentosLineas(FacturasDescuentosLineas facturasdescuentoslineas,Boolean conEnteros) throws Exception  {
		facturasdescuentoslineas.settotal_descuento(0.0);
		facturasdescuentoslineas.settotal_otro(0.0);
		facturasdescuentoslineas.setsub_total(0.0);
		facturasdescuentoslineas.settotal(0.0);
		facturasdescuentoslineas.setiva(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresFacturasDescuentosLineass(List<FacturasDescuentosLineas> facturasdescuentoslineass,Boolean conEnteros) throws Exception  {
		
		for(FacturasDescuentosLineas facturasdescuentoslineas: facturasdescuentoslineass) {
			facturasdescuentoslineas.settotal_descuento(0.0);
			facturasdescuentoslineas.settotal_otro(0.0);
			facturasdescuentoslineas.setsub_total(0.0);
			facturasdescuentoslineas.settotal(0.0);
			facturasdescuentoslineas.setiva(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaFacturasDescuentosLineas(List<FacturasDescuentosLineas> facturasdescuentoslineass,FacturasDescuentosLineas facturasdescuentoslineasAux) throws Exception  {
		FacturasDescuentosLineasConstantesFunciones.InicializarValoresFacturasDescuentosLineas(facturasdescuentoslineasAux,true);
		
		for(FacturasDescuentosLineas facturasdescuentoslineas: facturasdescuentoslineass) {
			if(facturasdescuentoslineas.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			facturasdescuentoslineasAux.settotal_descuento(facturasdescuentoslineasAux.gettotal_descuento()+facturasdescuentoslineas.gettotal_descuento());			
			facturasdescuentoslineasAux.settotal_otro(facturasdescuentoslineasAux.gettotal_otro()+facturasdescuentoslineas.gettotal_otro());			
			facturasdescuentoslineasAux.setsub_total(facturasdescuentoslineasAux.getsub_total()+facturasdescuentoslineas.getsub_total());			
			facturasdescuentoslineasAux.settotal(facturasdescuentoslineasAux.gettotal()+facturasdescuentoslineas.gettotal());			
			facturasdescuentoslineasAux.setiva(facturasdescuentoslineasAux.getiva()+facturasdescuentoslineas.getiva());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesFacturasDescuentosLineas(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=FacturasDescuentosLineasConstantesFunciones.getArrayColumnasGlobalesFacturasDescuentosLineas(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesFacturasDescuentosLineas(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FacturasDescuentosLineasConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FacturasDescuentosLineasConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(FacturasDescuentosLineasConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(FacturasDescuentosLineasConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoFacturasDescuentosLineas(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<FacturasDescuentosLineas> facturasdescuentoslineass,FacturasDescuentosLineas facturasdescuentoslineas,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(FacturasDescuentosLineas facturasdescuentoslineasAux: facturasdescuentoslineass) {
			if(facturasdescuentoslineasAux!=null && facturasdescuentoslineas!=null) {
				if((facturasdescuentoslineasAux.getId()==null && facturasdescuentoslineas.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(facturasdescuentoslineasAux.getId()!=null && facturasdescuentoslineas.getId()!=null){
					if(facturasdescuentoslineasAux.getId().equals(facturasdescuentoslineas.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaFacturasDescuentosLineas(List<FacturasDescuentosLineas> facturasdescuentoslineass) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double total_descuentoTotal=0.0;
		Double total_otroTotal=0.0;
		Double sub_totalTotal=0.0;
		Double totalTotal=0.0;
		Double ivaTotal=0.0;
	
		for(FacturasDescuentosLineas facturasdescuentoslineas: facturasdescuentoslineass) {			
			if(facturasdescuentoslineas.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			total_descuentoTotal+=facturasdescuentoslineas.gettotal_descuento();
			total_otroTotal+=facturasdescuentoslineas.gettotal_otro();
			sub_totalTotal+=facturasdescuentoslineas.getsub_total();
			totalTotal+=facturasdescuentoslineas.gettotal();
			ivaTotal+=facturasdescuentoslineas.getiva();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturasDescuentosLineasConstantesFunciones.TOTALDESCUENTO);
		datoGeneral.setsDescripcion(FacturasDescuentosLineasConstantesFunciones.LABEL_TOTALDESCUENTO);
		datoGeneral.setdValorDouble(total_descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturasDescuentosLineasConstantesFunciones.TOTALOTRO);
		datoGeneral.setsDescripcion(FacturasDescuentosLineasConstantesFunciones.LABEL_TOTALOTRO);
		datoGeneral.setdValorDouble(total_otroTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturasDescuentosLineasConstantesFunciones.SUBTOTAL);
		datoGeneral.setsDescripcion(FacturasDescuentosLineasConstantesFunciones.LABEL_SUBTOTAL);
		datoGeneral.setdValorDouble(sub_totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturasDescuentosLineasConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(FacturasDescuentosLineasConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(FacturasDescuentosLineasConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(FacturasDescuentosLineasConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaFacturasDescuentosLineas() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,FacturasDescuentosLineasConstantesFunciones.LABEL_ID, FacturasDescuentosLineasConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturasDescuentosLineasConstantesFunciones.LABEL_VERSIONROW, FacturasDescuentosLineasConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturasDescuentosLineasConstantesFunciones.LABEL_NOMBRE, FacturasDescuentosLineasConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturasDescuentosLineasConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE, FacturasDescuentosLineasConstantesFunciones.NOMBRECOMPLETOCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturasDescuentosLineasConstantesFunciones.LABEL_NOMBRETIPOFACTURA, FacturasDescuentosLineasConstantesFunciones.NOMBRETIPOFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturasDescuentosLineasConstantesFunciones.LABEL_FECHAEMISION, FacturasDescuentosLineasConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturasDescuentosLineasConstantesFunciones.LABEL_FECHAVENCIMIENTO, FacturasDescuentosLineasConstantesFunciones.FECHAVENCIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturasDescuentosLineasConstantesFunciones.LABEL_NUMEROPREIMPRESO, FacturasDescuentosLineasConstantesFunciones.NUMEROPREIMPRESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturasDescuentosLineasConstantesFunciones.LABEL_TOTALDESCUENTO, FacturasDescuentosLineasConstantesFunciones.TOTALDESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturasDescuentosLineasConstantesFunciones.LABEL_TOTALOTRO, FacturasDescuentosLineasConstantesFunciones.TOTALOTRO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturasDescuentosLineasConstantesFunciones.LABEL_SUBTOTAL, FacturasDescuentosLineasConstantesFunciones.SUBTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturasDescuentosLineasConstantesFunciones.LABEL_TOTAL, FacturasDescuentosLineasConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,FacturasDescuentosLineasConstantesFunciones.LABEL_IVA, FacturasDescuentosLineasConstantesFunciones.IVA,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasFacturasDescuentosLineas() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=FacturasDescuentosLineasConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturasDescuentosLineasConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturasDescuentosLineasConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturasDescuentosLineasConstantesFunciones.NOMBRECOMPLETOCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturasDescuentosLineasConstantesFunciones.NOMBRETIPOFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturasDescuentosLineasConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturasDescuentosLineasConstantesFunciones.FECHAVENCIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturasDescuentosLineasConstantesFunciones.NUMEROPREIMPRESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturasDescuentosLineasConstantesFunciones.TOTALDESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturasDescuentosLineasConstantesFunciones.TOTALOTRO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturasDescuentosLineasConstantesFunciones.SUBTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturasDescuentosLineasConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=FacturasDescuentosLineasConstantesFunciones.IVA;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFacturasDescuentosLineas() throws Exception  {
		return FacturasDescuentosLineasConstantesFunciones.getTiposSeleccionarFacturasDescuentosLineas(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFacturasDescuentosLineas(Boolean conFk) throws Exception  {
		return FacturasDescuentosLineasConstantesFunciones.getTiposSeleccionarFacturasDescuentosLineas(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarFacturasDescuentosLineas(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturasDescuentosLineasConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(FacturasDescuentosLineasConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturasDescuentosLineasConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(FacturasDescuentosLineasConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturasDescuentosLineasConstantesFunciones.LABEL_IDVENDEDOR);
			reporte.setsDescripcion(FacturasDescuentosLineasConstantesFunciones.LABEL_IDVENDEDOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturasDescuentosLineasConstantesFunciones.LABEL_FECHAEMISIONDESDE);
			reporte.setsDescripcion(FacturasDescuentosLineasConstantesFunciones.LABEL_FECHAEMISIONDESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturasDescuentosLineasConstantesFunciones.LABEL_FECHAEMISIONHASTA);
			reporte.setsDescripcion(FacturasDescuentosLineasConstantesFunciones.LABEL_FECHAEMISIONHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturasDescuentosLineasConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(FacturasDescuentosLineasConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturasDescuentosLineasConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);
			reporte.setsDescripcion(FacturasDescuentosLineasConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturasDescuentosLineasConstantesFunciones.LABEL_NOMBRETIPOFACTURA);
			reporte.setsDescripcion(FacturasDescuentosLineasConstantesFunciones.LABEL_NOMBRETIPOFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturasDescuentosLineasConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(FacturasDescuentosLineasConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturasDescuentosLineasConstantesFunciones.LABEL_FECHAVENCIMIENTO);
			reporte.setsDescripcion(FacturasDescuentosLineasConstantesFunciones.LABEL_FECHAVENCIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturasDescuentosLineasConstantesFunciones.LABEL_NUMEROPREIMPRESO);
			reporte.setsDescripcion(FacturasDescuentosLineasConstantesFunciones.LABEL_NUMEROPREIMPRESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturasDescuentosLineasConstantesFunciones.LABEL_TOTALDESCUENTO);
			reporte.setsDescripcion(FacturasDescuentosLineasConstantesFunciones.LABEL_TOTALDESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturasDescuentosLineasConstantesFunciones.LABEL_TOTALOTRO);
			reporte.setsDescripcion(FacturasDescuentosLineasConstantesFunciones.LABEL_TOTALOTRO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturasDescuentosLineasConstantesFunciones.LABEL_SUBTOTAL);
			reporte.setsDescripcion(FacturasDescuentosLineasConstantesFunciones.LABEL_SUBTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturasDescuentosLineasConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(FacturasDescuentosLineasConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(FacturasDescuentosLineasConstantesFunciones.LABEL_IVA);
			reporte.setsDescripcion(FacturasDescuentosLineasConstantesFunciones.LABEL_IVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesFacturasDescuentosLineas(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesFacturasDescuentosLineas(FacturasDescuentosLineas facturasdescuentoslineasAux) throws Exception {
		
			facturasdescuentoslineasAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(facturasdescuentoslineasAux.getEmpresa()));
			facturasdescuentoslineasAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(facturasdescuentoslineasAux.getSucursal()));
			facturasdescuentoslineasAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(facturasdescuentoslineasAux.getVendedor()));		
	}
	
	public static void refrescarForeignKeysDescripcionesFacturasDescuentosLineas(List<FacturasDescuentosLineas> facturasdescuentoslineassTemp) throws Exception {
		for(FacturasDescuentosLineas facturasdescuentoslineasAux:facturasdescuentoslineassTemp) {
			
			facturasdescuentoslineasAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(facturasdescuentoslineasAux.getEmpresa()));
			facturasdescuentoslineasAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(facturasdescuentoslineasAux.getSucursal()));
			facturasdescuentoslineasAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(facturasdescuentoslineasAux.getVendedor()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfFacturasDescuentosLineas(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfFacturasDescuentosLineas(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfFacturasDescuentosLineas(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return FacturasDescuentosLineasConstantesFunciones.getClassesRelationshipsOfFacturasDescuentosLineas(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfFacturasDescuentosLineas(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfFacturasDescuentosLineas(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return FacturasDescuentosLineasConstantesFunciones.getClassesRelationshipsFromStringsOfFacturasDescuentosLineas(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfFacturasDescuentosLineas(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(FacturasDescuentosLineas facturasdescuentoslineas,List<FacturasDescuentosLineas> facturasdescuentoslineass,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(FacturasDescuentosLineas facturasdescuentoslineas,List<FacturasDescuentosLineas> facturasdescuentoslineass) throws Exception {
		try	{			
			for(FacturasDescuentosLineas facturasdescuentoslineasLocal:facturasdescuentoslineass) {
				if(facturasdescuentoslineasLocal.getId().equals(facturasdescuentoslineas.getId())) {
					facturasdescuentoslineasLocal.setIsSelected(facturasdescuentoslineas.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesFacturasDescuentosLineas(List<FacturasDescuentosLineas> facturasdescuentoslineassAux) throws Exception {
		//this.facturasdescuentoslineassAux=facturasdescuentoslineassAux;
		
		for(FacturasDescuentosLineas facturasdescuentoslineasAux:facturasdescuentoslineassAux) {
			if(facturasdescuentoslineasAux.getIsChanged()) {
				facturasdescuentoslineasAux.setIsChanged(false);
			}		
			
			if(facturasdescuentoslineasAux.getIsNew()) {
				facturasdescuentoslineasAux.setIsNew(false);
			}	
			
			if(facturasdescuentoslineasAux.getIsDeleted()) {
				facturasdescuentoslineasAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesFacturasDescuentosLineas(FacturasDescuentosLineas facturasdescuentoslineasAux) throws Exception {
		//this.facturasdescuentoslineasAux=facturasdescuentoslineasAux;
		
			if(facturasdescuentoslineasAux.getIsChanged()) {
				facturasdescuentoslineasAux.setIsChanged(false);
			}		
			
			if(facturasdescuentoslineasAux.getIsNew()) {
				facturasdescuentoslineasAux.setIsNew(false);
			}	
			
			if(facturasdescuentoslineasAux.getIsDeleted()) {
				facturasdescuentoslineasAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(FacturasDescuentosLineas facturasdescuentoslineasAsignar,FacturasDescuentosLineas facturasdescuentoslineas) throws Exception {
		facturasdescuentoslineasAsignar.setId(facturasdescuentoslineas.getId());	
		facturasdescuentoslineasAsignar.setVersionRow(facturasdescuentoslineas.getVersionRow());	
		facturasdescuentoslineasAsignar.setnombre(facturasdescuentoslineas.getnombre());	
		facturasdescuentoslineasAsignar.setnombre_completo_cliente(facturasdescuentoslineas.getnombre_completo_cliente());	
		facturasdescuentoslineasAsignar.setnombre_tipo_factura(facturasdescuentoslineas.getnombre_tipo_factura());	
		facturasdescuentoslineasAsignar.setfecha_emision(facturasdescuentoslineas.getfecha_emision());	
		facturasdescuentoslineasAsignar.setfecha_vencimiento(facturasdescuentoslineas.getfecha_vencimiento());	
		facturasdescuentoslineasAsignar.setnumero_pre_impreso(facturasdescuentoslineas.getnumero_pre_impreso());	
		facturasdescuentoslineasAsignar.settotal_descuento(facturasdescuentoslineas.gettotal_descuento());	
		facturasdescuentoslineasAsignar.settotal_otro(facturasdescuentoslineas.gettotal_otro());	
		facturasdescuentoslineasAsignar.setsub_total(facturasdescuentoslineas.getsub_total());	
		facturasdescuentoslineasAsignar.settotal(facturasdescuentoslineas.gettotal());	
		facturasdescuentoslineasAsignar.setiva(facturasdescuentoslineas.getiva());	
	}
	
	public static void inicializarFacturasDescuentosLineas(FacturasDescuentosLineas facturasdescuentoslineas) throws Exception {
		try {
				facturasdescuentoslineas.setId(0L);	
					
				facturasdescuentoslineas.setnombre("");	
				facturasdescuentoslineas.setnombre_completo_cliente("");	
				facturasdescuentoslineas.setnombre_tipo_factura("");	
				facturasdescuentoslineas.setfecha_emision(new Date());	
				facturasdescuentoslineas.setfecha_vencimiento(new Date());	
				facturasdescuentoslineas.setnumero_pre_impreso("");	
				facturasdescuentoslineas.settotal_descuento(0.0);	
				facturasdescuentoslineas.settotal_otro(0.0);	
				facturasdescuentoslineas.setsub_total(0.0);	
				facturasdescuentoslineas.settotal(0.0);	
				facturasdescuentoslineas.setiva(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderFacturasDescuentosLineas(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturasDescuentosLineasConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturasDescuentosLineasConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturasDescuentosLineasConstantesFunciones.LABEL_IDVENDEDOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturasDescuentosLineasConstantesFunciones.LABEL_FECHAEMISIONDESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturasDescuentosLineasConstantesFunciones.LABEL_FECHAEMISIONHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturasDescuentosLineasConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturasDescuentosLineasConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturasDescuentosLineasConstantesFunciones.LABEL_NOMBRETIPOFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturasDescuentosLineasConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturasDescuentosLineasConstantesFunciones.LABEL_FECHAVENCIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturasDescuentosLineasConstantesFunciones.LABEL_NUMEROPREIMPRESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturasDescuentosLineasConstantesFunciones.LABEL_TOTALDESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturasDescuentosLineasConstantesFunciones.LABEL_TOTALOTRO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturasDescuentosLineasConstantesFunciones.LABEL_SUBTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturasDescuentosLineasConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(FacturasDescuentosLineasConstantesFunciones.LABEL_IVA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataFacturasDescuentosLineas(String sTipo,Row row,Workbook workbook,FacturasDescuentosLineas facturasdescuentoslineas,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(facturasdescuentoslineas.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturasdescuentoslineas.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturasdescuentoslineas.getvendedor_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturasdescuentoslineas.getfecha_emision_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturasdescuentoslineas.getfecha_emision_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturasdescuentoslineas.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturasdescuentoslineas.getnombre_completo_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturasdescuentoslineas.getnombre_tipo_factura());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturasdescuentoslineas.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturasdescuentoslineas.getfecha_vencimiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturasdescuentoslineas.getnumero_pre_impreso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturasdescuentoslineas.gettotal_descuento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturasdescuentoslineas.gettotal_otro());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturasdescuentoslineas.getsub_total());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturasdescuentoslineas.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(facturasdescuentoslineas.getiva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryFacturasDescuentosLineas="";
	
	public String getsFinalQueryFacturasDescuentosLineas() {
		return this.sFinalQueryFacturasDescuentosLineas;
	}
	
	public void setsFinalQueryFacturasDescuentosLineas(String sFinalQueryFacturasDescuentosLineas) {
		this.sFinalQueryFacturasDescuentosLineas= sFinalQueryFacturasDescuentosLineas;
	}
	
	public Border resaltarSeleccionarFacturasDescuentosLineas=null;
	
	public Border setResaltarSeleccionarFacturasDescuentosLineas(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasDescuentosLineasBeanSwingJInternalFrame facturasdescuentoslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//facturasdescuentoslineasBeanSwingJInternalFrame.jTtoolBarFacturasDescuentosLineas.setBorder(borderResaltar);
		
		this.resaltarSeleccionarFacturasDescuentosLineas= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarFacturasDescuentosLineas() {
		return this.resaltarSeleccionarFacturasDescuentosLineas;
	}
	
	public void setResaltarSeleccionarFacturasDescuentosLineas(Border borderResaltarSeleccionarFacturasDescuentosLineas) {
		this.resaltarSeleccionarFacturasDescuentosLineas= borderResaltarSeleccionarFacturasDescuentosLineas;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridFacturasDescuentosLineas=null;
	public Boolean mostraridFacturasDescuentosLineas=true;
	public Boolean activaridFacturasDescuentosLineas=true;

	public Border resaltarid_empresaFacturasDescuentosLineas=null;
	public Boolean mostrarid_empresaFacturasDescuentosLineas=true;
	public Boolean activarid_empresaFacturasDescuentosLineas=true;
	public Boolean cargarid_empresaFacturasDescuentosLineas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaFacturasDescuentosLineas=false;//ConEventDepend=true

	public Border resaltarid_sucursalFacturasDescuentosLineas=null;
	public Boolean mostrarid_sucursalFacturasDescuentosLineas=true;
	public Boolean activarid_sucursalFacturasDescuentosLineas=true;
	public Boolean cargarid_sucursalFacturasDescuentosLineas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalFacturasDescuentosLineas=false;//ConEventDepend=true

	public Border resaltarid_vendedorFacturasDescuentosLineas=null;
	public Boolean mostrarid_vendedorFacturasDescuentosLineas=true;
	public Boolean activarid_vendedorFacturasDescuentosLineas=true;
	public Boolean cargarid_vendedorFacturasDescuentosLineas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_vendedorFacturasDescuentosLineas=false;//ConEventDepend=true

	public Border resaltarfecha_emision_desdeFacturasDescuentosLineas=null;
	public Boolean mostrarfecha_emision_desdeFacturasDescuentosLineas=true;
	public Boolean activarfecha_emision_desdeFacturasDescuentosLineas=true;

	public Border resaltarfecha_emision_hastaFacturasDescuentosLineas=null;
	public Boolean mostrarfecha_emision_hastaFacturasDescuentosLineas=true;
	public Boolean activarfecha_emision_hastaFacturasDescuentosLineas=true;

	public Border resaltarnombreFacturasDescuentosLineas=null;
	public Boolean mostrarnombreFacturasDescuentosLineas=true;
	public Boolean activarnombreFacturasDescuentosLineas=true;

	public Border resaltarnombre_completo_clienteFacturasDescuentosLineas=null;
	public Boolean mostrarnombre_completo_clienteFacturasDescuentosLineas=true;
	public Boolean activarnombre_completo_clienteFacturasDescuentosLineas=true;

	public Border resaltarnombre_tipo_facturaFacturasDescuentosLineas=null;
	public Boolean mostrarnombre_tipo_facturaFacturasDescuentosLineas=true;
	public Boolean activarnombre_tipo_facturaFacturasDescuentosLineas=true;

	public Border resaltarfecha_emisionFacturasDescuentosLineas=null;
	public Boolean mostrarfecha_emisionFacturasDescuentosLineas=true;
	public Boolean activarfecha_emisionFacturasDescuentosLineas=true;

	public Border resaltarfecha_vencimientoFacturasDescuentosLineas=null;
	public Boolean mostrarfecha_vencimientoFacturasDescuentosLineas=true;
	public Boolean activarfecha_vencimientoFacturasDescuentosLineas=true;

	public Border resaltarnumero_pre_impresoFacturasDescuentosLineas=null;
	public Boolean mostrarnumero_pre_impresoFacturasDescuentosLineas=true;
	public Boolean activarnumero_pre_impresoFacturasDescuentosLineas=true;

	public Border resaltartotal_descuentoFacturasDescuentosLineas=null;
	public Boolean mostrartotal_descuentoFacturasDescuentosLineas=true;
	public Boolean activartotal_descuentoFacturasDescuentosLineas=true;

	public Border resaltartotal_otroFacturasDescuentosLineas=null;
	public Boolean mostrartotal_otroFacturasDescuentosLineas=true;
	public Boolean activartotal_otroFacturasDescuentosLineas=true;

	public Border resaltarsub_totalFacturasDescuentosLineas=null;
	public Boolean mostrarsub_totalFacturasDescuentosLineas=true;
	public Boolean activarsub_totalFacturasDescuentosLineas=true;

	public Border resaltartotalFacturasDescuentosLineas=null;
	public Boolean mostrartotalFacturasDescuentosLineas=true;
	public Boolean activartotalFacturasDescuentosLineas=true;

	public Border resaltarivaFacturasDescuentosLineas=null;
	public Boolean mostrarivaFacturasDescuentosLineas=true;
	public Boolean activarivaFacturasDescuentosLineas=true;

	
	

	public Border setResaltaridFacturasDescuentosLineas(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasDescuentosLineasBeanSwingJInternalFrame facturasdescuentoslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturasdescuentoslineasBeanSwingJInternalFrame.jTtoolBarFacturasDescuentosLineas.setBorder(borderResaltar);
		
		this.resaltaridFacturasDescuentosLineas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridFacturasDescuentosLineas() {
		return this.resaltaridFacturasDescuentosLineas;
	}

	public void setResaltaridFacturasDescuentosLineas(Border borderResaltar) {
		this.resaltaridFacturasDescuentosLineas= borderResaltar;
	}

	public Boolean getMostraridFacturasDescuentosLineas() {
		return this.mostraridFacturasDescuentosLineas;
	}

	public void setMostraridFacturasDescuentosLineas(Boolean mostraridFacturasDescuentosLineas) {
		this.mostraridFacturasDescuentosLineas= mostraridFacturasDescuentosLineas;
	}

	public Boolean getActivaridFacturasDescuentosLineas() {
		return this.activaridFacturasDescuentosLineas;
	}

	public void setActivaridFacturasDescuentosLineas(Boolean activaridFacturasDescuentosLineas) {
		this.activaridFacturasDescuentosLineas= activaridFacturasDescuentosLineas;
	}

	public Border setResaltarid_empresaFacturasDescuentosLineas(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasDescuentosLineasBeanSwingJInternalFrame facturasdescuentoslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturasdescuentoslineasBeanSwingJInternalFrame.jTtoolBarFacturasDescuentosLineas.setBorder(borderResaltar);
		
		this.resaltarid_empresaFacturasDescuentosLineas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaFacturasDescuentosLineas() {
		return this.resaltarid_empresaFacturasDescuentosLineas;
	}

	public void setResaltarid_empresaFacturasDescuentosLineas(Border borderResaltar) {
		this.resaltarid_empresaFacturasDescuentosLineas= borderResaltar;
	}

	public Boolean getMostrarid_empresaFacturasDescuentosLineas() {
		return this.mostrarid_empresaFacturasDescuentosLineas;
	}

	public void setMostrarid_empresaFacturasDescuentosLineas(Boolean mostrarid_empresaFacturasDescuentosLineas) {
		this.mostrarid_empresaFacturasDescuentosLineas= mostrarid_empresaFacturasDescuentosLineas;
	}

	public Boolean getActivarid_empresaFacturasDescuentosLineas() {
		return this.activarid_empresaFacturasDescuentosLineas;
	}

	public void setActivarid_empresaFacturasDescuentosLineas(Boolean activarid_empresaFacturasDescuentosLineas) {
		this.activarid_empresaFacturasDescuentosLineas= activarid_empresaFacturasDescuentosLineas;
	}

	public Boolean getCargarid_empresaFacturasDescuentosLineas() {
		return this.cargarid_empresaFacturasDescuentosLineas;
	}

	public void setCargarid_empresaFacturasDescuentosLineas(Boolean cargarid_empresaFacturasDescuentosLineas) {
		this.cargarid_empresaFacturasDescuentosLineas= cargarid_empresaFacturasDescuentosLineas;
	}

	public Border setResaltarid_sucursalFacturasDescuentosLineas(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasDescuentosLineasBeanSwingJInternalFrame facturasdescuentoslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturasdescuentoslineasBeanSwingJInternalFrame.jTtoolBarFacturasDescuentosLineas.setBorder(borderResaltar);
		
		this.resaltarid_sucursalFacturasDescuentosLineas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalFacturasDescuentosLineas() {
		return this.resaltarid_sucursalFacturasDescuentosLineas;
	}

	public void setResaltarid_sucursalFacturasDescuentosLineas(Border borderResaltar) {
		this.resaltarid_sucursalFacturasDescuentosLineas= borderResaltar;
	}

	public Boolean getMostrarid_sucursalFacturasDescuentosLineas() {
		return this.mostrarid_sucursalFacturasDescuentosLineas;
	}

	public void setMostrarid_sucursalFacturasDescuentosLineas(Boolean mostrarid_sucursalFacturasDescuentosLineas) {
		this.mostrarid_sucursalFacturasDescuentosLineas= mostrarid_sucursalFacturasDescuentosLineas;
	}

	public Boolean getActivarid_sucursalFacturasDescuentosLineas() {
		return this.activarid_sucursalFacturasDescuentosLineas;
	}

	public void setActivarid_sucursalFacturasDescuentosLineas(Boolean activarid_sucursalFacturasDescuentosLineas) {
		this.activarid_sucursalFacturasDescuentosLineas= activarid_sucursalFacturasDescuentosLineas;
	}

	public Boolean getCargarid_sucursalFacturasDescuentosLineas() {
		return this.cargarid_sucursalFacturasDescuentosLineas;
	}

	public void setCargarid_sucursalFacturasDescuentosLineas(Boolean cargarid_sucursalFacturasDescuentosLineas) {
		this.cargarid_sucursalFacturasDescuentosLineas= cargarid_sucursalFacturasDescuentosLineas;
	}

	public Border setResaltarid_vendedorFacturasDescuentosLineas(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasDescuentosLineasBeanSwingJInternalFrame facturasdescuentoslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturasdescuentoslineasBeanSwingJInternalFrame.jTtoolBarFacturasDescuentosLineas.setBorder(borderResaltar);
		
		this.resaltarid_vendedorFacturasDescuentosLineas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_vendedorFacturasDescuentosLineas() {
		return this.resaltarid_vendedorFacturasDescuentosLineas;
	}

	public void setResaltarid_vendedorFacturasDescuentosLineas(Border borderResaltar) {
		this.resaltarid_vendedorFacturasDescuentosLineas= borderResaltar;
	}

	public Boolean getMostrarid_vendedorFacturasDescuentosLineas() {
		return this.mostrarid_vendedorFacturasDescuentosLineas;
	}

	public void setMostrarid_vendedorFacturasDescuentosLineas(Boolean mostrarid_vendedorFacturasDescuentosLineas) {
		this.mostrarid_vendedorFacturasDescuentosLineas= mostrarid_vendedorFacturasDescuentosLineas;
	}

	public Boolean getActivarid_vendedorFacturasDescuentosLineas() {
		return this.activarid_vendedorFacturasDescuentosLineas;
	}

	public void setActivarid_vendedorFacturasDescuentosLineas(Boolean activarid_vendedorFacturasDescuentosLineas) {
		this.activarid_vendedorFacturasDescuentosLineas= activarid_vendedorFacturasDescuentosLineas;
	}

	public Boolean getCargarid_vendedorFacturasDescuentosLineas() {
		return this.cargarid_vendedorFacturasDescuentosLineas;
	}

	public void setCargarid_vendedorFacturasDescuentosLineas(Boolean cargarid_vendedorFacturasDescuentosLineas) {
		this.cargarid_vendedorFacturasDescuentosLineas= cargarid_vendedorFacturasDescuentosLineas;
	}

	public Border setResaltarfecha_emision_desdeFacturasDescuentosLineas(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasDescuentosLineasBeanSwingJInternalFrame facturasdescuentoslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturasdescuentoslineasBeanSwingJInternalFrame.jTtoolBarFacturasDescuentosLineas.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_desdeFacturasDescuentosLineas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_desdeFacturasDescuentosLineas() {
		return this.resaltarfecha_emision_desdeFacturasDescuentosLineas;
	}

	public void setResaltarfecha_emision_desdeFacturasDescuentosLineas(Border borderResaltar) {
		this.resaltarfecha_emision_desdeFacturasDescuentosLineas= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_desdeFacturasDescuentosLineas() {
		return this.mostrarfecha_emision_desdeFacturasDescuentosLineas;
	}

	public void setMostrarfecha_emision_desdeFacturasDescuentosLineas(Boolean mostrarfecha_emision_desdeFacturasDescuentosLineas) {
		this.mostrarfecha_emision_desdeFacturasDescuentosLineas= mostrarfecha_emision_desdeFacturasDescuentosLineas;
	}

	public Boolean getActivarfecha_emision_desdeFacturasDescuentosLineas() {
		return this.activarfecha_emision_desdeFacturasDescuentosLineas;
	}

	public void setActivarfecha_emision_desdeFacturasDescuentosLineas(Boolean activarfecha_emision_desdeFacturasDescuentosLineas) {
		this.activarfecha_emision_desdeFacturasDescuentosLineas= activarfecha_emision_desdeFacturasDescuentosLineas;
	}

	public Border setResaltarfecha_emision_hastaFacturasDescuentosLineas(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasDescuentosLineasBeanSwingJInternalFrame facturasdescuentoslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturasdescuentoslineasBeanSwingJInternalFrame.jTtoolBarFacturasDescuentosLineas.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_hastaFacturasDescuentosLineas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_hastaFacturasDescuentosLineas() {
		return this.resaltarfecha_emision_hastaFacturasDescuentosLineas;
	}

	public void setResaltarfecha_emision_hastaFacturasDescuentosLineas(Border borderResaltar) {
		this.resaltarfecha_emision_hastaFacturasDescuentosLineas= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_hastaFacturasDescuentosLineas() {
		return this.mostrarfecha_emision_hastaFacturasDescuentosLineas;
	}

	public void setMostrarfecha_emision_hastaFacturasDescuentosLineas(Boolean mostrarfecha_emision_hastaFacturasDescuentosLineas) {
		this.mostrarfecha_emision_hastaFacturasDescuentosLineas= mostrarfecha_emision_hastaFacturasDescuentosLineas;
	}

	public Boolean getActivarfecha_emision_hastaFacturasDescuentosLineas() {
		return this.activarfecha_emision_hastaFacturasDescuentosLineas;
	}

	public void setActivarfecha_emision_hastaFacturasDescuentosLineas(Boolean activarfecha_emision_hastaFacturasDescuentosLineas) {
		this.activarfecha_emision_hastaFacturasDescuentosLineas= activarfecha_emision_hastaFacturasDescuentosLineas;
	}

	public Border setResaltarnombreFacturasDescuentosLineas(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasDescuentosLineasBeanSwingJInternalFrame facturasdescuentoslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturasdescuentoslineasBeanSwingJInternalFrame.jTtoolBarFacturasDescuentosLineas.setBorder(borderResaltar);
		
		this.resaltarnombreFacturasDescuentosLineas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreFacturasDescuentosLineas() {
		return this.resaltarnombreFacturasDescuentosLineas;
	}

	public void setResaltarnombreFacturasDescuentosLineas(Border borderResaltar) {
		this.resaltarnombreFacturasDescuentosLineas= borderResaltar;
	}

	public Boolean getMostrarnombreFacturasDescuentosLineas() {
		return this.mostrarnombreFacturasDescuentosLineas;
	}

	public void setMostrarnombreFacturasDescuentosLineas(Boolean mostrarnombreFacturasDescuentosLineas) {
		this.mostrarnombreFacturasDescuentosLineas= mostrarnombreFacturasDescuentosLineas;
	}

	public Boolean getActivarnombreFacturasDescuentosLineas() {
		return this.activarnombreFacturasDescuentosLineas;
	}

	public void setActivarnombreFacturasDescuentosLineas(Boolean activarnombreFacturasDescuentosLineas) {
		this.activarnombreFacturasDescuentosLineas= activarnombreFacturasDescuentosLineas;
	}

	public Border setResaltarnombre_completo_clienteFacturasDescuentosLineas(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasDescuentosLineasBeanSwingJInternalFrame facturasdescuentoslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturasdescuentoslineasBeanSwingJInternalFrame.jTtoolBarFacturasDescuentosLineas.setBorder(borderResaltar);
		
		this.resaltarnombre_completo_clienteFacturasDescuentosLineas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_completo_clienteFacturasDescuentosLineas() {
		return this.resaltarnombre_completo_clienteFacturasDescuentosLineas;
	}

	public void setResaltarnombre_completo_clienteFacturasDescuentosLineas(Border borderResaltar) {
		this.resaltarnombre_completo_clienteFacturasDescuentosLineas= borderResaltar;
	}

	public Boolean getMostrarnombre_completo_clienteFacturasDescuentosLineas() {
		return this.mostrarnombre_completo_clienteFacturasDescuentosLineas;
	}

	public void setMostrarnombre_completo_clienteFacturasDescuentosLineas(Boolean mostrarnombre_completo_clienteFacturasDescuentosLineas) {
		this.mostrarnombre_completo_clienteFacturasDescuentosLineas= mostrarnombre_completo_clienteFacturasDescuentosLineas;
	}

	public Boolean getActivarnombre_completo_clienteFacturasDescuentosLineas() {
		return this.activarnombre_completo_clienteFacturasDescuentosLineas;
	}

	public void setActivarnombre_completo_clienteFacturasDescuentosLineas(Boolean activarnombre_completo_clienteFacturasDescuentosLineas) {
		this.activarnombre_completo_clienteFacturasDescuentosLineas= activarnombre_completo_clienteFacturasDescuentosLineas;
	}

	public Border setResaltarnombre_tipo_facturaFacturasDescuentosLineas(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasDescuentosLineasBeanSwingJInternalFrame facturasdescuentoslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturasdescuentoslineasBeanSwingJInternalFrame.jTtoolBarFacturasDescuentosLineas.setBorder(borderResaltar);
		
		this.resaltarnombre_tipo_facturaFacturasDescuentosLineas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_tipo_facturaFacturasDescuentosLineas() {
		return this.resaltarnombre_tipo_facturaFacturasDescuentosLineas;
	}

	public void setResaltarnombre_tipo_facturaFacturasDescuentosLineas(Border borderResaltar) {
		this.resaltarnombre_tipo_facturaFacturasDescuentosLineas= borderResaltar;
	}

	public Boolean getMostrarnombre_tipo_facturaFacturasDescuentosLineas() {
		return this.mostrarnombre_tipo_facturaFacturasDescuentosLineas;
	}

	public void setMostrarnombre_tipo_facturaFacturasDescuentosLineas(Boolean mostrarnombre_tipo_facturaFacturasDescuentosLineas) {
		this.mostrarnombre_tipo_facturaFacturasDescuentosLineas= mostrarnombre_tipo_facturaFacturasDescuentosLineas;
	}

	public Boolean getActivarnombre_tipo_facturaFacturasDescuentosLineas() {
		return this.activarnombre_tipo_facturaFacturasDescuentosLineas;
	}

	public void setActivarnombre_tipo_facturaFacturasDescuentosLineas(Boolean activarnombre_tipo_facturaFacturasDescuentosLineas) {
		this.activarnombre_tipo_facturaFacturasDescuentosLineas= activarnombre_tipo_facturaFacturasDescuentosLineas;
	}

	public Border setResaltarfecha_emisionFacturasDescuentosLineas(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasDescuentosLineasBeanSwingJInternalFrame facturasdescuentoslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturasdescuentoslineasBeanSwingJInternalFrame.jTtoolBarFacturasDescuentosLineas.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionFacturasDescuentosLineas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionFacturasDescuentosLineas() {
		return this.resaltarfecha_emisionFacturasDescuentosLineas;
	}

	public void setResaltarfecha_emisionFacturasDescuentosLineas(Border borderResaltar) {
		this.resaltarfecha_emisionFacturasDescuentosLineas= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionFacturasDescuentosLineas() {
		return this.mostrarfecha_emisionFacturasDescuentosLineas;
	}

	public void setMostrarfecha_emisionFacturasDescuentosLineas(Boolean mostrarfecha_emisionFacturasDescuentosLineas) {
		this.mostrarfecha_emisionFacturasDescuentosLineas= mostrarfecha_emisionFacturasDescuentosLineas;
	}

	public Boolean getActivarfecha_emisionFacturasDescuentosLineas() {
		return this.activarfecha_emisionFacturasDescuentosLineas;
	}

	public void setActivarfecha_emisionFacturasDescuentosLineas(Boolean activarfecha_emisionFacturasDescuentosLineas) {
		this.activarfecha_emisionFacturasDescuentosLineas= activarfecha_emisionFacturasDescuentosLineas;
	}

	public Border setResaltarfecha_vencimientoFacturasDescuentosLineas(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasDescuentosLineasBeanSwingJInternalFrame facturasdescuentoslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturasdescuentoslineasBeanSwingJInternalFrame.jTtoolBarFacturasDescuentosLineas.setBorder(borderResaltar);
		
		this.resaltarfecha_vencimientoFacturasDescuentosLineas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_vencimientoFacturasDescuentosLineas() {
		return this.resaltarfecha_vencimientoFacturasDescuentosLineas;
	}

	public void setResaltarfecha_vencimientoFacturasDescuentosLineas(Border borderResaltar) {
		this.resaltarfecha_vencimientoFacturasDescuentosLineas= borderResaltar;
	}

	public Boolean getMostrarfecha_vencimientoFacturasDescuentosLineas() {
		return this.mostrarfecha_vencimientoFacturasDescuentosLineas;
	}

	public void setMostrarfecha_vencimientoFacturasDescuentosLineas(Boolean mostrarfecha_vencimientoFacturasDescuentosLineas) {
		this.mostrarfecha_vencimientoFacturasDescuentosLineas= mostrarfecha_vencimientoFacturasDescuentosLineas;
	}

	public Boolean getActivarfecha_vencimientoFacturasDescuentosLineas() {
		return this.activarfecha_vencimientoFacturasDescuentosLineas;
	}

	public void setActivarfecha_vencimientoFacturasDescuentosLineas(Boolean activarfecha_vencimientoFacturasDescuentosLineas) {
		this.activarfecha_vencimientoFacturasDescuentosLineas= activarfecha_vencimientoFacturasDescuentosLineas;
	}

	public Border setResaltarnumero_pre_impresoFacturasDescuentosLineas(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasDescuentosLineasBeanSwingJInternalFrame facturasdescuentoslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturasdescuentoslineasBeanSwingJInternalFrame.jTtoolBarFacturasDescuentosLineas.setBorder(borderResaltar);
		
		this.resaltarnumero_pre_impresoFacturasDescuentosLineas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_pre_impresoFacturasDescuentosLineas() {
		return this.resaltarnumero_pre_impresoFacturasDescuentosLineas;
	}

	public void setResaltarnumero_pre_impresoFacturasDescuentosLineas(Border borderResaltar) {
		this.resaltarnumero_pre_impresoFacturasDescuentosLineas= borderResaltar;
	}

	public Boolean getMostrarnumero_pre_impresoFacturasDescuentosLineas() {
		return this.mostrarnumero_pre_impresoFacturasDescuentosLineas;
	}

	public void setMostrarnumero_pre_impresoFacturasDescuentosLineas(Boolean mostrarnumero_pre_impresoFacturasDescuentosLineas) {
		this.mostrarnumero_pre_impresoFacturasDescuentosLineas= mostrarnumero_pre_impresoFacturasDescuentosLineas;
	}

	public Boolean getActivarnumero_pre_impresoFacturasDescuentosLineas() {
		return this.activarnumero_pre_impresoFacturasDescuentosLineas;
	}

	public void setActivarnumero_pre_impresoFacturasDescuentosLineas(Boolean activarnumero_pre_impresoFacturasDescuentosLineas) {
		this.activarnumero_pre_impresoFacturasDescuentosLineas= activarnumero_pre_impresoFacturasDescuentosLineas;
	}

	public Border setResaltartotal_descuentoFacturasDescuentosLineas(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasDescuentosLineasBeanSwingJInternalFrame facturasdescuentoslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturasdescuentoslineasBeanSwingJInternalFrame.jTtoolBarFacturasDescuentosLineas.setBorder(borderResaltar);
		
		this.resaltartotal_descuentoFacturasDescuentosLineas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_descuentoFacturasDescuentosLineas() {
		return this.resaltartotal_descuentoFacturasDescuentosLineas;
	}

	public void setResaltartotal_descuentoFacturasDescuentosLineas(Border borderResaltar) {
		this.resaltartotal_descuentoFacturasDescuentosLineas= borderResaltar;
	}

	public Boolean getMostrartotal_descuentoFacturasDescuentosLineas() {
		return this.mostrartotal_descuentoFacturasDescuentosLineas;
	}

	public void setMostrartotal_descuentoFacturasDescuentosLineas(Boolean mostrartotal_descuentoFacturasDescuentosLineas) {
		this.mostrartotal_descuentoFacturasDescuentosLineas= mostrartotal_descuentoFacturasDescuentosLineas;
	}

	public Boolean getActivartotal_descuentoFacturasDescuentosLineas() {
		return this.activartotal_descuentoFacturasDescuentosLineas;
	}

	public void setActivartotal_descuentoFacturasDescuentosLineas(Boolean activartotal_descuentoFacturasDescuentosLineas) {
		this.activartotal_descuentoFacturasDescuentosLineas= activartotal_descuentoFacturasDescuentosLineas;
	}

	public Border setResaltartotal_otroFacturasDescuentosLineas(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasDescuentosLineasBeanSwingJInternalFrame facturasdescuentoslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturasdescuentoslineasBeanSwingJInternalFrame.jTtoolBarFacturasDescuentosLineas.setBorder(borderResaltar);
		
		this.resaltartotal_otroFacturasDescuentosLineas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_otroFacturasDescuentosLineas() {
		return this.resaltartotal_otroFacturasDescuentosLineas;
	}

	public void setResaltartotal_otroFacturasDescuentosLineas(Border borderResaltar) {
		this.resaltartotal_otroFacturasDescuentosLineas= borderResaltar;
	}

	public Boolean getMostrartotal_otroFacturasDescuentosLineas() {
		return this.mostrartotal_otroFacturasDescuentosLineas;
	}

	public void setMostrartotal_otroFacturasDescuentosLineas(Boolean mostrartotal_otroFacturasDescuentosLineas) {
		this.mostrartotal_otroFacturasDescuentosLineas= mostrartotal_otroFacturasDescuentosLineas;
	}

	public Boolean getActivartotal_otroFacturasDescuentosLineas() {
		return this.activartotal_otroFacturasDescuentosLineas;
	}

	public void setActivartotal_otroFacturasDescuentosLineas(Boolean activartotal_otroFacturasDescuentosLineas) {
		this.activartotal_otroFacturasDescuentosLineas= activartotal_otroFacturasDescuentosLineas;
	}

	public Border setResaltarsub_totalFacturasDescuentosLineas(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasDescuentosLineasBeanSwingJInternalFrame facturasdescuentoslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturasdescuentoslineasBeanSwingJInternalFrame.jTtoolBarFacturasDescuentosLineas.setBorder(borderResaltar);
		
		this.resaltarsub_totalFacturasDescuentosLineas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsub_totalFacturasDescuentosLineas() {
		return this.resaltarsub_totalFacturasDescuentosLineas;
	}

	public void setResaltarsub_totalFacturasDescuentosLineas(Border borderResaltar) {
		this.resaltarsub_totalFacturasDescuentosLineas= borderResaltar;
	}

	public Boolean getMostrarsub_totalFacturasDescuentosLineas() {
		return this.mostrarsub_totalFacturasDescuentosLineas;
	}

	public void setMostrarsub_totalFacturasDescuentosLineas(Boolean mostrarsub_totalFacturasDescuentosLineas) {
		this.mostrarsub_totalFacturasDescuentosLineas= mostrarsub_totalFacturasDescuentosLineas;
	}

	public Boolean getActivarsub_totalFacturasDescuentosLineas() {
		return this.activarsub_totalFacturasDescuentosLineas;
	}

	public void setActivarsub_totalFacturasDescuentosLineas(Boolean activarsub_totalFacturasDescuentosLineas) {
		this.activarsub_totalFacturasDescuentosLineas= activarsub_totalFacturasDescuentosLineas;
	}

	public Border setResaltartotalFacturasDescuentosLineas(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasDescuentosLineasBeanSwingJInternalFrame facturasdescuentoslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturasdescuentoslineasBeanSwingJInternalFrame.jTtoolBarFacturasDescuentosLineas.setBorder(borderResaltar);
		
		this.resaltartotalFacturasDescuentosLineas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalFacturasDescuentosLineas() {
		return this.resaltartotalFacturasDescuentosLineas;
	}

	public void setResaltartotalFacturasDescuentosLineas(Border borderResaltar) {
		this.resaltartotalFacturasDescuentosLineas= borderResaltar;
	}

	public Boolean getMostrartotalFacturasDescuentosLineas() {
		return this.mostrartotalFacturasDescuentosLineas;
	}

	public void setMostrartotalFacturasDescuentosLineas(Boolean mostrartotalFacturasDescuentosLineas) {
		this.mostrartotalFacturasDescuentosLineas= mostrartotalFacturasDescuentosLineas;
	}

	public Boolean getActivartotalFacturasDescuentosLineas() {
		return this.activartotalFacturasDescuentosLineas;
	}

	public void setActivartotalFacturasDescuentosLineas(Boolean activartotalFacturasDescuentosLineas) {
		this.activartotalFacturasDescuentosLineas= activartotalFacturasDescuentosLineas;
	}

	public Border setResaltarivaFacturasDescuentosLineas(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasDescuentosLineasBeanSwingJInternalFrame facturasdescuentoslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//facturasdescuentoslineasBeanSwingJInternalFrame.jTtoolBarFacturasDescuentosLineas.setBorder(borderResaltar);
		
		this.resaltarivaFacturasDescuentosLineas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarivaFacturasDescuentosLineas() {
		return this.resaltarivaFacturasDescuentosLineas;
	}

	public void setResaltarivaFacturasDescuentosLineas(Border borderResaltar) {
		this.resaltarivaFacturasDescuentosLineas= borderResaltar;
	}

	public Boolean getMostrarivaFacturasDescuentosLineas() {
		return this.mostrarivaFacturasDescuentosLineas;
	}

	public void setMostrarivaFacturasDescuentosLineas(Boolean mostrarivaFacturasDescuentosLineas) {
		this.mostrarivaFacturasDescuentosLineas= mostrarivaFacturasDescuentosLineas;
	}

	public Boolean getActivarivaFacturasDescuentosLineas() {
		return this.activarivaFacturasDescuentosLineas;
	}

	public void setActivarivaFacturasDescuentosLineas(Boolean activarivaFacturasDescuentosLineas) {
		this.activarivaFacturasDescuentosLineas= activarivaFacturasDescuentosLineas;
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
		
		
		this.setMostraridFacturasDescuentosLineas(esInicial);
		this.setMostrarid_empresaFacturasDescuentosLineas(esInicial);
		this.setMostrarid_sucursalFacturasDescuentosLineas(esInicial);
		this.setMostrarid_vendedorFacturasDescuentosLineas(esInicial);
		this.setMostrarfecha_emision_desdeFacturasDescuentosLineas(esInicial);
		this.setMostrarfecha_emision_hastaFacturasDescuentosLineas(esInicial);
		this.setMostrarnombreFacturasDescuentosLineas(esInicial);
		this.setMostrarnombre_completo_clienteFacturasDescuentosLineas(esInicial);
		this.setMostrarnombre_tipo_facturaFacturasDescuentosLineas(esInicial);
		this.setMostrarfecha_emisionFacturasDescuentosLineas(esInicial);
		this.setMostrarfecha_vencimientoFacturasDescuentosLineas(esInicial);
		this.setMostrarnumero_pre_impresoFacturasDescuentosLineas(esInicial);
		this.setMostrartotal_descuentoFacturasDescuentosLineas(esInicial);
		this.setMostrartotal_otroFacturasDescuentosLineas(esInicial);
		this.setMostrarsub_totalFacturasDescuentosLineas(esInicial);
		this.setMostrartotalFacturasDescuentosLineas(esInicial);
		this.setMostrarivaFacturasDescuentosLineas(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FacturasDescuentosLineasConstantesFunciones.ID)) {
				this.setMostraridFacturasDescuentosLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasDescuentosLineasConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaFacturasDescuentosLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasDescuentosLineasConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalFacturasDescuentosLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasDescuentosLineasConstantesFunciones.IDVENDEDOR)) {
				this.setMostrarid_vendedorFacturasDescuentosLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasDescuentosLineasConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setMostrarfecha_emision_desdeFacturasDescuentosLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasDescuentosLineasConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setMostrarfecha_emision_hastaFacturasDescuentosLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasDescuentosLineasConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreFacturasDescuentosLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasDescuentosLineasConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setMostrarnombre_completo_clienteFacturasDescuentosLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasDescuentosLineasConstantesFunciones.NOMBRETIPOFACTURA)) {
				this.setMostrarnombre_tipo_facturaFacturasDescuentosLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasDescuentosLineasConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionFacturasDescuentosLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasDescuentosLineasConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setMostrarfecha_vencimientoFacturasDescuentosLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasDescuentosLineasConstantesFunciones.NUMEROPREIMPRESO)) {
				this.setMostrarnumero_pre_impresoFacturasDescuentosLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasDescuentosLineasConstantesFunciones.TOTALDESCUENTO)) {
				this.setMostrartotal_descuentoFacturasDescuentosLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasDescuentosLineasConstantesFunciones.TOTALOTRO)) {
				this.setMostrartotal_otroFacturasDescuentosLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasDescuentosLineasConstantesFunciones.SUBTOTAL)) {
				this.setMostrarsub_totalFacturasDescuentosLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasDescuentosLineasConstantesFunciones.TOTAL)) {
				this.setMostrartotalFacturasDescuentosLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasDescuentosLineasConstantesFunciones.IVA)) {
				this.setMostrarivaFacturasDescuentosLineas(esAsigna);
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
		
		
		this.setActivaridFacturasDescuentosLineas(esInicial);
		this.setActivarid_empresaFacturasDescuentosLineas(esInicial);
		this.setActivarid_sucursalFacturasDescuentosLineas(esInicial);
		this.setActivarid_vendedorFacturasDescuentosLineas(esInicial);
		this.setActivarfecha_emision_desdeFacturasDescuentosLineas(esInicial);
		this.setActivarfecha_emision_hastaFacturasDescuentosLineas(esInicial);
		this.setActivarnombreFacturasDescuentosLineas(esInicial);
		this.setActivarnombre_completo_clienteFacturasDescuentosLineas(esInicial);
		this.setActivarnombre_tipo_facturaFacturasDescuentosLineas(esInicial);
		this.setActivarfecha_emisionFacturasDescuentosLineas(esInicial);
		this.setActivarfecha_vencimientoFacturasDescuentosLineas(esInicial);
		this.setActivarnumero_pre_impresoFacturasDescuentosLineas(esInicial);
		this.setActivartotal_descuentoFacturasDescuentosLineas(esInicial);
		this.setActivartotal_otroFacturasDescuentosLineas(esInicial);
		this.setActivarsub_totalFacturasDescuentosLineas(esInicial);
		this.setActivartotalFacturasDescuentosLineas(esInicial);
		this.setActivarivaFacturasDescuentosLineas(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FacturasDescuentosLineasConstantesFunciones.ID)) {
				this.setActivaridFacturasDescuentosLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasDescuentosLineasConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaFacturasDescuentosLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasDescuentosLineasConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalFacturasDescuentosLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasDescuentosLineasConstantesFunciones.IDVENDEDOR)) {
				this.setActivarid_vendedorFacturasDescuentosLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasDescuentosLineasConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setActivarfecha_emision_desdeFacturasDescuentosLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasDescuentosLineasConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setActivarfecha_emision_hastaFacturasDescuentosLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasDescuentosLineasConstantesFunciones.NOMBRE)) {
				this.setActivarnombreFacturasDescuentosLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasDescuentosLineasConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setActivarnombre_completo_clienteFacturasDescuentosLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasDescuentosLineasConstantesFunciones.NOMBRETIPOFACTURA)) {
				this.setActivarnombre_tipo_facturaFacturasDescuentosLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasDescuentosLineasConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionFacturasDescuentosLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasDescuentosLineasConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setActivarfecha_vencimientoFacturasDescuentosLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasDescuentosLineasConstantesFunciones.NUMEROPREIMPRESO)) {
				this.setActivarnumero_pre_impresoFacturasDescuentosLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasDescuentosLineasConstantesFunciones.TOTALDESCUENTO)) {
				this.setActivartotal_descuentoFacturasDescuentosLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasDescuentosLineasConstantesFunciones.TOTALOTRO)) {
				this.setActivartotal_otroFacturasDescuentosLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasDescuentosLineasConstantesFunciones.SUBTOTAL)) {
				this.setActivarsub_totalFacturasDescuentosLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasDescuentosLineasConstantesFunciones.TOTAL)) {
				this.setActivartotalFacturasDescuentosLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasDescuentosLineasConstantesFunciones.IVA)) {
				this.setActivarivaFacturasDescuentosLineas(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,FacturasDescuentosLineasBeanSwingJInternalFrame facturasdescuentoslineasBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridFacturasDescuentosLineas(esInicial);
		this.setResaltarid_empresaFacturasDescuentosLineas(esInicial);
		this.setResaltarid_sucursalFacturasDescuentosLineas(esInicial);
		this.setResaltarid_vendedorFacturasDescuentosLineas(esInicial);
		this.setResaltarfecha_emision_desdeFacturasDescuentosLineas(esInicial);
		this.setResaltarfecha_emision_hastaFacturasDescuentosLineas(esInicial);
		this.setResaltarnombreFacturasDescuentosLineas(esInicial);
		this.setResaltarnombre_completo_clienteFacturasDescuentosLineas(esInicial);
		this.setResaltarnombre_tipo_facturaFacturasDescuentosLineas(esInicial);
		this.setResaltarfecha_emisionFacturasDescuentosLineas(esInicial);
		this.setResaltarfecha_vencimientoFacturasDescuentosLineas(esInicial);
		this.setResaltarnumero_pre_impresoFacturasDescuentosLineas(esInicial);
		this.setResaltartotal_descuentoFacturasDescuentosLineas(esInicial);
		this.setResaltartotal_otroFacturasDescuentosLineas(esInicial);
		this.setResaltarsub_totalFacturasDescuentosLineas(esInicial);
		this.setResaltartotalFacturasDescuentosLineas(esInicial);
		this.setResaltarivaFacturasDescuentosLineas(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(FacturasDescuentosLineasConstantesFunciones.ID)) {
				this.setResaltaridFacturasDescuentosLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasDescuentosLineasConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaFacturasDescuentosLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasDescuentosLineasConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalFacturasDescuentosLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasDescuentosLineasConstantesFunciones.IDVENDEDOR)) {
				this.setResaltarid_vendedorFacturasDescuentosLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasDescuentosLineasConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setResaltarfecha_emision_desdeFacturasDescuentosLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasDescuentosLineasConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setResaltarfecha_emision_hastaFacturasDescuentosLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasDescuentosLineasConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreFacturasDescuentosLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasDescuentosLineasConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setResaltarnombre_completo_clienteFacturasDescuentosLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasDescuentosLineasConstantesFunciones.NOMBRETIPOFACTURA)) {
				this.setResaltarnombre_tipo_facturaFacturasDescuentosLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasDescuentosLineasConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionFacturasDescuentosLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasDescuentosLineasConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setResaltarfecha_vencimientoFacturasDescuentosLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasDescuentosLineasConstantesFunciones.NUMEROPREIMPRESO)) {
				this.setResaltarnumero_pre_impresoFacturasDescuentosLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasDescuentosLineasConstantesFunciones.TOTALDESCUENTO)) {
				this.setResaltartotal_descuentoFacturasDescuentosLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasDescuentosLineasConstantesFunciones.TOTALOTRO)) {
				this.setResaltartotal_otroFacturasDescuentosLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasDescuentosLineasConstantesFunciones.SUBTOTAL)) {
				this.setResaltarsub_totalFacturasDescuentosLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasDescuentosLineasConstantesFunciones.TOTAL)) {
				this.setResaltartotalFacturasDescuentosLineas(esAsigna);
				continue;
			}

			if(campo.clase.equals(FacturasDescuentosLineasConstantesFunciones.IVA)) {
				this.setResaltarivaFacturasDescuentosLineas(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,FacturasDescuentosLineasBeanSwingJInternalFrame facturasdescuentoslineasBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaFacturasDescuentosLineasFacturasDescuentosLineas=true;

	public Boolean getMostrarBusquedaFacturasDescuentosLineasFacturasDescuentosLineas() {
		return this.mostrarBusquedaFacturasDescuentosLineasFacturasDescuentosLineas;
	}

	public void setMostrarBusquedaFacturasDescuentosLineasFacturasDescuentosLineas(Boolean visibilidadResaltar) {
		this.mostrarBusquedaFacturasDescuentosLineasFacturasDescuentosLineas= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaFacturasDescuentosLineasFacturasDescuentosLineas=true;

	public Boolean getActivarBusquedaFacturasDescuentosLineasFacturasDescuentosLineas() {
		return this.activarBusquedaFacturasDescuentosLineasFacturasDescuentosLineas;
	}

	public void setActivarBusquedaFacturasDescuentosLineasFacturasDescuentosLineas(Boolean habilitarResaltar) {
		this.activarBusquedaFacturasDescuentosLineasFacturasDescuentosLineas= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaFacturasDescuentosLineasFacturasDescuentosLineas=null;

	public Border getResaltarBusquedaFacturasDescuentosLineasFacturasDescuentosLineas() {
		return this.resaltarBusquedaFacturasDescuentosLineasFacturasDescuentosLineas;
	}

	public void setResaltarBusquedaFacturasDescuentosLineasFacturasDescuentosLineas(Border borderResaltar) {
		this.resaltarBusquedaFacturasDescuentosLineasFacturasDescuentosLineas= borderResaltar;
	}

	public void setResaltarBusquedaFacturasDescuentosLineasFacturasDescuentosLineas(ParametroGeneralUsuario parametroGeneralUsuario/*FacturasDescuentosLineasBeanSwingJInternalFrame facturasdescuentoslineasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaFacturasDescuentosLineasFacturasDescuentosLineas= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}