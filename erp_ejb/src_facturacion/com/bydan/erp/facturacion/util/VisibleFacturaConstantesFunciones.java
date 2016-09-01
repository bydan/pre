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
package com.bydan.erp.facturacion.util;

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


import com.bydan.erp.facturacion.util.VisibleFacturaConstantesFunciones;
import com.bydan.erp.facturacion.util.VisibleFacturaParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.VisibleFacturaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;



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
final public class VisibleFacturaConstantesFunciones extends VisibleFacturaConstantesFuncionesAdditional {		
	
	
	
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
	
	
	public static final String SFINALQUERY=Constantes.SFINALQUERY;	
	public static final String SNOMBREOPCION="VisibleFactura";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="VisibleFactura"+VisibleFacturaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="VisibleFacturaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="VisibleFacturaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=VisibleFacturaConstantesFunciones.SCHEMA+"_"+VisibleFacturaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/VisibleFacturaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=VisibleFacturaConstantesFunciones.SCHEMA+"_"+VisibleFacturaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=VisibleFacturaConstantesFunciones.SCHEMA+"_"+VisibleFacturaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/VisibleFacturaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=VisibleFacturaConstantesFunciones.SCHEMA+"_"+VisibleFacturaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VisibleFacturaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/VisibleFacturaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VisibleFacturaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VisibleFacturaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/VisibleFacturaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VisibleFacturaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=VisibleFacturaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+VisibleFacturaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=VisibleFacturaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+VisibleFacturaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Visibilidad Facturas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Visibilidad Factura";
	public static final String SCLASSWEBTITULO_LOWER="Visible Factura";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="VisibleFactura";
	public static final String OBJECTNAME="visiblefactura";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="visible_factura";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select visiblefactura from "+VisibleFacturaConstantesFunciones.SPERSISTENCENAME+" visiblefactura";
	public static String QUERYSELECTNATIVE="select "+VisibleFacturaConstantesFunciones.SCHEMA+"."+VisibleFacturaConstantesFunciones.TABLENAME+".id,"+VisibleFacturaConstantesFunciones.SCHEMA+"."+VisibleFacturaConstantesFunciones.TABLENAME+".version_row,"+VisibleFacturaConstantesFunciones.SCHEMA+"."+VisibleFacturaConstantesFunciones.TABLENAME+".id_empresa,"+VisibleFacturaConstantesFunciones.SCHEMA+"."+VisibleFacturaConstantesFunciones.TABLENAME+".cabe_consignatario,"+VisibleFacturaConstantesFunciones.SCHEMA+"."+VisibleFacturaConstantesFunciones.TABLENAME+".cabe_tipo_tasa,"+VisibleFacturaConstantesFunciones.SCHEMA+"."+VisibleFacturaConstantesFunciones.TABLENAME+".cabe_consultor,"+VisibleFacturaConstantesFunciones.SCHEMA+"."+VisibleFacturaConstantesFunciones.TABLENAME+".cabe_ice,"+VisibleFacturaConstantesFunciones.SCHEMA+"."+VisibleFacturaConstantesFunciones.TABLENAME+".cabe_transporte,"+VisibleFacturaConstantesFunciones.SCHEMA+"."+VisibleFacturaConstantesFunciones.TABLENAME+".cabe_fue,"+VisibleFacturaConstantesFunciones.SCHEMA+"."+VisibleFacturaConstantesFunciones.TABLENAME+".cabe_orden,"+VisibleFacturaConstantesFunciones.SCHEMA+"."+VisibleFacturaConstantesFunciones.TABLENAME+".deta_autori_precio,"+VisibleFacturaConstantesFunciones.SCHEMA+"."+VisibleFacturaConstantesFunciones.TABLENAME+".deta_area,"+VisibleFacturaConstantesFunciones.SCHEMA+"."+VisibleFacturaConstantesFunciones.TABLENAME+".deta_foto from "+VisibleFacturaConstantesFunciones.SCHEMA+"."+VisibleFacturaConstantesFunciones.TABLENAME;//+" as "+VisibleFacturaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected VisibleFacturaConstantesFuncionesAdditional visiblefacturaConstantesFuncionesAdditional=null;
	
	public VisibleFacturaConstantesFuncionesAdditional getVisibleFacturaConstantesFuncionesAdditional() {
		return this.visiblefacturaConstantesFuncionesAdditional;
	}
	
	public void setVisibleFacturaConstantesFuncionesAdditional(VisibleFacturaConstantesFuncionesAdditional visiblefacturaConstantesFuncionesAdditional) {
		try {
			this.visiblefacturaConstantesFuncionesAdditional=visiblefacturaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String CABECONSIGNATARIO= "cabe_consignatario";
    public static final String CABETIPOTASA= "cabe_tipo_tasa";
    public static final String CABECONSULTOR= "cabe_consultor";
    public static final String CABEICE= "cabe_ice";
    public static final String CABETRANSPORTE= "cabe_transporte";
    public static final String CABEFUE= "cabe_fue";
    public static final String CABEORDEN= "cabe_orden";
    public static final String DETAAUTORIPRECIO= "deta_autori_precio";
    public static final String DETAAREA= "deta_area";
    public static final String DETAFOTO= "deta_foto";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_CABECONSIGNATARIO= "Consignatario";
		public static final String LABEL_CABECONSIGNATARIO_LOWER= "Cabe Consignatario";
    	public static final String LABEL_CABETIPOTASA= "Tipo Tasa";
		public static final String LABEL_CABETIPOTASA_LOWER= "Cabe Tipo Tasa";
    	public static final String LABEL_CABECONSULTOR= "Consultor";
		public static final String LABEL_CABECONSULTOR_LOWER= "Cabe Consultor";
    	public static final String LABEL_CABEICE= "Ice";
		public static final String LABEL_CABEICE_LOWER= "Cabe Ice";
    	public static final String LABEL_CABETRANSPORTE= "Transporte";
		public static final String LABEL_CABETRANSPORTE_LOWER= "Cabe Transporte";
    	public static final String LABEL_CABEFUE= "Fuente";
		public static final String LABEL_CABEFUE_LOWER= "Cabe Fue";
    	public static final String LABEL_CABEORDEN= "Orden";
		public static final String LABEL_CABEORDEN_LOWER= "Cabe Orden";
    	public static final String LABEL_DETAAUTORIPRECIO= "Autorizacion Precio";
		public static final String LABEL_DETAAUTORIPRECIO_LOWER= "Deta Autori Precio";
    	public static final String LABEL_DETAAREA= "Area";
		public static final String LABEL_DETAAREA_LOWER= "Deta Area";
    	public static final String LABEL_DETAFOTO= "Foto";
		public static final String LABEL_DETAFOTO_LOWER= "Deta Foto";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getVisibleFacturaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(VisibleFacturaConstantesFunciones.IDEMPRESA)) {sLabelColumna=VisibleFacturaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(VisibleFacturaConstantesFunciones.CABECONSIGNATARIO)) {sLabelColumna=VisibleFacturaConstantesFunciones.LABEL_CABECONSIGNATARIO;}
		if(sNombreColumna.equals(VisibleFacturaConstantesFunciones.CABETIPOTASA)) {sLabelColumna=VisibleFacturaConstantesFunciones.LABEL_CABETIPOTASA;}
		if(sNombreColumna.equals(VisibleFacturaConstantesFunciones.CABECONSULTOR)) {sLabelColumna=VisibleFacturaConstantesFunciones.LABEL_CABECONSULTOR;}
		if(sNombreColumna.equals(VisibleFacturaConstantesFunciones.CABEICE)) {sLabelColumna=VisibleFacturaConstantesFunciones.LABEL_CABEICE;}
		if(sNombreColumna.equals(VisibleFacturaConstantesFunciones.CABETRANSPORTE)) {sLabelColumna=VisibleFacturaConstantesFunciones.LABEL_CABETRANSPORTE;}
		if(sNombreColumna.equals(VisibleFacturaConstantesFunciones.CABEFUE)) {sLabelColumna=VisibleFacturaConstantesFunciones.LABEL_CABEFUE;}
		if(sNombreColumna.equals(VisibleFacturaConstantesFunciones.CABEORDEN)) {sLabelColumna=VisibleFacturaConstantesFunciones.LABEL_CABEORDEN;}
		if(sNombreColumna.equals(VisibleFacturaConstantesFunciones.DETAAUTORIPRECIO)) {sLabelColumna=VisibleFacturaConstantesFunciones.LABEL_DETAAUTORIPRECIO;}
		if(sNombreColumna.equals(VisibleFacturaConstantesFunciones.DETAAREA)) {sLabelColumna=VisibleFacturaConstantesFunciones.LABEL_DETAAREA;}
		if(sNombreColumna.equals(VisibleFacturaConstantesFunciones.DETAFOTO)) {sLabelColumna=VisibleFacturaConstantesFunciones.LABEL_DETAFOTO;}
		
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
	
	
	
			
			
			
		
	public static String getcabe_consignatarioDescripcion(VisibleFactura visiblefactura) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!visiblefactura.getcabe_consignatario()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcabe_consignatarioHtmlDescripcion(VisibleFactura visiblefactura) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(visiblefactura.getId(),visiblefactura.getcabe_consignatario());

		return sDescripcion;
	}	
		
