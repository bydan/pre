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


import com.bydan.erp.contabilidad.util.PresuTipoCuentaProyectoConstantesFunciones;
import com.bydan.erp.contabilidad.util.PresuTipoCuentaProyectoParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.PresuTipoCuentaProyectoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class PresuTipoCuentaProyectoConstantesFunciones extends PresuTipoCuentaProyectoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="PresuTipoCuentaProyecto";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="PresuTipoCuentaProyecto"+PresuTipoCuentaProyectoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="PresuTipoCuentaProyectoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="PresuTipoCuentaProyectoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=PresuTipoCuentaProyectoConstantesFunciones.SCHEMA+"_"+PresuTipoCuentaProyectoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/PresuTipoCuentaProyectoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=PresuTipoCuentaProyectoConstantesFunciones.SCHEMA+"_"+PresuTipoCuentaProyectoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=PresuTipoCuentaProyectoConstantesFunciones.SCHEMA+"_"+PresuTipoCuentaProyectoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/PresuTipoCuentaProyectoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=PresuTipoCuentaProyectoConstantesFunciones.SCHEMA+"_"+PresuTipoCuentaProyectoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PresuTipoCuentaProyectoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PresuTipoCuentaProyectoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PresuTipoCuentaProyectoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PresuTipoCuentaProyectoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PresuTipoCuentaProyectoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PresuTipoCuentaProyectoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=PresuTipoCuentaProyectoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+PresuTipoCuentaProyectoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=PresuTipoCuentaProyectoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+PresuTipoCuentaProyectoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Cuenta Proyectos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Cuenta Proyecto";
	public static final String SCLASSWEBTITULO_LOWER="Presu Tipo Cuenta Proyecto";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="PresuTipoCuentaProyecto";
	public static final String OBJECTNAME="presutipocuentaproyecto";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="presu_tipo_cuenta_proyecto";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select presutipocuentaproyecto from "+PresuTipoCuentaProyectoConstantesFunciones.SPERSISTENCENAME+" presutipocuentaproyecto";
	public static String QUERYSELECTNATIVE="select "+PresuTipoCuentaProyectoConstantesFunciones.SCHEMA+"."+PresuTipoCuentaProyectoConstantesFunciones.TABLENAME+".id,"+PresuTipoCuentaProyectoConstantesFunciones.SCHEMA+"."+PresuTipoCuentaProyectoConstantesFunciones.TABLENAME+".version_row,"+PresuTipoCuentaProyectoConstantesFunciones.SCHEMA+"."+PresuTipoCuentaProyectoConstantesFunciones.TABLENAME+".id_empresa,"+PresuTipoCuentaProyectoConstantesFunciones.SCHEMA+"."+PresuTipoCuentaProyectoConstantesFunciones.TABLENAME+".codigo,"+PresuTipoCuentaProyectoConstantesFunciones.SCHEMA+"."+PresuTipoCuentaProyectoConstantesFunciones.TABLENAME+".nombre from "+PresuTipoCuentaProyectoConstantesFunciones.SCHEMA+"."+PresuTipoCuentaProyectoConstantesFunciones.TABLENAME;//+" as "+PresuTipoCuentaProyectoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected PresuTipoCuentaProyectoConstantesFuncionesAdditional presutipocuentaproyectoConstantesFuncionesAdditional=null;
	
	public PresuTipoCuentaProyectoConstantesFuncionesAdditional getPresuTipoCuentaProyectoConstantesFuncionesAdditional() {
		return this.presutipocuentaproyectoConstantesFuncionesAdditional;
	}
	
	public void setPresuTipoCuentaProyectoConstantesFuncionesAdditional(PresuTipoCuentaProyectoConstantesFuncionesAdditional presutipocuentaproyectoConstantesFuncionesAdditional) {
		try {
			this.presutipocuentaproyectoConstantesFuncionesAdditional=presutipocuentaproyectoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getPresuTipoCuentaProyectoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(PresuTipoCuentaProyectoConstantesFunciones.IDEMPRESA)) {sLabelColumna=PresuTipoCuentaProyectoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(PresuTipoCuentaProyectoConstantesFunciones.CODIGO)) {sLabelColumna=PresuTipoCuentaProyectoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(PresuTipoCuentaProyectoConstantesFunciones.NOMBRE)) {sLabelColumna=PresuTipoCuentaProyectoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getPresuTipoCuentaProyectoDescripcion(PresuTipoCuentaProyecto presutipocuentaproyecto) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(presutipocuentaproyecto !=null/* && presutipocuentaproyecto.getId()!=0*/) {
			sDescripcion=presutipocuentaproyecto.getcodigo();//presutipocuentaproyectopresutipocuentaproyecto.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getPresuTipoCuentaProyectoDescripcionDetallado(PresuTipoCuentaProyecto presutipocuentaproyecto) {
		String sDescripcion="";
			
		sDescripcion+=PresuTipoCuentaProyectoConstantesFunciones.ID+"=";
		sDescripcion+=presutipocuentaproyecto.getId().toString()+",";
		sDescripcion+=PresuTipoCuentaProyectoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=presutipocuentaproyecto.getVersionRow().toString()+",";
		sDescripcion+=PresuTipoCuentaProyectoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=presutipocuentaproyecto.getid_empresa().toString()+",";
		sDescripcion+=PresuTipoCuentaProyectoConstantesFunciones.CODIGO+"=";
		sDescripcion+=presutipocuentaproyecto.getcodigo()+",";
		sDescripcion+=PresuTipoCuentaProyectoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=presutipocuentaproyecto.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setPresuTipoCuentaProyectoDescripcion(PresuTipoCuentaProyecto presutipocuentaproyecto,String sValor) throws Exception {			
		if(presutipocuentaproyecto !=null) {
			presutipocuentaproyecto.setcodigo(sValor);;//presutipocuentaproyectopresutipocuentaproyecto.getcodigo().trim();
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
		} else if(sNombreIndice.equals("BusquedaPorCodigo")) {
			sNombreIndice="Tipo=  Por Codigo";
		} else if(sNombreIndice.equals("BusquedaPorNombre")) {
			sNombreIndice="Tipo=  Por Nombre";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
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
	
	
	
	
	
	
	public static void quitarEspaciosPresuTipoCuentaProyecto(PresuTipoCuentaProyecto presutipocuentaproyecto,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		presutipocuentaproyecto.setcodigo(presutipocuentaproyecto.getcodigo().trim());
		presutipocuentaproyecto.setnombre(presutipocuentaproyecto.getnombre().trim());
	}
	
	public static void quitarEspaciosPresuTipoCuentaProyectos(List<PresuTipoCuentaProyecto> presutipocuentaproyectos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PresuTipoCuentaProyecto presutipocuentaproyecto: presutipocuentaproyectos) {
			presutipocuentaproyecto.setcodigo(presutipocuentaproyecto.getcodigo().trim());
			presutipocuentaproyecto.setnombre(presutipocuentaproyecto.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPresuTipoCuentaProyecto(PresuTipoCuentaProyecto presutipocuentaproyecto,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && presutipocuentaproyecto.getConCambioAuxiliar()) {
			presutipocuentaproyecto.setIsDeleted(presutipocuentaproyecto.getIsDeletedAuxiliar());	
			presutipocuentaproyecto.setIsNew(presutipocuentaproyecto.getIsNewAuxiliar());	
			presutipocuentaproyecto.setIsChanged(presutipocuentaproyecto.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			presutipocuentaproyecto.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			presutipocuentaproyecto.setIsDeletedAuxiliar(false);	
			presutipocuentaproyecto.setIsNewAuxiliar(false);	
			presutipocuentaproyecto.setIsChangedAuxiliar(false);
			
			presutipocuentaproyecto.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPresuTipoCuentaProyectos(List<PresuTipoCuentaProyecto> presutipocuentaproyectos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(PresuTipoCuentaProyecto presutipocuentaproyecto : presutipocuentaproyectos) {
			if(conAsignarBase && presutipocuentaproyecto.getConCambioAuxiliar()) {
				presutipocuentaproyecto.setIsDeleted(presutipocuentaproyecto.getIsDeletedAuxiliar());	
				presutipocuentaproyecto.setIsNew(presutipocuentaproyecto.getIsNewAuxiliar());	
				presutipocuentaproyecto.setIsChanged(presutipocuentaproyecto.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				presutipocuentaproyecto.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				presutipocuentaproyecto.setIsDeletedAuxiliar(false);	
				presutipocuentaproyecto.setIsNewAuxiliar(false);	
				presutipocuentaproyecto.setIsChangedAuxiliar(false);
				
				presutipocuentaproyecto.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresPresuTipoCuentaProyecto(PresuTipoCuentaProyecto presutipocuentaproyecto,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresPresuTipoCuentaProyectos(List<PresuTipoCuentaProyecto> presutipocuentaproyectos,Boolean conEnteros) throws Exception  {
		
		for(PresuTipoCuentaProyecto presutipocuentaproyecto: presutipocuentaproyectos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaPresuTipoCuentaProyecto(List<PresuTipoCuentaProyecto> presutipocuentaproyectos,PresuTipoCuentaProyecto presutipocuentaproyectoAux) throws Exception  {
		PresuTipoCuentaProyectoConstantesFunciones.InicializarValoresPresuTipoCuentaProyecto(presutipocuentaproyectoAux,true);
		
		for(PresuTipoCuentaProyecto presutipocuentaproyecto: presutipocuentaproyectos) {
			if(presutipocuentaproyecto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPresuTipoCuentaProyecto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=PresuTipoCuentaProyectoConstantesFunciones.getArrayColumnasGlobalesPresuTipoCuentaProyecto(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesPresuTipoCuentaProyecto(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PresuTipoCuentaProyectoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PresuTipoCuentaProyectoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoPresuTipoCuentaProyecto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PresuTipoCuentaProyecto> presutipocuentaproyectos,PresuTipoCuentaProyecto presutipocuentaproyecto,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PresuTipoCuentaProyecto presutipocuentaproyectoAux: presutipocuentaproyectos) {
			if(presutipocuentaproyectoAux!=null && presutipocuentaproyecto!=null) {
				if((presutipocuentaproyectoAux.getId()==null && presutipocuentaproyecto.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(presutipocuentaproyectoAux.getId()!=null && presutipocuentaproyecto.getId()!=null){
					if(presutipocuentaproyectoAux.getId().equals(presutipocuentaproyecto.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPresuTipoCuentaProyecto(List<PresuTipoCuentaProyecto> presutipocuentaproyectos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(PresuTipoCuentaProyecto presutipocuentaproyecto: presutipocuentaproyectos) {			
			if(presutipocuentaproyecto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaPresuTipoCuentaProyecto() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,PresuTipoCuentaProyectoConstantesFunciones.LABEL_ID, PresuTipoCuentaProyectoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresuTipoCuentaProyectoConstantesFunciones.LABEL_VERSIONROW, PresuTipoCuentaProyectoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresuTipoCuentaProyectoConstantesFunciones.LABEL_IDEMPRESA, PresuTipoCuentaProyectoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresuTipoCuentaProyectoConstantesFunciones.LABEL_CODIGO, PresuTipoCuentaProyectoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresuTipoCuentaProyectoConstantesFunciones.LABEL_NOMBRE, PresuTipoCuentaProyectoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasPresuTipoCuentaProyecto() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=PresuTipoCuentaProyectoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresuTipoCuentaProyectoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresuTipoCuentaProyectoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresuTipoCuentaProyectoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresuTipoCuentaProyectoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPresuTipoCuentaProyecto() throws Exception  {
		return PresuTipoCuentaProyectoConstantesFunciones.getTiposSeleccionarPresuTipoCuentaProyecto(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPresuTipoCuentaProyecto(Boolean conFk) throws Exception  {
		return PresuTipoCuentaProyectoConstantesFunciones.getTiposSeleccionarPresuTipoCuentaProyecto(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPresuTipoCuentaProyecto(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresuTipoCuentaProyectoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(PresuTipoCuentaProyectoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresuTipoCuentaProyectoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(PresuTipoCuentaProyectoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresuTipoCuentaProyectoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(PresuTipoCuentaProyectoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesPresuTipoCuentaProyecto(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesPresuTipoCuentaProyecto(PresuTipoCuentaProyecto presutipocuentaproyectoAux) throws Exception {
		
			presutipocuentaproyectoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(presutipocuentaproyectoAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesPresuTipoCuentaProyecto(List<PresuTipoCuentaProyecto> presutipocuentaproyectosTemp) throws Exception {
		for(PresuTipoCuentaProyecto presutipocuentaproyectoAux:presutipocuentaproyectosTemp) {
			
			presutipocuentaproyectoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(presutipocuentaproyectoAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfPresuTipoCuentaProyecto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfPresuTipoCuentaProyecto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfPresuTipoCuentaProyecto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return PresuTipoCuentaProyectoConstantesFunciones.getClassesRelationshipsOfPresuTipoCuentaProyecto(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPresuTipoCuentaProyecto(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(PresuProyectoCuenta.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(PresuProyectoCuenta.class)) {
						classes.add(new Classe(PresuProyectoCuenta.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPresuTipoCuentaProyecto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return PresuTipoCuentaProyectoConstantesFunciones.getClassesRelationshipsFromStringsOfPresuTipoCuentaProyecto(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPresuTipoCuentaProyecto(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(PresuProyectoCuenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PresuProyectoCuenta.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(PresuProyectoCuenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PresuProyectoCuenta.class)); continue;
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
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(PresuTipoCuentaProyecto presutipocuentaproyecto,List<PresuTipoCuentaProyecto> presutipocuentaproyectos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			PresuTipoCuentaProyecto presutipocuentaproyectoEncontrado=null;
			
			for(PresuTipoCuentaProyecto presutipocuentaproyectoLocal:presutipocuentaproyectos) {
				if(presutipocuentaproyectoLocal.getId().equals(presutipocuentaproyecto.getId())) {
					presutipocuentaproyectoEncontrado=presutipocuentaproyectoLocal;
					
					presutipocuentaproyectoLocal.setIsChanged(presutipocuentaproyecto.getIsChanged());
					presutipocuentaproyectoLocal.setIsNew(presutipocuentaproyecto.getIsNew());
					presutipocuentaproyectoLocal.setIsDeleted(presutipocuentaproyecto.getIsDeleted());
					
					presutipocuentaproyectoLocal.setGeneralEntityOriginal(presutipocuentaproyecto.getGeneralEntityOriginal());
					
					presutipocuentaproyectoLocal.setId(presutipocuentaproyecto.getId());	
					presutipocuentaproyectoLocal.setVersionRow(presutipocuentaproyecto.getVersionRow());	
					presutipocuentaproyectoLocal.setid_empresa(presutipocuentaproyecto.getid_empresa());	
					presutipocuentaproyectoLocal.setcodigo(presutipocuentaproyecto.getcodigo());	
					presutipocuentaproyectoLocal.setnombre(presutipocuentaproyecto.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!presutipocuentaproyecto.getIsDeleted()) {
				if(!existe) {
					presutipocuentaproyectos.add(presutipocuentaproyecto);
				}
			} else {
				if(presutipocuentaproyectoEncontrado!=null && permiteQuitar)  {
					presutipocuentaproyectos.remove(presutipocuentaproyectoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(PresuTipoCuentaProyecto presutipocuentaproyecto,List<PresuTipoCuentaProyecto> presutipocuentaproyectos) throws Exception {
		try	{			
			for(PresuTipoCuentaProyecto presutipocuentaproyectoLocal:presutipocuentaproyectos) {
				if(presutipocuentaproyectoLocal.getId().equals(presutipocuentaproyecto.getId())) {
					presutipocuentaproyectoLocal.setIsSelected(presutipocuentaproyecto.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesPresuTipoCuentaProyecto(List<PresuTipoCuentaProyecto> presutipocuentaproyectosAux) throws Exception {
		//this.presutipocuentaproyectosAux=presutipocuentaproyectosAux;
		
		for(PresuTipoCuentaProyecto presutipocuentaproyectoAux:presutipocuentaproyectosAux) {
			if(presutipocuentaproyectoAux.getIsChanged()) {
				presutipocuentaproyectoAux.setIsChanged(false);
			}		
			
			if(presutipocuentaproyectoAux.getIsNew()) {
				presutipocuentaproyectoAux.setIsNew(false);
			}	
			
			if(presutipocuentaproyectoAux.getIsDeleted()) {
				presutipocuentaproyectoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesPresuTipoCuentaProyecto(PresuTipoCuentaProyecto presutipocuentaproyectoAux) throws Exception {
		//this.presutipocuentaproyectoAux=presutipocuentaproyectoAux;
		
			if(presutipocuentaproyectoAux.getIsChanged()) {
				presutipocuentaproyectoAux.setIsChanged(false);
			}		
			
			if(presutipocuentaproyectoAux.getIsNew()) {
				presutipocuentaproyectoAux.setIsNew(false);
			}	
			
			if(presutipocuentaproyectoAux.getIsDeleted()) {
				presutipocuentaproyectoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(PresuTipoCuentaProyecto presutipocuentaproyectoAsignar,PresuTipoCuentaProyecto presutipocuentaproyecto) throws Exception {
		presutipocuentaproyectoAsignar.setId(presutipocuentaproyecto.getId());	
		presutipocuentaproyectoAsignar.setVersionRow(presutipocuentaproyecto.getVersionRow());	
		presutipocuentaproyectoAsignar.setid_empresa(presutipocuentaproyecto.getid_empresa());
		presutipocuentaproyectoAsignar.setempresa_descripcion(presutipocuentaproyecto.getempresa_descripcion());	
		presutipocuentaproyectoAsignar.setcodigo(presutipocuentaproyecto.getcodigo());	
		presutipocuentaproyectoAsignar.setnombre(presutipocuentaproyecto.getnombre());	
	}
	
	public static void inicializarPresuTipoCuentaProyecto(PresuTipoCuentaProyecto presutipocuentaproyecto) throws Exception {
		try {
				presutipocuentaproyecto.setId(0L);	
					
				presutipocuentaproyecto.setid_empresa(-1L);	
				presutipocuentaproyecto.setcodigo("");	
				presutipocuentaproyecto.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderPresuTipoCuentaProyecto(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(PresuTipoCuentaProyectoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresuTipoCuentaProyectoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresuTipoCuentaProyectoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataPresuTipoCuentaProyecto(String sTipo,Row row,Workbook workbook,PresuTipoCuentaProyecto presutipocuentaproyecto,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(presutipocuentaproyecto.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presutipocuentaproyecto.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presutipocuentaproyecto.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryPresuTipoCuentaProyecto=Constantes.SFINALQUERY;
	
	public String getsFinalQueryPresuTipoCuentaProyecto() {
		return this.sFinalQueryPresuTipoCuentaProyecto;
	}
	
	public void setsFinalQueryPresuTipoCuentaProyecto(String sFinalQueryPresuTipoCuentaProyecto) {
		this.sFinalQueryPresuTipoCuentaProyecto= sFinalQueryPresuTipoCuentaProyecto;
	}
	
	public Border resaltarSeleccionarPresuTipoCuentaProyecto=null;
	
	public Border setResaltarSeleccionarPresuTipoCuentaProyecto(ParametroGeneralUsuario parametroGeneralUsuario/*PresuTipoCuentaProyectoBeanSwingJInternalFrame presutipocuentaproyectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//presutipocuentaproyectoBeanSwingJInternalFrame.jTtoolBarPresuTipoCuentaProyecto.setBorder(borderResaltar);
		
		this.resaltarSeleccionarPresuTipoCuentaProyecto= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarPresuTipoCuentaProyecto() {
		return this.resaltarSeleccionarPresuTipoCuentaProyecto;
	}
	
	public void setResaltarSeleccionarPresuTipoCuentaProyecto(Border borderResaltarSeleccionarPresuTipoCuentaProyecto) {
		this.resaltarSeleccionarPresuTipoCuentaProyecto= borderResaltarSeleccionarPresuTipoCuentaProyecto;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridPresuTipoCuentaProyecto=null;
	public Boolean mostraridPresuTipoCuentaProyecto=true;
	public Boolean activaridPresuTipoCuentaProyecto=true;

	public Border resaltarid_empresaPresuTipoCuentaProyecto=null;
	public Boolean mostrarid_empresaPresuTipoCuentaProyecto=true;
	public Boolean activarid_empresaPresuTipoCuentaProyecto=true;
	public Boolean cargarid_empresaPresuTipoCuentaProyecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaPresuTipoCuentaProyecto=false;//ConEventDepend=true

	public Border resaltarcodigoPresuTipoCuentaProyecto=null;
	public Boolean mostrarcodigoPresuTipoCuentaProyecto=true;
	public Boolean activarcodigoPresuTipoCuentaProyecto=true;

	public Border resaltarnombrePresuTipoCuentaProyecto=null;
	public Boolean mostrarnombrePresuTipoCuentaProyecto=true;
	public Boolean activarnombrePresuTipoCuentaProyecto=true;

	
	

	public Border setResaltaridPresuTipoCuentaProyecto(ParametroGeneralUsuario parametroGeneralUsuario/*PresuTipoCuentaProyectoBeanSwingJInternalFrame presutipocuentaproyectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presutipocuentaproyectoBeanSwingJInternalFrame.jTtoolBarPresuTipoCuentaProyecto.setBorder(borderResaltar);
		
		this.resaltaridPresuTipoCuentaProyecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridPresuTipoCuentaProyecto() {
		return this.resaltaridPresuTipoCuentaProyecto;
	}

	public void setResaltaridPresuTipoCuentaProyecto(Border borderResaltar) {
		this.resaltaridPresuTipoCuentaProyecto= borderResaltar;
	}

	public Boolean getMostraridPresuTipoCuentaProyecto() {
		return this.mostraridPresuTipoCuentaProyecto;
	}

	public void setMostraridPresuTipoCuentaProyecto(Boolean mostraridPresuTipoCuentaProyecto) {
		this.mostraridPresuTipoCuentaProyecto= mostraridPresuTipoCuentaProyecto;
	}

	public Boolean getActivaridPresuTipoCuentaProyecto() {
		return this.activaridPresuTipoCuentaProyecto;
	}

	public void setActivaridPresuTipoCuentaProyecto(Boolean activaridPresuTipoCuentaProyecto) {
		this.activaridPresuTipoCuentaProyecto= activaridPresuTipoCuentaProyecto;
	}

	public Border setResaltarid_empresaPresuTipoCuentaProyecto(ParametroGeneralUsuario parametroGeneralUsuario/*PresuTipoCuentaProyectoBeanSwingJInternalFrame presutipocuentaproyectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presutipocuentaproyectoBeanSwingJInternalFrame.jTtoolBarPresuTipoCuentaProyecto.setBorder(borderResaltar);
		
		this.resaltarid_empresaPresuTipoCuentaProyecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaPresuTipoCuentaProyecto() {
		return this.resaltarid_empresaPresuTipoCuentaProyecto;
	}

	public void setResaltarid_empresaPresuTipoCuentaProyecto(Border borderResaltar) {
		this.resaltarid_empresaPresuTipoCuentaProyecto= borderResaltar;
	}

	public Boolean getMostrarid_empresaPresuTipoCuentaProyecto() {
		return this.mostrarid_empresaPresuTipoCuentaProyecto;
	}

	public void setMostrarid_empresaPresuTipoCuentaProyecto(Boolean mostrarid_empresaPresuTipoCuentaProyecto) {
		this.mostrarid_empresaPresuTipoCuentaProyecto= mostrarid_empresaPresuTipoCuentaProyecto;
	}

	public Boolean getActivarid_empresaPresuTipoCuentaProyecto() {
		return this.activarid_empresaPresuTipoCuentaProyecto;
	}

	public void setActivarid_empresaPresuTipoCuentaProyecto(Boolean activarid_empresaPresuTipoCuentaProyecto) {
		this.activarid_empresaPresuTipoCuentaProyecto= activarid_empresaPresuTipoCuentaProyecto;
	}

	public Boolean getCargarid_empresaPresuTipoCuentaProyecto() {
		return this.cargarid_empresaPresuTipoCuentaProyecto;
	}

	public void setCargarid_empresaPresuTipoCuentaProyecto(Boolean cargarid_empresaPresuTipoCuentaProyecto) {
		this.cargarid_empresaPresuTipoCuentaProyecto= cargarid_empresaPresuTipoCuentaProyecto;
	}

	public Border setResaltarcodigoPresuTipoCuentaProyecto(ParametroGeneralUsuario parametroGeneralUsuario/*PresuTipoCuentaProyectoBeanSwingJInternalFrame presutipocuentaproyectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presutipocuentaproyectoBeanSwingJInternalFrame.jTtoolBarPresuTipoCuentaProyecto.setBorder(borderResaltar);
		
		this.resaltarcodigoPresuTipoCuentaProyecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoPresuTipoCuentaProyecto() {
		return this.resaltarcodigoPresuTipoCuentaProyecto;
	}

	public void setResaltarcodigoPresuTipoCuentaProyecto(Border borderResaltar) {
		this.resaltarcodigoPresuTipoCuentaProyecto= borderResaltar;
	}

	public Boolean getMostrarcodigoPresuTipoCuentaProyecto() {
		return this.mostrarcodigoPresuTipoCuentaProyecto;
	}

	public void setMostrarcodigoPresuTipoCuentaProyecto(Boolean mostrarcodigoPresuTipoCuentaProyecto) {
		this.mostrarcodigoPresuTipoCuentaProyecto= mostrarcodigoPresuTipoCuentaProyecto;
	}

	public Boolean getActivarcodigoPresuTipoCuentaProyecto() {
		return this.activarcodigoPresuTipoCuentaProyecto;
	}

	public void setActivarcodigoPresuTipoCuentaProyecto(Boolean activarcodigoPresuTipoCuentaProyecto) {
		this.activarcodigoPresuTipoCuentaProyecto= activarcodigoPresuTipoCuentaProyecto;
	}

	public Border setResaltarnombrePresuTipoCuentaProyecto(ParametroGeneralUsuario parametroGeneralUsuario/*PresuTipoCuentaProyectoBeanSwingJInternalFrame presutipocuentaproyectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presutipocuentaproyectoBeanSwingJInternalFrame.jTtoolBarPresuTipoCuentaProyecto.setBorder(borderResaltar);
		
		this.resaltarnombrePresuTipoCuentaProyecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombrePresuTipoCuentaProyecto() {
		return this.resaltarnombrePresuTipoCuentaProyecto;
	}

	public void setResaltarnombrePresuTipoCuentaProyecto(Border borderResaltar) {
		this.resaltarnombrePresuTipoCuentaProyecto= borderResaltar;
	}

	public Boolean getMostrarnombrePresuTipoCuentaProyecto() {
		return this.mostrarnombrePresuTipoCuentaProyecto;
	}

	public void setMostrarnombrePresuTipoCuentaProyecto(Boolean mostrarnombrePresuTipoCuentaProyecto) {
		this.mostrarnombrePresuTipoCuentaProyecto= mostrarnombrePresuTipoCuentaProyecto;
	}

	public Boolean getActivarnombrePresuTipoCuentaProyecto() {
		return this.activarnombrePresuTipoCuentaProyecto;
	}

	public void setActivarnombrePresuTipoCuentaProyecto(Boolean activarnombrePresuTipoCuentaProyecto) {
		this.activarnombrePresuTipoCuentaProyecto= activarnombrePresuTipoCuentaProyecto;
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
		
		
		this.setMostraridPresuTipoCuentaProyecto(esInicial);
		this.setMostrarid_empresaPresuTipoCuentaProyecto(esInicial);
		this.setMostrarcodigoPresuTipoCuentaProyecto(esInicial);
		this.setMostrarnombrePresuTipoCuentaProyecto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PresuTipoCuentaProyectoConstantesFunciones.ID)) {
				this.setMostraridPresuTipoCuentaProyecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuTipoCuentaProyectoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaPresuTipoCuentaProyecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuTipoCuentaProyectoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoPresuTipoCuentaProyecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuTipoCuentaProyectoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombrePresuTipoCuentaProyecto(esAsigna);
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
		
		
		this.setActivaridPresuTipoCuentaProyecto(esInicial);
		this.setActivarid_empresaPresuTipoCuentaProyecto(esInicial);
		this.setActivarcodigoPresuTipoCuentaProyecto(esInicial);
		this.setActivarnombrePresuTipoCuentaProyecto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PresuTipoCuentaProyectoConstantesFunciones.ID)) {
				this.setActivaridPresuTipoCuentaProyecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuTipoCuentaProyectoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaPresuTipoCuentaProyecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuTipoCuentaProyectoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoPresuTipoCuentaProyecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuTipoCuentaProyectoConstantesFunciones.NOMBRE)) {
				this.setActivarnombrePresuTipoCuentaProyecto(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,PresuTipoCuentaProyectoBeanSwingJInternalFrame presutipocuentaproyectoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridPresuTipoCuentaProyecto(esInicial);
		this.setResaltarid_empresaPresuTipoCuentaProyecto(esInicial);
		this.setResaltarcodigoPresuTipoCuentaProyecto(esInicial);
		this.setResaltarnombrePresuTipoCuentaProyecto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PresuTipoCuentaProyectoConstantesFunciones.ID)) {
				this.setResaltaridPresuTipoCuentaProyecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuTipoCuentaProyectoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaPresuTipoCuentaProyecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuTipoCuentaProyectoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoPresuTipoCuentaProyecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuTipoCuentaProyectoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombrePresuTipoCuentaProyecto(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,PresuTipoCuentaProyectoBeanSwingJInternalFrame presutipocuentaproyectoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorCodigoPresuTipoCuentaProyecto=true;

	public Boolean getMostrarBusquedaPorCodigoPresuTipoCuentaProyecto() {
		return this.mostrarBusquedaPorCodigoPresuTipoCuentaProyecto;
	}

	public void setMostrarBusquedaPorCodigoPresuTipoCuentaProyecto(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoPresuTipoCuentaProyecto= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombrePresuTipoCuentaProyecto=true;

	public Boolean getMostrarBusquedaPorNombrePresuTipoCuentaProyecto() {
		return this.mostrarBusquedaPorNombrePresuTipoCuentaProyecto;
	}

	public void setMostrarBusquedaPorNombrePresuTipoCuentaProyecto(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombrePresuTipoCuentaProyecto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaPresuTipoCuentaProyecto=true;

	public Boolean getMostrarFK_IdEmpresaPresuTipoCuentaProyecto() {
		return this.mostrarFK_IdEmpresaPresuTipoCuentaProyecto;
	}

	public void setMostrarFK_IdEmpresaPresuTipoCuentaProyecto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaPresuTipoCuentaProyecto= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoPresuTipoCuentaProyecto=true;

	public Boolean getActivarBusquedaPorCodigoPresuTipoCuentaProyecto() {
		return this.activarBusquedaPorCodigoPresuTipoCuentaProyecto;
	}

	public void setActivarBusquedaPorCodigoPresuTipoCuentaProyecto(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoPresuTipoCuentaProyecto= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombrePresuTipoCuentaProyecto=true;

	public Boolean getActivarBusquedaPorNombrePresuTipoCuentaProyecto() {
		return this.activarBusquedaPorNombrePresuTipoCuentaProyecto;
	}

	public void setActivarBusquedaPorNombrePresuTipoCuentaProyecto(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombrePresuTipoCuentaProyecto= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaPresuTipoCuentaProyecto=true;

	public Boolean getActivarFK_IdEmpresaPresuTipoCuentaProyecto() {
		return this.activarFK_IdEmpresaPresuTipoCuentaProyecto;
	}

	public void setActivarFK_IdEmpresaPresuTipoCuentaProyecto(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaPresuTipoCuentaProyecto= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoPresuTipoCuentaProyecto=null;

	public Border getResaltarBusquedaPorCodigoPresuTipoCuentaProyecto() {
		return this.resaltarBusquedaPorCodigoPresuTipoCuentaProyecto;
	}

	public void setResaltarBusquedaPorCodigoPresuTipoCuentaProyecto(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoPresuTipoCuentaProyecto= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoPresuTipoCuentaProyecto(ParametroGeneralUsuario parametroGeneralUsuario/*PresuTipoCuentaProyectoBeanSwingJInternalFrame presutipocuentaproyectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoPresuTipoCuentaProyecto= borderResaltar;
	}

	public Border resaltarBusquedaPorNombrePresuTipoCuentaProyecto=null;

	public Border getResaltarBusquedaPorNombrePresuTipoCuentaProyecto() {
		return this.resaltarBusquedaPorNombrePresuTipoCuentaProyecto;
	}

	public void setResaltarBusquedaPorNombrePresuTipoCuentaProyecto(Border borderResaltar) {
		this.resaltarBusquedaPorNombrePresuTipoCuentaProyecto= borderResaltar;
	}

	public void setResaltarBusquedaPorNombrePresuTipoCuentaProyecto(ParametroGeneralUsuario parametroGeneralUsuario/*PresuTipoCuentaProyectoBeanSwingJInternalFrame presutipocuentaproyectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombrePresuTipoCuentaProyecto= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaPresuTipoCuentaProyecto=null;

	public Border getResaltarFK_IdEmpresaPresuTipoCuentaProyecto() {
		return this.resaltarFK_IdEmpresaPresuTipoCuentaProyecto;
	}

	public void setResaltarFK_IdEmpresaPresuTipoCuentaProyecto(Border borderResaltar) {
		this.resaltarFK_IdEmpresaPresuTipoCuentaProyecto= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaPresuTipoCuentaProyecto(ParametroGeneralUsuario parametroGeneralUsuario/*PresuTipoCuentaProyectoBeanSwingJInternalFrame presutipocuentaproyectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaPresuTipoCuentaProyecto= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}