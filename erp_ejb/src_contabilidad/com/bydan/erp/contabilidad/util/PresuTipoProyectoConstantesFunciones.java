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


import com.bydan.erp.contabilidad.util.PresuTipoProyectoConstantesFunciones;
import com.bydan.erp.contabilidad.util.PresuTipoProyectoParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.PresuTipoProyectoParameterGeneral;

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
final public class PresuTipoProyectoConstantesFunciones extends PresuTipoProyectoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="PresuTipoProyecto";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="PresuTipoProyecto"+PresuTipoProyectoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="PresuTipoProyectoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="PresuTipoProyectoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=PresuTipoProyectoConstantesFunciones.SCHEMA+"_"+PresuTipoProyectoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/PresuTipoProyectoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=PresuTipoProyectoConstantesFunciones.SCHEMA+"_"+PresuTipoProyectoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=PresuTipoProyectoConstantesFunciones.SCHEMA+"_"+PresuTipoProyectoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/PresuTipoProyectoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=PresuTipoProyectoConstantesFunciones.SCHEMA+"_"+PresuTipoProyectoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PresuTipoProyectoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PresuTipoProyectoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PresuTipoProyectoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PresuTipoProyectoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PresuTipoProyectoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PresuTipoProyectoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=PresuTipoProyectoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+PresuTipoProyectoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=PresuTipoProyectoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+PresuTipoProyectoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Proyectos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Proyecto";
	public static final String SCLASSWEBTITULO_LOWER="Presu Tipo Proyecto";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="PresuTipoProyecto";
	public static final String OBJECTNAME="presutipoproyecto";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="presu_tipo_proyecto";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select presutipoproyecto from "+PresuTipoProyectoConstantesFunciones.SPERSISTENCENAME+" presutipoproyecto";
	public static String QUERYSELECTNATIVE="select "+PresuTipoProyectoConstantesFunciones.SCHEMA+"."+PresuTipoProyectoConstantesFunciones.TABLENAME+".id,"+PresuTipoProyectoConstantesFunciones.SCHEMA+"."+PresuTipoProyectoConstantesFunciones.TABLENAME+".version_row,"+PresuTipoProyectoConstantesFunciones.SCHEMA+"."+PresuTipoProyectoConstantesFunciones.TABLENAME+".id_empresa,"+PresuTipoProyectoConstantesFunciones.SCHEMA+"."+PresuTipoProyectoConstantesFunciones.TABLENAME+".codigo,"+PresuTipoProyectoConstantesFunciones.SCHEMA+"."+PresuTipoProyectoConstantesFunciones.TABLENAME+".nombre from "+PresuTipoProyectoConstantesFunciones.SCHEMA+"."+PresuTipoProyectoConstantesFunciones.TABLENAME;//+" as "+PresuTipoProyectoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected PresuTipoProyectoConstantesFuncionesAdditional presutipoproyectoConstantesFuncionesAdditional=null;
	
	public PresuTipoProyectoConstantesFuncionesAdditional getPresuTipoProyectoConstantesFuncionesAdditional() {
		return this.presutipoproyectoConstantesFuncionesAdditional;
	}
	
	public void setPresuTipoProyectoConstantesFuncionesAdditional(PresuTipoProyectoConstantesFuncionesAdditional presutipoproyectoConstantesFuncionesAdditional) {
		try {
			this.presutipoproyectoConstantesFuncionesAdditional=presutipoproyectoConstantesFuncionesAdditional;
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
	
	public static String getPresuTipoProyectoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(PresuTipoProyectoConstantesFunciones.IDEMPRESA)) {sLabelColumna=PresuTipoProyectoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(PresuTipoProyectoConstantesFunciones.CODIGO)) {sLabelColumna=PresuTipoProyectoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(PresuTipoProyectoConstantesFunciones.NOMBRE)) {sLabelColumna=PresuTipoProyectoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getPresuTipoProyectoDescripcion(PresuTipoProyecto presutipoproyecto) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(presutipoproyecto !=null/* && presutipoproyecto.getId()!=0*/) {
			sDescripcion=presutipoproyecto.getcodigo();//presutipoproyectopresutipoproyecto.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getPresuTipoProyectoDescripcionDetallado(PresuTipoProyecto presutipoproyecto) {
		String sDescripcion="";
			
		sDescripcion+=PresuTipoProyectoConstantesFunciones.ID+"=";
		sDescripcion+=presutipoproyecto.getId().toString()+",";
		sDescripcion+=PresuTipoProyectoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=presutipoproyecto.getVersionRow().toString()+",";
		sDescripcion+=PresuTipoProyectoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=presutipoproyecto.getid_empresa().toString()+",";
		sDescripcion+=PresuTipoProyectoConstantesFunciones.CODIGO+"=";
		sDescripcion+=presutipoproyecto.getcodigo()+",";
		sDescripcion+=PresuTipoProyectoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=presutipoproyecto.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setPresuTipoProyectoDescripcion(PresuTipoProyecto presutipoproyecto,String sValor) throws Exception {			
		if(presutipoproyecto !=null) {
			presutipoproyecto.setcodigo(sValor);;//presutipoproyectopresutipoproyecto.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosPresuTipoProyecto(PresuTipoProyecto presutipoproyecto,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		presutipoproyecto.setcodigo(presutipoproyecto.getcodigo().trim());
		presutipoproyecto.setnombre(presutipoproyecto.getnombre().trim());
	}
	
	public static void quitarEspaciosPresuTipoProyectos(List<PresuTipoProyecto> presutipoproyectos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PresuTipoProyecto presutipoproyecto: presutipoproyectos) {
			presutipoproyecto.setcodigo(presutipoproyecto.getcodigo().trim());
			presutipoproyecto.setnombre(presutipoproyecto.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPresuTipoProyecto(PresuTipoProyecto presutipoproyecto,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && presutipoproyecto.getConCambioAuxiliar()) {
			presutipoproyecto.setIsDeleted(presutipoproyecto.getIsDeletedAuxiliar());	
			presutipoproyecto.setIsNew(presutipoproyecto.getIsNewAuxiliar());	
			presutipoproyecto.setIsChanged(presutipoproyecto.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			presutipoproyecto.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			presutipoproyecto.setIsDeletedAuxiliar(false);	
			presutipoproyecto.setIsNewAuxiliar(false);	
			presutipoproyecto.setIsChangedAuxiliar(false);
			
			presutipoproyecto.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPresuTipoProyectos(List<PresuTipoProyecto> presutipoproyectos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(PresuTipoProyecto presutipoproyecto : presutipoproyectos) {
			if(conAsignarBase && presutipoproyecto.getConCambioAuxiliar()) {
				presutipoproyecto.setIsDeleted(presutipoproyecto.getIsDeletedAuxiliar());	
				presutipoproyecto.setIsNew(presutipoproyecto.getIsNewAuxiliar());	
				presutipoproyecto.setIsChanged(presutipoproyecto.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				presutipoproyecto.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				presutipoproyecto.setIsDeletedAuxiliar(false);	
				presutipoproyecto.setIsNewAuxiliar(false);	
				presutipoproyecto.setIsChangedAuxiliar(false);
				
				presutipoproyecto.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresPresuTipoProyecto(PresuTipoProyecto presutipoproyecto,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresPresuTipoProyectos(List<PresuTipoProyecto> presutipoproyectos,Boolean conEnteros) throws Exception  {
		
		for(PresuTipoProyecto presutipoproyecto: presutipoproyectos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaPresuTipoProyecto(List<PresuTipoProyecto> presutipoproyectos,PresuTipoProyecto presutipoproyectoAux) throws Exception  {
		PresuTipoProyectoConstantesFunciones.InicializarValoresPresuTipoProyecto(presutipoproyectoAux,true);
		
		for(PresuTipoProyecto presutipoproyecto: presutipoproyectos) {
			if(presutipoproyecto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPresuTipoProyecto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=PresuTipoProyectoConstantesFunciones.getArrayColumnasGlobalesPresuTipoProyecto(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesPresuTipoProyecto(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PresuTipoProyectoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PresuTipoProyectoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoPresuTipoProyecto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PresuTipoProyecto> presutipoproyectos,PresuTipoProyecto presutipoproyecto,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PresuTipoProyecto presutipoproyectoAux: presutipoproyectos) {
			if(presutipoproyectoAux!=null && presutipoproyecto!=null) {
				if((presutipoproyectoAux.getId()==null && presutipoproyecto.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(presutipoproyectoAux.getId()!=null && presutipoproyecto.getId()!=null){
					if(presutipoproyectoAux.getId().equals(presutipoproyecto.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPresuTipoProyecto(List<PresuTipoProyecto> presutipoproyectos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(PresuTipoProyecto presutipoproyecto: presutipoproyectos) {			
			if(presutipoproyecto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaPresuTipoProyecto() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,PresuTipoProyectoConstantesFunciones.LABEL_ID, PresuTipoProyectoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresuTipoProyectoConstantesFunciones.LABEL_VERSIONROW, PresuTipoProyectoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresuTipoProyectoConstantesFunciones.LABEL_IDEMPRESA, PresuTipoProyectoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresuTipoProyectoConstantesFunciones.LABEL_CODIGO, PresuTipoProyectoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PresuTipoProyectoConstantesFunciones.LABEL_NOMBRE, PresuTipoProyectoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasPresuTipoProyecto() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=PresuTipoProyectoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresuTipoProyectoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresuTipoProyectoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresuTipoProyectoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PresuTipoProyectoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPresuTipoProyecto() throws Exception  {
		return PresuTipoProyectoConstantesFunciones.getTiposSeleccionarPresuTipoProyecto(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPresuTipoProyecto(Boolean conFk) throws Exception  {
		return PresuTipoProyectoConstantesFunciones.getTiposSeleccionarPresuTipoProyecto(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPresuTipoProyecto(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PresuTipoProyectoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(PresuTipoProyectoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresuTipoProyectoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(PresuTipoProyectoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PresuTipoProyectoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(PresuTipoProyectoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesPresuTipoProyecto(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesPresuTipoProyecto(PresuTipoProyecto presutipoproyectoAux) throws Exception {
		
			presutipoproyectoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(presutipoproyectoAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesPresuTipoProyecto(List<PresuTipoProyecto> presutipoproyectosTemp) throws Exception {
		for(PresuTipoProyecto presutipoproyectoAux:presutipoproyectosTemp) {
			
			presutipoproyectoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(presutipoproyectoAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfPresuTipoProyecto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfPresuTipoProyecto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfPresuTipoProyecto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return PresuTipoProyectoConstantesFunciones.getClassesRelationshipsOfPresuTipoProyecto(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPresuTipoProyecto(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(PresuProyecto.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(PresuProyecto.class)) {
						classes.add(new Classe(PresuProyecto.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPresuTipoProyecto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return PresuTipoProyectoConstantesFunciones.getClassesRelationshipsFromStringsOfPresuTipoProyecto(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPresuTipoProyecto(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(PresuProyecto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PresuProyecto.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(PresuProyecto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PresuProyecto.class)); continue;
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
	public static void actualizarLista(PresuTipoProyecto presutipoproyecto,List<PresuTipoProyecto> presutipoproyectos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			PresuTipoProyecto presutipoproyectoEncontrado=null;
			
			for(PresuTipoProyecto presutipoproyectoLocal:presutipoproyectos) {
				if(presutipoproyectoLocal.getId().equals(presutipoproyecto.getId())) {
					presutipoproyectoEncontrado=presutipoproyectoLocal;
					
					presutipoproyectoLocal.setIsChanged(presutipoproyecto.getIsChanged());
					presutipoproyectoLocal.setIsNew(presutipoproyecto.getIsNew());
					presutipoproyectoLocal.setIsDeleted(presutipoproyecto.getIsDeleted());
					
					presutipoproyectoLocal.setGeneralEntityOriginal(presutipoproyecto.getGeneralEntityOriginal());
					
					presutipoproyectoLocal.setId(presutipoproyecto.getId());	
					presutipoproyectoLocal.setVersionRow(presutipoproyecto.getVersionRow());	
					presutipoproyectoLocal.setid_empresa(presutipoproyecto.getid_empresa());	
					presutipoproyectoLocal.setcodigo(presutipoproyecto.getcodigo());	
					presutipoproyectoLocal.setnombre(presutipoproyecto.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!presutipoproyecto.getIsDeleted()) {
				if(!existe) {
					presutipoproyectos.add(presutipoproyecto);
				}
			} else {
				if(presutipoproyectoEncontrado!=null && permiteQuitar)  {
					presutipoproyectos.remove(presutipoproyectoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(PresuTipoProyecto presutipoproyecto,List<PresuTipoProyecto> presutipoproyectos) throws Exception {
		try	{			
			for(PresuTipoProyecto presutipoproyectoLocal:presutipoproyectos) {
				if(presutipoproyectoLocal.getId().equals(presutipoproyecto.getId())) {
					presutipoproyectoLocal.setIsSelected(presutipoproyecto.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesPresuTipoProyecto(List<PresuTipoProyecto> presutipoproyectosAux) throws Exception {
		//this.presutipoproyectosAux=presutipoproyectosAux;
		
		for(PresuTipoProyecto presutipoproyectoAux:presutipoproyectosAux) {
			if(presutipoproyectoAux.getIsChanged()) {
				presutipoproyectoAux.setIsChanged(false);
			}		
			
			if(presutipoproyectoAux.getIsNew()) {
				presutipoproyectoAux.setIsNew(false);
			}	
			
			if(presutipoproyectoAux.getIsDeleted()) {
				presutipoproyectoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesPresuTipoProyecto(PresuTipoProyecto presutipoproyectoAux) throws Exception {
		//this.presutipoproyectoAux=presutipoproyectoAux;
		
			if(presutipoproyectoAux.getIsChanged()) {
				presutipoproyectoAux.setIsChanged(false);
			}		
			
			if(presutipoproyectoAux.getIsNew()) {
				presutipoproyectoAux.setIsNew(false);
			}	
			
			if(presutipoproyectoAux.getIsDeleted()) {
				presutipoproyectoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(PresuTipoProyecto presutipoproyectoAsignar,PresuTipoProyecto presutipoproyecto) throws Exception {
		presutipoproyectoAsignar.setId(presutipoproyecto.getId());	
		presutipoproyectoAsignar.setVersionRow(presutipoproyecto.getVersionRow());	
		presutipoproyectoAsignar.setid_empresa(presutipoproyecto.getid_empresa());
		presutipoproyectoAsignar.setempresa_descripcion(presutipoproyecto.getempresa_descripcion());	
		presutipoproyectoAsignar.setcodigo(presutipoproyecto.getcodigo());	
		presutipoproyectoAsignar.setnombre(presutipoproyecto.getnombre());	
	}
	
	public static void inicializarPresuTipoProyecto(PresuTipoProyecto presutipoproyecto) throws Exception {
		try {
				presutipoproyecto.setId(0L);	
					
				presutipoproyecto.setid_empresa(-1L);	
				presutipoproyecto.setcodigo("");	
				presutipoproyecto.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderPresuTipoProyecto(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(PresuTipoProyectoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresuTipoProyectoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PresuTipoProyectoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataPresuTipoProyecto(String sTipo,Row row,Workbook workbook,PresuTipoProyecto presutipoproyecto,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(presutipoproyecto.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presutipoproyecto.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(presutipoproyecto.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryPresuTipoProyecto=Constantes.SFINALQUERY;
	
	public String getsFinalQueryPresuTipoProyecto() {
		return this.sFinalQueryPresuTipoProyecto;
	}
	
	public void setsFinalQueryPresuTipoProyecto(String sFinalQueryPresuTipoProyecto) {
		this.sFinalQueryPresuTipoProyecto= sFinalQueryPresuTipoProyecto;
	}
	
	public Border resaltarSeleccionarPresuTipoProyecto=null;
	
	public Border setResaltarSeleccionarPresuTipoProyecto(ParametroGeneralUsuario parametroGeneralUsuario/*PresuTipoProyectoBeanSwingJInternalFrame presutipoproyectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//presutipoproyectoBeanSwingJInternalFrame.jTtoolBarPresuTipoProyecto.setBorder(borderResaltar);
		
		this.resaltarSeleccionarPresuTipoProyecto= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarPresuTipoProyecto() {
		return this.resaltarSeleccionarPresuTipoProyecto;
	}
	
	public void setResaltarSeleccionarPresuTipoProyecto(Border borderResaltarSeleccionarPresuTipoProyecto) {
		this.resaltarSeleccionarPresuTipoProyecto= borderResaltarSeleccionarPresuTipoProyecto;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridPresuTipoProyecto=null;
	public Boolean mostraridPresuTipoProyecto=true;
	public Boolean activaridPresuTipoProyecto=true;

	public Border resaltarid_empresaPresuTipoProyecto=null;
	public Boolean mostrarid_empresaPresuTipoProyecto=true;
	public Boolean activarid_empresaPresuTipoProyecto=true;
	public Boolean cargarid_empresaPresuTipoProyecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaPresuTipoProyecto=false;//ConEventDepend=true

	public Border resaltarcodigoPresuTipoProyecto=null;
	public Boolean mostrarcodigoPresuTipoProyecto=true;
	public Boolean activarcodigoPresuTipoProyecto=true;

	public Border resaltarnombrePresuTipoProyecto=null;
	public Boolean mostrarnombrePresuTipoProyecto=true;
	public Boolean activarnombrePresuTipoProyecto=true;

	
	

	public Border setResaltaridPresuTipoProyecto(ParametroGeneralUsuario parametroGeneralUsuario/*PresuTipoProyectoBeanSwingJInternalFrame presutipoproyectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presutipoproyectoBeanSwingJInternalFrame.jTtoolBarPresuTipoProyecto.setBorder(borderResaltar);
		
		this.resaltaridPresuTipoProyecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridPresuTipoProyecto() {
		return this.resaltaridPresuTipoProyecto;
	}

	public void setResaltaridPresuTipoProyecto(Border borderResaltar) {
		this.resaltaridPresuTipoProyecto= borderResaltar;
	}

	public Boolean getMostraridPresuTipoProyecto() {
		return this.mostraridPresuTipoProyecto;
	}

	public void setMostraridPresuTipoProyecto(Boolean mostraridPresuTipoProyecto) {
		this.mostraridPresuTipoProyecto= mostraridPresuTipoProyecto;
	}

	public Boolean getActivaridPresuTipoProyecto() {
		return this.activaridPresuTipoProyecto;
	}

	public void setActivaridPresuTipoProyecto(Boolean activaridPresuTipoProyecto) {
		this.activaridPresuTipoProyecto= activaridPresuTipoProyecto;
	}

	public Border setResaltarid_empresaPresuTipoProyecto(ParametroGeneralUsuario parametroGeneralUsuario/*PresuTipoProyectoBeanSwingJInternalFrame presutipoproyectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presutipoproyectoBeanSwingJInternalFrame.jTtoolBarPresuTipoProyecto.setBorder(borderResaltar);
		
		this.resaltarid_empresaPresuTipoProyecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaPresuTipoProyecto() {
		return this.resaltarid_empresaPresuTipoProyecto;
	}

	public void setResaltarid_empresaPresuTipoProyecto(Border borderResaltar) {
		this.resaltarid_empresaPresuTipoProyecto= borderResaltar;
	}

	public Boolean getMostrarid_empresaPresuTipoProyecto() {
		return this.mostrarid_empresaPresuTipoProyecto;
	}

	public void setMostrarid_empresaPresuTipoProyecto(Boolean mostrarid_empresaPresuTipoProyecto) {
		this.mostrarid_empresaPresuTipoProyecto= mostrarid_empresaPresuTipoProyecto;
	}

	public Boolean getActivarid_empresaPresuTipoProyecto() {
		return this.activarid_empresaPresuTipoProyecto;
	}

	public void setActivarid_empresaPresuTipoProyecto(Boolean activarid_empresaPresuTipoProyecto) {
		this.activarid_empresaPresuTipoProyecto= activarid_empresaPresuTipoProyecto;
	}

	public Boolean getCargarid_empresaPresuTipoProyecto() {
		return this.cargarid_empresaPresuTipoProyecto;
	}

	public void setCargarid_empresaPresuTipoProyecto(Boolean cargarid_empresaPresuTipoProyecto) {
		this.cargarid_empresaPresuTipoProyecto= cargarid_empresaPresuTipoProyecto;
	}

	public Border setResaltarcodigoPresuTipoProyecto(ParametroGeneralUsuario parametroGeneralUsuario/*PresuTipoProyectoBeanSwingJInternalFrame presutipoproyectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presutipoproyectoBeanSwingJInternalFrame.jTtoolBarPresuTipoProyecto.setBorder(borderResaltar);
		
		this.resaltarcodigoPresuTipoProyecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoPresuTipoProyecto() {
		return this.resaltarcodigoPresuTipoProyecto;
	}

	public void setResaltarcodigoPresuTipoProyecto(Border borderResaltar) {
		this.resaltarcodigoPresuTipoProyecto= borderResaltar;
	}

	public Boolean getMostrarcodigoPresuTipoProyecto() {
		return this.mostrarcodigoPresuTipoProyecto;
	}

	public void setMostrarcodigoPresuTipoProyecto(Boolean mostrarcodigoPresuTipoProyecto) {
		this.mostrarcodigoPresuTipoProyecto= mostrarcodigoPresuTipoProyecto;
	}

	public Boolean getActivarcodigoPresuTipoProyecto() {
		return this.activarcodigoPresuTipoProyecto;
	}

	public void setActivarcodigoPresuTipoProyecto(Boolean activarcodigoPresuTipoProyecto) {
		this.activarcodigoPresuTipoProyecto= activarcodigoPresuTipoProyecto;
	}

	public Border setResaltarnombrePresuTipoProyecto(ParametroGeneralUsuario parametroGeneralUsuario/*PresuTipoProyectoBeanSwingJInternalFrame presutipoproyectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//presutipoproyectoBeanSwingJInternalFrame.jTtoolBarPresuTipoProyecto.setBorder(borderResaltar);
		
		this.resaltarnombrePresuTipoProyecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombrePresuTipoProyecto() {
		return this.resaltarnombrePresuTipoProyecto;
	}

	public void setResaltarnombrePresuTipoProyecto(Border borderResaltar) {
		this.resaltarnombrePresuTipoProyecto= borderResaltar;
	}

	public Boolean getMostrarnombrePresuTipoProyecto() {
		return this.mostrarnombrePresuTipoProyecto;
	}

	public void setMostrarnombrePresuTipoProyecto(Boolean mostrarnombrePresuTipoProyecto) {
		this.mostrarnombrePresuTipoProyecto= mostrarnombrePresuTipoProyecto;
	}

	public Boolean getActivarnombrePresuTipoProyecto() {
		return this.activarnombrePresuTipoProyecto;
	}

	public void setActivarnombrePresuTipoProyecto(Boolean activarnombrePresuTipoProyecto) {
		this.activarnombrePresuTipoProyecto= activarnombrePresuTipoProyecto;
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
		
		
		this.setMostraridPresuTipoProyecto(esInicial);
		this.setMostrarid_empresaPresuTipoProyecto(esInicial);
		this.setMostrarcodigoPresuTipoProyecto(esInicial);
		this.setMostrarnombrePresuTipoProyecto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PresuTipoProyectoConstantesFunciones.ID)) {
				this.setMostraridPresuTipoProyecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuTipoProyectoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaPresuTipoProyecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuTipoProyectoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoPresuTipoProyecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuTipoProyectoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombrePresuTipoProyecto(esAsigna);
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
		
		
		this.setActivaridPresuTipoProyecto(esInicial);
		this.setActivarid_empresaPresuTipoProyecto(esInicial);
		this.setActivarcodigoPresuTipoProyecto(esInicial);
		this.setActivarnombrePresuTipoProyecto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PresuTipoProyectoConstantesFunciones.ID)) {
				this.setActivaridPresuTipoProyecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuTipoProyectoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaPresuTipoProyecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuTipoProyectoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoPresuTipoProyecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuTipoProyectoConstantesFunciones.NOMBRE)) {
				this.setActivarnombrePresuTipoProyecto(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,PresuTipoProyectoBeanSwingJInternalFrame presutipoproyectoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridPresuTipoProyecto(esInicial);
		this.setResaltarid_empresaPresuTipoProyecto(esInicial);
		this.setResaltarcodigoPresuTipoProyecto(esInicial);
		this.setResaltarnombrePresuTipoProyecto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PresuTipoProyectoConstantesFunciones.ID)) {
				this.setResaltaridPresuTipoProyecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuTipoProyectoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaPresuTipoProyecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuTipoProyectoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoPresuTipoProyecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(PresuTipoProyectoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombrePresuTipoProyecto(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,PresuTipoProyectoBeanSwingJInternalFrame presutipoproyectoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaPorCodigoPresuTipoProyecto=true;

	public Boolean getMostrarBusquedaPorCodigoPresuTipoProyecto() {
		return this.mostrarBusquedaPorCodigoPresuTipoProyecto;
	}

	public void setMostrarBusquedaPorCodigoPresuTipoProyecto(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorCodigoPresuTipoProyecto= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombrePresuTipoProyecto=true;

	public Boolean getMostrarBusquedaPorNombrePresuTipoProyecto() {
		return this.mostrarBusquedaPorNombrePresuTipoProyecto;
	}

	public void setMostrarBusquedaPorNombrePresuTipoProyecto(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombrePresuTipoProyecto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaPresuTipoProyecto=true;

	public Boolean getMostrarFK_IdEmpresaPresuTipoProyecto() {
		return this.mostrarFK_IdEmpresaPresuTipoProyecto;
	}

	public void setMostrarFK_IdEmpresaPresuTipoProyecto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaPresuTipoProyecto= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorCodigoPresuTipoProyecto=true;

	public Boolean getActivarBusquedaPorCodigoPresuTipoProyecto() {
		return this.activarBusquedaPorCodigoPresuTipoProyecto;
	}

	public void setActivarBusquedaPorCodigoPresuTipoProyecto(Boolean habilitarResaltar) {
		this.activarBusquedaPorCodigoPresuTipoProyecto= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombrePresuTipoProyecto=true;

	public Boolean getActivarBusquedaPorNombrePresuTipoProyecto() {
		return this.activarBusquedaPorNombrePresuTipoProyecto;
	}

	public void setActivarBusquedaPorNombrePresuTipoProyecto(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombrePresuTipoProyecto= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaPresuTipoProyecto=true;

	public Boolean getActivarFK_IdEmpresaPresuTipoProyecto() {
		return this.activarFK_IdEmpresaPresuTipoProyecto;
	}

	public void setActivarFK_IdEmpresaPresuTipoProyecto(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaPresuTipoProyecto= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorCodigoPresuTipoProyecto=null;

	public Border getResaltarBusquedaPorCodigoPresuTipoProyecto() {
		return this.resaltarBusquedaPorCodigoPresuTipoProyecto;
	}

	public void setResaltarBusquedaPorCodigoPresuTipoProyecto(Border borderResaltar) {
		this.resaltarBusquedaPorCodigoPresuTipoProyecto= borderResaltar;
	}

	public void setResaltarBusquedaPorCodigoPresuTipoProyecto(ParametroGeneralUsuario parametroGeneralUsuario/*PresuTipoProyectoBeanSwingJInternalFrame presutipoproyectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorCodigoPresuTipoProyecto= borderResaltar;
	}

	public Border resaltarBusquedaPorNombrePresuTipoProyecto=null;

	public Border getResaltarBusquedaPorNombrePresuTipoProyecto() {
		return this.resaltarBusquedaPorNombrePresuTipoProyecto;
	}

	public void setResaltarBusquedaPorNombrePresuTipoProyecto(Border borderResaltar) {
		this.resaltarBusquedaPorNombrePresuTipoProyecto= borderResaltar;
	}

	public void setResaltarBusquedaPorNombrePresuTipoProyecto(ParametroGeneralUsuario parametroGeneralUsuario/*PresuTipoProyectoBeanSwingJInternalFrame presutipoproyectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombrePresuTipoProyecto= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaPresuTipoProyecto=null;

	public Border getResaltarFK_IdEmpresaPresuTipoProyecto() {
		return this.resaltarFK_IdEmpresaPresuTipoProyecto;
	}

	public void setResaltarFK_IdEmpresaPresuTipoProyecto(Border borderResaltar) {
		this.resaltarFK_IdEmpresaPresuTipoProyecto= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaPresuTipoProyecto(ParametroGeneralUsuario parametroGeneralUsuario/*PresuTipoProyectoBeanSwingJInternalFrame presutipoproyectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaPresuTipoProyecto= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}