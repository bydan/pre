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


import com.bydan.erp.facturacion.util.report.GuiasRemisionesConstantesFunciones;
import com.bydan.erp.facturacion.util.report.GuiasRemisionesParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.report.GuiasRemisionesParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.facturacion.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class GuiasRemisionesConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="GuiasRemisiones";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="GuiasRemisiones"+GuiasRemisionesConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="GuiasRemisionesHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="GuiasRemisionesHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=GuiasRemisionesConstantesFunciones.SCHEMA+"_"+GuiasRemisionesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/GuiasRemisionesHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=GuiasRemisionesConstantesFunciones.SCHEMA+"_"+GuiasRemisionesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=GuiasRemisionesConstantesFunciones.SCHEMA+"_"+GuiasRemisionesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/GuiasRemisionesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=GuiasRemisionesConstantesFunciones.SCHEMA+"_"+GuiasRemisionesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+GuiasRemisionesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/GuiasRemisionesHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+GuiasRemisionesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+GuiasRemisionesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/GuiasRemisionesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+GuiasRemisionesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=GuiasRemisionesConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+GuiasRemisionesConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=GuiasRemisionesConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+GuiasRemisionesConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Guias Remisioneses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Guias Remisiones";
	public static final String SCLASSWEBTITULO_LOWER="Guias Remisiones";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="GuiasRemisiones";
	public static final String OBJECTNAME="guiasremisiones";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="guias_remisiones";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select guiasremisiones from "+GuiasRemisionesConstantesFunciones.SPERSISTENCENAME+" guiasremisiones";
	public static String QUERYSELECTNATIVE="select "+GuiasRemisionesConstantesFunciones.SCHEMA+"."+GuiasRemisionesConstantesFunciones.TABLENAME+".id,"+GuiasRemisionesConstantesFunciones.SCHEMA+"."+GuiasRemisionesConstantesFunciones.TABLENAME+".version_row,"+GuiasRemisionesConstantesFunciones.SCHEMA+"."+GuiasRemisionesConstantesFunciones.TABLENAME+".id_empresa,"+GuiasRemisionesConstantesFunciones.SCHEMA+"."+GuiasRemisionesConstantesFunciones.TABLENAME+".fecha_emision_desde,"+GuiasRemisionesConstantesFunciones.SCHEMA+"."+GuiasRemisionesConstantesFunciones.TABLENAME+".fecha_emision_hasta,"+GuiasRemisionesConstantesFunciones.SCHEMA+"."+GuiasRemisionesConstantesFunciones.TABLENAME+".nombre_completo_cliente,"+GuiasRemisionesConstantesFunciones.SCHEMA+"."+GuiasRemisionesConstantesFunciones.TABLENAME+".numero_pre_impreso_factura,"+GuiasRemisionesConstantesFunciones.SCHEMA+"."+GuiasRemisionesConstantesFunciones.TABLENAME+".secuencial,"+GuiasRemisionesConstantesFunciones.SCHEMA+"."+GuiasRemisionesConstantesFunciones.TABLENAME+".fecha_emision,"+GuiasRemisionesConstantesFunciones.SCHEMA+"."+GuiasRemisionesConstantesFunciones.TABLENAME+".fecha_vencimiento,"+GuiasRemisionesConstantesFunciones.SCHEMA+"."+GuiasRemisionesConstantesFunciones.TABLENAME+".nombre_tipo_transporte,"+GuiasRemisionesConstantesFunciones.SCHEMA+"."+GuiasRemisionesConstantesFunciones.TABLENAME+".iva,"+GuiasRemisionesConstantesFunciones.SCHEMA+"."+GuiasRemisionesConstantesFunciones.TABLENAME+".descuento,"+GuiasRemisionesConstantesFunciones.SCHEMA+"."+GuiasRemisionesConstantesFunciones.TABLENAME+".otro,"+GuiasRemisionesConstantesFunciones.SCHEMA+"."+GuiasRemisionesConstantesFunciones.TABLENAME+".total from "+GuiasRemisionesConstantesFunciones.SCHEMA+"."+GuiasRemisionesConstantesFunciones.TABLENAME;//+" as "+GuiasRemisionesConstantesFunciones.TABLENAME;
	
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
    public static final String NOMBRECOMPLETOCLIENTE= "nombre_completo_cliente";
    public static final String NUMEROPREIMPRESOFACTURA= "numero_pre_impreso_factura";
    public static final String SECUENCIAL= "secuencial";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String FECHAVENCIMIENTO= "fecha_vencimiento";
    public static final String NOMBRETIPOTRANSPORTE= "nombre_tipo_transporte";
    public static final String IVA= "iva";
    public static final String DESCUENTO= "descuento";
    public static final String OTRO= "otro";
    public static final String TOTAL= "total";
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
    	public static final String LABEL_NOMBRECOMPLETOCLIENTE= "Nombre Completo Cliente";
		public static final String LABEL_NOMBRECOMPLETOCLIENTE_LOWER= "Nombre Completo Cliente";
    	public static final String LABEL_NUMEROPREIMPRESOFACTURA= "Numero Pre Impreso Factura";
		public static final String LABEL_NUMEROPREIMPRESOFACTURA_LOWER= "Numero Pre Impreso Factura";
    	public static final String LABEL_SECUENCIAL= "Secuencial";
		public static final String LABEL_SECUENCIAL_LOWER= "Secuencial";
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
    	public static final String LABEL_FECHAVENCIMIENTO= "Fecha Vencimiento";
		public static final String LABEL_FECHAVENCIMIENTO_LOWER= "Fecha Vencimiento";
    	public static final String LABEL_NOMBRETIPOTRANSPORTE= "Nombre Tipo Transporte";
		public static final String LABEL_NOMBRETIPOTRANSPORTE_LOWER= "Nombre Tipo Transporte";
    	public static final String LABEL_IVA= "Iva";
		public static final String LABEL_IVA_LOWER= "Iva";
    	public static final String LABEL_DESCUENTO= "Descuento";
		public static final String LABEL_DESCUENTO_LOWER= "Descuento";
    	public static final String LABEL_OTRO= "Otro";
		public static final String LABEL_OTRO_LOWER= "Otro";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
	
		
		
		
		
		
	public static final String SREGEXNOMBRE_COMPLETO_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_COMPLETO_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_PRE_IMPRESO_FACTURA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_PRE_IMPRESO_FACTURA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXSECUENCIAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSECUENCIAL=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXNOMBRE_TIPO_TRANSPORTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_TIPO_TRANSPORTE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
	
	public static String getGuiasRemisionesLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(GuiasRemisionesConstantesFunciones.IDEMPRESA)) {sLabelColumna=GuiasRemisionesConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(GuiasRemisionesConstantesFunciones.FECHAEMISIONDESDE)) {sLabelColumna=GuiasRemisionesConstantesFunciones.LABEL_FECHAEMISIONDESDE;}
		if(sNombreColumna.equals(GuiasRemisionesConstantesFunciones.FECHAEMISIONHASTA)) {sLabelColumna=GuiasRemisionesConstantesFunciones.LABEL_FECHAEMISIONHASTA;}
		if(sNombreColumna.equals(GuiasRemisionesConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {sLabelColumna=GuiasRemisionesConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE;}
		if(sNombreColumna.equals(GuiasRemisionesConstantesFunciones.NUMEROPREIMPRESOFACTURA)) {sLabelColumna=GuiasRemisionesConstantesFunciones.LABEL_NUMEROPREIMPRESOFACTURA;}
		if(sNombreColumna.equals(GuiasRemisionesConstantesFunciones.SECUENCIAL)) {sLabelColumna=GuiasRemisionesConstantesFunciones.LABEL_SECUENCIAL;}
		if(sNombreColumna.equals(GuiasRemisionesConstantesFunciones.FECHAEMISION)) {sLabelColumna=GuiasRemisionesConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(GuiasRemisionesConstantesFunciones.FECHAVENCIMIENTO)) {sLabelColumna=GuiasRemisionesConstantesFunciones.LABEL_FECHAVENCIMIENTO;}
		if(sNombreColumna.equals(GuiasRemisionesConstantesFunciones.NOMBRETIPOTRANSPORTE)) {sLabelColumna=GuiasRemisionesConstantesFunciones.LABEL_NOMBRETIPOTRANSPORTE;}
		if(sNombreColumna.equals(GuiasRemisionesConstantesFunciones.IVA)) {sLabelColumna=GuiasRemisionesConstantesFunciones.LABEL_IVA;}
		if(sNombreColumna.equals(GuiasRemisionesConstantesFunciones.DESCUENTO)) {sLabelColumna=GuiasRemisionesConstantesFunciones.LABEL_DESCUENTO;}
		if(sNombreColumna.equals(GuiasRemisionesConstantesFunciones.OTRO)) {sLabelColumna=GuiasRemisionesConstantesFunciones.LABEL_OTRO;}
		if(sNombreColumna.equals(GuiasRemisionesConstantesFunciones.TOTAL)) {sLabelColumna=GuiasRemisionesConstantesFunciones.LABEL_TOTAL;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getGuiasRemisionesDescripcion(GuiasRemisiones guiasremisiones) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(guiasremisiones !=null/* && guiasremisiones.getId()!=0*/) {
			sDescripcion=guiasremisiones.getfecha_emision_hasta().toString();//guiasremisionesguiasremisiones.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getGuiasRemisionesDescripcionDetallado(GuiasRemisiones guiasremisiones) {
		String sDescripcion="";
			
		sDescripcion+=GuiasRemisionesConstantesFunciones.ID+"=";
		sDescripcion+=guiasremisiones.getId().toString()+",";
		sDescripcion+=GuiasRemisionesConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=guiasremisiones.getVersionRow().toString()+",";
		sDescripcion+=GuiasRemisionesConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=guiasremisiones.getid_empresa().toString()+",";
		sDescripcion+=GuiasRemisionesConstantesFunciones.FECHAEMISIONDESDE+"=";
		sDescripcion+=guiasremisiones.getfecha_emision_desde().toString()+",";
		sDescripcion+=GuiasRemisionesConstantesFunciones.FECHAEMISIONHASTA+"=";
		sDescripcion+=guiasremisiones.getfecha_emision_hasta().toString()+",";
		sDescripcion+=GuiasRemisionesConstantesFunciones.NOMBRECOMPLETOCLIENTE+"=";
		sDescripcion+=guiasremisiones.getnombre_completo_cliente()+",";
		sDescripcion+=GuiasRemisionesConstantesFunciones.NUMEROPREIMPRESOFACTURA+"=";
		sDescripcion+=guiasremisiones.getnumero_pre_impreso_factura()+",";
		sDescripcion+=GuiasRemisionesConstantesFunciones.SECUENCIAL+"=";
		sDescripcion+=guiasremisiones.getsecuencial()+",";
		sDescripcion+=GuiasRemisionesConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=guiasremisiones.getfecha_emision().toString()+",";
		sDescripcion+=GuiasRemisionesConstantesFunciones.FECHAVENCIMIENTO+"=";
		sDescripcion+=guiasremisiones.getfecha_vencimiento().toString()+",";
		sDescripcion+=GuiasRemisionesConstantesFunciones.NOMBRETIPOTRANSPORTE+"=";
		sDescripcion+=guiasremisiones.getnombre_tipo_transporte()+",";
		sDescripcion+=GuiasRemisionesConstantesFunciones.IVA+"=";
		sDescripcion+=guiasremisiones.getiva().toString()+",";
		sDescripcion+=GuiasRemisionesConstantesFunciones.DESCUENTO+"=";
		sDescripcion+=guiasremisiones.getdescuento().toString()+",";
		sDescripcion+=GuiasRemisionesConstantesFunciones.OTRO+"=";
		sDescripcion+=guiasremisiones.getotro().toString()+",";
		sDescripcion+=GuiasRemisionesConstantesFunciones.TOTAL+"=";
		sDescripcion+=guiasremisiones.gettotal().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setGuiasRemisionesDescripcion(GuiasRemisiones guiasremisiones,String sValor) throws Exception {			
		if(guiasremisiones !=null) {
			//guiasremisionesguiasremisiones.getId().toString();
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
		} else if(sNombreIndice.equals("BusquedaGuiasRemisiones")) {
			sNombreIndice="Tipo=  Por Fecha Emision Desde Por Fecha Emision Hasta";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaGuiasRemisiones(Date fecha_emision_desde,Date fecha_emision_hasta) {
		String sDetalleIndice=" Parametros->";
		if(fecha_emision_desde!=null) {sDetalleIndice+=" Fecha Emision Desde="+fecha_emision_desde.toString();}
		if(fecha_emision_hasta!=null) {sDetalleIndice+=" Fecha Emision Hasta="+fecha_emision_hasta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosGuiasRemisiones(GuiasRemisiones guiasremisiones,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		guiasremisiones.setnombre_completo_cliente(guiasremisiones.getnombre_completo_cliente().trim());
		guiasremisiones.setnumero_pre_impreso_factura(guiasremisiones.getnumero_pre_impreso_factura().trim());
		guiasremisiones.setsecuencial(guiasremisiones.getsecuencial().trim());
		guiasremisiones.setnombre_tipo_transporte(guiasremisiones.getnombre_tipo_transporte().trim());
	}
	
	public static void quitarEspaciosGuiasRemisioness(List<GuiasRemisiones> guiasremisioness,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(GuiasRemisiones guiasremisiones: guiasremisioness) {
			guiasremisiones.setnombre_completo_cliente(guiasremisiones.getnombre_completo_cliente().trim());
			guiasremisiones.setnumero_pre_impreso_factura(guiasremisiones.getnumero_pre_impreso_factura().trim());
			guiasremisiones.setsecuencial(guiasremisiones.getsecuencial().trim());
			guiasremisiones.setnombre_tipo_transporte(guiasremisiones.getnombre_tipo_transporte().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresGuiasRemisiones(GuiasRemisiones guiasremisiones,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && guiasremisiones.getConCambioAuxiliar()) {
			guiasremisiones.setIsDeleted(guiasremisiones.getIsDeletedAuxiliar());	
			guiasremisiones.setIsNew(guiasremisiones.getIsNewAuxiliar());	
			guiasremisiones.setIsChanged(guiasremisiones.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			guiasremisiones.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			guiasremisiones.setIsDeletedAuxiliar(false);	
			guiasremisiones.setIsNewAuxiliar(false);	
			guiasremisiones.setIsChangedAuxiliar(false);
			
			guiasremisiones.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresGuiasRemisioness(List<GuiasRemisiones> guiasremisioness,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(GuiasRemisiones guiasremisiones : guiasremisioness) {
			if(conAsignarBase && guiasremisiones.getConCambioAuxiliar()) {
				guiasremisiones.setIsDeleted(guiasremisiones.getIsDeletedAuxiliar());	
				guiasremisiones.setIsNew(guiasremisiones.getIsNewAuxiliar());	
				guiasremisiones.setIsChanged(guiasremisiones.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				guiasremisiones.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				guiasremisiones.setIsDeletedAuxiliar(false);	
				guiasremisiones.setIsNewAuxiliar(false);	
				guiasremisiones.setIsChangedAuxiliar(false);
				
				guiasremisiones.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresGuiasRemisiones(GuiasRemisiones guiasremisiones,Boolean conEnteros) throws Exception  {
		guiasremisiones.setiva(0.0);
		guiasremisiones.setdescuento(0.0);
		guiasremisiones.setotro(0.0);
		guiasremisiones.settotal(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresGuiasRemisioness(List<GuiasRemisiones> guiasremisioness,Boolean conEnteros) throws Exception  {
		
		for(GuiasRemisiones guiasremisiones: guiasremisioness) {
			guiasremisiones.setiva(0.0);
			guiasremisiones.setdescuento(0.0);
			guiasremisiones.setotro(0.0);
			guiasremisiones.settotal(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaGuiasRemisiones(List<GuiasRemisiones> guiasremisioness,GuiasRemisiones guiasremisionesAux) throws Exception  {
		GuiasRemisionesConstantesFunciones.InicializarValoresGuiasRemisiones(guiasremisionesAux,true);
		
		for(GuiasRemisiones guiasremisiones: guiasremisioness) {
			if(guiasremisiones.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			guiasremisionesAux.setiva(guiasremisionesAux.getiva()+guiasremisiones.getiva());			
			guiasremisionesAux.setdescuento(guiasremisionesAux.getdescuento()+guiasremisiones.getdescuento());			
			guiasremisionesAux.setotro(guiasremisionesAux.getotro()+guiasremisiones.getotro());			
			guiasremisionesAux.settotal(guiasremisionesAux.gettotal()+guiasremisiones.gettotal());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesGuiasRemisiones(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=GuiasRemisionesConstantesFunciones.getArrayColumnasGlobalesGuiasRemisiones(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesGuiasRemisiones(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(GuiasRemisionesConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(GuiasRemisionesConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoGuiasRemisiones(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<GuiasRemisiones> guiasremisioness,GuiasRemisiones guiasremisiones,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(GuiasRemisiones guiasremisionesAux: guiasremisioness) {
			if(guiasremisionesAux!=null && guiasremisiones!=null) {
				if((guiasremisionesAux.getId()==null && guiasremisiones.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(guiasremisionesAux.getId()!=null && guiasremisiones.getId()!=null){
					if(guiasremisionesAux.getId().equals(guiasremisiones.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaGuiasRemisiones(List<GuiasRemisiones> guiasremisioness) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double ivaTotal=0.0;
		Double descuentoTotal=0.0;
		Double otroTotal=0.0;
		Double totalTotal=0.0;
	
		for(GuiasRemisiones guiasremisiones: guiasremisioness) {			
			if(guiasremisiones.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			ivaTotal+=guiasremisiones.getiva();
			descuentoTotal+=guiasremisiones.getdescuento();
			otroTotal+=guiasremisiones.getotro();
			totalTotal+=guiasremisiones.gettotal();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GuiasRemisionesConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(GuiasRemisionesConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GuiasRemisionesConstantesFunciones.DESCUENTO);
		datoGeneral.setsDescripcion(GuiasRemisionesConstantesFunciones.LABEL_DESCUENTO);
		datoGeneral.setdValorDouble(descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GuiasRemisionesConstantesFunciones.OTRO);
		datoGeneral.setsDescripcion(GuiasRemisionesConstantesFunciones.LABEL_OTRO);
		datoGeneral.setdValorDouble(otroTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GuiasRemisionesConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(GuiasRemisionesConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaGuiasRemisiones() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,GuiasRemisionesConstantesFunciones.LABEL_ID, GuiasRemisionesConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiasRemisionesConstantesFunciones.LABEL_VERSIONROW, GuiasRemisionesConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiasRemisionesConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE, GuiasRemisionesConstantesFunciones.NOMBRECOMPLETOCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiasRemisionesConstantesFunciones.LABEL_NUMEROPREIMPRESOFACTURA, GuiasRemisionesConstantesFunciones.NUMEROPREIMPRESOFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiasRemisionesConstantesFunciones.LABEL_SECUENCIAL, GuiasRemisionesConstantesFunciones.SECUENCIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiasRemisionesConstantesFunciones.LABEL_FECHAEMISION, GuiasRemisionesConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiasRemisionesConstantesFunciones.LABEL_FECHAVENCIMIENTO, GuiasRemisionesConstantesFunciones.FECHAVENCIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiasRemisionesConstantesFunciones.LABEL_NOMBRETIPOTRANSPORTE, GuiasRemisionesConstantesFunciones.NOMBRETIPOTRANSPORTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiasRemisionesConstantesFunciones.LABEL_IVA, GuiasRemisionesConstantesFunciones.IVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiasRemisionesConstantesFunciones.LABEL_DESCUENTO, GuiasRemisionesConstantesFunciones.DESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiasRemisionesConstantesFunciones.LABEL_OTRO, GuiasRemisionesConstantesFunciones.OTRO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GuiasRemisionesConstantesFunciones.LABEL_TOTAL, GuiasRemisionesConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasGuiasRemisiones() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=GuiasRemisionesConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiasRemisionesConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiasRemisionesConstantesFunciones.NOMBRECOMPLETOCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiasRemisionesConstantesFunciones.NUMEROPREIMPRESOFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiasRemisionesConstantesFunciones.SECUENCIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiasRemisionesConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiasRemisionesConstantesFunciones.FECHAVENCIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiasRemisionesConstantesFunciones.NOMBRETIPOTRANSPORTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiasRemisionesConstantesFunciones.IVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiasRemisionesConstantesFunciones.DESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiasRemisionesConstantesFunciones.OTRO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GuiasRemisionesConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarGuiasRemisiones() throws Exception  {
		return GuiasRemisionesConstantesFunciones.getTiposSeleccionarGuiasRemisiones(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarGuiasRemisiones(Boolean conFk) throws Exception  {
		return GuiasRemisionesConstantesFunciones.getTiposSeleccionarGuiasRemisiones(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarGuiasRemisiones(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiasRemisionesConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(GuiasRemisionesConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiasRemisionesConstantesFunciones.LABEL_FECHAEMISIONDESDE);
			reporte.setsDescripcion(GuiasRemisionesConstantesFunciones.LABEL_FECHAEMISIONDESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiasRemisionesConstantesFunciones.LABEL_FECHAEMISIONHASTA);
			reporte.setsDescripcion(GuiasRemisionesConstantesFunciones.LABEL_FECHAEMISIONHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiasRemisionesConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);
			reporte.setsDescripcion(GuiasRemisionesConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiasRemisionesConstantesFunciones.LABEL_NUMEROPREIMPRESOFACTURA);
			reporte.setsDescripcion(GuiasRemisionesConstantesFunciones.LABEL_NUMEROPREIMPRESOFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiasRemisionesConstantesFunciones.LABEL_SECUENCIAL);
			reporte.setsDescripcion(GuiasRemisionesConstantesFunciones.LABEL_SECUENCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiasRemisionesConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(GuiasRemisionesConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiasRemisionesConstantesFunciones.LABEL_FECHAVENCIMIENTO);
			reporte.setsDescripcion(GuiasRemisionesConstantesFunciones.LABEL_FECHAVENCIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiasRemisionesConstantesFunciones.LABEL_NOMBRETIPOTRANSPORTE);
			reporte.setsDescripcion(GuiasRemisionesConstantesFunciones.LABEL_NOMBRETIPOTRANSPORTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiasRemisionesConstantesFunciones.LABEL_IVA);
			reporte.setsDescripcion(GuiasRemisionesConstantesFunciones.LABEL_IVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiasRemisionesConstantesFunciones.LABEL_DESCUENTO);
			reporte.setsDescripcion(GuiasRemisionesConstantesFunciones.LABEL_DESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiasRemisionesConstantesFunciones.LABEL_OTRO);
			reporte.setsDescripcion(GuiasRemisionesConstantesFunciones.LABEL_OTRO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GuiasRemisionesConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(GuiasRemisionesConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesGuiasRemisiones(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesGuiasRemisiones(GuiasRemisiones guiasremisionesAux) throws Exception {
		
			guiasremisionesAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(guiasremisionesAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesGuiasRemisiones(List<GuiasRemisiones> guiasremisionessTemp) throws Exception {
		for(GuiasRemisiones guiasremisionesAux:guiasremisionessTemp) {
			
			guiasremisionesAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(guiasremisionesAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfGuiasRemisiones(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfGuiasRemisiones(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfGuiasRemisiones(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return GuiasRemisionesConstantesFunciones.getClassesRelationshipsOfGuiasRemisiones(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfGuiasRemisiones(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfGuiasRemisiones(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return GuiasRemisionesConstantesFunciones.getClassesRelationshipsFromStringsOfGuiasRemisiones(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfGuiasRemisiones(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(GuiasRemisiones guiasremisiones,List<GuiasRemisiones> guiasremisioness,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(GuiasRemisiones guiasremisiones,List<GuiasRemisiones> guiasremisioness) throws Exception {
		try	{			
			for(GuiasRemisiones guiasremisionesLocal:guiasremisioness) {
				if(guiasremisionesLocal.getId().equals(guiasremisiones.getId())) {
					guiasremisionesLocal.setIsSelected(guiasremisiones.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesGuiasRemisiones(List<GuiasRemisiones> guiasremisionessAux) throws Exception {
		//this.guiasremisionessAux=guiasremisionessAux;
		
		for(GuiasRemisiones guiasremisionesAux:guiasremisionessAux) {
			if(guiasremisionesAux.getIsChanged()) {
				guiasremisionesAux.setIsChanged(false);
			}		
			
			if(guiasremisionesAux.getIsNew()) {
				guiasremisionesAux.setIsNew(false);
			}	
			
			if(guiasremisionesAux.getIsDeleted()) {
				guiasremisionesAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesGuiasRemisiones(GuiasRemisiones guiasremisionesAux) throws Exception {
		//this.guiasremisionesAux=guiasremisionesAux;
		
			if(guiasremisionesAux.getIsChanged()) {
				guiasremisionesAux.setIsChanged(false);
			}		
			
			if(guiasremisionesAux.getIsNew()) {
				guiasremisionesAux.setIsNew(false);
			}	
			
			if(guiasremisionesAux.getIsDeleted()) {
				guiasremisionesAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(GuiasRemisiones guiasremisionesAsignar,GuiasRemisiones guiasremisiones) throws Exception {
		guiasremisionesAsignar.setId(guiasremisiones.getId());	
		guiasremisionesAsignar.setVersionRow(guiasremisiones.getVersionRow());	
		guiasremisionesAsignar.setnombre_completo_cliente(guiasremisiones.getnombre_completo_cliente());	
		guiasremisionesAsignar.setnumero_pre_impreso_factura(guiasremisiones.getnumero_pre_impreso_factura());	
		guiasremisionesAsignar.setsecuencial(guiasremisiones.getsecuencial());	
		guiasremisionesAsignar.setfecha_emision(guiasremisiones.getfecha_emision());	
		guiasremisionesAsignar.setfecha_vencimiento(guiasremisiones.getfecha_vencimiento());	
		guiasremisionesAsignar.setnombre_tipo_transporte(guiasremisiones.getnombre_tipo_transporte());	
		guiasremisionesAsignar.setiva(guiasremisiones.getiva());	
		guiasremisionesAsignar.setdescuento(guiasremisiones.getdescuento());	
		guiasremisionesAsignar.setotro(guiasremisiones.getotro());	
		guiasremisionesAsignar.settotal(guiasremisiones.gettotal());	
	}
	
	public static void inicializarGuiasRemisiones(GuiasRemisiones guiasremisiones) throws Exception {
		try {
				guiasremisiones.setId(0L);	
					
				guiasremisiones.setnombre_completo_cliente("");	
				guiasremisiones.setnumero_pre_impreso_factura("");	
				guiasremisiones.setsecuencial("");	
				guiasremisiones.setfecha_emision(new Date());	
				guiasremisiones.setfecha_vencimiento(new Date());	
				guiasremisiones.setnombre_tipo_transporte("");	
				guiasremisiones.setiva(0.0);	
				guiasremisiones.setdescuento(0.0);	
				guiasremisiones.setotro(0.0);	
				guiasremisiones.settotal(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderGuiasRemisiones(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiasRemisionesConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiasRemisionesConstantesFunciones.LABEL_FECHAEMISIONDESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiasRemisionesConstantesFunciones.LABEL_FECHAEMISIONHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiasRemisionesConstantesFunciones.LABEL_NOMBRECOMPLETOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiasRemisionesConstantesFunciones.LABEL_NUMEROPREIMPRESOFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiasRemisionesConstantesFunciones.LABEL_SECUENCIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiasRemisionesConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiasRemisionesConstantesFunciones.LABEL_FECHAVENCIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiasRemisionesConstantesFunciones.LABEL_NOMBRETIPOTRANSPORTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiasRemisionesConstantesFunciones.LABEL_IVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiasRemisionesConstantesFunciones.LABEL_DESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiasRemisionesConstantesFunciones.LABEL_OTRO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GuiasRemisionesConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataGuiasRemisiones(String sTipo,Row row,Workbook workbook,GuiasRemisiones guiasremisiones,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(guiasremisiones.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiasremisiones.getfecha_emision_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiasremisiones.getfecha_emision_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiasremisiones.getnombre_completo_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiasremisiones.getnumero_pre_impreso_factura());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiasremisiones.getsecuencial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiasremisiones.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiasremisiones.getfecha_vencimiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiasremisiones.getnombre_tipo_transporte());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiasremisiones.getiva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiasremisiones.getdescuento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiasremisiones.getotro());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(guiasremisiones.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryGuiasRemisiones="";
	
	public String getsFinalQueryGuiasRemisiones() {
		return this.sFinalQueryGuiasRemisiones;
	}
	
	public void setsFinalQueryGuiasRemisiones(String sFinalQueryGuiasRemisiones) {
		this.sFinalQueryGuiasRemisiones= sFinalQueryGuiasRemisiones;
	}
	
	public Border resaltarSeleccionarGuiasRemisiones=null;
	
	public Border setResaltarSeleccionarGuiasRemisiones(ParametroGeneralUsuario parametroGeneralUsuario/*GuiasRemisionesBeanSwingJInternalFrame guiasremisionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//guiasremisionesBeanSwingJInternalFrame.jTtoolBarGuiasRemisiones.setBorder(borderResaltar);
		
		this.resaltarSeleccionarGuiasRemisiones= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarGuiasRemisiones() {
		return this.resaltarSeleccionarGuiasRemisiones;
	}
	
	public void setResaltarSeleccionarGuiasRemisiones(Border borderResaltarSeleccionarGuiasRemisiones) {
		this.resaltarSeleccionarGuiasRemisiones= borderResaltarSeleccionarGuiasRemisiones;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridGuiasRemisiones=null;
	public Boolean mostraridGuiasRemisiones=true;
	public Boolean activaridGuiasRemisiones=true;

	public Border resaltarid_empresaGuiasRemisiones=null;
	public Boolean mostrarid_empresaGuiasRemisiones=true;
	public Boolean activarid_empresaGuiasRemisiones=true;
	public Boolean cargarid_empresaGuiasRemisiones=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaGuiasRemisiones=false;//ConEventDepend=true

	public Border resaltarfecha_emision_desdeGuiasRemisiones=null;
	public Boolean mostrarfecha_emision_desdeGuiasRemisiones=true;
	public Boolean activarfecha_emision_desdeGuiasRemisiones=true;

	public Border resaltarfecha_emision_hastaGuiasRemisiones=null;
	public Boolean mostrarfecha_emision_hastaGuiasRemisiones=true;
	public Boolean activarfecha_emision_hastaGuiasRemisiones=true;

	public Border resaltarnombre_completo_clienteGuiasRemisiones=null;
	public Boolean mostrarnombre_completo_clienteGuiasRemisiones=true;
	public Boolean activarnombre_completo_clienteGuiasRemisiones=true;

	public Border resaltarnumero_pre_impreso_facturaGuiasRemisiones=null;
	public Boolean mostrarnumero_pre_impreso_facturaGuiasRemisiones=true;
	public Boolean activarnumero_pre_impreso_facturaGuiasRemisiones=true;

	public Border resaltarsecuencialGuiasRemisiones=null;
	public Boolean mostrarsecuencialGuiasRemisiones=true;
	public Boolean activarsecuencialGuiasRemisiones=true;

	public Border resaltarfecha_emisionGuiasRemisiones=null;
	public Boolean mostrarfecha_emisionGuiasRemisiones=true;
	public Boolean activarfecha_emisionGuiasRemisiones=true;

	public Border resaltarfecha_vencimientoGuiasRemisiones=null;
	public Boolean mostrarfecha_vencimientoGuiasRemisiones=true;
	public Boolean activarfecha_vencimientoGuiasRemisiones=true;

	public Border resaltarnombre_tipo_transporteGuiasRemisiones=null;
	public Boolean mostrarnombre_tipo_transporteGuiasRemisiones=true;
	public Boolean activarnombre_tipo_transporteGuiasRemisiones=true;

	public Border resaltarivaGuiasRemisiones=null;
	public Boolean mostrarivaGuiasRemisiones=true;
	public Boolean activarivaGuiasRemisiones=true;

	public Border resaltardescuentoGuiasRemisiones=null;
	public Boolean mostrardescuentoGuiasRemisiones=true;
	public Boolean activardescuentoGuiasRemisiones=true;

	public Border resaltarotroGuiasRemisiones=null;
	public Boolean mostrarotroGuiasRemisiones=true;
	public Boolean activarotroGuiasRemisiones=true;

	public Border resaltartotalGuiasRemisiones=null;
	public Boolean mostrartotalGuiasRemisiones=true;
	public Boolean activartotalGuiasRemisiones=true;

	
	

	public Border setResaltaridGuiasRemisiones(ParametroGeneralUsuario parametroGeneralUsuario/*GuiasRemisionesBeanSwingJInternalFrame guiasremisionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiasremisionesBeanSwingJInternalFrame.jTtoolBarGuiasRemisiones.setBorder(borderResaltar);
		
		this.resaltaridGuiasRemisiones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridGuiasRemisiones() {
		return this.resaltaridGuiasRemisiones;
	}

	public void setResaltaridGuiasRemisiones(Border borderResaltar) {
		this.resaltaridGuiasRemisiones= borderResaltar;
	}

	public Boolean getMostraridGuiasRemisiones() {
		return this.mostraridGuiasRemisiones;
	}

	public void setMostraridGuiasRemisiones(Boolean mostraridGuiasRemisiones) {
		this.mostraridGuiasRemisiones= mostraridGuiasRemisiones;
	}

	public Boolean getActivaridGuiasRemisiones() {
		return this.activaridGuiasRemisiones;
	}

	public void setActivaridGuiasRemisiones(Boolean activaridGuiasRemisiones) {
		this.activaridGuiasRemisiones= activaridGuiasRemisiones;
	}

	public Border setResaltarid_empresaGuiasRemisiones(ParametroGeneralUsuario parametroGeneralUsuario/*GuiasRemisionesBeanSwingJInternalFrame guiasremisionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiasremisionesBeanSwingJInternalFrame.jTtoolBarGuiasRemisiones.setBorder(borderResaltar);
		
		this.resaltarid_empresaGuiasRemisiones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaGuiasRemisiones() {
		return this.resaltarid_empresaGuiasRemisiones;
	}

	public void setResaltarid_empresaGuiasRemisiones(Border borderResaltar) {
		this.resaltarid_empresaGuiasRemisiones= borderResaltar;
	}

	public Boolean getMostrarid_empresaGuiasRemisiones() {
		return this.mostrarid_empresaGuiasRemisiones;
	}

	public void setMostrarid_empresaGuiasRemisiones(Boolean mostrarid_empresaGuiasRemisiones) {
		this.mostrarid_empresaGuiasRemisiones= mostrarid_empresaGuiasRemisiones;
	}

	public Boolean getActivarid_empresaGuiasRemisiones() {
		return this.activarid_empresaGuiasRemisiones;
	}

	public void setActivarid_empresaGuiasRemisiones(Boolean activarid_empresaGuiasRemisiones) {
		this.activarid_empresaGuiasRemisiones= activarid_empresaGuiasRemisiones;
	}

	public Boolean getCargarid_empresaGuiasRemisiones() {
		return this.cargarid_empresaGuiasRemisiones;
	}

	public void setCargarid_empresaGuiasRemisiones(Boolean cargarid_empresaGuiasRemisiones) {
		this.cargarid_empresaGuiasRemisiones= cargarid_empresaGuiasRemisiones;
	}

	public Border setResaltarfecha_emision_desdeGuiasRemisiones(ParametroGeneralUsuario parametroGeneralUsuario/*GuiasRemisionesBeanSwingJInternalFrame guiasremisionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiasremisionesBeanSwingJInternalFrame.jTtoolBarGuiasRemisiones.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_desdeGuiasRemisiones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_desdeGuiasRemisiones() {
		return this.resaltarfecha_emision_desdeGuiasRemisiones;
	}

	public void setResaltarfecha_emision_desdeGuiasRemisiones(Border borderResaltar) {
		this.resaltarfecha_emision_desdeGuiasRemisiones= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_desdeGuiasRemisiones() {
		return this.mostrarfecha_emision_desdeGuiasRemisiones;
	}

	public void setMostrarfecha_emision_desdeGuiasRemisiones(Boolean mostrarfecha_emision_desdeGuiasRemisiones) {
		this.mostrarfecha_emision_desdeGuiasRemisiones= mostrarfecha_emision_desdeGuiasRemisiones;
	}

	public Boolean getActivarfecha_emision_desdeGuiasRemisiones() {
		return this.activarfecha_emision_desdeGuiasRemisiones;
	}

	public void setActivarfecha_emision_desdeGuiasRemisiones(Boolean activarfecha_emision_desdeGuiasRemisiones) {
		this.activarfecha_emision_desdeGuiasRemisiones= activarfecha_emision_desdeGuiasRemisiones;
	}

	public Border setResaltarfecha_emision_hastaGuiasRemisiones(ParametroGeneralUsuario parametroGeneralUsuario/*GuiasRemisionesBeanSwingJInternalFrame guiasremisionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiasremisionesBeanSwingJInternalFrame.jTtoolBarGuiasRemisiones.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_hastaGuiasRemisiones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_hastaGuiasRemisiones() {
		return this.resaltarfecha_emision_hastaGuiasRemisiones;
	}

	public void setResaltarfecha_emision_hastaGuiasRemisiones(Border borderResaltar) {
		this.resaltarfecha_emision_hastaGuiasRemisiones= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_hastaGuiasRemisiones() {
		return this.mostrarfecha_emision_hastaGuiasRemisiones;
	}

	public void setMostrarfecha_emision_hastaGuiasRemisiones(Boolean mostrarfecha_emision_hastaGuiasRemisiones) {
		this.mostrarfecha_emision_hastaGuiasRemisiones= mostrarfecha_emision_hastaGuiasRemisiones;
	}

	public Boolean getActivarfecha_emision_hastaGuiasRemisiones() {
		return this.activarfecha_emision_hastaGuiasRemisiones;
	}

	public void setActivarfecha_emision_hastaGuiasRemisiones(Boolean activarfecha_emision_hastaGuiasRemisiones) {
		this.activarfecha_emision_hastaGuiasRemisiones= activarfecha_emision_hastaGuiasRemisiones;
	}

	public Border setResaltarnombre_completo_clienteGuiasRemisiones(ParametroGeneralUsuario parametroGeneralUsuario/*GuiasRemisionesBeanSwingJInternalFrame guiasremisionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiasremisionesBeanSwingJInternalFrame.jTtoolBarGuiasRemisiones.setBorder(borderResaltar);
		
		this.resaltarnombre_completo_clienteGuiasRemisiones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_completo_clienteGuiasRemisiones() {
		return this.resaltarnombre_completo_clienteGuiasRemisiones;
	}

	public void setResaltarnombre_completo_clienteGuiasRemisiones(Border borderResaltar) {
		this.resaltarnombre_completo_clienteGuiasRemisiones= borderResaltar;
	}

	public Boolean getMostrarnombre_completo_clienteGuiasRemisiones() {
		return this.mostrarnombre_completo_clienteGuiasRemisiones;
	}

	public void setMostrarnombre_completo_clienteGuiasRemisiones(Boolean mostrarnombre_completo_clienteGuiasRemisiones) {
		this.mostrarnombre_completo_clienteGuiasRemisiones= mostrarnombre_completo_clienteGuiasRemisiones;
	}

	public Boolean getActivarnombre_completo_clienteGuiasRemisiones() {
		return this.activarnombre_completo_clienteGuiasRemisiones;
	}

	public void setActivarnombre_completo_clienteGuiasRemisiones(Boolean activarnombre_completo_clienteGuiasRemisiones) {
		this.activarnombre_completo_clienteGuiasRemisiones= activarnombre_completo_clienteGuiasRemisiones;
	}

	public Border setResaltarnumero_pre_impreso_facturaGuiasRemisiones(ParametroGeneralUsuario parametroGeneralUsuario/*GuiasRemisionesBeanSwingJInternalFrame guiasremisionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiasremisionesBeanSwingJInternalFrame.jTtoolBarGuiasRemisiones.setBorder(borderResaltar);
		
		this.resaltarnumero_pre_impreso_facturaGuiasRemisiones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_pre_impreso_facturaGuiasRemisiones() {
		return this.resaltarnumero_pre_impreso_facturaGuiasRemisiones;
	}

	public void setResaltarnumero_pre_impreso_facturaGuiasRemisiones(Border borderResaltar) {
		this.resaltarnumero_pre_impreso_facturaGuiasRemisiones= borderResaltar;
	}

	public Boolean getMostrarnumero_pre_impreso_facturaGuiasRemisiones() {
		return this.mostrarnumero_pre_impreso_facturaGuiasRemisiones;
	}

	public void setMostrarnumero_pre_impreso_facturaGuiasRemisiones(Boolean mostrarnumero_pre_impreso_facturaGuiasRemisiones) {
		this.mostrarnumero_pre_impreso_facturaGuiasRemisiones= mostrarnumero_pre_impreso_facturaGuiasRemisiones;
	}

	public Boolean getActivarnumero_pre_impreso_facturaGuiasRemisiones() {
		return this.activarnumero_pre_impreso_facturaGuiasRemisiones;
	}

	public void setActivarnumero_pre_impreso_facturaGuiasRemisiones(Boolean activarnumero_pre_impreso_facturaGuiasRemisiones) {
		this.activarnumero_pre_impreso_facturaGuiasRemisiones= activarnumero_pre_impreso_facturaGuiasRemisiones;
	}

	public Border setResaltarsecuencialGuiasRemisiones(ParametroGeneralUsuario parametroGeneralUsuario/*GuiasRemisionesBeanSwingJInternalFrame guiasremisionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiasremisionesBeanSwingJInternalFrame.jTtoolBarGuiasRemisiones.setBorder(borderResaltar);
		
		this.resaltarsecuencialGuiasRemisiones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsecuencialGuiasRemisiones() {
		return this.resaltarsecuencialGuiasRemisiones;
	}

	public void setResaltarsecuencialGuiasRemisiones(Border borderResaltar) {
		this.resaltarsecuencialGuiasRemisiones= borderResaltar;
	}

	public Boolean getMostrarsecuencialGuiasRemisiones() {
		return this.mostrarsecuencialGuiasRemisiones;
	}

	public void setMostrarsecuencialGuiasRemisiones(Boolean mostrarsecuencialGuiasRemisiones) {
		this.mostrarsecuencialGuiasRemisiones= mostrarsecuencialGuiasRemisiones;
	}

	public Boolean getActivarsecuencialGuiasRemisiones() {
		return this.activarsecuencialGuiasRemisiones;
	}

	public void setActivarsecuencialGuiasRemisiones(Boolean activarsecuencialGuiasRemisiones) {
		this.activarsecuencialGuiasRemisiones= activarsecuencialGuiasRemisiones;
	}

	public Border setResaltarfecha_emisionGuiasRemisiones(ParametroGeneralUsuario parametroGeneralUsuario/*GuiasRemisionesBeanSwingJInternalFrame guiasremisionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiasremisionesBeanSwingJInternalFrame.jTtoolBarGuiasRemisiones.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionGuiasRemisiones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionGuiasRemisiones() {
		return this.resaltarfecha_emisionGuiasRemisiones;
	}

	public void setResaltarfecha_emisionGuiasRemisiones(Border borderResaltar) {
		this.resaltarfecha_emisionGuiasRemisiones= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionGuiasRemisiones() {
		return this.mostrarfecha_emisionGuiasRemisiones;
	}

	public void setMostrarfecha_emisionGuiasRemisiones(Boolean mostrarfecha_emisionGuiasRemisiones) {
		this.mostrarfecha_emisionGuiasRemisiones= mostrarfecha_emisionGuiasRemisiones;
	}

	public Boolean getActivarfecha_emisionGuiasRemisiones() {
		return this.activarfecha_emisionGuiasRemisiones;
	}

	public void setActivarfecha_emisionGuiasRemisiones(Boolean activarfecha_emisionGuiasRemisiones) {
		this.activarfecha_emisionGuiasRemisiones= activarfecha_emisionGuiasRemisiones;
	}

	public Border setResaltarfecha_vencimientoGuiasRemisiones(ParametroGeneralUsuario parametroGeneralUsuario/*GuiasRemisionesBeanSwingJInternalFrame guiasremisionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiasremisionesBeanSwingJInternalFrame.jTtoolBarGuiasRemisiones.setBorder(borderResaltar);
		
		this.resaltarfecha_vencimientoGuiasRemisiones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_vencimientoGuiasRemisiones() {
		return this.resaltarfecha_vencimientoGuiasRemisiones;
	}

	public void setResaltarfecha_vencimientoGuiasRemisiones(Border borderResaltar) {
		this.resaltarfecha_vencimientoGuiasRemisiones= borderResaltar;
	}

	public Boolean getMostrarfecha_vencimientoGuiasRemisiones() {
		return this.mostrarfecha_vencimientoGuiasRemisiones;
	}

	public void setMostrarfecha_vencimientoGuiasRemisiones(Boolean mostrarfecha_vencimientoGuiasRemisiones) {
		this.mostrarfecha_vencimientoGuiasRemisiones= mostrarfecha_vencimientoGuiasRemisiones;
	}

	public Boolean getActivarfecha_vencimientoGuiasRemisiones() {
		return this.activarfecha_vencimientoGuiasRemisiones;
	}

	public void setActivarfecha_vencimientoGuiasRemisiones(Boolean activarfecha_vencimientoGuiasRemisiones) {
		this.activarfecha_vencimientoGuiasRemisiones= activarfecha_vencimientoGuiasRemisiones;
	}

	public Border setResaltarnombre_tipo_transporteGuiasRemisiones(ParametroGeneralUsuario parametroGeneralUsuario/*GuiasRemisionesBeanSwingJInternalFrame guiasremisionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiasremisionesBeanSwingJInternalFrame.jTtoolBarGuiasRemisiones.setBorder(borderResaltar);
		
		this.resaltarnombre_tipo_transporteGuiasRemisiones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_tipo_transporteGuiasRemisiones() {
		return this.resaltarnombre_tipo_transporteGuiasRemisiones;
	}

	public void setResaltarnombre_tipo_transporteGuiasRemisiones(Border borderResaltar) {
		this.resaltarnombre_tipo_transporteGuiasRemisiones= borderResaltar;
	}

	public Boolean getMostrarnombre_tipo_transporteGuiasRemisiones() {
		return this.mostrarnombre_tipo_transporteGuiasRemisiones;
	}

	public void setMostrarnombre_tipo_transporteGuiasRemisiones(Boolean mostrarnombre_tipo_transporteGuiasRemisiones) {
		this.mostrarnombre_tipo_transporteGuiasRemisiones= mostrarnombre_tipo_transporteGuiasRemisiones;
	}

	public Boolean getActivarnombre_tipo_transporteGuiasRemisiones() {
		return this.activarnombre_tipo_transporteGuiasRemisiones;
	}

	public void setActivarnombre_tipo_transporteGuiasRemisiones(Boolean activarnombre_tipo_transporteGuiasRemisiones) {
		this.activarnombre_tipo_transporteGuiasRemisiones= activarnombre_tipo_transporteGuiasRemisiones;
	}

	public Border setResaltarivaGuiasRemisiones(ParametroGeneralUsuario parametroGeneralUsuario/*GuiasRemisionesBeanSwingJInternalFrame guiasremisionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiasremisionesBeanSwingJInternalFrame.jTtoolBarGuiasRemisiones.setBorder(borderResaltar);
		
		this.resaltarivaGuiasRemisiones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarivaGuiasRemisiones() {
		return this.resaltarivaGuiasRemisiones;
	}

	public void setResaltarivaGuiasRemisiones(Border borderResaltar) {
		this.resaltarivaGuiasRemisiones= borderResaltar;
	}

	public Boolean getMostrarivaGuiasRemisiones() {
		return this.mostrarivaGuiasRemisiones;
	}

	public void setMostrarivaGuiasRemisiones(Boolean mostrarivaGuiasRemisiones) {
		this.mostrarivaGuiasRemisiones= mostrarivaGuiasRemisiones;
	}

	public Boolean getActivarivaGuiasRemisiones() {
		return this.activarivaGuiasRemisiones;
	}

	public void setActivarivaGuiasRemisiones(Boolean activarivaGuiasRemisiones) {
		this.activarivaGuiasRemisiones= activarivaGuiasRemisiones;
	}

	public Border setResaltardescuentoGuiasRemisiones(ParametroGeneralUsuario parametroGeneralUsuario/*GuiasRemisionesBeanSwingJInternalFrame guiasremisionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiasremisionesBeanSwingJInternalFrame.jTtoolBarGuiasRemisiones.setBorder(borderResaltar);
		
		this.resaltardescuentoGuiasRemisiones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuentoGuiasRemisiones() {
		return this.resaltardescuentoGuiasRemisiones;
	}

	public void setResaltardescuentoGuiasRemisiones(Border borderResaltar) {
		this.resaltardescuentoGuiasRemisiones= borderResaltar;
	}

	public Boolean getMostrardescuentoGuiasRemisiones() {
		return this.mostrardescuentoGuiasRemisiones;
	}

	public void setMostrardescuentoGuiasRemisiones(Boolean mostrardescuentoGuiasRemisiones) {
		this.mostrardescuentoGuiasRemisiones= mostrardescuentoGuiasRemisiones;
	}

	public Boolean getActivardescuentoGuiasRemisiones() {
		return this.activardescuentoGuiasRemisiones;
	}

	public void setActivardescuentoGuiasRemisiones(Boolean activardescuentoGuiasRemisiones) {
		this.activardescuentoGuiasRemisiones= activardescuentoGuiasRemisiones;
	}

	public Border setResaltarotroGuiasRemisiones(ParametroGeneralUsuario parametroGeneralUsuario/*GuiasRemisionesBeanSwingJInternalFrame guiasremisionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiasremisionesBeanSwingJInternalFrame.jTtoolBarGuiasRemisiones.setBorder(borderResaltar);
		
		this.resaltarotroGuiasRemisiones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarotroGuiasRemisiones() {
		return this.resaltarotroGuiasRemisiones;
	}

	public void setResaltarotroGuiasRemisiones(Border borderResaltar) {
		this.resaltarotroGuiasRemisiones= borderResaltar;
	}

	public Boolean getMostrarotroGuiasRemisiones() {
		return this.mostrarotroGuiasRemisiones;
	}

	public void setMostrarotroGuiasRemisiones(Boolean mostrarotroGuiasRemisiones) {
		this.mostrarotroGuiasRemisiones= mostrarotroGuiasRemisiones;
	}

	public Boolean getActivarotroGuiasRemisiones() {
		return this.activarotroGuiasRemisiones;
	}

	public void setActivarotroGuiasRemisiones(Boolean activarotroGuiasRemisiones) {
		this.activarotroGuiasRemisiones= activarotroGuiasRemisiones;
	}

	public Border setResaltartotalGuiasRemisiones(ParametroGeneralUsuario parametroGeneralUsuario/*GuiasRemisionesBeanSwingJInternalFrame guiasremisionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//guiasremisionesBeanSwingJInternalFrame.jTtoolBarGuiasRemisiones.setBorder(borderResaltar);
		
		this.resaltartotalGuiasRemisiones= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalGuiasRemisiones() {
		return this.resaltartotalGuiasRemisiones;
	}

	public void setResaltartotalGuiasRemisiones(Border borderResaltar) {
		this.resaltartotalGuiasRemisiones= borderResaltar;
	}

	public Boolean getMostrartotalGuiasRemisiones() {
		return this.mostrartotalGuiasRemisiones;
	}

	public void setMostrartotalGuiasRemisiones(Boolean mostrartotalGuiasRemisiones) {
		this.mostrartotalGuiasRemisiones= mostrartotalGuiasRemisiones;
	}

	public Boolean getActivartotalGuiasRemisiones() {
		return this.activartotalGuiasRemisiones;
	}

	public void setActivartotalGuiasRemisiones(Boolean activartotalGuiasRemisiones) {
		this.activartotalGuiasRemisiones= activartotalGuiasRemisiones;
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
		
		
		this.setMostraridGuiasRemisiones(esInicial);
		this.setMostrarid_empresaGuiasRemisiones(esInicial);
		this.setMostrarfecha_emision_desdeGuiasRemisiones(esInicial);
		this.setMostrarfecha_emision_hastaGuiasRemisiones(esInicial);
		this.setMostrarnombre_completo_clienteGuiasRemisiones(esInicial);
		this.setMostrarnumero_pre_impreso_facturaGuiasRemisiones(esInicial);
		this.setMostrarsecuencialGuiasRemisiones(esInicial);
		this.setMostrarfecha_emisionGuiasRemisiones(esInicial);
		this.setMostrarfecha_vencimientoGuiasRemisiones(esInicial);
		this.setMostrarnombre_tipo_transporteGuiasRemisiones(esInicial);
		this.setMostrarivaGuiasRemisiones(esInicial);
		this.setMostrardescuentoGuiasRemisiones(esInicial);
		this.setMostrarotroGuiasRemisiones(esInicial);
		this.setMostrartotalGuiasRemisiones(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(GuiasRemisionesConstantesFunciones.ID)) {
				this.setMostraridGuiasRemisiones(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiasRemisionesConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaGuiasRemisiones(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiasRemisionesConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setMostrarfecha_emision_desdeGuiasRemisiones(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiasRemisionesConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setMostrarfecha_emision_hastaGuiasRemisiones(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiasRemisionesConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setMostrarnombre_completo_clienteGuiasRemisiones(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiasRemisionesConstantesFunciones.NUMEROPREIMPRESOFACTURA)) {
				this.setMostrarnumero_pre_impreso_facturaGuiasRemisiones(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiasRemisionesConstantesFunciones.SECUENCIAL)) {
				this.setMostrarsecuencialGuiasRemisiones(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiasRemisionesConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionGuiasRemisiones(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiasRemisionesConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setMostrarfecha_vencimientoGuiasRemisiones(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiasRemisionesConstantesFunciones.NOMBRETIPOTRANSPORTE)) {
				this.setMostrarnombre_tipo_transporteGuiasRemisiones(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiasRemisionesConstantesFunciones.IVA)) {
				this.setMostrarivaGuiasRemisiones(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiasRemisionesConstantesFunciones.DESCUENTO)) {
				this.setMostrardescuentoGuiasRemisiones(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiasRemisionesConstantesFunciones.OTRO)) {
				this.setMostrarotroGuiasRemisiones(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiasRemisionesConstantesFunciones.TOTAL)) {
				this.setMostrartotalGuiasRemisiones(esAsigna);
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
		
		
		this.setActivaridGuiasRemisiones(esInicial);
		this.setActivarid_empresaGuiasRemisiones(esInicial);
		this.setActivarfecha_emision_desdeGuiasRemisiones(esInicial);
		this.setActivarfecha_emision_hastaGuiasRemisiones(esInicial);
		this.setActivarnombre_completo_clienteGuiasRemisiones(esInicial);
		this.setActivarnumero_pre_impreso_facturaGuiasRemisiones(esInicial);
		this.setActivarsecuencialGuiasRemisiones(esInicial);
		this.setActivarfecha_emisionGuiasRemisiones(esInicial);
		this.setActivarfecha_vencimientoGuiasRemisiones(esInicial);
		this.setActivarnombre_tipo_transporteGuiasRemisiones(esInicial);
		this.setActivarivaGuiasRemisiones(esInicial);
		this.setActivardescuentoGuiasRemisiones(esInicial);
		this.setActivarotroGuiasRemisiones(esInicial);
		this.setActivartotalGuiasRemisiones(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(GuiasRemisionesConstantesFunciones.ID)) {
				this.setActivaridGuiasRemisiones(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiasRemisionesConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaGuiasRemisiones(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiasRemisionesConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setActivarfecha_emision_desdeGuiasRemisiones(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiasRemisionesConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setActivarfecha_emision_hastaGuiasRemisiones(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiasRemisionesConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setActivarnombre_completo_clienteGuiasRemisiones(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiasRemisionesConstantesFunciones.NUMEROPREIMPRESOFACTURA)) {
				this.setActivarnumero_pre_impreso_facturaGuiasRemisiones(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiasRemisionesConstantesFunciones.SECUENCIAL)) {
				this.setActivarsecuencialGuiasRemisiones(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiasRemisionesConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionGuiasRemisiones(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiasRemisionesConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setActivarfecha_vencimientoGuiasRemisiones(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiasRemisionesConstantesFunciones.NOMBRETIPOTRANSPORTE)) {
				this.setActivarnombre_tipo_transporteGuiasRemisiones(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiasRemisionesConstantesFunciones.IVA)) {
				this.setActivarivaGuiasRemisiones(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiasRemisionesConstantesFunciones.DESCUENTO)) {
				this.setActivardescuentoGuiasRemisiones(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiasRemisionesConstantesFunciones.OTRO)) {
				this.setActivarotroGuiasRemisiones(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiasRemisionesConstantesFunciones.TOTAL)) {
				this.setActivartotalGuiasRemisiones(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,GuiasRemisionesBeanSwingJInternalFrame guiasremisionesBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridGuiasRemisiones(esInicial);
		this.setResaltarid_empresaGuiasRemisiones(esInicial);
		this.setResaltarfecha_emision_desdeGuiasRemisiones(esInicial);
		this.setResaltarfecha_emision_hastaGuiasRemisiones(esInicial);
		this.setResaltarnombre_completo_clienteGuiasRemisiones(esInicial);
		this.setResaltarnumero_pre_impreso_facturaGuiasRemisiones(esInicial);
		this.setResaltarsecuencialGuiasRemisiones(esInicial);
		this.setResaltarfecha_emisionGuiasRemisiones(esInicial);
		this.setResaltarfecha_vencimientoGuiasRemisiones(esInicial);
		this.setResaltarnombre_tipo_transporteGuiasRemisiones(esInicial);
		this.setResaltarivaGuiasRemisiones(esInicial);
		this.setResaltardescuentoGuiasRemisiones(esInicial);
		this.setResaltarotroGuiasRemisiones(esInicial);
		this.setResaltartotalGuiasRemisiones(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(GuiasRemisionesConstantesFunciones.ID)) {
				this.setResaltaridGuiasRemisiones(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiasRemisionesConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaGuiasRemisiones(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiasRemisionesConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setResaltarfecha_emision_desdeGuiasRemisiones(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiasRemisionesConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setResaltarfecha_emision_hastaGuiasRemisiones(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiasRemisionesConstantesFunciones.NOMBRECOMPLETOCLIENTE)) {
				this.setResaltarnombre_completo_clienteGuiasRemisiones(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiasRemisionesConstantesFunciones.NUMEROPREIMPRESOFACTURA)) {
				this.setResaltarnumero_pre_impreso_facturaGuiasRemisiones(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiasRemisionesConstantesFunciones.SECUENCIAL)) {
				this.setResaltarsecuencialGuiasRemisiones(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiasRemisionesConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionGuiasRemisiones(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiasRemisionesConstantesFunciones.FECHAVENCIMIENTO)) {
				this.setResaltarfecha_vencimientoGuiasRemisiones(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiasRemisionesConstantesFunciones.NOMBRETIPOTRANSPORTE)) {
				this.setResaltarnombre_tipo_transporteGuiasRemisiones(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiasRemisionesConstantesFunciones.IVA)) {
				this.setResaltarivaGuiasRemisiones(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiasRemisionesConstantesFunciones.DESCUENTO)) {
				this.setResaltardescuentoGuiasRemisiones(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiasRemisionesConstantesFunciones.OTRO)) {
				this.setResaltarotroGuiasRemisiones(esAsigna);
				continue;
			}

			if(campo.clase.equals(GuiasRemisionesConstantesFunciones.TOTAL)) {
				this.setResaltartotalGuiasRemisiones(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,GuiasRemisionesBeanSwingJInternalFrame guiasremisionesBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaGuiasRemisionesGuiasRemisiones=true;

	public Boolean getMostrarBusquedaGuiasRemisionesGuiasRemisiones() {
		return this.mostrarBusquedaGuiasRemisionesGuiasRemisiones;
	}

	public void setMostrarBusquedaGuiasRemisionesGuiasRemisiones(Boolean visibilidadResaltar) {
		this.mostrarBusquedaGuiasRemisionesGuiasRemisiones= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaGuiasRemisionesGuiasRemisiones=true;

	public Boolean getActivarBusquedaGuiasRemisionesGuiasRemisiones() {
		return this.activarBusquedaGuiasRemisionesGuiasRemisiones;
	}

	public void setActivarBusquedaGuiasRemisionesGuiasRemisiones(Boolean habilitarResaltar) {
		this.activarBusquedaGuiasRemisionesGuiasRemisiones= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaGuiasRemisionesGuiasRemisiones=null;

	public Border getResaltarBusquedaGuiasRemisionesGuiasRemisiones() {
		return this.resaltarBusquedaGuiasRemisionesGuiasRemisiones;
	}

	public void setResaltarBusquedaGuiasRemisionesGuiasRemisiones(Border borderResaltar) {
		this.resaltarBusquedaGuiasRemisionesGuiasRemisiones= borderResaltar;
	}

	public void setResaltarBusquedaGuiasRemisionesGuiasRemisiones(ParametroGeneralUsuario parametroGeneralUsuario/*GuiasRemisionesBeanSwingJInternalFrame guiasremisionesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaGuiasRemisionesGuiasRemisiones= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}