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


import com.bydan.erp.contabilidad.util.GrupoParametroFormularioIvaConstantesFunciones;
import com.bydan.erp.contabilidad.util.GrupoParametroFormularioIvaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.GrupoParametroFormularioIvaParameterGeneral;

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
final public class GrupoParametroFormularioIvaConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="GrupoParametroFormularioIva";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="GrupoParametroFormularioIva"+GrupoParametroFormularioIvaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="GrupoParametroFormularioIvaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="GrupoParametroFormularioIvaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=GrupoParametroFormularioIvaConstantesFunciones.SCHEMA+"_"+GrupoParametroFormularioIvaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/GrupoParametroFormularioIvaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=GrupoParametroFormularioIvaConstantesFunciones.SCHEMA+"_"+GrupoParametroFormularioIvaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=GrupoParametroFormularioIvaConstantesFunciones.SCHEMA+"_"+GrupoParametroFormularioIvaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/GrupoParametroFormularioIvaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=GrupoParametroFormularioIvaConstantesFunciones.SCHEMA+"_"+GrupoParametroFormularioIvaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+GrupoParametroFormularioIvaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/GrupoParametroFormularioIvaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+GrupoParametroFormularioIvaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+GrupoParametroFormularioIvaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/GrupoParametroFormularioIvaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+GrupoParametroFormularioIvaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=GrupoParametroFormularioIvaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+GrupoParametroFormularioIvaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=GrupoParametroFormularioIvaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+GrupoParametroFormularioIvaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Grupo Parametro Formulario Ivas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Grupo Parametro Formulario Iva";
	public static final String SCLASSWEBTITULO_LOWER="Grupo Parametro Formulario Iva";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="GrupoParametroFormularioIva";
	public static final String OBJECTNAME="grupoparametroformularioiva";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="grupo_parametro_formulario_iva";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select grupoparametroformularioiva from "+GrupoParametroFormularioIvaConstantesFunciones.SPERSISTENCENAME+" grupoparametroformularioiva";
	public static String QUERYSELECTNATIVE="select "+GrupoParametroFormularioIvaConstantesFunciones.SCHEMA+"."+GrupoParametroFormularioIvaConstantesFunciones.TABLENAME+".id,"+GrupoParametroFormularioIvaConstantesFunciones.SCHEMA+"."+GrupoParametroFormularioIvaConstantesFunciones.TABLENAME+".id_empresa,"+GrupoParametroFormularioIvaConstantesFunciones.SCHEMA+"."+GrupoParametroFormularioIvaConstantesFunciones.TABLENAME+".version_row,"+GrupoParametroFormularioIvaConstantesFunciones.SCHEMA+"."+GrupoParametroFormularioIvaConstantesFunciones.TABLENAME+".nombre from "+GrupoParametroFormularioIvaConstantesFunciones.SCHEMA+"."+GrupoParametroFormularioIvaConstantesFunciones.TABLENAME;//+" as "+GrupoParametroFormularioIvaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getGrupoParametroFormularioIvaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(GrupoParametroFormularioIvaConstantesFunciones.IDEMPRESA)) {sLabelColumna=GrupoParametroFormularioIvaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(GrupoParametroFormularioIvaConstantesFunciones.NOMBRE)) {sLabelColumna=GrupoParametroFormularioIvaConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getGrupoParametroFormularioIvaDescripcion(GrupoParametroFormularioIva grupoparametroformularioiva) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(grupoparametroformularioiva !=null/* && grupoparametroformularioiva.getId()!=0*/) {
			sDescripcion=grupoparametroformularioiva.getnombre();//grupoparametroformularioivagrupoparametroformularioiva.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getGrupoParametroFormularioIvaDescripcionDetallado(GrupoParametroFormularioIva grupoparametroformularioiva) {
		String sDescripcion="";
			
		sDescripcion+=GrupoParametroFormularioIvaConstantesFunciones.ID+"=";
		sDescripcion+=grupoparametroformularioiva.getId().toString()+",";
		sDescripcion+=GrupoParametroFormularioIvaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=grupoparametroformularioiva.getid_empresa().toString()+",";
		sDescripcion+=GrupoParametroFormularioIvaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=grupoparametroformularioiva.getVersionRow().toString()+",";
		sDescripcion+=GrupoParametroFormularioIvaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=grupoparametroformularioiva.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setGrupoParametroFormularioIvaDescripcion(GrupoParametroFormularioIva grupoparametroformularioiva,String sValor) throws Exception {			
		if(grupoparametroformularioiva !=null) {
			grupoparametroformularioiva.setnombre(sValor);;//grupoparametroformularioivagrupoparametroformularioiva.getnombre().trim();
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
		} else if(sNombreIndice.equals("BusquedaPorId")) {
			sNombreIndice="Tipo=  Por Id";
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

	public static String getDetalleIndiceBusquedaPorId(Long id) {
		String sDetalleIndice=" Parametros->";
		if(id!=null) {sDetalleIndice+=" Id="+id.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosGrupoParametroFormularioIva(GrupoParametroFormularioIva grupoparametroformularioiva,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		grupoparametroformularioiva.setnombre(grupoparametroformularioiva.getnombre().trim());
	}
	
	public static void quitarEspaciosGrupoParametroFormularioIvas(List<GrupoParametroFormularioIva> grupoparametroformularioivas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(GrupoParametroFormularioIva grupoparametroformularioiva: grupoparametroformularioivas) {
			grupoparametroformularioiva.setnombre(grupoparametroformularioiva.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresGrupoParametroFormularioIva(GrupoParametroFormularioIva grupoparametroformularioiva,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && grupoparametroformularioiva.getConCambioAuxiliar()) {
			grupoparametroformularioiva.setIsDeleted(grupoparametroformularioiva.getIsDeletedAuxiliar());	
			grupoparametroformularioiva.setIsNew(grupoparametroformularioiva.getIsNewAuxiliar());	
			grupoparametroformularioiva.setIsChanged(grupoparametroformularioiva.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			grupoparametroformularioiva.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			grupoparametroformularioiva.setIsDeletedAuxiliar(false);	
			grupoparametroformularioiva.setIsNewAuxiliar(false);	
			grupoparametroformularioiva.setIsChangedAuxiliar(false);
			
			grupoparametroformularioiva.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresGrupoParametroFormularioIvas(List<GrupoParametroFormularioIva> grupoparametroformularioivas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(GrupoParametroFormularioIva grupoparametroformularioiva : grupoparametroformularioivas) {
			if(conAsignarBase && grupoparametroformularioiva.getConCambioAuxiliar()) {
				grupoparametroformularioiva.setIsDeleted(grupoparametroformularioiva.getIsDeletedAuxiliar());	
				grupoparametroformularioiva.setIsNew(grupoparametroformularioiva.getIsNewAuxiliar());	
				grupoparametroformularioiva.setIsChanged(grupoparametroformularioiva.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				grupoparametroformularioiva.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				grupoparametroformularioiva.setIsDeletedAuxiliar(false);	
				grupoparametroformularioiva.setIsNewAuxiliar(false);	
				grupoparametroformularioiva.setIsChangedAuxiliar(false);
				
				grupoparametroformularioiva.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresGrupoParametroFormularioIva(GrupoParametroFormularioIva grupoparametroformularioiva,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresGrupoParametroFormularioIvas(List<GrupoParametroFormularioIva> grupoparametroformularioivas,Boolean conEnteros) throws Exception  {
		
		for(GrupoParametroFormularioIva grupoparametroformularioiva: grupoparametroformularioivas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaGrupoParametroFormularioIva(List<GrupoParametroFormularioIva> grupoparametroformularioivas,GrupoParametroFormularioIva grupoparametroformularioivaAux) throws Exception  {
		GrupoParametroFormularioIvaConstantesFunciones.InicializarValoresGrupoParametroFormularioIva(grupoparametroformularioivaAux,true);
		
		for(GrupoParametroFormularioIva grupoparametroformularioiva: grupoparametroformularioivas) {
			if(grupoparametroformularioiva.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesGrupoParametroFormularioIva(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=GrupoParametroFormularioIvaConstantesFunciones.getArrayColumnasGlobalesGrupoParametroFormularioIva(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesGrupoParametroFormularioIva(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(GrupoParametroFormularioIvaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(GrupoParametroFormularioIvaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoGrupoParametroFormularioIva(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<GrupoParametroFormularioIva> grupoparametroformularioivas,GrupoParametroFormularioIva grupoparametroformularioiva,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(GrupoParametroFormularioIva grupoparametroformularioivaAux: grupoparametroformularioivas) {
			if(grupoparametroformularioivaAux!=null && grupoparametroformularioiva!=null) {
				if((grupoparametroformularioivaAux.getId()==null && grupoparametroformularioiva.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(grupoparametroformularioivaAux.getId()!=null && grupoparametroformularioiva.getId()!=null){
					if(grupoparametroformularioivaAux.getId().equals(grupoparametroformularioiva.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaGrupoParametroFormularioIva(List<GrupoParametroFormularioIva> grupoparametroformularioivas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(GrupoParametroFormularioIva grupoparametroformularioiva: grupoparametroformularioivas) {			
			if(grupoparametroformularioiva.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaGrupoParametroFormularioIva() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,GrupoParametroFormularioIvaConstantesFunciones.LABEL_ID, GrupoParametroFormularioIvaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GrupoParametroFormularioIvaConstantesFunciones.LABEL_IDEMPRESA, GrupoParametroFormularioIvaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GrupoParametroFormularioIvaConstantesFunciones.LABEL_VERSIONROW, GrupoParametroFormularioIvaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GrupoParametroFormularioIvaConstantesFunciones.LABEL_NOMBRE, GrupoParametroFormularioIvaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasGrupoParametroFormularioIva() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=GrupoParametroFormularioIvaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GrupoParametroFormularioIvaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GrupoParametroFormularioIvaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GrupoParametroFormularioIvaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarGrupoParametroFormularioIva() throws Exception  {
		return GrupoParametroFormularioIvaConstantesFunciones.getTiposSeleccionarGrupoParametroFormularioIva(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarGrupoParametroFormularioIva(Boolean conFk) throws Exception  {
		return GrupoParametroFormularioIvaConstantesFunciones.getTiposSeleccionarGrupoParametroFormularioIva(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarGrupoParametroFormularioIva(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GrupoParametroFormularioIvaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(GrupoParametroFormularioIvaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GrupoParametroFormularioIvaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(GrupoParametroFormularioIvaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesGrupoParametroFormularioIva(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesGrupoParametroFormularioIva(GrupoParametroFormularioIva grupoparametroformularioivaAux) throws Exception {
		
			grupoparametroformularioivaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(grupoparametroformularioivaAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesGrupoParametroFormularioIva(List<GrupoParametroFormularioIva> grupoparametroformularioivasTemp) throws Exception {
		for(GrupoParametroFormularioIva grupoparametroformularioivaAux:grupoparametroformularioivasTemp) {
			
			grupoparametroformularioivaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(grupoparametroformularioivaAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfGrupoParametroFormularioIva(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfGrupoParametroFormularioIva(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfGrupoParametroFormularioIva(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return GrupoParametroFormularioIvaConstantesFunciones.getClassesRelationshipsOfGrupoParametroFormularioIva(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfGrupoParametroFormularioIva(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(ParametroFormularioIva.class));
				classes.add(new Classe(FormularioIva.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(ParametroFormularioIva.class)) {
						classes.add(new Classe(ParametroFormularioIva.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(FormularioIva.class)) {
						classes.add(new Classe(FormularioIva.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfGrupoParametroFormularioIva(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return GrupoParametroFormularioIvaConstantesFunciones.getClassesRelationshipsFromStringsOfGrupoParametroFormularioIva(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfGrupoParametroFormularioIva(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(ParametroFormularioIva.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroFormularioIva.class)); continue;
					}

					if(FormularioIva.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormularioIva.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(ParametroFormularioIva.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroFormularioIva.class)); continue;
					}

					if(FormularioIva.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FormularioIva.class)); continue;
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
	public static void actualizarLista(GrupoParametroFormularioIva grupoparametroformularioiva,List<GrupoParametroFormularioIva> grupoparametroformularioivas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			GrupoParametroFormularioIva grupoparametroformularioivaEncontrado=null;
			
			for(GrupoParametroFormularioIva grupoparametroformularioivaLocal:grupoparametroformularioivas) {
				if(grupoparametroformularioivaLocal.getId().equals(grupoparametroformularioiva.getId())) {
					grupoparametroformularioivaEncontrado=grupoparametroformularioivaLocal;
					
					grupoparametroformularioivaLocal.setIsChanged(grupoparametroformularioiva.getIsChanged());
					grupoparametroformularioivaLocal.setIsNew(grupoparametroformularioiva.getIsNew());
					grupoparametroformularioivaLocal.setIsDeleted(grupoparametroformularioiva.getIsDeleted());
					
					grupoparametroformularioivaLocal.setGeneralEntityOriginal(grupoparametroformularioiva.getGeneralEntityOriginal());
					
					grupoparametroformularioivaLocal.setId(grupoparametroformularioiva.getId());	
					grupoparametroformularioivaLocal.setid_empresa(grupoparametroformularioiva.getid_empresa());	
					grupoparametroformularioivaLocal.setVersionRow(grupoparametroformularioiva.getVersionRow());	
					grupoparametroformularioivaLocal.setnombre(grupoparametroformularioiva.getnombre());	
					
					
					grupoparametroformularioivaLocal.setParametroFormularioIvas(grupoparametroformularioiva.getParametroFormularioIvas());
					grupoparametroformularioivaLocal.setFormularioIvas(grupoparametroformularioiva.getFormularioIvas());
					
					existe=true;
					break;
				}
			}
			
			if(!grupoparametroformularioiva.getIsDeleted()) {
				if(!existe) {
					grupoparametroformularioivas.add(grupoparametroformularioiva);
				}
			} else {
				if(grupoparametroformularioivaEncontrado!=null && permiteQuitar)  {
					grupoparametroformularioivas.remove(grupoparametroformularioivaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(GrupoParametroFormularioIva grupoparametroformularioiva,List<GrupoParametroFormularioIva> grupoparametroformularioivas) throws Exception {
		try	{			
			for(GrupoParametroFormularioIva grupoparametroformularioivaLocal:grupoparametroformularioivas) {
				if(grupoparametroformularioivaLocal.getId().equals(grupoparametroformularioiva.getId())) {
					grupoparametroformularioivaLocal.setIsSelected(grupoparametroformularioiva.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesGrupoParametroFormularioIva(List<GrupoParametroFormularioIva> grupoparametroformularioivasAux) throws Exception {
		//this.grupoparametroformularioivasAux=grupoparametroformularioivasAux;
		
		for(GrupoParametroFormularioIva grupoparametroformularioivaAux:grupoparametroformularioivasAux) {
			if(grupoparametroformularioivaAux.getIsChanged()) {
				grupoparametroformularioivaAux.setIsChanged(false);
			}		
			
			if(grupoparametroformularioivaAux.getIsNew()) {
				grupoparametroformularioivaAux.setIsNew(false);
			}	
			
			if(grupoparametroformularioivaAux.getIsDeleted()) {
				grupoparametroformularioivaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesGrupoParametroFormularioIva(GrupoParametroFormularioIva grupoparametroformularioivaAux) throws Exception {
		//this.grupoparametroformularioivaAux=grupoparametroformularioivaAux;
		
			if(grupoparametroformularioivaAux.getIsChanged()) {
				grupoparametroformularioivaAux.setIsChanged(false);
			}		
			
			if(grupoparametroformularioivaAux.getIsNew()) {
				grupoparametroformularioivaAux.setIsNew(false);
			}	
			
			if(grupoparametroformularioivaAux.getIsDeleted()) {
				grupoparametroformularioivaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(GrupoParametroFormularioIva grupoparametroformularioivaAsignar,GrupoParametroFormularioIva grupoparametroformularioiva) throws Exception {
		grupoparametroformularioivaAsignar.setId(grupoparametroformularioiva.getId());	
		grupoparametroformularioivaAsignar.setid_empresa(grupoparametroformularioiva.getid_empresa());
		grupoparametroformularioivaAsignar.setempresa_descripcion(grupoparametroformularioiva.getempresa_descripcion());	
		grupoparametroformularioivaAsignar.setVersionRow(grupoparametroformularioiva.getVersionRow());	
		grupoparametroformularioivaAsignar.setnombre(grupoparametroformularioiva.getnombre());	
	}
	
	public static void inicializarGrupoParametroFormularioIva(GrupoParametroFormularioIva grupoparametroformularioiva) throws Exception {
		try {
				grupoparametroformularioiva.setId(0L);	
				grupoparametroformularioiva.setid_empresa(-1L);	
					
				grupoparametroformularioiva.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderGrupoParametroFormularioIva(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(GrupoParametroFormularioIvaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GrupoParametroFormularioIvaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataGrupoParametroFormularioIva(String sTipo,Row row,Workbook workbook,GrupoParametroFormularioIva grupoparametroformularioiva,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(grupoparametroformularioiva.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(grupoparametroformularioiva.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryGrupoParametroFormularioIva=Constantes.SFINALQUERY;
	
	public String getsFinalQueryGrupoParametroFormularioIva() {
		return this.sFinalQueryGrupoParametroFormularioIva;
	}
	
	public void setsFinalQueryGrupoParametroFormularioIva(String sFinalQueryGrupoParametroFormularioIva) {
		this.sFinalQueryGrupoParametroFormularioIva= sFinalQueryGrupoParametroFormularioIva;
	}
	
	public Border resaltarSeleccionarGrupoParametroFormularioIva=null;
	
	public Border setResaltarSeleccionarGrupoParametroFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoParametroFormularioIvaBeanSwingJInternalFrame grupoparametroformularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//grupoparametroformularioivaBeanSwingJInternalFrame.jTtoolBarGrupoParametroFormularioIva.setBorder(borderResaltar);
		
		this.resaltarSeleccionarGrupoParametroFormularioIva= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarGrupoParametroFormularioIva() {
		return this.resaltarSeleccionarGrupoParametroFormularioIva;
	}
	
	public void setResaltarSeleccionarGrupoParametroFormularioIva(Border borderResaltarSeleccionarGrupoParametroFormularioIva) {
		this.resaltarSeleccionarGrupoParametroFormularioIva= borderResaltarSeleccionarGrupoParametroFormularioIva;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridGrupoParametroFormularioIva=null;
	public Boolean mostraridGrupoParametroFormularioIva=true;
	public Boolean activaridGrupoParametroFormularioIva=true;

	public Border resaltarid_empresaGrupoParametroFormularioIva=null;
	public Boolean mostrarid_empresaGrupoParametroFormularioIva=true;
	public Boolean activarid_empresaGrupoParametroFormularioIva=true;
	public Boolean cargarid_empresaGrupoParametroFormularioIva=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaGrupoParametroFormularioIva=false;//ConEventDepend=true

	public Border resaltarnombreGrupoParametroFormularioIva=null;
	public Boolean mostrarnombreGrupoParametroFormularioIva=true;
	public Boolean activarnombreGrupoParametroFormularioIva=true;

	
	

	public Border setResaltaridGrupoParametroFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoParametroFormularioIvaBeanSwingJInternalFrame grupoparametroformularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//grupoparametroformularioivaBeanSwingJInternalFrame.jTtoolBarGrupoParametroFormularioIva.setBorder(borderResaltar);
		
		this.resaltaridGrupoParametroFormularioIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridGrupoParametroFormularioIva() {
		return this.resaltaridGrupoParametroFormularioIva;
	}

	public void setResaltaridGrupoParametroFormularioIva(Border borderResaltar) {
		this.resaltaridGrupoParametroFormularioIva= borderResaltar;
	}

	public Boolean getMostraridGrupoParametroFormularioIva() {
		return this.mostraridGrupoParametroFormularioIva;
	}

	public void setMostraridGrupoParametroFormularioIva(Boolean mostraridGrupoParametroFormularioIva) {
		this.mostraridGrupoParametroFormularioIva= mostraridGrupoParametroFormularioIva;
	}

	public Boolean getActivaridGrupoParametroFormularioIva() {
		return this.activaridGrupoParametroFormularioIva;
	}

	public void setActivaridGrupoParametroFormularioIva(Boolean activaridGrupoParametroFormularioIva) {
		this.activaridGrupoParametroFormularioIva= activaridGrupoParametroFormularioIva;
	}

	public Border setResaltarid_empresaGrupoParametroFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoParametroFormularioIvaBeanSwingJInternalFrame grupoparametroformularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//grupoparametroformularioivaBeanSwingJInternalFrame.jTtoolBarGrupoParametroFormularioIva.setBorder(borderResaltar);
		
		this.resaltarid_empresaGrupoParametroFormularioIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaGrupoParametroFormularioIva() {
		return this.resaltarid_empresaGrupoParametroFormularioIva;
	}

	public void setResaltarid_empresaGrupoParametroFormularioIva(Border borderResaltar) {
		this.resaltarid_empresaGrupoParametroFormularioIva= borderResaltar;
	}

	public Boolean getMostrarid_empresaGrupoParametroFormularioIva() {
		return this.mostrarid_empresaGrupoParametroFormularioIva;
	}

	public void setMostrarid_empresaGrupoParametroFormularioIva(Boolean mostrarid_empresaGrupoParametroFormularioIva) {
		this.mostrarid_empresaGrupoParametroFormularioIva= mostrarid_empresaGrupoParametroFormularioIva;
	}

	public Boolean getActivarid_empresaGrupoParametroFormularioIva() {
		return this.activarid_empresaGrupoParametroFormularioIva;
	}

	public void setActivarid_empresaGrupoParametroFormularioIva(Boolean activarid_empresaGrupoParametroFormularioIva) {
		this.activarid_empresaGrupoParametroFormularioIva= activarid_empresaGrupoParametroFormularioIva;
	}

	public Boolean getCargarid_empresaGrupoParametroFormularioIva() {
		return this.cargarid_empresaGrupoParametroFormularioIva;
	}

	public void setCargarid_empresaGrupoParametroFormularioIva(Boolean cargarid_empresaGrupoParametroFormularioIva) {
		this.cargarid_empresaGrupoParametroFormularioIva= cargarid_empresaGrupoParametroFormularioIva;
	}

	public Border setResaltarnombreGrupoParametroFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoParametroFormularioIvaBeanSwingJInternalFrame grupoparametroformularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//grupoparametroformularioivaBeanSwingJInternalFrame.jTtoolBarGrupoParametroFormularioIva.setBorder(borderResaltar);
		
		this.resaltarnombreGrupoParametroFormularioIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreGrupoParametroFormularioIva() {
		return this.resaltarnombreGrupoParametroFormularioIva;
	}

	public void setResaltarnombreGrupoParametroFormularioIva(Border borderResaltar) {
		this.resaltarnombreGrupoParametroFormularioIva= borderResaltar;
	}

	public Boolean getMostrarnombreGrupoParametroFormularioIva() {
		return this.mostrarnombreGrupoParametroFormularioIva;
	}

	public void setMostrarnombreGrupoParametroFormularioIva(Boolean mostrarnombreGrupoParametroFormularioIva) {
		this.mostrarnombreGrupoParametroFormularioIva= mostrarnombreGrupoParametroFormularioIva;
	}

	public Boolean getActivarnombreGrupoParametroFormularioIva() {
		return this.activarnombreGrupoParametroFormularioIva;
	}

	public void setActivarnombreGrupoParametroFormularioIva(Boolean activarnombreGrupoParametroFormularioIva) {
		this.activarnombreGrupoParametroFormularioIva= activarnombreGrupoParametroFormularioIva;
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
		
		
		this.setMostraridGrupoParametroFormularioIva(esInicial);
		this.setMostrarid_empresaGrupoParametroFormularioIva(esInicial);
		this.setMostrarnombreGrupoParametroFormularioIva(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(GrupoParametroFormularioIvaConstantesFunciones.ID)) {
				this.setMostraridGrupoParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoParametroFormularioIvaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaGrupoParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoParametroFormularioIvaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreGrupoParametroFormularioIva(esAsigna);
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
		
		
		this.setActivaridGrupoParametroFormularioIva(esInicial);
		this.setActivarid_empresaGrupoParametroFormularioIva(esInicial);
		this.setActivarnombreGrupoParametroFormularioIva(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(GrupoParametroFormularioIvaConstantesFunciones.ID)) {
				this.setActivaridGrupoParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoParametroFormularioIvaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaGrupoParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoParametroFormularioIvaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreGrupoParametroFormularioIva(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,GrupoParametroFormularioIvaBeanSwingJInternalFrame grupoparametroformularioivaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridGrupoParametroFormularioIva(esInicial);
		this.setResaltarid_empresaGrupoParametroFormularioIva(esInicial);
		this.setResaltarnombreGrupoParametroFormularioIva(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(GrupoParametroFormularioIvaConstantesFunciones.ID)) {
				this.setResaltaridGrupoParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoParametroFormularioIvaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaGrupoParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(GrupoParametroFormularioIvaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreGrupoParametroFormularioIva(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarParametroFormularioIvaGrupoParametroFormularioIva=null;

	public Border getResaltarParametroFormularioIvaGrupoParametroFormularioIva() {
		return this.resaltarParametroFormularioIvaGrupoParametroFormularioIva;
	}

	public void setResaltarParametroFormularioIvaGrupoParametroFormularioIva(Border borderResaltarParametroFormularioIva) {
		if(borderResaltarParametroFormularioIva!=null) {
			this.resaltarParametroFormularioIvaGrupoParametroFormularioIva= borderResaltarParametroFormularioIva;
		}
	}

	public Border setResaltarParametroFormularioIvaGrupoParametroFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoParametroFormularioIvaBeanSwingJInternalFrame grupoparametroformularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltarParametroFormularioIva=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//grupoparametroformularioivaBeanSwingJInternalFrame.jTtoolBarGrupoParametroFormularioIva.setBorder(borderResaltarParametroFormularioIva);
			
		this.resaltarParametroFormularioIvaGrupoParametroFormularioIva= borderResaltarParametroFormularioIva;

		 return borderResaltarParametroFormularioIva;
	}



	public Boolean mostrarParametroFormularioIvaGrupoParametroFormularioIva=true;

	public Boolean getMostrarParametroFormularioIvaGrupoParametroFormularioIva() {
		return this.mostrarParametroFormularioIvaGrupoParametroFormularioIva;
	}

	public void setMostrarParametroFormularioIvaGrupoParametroFormularioIva(Boolean visibilidadResaltarParametroFormularioIva) {
		this.mostrarParametroFormularioIvaGrupoParametroFormularioIva= visibilidadResaltarParametroFormularioIva;
	}



	public Boolean activarParametroFormularioIvaGrupoParametroFormularioIva=true;

	public Boolean gethabilitarResaltarParametroFormularioIvaGrupoParametroFormularioIva() {
		return this.activarParametroFormularioIvaGrupoParametroFormularioIva;
	}

	public void setActivarParametroFormularioIvaGrupoParametroFormularioIva(Boolean habilitarResaltarParametroFormularioIva) {
		this.activarParametroFormularioIvaGrupoParametroFormularioIva= habilitarResaltarParametroFormularioIva;
	}


	public Border resaltarFormularioIvaGrupoParametroFormularioIva=null;

	public Border getResaltarFormularioIvaGrupoParametroFormularioIva() {
		return this.resaltarFormularioIvaGrupoParametroFormularioIva;
	}

	public void setResaltarFormularioIvaGrupoParametroFormularioIva(Border borderResaltarFormularioIva) {
		if(borderResaltarFormularioIva!=null) {
			this.resaltarFormularioIvaGrupoParametroFormularioIva= borderResaltarFormularioIva;
		}
	}

	public Border setResaltarFormularioIvaGrupoParametroFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoParametroFormularioIvaBeanSwingJInternalFrame grupoparametroformularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltarFormularioIva=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//grupoparametroformularioivaBeanSwingJInternalFrame.jTtoolBarGrupoParametroFormularioIva.setBorder(borderResaltarFormularioIva);
			
		this.resaltarFormularioIvaGrupoParametroFormularioIva= borderResaltarFormularioIva;

		 return borderResaltarFormularioIva;
	}



	public Boolean mostrarFormularioIvaGrupoParametroFormularioIva=true;

	public Boolean getMostrarFormularioIvaGrupoParametroFormularioIva() {
		return this.mostrarFormularioIvaGrupoParametroFormularioIva;
	}

	public void setMostrarFormularioIvaGrupoParametroFormularioIva(Boolean visibilidadResaltarFormularioIva) {
		this.mostrarFormularioIvaGrupoParametroFormularioIva= visibilidadResaltarFormularioIva;
	}



	public Boolean activarFormularioIvaGrupoParametroFormularioIva=true;

	public Boolean gethabilitarResaltarFormularioIvaGrupoParametroFormularioIva() {
		return this.activarFormularioIvaGrupoParametroFormularioIva;
	}

	public void setActivarFormularioIvaGrupoParametroFormularioIva(Boolean habilitarResaltarFormularioIva) {
		this.activarFormularioIvaGrupoParametroFormularioIva= habilitarResaltarFormularioIva;
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

		this.setMostrarParametroFormularioIvaGrupoParametroFormularioIva(esInicial);
		this.setMostrarFormularioIvaGrupoParametroFormularioIva(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ParametroFormularioIva.class)) {
				this.setMostrarParametroFormularioIvaGrupoParametroFormularioIva(esAsigna);
				continue;
			}

			if(clase.clas.equals(FormularioIva.class)) {
				this.setMostrarFormularioIvaGrupoParametroFormularioIva(esAsigna);
				continue;
			}
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

		this.setActivarParametroFormularioIvaGrupoParametroFormularioIva(esInicial);
		this.setActivarFormularioIvaGrupoParametroFormularioIva(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ParametroFormularioIva.class)) {
				this.setActivarParametroFormularioIvaGrupoParametroFormularioIva(esAsigna);
				continue;
			}

			if(clase.clas.equals(FormularioIva.class)) {
				this.setActivarFormularioIvaGrupoParametroFormularioIva(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,GrupoParametroFormularioIvaBeanSwingJInternalFrame grupoparametroformularioivaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarParametroFormularioIvaGrupoParametroFormularioIva(esInicial);
		this.setResaltarFormularioIvaGrupoParametroFormularioIva(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ParametroFormularioIva.class)) {
				this.setResaltarParametroFormularioIvaGrupoParametroFormularioIva(esAsigna);
				continue;
			}

			if(clase.clas.equals(FormularioIva.class)) {
				this.setResaltarFormularioIvaGrupoParametroFormularioIva(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorIdGrupoParametroFormularioIva=true;

	public Boolean getMostrarBusquedaPorIdGrupoParametroFormularioIva() {
		return this.mostrarBusquedaPorIdGrupoParametroFormularioIva;
	}

	public void setMostrarBusquedaPorIdGrupoParametroFormularioIva(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorIdGrupoParametroFormularioIva= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreGrupoParametroFormularioIva=true;

	public Boolean getMostrarBusquedaPorNombreGrupoParametroFormularioIva() {
		return this.mostrarBusquedaPorNombreGrupoParametroFormularioIva;
	}

	public void setMostrarBusquedaPorNombreGrupoParametroFormularioIva(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreGrupoParametroFormularioIva= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaGrupoParametroFormularioIva=true;

	public Boolean getMostrarFK_IdEmpresaGrupoParametroFormularioIva() {
		return this.mostrarFK_IdEmpresaGrupoParametroFormularioIva;
	}

	public void setMostrarFK_IdEmpresaGrupoParametroFormularioIva(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaGrupoParametroFormularioIva= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorIdGrupoParametroFormularioIva=true;

	public Boolean getActivarBusquedaPorIdGrupoParametroFormularioIva() {
		return this.activarBusquedaPorIdGrupoParametroFormularioIva;
	}

	public void setActivarBusquedaPorIdGrupoParametroFormularioIva(Boolean habilitarResaltar) {
		this.activarBusquedaPorIdGrupoParametroFormularioIva= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreGrupoParametroFormularioIva=true;

	public Boolean getActivarBusquedaPorNombreGrupoParametroFormularioIva() {
		return this.activarBusquedaPorNombreGrupoParametroFormularioIva;
	}

	public void setActivarBusquedaPorNombreGrupoParametroFormularioIva(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreGrupoParametroFormularioIva= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaGrupoParametroFormularioIva=true;

	public Boolean getActivarFK_IdEmpresaGrupoParametroFormularioIva() {
		return this.activarFK_IdEmpresaGrupoParametroFormularioIva;
	}

	public void setActivarFK_IdEmpresaGrupoParametroFormularioIva(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaGrupoParametroFormularioIva= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorIdGrupoParametroFormularioIva=null;

	public Border getResaltarBusquedaPorIdGrupoParametroFormularioIva() {
		return this.resaltarBusquedaPorIdGrupoParametroFormularioIva;
	}

	public void setResaltarBusquedaPorIdGrupoParametroFormularioIva(Border borderResaltar) {
		this.resaltarBusquedaPorIdGrupoParametroFormularioIva= borderResaltar;
	}

	public void setResaltarBusquedaPorIdGrupoParametroFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoParametroFormularioIvaBeanSwingJInternalFrame grupoparametroformularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorIdGrupoParametroFormularioIva= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreGrupoParametroFormularioIva=null;

	public Border getResaltarBusquedaPorNombreGrupoParametroFormularioIva() {
		return this.resaltarBusquedaPorNombreGrupoParametroFormularioIva;
	}

	public void setResaltarBusquedaPorNombreGrupoParametroFormularioIva(Border borderResaltar) {
		this.resaltarBusquedaPorNombreGrupoParametroFormularioIva= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreGrupoParametroFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoParametroFormularioIvaBeanSwingJInternalFrame grupoparametroformularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreGrupoParametroFormularioIva= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaGrupoParametroFormularioIva=null;

	public Border getResaltarFK_IdEmpresaGrupoParametroFormularioIva() {
		return this.resaltarFK_IdEmpresaGrupoParametroFormularioIva;
	}

	public void setResaltarFK_IdEmpresaGrupoParametroFormularioIva(Border borderResaltar) {
		this.resaltarFK_IdEmpresaGrupoParametroFormularioIva= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaGrupoParametroFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*GrupoParametroFormularioIvaBeanSwingJInternalFrame grupoparametroformularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaGrupoParametroFormularioIva= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}