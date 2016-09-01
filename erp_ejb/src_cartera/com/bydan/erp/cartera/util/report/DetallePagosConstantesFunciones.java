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


import com.bydan.erp.cartera.util.report.DetallePagosConstantesFunciones;
import com.bydan.erp.cartera.util.report.DetallePagosParameterReturnGeneral;
//import com.bydan.erp.cartera.util.report.DetallePagosParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class DetallePagosConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="DetallePagos";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DetallePagos"+DetallePagosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DetallePagosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DetallePagosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DetallePagosConstantesFunciones.SCHEMA+"_"+DetallePagosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DetallePagosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DetallePagosConstantesFunciones.SCHEMA+"_"+DetallePagosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DetallePagosConstantesFunciones.SCHEMA+"_"+DetallePagosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DetallePagosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DetallePagosConstantesFunciones.SCHEMA+"_"+DetallePagosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetallePagosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetallePagosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetallePagosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetallePagosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetallePagosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetallePagosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DetallePagosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DetallePagosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DetallePagosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DetallePagosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Detalle Pagoses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Detalle Pagos";
	public static final String SCLASSWEBTITULO_LOWER="Detalle Pagos";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DetallePagos";
	public static final String OBJECTNAME="detallepagos";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="detalle_pagos";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select detallepagos from "+DetallePagosConstantesFunciones.SPERSISTENCENAME+" detallepagos";
	public static String QUERYSELECTNATIVE="select "+DetallePagosConstantesFunciones.SCHEMA+"."+DetallePagosConstantesFunciones.TABLENAME+".id,"+DetallePagosConstantesFunciones.SCHEMA+"."+DetallePagosConstantesFunciones.TABLENAME+".version_row,"+DetallePagosConstantesFunciones.SCHEMA+"."+DetallePagosConstantesFunciones.TABLENAME+".id_empresa,"+DetallePagosConstantesFunciones.SCHEMA+"."+DetallePagosConstantesFunciones.TABLENAME+".id_grupo_cliente,"+DetallePagosConstantesFunciones.SCHEMA+"."+DetallePagosConstantesFunciones.TABLENAME+".id_zona,"+DetallePagosConstantesFunciones.SCHEMA+"."+DetallePagosConstantesFunciones.TABLENAME+".fecha_emision_desde,"+DetallePagosConstantesFunciones.SCHEMA+"."+DetallePagosConstantesFunciones.TABLENAME+".fecha_emision_hasta,"+DetallePagosConstantesFunciones.SCHEMA+"."+DetallePagosConstantesFunciones.TABLENAME+".codigo,"+DetallePagosConstantesFunciones.SCHEMA+"."+DetallePagosConstantesFunciones.TABLENAME+".nombre_cliente,"+DetallePagosConstantesFunciones.SCHEMA+"."+DetallePagosConstantesFunciones.TABLENAME+".ruc,"+DetallePagosConstantesFunciones.SCHEMA+"."+DetallePagosConstantesFunciones.TABLENAME+".total_facturas,"+DetallePagosConstantesFunciones.SCHEMA+"."+DetallePagosConstantesFunciones.TABLENAME+".total_abonos,"+DetallePagosConstantesFunciones.SCHEMA+"."+DetallePagosConstantesFunciones.TABLENAME+".total_facturas_actual,"+DetallePagosConstantesFunciones.SCHEMA+"."+DetallePagosConstantesFunciones.TABLENAME+".abonos_anterior,"+DetallePagosConstantesFunciones.SCHEMA+"."+DetallePagosConstantesFunciones.TABLENAME+".abonos_actual from "+DetallePagosConstantesFunciones.SCHEMA+"."+DetallePagosConstantesFunciones.TABLENAME;//+" as "+DetallePagosConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDGRUPOCLIENTE= "id_grupo_cliente";
    public static final String IDZONA= "id_zona";
    public static final String FECHAEMISIONDESDE= "fecha_emision_desde";
    public static final String FECHAEMISIONHASTA= "fecha_emision_hasta";
    public static final String CODIGO= "codigo";
    public static final String NOMBRECLIENTE= "nombre_cliente";
    public static final String RUC= "ruc";
    public static final String TOTALFACTURAS= "total_facturas";
    public static final String TOTALABONOS= "total_abonos";
    public static final String TOTALFACTURASACTUAL= "total_facturas_actual";
    public static final String ABONOSANTERIOR= "abonos_anterior";
    public static final String ABONOSACTUAL= "abonos_actual";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDGRUPOCLIENTE= "Grupo Cliente";
		public static final String LABEL_IDGRUPOCLIENTE_LOWER= "Grupo Cliente";
    	public static final String LABEL_IDZONA= "Zona";
		public static final String LABEL_IDZONA_LOWER= "Zona";
    	public static final String LABEL_FECHAEMISIONDESDE= "Fecha Emision Desde";
		public static final String LABEL_FECHAEMISIONDESDE_LOWER= "Fecha Emision Desde";
    	public static final String LABEL_FECHAEMISIONHASTA= "Fecha Emision Hasta";
		public static final String LABEL_FECHAEMISIONHASTA_LOWER= "Fecha Emision Hasta";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRECLIENTE= "Nombre Cliente";
		public static final String LABEL_NOMBRECLIENTE_LOWER= "Nombre Cliente";
    	public static final String LABEL_RUC= "Ruc";
		public static final String LABEL_RUC_LOWER= "Ruc";
    	public static final String LABEL_TOTALFACTURAS= "Total Facturas";
		public static final String LABEL_TOTALFACTURAS_LOWER= "Total Facturas";
    	public static final String LABEL_TOTALABONOS= "Total Abonos";
		public static final String LABEL_TOTALABONOS_LOWER= "Total Abonos";
    	public static final String LABEL_TOTALFACTURASACTUAL= "Total Facturas Actual";
		public static final String LABEL_TOTALFACTURASACTUAL_LOWER= "Total Facturas Actual";
    	public static final String LABEL_ABONOSANTERIOR= "Abonos Anterior";
		public static final String LABEL_ABONOSANTERIOR_LOWER= "Abonos Anterior";
    	public static final String LABEL_ABONOSACTUAL= "Abonos Actual";
		public static final String LABEL_ABONOSACTUAL_LOWER= "Abonos Actual";
	
		
		
		
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_CLIENTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_CLIENTE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXRUC=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRUC=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
	
	public static String getDetallePagosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DetallePagosConstantesFunciones.IDEMPRESA)) {sLabelColumna=DetallePagosConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DetallePagosConstantesFunciones.IDGRUPOCLIENTE)) {sLabelColumna=DetallePagosConstantesFunciones.LABEL_IDGRUPOCLIENTE;}
		if(sNombreColumna.equals(DetallePagosConstantesFunciones.IDZONA)) {sLabelColumna=DetallePagosConstantesFunciones.LABEL_IDZONA;}
		if(sNombreColumna.equals(DetallePagosConstantesFunciones.FECHAEMISIONDESDE)) {sLabelColumna=DetallePagosConstantesFunciones.LABEL_FECHAEMISIONDESDE;}
		if(sNombreColumna.equals(DetallePagosConstantesFunciones.FECHAEMISIONHASTA)) {sLabelColumna=DetallePagosConstantesFunciones.LABEL_FECHAEMISIONHASTA;}
		if(sNombreColumna.equals(DetallePagosConstantesFunciones.CODIGO)) {sLabelColumna=DetallePagosConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(DetallePagosConstantesFunciones.NOMBRECLIENTE)) {sLabelColumna=DetallePagosConstantesFunciones.LABEL_NOMBRECLIENTE;}
		if(sNombreColumna.equals(DetallePagosConstantesFunciones.RUC)) {sLabelColumna=DetallePagosConstantesFunciones.LABEL_RUC;}
		if(sNombreColumna.equals(DetallePagosConstantesFunciones.TOTALFACTURAS)) {sLabelColumna=DetallePagosConstantesFunciones.LABEL_TOTALFACTURAS;}
		if(sNombreColumna.equals(DetallePagosConstantesFunciones.TOTALABONOS)) {sLabelColumna=DetallePagosConstantesFunciones.LABEL_TOTALABONOS;}
		if(sNombreColumna.equals(DetallePagosConstantesFunciones.TOTALFACTURASACTUAL)) {sLabelColumna=DetallePagosConstantesFunciones.LABEL_TOTALFACTURASACTUAL;}
		if(sNombreColumna.equals(DetallePagosConstantesFunciones.ABONOSANTERIOR)) {sLabelColumna=DetallePagosConstantesFunciones.LABEL_ABONOSANTERIOR;}
		if(sNombreColumna.equals(DetallePagosConstantesFunciones.ABONOSACTUAL)) {sLabelColumna=DetallePagosConstantesFunciones.LABEL_ABONOSACTUAL;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getDetallePagosDescripcion(DetallePagos detallepagos) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(detallepagos !=null/* && detallepagos.getId()!=0*/) {
			sDescripcion=detallepagos.getcodigo();//detallepagosdetallepagos.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getDetallePagosDescripcionDetallado(DetallePagos detallepagos) {
		String sDescripcion="";
			
		sDescripcion+=DetallePagosConstantesFunciones.ID+"=";
		sDescripcion+=detallepagos.getId().toString()+",";
		sDescripcion+=DetallePagosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=detallepagos.getVersionRow().toString()+",";
		sDescripcion+=DetallePagosConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=detallepagos.getid_empresa().toString()+",";
		sDescripcion+=DetallePagosConstantesFunciones.IDGRUPOCLIENTE+"=";
		sDescripcion+=detallepagos.getid_grupo_cliente().toString()+",";
		sDescripcion+=DetallePagosConstantesFunciones.IDZONA+"=";
		sDescripcion+=detallepagos.getid_zona().toString()+",";
		sDescripcion+=DetallePagosConstantesFunciones.FECHAEMISIONDESDE+"=";
		sDescripcion+=detallepagos.getfecha_emision_desde().toString()+",";
		sDescripcion+=DetallePagosConstantesFunciones.FECHAEMISIONHASTA+"=";
		sDescripcion+=detallepagos.getfecha_emision_hasta().toString()+",";
		sDescripcion+=DetallePagosConstantesFunciones.CODIGO+"=";
		sDescripcion+=detallepagos.getcodigo()+",";
		sDescripcion+=DetallePagosConstantesFunciones.NOMBRECLIENTE+"=";
		sDescripcion+=detallepagos.getnombre_cliente()+",";
		sDescripcion+=DetallePagosConstantesFunciones.RUC+"=";
		sDescripcion+=detallepagos.getruc()+",";
		sDescripcion+=DetallePagosConstantesFunciones.TOTALFACTURAS+"=";
		sDescripcion+=detallepagos.gettotal_facturas().toString()+",";
		sDescripcion+=DetallePagosConstantesFunciones.TOTALABONOS+"=";
		sDescripcion+=detallepagos.gettotal_abonos().toString()+",";
		sDescripcion+=DetallePagosConstantesFunciones.TOTALFACTURASACTUAL+"=";
		sDescripcion+=detallepagos.gettotal_facturas_actual().toString()+",";
		sDescripcion+=DetallePagosConstantesFunciones.ABONOSANTERIOR+"=";
		sDescripcion+=detallepagos.getabonos_anterior().toString()+",";
		sDescripcion+=DetallePagosConstantesFunciones.ABONOSACTUAL+"=";
		sDescripcion+=detallepagos.getabonos_actual().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setDetallePagosDescripcion(DetallePagos detallepagos,String sValor) throws Exception {			
		if(detallepagos !=null) {
			detallepagos.setcodigo(sValor);;//detallepagosdetallepagos.getcodigo().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getGrupoClienteDescripcion(GrupoCliente grupocliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(grupocliente!=null/*&&grupocliente.getId()>0*/) {
			sDescripcion=GrupoClienteConstantesFunciones.getGrupoClienteDescripcion(grupocliente);
		}

		return sDescripcion;
	}

	public static String getZonaDescripcion(Zona zona) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(zona!=null/*&&zona.getId()>0*/) {
			sDescripcion=ZonaConstantesFunciones.getZonaDescripcion(zona);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaDetallePagos")) {
			sNombreIndice="Tipo=  Por Grupo Cliente Por Zona Por Fecha Emision Desde Por Fecha Emision Hasta";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdGrupoCliente")) {
			sNombreIndice="Tipo=  Por Grupo Cliente";
		} else if(sNombreIndice.equals("FK_IdZona")) {
			sNombreIndice="Tipo=  Por Zona";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaDetallePagos(Long id_grupo_cliente,Long id_zona,Date fecha_emision_desde,Date fecha_emision_hasta) {
		String sDetalleIndice=" Parametros->";
		if(id_grupo_cliente!=null) {sDetalleIndice+=" Codigo Unico De Grupo Cliente="+id_grupo_cliente.toString();}
		if(id_zona!=null) {sDetalleIndice+=" Codigo Unico De Zona="+id_zona.toString();}
		if(fecha_emision_desde!=null) {sDetalleIndice+=" Fecha Emision Desde="+fecha_emision_desde.toString();}
		if(fecha_emision_hasta!=null) {sDetalleIndice+=" Fecha Emision Hasta="+fecha_emision_hasta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdGrupoCliente(Long id_grupo_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_grupo_cliente!=null) {sDetalleIndice+=" Codigo Unico De Grupo Cliente="+id_grupo_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdZona(Long id_zona) {
		String sDetalleIndice=" Parametros->";
		if(id_zona!=null) {sDetalleIndice+=" Codigo Unico De Zona="+id_zona.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosDetallePagos(DetallePagos detallepagos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		detallepagos.setcodigo(detallepagos.getcodigo().trim());
		detallepagos.setnombre_cliente(detallepagos.getnombre_cliente().trim());
		detallepagos.setruc(detallepagos.getruc().trim());
	}
	
	public static void quitarEspaciosDetallePagoss(List<DetallePagos> detallepagoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetallePagos detallepagos: detallepagoss) {
			detallepagos.setcodigo(detallepagos.getcodigo().trim());
			detallepagos.setnombre_cliente(detallepagos.getnombre_cliente().trim());
			detallepagos.setruc(detallepagos.getruc().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetallePagos(DetallePagos detallepagos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && detallepagos.getConCambioAuxiliar()) {
			detallepagos.setIsDeleted(detallepagos.getIsDeletedAuxiliar());	
			detallepagos.setIsNew(detallepagos.getIsNewAuxiliar());	
			detallepagos.setIsChanged(detallepagos.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			detallepagos.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			detallepagos.setIsDeletedAuxiliar(false);	
			detallepagos.setIsNewAuxiliar(false);	
			detallepagos.setIsChangedAuxiliar(false);
			
			detallepagos.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetallePagoss(List<DetallePagos> detallepagoss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DetallePagos detallepagos : detallepagoss) {
			if(conAsignarBase && detallepagos.getConCambioAuxiliar()) {
				detallepagos.setIsDeleted(detallepagos.getIsDeletedAuxiliar());	
				detallepagos.setIsNew(detallepagos.getIsNewAuxiliar());	
				detallepagos.setIsChanged(detallepagos.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				detallepagos.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				detallepagos.setIsDeletedAuxiliar(false);	
				detallepagos.setIsNewAuxiliar(false);	
				detallepagos.setIsChangedAuxiliar(false);
				
				detallepagos.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDetallePagos(DetallePagos detallepagos,Boolean conEnteros) throws Exception  {
		detallepagos.settotal_facturas(0.0);
		detallepagos.settotal_abonos(0.0);
		detallepagos.settotal_facturas_actual(0.0);
		detallepagos.setabonos_anterior(0.0);
		detallepagos.setabonos_actual(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresDetallePagoss(List<DetallePagos> detallepagoss,Boolean conEnteros) throws Exception  {
		
		for(DetallePagos detallepagos: detallepagoss) {
			detallepagos.settotal_facturas(0.0);
			detallepagos.settotal_abonos(0.0);
			detallepagos.settotal_facturas_actual(0.0);
			detallepagos.setabonos_anterior(0.0);
			detallepagos.setabonos_actual(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaDetallePagos(List<DetallePagos> detallepagoss,DetallePagos detallepagosAux) throws Exception  {
		DetallePagosConstantesFunciones.InicializarValoresDetallePagos(detallepagosAux,true);
		
		for(DetallePagos detallepagos: detallepagoss) {
			if(detallepagos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			detallepagosAux.settotal_facturas(detallepagosAux.gettotal_facturas()+detallepagos.gettotal_facturas());			
			detallepagosAux.settotal_abonos(detallepagosAux.gettotal_abonos()+detallepagos.gettotal_abonos());			
			detallepagosAux.settotal_facturas_actual(detallepagosAux.gettotal_facturas_actual()+detallepagos.gettotal_facturas_actual());			
			detallepagosAux.setabonos_anterior(detallepagosAux.getabonos_anterior()+detallepagos.getabonos_anterior());			
			detallepagosAux.setabonos_actual(detallepagosAux.getabonos_actual()+detallepagos.getabonos_actual());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetallePagos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DetallePagosConstantesFunciones.getArrayColumnasGlobalesDetallePagos(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDetallePagos(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetallePagosConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetallePagosConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDetallePagos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetallePagos> detallepagoss,DetallePagos detallepagos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetallePagos detallepagosAux: detallepagoss) {
			if(detallepagosAux!=null && detallepagos!=null) {
				if((detallepagosAux.getId()==null && detallepagos.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(detallepagosAux.getId()!=null && detallepagos.getId()!=null){
					if(detallepagosAux.getId().equals(detallepagos.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetallePagos(List<DetallePagos> detallepagoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double total_facturasTotal=0.0;
		Double total_abonosTotal=0.0;
		Double total_facturas_actualTotal=0.0;
		Double abonos_anteriorTotal=0.0;
		Double abonos_actualTotal=0.0;
	
		for(DetallePagos detallepagos: detallepagoss) {			
			if(detallepagos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			total_facturasTotal+=detallepagos.gettotal_facturas();
			total_abonosTotal+=detallepagos.gettotal_abonos();
			total_facturas_actualTotal+=detallepagos.gettotal_facturas_actual();
			abonos_anteriorTotal+=detallepagos.getabonos_anterior();
			abonos_actualTotal+=detallepagos.getabonos_actual();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePagosConstantesFunciones.TOTALFACTURAS);
		datoGeneral.setsDescripcion(DetallePagosConstantesFunciones.LABEL_TOTALFACTURAS);
		datoGeneral.setdValorDouble(total_facturasTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePagosConstantesFunciones.TOTALABONOS);
		datoGeneral.setsDescripcion(DetallePagosConstantesFunciones.LABEL_TOTALABONOS);
		datoGeneral.setdValorDouble(total_abonosTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePagosConstantesFunciones.TOTALFACTURASACTUAL);
		datoGeneral.setsDescripcion(DetallePagosConstantesFunciones.LABEL_TOTALFACTURASACTUAL);
		datoGeneral.setdValorDouble(total_facturas_actualTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePagosConstantesFunciones.ABONOSANTERIOR);
		datoGeneral.setsDescripcion(DetallePagosConstantesFunciones.LABEL_ABONOSANTERIOR);
		datoGeneral.setdValorDouble(abonos_anteriorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePagosConstantesFunciones.ABONOSACTUAL);
		datoGeneral.setsDescripcion(DetallePagosConstantesFunciones.LABEL_ABONOSACTUAL);
		datoGeneral.setdValorDouble(abonos_actualTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDetallePagos() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DetallePagosConstantesFunciones.LABEL_ID, DetallePagosConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePagosConstantesFunciones.LABEL_VERSIONROW, DetallePagosConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePagosConstantesFunciones.LABEL_CODIGO, DetallePagosConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePagosConstantesFunciones.LABEL_NOMBRECLIENTE, DetallePagosConstantesFunciones.NOMBRECLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePagosConstantesFunciones.LABEL_RUC, DetallePagosConstantesFunciones.RUC,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePagosConstantesFunciones.LABEL_TOTALFACTURAS, DetallePagosConstantesFunciones.TOTALFACTURAS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePagosConstantesFunciones.LABEL_TOTALABONOS, DetallePagosConstantesFunciones.TOTALABONOS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePagosConstantesFunciones.LABEL_TOTALFACTURASACTUAL, DetallePagosConstantesFunciones.TOTALFACTURASACTUAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePagosConstantesFunciones.LABEL_ABONOSANTERIOR, DetallePagosConstantesFunciones.ABONOSANTERIOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePagosConstantesFunciones.LABEL_ABONOSACTUAL, DetallePagosConstantesFunciones.ABONOSACTUAL,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDetallePagos() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DetallePagosConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePagosConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePagosConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePagosConstantesFunciones.NOMBRECLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePagosConstantesFunciones.RUC;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePagosConstantesFunciones.TOTALFACTURAS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePagosConstantesFunciones.TOTALABONOS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePagosConstantesFunciones.TOTALFACTURASACTUAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePagosConstantesFunciones.ABONOSANTERIOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePagosConstantesFunciones.ABONOSACTUAL;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetallePagos() throws Exception  {
		return DetallePagosConstantesFunciones.getTiposSeleccionarDetallePagos(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetallePagos(Boolean conFk) throws Exception  {
		return DetallePagosConstantesFunciones.getTiposSeleccionarDetallePagos(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetallePagos(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePagosConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DetallePagosConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePagosConstantesFunciones.LABEL_IDGRUPOCLIENTE);
			reporte.setsDescripcion(DetallePagosConstantesFunciones.LABEL_IDGRUPOCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePagosConstantesFunciones.LABEL_IDZONA);
			reporte.setsDescripcion(DetallePagosConstantesFunciones.LABEL_IDZONA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePagosConstantesFunciones.LABEL_FECHAEMISIONDESDE);
			reporte.setsDescripcion(DetallePagosConstantesFunciones.LABEL_FECHAEMISIONDESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePagosConstantesFunciones.LABEL_FECHAEMISIONHASTA);
			reporte.setsDescripcion(DetallePagosConstantesFunciones.LABEL_FECHAEMISIONHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePagosConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(DetallePagosConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePagosConstantesFunciones.LABEL_NOMBRECLIENTE);
			reporte.setsDescripcion(DetallePagosConstantesFunciones.LABEL_NOMBRECLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePagosConstantesFunciones.LABEL_RUC);
			reporte.setsDescripcion(DetallePagosConstantesFunciones.LABEL_RUC);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePagosConstantesFunciones.LABEL_TOTALFACTURAS);
			reporte.setsDescripcion(DetallePagosConstantesFunciones.LABEL_TOTALFACTURAS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePagosConstantesFunciones.LABEL_TOTALABONOS);
			reporte.setsDescripcion(DetallePagosConstantesFunciones.LABEL_TOTALABONOS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePagosConstantesFunciones.LABEL_TOTALFACTURASACTUAL);
			reporte.setsDescripcion(DetallePagosConstantesFunciones.LABEL_TOTALFACTURASACTUAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePagosConstantesFunciones.LABEL_ABONOSANTERIOR);
			reporte.setsDescripcion(DetallePagosConstantesFunciones.LABEL_ABONOSANTERIOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePagosConstantesFunciones.LABEL_ABONOSACTUAL);
			reporte.setsDescripcion(DetallePagosConstantesFunciones.LABEL_ABONOSACTUAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDetallePagos(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDetallePagos(DetallePagos detallepagosAux) throws Exception {
		
			detallepagosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detallepagosAux.getEmpresa()));
			detallepagosAux.setgrupocliente_descripcion(GrupoClienteConstantesFunciones.getGrupoClienteDescripcion(detallepagosAux.getGrupoCliente()));
			detallepagosAux.setzona_descripcion(ZonaConstantesFunciones.getZonaDescripcion(detallepagosAux.getZona()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDetallePagos(List<DetallePagos> detallepagossTemp) throws Exception {
		for(DetallePagos detallepagosAux:detallepagossTemp) {
			
			detallepagosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detallepagosAux.getEmpresa()));
			detallepagosAux.setgrupocliente_descripcion(GrupoClienteConstantesFunciones.getGrupoClienteDescripcion(detallepagosAux.getGrupoCliente()));
			detallepagosAux.setzona_descripcion(ZonaConstantesFunciones.getZonaDescripcion(detallepagosAux.getZona()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDetallePagos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(GrupoCliente.class));
				classes.add(new Classe(Zona.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(GrupoCliente.class)) {
						classes.add(new Classe(GrupoCliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Zona.class)) {
						classes.add(new Classe(Zona.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDetallePagos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(GrupoCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GrupoCliente.class)); continue;
					}

					if(Zona.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Zona.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(GrupoCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GrupoCliente.class)); continue;
					}

					if(Zona.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Zona.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetallePagos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetallePagosConstantesFunciones.getClassesRelationshipsOfDetallePagos(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetallePagos(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetallePagos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetallePagosConstantesFunciones.getClassesRelationshipsFromStringsOfDetallePagos(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetallePagos(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(DetallePagos detallepagos,List<DetallePagos> detallepagoss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(DetallePagos detallepagos,List<DetallePagos> detallepagoss) throws Exception {
		try	{			
			for(DetallePagos detallepagosLocal:detallepagoss) {
				if(detallepagosLocal.getId().equals(detallepagos.getId())) {
					detallepagosLocal.setIsSelected(detallepagos.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDetallePagos(List<DetallePagos> detallepagossAux) throws Exception {
		//this.detallepagossAux=detallepagossAux;
		
		for(DetallePagos detallepagosAux:detallepagossAux) {
			if(detallepagosAux.getIsChanged()) {
				detallepagosAux.setIsChanged(false);
			}		
			
			if(detallepagosAux.getIsNew()) {
				detallepagosAux.setIsNew(false);
			}	
			
			if(detallepagosAux.getIsDeleted()) {
				detallepagosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDetallePagos(DetallePagos detallepagosAux) throws Exception {
		//this.detallepagosAux=detallepagosAux;
		
			if(detallepagosAux.getIsChanged()) {
				detallepagosAux.setIsChanged(false);
			}		
			
			if(detallepagosAux.getIsNew()) {
				detallepagosAux.setIsNew(false);
			}	
			
			if(detallepagosAux.getIsDeleted()) {
				detallepagosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DetallePagos detallepagosAsignar,DetallePagos detallepagos) throws Exception {
		detallepagosAsignar.setId(detallepagos.getId());	
		detallepagosAsignar.setVersionRow(detallepagos.getVersionRow());	
		detallepagosAsignar.setcodigo(detallepagos.getcodigo());	
		detallepagosAsignar.setnombre_cliente(detallepagos.getnombre_cliente());	
		detallepagosAsignar.setruc(detallepagos.getruc());	
		detallepagosAsignar.settotal_facturas(detallepagos.gettotal_facturas());	
		detallepagosAsignar.settotal_abonos(detallepagos.gettotal_abonos());	
		detallepagosAsignar.settotal_facturas_actual(detallepagos.gettotal_facturas_actual());	
		detallepagosAsignar.setabonos_anterior(detallepagos.getabonos_anterior());	
		detallepagosAsignar.setabonos_actual(detallepagos.getabonos_actual());	
	}
	
	public static void inicializarDetallePagos(DetallePagos detallepagos) throws Exception {
		try {
				detallepagos.setId(0L);	
					
				detallepagos.setcodigo("");	
				detallepagos.setnombre_cliente("");	
				detallepagos.setruc("");	
				detallepagos.settotal_facturas(0.0);	
				detallepagos.settotal_abonos(0.0);	
				detallepagos.settotal_facturas_actual(0.0);	
				detallepagos.setabonos_anterior(0.0);	
				detallepagos.setabonos_actual(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDetallePagos(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePagosConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePagosConstantesFunciones.LABEL_IDGRUPOCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePagosConstantesFunciones.LABEL_IDZONA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePagosConstantesFunciones.LABEL_FECHAEMISIONDESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePagosConstantesFunciones.LABEL_FECHAEMISIONHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePagosConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePagosConstantesFunciones.LABEL_NOMBRECLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePagosConstantesFunciones.LABEL_RUC);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePagosConstantesFunciones.LABEL_TOTALFACTURAS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePagosConstantesFunciones.LABEL_TOTALABONOS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePagosConstantesFunciones.LABEL_TOTALFACTURASACTUAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePagosConstantesFunciones.LABEL_ABONOSANTERIOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePagosConstantesFunciones.LABEL_ABONOSACTUAL);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDetallePagos(String sTipo,Row row,Workbook workbook,DetallePagos detallepagos,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepagos.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepagos.getgrupocliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepagos.getzona_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepagos.getfecha_emision_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepagos.getfecha_emision_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepagos.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepagos.getnombre_cliente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepagos.getruc());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepagos.gettotal_facturas());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepagos.gettotal_abonos());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepagos.gettotal_facturas_actual());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepagos.getabonos_anterior());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepagos.getabonos_actual());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDetallePagos="";
	
	public String getsFinalQueryDetallePagos() {
		return this.sFinalQueryDetallePagos;
	}
	
	public void setsFinalQueryDetallePagos(String sFinalQueryDetallePagos) {
		this.sFinalQueryDetallePagos= sFinalQueryDetallePagos;
	}
	
	public Border resaltarSeleccionarDetallePagos=null;
	
	public Border setResaltarSeleccionarDetallePagos(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePagosBeanSwingJInternalFrame detallepagosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//detallepagosBeanSwingJInternalFrame.jTtoolBarDetallePagos.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDetallePagos= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDetallePagos() {
		return this.resaltarSeleccionarDetallePagos;
	}
	
	public void setResaltarSeleccionarDetallePagos(Border borderResaltarSeleccionarDetallePagos) {
		this.resaltarSeleccionarDetallePagos= borderResaltarSeleccionarDetallePagos;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDetallePagos=null;
	public Boolean mostraridDetallePagos=true;
	public Boolean activaridDetallePagos=true;

	public Border resaltarid_empresaDetallePagos=null;
	public Boolean mostrarid_empresaDetallePagos=true;
	public Boolean activarid_empresaDetallePagos=true;
	public Boolean cargarid_empresaDetallePagos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDetallePagos=false;//ConEventDepend=true

	public Border resaltarid_grupo_clienteDetallePagos=null;
	public Boolean mostrarid_grupo_clienteDetallePagos=true;
	public Boolean activarid_grupo_clienteDetallePagos=true;
	public Boolean cargarid_grupo_clienteDetallePagos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_grupo_clienteDetallePagos=false;//ConEventDepend=true

	public Border resaltarid_zonaDetallePagos=null;
	public Boolean mostrarid_zonaDetallePagos=true;
	public Boolean activarid_zonaDetallePagos=true;
	public Boolean cargarid_zonaDetallePagos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_zonaDetallePagos=false;//ConEventDepend=true

	public Border resaltarfecha_emision_desdeDetallePagos=null;
	public Boolean mostrarfecha_emision_desdeDetallePagos=true;
	public Boolean activarfecha_emision_desdeDetallePagos=true;

	public Border resaltarfecha_emision_hastaDetallePagos=null;
	public Boolean mostrarfecha_emision_hastaDetallePagos=true;
	public Boolean activarfecha_emision_hastaDetallePagos=true;

	public Border resaltarcodigoDetallePagos=null;
	public Boolean mostrarcodigoDetallePagos=true;
	public Boolean activarcodigoDetallePagos=true;

	public Border resaltarnombre_clienteDetallePagos=null;
	public Boolean mostrarnombre_clienteDetallePagos=true;
	public Boolean activarnombre_clienteDetallePagos=true;

	public Border resaltarrucDetallePagos=null;
	public Boolean mostrarrucDetallePagos=true;
	public Boolean activarrucDetallePagos=true;

	public Border resaltartotal_facturasDetallePagos=null;
	public Boolean mostrartotal_facturasDetallePagos=true;
	public Boolean activartotal_facturasDetallePagos=true;

	public Border resaltartotal_abonosDetallePagos=null;
	public Boolean mostrartotal_abonosDetallePagos=true;
	public Boolean activartotal_abonosDetallePagos=true;

	public Border resaltartotal_facturas_actualDetallePagos=null;
	public Boolean mostrartotal_facturas_actualDetallePagos=true;
	public Boolean activartotal_facturas_actualDetallePagos=true;

	public Border resaltarabonos_anteriorDetallePagos=null;
	public Boolean mostrarabonos_anteriorDetallePagos=true;
	public Boolean activarabonos_anteriorDetallePagos=true;

	public Border resaltarabonos_actualDetallePagos=null;
	public Boolean mostrarabonos_actualDetallePagos=true;
	public Boolean activarabonos_actualDetallePagos=true;

	
	

	public Border setResaltaridDetallePagos(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePagosBeanSwingJInternalFrame detallepagosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepagosBeanSwingJInternalFrame.jTtoolBarDetallePagos.setBorder(borderResaltar);
		
		this.resaltaridDetallePagos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDetallePagos() {
		return this.resaltaridDetallePagos;
	}

	public void setResaltaridDetallePagos(Border borderResaltar) {
		this.resaltaridDetallePagos= borderResaltar;
	}

	public Boolean getMostraridDetallePagos() {
		return this.mostraridDetallePagos;
	}

	public void setMostraridDetallePagos(Boolean mostraridDetallePagos) {
		this.mostraridDetallePagos= mostraridDetallePagos;
	}

	public Boolean getActivaridDetallePagos() {
		return this.activaridDetallePagos;
	}

	public void setActivaridDetallePagos(Boolean activaridDetallePagos) {
		this.activaridDetallePagos= activaridDetallePagos;
	}

	public Border setResaltarid_empresaDetallePagos(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePagosBeanSwingJInternalFrame detallepagosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepagosBeanSwingJInternalFrame.jTtoolBarDetallePagos.setBorder(borderResaltar);
		
		this.resaltarid_empresaDetallePagos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDetallePagos() {
		return this.resaltarid_empresaDetallePagos;
	}

	public void setResaltarid_empresaDetallePagos(Border borderResaltar) {
		this.resaltarid_empresaDetallePagos= borderResaltar;
	}

	public Boolean getMostrarid_empresaDetallePagos() {
		return this.mostrarid_empresaDetallePagos;
	}

	public void setMostrarid_empresaDetallePagos(Boolean mostrarid_empresaDetallePagos) {
		this.mostrarid_empresaDetallePagos= mostrarid_empresaDetallePagos;
	}

	public Boolean getActivarid_empresaDetallePagos() {
		return this.activarid_empresaDetallePagos;
	}

	public void setActivarid_empresaDetallePagos(Boolean activarid_empresaDetallePagos) {
		this.activarid_empresaDetallePagos= activarid_empresaDetallePagos;
	}

	public Boolean getCargarid_empresaDetallePagos() {
		return this.cargarid_empresaDetallePagos;
	}

	public void setCargarid_empresaDetallePagos(Boolean cargarid_empresaDetallePagos) {
		this.cargarid_empresaDetallePagos= cargarid_empresaDetallePagos;
	}

	public Border setResaltarid_grupo_clienteDetallePagos(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePagosBeanSwingJInternalFrame detallepagosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepagosBeanSwingJInternalFrame.jTtoolBarDetallePagos.setBorder(borderResaltar);
		
		this.resaltarid_grupo_clienteDetallePagos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_grupo_clienteDetallePagos() {
		return this.resaltarid_grupo_clienteDetallePagos;
	}

	public void setResaltarid_grupo_clienteDetallePagos(Border borderResaltar) {
		this.resaltarid_grupo_clienteDetallePagos= borderResaltar;
	}

	public Boolean getMostrarid_grupo_clienteDetallePagos() {
		return this.mostrarid_grupo_clienteDetallePagos;
	}

	public void setMostrarid_grupo_clienteDetallePagos(Boolean mostrarid_grupo_clienteDetallePagos) {
		this.mostrarid_grupo_clienteDetallePagos= mostrarid_grupo_clienteDetallePagos;
	}

	public Boolean getActivarid_grupo_clienteDetallePagos() {
		return this.activarid_grupo_clienteDetallePagos;
	}

	public void setActivarid_grupo_clienteDetallePagos(Boolean activarid_grupo_clienteDetallePagos) {
		this.activarid_grupo_clienteDetallePagos= activarid_grupo_clienteDetallePagos;
	}

	public Boolean getCargarid_grupo_clienteDetallePagos() {
		return this.cargarid_grupo_clienteDetallePagos;
	}

	public void setCargarid_grupo_clienteDetallePagos(Boolean cargarid_grupo_clienteDetallePagos) {
		this.cargarid_grupo_clienteDetallePagos= cargarid_grupo_clienteDetallePagos;
	}

	public Border setResaltarid_zonaDetallePagos(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePagosBeanSwingJInternalFrame detallepagosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepagosBeanSwingJInternalFrame.jTtoolBarDetallePagos.setBorder(borderResaltar);
		
		this.resaltarid_zonaDetallePagos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_zonaDetallePagos() {
		return this.resaltarid_zonaDetallePagos;
	}

	public void setResaltarid_zonaDetallePagos(Border borderResaltar) {
		this.resaltarid_zonaDetallePagos= borderResaltar;
	}

	public Boolean getMostrarid_zonaDetallePagos() {
		return this.mostrarid_zonaDetallePagos;
	}

	public void setMostrarid_zonaDetallePagos(Boolean mostrarid_zonaDetallePagos) {
		this.mostrarid_zonaDetallePagos= mostrarid_zonaDetallePagos;
	}

	public Boolean getActivarid_zonaDetallePagos() {
		return this.activarid_zonaDetallePagos;
	}

	public void setActivarid_zonaDetallePagos(Boolean activarid_zonaDetallePagos) {
		this.activarid_zonaDetallePagos= activarid_zonaDetallePagos;
	}

	public Boolean getCargarid_zonaDetallePagos() {
		return this.cargarid_zonaDetallePagos;
	}

	public void setCargarid_zonaDetallePagos(Boolean cargarid_zonaDetallePagos) {
		this.cargarid_zonaDetallePagos= cargarid_zonaDetallePagos;
	}

	public Border setResaltarfecha_emision_desdeDetallePagos(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePagosBeanSwingJInternalFrame detallepagosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepagosBeanSwingJInternalFrame.jTtoolBarDetallePagos.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_desdeDetallePagos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_desdeDetallePagos() {
		return this.resaltarfecha_emision_desdeDetallePagos;
	}

	public void setResaltarfecha_emision_desdeDetallePagos(Border borderResaltar) {
		this.resaltarfecha_emision_desdeDetallePagos= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_desdeDetallePagos() {
		return this.mostrarfecha_emision_desdeDetallePagos;
	}

	public void setMostrarfecha_emision_desdeDetallePagos(Boolean mostrarfecha_emision_desdeDetallePagos) {
		this.mostrarfecha_emision_desdeDetallePagos= mostrarfecha_emision_desdeDetallePagos;
	}

	public Boolean getActivarfecha_emision_desdeDetallePagos() {
		return this.activarfecha_emision_desdeDetallePagos;
	}

	public void setActivarfecha_emision_desdeDetallePagos(Boolean activarfecha_emision_desdeDetallePagos) {
		this.activarfecha_emision_desdeDetallePagos= activarfecha_emision_desdeDetallePagos;
	}

	public Border setResaltarfecha_emision_hastaDetallePagos(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePagosBeanSwingJInternalFrame detallepagosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepagosBeanSwingJInternalFrame.jTtoolBarDetallePagos.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_hastaDetallePagos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_hastaDetallePagos() {
		return this.resaltarfecha_emision_hastaDetallePagos;
	}

	public void setResaltarfecha_emision_hastaDetallePagos(Border borderResaltar) {
		this.resaltarfecha_emision_hastaDetallePagos= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_hastaDetallePagos() {
		return this.mostrarfecha_emision_hastaDetallePagos;
	}

	public void setMostrarfecha_emision_hastaDetallePagos(Boolean mostrarfecha_emision_hastaDetallePagos) {
		this.mostrarfecha_emision_hastaDetallePagos= mostrarfecha_emision_hastaDetallePagos;
	}

	public Boolean getActivarfecha_emision_hastaDetallePagos() {
		return this.activarfecha_emision_hastaDetallePagos;
	}

	public void setActivarfecha_emision_hastaDetallePagos(Boolean activarfecha_emision_hastaDetallePagos) {
		this.activarfecha_emision_hastaDetallePagos= activarfecha_emision_hastaDetallePagos;
	}

	public Border setResaltarcodigoDetallePagos(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePagosBeanSwingJInternalFrame detallepagosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepagosBeanSwingJInternalFrame.jTtoolBarDetallePagos.setBorder(borderResaltar);
		
		this.resaltarcodigoDetallePagos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoDetallePagos() {
		return this.resaltarcodigoDetallePagos;
	}

	public void setResaltarcodigoDetallePagos(Border borderResaltar) {
		this.resaltarcodigoDetallePagos= borderResaltar;
	}

	public Boolean getMostrarcodigoDetallePagos() {
		return this.mostrarcodigoDetallePagos;
	}

	public void setMostrarcodigoDetallePagos(Boolean mostrarcodigoDetallePagos) {
		this.mostrarcodigoDetallePagos= mostrarcodigoDetallePagos;
	}

	public Boolean getActivarcodigoDetallePagos() {
		return this.activarcodigoDetallePagos;
	}

	public void setActivarcodigoDetallePagos(Boolean activarcodigoDetallePagos) {
		this.activarcodigoDetallePagos= activarcodigoDetallePagos;
	}

	public Border setResaltarnombre_clienteDetallePagos(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePagosBeanSwingJInternalFrame detallepagosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepagosBeanSwingJInternalFrame.jTtoolBarDetallePagos.setBorder(borderResaltar);
		
		this.resaltarnombre_clienteDetallePagos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_clienteDetallePagos() {
		return this.resaltarnombre_clienteDetallePagos;
	}

	public void setResaltarnombre_clienteDetallePagos(Border borderResaltar) {
		this.resaltarnombre_clienteDetallePagos= borderResaltar;
	}

	public Boolean getMostrarnombre_clienteDetallePagos() {
		return this.mostrarnombre_clienteDetallePagos;
	}

	public void setMostrarnombre_clienteDetallePagos(Boolean mostrarnombre_clienteDetallePagos) {
		this.mostrarnombre_clienteDetallePagos= mostrarnombre_clienteDetallePagos;
	}

	public Boolean getActivarnombre_clienteDetallePagos() {
		return this.activarnombre_clienteDetallePagos;
	}

	public void setActivarnombre_clienteDetallePagos(Boolean activarnombre_clienteDetallePagos) {
		this.activarnombre_clienteDetallePagos= activarnombre_clienteDetallePagos;
	}

	public Border setResaltarrucDetallePagos(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePagosBeanSwingJInternalFrame detallepagosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepagosBeanSwingJInternalFrame.jTtoolBarDetallePagos.setBorder(borderResaltar);
		
		this.resaltarrucDetallePagos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarrucDetallePagos() {
		return this.resaltarrucDetallePagos;
	}

	public void setResaltarrucDetallePagos(Border borderResaltar) {
		this.resaltarrucDetallePagos= borderResaltar;
	}

	public Boolean getMostrarrucDetallePagos() {
		return this.mostrarrucDetallePagos;
	}

	public void setMostrarrucDetallePagos(Boolean mostrarrucDetallePagos) {
		this.mostrarrucDetallePagos= mostrarrucDetallePagos;
	}

	public Boolean getActivarrucDetallePagos() {
		return this.activarrucDetallePagos;
	}

	public void setActivarrucDetallePagos(Boolean activarrucDetallePagos) {
		this.activarrucDetallePagos= activarrucDetallePagos;
	}

	public Border setResaltartotal_facturasDetallePagos(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePagosBeanSwingJInternalFrame detallepagosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepagosBeanSwingJInternalFrame.jTtoolBarDetallePagos.setBorder(borderResaltar);
		
		this.resaltartotal_facturasDetallePagos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_facturasDetallePagos() {
		return this.resaltartotal_facturasDetallePagos;
	}

	public void setResaltartotal_facturasDetallePagos(Border borderResaltar) {
		this.resaltartotal_facturasDetallePagos= borderResaltar;
	}

	public Boolean getMostrartotal_facturasDetallePagos() {
		return this.mostrartotal_facturasDetallePagos;
	}

	public void setMostrartotal_facturasDetallePagos(Boolean mostrartotal_facturasDetallePagos) {
		this.mostrartotal_facturasDetallePagos= mostrartotal_facturasDetallePagos;
	}

	public Boolean getActivartotal_facturasDetallePagos() {
		return this.activartotal_facturasDetallePagos;
	}

	public void setActivartotal_facturasDetallePagos(Boolean activartotal_facturasDetallePagos) {
		this.activartotal_facturasDetallePagos= activartotal_facturasDetallePagos;
	}

	public Border setResaltartotal_abonosDetallePagos(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePagosBeanSwingJInternalFrame detallepagosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepagosBeanSwingJInternalFrame.jTtoolBarDetallePagos.setBorder(borderResaltar);
		
		this.resaltartotal_abonosDetallePagos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_abonosDetallePagos() {
		return this.resaltartotal_abonosDetallePagos;
	}

	public void setResaltartotal_abonosDetallePagos(Border borderResaltar) {
		this.resaltartotal_abonosDetallePagos= borderResaltar;
	}

	public Boolean getMostrartotal_abonosDetallePagos() {
		return this.mostrartotal_abonosDetallePagos;
	}

	public void setMostrartotal_abonosDetallePagos(Boolean mostrartotal_abonosDetallePagos) {
		this.mostrartotal_abonosDetallePagos= mostrartotal_abonosDetallePagos;
	}

	public Boolean getActivartotal_abonosDetallePagos() {
		return this.activartotal_abonosDetallePagos;
	}

	public void setActivartotal_abonosDetallePagos(Boolean activartotal_abonosDetallePagos) {
		this.activartotal_abonosDetallePagos= activartotal_abonosDetallePagos;
	}

	public Border setResaltartotal_facturas_actualDetallePagos(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePagosBeanSwingJInternalFrame detallepagosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepagosBeanSwingJInternalFrame.jTtoolBarDetallePagos.setBorder(borderResaltar);
		
		this.resaltartotal_facturas_actualDetallePagos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_facturas_actualDetallePagos() {
		return this.resaltartotal_facturas_actualDetallePagos;
	}

	public void setResaltartotal_facturas_actualDetallePagos(Border borderResaltar) {
		this.resaltartotal_facturas_actualDetallePagos= borderResaltar;
	}

	public Boolean getMostrartotal_facturas_actualDetallePagos() {
		return this.mostrartotal_facturas_actualDetallePagos;
	}

	public void setMostrartotal_facturas_actualDetallePagos(Boolean mostrartotal_facturas_actualDetallePagos) {
		this.mostrartotal_facturas_actualDetallePagos= mostrartotal_facturas_actualDetallePagos;
	}

	public Boolean getActivartotal_facturas_actualDetallePagos() {
		return this.activartotal_facturas_actualDetallePagos;
	}

	public void setActivartotal_facturas_actualDetallePagos(Boolean activartotal_facturas_actualDetallePagos) {
		this.activartotal_facturas_actualDetallePagos= activartotal_facturas_actualDetallePagos;
	}

	public Border setResaltarabonos_anteriorDetallePagos(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePagosBeanSwingJInternalFrame detallepagosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepagosBeanSwingJInternalFrame.jTtoolBarDetallePagos.setBorder(borderResaltar);
		
		this.resaltarabonos_anteriorDetallePagos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarabonos_anteriorDetallePagos() {
		return this.resaltarabonos_anteriorDetallePagos;
	}

	public void setResaltarabonos_anteriorDetallePagos(Border borderResaltar) {
		this.resaltarabonos_anteriorDetallePagos= borderResaltar;
	}

	public Boolean getMostrarabonos_anteriorDetallePagos() {
		return this.mostrarabonos_anteriorDetallePagos;
	}

	public void setMostrarabonos_anteriorDetallePagos(Boolean mostrarabonos_anteriorDetallePagos) {
		this.mostrarabonos_anteriorDetallePagos= mostrarabonos_anteriorDetallePagos;
	}

	public Boolean getActivarabonos_anteriorDetallePagos() {
		return this.activarabonos_anteriorDetallePagos;
	}

	public void setActivarabonos_anteriorDetallePagos(Boolean activarabonos_anteriorDetallePagos) {
		this.activarabonos_anteriorDetallePagos= activarabonos_anteriorDetallePagos;
	}

	public Border setResaltarabonos_actualDetallePagos(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePagosBeanSwingJInternalFrame detallepagosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepagosBeanSwingJInternalFrame.jTtoolBarDetallePagos.setBorder(borderResaltar);
		
		this.resaltarabonos_actualDetallePagos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarabonos_actualDetallePagos() {
		return this.resaltarabonos_actualDetallePagos;
	}

	public void setResaltarabonos_actualDetallePagos(Border borderResaltar) {
		this.resaltarabonos_actualDetallePagos= borderResaltar;
	}

	public Boolean getMostrarabonos_actualDetallePagos() {
		return this.mostrarabonos_actualDetallePagos;
	}

	public void setMostrarabonos_actualDetallePagos(Boolean mostrarabonos_actualDetallePagos) {
		this.mostrarabonos_actualDetallePagos= mostrarabonos_actualDetallePagos;
	}

	public Boolean getActivarabonos_actualDetallePagos() {
		return this.activarabonos_actualDetallePagos;
	}

	public void setActivarabonos_actualDetallePagos(Boolean activarabonos_actualDetallePagos) {
		this.activarabonos_actualDetallePagos= activarabonos_actualDetallePagos;
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
		
		
		this.setMostraridDetallePagos(esInicial);
		this.setMostrarid_empresaDetallePagos(esInicial);
		this.setMostrarid_grupo_clienteDetallePagos(esInicial);
		this.setMostrarid_zonaDetallePagos(esInicial);
		this.setMostrarfecha_emision_desdeDetallePagos(esInicial);
		this.setMostrarfecha_emision_hastaDetallePagos(esInicial);
		this.setMostrarcodigoDetallePagos(esInicial);
		this.setMostrarnombre_clienteDetallePagos(esInicial);
		this.setMostrarrucDetallePagos(esInicial);
		this.setMostrartotal_facturasDetallePagos(esInicial);
		this.setMostrartotal_abonosDetallePagos(esInicial);
		this.setMostrartotal_facturas_actualDetallePagos(esInicial);
		this.setMostrarabonos_anteriorDetallePagos(esInicial);
		this.setMostrarabonos_actualDetallePagos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetallePagosConstantesFunciones.ID)) {
				this.setMostraridDetallePagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagosConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDetallePagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagosConstantesFunciones.IDGRUPOCLIENTE)) {
				this.setMostrarid_grupo_clienteDetallePagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagosConstantesFunciones.IDZONA)) {
				this.setMostrarid_zonaDetallePagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagosConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setMostrarfecha_emision_desdeDetallePagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagosConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setMostrarfecha_emision_hastaDetallePagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagosConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoDetallePagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagosConstantesFunciones.NOMBRECLIENTE)) {
				this.setMostrarnombre_clienteDetallePagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagosConstantesFunciones.RUC)) {
				this.setMostrarrucDetallePagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagosConstantesFunciones.TOTALFACTURAS)) {
				this.setMostrartotal_facturasDetallePagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagosConstantesFunciones.TOTALABONOS)) {
				this.setMostrartotal_abonosDetallePagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagosConstantesFunciones.TOTALFACTURASACTUAL)) {
				this.setMostrartotal_facturas_actualDetallePagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagosConstantesFunciones.ABONOSANTERIOR)) {
				this.setMostrarabonos_anteriorDetallePagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagosConstantesFunciones.ABONOSACTUAL)) {
				this.setMostrarabonos_actualDetallePagos(esAsigna);
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
		
		
		this.setActivaridDetallePagos(esInicial);
		this.setActivarid_empresaDetallePagos(esInicial);
		this.setActivarid_grupo_clienteDetallePagos(esInicial);
		this.setActivarid_zonaDetallePagos(esInicial);
		this.setActivarfecha_emision_desdeDetallePagos(esInicial);
		this.setActivarfecha_emision_hastaDetallePagos(esInicial);
		this.setActivarcodigoDetallePagos(esInicial);
		this.setActivarnombre_clienteDetallePagos(esInicial);
		this.setActivarrucDetallePagos(esInicial);
		this.setActivartotal_facturasDetallePagos(esInicial);
		this.setActivartotal_abonosDetallePagos(esInicial);
		this.setActivartotal_facturas_actualDetallePagos(esInicial);
		this.setActivarabonos_anteriorDetallePagos(esInicial);
		this.setActivarabonos_actualDetallePagos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetallePagosConstantesFunciones.ID)) {
				this.setActivaridDetallePagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagosConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDetallePagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagosConstantesFunciones.IDGRUPOCLIENTE)) {
				this.setActivarid_grupo_clienteDetallePagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagosConstantesFunciones.IDZONA)) {
				this.setActivarid_zonaDetallePagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagosConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setActivarfecha_emision_desdeDetallePagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagosConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setActivarfecha_emision_hastaDetallePagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagosConstantesFunciones.CODIGO)) {
				this.setActivarcodigoDetallePagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagosConstantesFunciones.NOMBRECLIENTE)) {
				this.setActivarnombre_clienteDetallePagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagosConstantesFunciones.RUC)) {
				this.setActivarrucDetallePagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagosConstantesFunciones.TOTALFACTURAS)) {
				this.setActivartotal_facturasDetallePagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagosConstantesFunciones.TOTALABONOS)) {
				this.setActivartotal_abonosDetallePagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagosConstantesFunciones.TOTALFACTURASACTUAL)) {
				this.setActivartotal_facturas_actualDetallePagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagosConstantesFunciones.ABONOSANTERIOR)) {
				this.setActivarabonos_anteriorDetallePagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagosConstantesFunciones.ABONOSACTUAL)) {
				this.setActivarabonos_actualDetallePagos(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DetallePagosBeanSwingJInternalFrame detallepagosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDetallePagos(esInicial);
		this.setResaltarid_empresaDetallePagos(esInicial);
		this.setResaltarid_grupo_clienteDetallePagos(esInicial);
		this.setResaltarid_zonaDetallePagos(esInicial);
		this.setResaltarfecha_emision_desdeDetallePagos(esInicial);
		this.setResaltarfecha_emision_hastaDetallePagos(esInicial);
		this.setResaltarcodigoDetallePagos(esInicial);
		this.setResaltarnombre_clienteDetallePagos(esInicial);
		this.setResaltarrucDetallePagos(esInicial);
		this.setResaltartotal_facturasDetallePagos(esInicial);
		this.setResaltartotal_abonosDetallePagos(esInicial);
		this.setResaltartotal_facturas_actualDetallePagos(esInicial);
		this.setResaltarabonos_anteriorDetallePagos(esInicial);
		this.setResaltarabonos_actualDetallePagos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetallePagosConstantesFunciones.ID)) {
				this.setResaltaridDetallePagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagosConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDetallePagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagosConstantesFunciones.IDGRUPOCLIENTE)) {
				this.setResaltarid_grupo_clienteDetallePagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagosConstantesFunciones.IDZONA)) {
				this.setResaltarid_zonaDetallePagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagosConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setResaltarfecha_emision_desdeDetallePagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagosConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setResaltarfecha_emision_hastaDetallePagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagosConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoDetallePagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagosConstantesFunciones.NOMBRECLIENTE)) {
				this.setResaltarnombre_clienteDetallePagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagosConstantesFunciones.RUC)) {
				this.setResaltarrucDetallePagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagosConstantesFunciones.TOTALFACTURAS)) {
				this.setResaltartotal_facturasDetallePagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagosConstantesFunciones.TOTALABONOS)) {
				this.setResaltartotal_abonosDetallePagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagosConstantesFunciones.TOTALFACTURASACTUAL)) {
				this.setResaltartotal_facturas_actualDetallePagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagosConstantesFunciones.ABONOSANTERIOR)) {
				this.setResaltarabonos_anteriorDetallePagos(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagosConstantesFunciones.ABONOSACTUAL)) {
				this.setResaltarabonos_actualDetallePagos(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DetallePagosBeanSwingJInternalFrame detallepagosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaDetallePagosDetallePagos=true;

	public Boolean getMostrarBusquedaDetallePagosDetallePagos() {
		return this.mostrarBusquedaDetallePagosDetallePagos;
	}

	public void setMostrarBusquedaDetallePagosDetallePagos(Boolean visibilidadResaltar) {
		this.mostrarBusquedaDetallePagosDetallePagos= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaDetallePagosDetallePagos=true;

	public Boolean getActivarBusquedaDetallePagosDetallePagos() {
		return this.activarBusquedaDetallePagosDetallePagos;
	}

	public void setActivarBusquedaDetallePagosDetallePagos(Boolean habilitarResaltar) {
		this.activarBusquedaDetallePagosDetallePagos= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaDetallePagosDetallePagos=null;

	public Border getResaltarBusquedaDetallePagosDetallePagos() {
		return this.resaltarBusquedaDetallePagosDetallePagos;
	}

	public void setResaltarBusquedaDetallePagosDetallePagos(Border borderResaltar) {
		this.resaltarBusquedaDetallePagosDetallePagos= borderResaltar;
	}

	public void setResaltarBusquedaDetallePagosDetallePagos(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePagosBeanSwingJInternalFrame detallepagosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaDetallePagosDetallePagos= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}