	public static String getcabe_tipo_tasaDescripcion(VisibleFactura visiblefactura) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!visiblefactura.getcabe_tipo_tasa()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcabe_tipo_tasaHtmlDescripcion(VisibleFactura visiblefactura) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(visiblefactura.getId(),visiblefactura.getcabe_tipo_tasa());

		return sDescripcion;
	}	
		
	public static String getcabe_consultorDescripcion(VisibleFactura visiblefactura) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!visiblefactura.getcabe_consultor()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcabe_consultorHtmlDescripcion(VisibleFactura visiblefactura) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(visiblefactura.getId(),visiblefactura.getcabe_consultor());

		return sDescripcion;
	}	
		
	public static String getcabe_iceDescripcion(VisibleFactura visiblefactura) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!visiblefactura.getcabe_ice()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcabe_iceHtmlDescripcion(VisibleFactura visiblefactura) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(visiblefactura.getId(),visiblefactura.getcabe_ice());

		return sDescripcion;
	}	
		
	public static String getcabe_transporteDescripcion(VisibleFactura visiblefactura) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!visiblefactura.getcabe_transporte()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcabe_transporteHtmlDescripcion(VisibleFactura visiblefactura) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(visiblefactura.getId(),visiblefactura.getcabe_transporte());

		return sDescripcion;
	}	
		
	public static String getcabe_fueDescripcion(VisibleFactura visiblefactura) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!visiblefactura.getcabe_fue()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcabe_fueHtmlDescripcion(VisibleFactura visiblefactura) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(visiblefactura.getId(),visiblefactura.getcabe_fue());

		return sDescripcion;
	}	
		
	public static String getcabe_ordenDescripcion(VisibleFactura visiblefactura) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!visiblefactura.getcabe_orden()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcabe_ordenHtmlDescripcion(VisibleFactura visiblefactura) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(visiblefactura.getId(),visiblefactura.getcabe_orden());

		return sDescripcion;
	}	
		
	public static String getdeta_autori_precioDescripcion(VisibleFactura visiblefactura) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!visiblefactura.getdeta_autori_precio()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getdeta_autori_precioHtmlDescripcion(VisibleFactura visiblefactura) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(visiblefactura.getId(),visiblefactura.getdeta_autori_precio());

		return sDescripcion;
	}	
		
	public static String getdeta_areaDescripcion(VisibleFactura visiblefactura) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!visiblefactura.getdeta_area()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getdeta_areaHtmlDescripcion(VisibleFactura visiblefactura) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(visiblefactura.getId(),visiblefactura.getdeta_area());

		return sDescripcion;
	}	
		
	public static String getdeta_fotoDescripcion(VisibleFactura visiblefactura) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!visiblefactura.getdeta_foto()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getdeta_fotoHtmlDescripcion(VisibleFactura visiblefactura) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(visiblefactura.getId(),visiblefactura.getdeta_foto());

		return sDescripcion;
	}	
	
	public static String getVisibleFacturaDescripcion(VisibleFactura visiblefactura) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(visiblefactura !=null/* && visiblefactura.getId()!=0*/) {
			if(visiblefactura.getId()!=null) {
				sDescripcion=visiblefactura.getId().toString();
			}//visiblefacturavisiblefactura.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getVisibleFacturaDescripcionDetallado(VisibleFactura visiblefactura) {
		String sDescripcion="";
			
		sDescripcion+=VisibleFacturaConstantesFunciones.ID+"=";
		sDescripcion+=visiblefactura.getId().toString()+",";
		sDescripcion+=VisibleFacturaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=visiblefactura.getVersionRow().toString()+",";
		sDescripcion+=VisibleFacturaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=visiblefactura.getid_empresa().toString()+",";
		sDescripcion+=VisibleFacturaConstantesFunciones.CABECONSIGNATARIO+"=";
		sDescripcion+=visiblefactura.getcabe_consignatario().toString()+",";
		sDescripcion+=VisibleFacturaConstantesFunciones.CABETIPOTASA+"=";
		sDescripcion+=visiblefactura.getcabe_tipo_tasa().toString()+",";
		sDescripcion+=VisibleFacturaConstantesFunciones.CABECONSULTOR+"=";
		sDescripcion+=visiblefactura.getcabe_consultor().toString()+",";
		sDescripcion+=VisibleFacturaConstantesFunciones.CABEICE+"=";
		sDescripcion+=visiblefactura.getcabe_ice().toString()+",";
		sDescripcion+=VisibleFacturaConstantesFunciones.CABETRANSPORTE+"=";
		sDescripcion+=visiblefactura.getcabe_transporte().toString()+",";
		sDescripcion+=VisibleFacturaConstantesFunciones.CABEFUE+"=";
		sDescripcion+=visiblefactura.getcabe_fue().toString()+",";
		sDescripcion+=VisibleFacturaConstantesFunciones.CABEORDEN+"=";
		sDescripcion+=visiblefactura.getcabe_orden().toString()+",";
		sDescripcion+=VisibleFacturaConstantesFunciones.DETAAUTORIPRECIO+"=";
		sDescripcion+=visiblefactura.getdeta_autori_precio().toString()+",";
		sDescripcion+=VisibleFacturaConstantesFunciones.DETAAREA+"=";
		sDescripcion+=visiblefactura.getdeta_area().toString()+",";
		sDescripcion+=VisibleFacturaConstantesFunciones.DETAFOTO+"=";
		sDescripcion+=visiblefactura.getdeta_foto().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setVisibleFacturaDescripcion(VisibleFactura visiblefactura,String sValor) throws Exception {			
		if(visiblefactura !=null) {
			//visiblefacturavisiblefactura.getId().toString();
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
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosVisibleFactura(VisibleFactura visiblefactura,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosVisibleFacturas(List<VisibleFactura> visiblefacturas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(VisibleFactura visiblefactura: visiblefacturas) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresVisibleFactura(VisibleFactura visiblefactura,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && visiblefactura.getConCambioAuxiliar()) {
			visiblefactura.setIsDeleted(visiblefactura.getIsDeletedAuxiliar());	
			visiblefactura.setIsNew(visiblefactura.getIsNewAuxiliar());	
			visiblefactura.setIsChanged(visiblefactura.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			visiblefactura.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			visiblefactura.setIsDeletedAuxiliar(false);	
			visiblefactura.setIsNewAuxiliar(false);	
			visiblefactura.setIsChangedAuxiliar(false);
			
			visiblefactura.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresVisibleFacturas(List<VisibleFactura> visiblefacturas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(VisibleFactura visiblefactura : visiblefacturas) {
			if(conAsignarBase && visiblefactura.getConCambioAuxiliar()) {
				visiblefactura.setIsDeleted(visiblefactura.getIsDeletedAuxiliar());	
				visiblefactura.setIsNew(visiblefactura.getIsNewAuxiliar());	
				visiblefactura.setIsChanged(visiblefactura.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				visiblefactura.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				visiblefactura.setIsDeletedAuxiliar(false);	
				visiblefactura.setIsNewAuxiliar(false);	
				visiblefactura.setIsChangedAuxiliar(false);
				
				visiblefactura.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresVisibleFactura(VisibleFactura visiblefactura,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresVisibleFacturas(List<VisibleFactura> visiblefacturas,Boolean conEnteros) throws Exception  {
		
		for(VisibleFactura visiblefactura: visiblefacturas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaVisibleFactura(List<VisibleFactura> visiblefacturas,VisibleFactura visiblefacturaAux) throws Exception  {
		VisibleFacturaConstantesFunciones.InicializarValoresVisibleFactura(visiblefacturaAux,true);
		
		for(VisibleFactura visiblefactura: visiblefacturas) {
			if(visiblefactura.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesVisibleFactura(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=VisibleFacturaConstantesFunciones.getArrayColumnasGlobalesVisibleFactura(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesVisibleFactura(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(VisibleFacturaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(VisibleFacturaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoVisibleFactura(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<VisibleFactura> visiblefacturas,VisibleFactura visiblefactura,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(VisibleFactura visiblefacturaAux: visiblefacturas) {
			if(visiblefacturaAux!=null && visiblefactura!=null) {
				if((visiblefacturaAux.getId()==null && visiblefactura.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(visiblefacturaAux.getId()!=null && visiblefactura.getId()!=null){
					if(visiblefacturaAux.getId().equals(visiblefactura.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaVisibleFactura(List<VisibleFactura> visiblefacturas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(VisibleFactura visiblefactura: visiblefacturas) {			
			if(visiblefactura.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaVisibleFactura() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,VisibleFacturaConstantesFunciones.LABEL_ID, VisibleFacturaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VisibleFacturaConstantesFunciones.LABEL_VERSIONROW, VisibleFacturaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VisibleFacturaConstantesFunciones.LABEL_IDEMPRESA, VisibleFacturaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VisibleFacturaConstantesFunciones.LABEL_CABECONSIGNATARIO, VisibleFacturaConstantesFunciones.CABECONSIGNATARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VisibleFacturaConstantesFunciones.LABEL_CABETIPOTASA, VisibleFacturaConstantesFunciones.CABETIPOTASA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VisibleFacturaConstantesFunciones.LABEL_CABECONSULTOR, VisibleFacturaConstantesFunciones.CABECONSULTOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VisibleFacturaConstantesFunciones.LABEL_CABEICE, VisibleFacturaConstantesFunciones.CABEICE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VisibleFacturaConstantesFunciones.LABEL_CABETRANSPORTE, VisibleFacturaConstantesFunciones.CABETRANSPORTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VisibleFacturaConstantesFunciones.LABEL_CABEFUE, VisibleFacturaConstantesFunciones.CABEFUE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VisibleFacturaConstantesFunciones.LABEL_CABEORDEN, VisibleFacturaConstantesFunciones.CABEORDEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VisibleFacturaConstantesFunciones.LABEL_DETAAUTORIPRECIO, VisibleFacturaConstantesFunciones.DETAAUTORIPRECIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VisibleFacturaConstantesFunciones.LABEL_DETAAREA, VisibleFacturaConstantesFunciones.DETAAREA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VisibleFacturaConstantesFunciones.LABEL_DETAFOTO, VisibleFacturaConstantesFunciones.DETAFOTO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasVisibleFactura() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=VisibleFacturaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VisibleFacturaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VisibleFacturaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VisibleFacturaConstantesFunciones.CABECONSIGNATARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VisibleFacturaConstantesFunciones.CABETIPOTASA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VisibleFacturaConstantesFunciones.CABECONSULTOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VisibleFacturaConstantesFunciones.CABEICE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VisibleFacturaConstantesFunciones.CABETRANSPORTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VisibleFacturaConstantesFunciones.CABEFUE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VisibleFacturaConstantesFunciones.CABEORDEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VisibleFacturaConstantesFunciones.DETAAUTORIPRECIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VisibleFacturaConstantesFunciones.DETAAREA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VisibleFacturaConstantesFunciones.DETAFOTO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVisibleFactura() throws Exception  {
		return VisibleFacturaConstantesFunciones.getTiposSeleccionarVisibleFactura(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVisibleFactura(Boolean conFk) throws Exception  {
		return VisibleFacturaConstantesFunciones.getTiposSeleccionarVisibleFactura(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVisibleFactura(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VisibleFacturaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(VisibleFacturaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VisibleFacturaConstantesFunciones.LABEL_CABECONSIGNATARIO);
			reporte.setsDescripcion(VisibleFacturaConstantesFunciones.LABEL_CABECONSIGNATARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VisibleFacturaConstantesFunciones.LABEL_CABETIPOTASA);
			reporte.setsDescripcion(VisibleFacturaConstantesFunciones.LABEL_CABETIPOTASA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VisibleFacturaConstantesFunciones.LABEL_CABECONSULTOR);
			reporte.setsDescripcion(VisibleFacturaConstantesFunciones.LABEL_CABECONSULTOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VisibleFacturaConstantesFunciones.LABEL_CABEICE);
			reporte.setsDescripcion(VisibleFacturaConstantesFunciones.LABEL_CABEICE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VisibleFacturaConstantesFunciones.LABEL_CABETRANSPORTE);
			reporte.setsDescripcion(VisibleFacturaConstantesFunciones.LABEL_CABETRANSPORTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VisibleFacturaConstantesFunciones.LABEL_CABEFUE);
			reporte.setsDescripcion(VisibleFacturaConstantesFunciones.LABEL_CABEFUE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VisibleFacturaConstantesFunciones.LABEL_CABEORDEN);
			reporte.setsDescripcion(VisibleFacturaConstantesFunciones.LABEL_CABEORDEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VisibleFacturaConstantesFunciones.LABEL_DETAAUTORIPRECIO);
			reporte.setsDescripcion(VisibleFacturaConstantesFunciones.LABEL_DETAAUTORIPRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VisibleFacturaConstantesFunciones.LABEL_DETAAREA);
			reporte.setsDescripcion(VisibleFacturaConstantesFunciones.LABEL_DETAAREA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VisibleFacturaConstantesFunciones.LABEL_DETAFOTO);
			reporte.setsDescripcion(VisibleFacturaConstantesFunciones.LABEL_DETAFOTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesVisibleFactura(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesVisibleFactura(VisibleFactura visiblefacturaAux) throws Exception {
		
			visiblefacturaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(visiblefacturaAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesVisibleFactura(List<VisibleFactura> visiblefacturasTemp) throws Exception {
		for(VisibleFactura visiblefacturaAux:visiblefacturasTemp) {
			
			visiblefacturaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(visiblefacturaAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfVisibleFactura(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfVisibleFactura(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfVisibleFactura(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return VisibleFacturaConstantesFunciones.getClassesRelationshipsOfVisibleFactura(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfVisibleFactura(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfVisibleFactura(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return VisibleFacturaConstantesFunciones.getClassesRelationshipsFromStringsOfVisibleFactura(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfVisibleFactura(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(VisibleFactura visiblefactura,List<VisibleFactura> visiblefacturas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			VisibleFactura visiblefacturaEncontrado=null;
			
			for(VisibleFactura visiblefacturaLocal:visiblefacturas) {
				if(visiblefacturaLocal.getId().equals(visiblefactura.getId())) {
					visiblefacturaEncontrado=visiblefacturaLocal;
					
					visiblefacturaLocal.setIsChanged(visiblefactura.getIsChanged());
					visiblefacturaLocal.setIsNew(visiblefactura.getIsNew());
					visiblefacturaLocal.setIsDeleted(visiblefactura.getIsDeleted());
					
					visiblefacturaLocal.setGeneralEntityOriginal(visiblefactura.getGeneralEntityOriginal());
					
					visiblefacturaLocal.setId(visiblefactura.getId());	
					visiblefacturaLocal.setVersionRow(visiblefactura.getVersionRow());	
					visiblefacturaLocal.setid_empresa(visiblefactura.getid_empresa());	
					visiblefacturaLocal.setcabe_consignatario(visiblefactura.getcabe_consignatario());	
					visiblefacturaLocal.setcabe_tipo_tasa(visiblefactura.getcabe_tipo_tasa());	
					visiblefacturaLocal.setcabe_consultor(visiblefactura.getcabe_consultor());	
					visiblefacturaLocal.setcabe_ice(visiblefactura.getcabe_ice());	
					visiblefacturaLocal.setcabe_transporte(visiblefactura.getcabe_transporte());	
					visiblefacturaLocal.setcabe_fue(visiblefactura.getcabe_fue());	
					visiblefacturaLocal.setcabe_orden(visiblefactura.getcabe_orden());	
					visiblefacturaLocal.setdeta_autori_precio(visiblefactura.getdeta_autori_precio());	
					visiblefacturaLocal.setdeta_area(visiblefactura.getdeta_area());	
					visiblefacturaLocal.setdeta_foto(visiblefactura.getdeta_foto());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!visiblefactura.getIsDeleted()) {
				if(!existe) {
					visiblefacturas.add(visiblefactura);
				}
			} else {
				if(visiblefacturaEncontrado!=null && permiteQuitar)  {
					visiblefacturas.remove(visiblefacturaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(VisibleFactura visiblefactura,List<VisibleFactura> visiblefacturas) throws Exception {
		try	{			
			for(VisibleFactura visiblefacturaLocal:visiblefacturas) {
				if(visiblefacturaLocal.getId().equals(visiblefactura.getId())) {
					visiblefacturaLocal.setIsSelected(visiblefactura.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesVisibleFactura(List<VisibleFactura> visiblefacturasAux) throws Exception {
		//this.visiblefacturasAux=visiblefacturasAux;
		
		for(VisibleFactura visiblefacturaAux:visiblefacturasAux) {
			if(visiblefacturaAux.getIsChanged()) {
				visiblefacturaAux.setIsChanged(false);
			}		
			
			if(visiblefacturaAux.getIsNew()) {
				visiblefacturaAux.setIsNew(false);
			}	
			
			if(visiblefacturaAux.getIsDeleted()) {
				visiblefacturaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesVisibleFactura(VisibleFactura visiblefacturaAux) throws Exception {
		//this.visiblefacturaAux=visiblefacturaAux;
		
			if(visiblefacturaAux.getIsChanged()) {
				visiblefacturaAux.setIsChanged(false);
			}		
			
			if(visiblefacturaAux.getIsNew()) {
				visiblefacturaAux.setIsNew(false);
			}	
			
			if(visiblefacturaAux.getIsDeleted()) {
				visiblefacturaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(VisibleFactura visiblefacturaAsignar,VisibleFactura visiblefactura) throws Exception {
		visiblefacturaAsignar.setId(visiblefactura.getId());	
		visiblefacturaAsignar.setVersionRow(visiblefactura.getVersionRow());	
		visiblefacturaAsignar.setid_empresa(visiblefactura.getid_empresa());
		visiblefacturaAsignar.setempresa_descripcion(visiblefactura.getempresa_descripcion());	
		visiblefacturaAsignar.setcabe_consignatario(visiblefactura.getcabe_consignatario());	
		visiblefacturaAsignar.setcabe_tipo_tasa(visiblefactura.getcabe_tipo_tasa());	
		visiblefacturaAsignar.setcabe_consultor(visiblefactura.getcabe_consultor());	
		visiblefacturaAsignar.setcabe_ice(visiblefactura.getcabe_ice());	
		visiblefacturaAsignar.setcabe_transporte(visiblefactura.getcabe_transporte());	
		visiblefacturaAsignar.setcabe_fue(visiblefactura.getcabe_fue());	
		visiblefacturaAsignar.setcabe_orden(visiblefactura.getcabe_orden());	
		visiblefacturaAsignar.setdeta_autori_precio(visiblefactura.getdeta_autori_precio());	
		visiblefacturaAsignar.setdeta_area(visiblefactura.getdeta_area());	
		visiblefacturaAsignar.setdeta_foto(visiblefactura.getdeta_foto());	
	}
	
	public static void inicializarVisibleFactura(VisibleFactura visiblefactura) throws Exception {
		try {
				visiblefactura.setId(0L);	
					
				visiblefactura.setid_empresa(-1L);	
				visiblefactura.setcabe_consignatario(false);	
				visiblefactura.setcabe_tipo_tasa(false);	
				visiblefactura.setcabe_consultor(false);	
				visiblefactura.setcabe_ice(false);	
				visiblefactura.setcabe_transporte(false);	
				visiblefactura.setcabe_fue(false);	
				visiblefactura.setcabe_orden(false);	
				visiblefactura.setdeta_autori_precio(false);	
				visiblefactura.setdeta_area(false);	
				visiblefactura.setdeta_foto(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderVisibleFactura(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(VisibleFacturaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VisibleFacturaConstantesFunciones.LABEL_CABECONSIGNATARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VisibleFacturaConstantesFunciones.LABEL_CABETIPOTASA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VisibleFacturaConstantesFunciones.LABEL_CABECONSULTOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VisibleFacturaConstantesFunciones.LABEL_CABEICE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VisibleFacturaConstantesFunciones.LABEL_CABETRANSPORTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VisibleFacturaConstantesFunciones.LABEL_CABEFUE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VisibleFacturaConstantesFunciones.LABEL_CABEORDEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VisibleFacturaConstantesFunciones.LABEL_DETAAUTORIPRECIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VisibleFacturaConstantesFunciones.LABEL_DETAAREA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VisibleFacturaConstantesFunciones.LABEL_DETAFOTO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataVisibleFactura(String sTipo,Row row,Workbook workbook,VisibleFactura visiblefactura,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(visiblefactura.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(visiblefactura.getcabe_consignatario()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(visiblefactura.getcabe_tipo_tasa()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(visiblefactura.getcabe_consultor()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(visiblefactura.getcabe_ice()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(visiblefactura.getcabe_transporte()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(visiblefactura.getcabe_fue()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(visiblefactura.getcabe_orden()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(visiblefactura.getdeta_autori_precio()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(visiblefactura.getdeta_area()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(visiblefactura.getdeta_foto()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryVisibleFactura=Constantes.SFINALQUERY;
	
	public String getsFinalQueryVisibleFactura() {
		return this.sFinalQueryVisibleFactura;
	}
	
	public void setsFinalQueryVisibleFactura(String sFinalQueryVisibleFactura) {
		this.sFinalQueryVisibleFactura= sFinalQueryVisibleFactura;
	}
	
	public Border resaltarSeleccionarVisibleFactura=null;
	
	public Border setResaltarSeleccionarVisibleFactura(ParametroGeneralUsuario parametroGeneralUsuario/*VisibleFacturaBeanSwingJInternalFrame visiblefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//visiblefacturaBeanSwingJInternalFrame.jTtoolBarVisibleFactura.setBorder(borderResaltar);
		
		this.resaltarSeleccionarVisibleFactura= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarVisibleFactura() {
		return this.resaltarSeleccionarVisibleFactura;
	}
	
	public void setResaltarSeleccionarVisibleFactura(Border borderResaltarSeleccionarVisibleFactura) {
		this.resaltarSeleccionarVisibleFactura= borderResaltarSeleccionarVisibleFactura;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridVisibleFactura=null;
	public Boolean mostraridVisibleFactura=true;
	public Boolean activaridVisibleFactura=true;

	public Border resaltarid_empresaVisibleFactura=null;
	public Boolean mostrarid_empresaVisibleFactura=true;
	public Boolean activarid_empresaVisibleFactura=true;
	public Boolean cargarid_empresaVisibleFactura=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaVisibleFactura=false;//ConEventDepend=true

	public Border resaltarcabe_consignatarioVisibleFactura=null;
	public Boolean mostrarcabe_consignatarioVisibleFactura=true;
	public Boolean activarcabe_consignatarioVisibleFactura=true;

	public Border resaltarcabe_tipo_tasaVisibleFactura=null;
	public Boolean mostrarcabe_tipo_tasaVisibleFactura=true;
	public Boolean activarcabe_tipo_tasaVisibleFactura=true;

	public Border resaltarcabe_consultorVisibleFactura=null;
	public Boolean mostrarcabe_consultorVisibleFactura=true;
	public Boolean activarcabe_consultorVisibleFactura=true;

	public Border resaltarcabe_iceVisibleFactura=null;
	public Boolean mostrarcabe_iceVisibleFactura=true;
	public Boolean activarcabe_iceVisibleFactura=true;

	public Border resaltarcabe_transporteVisibleFactura=null;
	public Boolean mostrarcabe_transporteVisibleFactura=true;
	public Boolean activarcabe_transporteVisibleFactura=true;

	public Border resaltarcabe_fueVisibleFactura=null;
	public Boolean mostrarcabe_fueVisibleFactura=true;
	public Boolean activarcabe_fueVisibleFactura=true;

	public Border resaltarcabe_ordenVisibleFactura=null;
	public Boolean mostrarcabe_ordenVisibleFactura=true;
	public Boolean activarcabe_ordenVisibleFactura=true;

	public Border resaltardeta_autori_precioVisibleFactura=null;
	public Boolean mostrardeta_autori_precioVisibleFactura=true;
	public Boolean activardeta_autori_precioVisibleFactura=true;

	public Border resaltardeta_areaVisibleFactura=null;
	public Boolean mostrardeta_areaVisibleFactura=true;
	public Boolean activardeta_areaVisibleFactura=true;

	public Border resaltardeta_fotoVisibleFactura=null;
	public Boolean mostrardeta_fotoVisibleFactura=true;
	public Boolean activardeta_fotoVisibleFactura=true;

	
	

	public Border setResaltaridVisibleFactura(ParametroGeneralUsuario parametroGeneralUsuario/*VisibleFacturaBeanSwingJInternalFrame visiblefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//visiblefacturaBeanSwingJInternalFrame.jTtoolBarVisibleFactura.setBorder(borderResaltar);
		
		this.resaltaridVisibleFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridVisibleFactura() {
		return this.resaltaridVisibleFactura;
	}

	public void setResaltaridVisibleFactura(Border borderResaltar) {
		this.resaltaridVisibleFactura= borderResaltar;
	}

	public Boolean getMostraridVisibleFactura() {
		return this.mostraridVisibleFactura;
	}

	public void setMostraridVisibleFactura(Boolean mostraridVisibleFactura) {
		this.mostraridVisibleFactura= mostraridVisibleFactura;
	}

	public Boolean getActivaridVisibleFactura() {
		return this.activaridVisibleFactura;
	}

	public void setActivaridVisibleFactura(Boolean activaridVisibleFactura) {
		this.activaridVisibleFactura= activaridVisibleFactura;
	}

	public Border setResaltarid_empresaVisibleFactura(ParametroGeneralUsuario parametroGeneralUsuario/*VisibleFacturaBeanSwingJInternalFrame visiblefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//visiblefacturaBeanSwingJInternalFrame.jTtoolBarVisibleFactura.setBorder(borderResaltar);
		
		this.resaltarid_empresaVisibleFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaVisibleFactura() {
		return this.resaltarid_empresaVisibleFactura;
	}

	public void setResaltarid_empresaVisibleFactura(Border borderResaltar) {
		this.resaltarid_empresaVisibleFactura= borderResaltar;
	}

	public Boolean getMostrarid_empresaVisibleFactura() {
		return this.mostrarid_empresaVisibleFactura;
	}

	public void setMostrarid_empresaVisibleFactura(Boolean mostrarid_empresaVisibleFactura) {
		this.mostrarid_empresaVisibleFactura= mostrarid_empresaVisibleFactura;
	}

	public Boolean getActivarid_empresaVisibleFactura() {
		return this.activarid_empresaVisibleFactura;
	}

	public void setActivarid_empresaVisibleFactura(Boolean activarid_empresaVisibleFactura) {
		this.activarid_empresaVisibleFactura= activarid_empresaVisibleFactura;
	}

	public Boolean getCargarid_empresaVisibleFactura() {
		return this.cargarid_empresaVisibleFactura;
	}

	public void setCargarid_empresaVisibleFactura(Boolean cargarid_empresaVisibleFactura) {
		this.cargarid_empresaVisibleFactura= cargarid_empresaVisibleFactura;
	}

	public Border setResaltarcabe_consignatarioVisibleFactura(ParametroGeneralUsuario parametroGeneralUsuario/*VisibleFacturaBeanSwingJInternalFrame visiblefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//visiblefacturaBeanSwingJInternalFrame.jTtoolBarVisibleFactura.setBorder(borderResaltar);
		
		this.resaltarcabe_consignatarioVisibleFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcabe_consignatarioVisibleFactura() {
		return this.resaltarcabe_consignatarioVisibleFactura;
	}

	public void setResaltarcabe_consignatarioVisibleFactura(Border borderResaltar) {
		this.resaltarcabe_consignatarioVisibleFactura= borderResaltar;
	}

	public Boolean getMostrarcabe_consignatarioVisibleFactura() {
		return this.mostrarcabe_consignatarioVisibleFactura;
	}

	public void setMostrarcabe_consignatarioVisibleFactura(Boolean mostrarcabe_consignatarioVisibleFactura) {
		this.mostrarcabe_consignatarioVisibleFactura= mostrarcabe_consignatarioVisibleFactura;
	}

	public Boolean getActivarcabe_consignatarioVisibleFactura() {
		return this.activarcabe_consignatarioVisibleFactura;
	}

	public void setActivarcabe_consignatarioVisibleFactura(Boolean activarcabe_consignatarioVisibleFactura) {
		this.activarcabe_consignatarioVisibleFactura= activarcabe_consignatarioVisibleFactura;
	}

	public Border setResaltarcabe_tipo_tasaVisibleFactura(ParametroGeneralUsuario parametroGeneralUsuario/*VisibleFacturaBeanSwingJInternalFrame visiblefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//visiblefacturaBeanSwingJInternalFrame.jTtoolBarVisibleFactura.setBorder(borderResaltar);
		
		this.resaltarcabe_tipo_tasaVisibleFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcabe_tipo_tasaVisibleFactura() {
		return this.resaltarcabe_tipo_tasaVisibleFactura;
	}

	public void setResaltarcabe_tipo_tasaVisibleFactura(Border borderResaltar) {
		this.resaltarcabe_tipo_tasaVisibleFactura= borderResaltar;
	}

	public Boolean getMostrarcabe_tipo_tasaVisibleFactura() {
		return this.mostrarcabe_tipo_tasaVisibleFactura;
	}

	public void setMostrarcabe_tipo_tasaVisibleFactura(Boolean mostrarcabe_tipo_tasaVisibleFactura) {
		this.mostrarcabe_tipo_tasaVisibleFactura= mostrarcabe_tipo_tasaVisibleFactura;
	}

	public Boolean getActivarcabe_tipo_tasaVisibleFactura() {
		return this.activarcabe_tipo_tasaVisibleFactura;
	}

	public void setActivarcabe_tipo_tasaVisibleFactura(Boolean activarcabe_tipo_tasaVisibleFactura) {
		this.activarcabe_tipo_tasaVisibleFactura= activarcabe_tipo_tasaVisibleFactura;
	}

	public Border setResaltarcabe_consultorVisibleFactura(ParametroGeneralUsuario parametroGeneralUsuario/*VisibleFacturaBeanSwingJInternalFrame visiblefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//visiblefacturaBeanSwingJInternalFrame.jTtoolBarVisibleFactura.setBorder(borderResaltar);
		
		this.resaltarcabe_consultorVisibleFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcabe_consultorVisibleFactura() {
		return this.resaltarcabe_consultorVisibleFactura;
	}

	public void setResaltarcabe_consultorVisibleFactura(Border borderResaltar) {
		this.resaltarcabe_consultorVisibleFactura= borderResaltar;
	}

	public Boolean getMostrarcabe_consultorVisibleFactura() {
		return this.mostrarcabe_consultorVisibleFactura;
	}

	public void setMostrarcabe_consultorVisibleFactura(Boolean mostrarcabe_consultorVisibleFactura) {
		this.mostrarcabe_consultorVisibleFactura= mostrarcabe_consultorVisibleFactura;
	}

	public Boolean getActivarcabe_consultorVisibleFactura() {
		return this.activarcabe_consultorVisibleFactura;
	}

	public void setActivarcabe_consultorVisibleFactura(Boolean activarcabe_consultorVisibleFactura) {
		this.activarcabe_consultorVisibleFactura= activarcabe_consultorVisibleFactura;
	}

	public Border setResaltarcabe_iceVisibleFactura(ParametroGeneralUsuario parametroGeneralUsuario/*VisibleFacturaBeanSwingJInternalFrame visiblefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//visiblefacturaBeanSwingJInternalFrame.jTtoolBarVisibleFactura.setBorder(borderResaltar);
		
		this.resaltarcabe_iceVisibleFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcabe_iceVisibleFactura() {
		return this.resaltarcabe_iceVisibleFactura;
	}

	public void setResaltarcabe_iceVisibleFactura(Border borderResaltar) {
		this.resaltarcabe_iceVisibleFactura= borderResaltar;
	}

	public Boolean getMostrarcabe_iceVisibleFactura() {
		return this.mostrarcabe_iceVisibleFactura;
	}

	public void setMostrarcabe_iceVisibleFactura(Boolean mostrarcabe_iceVisibleFactura) {
		this.mostrarcabe_iceVisibleFactura= mostrarcabe_iceVisibleFactura;
	}

	public Boolean getActivarcabe_iceVisibleFactura() {
		return this.activarcabe_iceVisibleFactura;
	}

	public void setActivarcabe_iceVisibleFactura(Boolean activarcabe_iceVisibleFactura) {
		this.activarcabe_iceVisibleFactura= activarcabe_iceVisibleFactura;
	}

	public Border setResaltarcabe_transporteVisibleFactura(ParametroGeneralUsuario parametroGeneralUsuario/*VisibleFacturaBeanSwingJInternalFrame visiblefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//visiblefacturaBeanSwingJInternalFrame.jTtoolBarVisibleFactura.setBorder(borderResaltar);
		
		this.resaltarcabe_transporteVisibleFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcabe_transporteVisibleFactura() {
		return this.resaltarcabe_transporteVisibleFactura;
	}

	public void setResaltarcabe_transporteVisibleFactura(Border borderResaltar) {
		this.resaltarcabe_transporteVisibleFactura= borderResaltar;
	}

	public Boolean getMostrarcabe_transporteVisibleFactura() {
		return this.mostrarcabe_transporteVisibleFactura;
	}

	public void setMostrarcabe_transporteVisibleFactura(Boolean mostrarcabe_transporteVisibleFactura) {
		this.mostrarcabe_transporteVisibleFactura= mostrarcabe_transporteVisibleFactura;
	}

	public Boolean getActivarcabe_transporteVisibleFactura() {
		return this.activarcabe_transporteVisibleFactura;
	}

	public void setActivarcabe_transporteVisibleFactura(Boolean activarcabe_transporteVisibleFactura) {
		this.activarcabe_transporteVisibleFactura= activarcabe_transporteVisibleFactura;
	}

	public Border setResaltarcabe_fueVisibleFactura(ParametroGeneralUsuario parametroGeneralUsuario/*VisibleFacturaBeanSwingJInternalFrame visiblefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//visiblefacturaBeanSwingJInternalFrame.jTtoolBarVisibleFactura.setBorder(borderResaltar);
		
		this.resaltarcabe_fueVisibleFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcabe_fueVisibleFactura() {
		return this.resaltarcabe_fueVisibleFactura;
	}

	public void setResaltarcabe_fueVisibleFactura(Border borderResaltar) {
		this.resaltarcabe_fueVisibleFactura= borderResaltar;
	}

	public Boolean getMostrarcabe_fueVisibleFactura() {
		return this.mostrarcabe_fueVisibleFactura;
	}

	public void setMostrarcabe_fueVisibleFactura(Boolean mostrarcabe_fueVisibleFactura) {
		this.mostrarcabe_fueVisibleFactura= mostrarcabe_fueVisibleFactura;
	}

	public Boolean getActivarcabe_fueVisibleFactura() {
		return this.activarcabe_fueVisibleFactura;
	}

	public void setActivarcabe_fueVisibleFactura(Boolean activarcabe_fueVisibleFactura) {
		this.activarcabe_fueVisibleFactura= activarcabe_fueVisibleFactura;
	}

	public Border setResaltarcabe_ordenVisibleFactura(ParametroGeneralUsuario parametroGeneralUsuario/*VisibleFacturaBeanSwingJInternalFrame visiblefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//visiblefacturaBeanSwingJInternalFrame.jTtoolBarVisibleFactura.setBorder(borderResaltar);
		
		this.resaltarcabe_ordenVisibleFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcabe_ordenVisibleFactura() {
		return this.resaltarcabe_ordenVisibleFactura;
	}

	public void setResaltarcabe_ordenVisibleFactura(Border borderResaltar) {
		this.resaltarcabe_ordenVisibleFactura= borderResaltar;
	}

	public Boolean getMostrarcabe_ordenVisibleFactura() {
		return this.mostrarcabe_ordenVisibleFactura;
	}

	public void setMostrarcabe_ordenVisibleFactura(Boolean mostrarcabe_ordenVisibleFactura) {
		this.mostrarcabe_ordenVisibleFactura= mostrarcabe_ordenVisibleFactura;
	}

	public Boolean getActivarcabe_ordenVisibleFactura() {
		return this.activarcabe_ordenVisibleFactura;
	}

	public void setActivarcabe_ordenVisibleFactura(Boolean activarcabe_ordenVisibleFactura) {
		this.activarcabe_ordenVisibleFactura= activarcabe_ordenVisibleFactura;
	}

	public Border setResaltardeta_autori_precioVisibleFactura(ParametroGeneralUsuario parametroGeneralUsuario/*VisibleFacturaBeanSwingJInternalFrame visiblefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//visiblefacturaBeanSwingJInternalFrame.jTtoolBarVisibleFactura.setBorder(borderResaltar);
		
		this.resaltardeta_autori_precioVisibleFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardeta_autori_precioVisibleFactura() {
		return this.resaltardeta_autori_precioVisibleFactura;
	}

	public void setResaltardeta_autori_precioVisibleFactura(Border borderResaltar) {
		this.resaltardeta_autori_precioVisibleFactura= borderResaltar;
	}

	public Boolean getMostrardeta_autori_precioVisibleFactura() {
		return this.mostrardeta_autori_precioVisibleFactura;
	}

	public void setMostrardeta_autori_precioVisibleFactura(Boolean mostrardeta_autori_precioVisibleFactura) {
		this.mostrardeta_autori_precioVisibleFactura= mostrardeta_autori_precioVisibleFactura;
	}

	public Boolean getActivardeta_autori_precioVisibleFactura() {
		return this.activardeta_autori_precioVisibleFactura;
	}

	public void setActivardeta_autori_precioVisibleFactura(Boolean activardeta_autori_precioVisibleFactura) {
		this.activardeta_autori_precioVisibleFactura= activardeta_autori_precioVisibleFactura;
	}

	public Border setResaltardeta_areaVisibleFactura(ParametroGeneralUsuario parametroGeneralUsuario/*VisibleFacturaBeanSwingJInternalFrame visiblefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//visiblefacturaBeanSwingJInternalFrame.jTtoolBarVisibleFactura.setBorder(borderResaltar);
		
		this.resaltardeta_areaVisibleFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardeta_areaVisibleFactura() {
		return this.resaltardeta_areaVisibleFactura;
	}

	public void setResaltardeta_areaVisibleFactura(Border borderResaltar) {
		this.resaltardeta_areaVisibleFactura= borderResaltar;
	}

	public Boolean getMostrardeta_areaVisibleFactura() {
		return this.mostrardeta_areaVisibleFactura;
	}

	public void setMostrardeta_areaVisibleFactura(Boolean mostrardeta_areaVisibleFactura) {
		this.mostrardeta_areaVisibleFactura= mostrardeta_areaVisibleFactura;
	}

	public Boolean getActivardeta_areaVisibleFactura() {
		return this.activardeta_areaVisibleFactura;
	}

	public void setActivardeta_areaVisibleFactura(Boolean activardeta_areaVisibleFactura) {
		this.activardeta_areaVisibleFactura= activardeta_areaVisibleFactura;
	}

	public Border setResaltardeta_fotoVisibleFactura(ParametroGeneralUsuario parametroGeneralUsuario/*VisibleFacturaBeanSwingJInternalFrame visiblefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//visiblefacturaBeanSwingJInternalFrame.jTtoolBarVisibleFactura.setBorder(borderResaltar);
		
		this.resaltardeta_fotoVisibleFactura= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardeta_fotoVisibleFactura() {
		return this.resaltardeta_fotoVisibleFactura;
	}

	public void setResaltardeta_fotoVisibleFactura(Border borderResaltar) {
		this.resaltardeta_fotoVisibleFactura= borderResaltar;
	}

	public Boolean getMostrardeta_fotoVisibleFactura() {
		return this.mostrardeta_fotoVisibleFactura;
	}

	public void setMostrardeta_fotoVisibleFactura(Boolean mostrardeta_fotoVisibleFactura) {
		this.mostrardeta_fotoVisibleFactura= mostrardeta_fotoVisibleFactura;
	}

	public Boolean getActivardeta_fotoVisibleFactura() {
		return this.activardeta_fotoVisibleFactura;
	}

	public void setActivardeta_fotoVisibleFactura(Boolean activardeta_fotoVisibleFactura) {
		this.activardeta_fotoVisibleFactura= activardeta_fotoVisibleFactura;
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
		
		
		this.setMostraridVisibleFactura(esInicial);
		this.setMostrarid_empresaVisibleFactura(esInicial);
		this.setMostrarcabe_consignatarioVisibleFactura(esInicial);
		this.setMostrarcabe_tipo_tasaVisibleFactura(esInicial);
		this.setMostrarcabe_consultorVisibleFactura(esInicial);
		this.setMostrarcabe_iceVisibleFactura(esInicial);
		this.setMostrarcabe_transporteVisibleFactura(esInicial);
		this.setMostrarcabe_fueVisibleFactura(esInicial);
		this.setMostrarcabe_ordenVisibleFactura(esInicial);
		this.setMostrardeta_autori_precioVisibleFactura(esInicial);
		this.setMostrardeta_areaVisibleFactura(esInicial);
		this.setMostrardeta_fotoVisibleFactura(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VisibleFacturaConstantesFunciones.ID)) {
				this.setMostraridVisibleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(VisibleFacturaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaVisibleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(VisibleFacturaConstantesFunciones.CABECONSIGNATARIO)) {
				this.setMostrarcabe_consignatarioVisibleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(VisibleFacturaConstantesFunciones.CABETIPOTASA)) {
				this.setMostrarcabe_tipo_tasaVisibleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(VisibleFacturaConstantesFunciones.CABECONSULTOR)) {
				this.setMostrarcabe_consultorVisibleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(VisibleFacturaConstantesFunciones.CABEICE)) {
				this.setMostrarcabe_iceVisibleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(VisibleFacturaConstantesFunciones.CABETRANSPORTE)) {
				this.setMostrarcabe_transporteVisibleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(VisibleFacturaConstantesFunciones.CABEFUE)) {
				this.setMostrarcabe_fueVisibleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(VisibleFacturaConstantesFunciones.CABEORDEN)) {
				this.setMostrarcabe_ordenVisibleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(VisibleFacturaConstantesFunciones.DETAAUTORIPRECIO)) {
				this.setMostrardeta_autori_precioVisibleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(VisibleFacturaConstantesFunciones.DETAAREA)) {
				this.setMostrardeta_areaVisibleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(VisibleFacturaConstantesFunciones.DETAFOTO)) {
				this.setMostrardeta_fotoVisibleFactura(esAsigna);
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
		
		
		this.setActivaridVisibleFactura(esInicial);
		this.setActivarid_empresaVisibleFactura(esInicial);
		this.setActivarcabe_consignatarioVisibleFactura(esInicial);
		this.setActivarcabe_tipo_tasaVisibleFactura(esInicial);
		this.setActivarcabe_consultorVisibleFactura(esInicial);
		this.setActivarcabe_iceVisibleFactura(esInicial);
		this.setActivarcabe_transporteVisibleFactura(esInicial);
		this.setActivarcabe_fueVisibleFactura(esInicial);
		this.setActivarcabe_ordenVisibleFactura(esInicial);
		this.setActivardeta_autori_precioVisibleFactura(esInicial);
		this.setActivardeta_areaVisibleFactura(esInicial);
		this.setActivardeta_fotoVisibleFactura(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VisibleFacturaConstantesFunciones.ID)) {
				this.setActivaridVisibleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(VisibleFacturaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaVisibleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(VisibleFacturaConstantesFunciones.CABECONSIGNATARIO)) {
				this.setActivarcabe_consignatarioVisibleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(VisibleFacturaConstantesFunciones.CABETIPOTASA)) {
				this.setActivarcabe_tipo_tasaVisibleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(VisibleFacturaConstantesFunciones.CABECONSULTOR)) {
				this.setActivarcabe_consultorVisibleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(VisibleFacturaConstantesFunciones.CABEICE)) {
				this.setActivarcabe_iceVisibleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(VisibleFacturaConstantesFunciones.CABETRANSPORTE)) {
				this.setActivarcabe_transporteVisibleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(VisibleFacturaConstantesFunciones.CABEFUE)) {
				this.setActivarcabe_fueVisibleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(VisibleFacturaConstantesFunciones.CABEORDEN)) {
				this.setActivarcabe_ordenVisibleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(VisibleFacturaConstantesFunciones.DETAAUTORIPRECIO)) {
				this.setActivardeta_autori_precioVisibleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(VisibleFacturaConstantesFunciones.DETAAREA)) {
				this.setActivardeta_areaVisibleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(VisibleFacturaConstantesFunciones.DETAFOTO)) {
				this.setActivardeta_fotoVisibleFactura(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,VisibleFacturaBeanSwingJInternalFrame visiblefacturaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridVisibleFactura(esInicial);
		this.setResaltarid_empresaVisibleFactura(esInicial);
		this.setResaltarcabe_consignatarioVisibleFactura(esInicial);
		this.setResaltarcabe_tipo_tasaVisibleFactura(esInicial);
		this.setResaltarcabe_consultorVisibleFactura(esInicial);
		this.setResaltarcabe_iceVisibleFactura(esInicial);
		this.setResaltarcabe_transporteVisibleFactura(esInicial);
		this.setResaltarcabe_fueVisibleFactura(esInicial);
		this.setResaltarcabe_ordenVisibleFactura(esInicial);
		this.setResaltardeta_autori_precioVisibleFactura(esInicial);
		this.setResaltardeta_areaVisibleFactura(esInicial);
		this.setResaltardeta_fotoVisibleFactura(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VisibleFacturaConstantesFunciones.ID)) {
				this.setResaltaridVisibleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(VisibleFacturaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaVisibleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(VisibleFacturaConstantesFunciones.CABECONSIGNATARIO)) {
				this.setResaltarcabe_consignatarioVisibleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(VisibleFacturaConstantesFunciones.CABETIPOTASA)) {
				this.setResaltarcabe_tipo_tasaVisibleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(VisibleFacturaConstantesFunciones.CABECONSULTOR)) {
				this.setResaltarcabe_consultorVisibleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(VisibleFacturaConstantesFunciones.CABEICE)) {
				this.setResaltarcabe_iceVisibleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(VisibleFacturaConstantesFunciones.CABETRANSPORTE)) {
				this.setResaltarcabe_transporteVisibleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(VisibleFacturaConstantesFunciones.CABEFUE)) {
				this.setResaltarcabe_fueVisibleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(VisibleFacturaConstantesFunciones.CABEORDEN)) {
				this.setResaltarcabe_ordenVisibleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(VisibleFacturaConstantesFunciones.DETAAUTORIPRECIO)) {
				this.setResaltardeta_autori_precioVisibleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(VisibleFacturaConstantesFunciones.DETAAREA)) {
				this.setResaltardeta_areaVisibleFactura(esAsigna);
				continue;
			}

			if(campo.clase.equals(VisibleFacturaConstantesFunciones.DETAFOTO)) {
				this.setResaltardeta_fotoVisibleFactura(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,VisibleFacturaBeanSwingJInternalFrame visiblefacturaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaVisibleFactura=true;

	public Boolean getMostrarFK_IdEmpresaVisibleFactura() {
		return this.mostrarFK_IdEmpresaVisibleFactura;
	}

	public void setMostrarFK_IdEmpresaVisibleFactura(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaVisibleFactura= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaVisibleFactura=true;

	public Boolean getActivarFK_IdEmpresaVisibleFactura() {
		return this.activarFK_IdEmpresaVisibleFactura;
	}

	public void setActivarFK_IdEmpresaVisibleFactura(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaVisibleFactura= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaVisibleFactura=null;

	public Border getResaltarFK_IdEmpresaVisibleFactura() {
		return this.resaltarFK_IdEmpresaVisibleFactura;
	}

	public void setResaltarFK_IdEmpresaVisibleFactura(Border borderResaltar) {
		this.resaltarFK_IdEmpresaVisibleFactura= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaVisibleFactura(ParametroGeneralUsuario parametroGeneralUsuario/*VisibleFacturaBeanSwingJInternalFrame visiblefacturaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaVisibleFactura= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}