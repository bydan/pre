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
package com.bydan.erp.contabilidad.util;

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


import com.bydan.erp.contabilidad.util.LineaFlujoCajaConstantesFunciones;
import com.bydan.erp.contabilidad.util.LineaFlujoCajaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.LineaFlujoCajaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class LineaFlujoCajaConstantesFunciones extends LineaFlujoCajaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="LineaFlujoCaja";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="LineaFlujoCaja"+LineaFlujoCajaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="LineaFlujoCajaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="LineaFlujoCajaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=LineaFlujoCajaConstantesFunciones.SCHEMA+"_"+LineaFlujoCajaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/LineaFlujoCajaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=LineaFlujoCajaConstantesFunciones.SCHEMA+"_"+LineaFlujoCajaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=LineaFlujoCajaConstantesFunciones.SCHEMA+"_"+LineaFlujoCajaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/LineaFlujoCajaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=LineaFlujoCajaConstantesFunciones.SCHEMA+"_"+LineaFlujoCajaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+LineaFlujoCajaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/LineaFlujoCajaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+LineaFlujoCajaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+LineaFlujoCajaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/LineaFlujoCajaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+LineaFlujoCajaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=LineaFlujoCajaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+LineaFlujoCajaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=LineaFlujoCajaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+LineaFlujoCajaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Linea Flujo Cajas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Linea Flujo Caja";
	public static final String SCLASSWEBTITULO_LOWER="Linea Flujo Caja";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="LineaFlujoCaja";
	public static final String OBJECTNAME="lineaflujocaja";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="linea_flujo_caja";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select lineaflujocaja from "+LineaFlujoCajaConstantesFunciones.SPERSISTENCENAME+" lineaflujocaja";
	public static String QUERYSELECTNATIVE="select "+LineaFlujoCajaConstantesFunciones.SCHEMA+"."+LineaFlujoCajaConstantesFunciones.TABLENAME+".id,"+LineaFlujoCajaConstantesFunciones.SCHEMA+"."+LineaFlujoCajaConstantesFunciones.TABLENAME+".version_row,"+LineaFlujoCajaConstantesFunciones.SCHEMA+"."+LineaFlujoCajaConstantesFunciones.TABLENAME+".id_empresa,"+LineaFlujoCajaConstantesFunciones.SCHEMA+"."+LineaFlujoCajaConstantesFunciones.TABLENAME+".id_tipo_grupo_flujo_caja,"+LineaFlujoCajaConstantesFunciones.SCHEMA+"."+LineaFlujoCajaConstantesFunciones.TABLENAME+".codigo,"+LineaFlujoCajaConstantesFunciones.SCHEMA+"."+LineaFlujoCajaConstantesFunciones.TABLENAME+".nombre,"+LineaFlujoCajaConstantesFunciones.SCHEMA+"."+LineaFlujoCajaConstantesFunciones.TABLENAME+".id_tipo_linea_flujo_caja,"+LineaFlujoCajaConstantesFunciones.SCHEMA+"."+LineaFlujoCajaConstantesFunciones.TABLENAME+".es_consolidado,"+LineaFlujoCajaConstantesFunciones.SCHEMA+"."+LineaFlujoCajaConstantesFunciones.TABLENAME+".esta_proyeccion from "+LineaFlujoCajaConstantesFunciones.SCHEMA+"."+LineaFlujoCajaConstantesFunciones.TABLENAME;//+" as "+LineaFlujoCajaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected LineaFlujoCajaConstantesFuncionesAdditional lineaflujocajaConstantesFuncionesAdditional=null;
	
	public LineaFlujoCajaConstantesFuncionesAdditional getLineaFlujoCajaConstantesFuncionesAdditional() {
		return this.lineaflujocajaConstantesFuncionesAdditional;
	}
	
	public void setLineaFlujoCajaConstantesFuncionesAdditional(LineaFlujoCajaConstantesFuncionesAdditional lineaflujocajaConstantesFuncionesAdditional) {
		try {
			this.lineaflujocajaConstantesFuncionesAdditional=lineaflujocajaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDTIPOGRUPOFLUJOCAJA= "id_tipo_grupo_flujo_caja";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String IDTIPOLINEAFLUJOCAJA= "id_tipo_linea_flujo_caja";
    public static final String ESCONSOLIDADO= "es_consolidado";
    public static final String ESTAPROYECCION= "esta_proyeccion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDTIPOGRUPOFLUJOCAJA= "Tipo Grupo Flujo Caja";
		public static final String LABEL_IDTIPOGRUPOFLUJOCAJA_LOWER= "Tipo Grupo Flujo Caja";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_IDTIPOLINEAFLUJOCAJA= "Tipo Linea Flujo Caja";
		public static final String LABEL_IDTIPOLINEAFLUJOCAJA_LOWER= "Tipo Linea Flujo Caja";
    	public static final String LABEL_ESCONSOLIDADO= "Es Consolidado";
		public static final String LABEL_ESCONSOLIDADO_LOWER= "Es Consolidado";
    	public static final String LABEL_ESTAPROYECCION= "Esta Proyeccion";
		public static final String LABEL_ESTAPROYECCION_LOWER= "Esta Proyeccion";
	
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	
	public static String getLineaFlujoCajaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(LineaFlujoCajaConstantesFunciones.IDEMPRESA)) {sLabelColumna=LineaFlujoCajaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(LineaFlujoCajaConstantesFunciones.IDTIPOGRUPOFLUJOCAJA)) {sLabelColumna=LineaFlujoCajaConstantesFunciones.LABEL_IDTIPOGRUPOFLUJOCAJA;}
		if(sNombreColumna.equals(LineaFlujoCajaConstantesFunciones.CODIGO)) {sLabelColumna=LineaFlujoCajaConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(LineaFlujoCajaConstantesFunciones.NOMBRE)) {sLabelColumna=LineaFlujoCajaConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(LineaFlujoCajaConstantesFunciones.IDTIPOLINEAFLUJOCAJA)) {sLabelColumna=LineaFlujoCajaConstantesFunciones.LABEL_IDTIPOLINEAFLUJOCAJA;}
		if(sNombreColumna.equals(LineaFlujoCajaConstantesFunciones.ESCONSOLIDADO)) {sLabelColumna=LineaFlujoCajaConstantesFunciones.LABEL_ESCONSOLIDADO;}
		if(sNombreColumna.equals(LineaFlujoCajaConstantesFunciones.ESTAPROYECCION)) {sLabelColumna=LineaFlujoCajaConstantesFunciones.LABEL_ESTAPROYECCION;}
		
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
	
	
	
			
			
			
			
			
			
			
		
	public static String getes_consolidadoDescripcion(LineaFlujoCaja lineaflujocaja) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!lineaflujocaja.getes_consolidado()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_consolidadoHtmlDescripcion(LineaFlujoCaja lineaflujocaja) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(lineaflujocaja.getId(),lineaflujocaja.getes_consolidado());

		return sDescripcion;
	}	
		
	public static String getesta_proyeccionDescripcion(LineaFlujoCaja lineaflujocaja) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!lineaflujocaja.getesta_proyeccion()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getesta_proyeccionHtmlDescripcion(LineaFlujoCaja lineaflujocaja) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(lineaflujocaja.getId(),lineaflujocaja.getesta_proyeccion());

		return sDescripcion;
	}	
	
	public static String getLineaFlujoCajaDescripcion(LineaFlujoCaja lineaflujocaja) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(lineaflujocaja !=null/* && lineaflujocaja.getId()!=0*/) {
			sDescripcion=lineaflujocaja.getcodigo();//lineaflujocajalineaflujocaja.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getLineaFlujoCajaDescripcionDetallado(LineaFlujoCaja lineaflujocaja) {
		String sDescripcion="";
			
		sDescripcion+=LineaFlujoCajaConstantesFunciones.ID+"=";
		sDescripcion+=lineaflujocaja.getId().toString()+",";
		sDescripcion+=LineaFlujoCajaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=lineaflujocaja.getVersionRow().toString()+",";
		sDescripcion+=LineaFlujoCajaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=lineaflujocaja.getid_empresa().toString()+",";
		sDescripcion+=LineaFlujoCajaConstantesFunciones.IDTIPOGRUPOFLUJOCAJA+"=";
		sDescripcion+=lineaflujocaja.getid_tipo_grupo_flujo_caja().toString()+",";
		sDescripcion+=LineaFlujoCajaConstantesFunciones.CODIGO+"=";
		sDescripcion+=lineaflujocaja.getcodigo()+",";
		sDescripcion+=LineaFlujoCajaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=lineaflujocaja.getnombre()+",";
		sDescripcion+=LineaFlujoCajaConstantesFunciones.IDTIPOLINEAFLUJOCAJA+"=";
		sDescripcion+=lineaflujocaja.getid_tipo_linea_flujo_caja().toString()+",";
		sDescripcion+=LineaFlujoCajaConstantesFunciones.ESCONSOLIDADO+"=";
		sDescripcion+=lineaflujocaja.getes_consolidado().toString()+",";
		sDescripcion+=LineaFlujoCajaConstantesFunciones.ESTAPROYECCION+"=";
		sDescripcion+=lineaflujocaja.getesta_proyeccion().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setLineaFlujoCajaDescripcion(LineaFlujoCaja lineaflujocaja,String sValor) throws Exception {			
		if(lineaflujocaja !=null) {
			lineaflujocaja.setcodigo(sValor);;//lineaflujocajalineaflujocaja.getcodigo().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getTipoGrupoFlujoCajaDescripcion(TipoGrupoFlujoCaja tipogrupoflujocaja) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipogrupoflujocaja!=null/*&&tipogrupoflujocaja.getId()>0*/) {
			sDescripcion=TipoGrupoFlujoCajaConstantesFunciones.getTipoGrupoFlujoCajaDescripcion(tipogrupoflujocaja);
		}

		return sDescripcion;
	}

	public static String getTipoLineaFlujoCajaDescripcion(TipoLineaFlujoCaja tipolineaflujocaja) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipolineaflujocaja!=null/*&&tipolineaflujocaja.getId()>0*/) {
			sDescripcion=TipoLineaFlujoCajaConstantesFunciones.getTipoLineaFlujoCajaDescripcion(tipolineaflujocaja);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaPorCodigo")) {
			sNombreIndice="Tipo=  Por Codigo";
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdTipoGrupoFlujoCaja")) {
			sNombreIndice="Tipo=  Por Tipo Grupo Flujo Caja";
		} else if(sNombreIndice.equals("FK_IdTipoLineaFlujoCaja")) {
			sNombreIndice="Tipo=  Por Tipo Linea Flujo Caja";
		} else if(sNombreIndice.equals("PorEmpresaPorTipoLineaFlujo")) {
			sNombreIndice="Tipo=  Por Empresa Por Tipo Linea Flujo Caja";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaPorCodigo(String codigo) {
		String sDetalleIndice=" Parametros->";
		if(codigo!=null) {sDetalleIndice+=" Codigo="+codigo;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceBusquedaPorNombre(String nombre) {
		String sDetalleIndice=" Parametros->";
		if(nombre!=null) {sDetalleIndice+=" Nombre="+nombre;} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoGrupoFlujoCaja(Long id_tipo_grupo_flujo_caja) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_grupo_flujo_caja!=null) {sDetalleIndice+=" Codigo Unico De Tipo Grupo Flujo Caja="+id_tipo_grupo_flujo_caja.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoLineaFlujoCaja(Long id_tipo_linea_flujo_caja) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_linea_flujo_caja!=null) {sDetalleIndice+=" Codigo Unico De Tipo Linea Flujo Caja="+id_tipo_linea_flujo_caja.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndicePorEmpresaPorTipoLineaFlujo(Long id_empresa,Long id_tipo_linea_flujo_caja) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();}
		if(id_tipo_linea_flujo_caja!=null) {sDetalleIndice+=" Codigo Unico De Tipo Linea Flujo Caja="+id_tipo_linea_flujo_caja.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosLineaFlujoCaja(LineaFlujoCaja lineaflujocaja,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		lineaflujocaja.setcodigo(lineaflujocaja.getcodigo().trim());
		lineaflujocaja.setnombre(lineaflujocaja.getnombre().trim());
	}
	
	public static void quitarEspaciosLineaFlujoCajas(List<LineaFlujoCaja> lineaflujocajas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(LineaFlujoCaja lineaflujocaja: lineaflujocajas) {
			lineaflujocaja.setcodigo(lineaflujocaja.getcodigo().trim());
			lineaflujocaja.setnombre(lineaflujocaja.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresLineaFlujoCaja(LineaFlujoCaja lineaflujocaja,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && lineaflujocaja.getConCambioAuxiliar()) {
			lineaflujocaja.setIsDeleted(lineaflujocaja.getIsDeletedAuxiliar());	
			lineaflujocaja.setIsNew(lineaflujocaja.getIsNewAuxiliar());	
			lineaflujocaja.setIsChanged(lineaflujocaja.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			lineaflujocaja.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			lineaflujocaja.setIsDeletedAuxiliar(false);	
			lineaflujocaja.setIsNewAuxiliar(false);	
			lineaflujocaja.setIsChangedAuxiliar(false);
			
			lineaflujocaja.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresLineaFlujoCajas(List<LineaFlujoCaja> lineaflujocajas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(LineaFlujoCaja lineaflujocaja : lineaflujocajas) {
			if(conAsignarBase && lineaflujocaja.getConCambioAuxiliar()) {
				lineaflujocaja.setIsDeleted(lineaflujocaja.getIsDeletedAuxiliar());	
				lineaflujocaja.setIsNew(lineaflujocaja.getIsNewAuxiliar());	
				lineaflujocaja.setIsChanged(lineaflujocaja.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				lineaflujocaja.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				lineaflujocaja.setIsDeletedAuxiliar(false);	
				lineaflujocaja.setIsNewAuxiliar(false);	
				lineaflujocaja.setIsChangedAuxiliar(false);
				
				lineaflujocaja.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresLineaFlujoCaja(LineaFlujoCaja lineaflujocaja,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresLineaFlujoCajas(List<LineaFlujoCaja> lineaflujocajas,Boolean conEnteros) throws Exception  {
		
		for(LineaFlujoCaja lineaflujocaja: lineaflujocajas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaLineaFlujoCaja(List<LineaFlujoCaja> lineaflujocajas,LineaFlujoCaja lineaflujocajaAux) throws Exception  {
		LineaFlujoCajaConstantesFunciones.InicializarValoresLineaFlujoCaja(lineaflujocajaAux,true);
		
		for(LineaFlujoCaja lineaflujocaja: lineaflujocajas) {
			if(lineaflujocaja.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesLineaFlujoCaja(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=LineaFlujoCajaConstantesFunciones.getArrayColumnasGlobalesLineaFlujoCaja(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesLineaFlujoCaja(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(LineaFlujoCajaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(LineaFlujoCajaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoLineaFlujoCaja(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<LineaFlujoCaja> lineaflujocajas,LineaFlujoCaja lineaflujocaja,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(LineaFlujoCaja lineaflujocajaAux: lineaflujocajas) {
			if(lineaflujocajaAux!=null && lineaflujocaja!=null) {
				if((lineaflujocajaAux.getId()==null && lineaflujocaja.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(lineaflujocajaAux.getId()!=null && lineaflujocaja.getId()!=null){
					if(lineaflujocajaAux.getId().equals(lineaflujocaja.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaLineaFlujoCaja(List<LineaFlujoCaja> lineaflujocajas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(LineaFlujoCaja lineaflujocaja: lineaflujocajas) {			
			if(lineaflujocaja.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaLineaFlujoCaja() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,LineaFlujoCajaConstantesFunciones.LABEL_ID, LineaFlujoCajaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LineaFlujoCajaConstantesFunciones.LABEL_VERSIONROW, LineaFlujoCajaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LineaFlujoCajaConstantesFunciones.LABEL_IDEMPRESA, LineaFlujoCajaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LineaFlujoCajaConstantesFunciones.LABEL_IDTIPOGRUPOFLUJOCAJA, LineaFlujoCajaConstantesFunciones.IDTIPOGRUPOFLUJOCAJA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LineaFlujoCajaConstantesFunciones.LABEL_CODIGO, LineaFlujoCajaConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LineaFlujoCajaConstantesFunciones.LABEL_NOMBRE, LineaFlujoCajaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LineaFlujoCajaConstantesFunciones.LABEL_IDTIPOLINEAFLUJOCAJA, LineaFlujoCajaConstantesFunciones.IDTIPOLINEAFLUJOCAJA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LineaFlujoCajaConstantesFunciones.LABEL_ESCONSOLIDADO, LineaFlujoCajaConstantesFunciones.ESCONSOLIDADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,LineaFlujoCajaConstantesFunciones.LABEL_ESTAPROYECCION, LineaFlujoCajaConstantesFunciones.ESTAPROYECCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasLineaFlujoCaja() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=LineaFlujoCajaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LineaFlujoCajaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LineaFlujoCajaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LineaFlujoCajaConstantesFunciones.IDTIPOGRUPOFLUJOCAJA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LineaFlujoCajaConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LineaFlujoCajaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LineaFlujoCajaConstantesFunciones.IDTIPOLINEAFLUJOCAJA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LineaFlujoCajaConstantesFunciones.ESCONSOLIDADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=LineaFlujoCajaConstantesFunciones.ESTAPROYECCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarLineaFlujoCaja() throws Exception  {
		return LineaFlujoCajaConstantesFunciones.getTiposSeleccionarLineaFlujoCaja(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarLineaFlujoCaja(Boolean conFk) throws Exception  {
		return LineaFlujoCajaConstantesFunciones.getTiposSeleccionarLineaFlujoCaja(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarLineaFlujoCaja(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(LineaFlujoCajaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(LineaFlujoCajaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(LineaFlujoCajaConstantesFunciones.LABEL_IDTIPOGRUPOFLUJOCAJA);
			reporte.setsDescripcion(LineaFlujoCajaConstantesFunciones.LABEL_IDTIPOGRUPOFLUJOCAJA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(LineaFlujoCajaConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(LineaFlujoCajaConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(LineaFlujoCajaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(LineaFlujoCajaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(LineaFlujoCajaConstantesFunciones.LABEL_IDTIPOLINEAFLUJOCAJA);
			reporte.setsDescripcion(LineaFlujoCajaConstantesFunciones.LABEL_IDTIPOLINEAFLUJOCAJA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(LineaFlujoCajaConstantesFunciones.LABEL_ESCONSOLIDADO);
			reporte.setsDescripcion(LineaFlujoCajaConstantesFunciones.LABEL_ESCONSOLIDADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(LineaFlujoCajaConstantesFunciones.LABEL_ESTAPROYECCION);
			reporte.setsDescripcion(LineaFlujoCajaConstantesFunciones.LABEL_ESTAPROYECCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesLineaFlujoCaja(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesLineaFlujoCaja(LineaFlujoCaja lineaflujocajaAux) throws Exception {
		
			lineaflujocajaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(lineaflujocajaAux.getEmpresa()));
			lineaflujocajaAux.settipogrupoflujocaja_descripcion(TipoGrupoFlujoCajaConstantesFunciones.getTipoGrupoFlujoCajaDescripcion(lineaflujocajaAux.getTipoGrupoFlujoCaja()));
			lineaflujocajaAux.settipolineaflujocaja_descripcion(TipoLineaFlujoCajaConstantesFunciones.getTipoLineaFlujoCajaDescripcion(lineaflujocajaAux.getTipoLineaFlujoCaja()));		
	}
	
	public static void refrescarForeignKeysDescripcionesLineaFlujoCaja(List<LineaFlujoCaja> lineaflujocajasTemp) throws Exception {
		for(LineaFlujoCaja lineaflujocajaAux:lineaflujocajasTemp) {
			
			lineaflujocajaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(lineaflujocajaAux.getEmpresa()));
			lineaflujocajaAux.settipogrupoflujocaja_descripcion(TipoGrupoFlujoCajaConstantesFunciones.getTipoGrupoFlujoCajaDescripcion(lineaflujocajaAux.getTipoGrupoFlujoCaja()));
			lineaflujocajaAux.settipolineaflujocaja_descripcion(TipoLineaFlujoCajaConstantesFunciones.getTipoLineaFlujoCajaDescripcion(lineaflujocajaAux.getTipoLineaFlujoCaja()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfLineaFlujoCaja(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(TipoGrupoFlujoCaja.class));
				classes.add(new Classe(TipoLineaFlujoCaja.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoGrupoFlujoCaja.class)) {
						classes.add(new Classe(TipoGrupoFlujoCaja.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoLineaFlujoCaja.class)) {
						classes.add(new Classe(TipoLineaFlujoCaja.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfLineaFlujoCaja(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(TipoGrupoFlujoCaja.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoGrupoFlujoCaja.class)); continue;
					}

					if(TipoLineaFlujoCaja.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoLineaFlujoCaja.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(TipoGrupoFlujoCaja.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoGrupoFlujoCaja.class)); continue;
					}

					if(TipoLineaFlujoCaja.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoLineaFlujoCaja.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfLineaFlujoCaja(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return LineaFlujoCajaConstantesFunciones.getClassesRelationshipsOfLineaFlujoCaja(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfLineaFlujoCaja(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfLineaFlujoCaja(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return LineaFlujoCajaConstantesFunciones.getClassesRelationshipsFromStringsOfLineaFlujoCaja(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfLineaFlujoCaja(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(LineaFlujoCaja lineaflujocaja,List<LineaFlujoCaja> lineaflujocajas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			LineaFlujoCaja lineaflujocajaEncontrado=null;
			
			for(LineaFlujoCaja lineaflujocajaLocal:lineaflujocajas) {
				if(lineaflujocajaLocal.getId().equals(lineaflujocaja.getId())) {
					lineaflujocajaEncontrado=lineaflujocajaLocal;
					
					lineaflujocajaLocal.setIsChanged(lineaflujocaja.getIsChanged());
					lineaflujocajaLocal.setIsNew(lineaflujocaja.getIsNew());
					lineaflujocajaLocal.setIsDeleted(lineaflujocaja.getIsDeleted());
					
					lineaflujocajaLocal.setGeneralEntityOriginal(lineaflujocaja.getGeneralEntityOriginal());
					
					lineaflujocajaLocal.setId(lineaflujocaja.getId());	
					lineaflujocajaLocal.setVersionRow(lineaflujocaja.getVersionRow());	
					lineaflujocajaLocal.setid_empresa(lineaflujocaja.getid_empresa());	
					lineaflujocajaLocal.setid_tipo_grupo_flujo_caja(lineaflujocaja.getid_tipo_grupo_flujo_caja());	
					lineaflujocajaLocal.setcodigo(lineaflujocaja.getcodigo());	
					lineaflujocajaLocal.setnombre(lineaflujocaja.getnombre());	
					lineaflujocajaLocal.setid_tipo_linea_flujo_caja(lineaflujocaja.getid_tipo_linea_flujo_caja());	
					lineaflujocajaLocal.setes_consolidado(lineaflujocaja.getes_consolidado());	
					lineaflujocajaLocal.setesta_proyeccion(lineaflujocaja.getesta_proyeccion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!lineaflujocaja.getIsDeleted()) {
				if(!existe) {
					lineaflujocajas.add(lineaflujocaja);
				}
			} else {
				if(lineaflujocajaEncontrado!=null && permiteQuitar)  {
					lineaflujocajas.remove(lineaflujocajaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(LineaFlujoCaja lineaflujocaja,List<LineaFlujoCaja> lineaflujocajas) throws Exception {
		try	{			
			for(LineaFlujoCaja lineaflujocajaLocal:lineaflujocajas) {
				if(lineaflujocajaLocal.getId().equals(lineaflujocaja.getId())) {
					lineaflujocajaLocal.setIsSelected(lineaflujocaja.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesLineaFlujoCaja(List<LineaFlujoCaja> lineaflujocajasAux) throws Exception {
		//this.lineaflujocajasAux=lineaflujocajasAux;
		
		for(LineaFlujoCaja lineaflujocajaAux:lineaflujocajasAux) {
			if(lineaflujocajaAux.getIsChanged()) {
				lineaflujocajaAux.setIsChanged(false);
			}		
			
			if(lineaflujocajaAux.getIsNew()) {
				lineaflujocajaAux.setIsNew(false);
			}	
			
			if(lineaflujocajaAux.getIsDeleted()) {
				lineaflujocajaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesLineaFlujoCaja(LineaFlujoCaja lineaflujocajaAux) throws Exception {
		//this.lineaflujocajaAux=lineaflujocajaAux;
		
			if(lineaflujocajaAux.getIsChanged()) {
				lineaflujocajaAux.setIsChanged(false);
			}		
			
			if(lineaflujocajaAux.getIsNew()) {
				lineaflujocajaAux.setIsNew(false);
			}	
			
			if(lineaflujocajaAux.getIsDeleted()) {
				lineaflujocajaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(LineaFlujoCaja lineaflujocajaAsignar,LineaFlujoCaja lineaflujocaja) throws Exception {
		lineaflujocajaAsignar.setId(lineaflujocaja.getId());	
		lineaflujocajaAsignar.setVersionRow(lineaflujocaja.getVersionRow());	
		lineaflujocajaAsignar.setid_empresa(lineaflujocaja.getid_empresa());
		lineaflujocajaAsignar.setempresa_descripcion(lineaflujocaja.getempresa_descripcion());	
		lineaflujocajaAsignar.setid_tipo_grupo_flujo_caja(lineaflujocaja.getid_tipo_grupo_flujo_caja());
		lineaflujocajaAsignar.settipogrupoflujocaja_descripcion(lineaflujocaja.gettipogrupoflujocaja_descripcion());	
		lineaflujocajaAsignar.setcodigo(lineaflujocaja.getcodigo());	
		lineaflujocajaAsignar.setnombre(lineaflujocaja.getnombre());	
		lineaflujocajaAsignar.setid_tipo_linea_flujo_caja(lineaflujocaja.getid_tipo_linea_flujo_caja());
		lineaflujocajaAsignar.settipolineaflujocaja_descripcion(lineaflujocaja.gettipolineaflujocaja_descripcion());	
		lineaflujocajaAsignar.setes_consolidado(lineaflujocaja.getes_consolidado());	
		lineaflujocajaAsignar.setesta_proyeccion(lineaflujocaja.getesta_proyeccion());	
	}
	
	public static void inicializarLineaFlujoCaja(LineaFlujoCaja lineaflujocaja) throws Exception {
		try {
				lineaflujocaja.setId(0L);	
					
				lineaflujocaja.setid_empresa(-1L);	
				lineaflujocaja.setid_tipo_grupo_flujo_caja(-1L);	
				lineaflujocaja.setcodigo("");	
				lineaflujocaja.setnombre("");	
				lineaflujocaja.setid_tipo_linea_flujo_caja(-1L);	
				lineaflujocaja.setes_consolidado(false);	
				lineaflujocaja.setesta_proyeccion(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderLineaFlujoCaja(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(LineaFlujoCajaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(LineaFlujoCajaConstantesFunciones.LABEL_IDTIPOGRUPOFLUJOCAJA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(LineaFlujoCajaConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(LineaFlujoCajaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(LineaFlujoCajaConstantesFunciones.LABEL_IDTIPOLINEAFLUJOCAJA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(LineaFlujoCajaConstantesFunciones.LABEL_ESCONSOLIDADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(LineaFlujoCajaConstantesFunciones.LABEL_ESTAPROYECCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataLineaFlujoCaja(String sTipo,Row row,Workbook workbook,LineaFlujoCaja lineaflujocaja,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(lineaflujocaja.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(lineaflujocaja.gettipogrupoflujocaja_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(lineaflujocaja.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(lineaflujocaja.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(lineaflujocaja.gettipolineaflujocaja_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(lineaflujocaja.getes_consolidado()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(lineaflujocaja.getesta_proyeccion()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryLineaFlujoCaja=Constantes.SFINALQUERY;
	
	public String getsFinalQueryLineaFlujoCaja() {
		return this.sFinalQueryLineaFlujoCaja;
	}
	
	public void setsFinalQueryLineaFlujoCaja(String sFinalQueryLineaFlujoCaja) {
		this.sFinalQueryLineaFlujoCaja= sFinalQueryLineaFlujoCaja;
	}
	
	public Border resaltarSeleccionarLineaFlujoCaja=null;
	
	public Border setResaltarSeleccionarLineaFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*LineaFlujoCajaBeanSwingJInternalFrame lineaflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//lineaflujocajaBeanSwingJInternalFrame.jTtoolBarLineaFlujoCaja.setBorder(borderResaltar);
		
		this.resaltarSeleccionarLineaFlujoCaja= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarLineaFlujoCaja() {
		return this.resaltarSeleccionarLineaFlujoCaja;
	}
	
	public void setResaltarSeleccionarLineaFlujoCaja(Border borderResaltarSeleccionarLineaFlujoCaja) {
		this.resaltarSeleccionarLineaFlujoCaja= borderResaltarSeleccionarLineaFlujoCaja;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridLineaFlujoCaja=null;
	public Boolean mostraridLineaFlujoCaja=true;
	public Boolean activaridLineaFlujoCaja=true;

	public Border resaltarid_empresaLineaFlujoCaja=null;
	public Boolean mostrarid_empresaLineaFlujoCaja=true;
	public Boolean activarid_empresaLineaFlujoCaja=true;
	public Boolean cargarid_empresaLineaFlujoCaja=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaLineaFlujoCaja=false;//ConEventDepend=true

	public Border resaltarid_tipo_grupo_flujo_cajaLineaFlujoCaja=null;
	public Boolean mostrarid_tipo_grupo_flujo_cajaLineaFlujoCaja=true;
	public Boolean activarid_tipo_grupo_flujo_cajaLineaFlujoCaja=true;
	public Boolean cargarid_tipo_grupo_flujo_cajaLineaFlujoCaja=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_grupo_flujo_cajaLineaFlujoCaja=false;//ConEventDepend=true

	public Border resaltarcodigoLineaFlujoCaja=null;
	public Boolean mostrarcodigoLineaFlujoCaja=true;
	public Boolean activarcodigoLineaFlujoCaja=true;

	public Border resaltarnombreLineaFlujoCaja=null;
	public Boolean mostrarnombreLineaFlujoCaja=true;
	public Boolean activarnombreLineaFlujoCaja=true;

	public Border resaltarid_tipo_linea_flujo_cajaLineaFlujoCaja=null;
	public Boolean mostrarid_tipo_linea_flujo_cajaLineaFlujoCaja=true;
	public Boolean activarid_tipo_linea_flujo_cajaLineaFlujoCaja=true;
	public Boolean cargarid_tipo_linea_flujo_cajaLineaFlujoCaja=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_linea_flujo_cajaLineaFlujoCaja=false;//ConEventDepend=true

	public Border resaltares_consolidadoLineaFlujoCaja=null;
	public Boolean mostrares_consolidadoLineaFlujoCaja=true;
	public Boolean activares_consolidadoLineaFlujoCaja=true;

	public Border resaltaresta_proyeccionLineaFlujoCaja=null;
	public Boolean mostraresta_proyeccionLineaFlujoCaja=true;
	public Boolean activaresta_proyeccionLineaFlujoCaja=true;

	
	

	public Border setResaltaridLineaFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*LineaFlujoCajaBeanSwingJInternalFrame lineaflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//lineaflujocajaBeanSwingJInternalFrame.jTtoolBarLineaFlujoCaja.setBorder(borderResaltar);
		
		this.resaltaridLineaFlujoCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridLineaFlujoCaja() {
		return this.resaltaridLineaFlujoCaja;
	}

	public void setResaltaridLineaFlujoCaja(Border borderResaltar) {
		this.resaltaridLineaFlujoCaja= borderResaltar;
	}

	public Boolean getMostraridLineaFlujoCaja() {
		return this.mostraridLineaFlujoCaja;
	}

	public void setMostraridLineaFlujoCaja(Boolean mostraridLineaFlujoCaja) {
		this.mostraridLineaFlujoCaja= mostraridLineaFlujoCaja;
	}

	public Boolean getActivaridLineaFlujoCaja() {
		return this.activaridLineaFlujoCaja;
	}

	public void setActivaridLineaFlujoCaja(Boolean activaridLineaFlujoCaja) {
		this.activaridLineaFlujoCaja= activaridLineaFlujoCaja;
	}

	public Border setResaltarid_empresaLineaFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*LineaFlujoCajaBeanSwingJInternalFrame lineaflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//lineaflujocajaBeanSwingJInternalFrame.jTtoolBarLineaFlujoCaja.setBorder(borderResaltar);
		
		this.resaltarid_empresaLineaFlujoCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaLineaFlujoCaja() {
		return this.resaltarid_empresaLineaFlujoCaja;
	}

	public void setResaltarid_empresaLineaFlujoCaja(Border borderResaltar) {
		this.resaltarid_empresaLineaFlujoCaja= borderResaltar;
	}

	public Boolean getMostrarid_empresaLineaFlujoCaja() {
		return this.mostrarid_empresaLineaFlujoCaja;
	}

	public void setMostrarid_empresaLineaFlujoCaja(Boolean mostrarid_empresaLineaFlujoCaja) {
		this.mostrarid_empresaLineaFlujoCaja= mostrarid_empresaLineaFlujoCaja;
	}

	public Boolean getActivarid_empresaLineaFlujoCaja() {
		return this.activarid_empresaLineaFlujoCaja;
	}

	public void setActivarid_empresaLineaFlujoCaja(Boolean activarid_empresaLineaFlujoCaja) {
		this.activarid_empresaLineaFlujoCaja= activarid_empresaLineaFlujoCaja;
	}

	public Boolean getCargarid_empresaLineaFlujoCaja() {
		return this.cargarid_empresaLineaFlujoCaja;
	}

	public void setCargarid_empresaLineaFlujoCaja(Boolean cargarid_empresaLineaFlujoCaja) {
		this.cargarid_empresaLineaFlujoCaja= cargarid_empresaLineaFlujoCaja;
	}

	public Border setResaltarid_tipo_grupo_flujo_cajaLineaFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*LineaFlujoCajaBeanSwingJInternalFrame lineaflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//lineaflujocajaBeanSwingJInternalFrame.jTtoolBarLineaFlujoCaja.setBorder(borderResaltar);
		
		this.resaltarid_tipo_grupo_flujo_cajaLineaFlujoCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_grupo_flujo_cajaLineaFlujoCaja() {
		return this.resaltarid_tipo_grupo_flujo_cajaLineaFlujoCaja;
	}

	public void setResaltarid_tipo_grupo_flujo_cajaLineaFlujoCaja(Border borderResaltar) {
		this.resaltarid_tipo_grupo_flujo_cajaLineaFlujoCaja= borderResaltar;
	}

	public Boolean getMostrarid_tipo_grupo_flujo_cajaLineaFlujoCaja() {
		return this.mostrarid_tipo_grupo_flujo_cajaLineaFlujoCaja;
	}

	public void setMostrarid_tipo_grupo_flujo_cajaLineaFlujoCaja(Boolean mostrarid_tipo_grupo_flujo_cajaLineaFlujoCaja) {
		this.mostrarid_tipo_grupo_flujo_cajaLineaFlujoCaja= mostrarid_tipo_grupo_flujo_cajaLineaFlujoCaja;
	}

	public Boolean getActivarid_tipo_grupo_flujo_cajaLineaFlujoCaja() {
		return this.activarid_tipo_grupo_flujo_cajaLineaFlujoCaja;
	}

	public void setActivarid_tipo_grupo_flujo_cajaLineaFlujoCaja(Boolean activarid_tipo_grupo_flujo_cajaLineaFlujoCaja) {
		this.activarid_tipo_grupo_flujo_cajaLineaFlujoCaja= activarid_tipo_grupo_flujo_cajaLineaFlujoCaja;
	}

	public Boolean getCargarid_tipo_grupo_flujo_cajaLineaFlujoCaja() {
		return this.cargarid_tipo_grupo_flujo_cajaLineaFlujoCaja;
	}

	public void setCargarid_tipo_grupo_flujo_cajaLineaFlujoCaja(Boolean cargarid_tipo_grupo_flujo_cajaLineaFlujoCaja) {
		this.cargarid_tipo_grupo_flujo_cajaLineaFlujoCaja= cargarid_tipo_grupo_flujo_cajaLineaFlujoCaja;
	}

	public Border setResaltarcodigoLineaFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*LineaFlujoCajaBeanSwingJInternalFrame lineaflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//lineaflujocajaBeanSwingJInternalFrame.jTtoolBarLineaFlujoCaja.setBorder(borderResaltar);
		
		this.resaltarcodigoLineaFlujoCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoLineaFlujoCaja() {
		return this.resaltarcodigoLineaFlujoCaja;
	}

	public void setResaltarcodigoLineaFlujoCaja(Border borderResaltar) {
		this.resaltarcodigoLineaFlujoCaja= borderResaltar;
	}

	public Boolean getMostrarcodigoLineaFlujoCaja() {
		return this.mostrarcodigoLineaFlujoCaja;
	}

	public void setMostrarcodigoLineaFlujoCaja(Boolean mostrarcodigoLineaFlujoCaja) {
		this.mostrarcodigoLineaFlujoCaja= mostrarcodigoLineaFlujoCaja;
	}

	public Boolean getActivarcodigoLineaFlujoCaja() {
		return this.activarcodigoLineaFlujoCaja;
	}

	public void setActivarcodigoLineaFlujoCaja(Boolean activarcodigoLineaFlujoCaja) {
		this.activarcodigoLineaFlujoCaja= activarcodigoLineaFlujoCaja;
	}

	public Border setResaltarnombreLineaFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*LineaFlujoCajaBeanSwingJInternalFrame lineaflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//lineaflujocajaBeanSwingJInternalFrame.jTtoolBarLineaFlujoCaja.setBorder(borderResaltar);
		
		this.resaltarnombreLineaFlujoCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreLineaFlujoCaja() {
		return this.resaltarnombreLineaFlujoCaja;
	}

	public void setResaltarnombreLineaFlujoCaja(Border borderResaltar) {
		this.resaltarnombreLineaFlujoCaja= borderResaltar;
	}

	public Boolean getMostrarnombreLineaFlujoCaja() {
		return this.mostrarnombreLineaFlujoCaja;
	}

	public void setMostrarnombreLineaFlujoCaja(Boolean mostrarnombreLineaFlujoCaja) {
		this.mostrarnombreLineaFlujoCaja= mostrarnombreLineaFlujoCaja;
	}

	public Boolean getActivarnombreLineaFlujoCaja() {
		return this.activarnombreLineaFlujoCaja;
	}

	public void setActivarnombreLineaFlujoCaja(Boolean activarnombreLineaFlujoCaja) {
		this.activarnombreLineaFlujoCaja= activarnombreLineaFlujoCaja;
	}

	public Border setResaltarid_tipo_linea_flujo_cajaLineaFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*LineaFlujoCajaBeanSwingJInternalFrame lineaflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//lineaflujocajaBeanSwingJInternalFrame.jTtoolBarLineaFlujoCaja.setBorder(borderResaltar);
		
		this.resaltarid_tipo_linea_flujo_cajaLineaFlujoCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_linea_flujo_cajaLineaFlujoCaja() {
		return this.resaltarid_tipo_linea_flujo_cajaLineaFlujoCaja;
	}

	public void setResaltarid_tipo_linea_flujo_cajaLineaFlujoCaja(Border borderResaltar) {
		this.resaltarid_tipo_linea_flujo_cajaLineaFlujoCaja= borderResaltar;
	}

	public Boolean getMostrarid_tipo_linea_flujo_cajaLineaFlujoCaja() {
		return this.mostrarid_tipo_linea_flujo_cajaLineaFlujoCaja;
	}

	public void setMostrarid_tipo_linea_flujo_cajaLineaFlujoCaja(Boolean mostrarid_tipo_linea_flujo_cajaLineaFlujoCaja) {
		this.mostrarid_tipo_linea_flujo_cajaLineaFlujoCaja= mostrarid_tipo_linea_flujo_cajaLineaFlujoCaja;
	}

	public Boolean getActivarid_tipo_linea_flujo_cajaLineaFlujoCaja() {
		return this.activarid_tipo_linea_flujo_cajaLineaFlujoCaja;
	}

	public void setActivarid_tipo_linea_flujo_cajaLineaFlujoCaja(Boolean activarid_tipo_linea_flujo_cajaLineaFlujoCaja) {
		this.activarid_tipo_linea_flujo_cajaLineaFlujoCaja= activarid_tipo_linea_flujo_cajaLineaFlujoCaja;
	}

	public Boolean getCargarid_tipo_linea_flujo_cajaLineaFlujoCaja() {
		return this.cargarid_tipo_linea_flujo_cajaLineaFlujoCaja;
	}

	public void setCargarid_tipo_linea_flujo_cajaLineaFlujoCaja(Boolean cargarid_tipo_linea_flujo_cajaLineaFlujoCaja) {
		this.cargarid_tipo_linea_flujo_cajaLineaFlujoCaja= cargarid_tipo_linea_flujo_cajaLineaFlujoCaja;
	}

	public Border setResaltares_consolidadoLineaFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*LineaFlujoCajaBeanSwingJInternalFrame lineaflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//lineaflujocajaBeanSwingJInternalFrame.jTtoolBarLineaFlujoCaja.setBorder(borderResaltar);
		
		this.resaltares_consolidadoLineaFlujoCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_consolidadoLineaFlujoCaja() {
		return this.resaltares_consolidadoLineaFlujoCaja;
	}

	public void setResaltares_consolidadoLineaFlujoCaja(Border borderResaltar) {
		this.resaltares_consolidadoLineaFlujoCaja= borderResaltar;
	}

	public Boolean getMostrares_consolidadoLineaFlujoCaja() {
		return this.mostrares_consolidadoLineaFlujoCaja;
	}

	public void setMostrares_consolidadoLineaFlujoCaja(Boolean mostrares_consolidadoLineaFlujoCaja) {
		this.mostrares_consolidadoLineaFlujoCaja= mostrares_consolidadoLineaFlujoCaja;
	}

	public Boolean getActivares_consolidadoLineaFlujoCaja() {
		return this.activares_consolidadoLineaFlujoCaja;
	}

	public void setActivares_consolidadoLineaFlujoCaja(Boolean activares_consolidadoLineaFlujoCaja) {
		this.activares_consolidadoLineaFlujoCaja= activares_consolidadoLineaFlujoCaja;
	}

	public Border setResaltaresta_proyeccionLineaFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*LineaFlujoCajaBeanSwingJInternalFrame lineaflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//lineaflujocajaBeanSwingJInternalFrame.jTtoolBarLineaFlujoCaja.setBorder(borderResaltar);
		
		this.resaltaresta_proyeccionLineaFlujoCaja= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaresta_proyeccionLineaFlujoCaja() {
		return this.resaltaresta_proyeccionLineaFlujoCaja;
	}

	public void setResaltaresta_proyeccionLineaFlujoCaja(Border borderResaltar) {
		this.resaltaresta_proyeccionLineaFlujoCaja= borderResaltar;
	}

	public Boolean getMostraresta_proyeccionLineaFlujoCaja() {
		return this.mostraresta_proyeccionLineaFlujoCaja;
	}

	public void setMostraresta_proyeccionLineaFlujoCaja(Boolean mostraresta_proyeccionLineaFlujoCaja) {
		this.mostraresta_proyeccionLineaFlujoCaja= mostraresta_proyeccionLineaFlujoCaja;
	}

	public Boolean getActivaresta_proyeccionLineaFlujoCaja() {
		return this.activaresta_proyeccionLineaFlujoCaja;
	}

	public void setActivaresta_proyeccionLineaFlujoCaja(Boolean activaresta_proyeccionLineaFlujoCaja) {
		this.activaresta_proyeccionLineaFlujoCaja= activaresta_proyeccionLineaFlujoCaja;
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
		
		
		this.setMostraridLineaFlujoCaja(esInicial);
		this.setMostrarid_empresaLineaFlujoCaja(esInicial);
		this.setMostrarid_tipo_grupo_flujo_cajaLineaFlujoCaja(esInicial);
		this.setMostrarcodigoLineaFlujoCaja(esInicial);
		this.setMostrarnombreLineaFlujoCaja(esInicial);
		this.setMostrarid_tipo_linea_flujo_cajaLineaFlujoCaja(esInicial);
		this.setMostrares_consolidadoLineaFlujoCaja(esInicial);
		this.setMostraresta_proyeccionLineaFlujoCaja(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(LineaFlujoCajaConstantesFunciones.ID)) {
				this.setMostraridLineaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaFlujoCajaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaLineaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaFlujoCajaConstantesFunciones.IDTIPOGRUPOFLUJOCAJA)) {
				this.setMostrarid_tipo_grupo_flujo_cajaLineaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaFlujoCajaConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoLineaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaFlujoCajaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreLineaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaFlujoCajaConstantesFunciones.IDTIPOLINEAFLUJOCAJA)) {
				this.setMostrarid_tipo_linea_flujo_cajaLineaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaFlujoCajaConstantesFunciones.ESCONSOLIDADO)) {
				this.setMostrares_consolidadoLineaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaFlujoCajaConstantesFunciones.ESTAPROYECCION)) {
				this.setMostraresta_proyeccionLineaFlujoCaja(esAsigna);
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
		
		
		this.setActivaridLineaFlujoCaja(esInicial);
		this.setActivarid_empresaLineaFlujoCaja(esInicial);
		this.setActivarid_tipo_grupo_flujo_cajaLineaFlujoCaja(esInicial);
		this.setActivarcodigoLineaFlujoCaja(esInicial);
		this.setActivarnombreLineaFlujoCaja(esInicial);
		this.setActivarid_tipo_linea_flujo_cajaLineaFlujoCaja(esInicial);
		this.setActivares_consolidadoLineaFlujoCaja(esInicial);
		this.setActivaresta_proyeccionLineaFlujoCaja(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(LineaFlujoCajaConstantesFunciones.ID)) {
				this.setActivaridLineaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaFlujoCajaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaLineaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaFlujoCajaConstantesFunciones.IDTIPOGRUPOFLUJOCAJA)) {
				this.setActivarid_tipo_grupo_flujo_cajaLineaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaFlujoCajaConstantesFunciones.CODIGO)) {
				this.setActivarcodigoLineaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaFlujoCajaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreLineaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaFlujoCajaConstantesFunciones.IDTIPOLINEAFLUJOCAJA)) {
				this.setActivarid_tipo_linea_flujo_cajaLineaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaFlujoCajaConstantesFunciones.ESCONSOLIDADO)) {
				this.setActivares_consolidadoLineaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaFlujoCajaConstantesFunciones.ESTAPROYECCION)) {
				this.setActivaresta_proyeccionLineaFlujoCaja(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,LineaFlujoCajaBeanSwingJInternalFrame lineaflujocajaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridLineaFlujoCaja(esInicial);
		this.setResaltarid_empresaLineaFlujoCaja(esInicial);
		this.setResaltarid_tipo_grupo_flujo_cajaLineaFlujoCaja(esInicial);
		this.setResaltarcodigoLineaFlujoCaja(esInicial);
		this.setResaltarnombreLineaFlujoCaja(esInicial);
		this.setResaltarid_tipo_linea_flujo_cajaLineaFlujoCaja(esInicial);
		this.setResaltares_consolidadoLineaFlujoCaja(esInicial);
		this.setResaltaresta_proyeccionLineaFlujoCaja(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(LineaFlujoCajaConstantesFunciones.ID)) {
				this.setResaltaridLineaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaFlujoCajaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaLineaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaFlujoCajaConstantesFunciones.IDTIPOGRUPOFLUJOCAJA)) {
				this.setResaltarid_tipo_grupo_flujo_cajaLineaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaFlujoCajaConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoLineaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaFlujoCajaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreLineaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaFlujoCajaConstantesFunciones.IDTIPOLINEAFLUJOCAJA)) {
				this.setResaltarid_tipo_linea_flujo_cajaLineaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaFlujoCajaConstantesFunciones.ESCONSOLIDADO)) {
				this.setResaltares_consolidadoLineaFlujoCaja(esAsigna);
				continue;
			}

			if(campo.clase.equals(LineaFlujoCajaConstantesFunciones.ESTAPROYECCION)) {
				this.setResaltaresta_proyeccionLineaFlujoCaja(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,LineaFlujoCajaBeanSwingJInternalFrame lineaflujocajaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorCodigoLineaFlujoCaja=true;

	public Boolean getMostrarBusquedaPorCodigoLineaFlujoCaja() {
		return this.mostrarBusquedaPorCodigoLineaFlujoCaja;
	}

	public void setMostrarBusquedaPorCodigoLineaFlujoCaja(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoLineaFlujoCaja= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreLineaFlujoCaja=true;

	public Boolean getMostrarBusquedaPorNombreLineaFlujoCaja() {
		return this.mostrarBusquedaPorNombreLineaFlujoCaja;
	}

	public void setMostrarBusquedaPorNombreLineaFlujoCaja(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreLineaFlujoCaja= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaLineaFlujoCaja=true;

	public Boolean getMostrarFK_IdEmpresaLineaFlujoCaja() {
		return this.mostrarFK_IdEmpresaLineaFlujoCaja;
	}

	public void setMostrarFK_IdEmpresaLineaFlujoCaja(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaLineaFlujoCaja= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoGrupoFlujoCajaLineaFlujoCaja=true;

	public Boolean getMostrarFK_IdTipoGrupoFlujoCajaLineaFlujoCaja() {
		return this.mostrarFK_IdTipoGrupoFlujoCajaLineaFlujoCaja;
	}

	public void setMostrarFK_IdTipoGrupoFlujoCajaLineaFlujoCaja(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoGrupoFlujoCajaLineaFlujoCaja= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoLineaFlujoCajaLineaFlujoCaja=true;

	public Boolean getMostrarFK_IdTipoLineaFlujoCajaLineaFlujoCaja() {
		return this.mostrarFK_IdTipoLineaFlujoCajaLineaFlujoCaja;
	}

	public void setMostrarFK_IdTipoLineaFlujoCajaLineaFlujoCaja(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoLineaFlujoCajaLineaFlujoCaja= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoLineaFlujoCaja=true;

	public Boolean getActivarBusquedaPorCodigoLineaFlujoCaja() {
		return this.activarBusquedaPorCodigoLineaFlujoCaja;
	}

	public void setActivarBusquedaPorCodigoLineaFlujoCaja(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoLineaFlujoCaja= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreLineaFlujoCaja=true;

	public Boolean getActivarBusquedaPorNombreLineaFlujoCaja() {
		return this.activarBusquedaPorNombreLineaFlujoCaja;
	}

	public void setActivarBusquedaPorNombreLineaFlujoCaja(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreLineaFlujoCaja= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaLineaFlujoCaja=true;

	public Boolean getActivarFK_IdEmpresaLineaFlujoCaja() {
		return this.activarFK_IdEmpresaLineaFlujoCaja;
	}

	public void setActivarFK_IdEmpresaLineaFlujoCaja(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaLineaFlujoCaja= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoGrupoFlujoCajaLineaFlujoCaja=true;

	public Boolean getActivarFK_IdTipoGrupoFlujoCajaLineaFlujoCaja() {
		return this.activarFK_IdTipoGrupoFlujoCajaLineaFlujoCaja;
	}

	public void setActivarFK_IdTipoGrupoFlujoCajaLineaFlujoCaja(Boolean habilitarResaltar) {
		this.activarFK_IdTipoGrupoFlujoCajaLineaFlujoCaja= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoLineaFlujoCajaLineaFlujoCaja=true;

	public Boolean getActivarFK_IdTipoLineaFlujoCajaLineaFlujoCaja() {
		return this.activarFK_IdTipoLineaFlujoCajaLineaFlujoCaja;
	}

	public void setActivarFK_IdTipoLineaFlujoCajaLineaFlujoCaja(Boolean habilitarResaltar) {
		this.activarFK_IdTipoLineaFlujoCajaLineaFlujoCaja= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoLineaFlujoCaja=null;

	public Border getResaltarBusquedaPorCodigoLineaFlujoCaja() {
		return this.resaltarBusquedaPorCodigoLineaFlujoCaja;
	}

	public void setResaltarBusquedaPorCodigoLineaFlujoCaja(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoLineaFlujoCaja= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoLineaFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*LineaFlujoCajaBeanSwingJInternalFrame lineaflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoLineaFlujoCaja= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreLineaFlujoCaja=null;

	public Border getResaltarBusquedaPorNombreLineaFlujoCaja() {
		return this.resaltarBusquedaPorNombreLineaFlujoCaja;
	}

	public void setResaltarBusquedaPorNombreLineaFlujoCaja(Border borderResaltar) {
		this.resaltarBusquedaPorNombreLineaFlujoCaja= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreLineaFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*LineaFlujoCajaBeanSwingJInternalFrame lineaflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreLineaFlujoCaja= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaLineaFlujoCaja=null;

	public Border getResaltarFK_IdEmpresaLineaFlujoCaja() {
		return this.resaltarFK_IdEmpresaLineaFlujoCaja;
	}

	public void setResaltarFK_IdEmpresaLineaFlujoCaja(Border borderResaltar) {
		this.resaltarFK_IdEmpresaLineaFlujoCaja= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaLineaFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*LineaFlujoCajaBeanSwingJInternalFrame lineaflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaLineaFlujoCaja= borderResaltar;
	}

	public Border resaltarFK_IdTipoGrupoFlujoCajaLineaFlujoCaja=null;

	public Border getResaltarFK_IdTipoGrupoFlujoCajaLineaFlujoCaja() {
		return this.resaltarFK_IdTipoGrupoFlujoCajaLineaFlujoCaja;
	}

	public void setResaltarFK_IdTipoGrupoFlujoCajaLineaFlujoCaja(Border borderResaltar) {
		this.resaltarFK_IdTipoGrupoFlujoCajaLineaFlujoCaja= borderResaltar;
	}

	public void setResaltarFK_IdTipoGrupoFlujoCajaLineaFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*LineaFlujoCajaBeanSwingJInternalFrame lineaflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoGrupoFlujoCajaLineaFlujoCaja= borderResaltar;
	}

	public Border resaltarFK_IdTipoLineaFlujoCajaLineaFlujoCaja=null;

	public Border getResaltarFK_IdTipoLineaFlujoCajaLineaFlujoCaja() {
		return this.resaltarFK_IdTipoLineaFlujoCajaLineaFlujoCaja;
	}

	public void setResaltarFK_IdTipoLineaFlujoCajaLineaFlujoCaja(Border borderResaltar) {
		this.resaltarFK_IdTipoLineaFlujoCajaLineaFlujoCaja= borderResaltar;
	}

	public void setResaltarFK_IdTipoLineaFlujoCajaLineaFlujoCaja(ParametroGeneralUsuario parametroGeneralUsuario/*LineaFlujoCajaBeanSwingJInternalFrame lineaflujocajaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoLineaFlujoCajaLineaFlujoCaja= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}