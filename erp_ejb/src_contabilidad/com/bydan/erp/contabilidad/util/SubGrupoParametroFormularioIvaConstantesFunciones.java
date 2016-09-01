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


import com.bydan.erp.contabilidad.util.SubGrupoParametroFormularioIvaConstantesFunciones;
import com.bydan.erp.contabilidad.util.SubGrupoParametroFormularioIvaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.SubGrupoParametroFormularioIvaParameterGeneral;

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
final public class SubGrupoParametroFormularioIvaConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="SubGrupoParametroFormularioIva";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="SubGrupoParametroFormularioIva"+SubGrupoParametroFormularioIvaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="SubGrupoParametroFormularioIvaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="SubGrupoParametroFormularioIvaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=SubGrupoParametroFormularioIvaConstantesFunciones.SCHEMA+"_"+SubGrupoParametroFormularioIvaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/SubGrupoParametroFormularioIvaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=SubGrupoParametroFormularioIvaConstantesFunciones.SCHEMA+"_"+SubGrupoParametroFormularioIvaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=SubGrupoParametroFormularioIvaConstantesFunciones.SCHEMA+"_"+SubGrupoParametroFormularioIvaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/SubGrupoParametroFormularioIvaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=SubGrupoParametroFormularioIvaConstantesFunciones.SCHEMA+"_"+SubGrupoParametroFormularioIvaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SubGrupoParametroFormularioIvaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/SubGrupoParametroFormularioIvaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SubGrupoParametroFormularioIvaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SubGrupoParametroFormularioIvaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/SubGrupoParametroFormularioIvaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+SubGrupoParametroFormularioIvaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=SubGrupoParametroFormularioIvaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+SubGrupoParametroFormularioIvaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=SubGrupoParametroFormularioIvaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+SubGrupoParametroFormularioIvaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Sub Grupo Parametro Formulario Iva s";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Sub Grupo Parametro Formulario Iva ";
	public static final String SCLASSWEBTITULO_LOWER="Sub Grupo Parametro Formulario Iva";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="SubGrupoParametroFormularioIva";
	public static final String OBJECTNAME="subgrupoparametroformularioiva";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="sub_grupo_parametro_formulario_iva";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select subgrupoparametroformularioiva from "+SubGrupoParametroFormularioIvaConstantesFunciones.SPERSISTENCENAME+" subgrupoparametroformularioiva";
	public static String QUERYSELECTNATIVE="select "+SubGrupoParametroFormularioIvaConstantesFunciones.SCHEMA+"."+SubGrupoParametroFormularioIvaConstantesFunciones.TABLENAME+".id,"+SubGrupoParametroFormularioIvaConstantesFunciones.SCHEMA+"."+SubGrupoParametroFormularioIvaConstantesFunciones.TABLENAME+".id_empresa,"+SubGrupoParametroFormularioIvaConstantesFunciones.SCHEMA+"."+SubGrupoParametroFormularioIvaConstantesFunciones.TABLENAME+".version_row,"+SubGrupoParametroFormularioIvaConstantesFunciones.SCHEMA+"."+SubGrupoParametroFormularioIvaConstantesFunciones.TABLENAME+".nombre from "+SubGrupoParametroFormularioIvaConstantesFunciones.SCHEMA+"."+SubGrupoParametroFormularioIvaConstantesFunciones.TABLENAME;//+" as "+SubGrupoParametroFormularioIvaConstantesFunciones.TABLENAME;
	
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
	
	public static String getSubGrupoParametroFormularioIvaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(SubGrupoParametroFormularioIvaConstantesFunciones.IDEMPRESA)) {sLabelColumna=SubGrupoParametroFormularioIvaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(SubGrupoParametroFormularioIvaConstantesFunciones.NOMBRE)) {sLabelColumna=SubGrupoParametroFormularioIvaConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getSubGrupoParametroFormularioIvaDescripcion(SubGrupoParametroFormularioIva subgrupoparametroformularioiva) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(subgrupoparametroformularioiva !=null/* && subgrupoparametroformularioiva.getId()!=0*/) {
			sDescripcion=subgrupoparametroformularioiva.getnombre();//subgrupoparametroformularioivasubgrupoparametroformularioiva.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getSubGrupoParametroFormularioIvaDescripcionDetallado(SubGrupoParametroFormularioIva subgrupoparametroformularioiva) {
		String sDescripcion="";
			
		sDescripcion+=SubGrupoParametroFormularioIvaConstantesFunciones.ID+"=";
		sDescripcion+=subgrupoparametroformularioiva.getId().toString()+",";
		sDescripcion+=SubGrupoParametroFormularioIvaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=subgrupoparametroformularioiva.getid_empresa().toString()+",";
		sDescripcion+=SubGrupoParametroFormularioIvaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=subgrupoparametroformularioiva.getVersionRow().toString()+",";
		sDescripcion+=SubGrupoParametroFormularioIvaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=subgrupoparametroformularioiva.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setSubGrupoParametroFormularioIvaDescripcion(SubGrupoParametroFormularioIva subgrupoparametroformularioiva,String sValor) throws Exception {			
		if(subgrupoparametroformularioiva !=null) {
			subgrupoparametroformularioiva.setnombre(sValor);;//subgrupoparametroformularioivasubgrupoparametroformularioiva.getnombre().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosSubGrupoParametroFormularioIva(SubGrupoParametroFormularioIva subgrupoparametroformularioiva,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		subgrupoparametroformularioiva.setnombre(subgrupoparametroformularioiva.getnombre().trim());
	}
	
	public static void quitarEspaciosSubGrupoParametroFormularioIvas(List<SubGrupoParametroFormularioIva> subgrupoparametroformularioivas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(SubGrupoParametroFormularioIva subgrupoparametroformularioiva: subgrupoparametroformularioivas) {
			subgrupoparametroformularioiva.setnombre(subgrupoparametroformularioiva.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresSubGrupoParametroFormularioIva(SubGrupoParametroFormularioIva subgrupoparametroformularioiva,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && subgrupoparametroformularioiva.getConCambioAuxiliar()) {
			subgrupoparametroformularioiva.setIsDeleted(subgrupoparametroformularioiva.getIsDeletedAuxiliar());	
			subgrupoparametroformularioiva.setIsNew(subgrupoparametroformularioiva.getIsNewAuxiliar());	
			subgrupoparametroformularioiva.setIsChanged(subgrupoparametroformularioiva.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			subgrupoparametroformularioiva.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			subgrupoparametroformularioiva.setIsDeletedAuxiliar(false);	
			subgrupoparametroformularioiva.setIsNewAuxiliar(false);	
			subgrupoparametroformularioiva.setIsChangedAuxiliar(false);
			
			subgrupoparametroformularioiva.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresSubGrupoParametroFormularioIvas(List<SubGrupoParametroFormularioIva> subgrupoparametroformularioivas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(SubGrupoParametroFormularioIva subgrupoparametroformularioiva : subgrupoparametroformularioivas) {
			if(conAsignarBase && subgrupoparametroformularioiva.getConCambioAuxiliar()) {
				subgrupoparametroformularioiva.setIsDeleted(subgrupoparametroformularioiva.getIsDeletedAuxiliar());	
				subgrupoparametroformularioiva.setIsNew(subgrupoparametroformularioiva.getIsNewAuxiliar());	
				subgrupoparametroformularioiva.setIsChanged(subgrupoparametroformularioiva.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				subgrupoparametroformularioiva.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				subgrupoparametroformularioiva.setIsDeletedAuxiliar(false);	
				subgrupoparametroformularioiva.setIsNewAuxiliar(false);	
				subgrupoparametroformularioiva.setIsChangedAuxiliar(false);
				
				subgrupoparametroformularioiva.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresSubGrupoParametroFormularioIva(SubGrupoParametroFormularioIva subgrupoparametroformularioiva,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresSubGrupoParametroFormularioIvas(List<SubGrupoParametroFormularioIva> subgrupoparametroformularioivas,Boolean conEnteros) throws Exception  {
		
		for(SubGrupoParametroFormularioIva subgrupoparametroformularioiva: subgrupoparametroformularioivas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaSubGrupoParametroFormularioIva(List<SubGrupoParametroFormularioIva> subgrupoparametroformularioivas,SubGrupoParametroFormularioIva subgrupoparametroformularioivaAux) throws Exception  {
		SubGrupoParametroFormularioIvaConstantesFunciones.InicializarValoresSubGrupoParametroFormularioIva(subgrupoparametroformularioivaAux,true);
		
		for(SubGrupoParametroFormularioIva subgrupoparametroformularioiva: subgrupoparametroformularioivas) {
			if(subgrupoparametroformularioiva.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesSubGrupoParametroFormularioIva(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=SubGrupoParametroFormularioIvaConstantesFunciones.getArrayColumnasGlobalesSubGrupoParametroFormularioIva(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesSubGrupoParametroFormularioIva(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(SubGrupoParametroFormularioIvaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(SubGrupoParametroFormularioIvaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoSubGrupoParametroFormularioIva(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<SubGrupoParametroFormularioIva> subgrupoparametroformularioivas,SubGrupoParametroFormularioIva subgrupoparametroformularioiva,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(SubGrupoParametroFormularioIva subgrupoparametroformularioivaAux: subgrupoparametroformularioivas) {
			if(subgrupoparametroformularioivaAux!=null && subgrupoparametroformularioiva!=null) {
				if((subgrupoparametroformularioivaAux.getId()==null && subgrupoparametroformularioiva.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(subgrupoparametroformularioivaAux.getId()!=null && subgrupoparametroformularioiva.getId()!=null){
					if(subgrupoparametroformularioivaAux.getId().equals(subgrupoparametroformularioiva.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaSubGrupoParametroFormularioIva(List<SubGrupoParametroFormularioIva> subgrupoparametroformularioivas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(SubGrupoParametroFormularioIva subgrupoparametroformularioiva: subgrupoparametroformularioivas) {			
			if(subgrupoparametroformularioiva.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaSubGrupoParametroFormularioIva() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,SubGrupoParametroFormularioIvaConstantesFunciones.LABEL_ID, SubGrupoParametroFormularioIvaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubGrupoParametroFormularioIvaConstantesFunciones.LABEL_IDEMPRESA, SubGrupoParametroFormularioIvaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubGrupoParametroFormularioIvaConstantesFunciones.LABEL_VERSIONROW, SubGrupoParametroFormularioIvaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,SubGrupoParametroFormularioIvaConstantesFunciones.LABEL_NOMBRE, SubGrupoParametroFormularioIvaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasSubGrupoParametroFormularioIva() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=SubGrupoParametroFormularioIvaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubGrupoParametroFormularioIvaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubGrupoParametroFormularioIvaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=SubGrupoParametroFormularioIvaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSubGrupoParametroFormularioIva() throws Exception  {
		return SubGrupoParametroFormularioIvaConstantesFunciones.getTiposSeleccionarSubGrupoParametroFormularioIva(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSubGrupoParametroFormularioIva(Boolean conFk) throws Exception  {
		return SubGrupoParametroFormularioIvaConstantesFunciones.getTiposSeleccionarSubGrupoParametroFormularioIva(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarSubGrupoParametroFormularioIva(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(SubGrupoParametroFormularioIvaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(SubGrupoParametroFormularioIvaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(SubGrupoParametroFormularioIvaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(SubGrupoParametroFormularioIvaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesSubGrupoParametroFormularioIva(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesSubGrupoParametroFormularioIva(SubGrupoParametroFormularioIva subgrupoparametroformularioivaAux) throws Exception {
		
			subgrupoparametroformularioivaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(subgrupoparametroformularioivaAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesSubGrupoParametroFormularioIva(List<SubGrupoParametroFormularioIva> subgrupoparametroformularioivasTemp) throws Exception {
		for(SubGrupoParametroFormularioIva subgrupoparametroformularioivaAux:subgrupoparametroformularioivasTemp) {
			
			subgrupoparametroformularioivaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(subgrupoparametroformularioivaAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfSubGrupoParametroFormularioIva(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfSubGrupoParametroFormularioIva(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfSubGrupoParametroFormularioIva(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return SubGrupoParametroFormularioIvaConstantesFunciones.getClassesRelationshipsOfSubGrupoParametroFormularioIva(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfSubGrupoParametroFormularioIva(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(ParametroFormularioIva.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(ParametroFormularioIva.class)) {
						classes.add(new Classe(ParametroFormularioIva.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfSubGrupoParametroFormularioIva(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return SubGrupoParametroFormularioIvaConstantesFunciones.getClassesRelationshipsFromStringsOfSubGrupoParametroFormularioIva(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfSubGrupoParametroFormularioIva(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(ParametroFormularioIva.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroFormularioIva.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(ParametroFormularioIva.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroFormularioIva.class)); continue;
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
	public static void actualizarLista(SubGrupoParametroFormularioIva subgrupoparametroformularioiva,List<SubGrupoParametroFormularioIva> subgrupoparametroformularioivas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			SubGrupoParametroFormularioIva subgrupoparametroformularioivaEncontrado=null;
			
			for(SubGrupoParametroFormularioIva subgrupoparametroformularioivaLocal:subgrupoparametroformularioivas) {
				if(subgrupoparametroformularioivaLocal.getId().equals(subgrupoparametroformularioiva.getId())) {
					subgrupoparametroformularioivaEncontrado=subgrupoparametroformularioivaLocal;
					
					subgrupoparametroformularioivaLocal.setIsChanged(subgrupoparametroformularioiva.getIsChanged());
					subgrupoparametroformularioivaLocal.setIsNew(subgrupoparametroformularioiva.getIsNew());
					subgrupoparametroformularioivaLocal.setIsDeleted(subgrupoparametroformularioiva.getIsDeleted());
					
					subgrupoparametroformularioivaLocal.setGeneralEntityOriginal(subgrupoparametroformularioiva.getGeneralEntityOriginal());
					
					subgrupoparametroformularioivaLocal.setId(subgrupoparametroformularioiva.getId());	
					subgrupoparametroformularioivaLocal.setid_empresa(subgrupoparametroformularioiva.getid_empresa());	
					subgrupoparametroformularioivaLocal.setVersionRow(subgrupoparametroformularioiva.getVersionRow());	
					subgrupoparametroformularioivaLocal.setnombre(subgrupoparametroformularioiva.getnombre());	
					
					
					subgrupoparametroformularioivaLocal.setParametroFormularioIvas(subgrupoparametroformularioiva.getParametroFormularioIvas());
					
					existe=true;
					break;
				}
			}
			
			if(!subgrupoparametroformularioiva.getIsDeleted()) {
				if(!existe) {
					subgrupoparametroformularioivas.add(subgrupoparametroformularioiva);
				}
			} else {
				if(subgrupoparametroformularioivaEncontrado!=null && permiteQuitar)  {
					subgrupoparametroformularioivas.remove(subgrupoparametroformularioivaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(SubGrupoParametroFormularioIva subgrupoparametroformularioiva,List<SubGrupoParametroFormularioIva> subgrupoparametroformularioivas) throws Exception {
		try	{			
			for(SubGrupoParametroFormularioIva subgrupoparametroformularioivaLocal:subgrupoparametroformularioivas) {
				if(subgrupoparametroformularioivaLocal.getId().equals(subgrupoparametroformularioiva.getId())) {
					subgrupoparametroformularioivaLocal.setIsSelected(subgrupoparametroformularioiva.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesSubGrupoParametroFormularioIva(List<SubGrupoParametroFormularioIva> subgrupoparametroformularioivasAux) throws Exception {
		//this.subgrupoparametroformularioivasAux=subgrupoparametroformularioivasAux;
		
		for(SubGrupoParametroFormularioIva subgrupoparametroformularioivaAux:subgrupoparametroformularioivasAux) {
			if(subgrupoparametroformularioivaAux.getIsChanged()) {
				subgrupoparametroformularioivaAux.setIsChanged(false);
			}		
			
			if(subgrupoparametroformularioivaAux.getIsNew()) {
				subgrupoparametroformularioivaAux.setIsNew(false);
			}	
			
			if(subgrupoparametroformularioivaAux.getIsDeleted()) {
				subgrupoparametroformularioivaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesSubGrupoParametroFormularioIva(SubGrupoParametroFormularioIva subgrupoparametroformularioivaAux) throws Exception {
		//this.subgrupoparametroformularioivaAux=subgrupoparametroformularioivaAux;
		
			if(subgrupoparametroformularioivaAux.getIsChanged()) {
				subgrupoparametroformularioivaAux.setIsChanged(false);
			}		
			
			if(subgrupoparametroformularioivaAux.getIsNew()) {
				subgrupoparametroformularioivaAux.setIsNew(false);
			}	
			
			if(subgrupoparametroformularioivaAux.getIsDeleted()) {
				subgrupoparametroformularioivaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(SubGrupoParametroFormularioIva subgrupoparametroformularioivaAsignar,SubGrupoParametroFormularioIva subgrupoparametroformularioiva) throws Exception {
		subgrupoparametroformularioivaAsignar.setId(subgrupoparametroformularioiva.getId());	
		subgrupoparametroformularioivaAsignar.setid_empresa(subgrupoparametroformularioiva.getid_empresa());
		subgrupoparametroformularioivaAsignar.setempresa_descripcion(subgrupoparametroformularioiva.getempresa_descripcion());	
		subgrupoparametroformularioivaAsignar.setVersionRow(subgrupoparametroformularioiva.getVersionRow());	
		subgrupoparametroformularioivaAsignar.setnombre(subgrupoparametroformularioiva.getnombre());	
	}
	
	public static void inicializarSubGrupoParametroFormularioIva(SubGrupoParametroFormularioIva subgrupoparametroformularioiva) throws Exception {
		try {
				subgrupoparametroformularioiva.setId(0L);	
				subgrupoparametroformularioiva.setid_empresa(-1L);	
					
				subgrupoparametroformularioiva.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderSubGrupoParametroFormularioIva(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(SubGrupoParametroFormularioIvaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(SubGrupoParametroFormularioIvaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataSubGrupoParametroFormularioIva(String sTipo,Row row,Workbook workbook,SubGrupoParametroFormularioIva subgrupoparametroformularioiva,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(subgrupoparametroformularioiva.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(subgrupoparametroformularioiva.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQuerySubGrupoParametroFormularioIva=Constantes.SFINALQUERY;
	
	public String getsFinalQuerySubGrupoParametroFormularioIva() {
		return this.sFinalQuerySubGrupoParametroFormularioIva;
	}
	
	public void setsFinalQuerySubGrupoParametroFormularioIva(String sFinalQuerySubGrupoParametroFormularioIva) {
		this.sFinalQuerySubGrupoParametroFormularioIva= sFinalQuerySubGrupoParametroFormularioIva;
	}
	
	public Border resaltarSeleccionarSubGrupoParametroFormularioIva=null;
	
	public Border setResaltarSeleccionarSubGrupoParametroFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*SubGrupoParametroFormularioIvaBeanSwingJInternalFrame subgrupoparametroformularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//subgrupoparametroformularioivaBeanSwingJInternalFrame.jTtoolBarSubGrupoParametroFormularioIva.setBorder(borderResaltar);
		
		this.resaltarSeleccionarSubGrupoParametroFormularioIva= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarSubGrupoParametroFormularioIva() {
		return this.resaltarSeleccionarSubGrupoParametroFormularioIva;
	}
	
	public void setResaltarSeleccionarSubGrupoParametroFormularioIva(Border borderResaltarSeleccionarSubGrupoParametroFormularioIva) {
		this.resaltarSeleccionarSubGrupoParametroFormularioIva= borderResaltarSeleccionarSubGrupoParametroFormularioIva;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridSubGrupoParametroFormularioIva=null;
	public Boolean mostraridSubGrupoParametroFormularioIva=true;
	public Boolean activaridSubGrupoParametroFormularioIva=true;

	public Border resaltarid_empresaSubGrupoParametroFormularioIva=null;
	public Boolean mostrarid_empresaSubGrupoParametroFormularioIva=true;
	public Boolean activarid_empresaSubGrupoParametroFormularioIva=true;
	public Boolean cargarid_empresaSubGrupoParametroFormularioIva=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaSubGrupoParametroFormularioIva=false;//ConEventDepend=true

	public Border resaltarnombreSubGrupoParametroFormularioIva=null;
	public Boolean mostrarnombreSubGrupoParametroFormularioIva=true;
	public Boolean activarnombreSubGrupoParametroFormularioIva=true;

	
	

	public Border setResaltaridSubGrupoParametroFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*SubGrupoParametroFormularioIvaBeanSwingJInternalFrame subgrupoparametroformularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subgrupoparametroformularioivaBeanSwingJInternalFrame.jTtoolBarSubGrupoParametroFormularioIva.setBorder(borderResaltar);
		
		this.resaltaridSubGrupoParametroFormularioIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridSubGrupoParametroFormularioIva() {
		return this.resaltaridSubGrupoParametroFormularioIva;
	}

	public void setResaltaridSubGrupoParametroFormularioIva(Border borderResaltar) {
		this.resaltaridSubGrupoParametroFormularioIva= borderResaltar;
	}

	public Boolean getMostraridSubGrupoParametroFormularioIva() {
		return this.mostraridSubGrupoParametroFormularioIva;
	}

	public void setMostraridSubGrupoParametroFormularioIva(Boolean mostraridSubGrupoParametroFormularioIva) {
		this.mostraridSubGrupoParametroFormularioIva= mostraridSubGrupoParametroFormularioIva;
	}

	public Boolean getActivaridSubGrupoParametroFormularioIva() {
		return this.activaridSubGrupoParametroFormularioIva;
	}

	public void setActivaridSubGrupoParametroFormularioIva(Boolean activaridSubGrupoParametroFormularioIva) {
		this.activaridSubGrupoParametroFormularioIva= activaridSubGrupoParametroFormularioIva;
	}

	public Border setResaltarid_empresaSubGrupoParametroFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*SubGrupoParametroFormularioIvaBeanSwingJInternalFrame subgrupoparametroformularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subgrupoparametroformularioivaBeanSwingJInternalFrame.jTtoolBarSubGrupoParametroFormularioIva.setBorder(borderResaltar);
		
		this.resaltarid_empresaSubGrupoParametroFormularioIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaSubGrupoParametroFormularioIva() {
		return this.resaltarid_empresaSubGrupoParametroFormularioIva;
	}

	public void setResaltarid_empresaSubGrupoParametroFormularioIva(Border borderResaltar) {
		this.resaltarid_empresaSubGrupoParametroFormularioIva= borderResaltar;
	}

	public Boolean getMostrarid_empresaSubGrupoParametroFormularioIva() {
		return this.mostrarid_empresaSubGrupoParametroFormularioIva;
	}

	public void setMostrarid_empresaSubGrupoParametroFormularioIva(Boolean mostrarid_empresaSubGrupoParametroFormularioIva) {
		this.mostrarid_empresaSubGrupoParametroFormularioIva= mostrarid_empresaSubGrupoParametroFormularioIva;
	}

	public Boolean getActivarid_empresaSubGrupoParametroFormularioIva() {
		return this.activarid_empresaSubGrupoParametroFormularioIva;
	}

	public void setActivarid_empresaSubGrupoParametroFormularioIva(Boolean activarid_empresaSubGrupoParametroFormularioIva) {
		this.activarid_empresaSubGrupoParametroFormularioIva= activarid_empresaSubGrupoParametroFormularioIva;
	}

	public Boolean getCargarid_empresaSubGrupoParametroFormularioIva() {
		return this.cargarid_empresaSubGrupoParametroFormularioIva;
	}

	public void setCargarid_empresaSubGrupoParametroFormularioIva(Boolean cargarid_empresaSubGrupoParametroFormularioIva) {
		this.cargarid_empresaSubGrupoParametroFormularioIva= cargarid_empresaSubGrupoParametroFormularioIva;
	}

	public Border setResaltarnombreSubGrupoParametroFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*SubGrupoParametroFormularioIvaBeanSwingJInternalFrame subgrupoparametroformularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//subgrupoparametroformularioivaBeanSwingJInternalFrame.jTtoolBarSubGrupoParametroFormularioIva.setBorder(borderResaltar);
		
		this.resaltarnombreSubGrupoParametroFormularioIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreSubGrupoParametroFormularioIva() {
		return this.resaltarnombreSubGrupoParametroFormularioIva;
	}

	public void setResaltarnombreSubGrupoParametroFormularioIva(Border borderResaltar) {
		this.resaltarnombreSubGrupoParametroFormularioIva= borderResaltar;
	}

	public Boolean getMostrarnombreSubGrupoParametroFormularioIva() {
		return this.mostrarnombreSubGrupoParametroFormularioIva;
	}

	public void setMostrarnombreSubGrupoParametroFormularioIva(Boolean mostrarnombreSubGrupoParametroFormularioIva) {
		this.mostrarnombreSubGrupoParametroFormularioIva= mostrarnombreSubGrupoParametroFormularioIva;
	}

	public Boolean getActivarnombreSubGrupoParametroFormularioIva() {
		return this.activarnombreSubGrupoParametroFormularioIva;
	}

	public void setActivarnombreSubGrupoParametroFormularioIva(Boolean activarnombreSubGrupoParametroFormularioIva) {
		this.activarnombreSubGrupoParametroFormularioIva= activarnombreSubGrupoParametroFormularioIva;
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
		
		
		this.setMostraridSubGrupoParametroFormularioIva(esInicial);
		this.setMostrarid_empresaSubGrupoParametroFormularioIva(esInicial);
		this.setMostrarnombreSubGrupoParametroFormularioIva(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SubGrupoParametroFormularioIvaConstantesFunciones.ID)) {
				this.setMostraridSubGrupoParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubGrupoParametroFormularioIvaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaSubGrupoParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubGrupoParametroFormularioIvaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreSubGrupoParametroFormularioIva(esAsigna);
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
		
		
		this.setActivaridSubGrupoParametroFormularioIva(esInicial);
		this.setActivarid_empresaSubGrupoParametroFormularioIva(esInicial);
		this.setActivarnombreSubGrupoParametroFormularioIva(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SubGrupoParametroFormularioIvaConstantesFunciones.ID)) {
				this.setActivaridSubGrupoParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubGrupoParametroFormularioIvaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaSubGrupoParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubGrupoParametroFormularioIvaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreSubGrupoParametroFormularioIva(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,SubGrupoParametroFormularioIvaBeanSwingJInternalFrame subgrupoparametroformularioivaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridSubGrupoParametroFormularioIva(esInicial);
		this.setResaltarid_empresaSubGrupoParametroFormularioIva(esInicial);
		this.setResaltarnombreSubGrupoParametroFormularioIva(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(SubGrupoParametroFormularioIvaConstantesFunciones.ID)) {
				this.setResaltaridSubGrupoParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubGrupoParametroFormularioIvaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaSubGrupoParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(SubGrupoParametroFormularioIvaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreSubGrupoParametroFormularioIva(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarParametroFormularioIvaSubGrupoParametroFormularioIva=null;

	public Border getResaltarParametroFormularioIvaSubGrupoParametroFormularioIva() {
		return this.resaltarParametroFormularioIvaSubGrupoParametroFormularioIva;
	}

	public void setResaltarParametroFormularioIvaSubGrupoParametroFormularioIva(Border borderResaltarParametroFormularioIva) {
		if(borderResaltarParametroFormularioIva!=null) {
			this.resaltarParametroFormularioIvaSubGrupoParametroFormularioIva= borderResaltarParametroFormularioIva;
		}
	}

	public Border setResaltarParametroFormularioIvaSubGrupoParametroFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*SubGrupoParametroFormularioIvaBeanSwingJInternalFrame subgrupoparametroformularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltarParametroFormularioIva=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//subgrupoparametroformularioivaBeanSwingJInternalFrame.jTtoolBarSubGrupoParametroFormularioIva.setBorder(borderResaltarParametroFormularioIva);
			
		this.resaltarParametroFormularioIvaSubGrupoParametroFormularioIva= borderResaltarParametroFormularioIva;

		 return borderResaltarParametroFormularioIva;
	}



	public Boolean mostrarParametroFormularioIvaSubGrupoParametroFormularioIva=true;

	public Boolean getMostrarParametroFormularioIvaSubGrupoParametroFormularioIva() {
		return this.mostrarParametroFormularioIvaSubGrupoParametroFormularioIva;
	}

	public void setMostrarParametroFormularioIvaSubGrupoParametroFormularioIva(Boolean visibilidadResaltarParametroFormularioIva) {
		this.mostrarParametroFormularioIvaSubGrupoParametroFormularioIva= visibilidadResaltarParametroFormularioIva;
	}



	public Boolean activarParametroFormularioIvaSubGrupoParametroFormularioIva=true;

	public Boolean gethabilitarResaltarParametroFormularioIvaSubGrupoParametroFormularioIva() {
		return this.activarParametroFormularioIvaSubGrupoParametroFormularioIva;
	}

	public void setActivarParametroFormularioIvaSubGrupoParametroFormularioIva(Boolean habilitarResaltarParametroFormularioIva) {
		this.activarParametroFormularioIvaSubGrupoParametroFormularioIva= habilitarResaltarParametroFormularioIva;
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

		this.setMostrarParametroFormularioIvaSubGrupoParametroFormularioIva(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ParametroFormularioIva.class)) {
				this.setMostrarParametroFormularioIvaSubGrupoParametroFormularioIva(esAsigna);
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

		this.setActivarParametroFormularioIvaSubGrupoParametroFormularioIva(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ParametroFormularioIva.class)) {
				this.setActivarParametroFormularioIvaSubGrupoParametroFormularioIva(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,SubGrupoParametroFormularioIvaBeanSwingJInternalFrame subgrupoparametroformularioivaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarParametroFormularioIvaSubGrupoParametroFormularioIva(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ParametroFormularioIva.class)) {
				this.setResaltarParametroFormularioIvaSubGrupoParametroFormularioIva(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarBusquedaPorIdSubGrupoParametroFormularioIva=true;

	public Boolean getMostrarBusquedaPorIdSubGrupoParametroFormularioIva() {
		return this.mostrarBusquedaPorIdSubGrupoParametroFormularioIva;
	}

	public void setMostrarBusquedaPorIdSubGrupoParametroFormularioIva(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorIdSubGrupoParametroFormularioIva= visibilidadResaltar;
	}

	public Boolean mostrarBusquedaPorNombreSubGrupoParametroFormularioIva=true;

	public Boolean getMostrarBusquedaPorNombreSubGrupoParametroFormularioIva() {
		return this.mostrarBusquedaPorNombreSubGrupoParametroFormularioIva;
	}

	public void setMostrarBusquedaPorNombreSubGrupoParametroFormularioIva(Boolean visibilidadResaltar) {
		this.mostrarBusquedaPorNombreSubGrupoParametroFormularioIva= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaSubGrupoParametroFormularioIva=true;

	public Boolean getMostrarFK_IdEmpresaSubGrupoParametroFormularioIva() {
		return this.mostrarFK_IdEmpresaSubGrupoParametroFormularioIva;
	}

	public void setMostrarFK_IdEmpresaSubGrupoParametroFormularioIva(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaSubGrupoParametroFormularioIva= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaPorIdSubGrupoParametroFormularioIva=true;

	public Boolean getActivarBusquedaPorIdSubGrupoParametroFormularioIva() {
		return this.activarBusquedaPorIdSubGrupoParametroFormularioIva;
	}

	public void setActivarBusquedaPorIdSubGrupoParametroFormularioIva(Boolean habilitarResaltar) {
		this.activarBusquedaPorIdSubGrupoParametroFormularioIva= habilitarResaltar;
	}

	public Boolean activarBusquedaPorNombreSubGrupoParametroFormularioIva=true;

	public Boolean getActivarBusquedaPorNombreSubGrupoParametroFormularioIva() {
		return this.activarBusquedaPorNombreSubGrupoParametroFormularioIva;
	}

	public void setActivarBusquedaPorNombreSubGrupoParametroFormularioIva(Boolean habilitarResaltar) {
		this.activarBusquedaPorNombreSubGrupoParametroFormularioIva= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaSubGrupoParametroFormularioIva=true;

	public Boolean getActivarFK_IdEmpresaSubGrupoParametroFormularioIva() {
		return this.activarFK_IdEmpresaSubGrupoParametroFormularioIva;
	}

	public void setActivarFK_IdEmpresaSubGrupoParametroFormularioIva(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaSubGrupoParametroFormularioIva= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaPorIdSubGrupoParametroFormularioIva=null;

	public Border getResaltarBusquedaPorIdSubGrupoParametroFormularioIva() {
		return this.resaltarBusquedaPorIdSubGrupoParametroFormularioIva;
	}

	public void setResaltarBusquedaPorIdSubGrupoParametroFormularioIva(Border borderResaltar) {
		this.resaltarBusquedaPorIdSubGrupoParametroFormularioIva= borderResaltar;
	}

	public void setResaltarBusquedaPorIdSubGrupoParametroFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*SubGrupoParametroFormularioIvaBeanSwingJInternalFrame subgrupoparametroformularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorIdSubGrupoParametroFormularioIva= borderResaltar;
	}

	public Border resaltarBusquedaPorNombreSubGrupoParametroFormularioIva=null;

	public Border getResaltarBusquedaPorNombreSubGrupoParametroFormularioIva() {
		return this.resaltarBusquedaPorNombreSubGrupoParametroFormularioIva;
	}

	public void setResaltarBusquedaPorNombreSubGrupoParametroFormularioIva(Border borderResaltar) {
		this.resaltarBusquedaPorNombreSubGrupoParametroFormularioIva= borderResaltar;
	}

	public void setResaltarBusquedaPorNombreSubGrupoParametroFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*SubGrupoParametroFormularioIvaBeanSwingJInternalFrame subgrupoparametroformularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaPorNombreSubGrupoParametroFormularioIva= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaSubGrupoParametroFormularioIva=null;

	public Border getResaltarFK_IdEmpresaSubGrupoParametroFormularioIva() {
		return this.resaltarFK_IdEmpresaSubGrupoParametroFormularioIva;
	}

	public void setResaltarFK_IdEmpresaSubGrupoParametroFormularioIva(Border borderResaltar) {
		this.resaltarFK_IdEmpresaSubGrupoParametroFormularioIva= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaSubGrupoParametroFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*SubGrupoParametroFormularioIvaBeanSwingJInternalFrame subgrupoparametroformularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaSubGrupoParametroFormularioIva= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}