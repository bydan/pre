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
package com.bydan.erp.nomina.util;

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


import com.bydan.erp.nomina.util.TipoColegioProfeConstantesFunciones;
import com.bydan.erp.nomina.util.TipoColegioProfeParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TipoColegioProfeParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoColegioProfeConstantesFunciones extends TipoColegioProfeConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoColegioProfe";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoColegioProfe"+TipoColegioProfeConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoColegioProfeHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoColegioProfeHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoColegioProfeConstantesFunciones.SCHEMA+"_"+TipoColegioProfeConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoColegioProfeHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoColegioProfeConstantesFunciones.SCHEMA+"_"+TipoColegioProfeConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoColegioProfeConstantesFunciones.SCHEMA+"_"+TipoColegioProfeConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoColegioProfeHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoColegioProfeConstantesFunciones.SCHEMA+"_"+TipoColegioProfeConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoColegioProfeConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoColegioProfeHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoColegioProfeConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoColegioProfeConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoColegioProfeHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoColegioProfeConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoColegioProfeConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoColegioProfeConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoColegioProfeConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoColegioProfeConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Colegio Profes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Colegio Profe";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Colegio Profe";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoColegioProfe";
	public static final String OBJECTNAME="tipocolegioprofe";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="tipo_colegio_profe";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipocolegioprofe from "+TipoColegioProfeConstantesFunciones.SPERSISTENCENAME+" tipocolegioprofe";
	public static String QUERYSELECTNATIVE="select "+TipoColegioProfeConstantesFunciones.SCHEMA+"."+TipoColegioProfeConstantesFunciones.TABLENAME+".id,"+TipoColegioProfeConstantesFunciones.SCHEMA+"."+TipoColegioProfeConstantesFunciones.TABLENAME+".version_row,"+TipoColegioProfeConstantesFunciones.SCHEMA+"."+TipoColegioProfeConstantesFunciones.TABLENAME+".id_empresa,"+TipoColegioProfeConstantesFunciones.SCHEMA+"."+TipoColegioProfeConstantesFunciones.TABLENAME+".codigo,"+TipoColegioProfeConstantesFunciones.SCHEMA+"."+TipoColegioProfeConstantesFunciones.TABLENAME+".nombre from "+TipoColegioProfeConstantesFunciones.SCHEMA+"."+TipoColegioProfeConstantesFunciones.TABLENAME;//+" as "+TipoColegioProfeConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoColegioProfeConstantesFuncionesAdditional tipocolegioprofeConstantesFuncionesAdditional=null;
	
	public TipoColegioProfeConstantesFuncionesAdditional getTipoColegioProfeConstantesFuncionesAdditional() {
		return this.tipocolegioprofeConstantesFuncionesAdditional;
	}
	
	public void setTipoColegioProfeConstantesFuncionesAdditional(TipoColegioProfeConstantesFuncionesAdditional tipocolegioprofeConstantesFuncionesAdditional) {
		try {
			this.tipocolegioprofeConstantesFuncionesAdditional=tipocolegioprofeConstantesFuncionesAdditional;
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
	
	public static String getTipoColegioProfeLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoColegioProfeConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoColegioProfeConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoColegioProfeConstantesFunciones.CODIGO)) {sLabelColumna=TipoColegioProfeConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoColegioProfeConstantesFunciones.NOMBRE)) {sLabelColumna=TipoColegioProfeConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoColegioProfeDescripcion(TipoColegioProfe tipocolegioprofe) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipocolegioprofe !=null/* && tipocolegioprofe.getId()!=0*/) {
			sDescripcion=tipocolegioprofe.getcodigo();//tipocolegioprofetipocolegioprofe.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoColegioProfeDescripcionDetallado(TipoColegioProfe tipocolegioprofe) {
		String sDescripcion="";
			
		sDescripcion+=TipoColegioProfeConstantesFunciones.ID+"=";
		sDescripcion+=tipocolegioprofe.getId().toString()+",";
		sDescripcion+=TipoColegioProfeConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipocolegioprofe.getVersionRow().toString()+",";
		sDescripcion+=TipoColegioProfeConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipocolegioprofe.getid_empresa().toString()+",";
		sDescripcion+=TipoColegioProfeConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipocolegioprofe.getcodigo()+",";
		sDescripcion+=TipoColegioProfeConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipocolegioprofe.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoColegioProfeDescripcion(TipoColegioProfe tipocolegioprofe,String sValor) throws Exception {			
		if(tipocolegioprofe !=null) {
			tipocolegioprofe.setcodigo(sValor);;//tipocolegioprofetipocolegioprofe.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoColegioProfe(TipoColegioProfe tipocolegioprofe,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipocolegioprofe.setcodigo(tipocolegioprofe.getcodigo().trim());
		tipocolegioprofe.setnombre(tipocolegioprofe.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoColegioProfes(List<TipoColegioProfe> tipocolegioprofes,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoColegioProfe tipocolegioprofe: tipocolegioprofes) {
			tipocolegioprofe.setcodigo(tipocolegioprofe.getcodigo().trim());
			tipocolegioprofe.setnombre(tipocolegioprofe.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoColegioProfe(TipoColegioProfe tipocolegioprofe,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipocolegioprofe.getConCambioAuxiliar()) {
			tipocolegioprofe.setIsDeleted(tipocolegioprofe.getIsDeletedAuxiliar());	
			tipocolegioprofe.setIsNew(tipocolegioprofe.getIsNewAuxiliar());	
			tipocolegioprofe.setIsChanged(tipocolegioprofe.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipocolegioprofe.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipocolegioprofe.setIsDeletedAuxiliar(false);	
			tipocolegioprofe.setIsNewAuxiliar(false);	
			tipocolegioprofe.setIsChangedAuxiliar(false);
			
			tipocolegioprofe.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoColegioProfes(List<TipoColegioProfe> tipocolegioprofes,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoColegioProfe tipocolegioprofe : tipocolegioprofes) {
			if(conAsignarBase && tipocolegioprofe.getConCambioAuxiliar()) {
				tipocolegioprofe.setIsDeleted(tipocolegioprofe.getIsDeletedAuxiliar());	
				tipocolegioprofe.setIsNew(tipocolegioprofe.getIsNewAuxiliar());	
				tipocolegioprofe.setIsChanged(tipocolegioprofe.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipocolegioprofe.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipocolegioprofe.setIsDeletedAuxiliar(false);	
				tipocolegioprofe.setIsNewAuxiliar(false);	
				tipocolegioprofe.setIsChangedAuxiliar(false);
				
				tipocolegioprofe.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoColegioProfe(TipoColegioProfe tipocolegioprofe,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoColegioProfes(List<TipoColegioProfe> tipocolegioprofes,Boolean conEnteros) throws Exception  {
		
		for(TipoColegioProfe tipocolegioprofe: tipocolegioprofes) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoColegioProfe(List<TipoColegioProfe> tipocolegioprofes,TipoColegioProfe tipocolegioprofeAux) throws Exception  {
		TipoColegioProfeConstantesFunciones.InicializarValoresTipoColegioProfe(tipocolegioprofeAux,true);
		
		for(TipoColegioProfe tipocolegioprofe: tipocolegioprofes) {
			if(tipocolegioprofe.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoColegioProfe(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoColegioProfeConstantesFunciones.getArrayColumnasGlobalesTipoColegioProfe(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoColegioProfe(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoColegioProfeConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoColegioProfeConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoColegioProfe(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoColegioProfe> tipocolegioprofes,TipoColegioProfe tipocolegioprofe,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoColegioProfe tipocolegioprofeAux: tipocolegioprofes) {
			if(tipocolegioprofeAux!=null && tipocolegioprofe!=null) {
				if((tipocolegioprofeAux.getId()==null && tipocolegioprofe.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipocolegioprofeAux.getId()!=null && tipocolegioprofe.getId()!=null){
					if(tipocolegioprofeAux.getId().equals(tipocolegioprofe.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoColegioProfe(List<TipoColegioProfe> tipocolegioprofes) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoColegioProfe tipocolegioprofe: tipocolegioprofes) {			
			if(tipocolegioprofe.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoColegioProfe() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoColegioProfeConstantesFunciones.LABEL_ID, TipoColegioProfeConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoColegioProfeConstantesFunciones.LABEL_VERSIONROW, TipoColegioProfeConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoColegioProfeConstantesFunciones.LABEL_IDEMPRESA, TipoColegioProfeConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoColegioProfeConstantesFunciones.LABEL_CODIGO, TipoColegioProfeConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoColegioProfeConstantesFunciones.LABEL_NOMBRE, TipoColegioProfeConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoColegioProfe() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoColegioProfeConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoColegioProfeConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoColegioProfeConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoColegioProfeConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoColegioProfeConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoColegioProfe() throws Exception  {
		return TipoColegioProfeConstantesFunciones.getTiposSeleccionarTipoColegioProfe(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoColegioProfe(Boolean conFk) throws Exception  {
		return TipoColegioProfeConstantesFunciones.getTiposSeleccionarTipoColegioProfe(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoColegioProfe(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoColegioProfeConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoColegioProfeConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoColegioProfeConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoColegioProfeConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoColegioProfeConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoColegioProfeConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoColegioProfe(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoColegioProfe(TipoColegioProfe tipocolegioprofeAux) throws Exception {
		
			tipocolegioprofeAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipocolegioprofeAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoColegioProfe(List<TipoColegioProfe> tipocolegioprofesTemp) throws Exception {
		for(TipoColegioProfe tipocolegioprofeAux:tipocolegioprofesTemp) {
			
			tipocolegioprofeAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipocolegioprofeAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoColegioProfe(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoColegioProfe(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoColegioProfe(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoColegioProfeConstantesFunciones.getClassesRelationshipsOfTipoColegioProfe(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoColegioProfe(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoColegioProfe(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoColegioProfeConstantesFunciones.getClassesRelationshipsFromStringsOfTipoColegioProfe(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoColegioProfe(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoColegioProfe tipocolegioprofe,List<TipoColegioProfe> tipocolegioprofes,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoColegioProfe tipocolegioprofeEncontrado=null;
			
			for(TipoColegioProfe tipocolegioprofeLocal:tipocolegioprofes) {
				if(tipocolegioprofeLocal.getId().equals(tipocolegioprofe.getId())) {
					tipocolegioprofeEncontrado=tipocolegioprofeLocal;
					
					tipocolegioprofeLocal.setIsChanged(tipocolegioprofe.getIsChanged());
					tipocolegioprofeLocal.setIsNew(tipocolegioprofe.getIsNew());
					tipocolegioprofeLocal.setIsDeleted(tipocolegioprofe.getIsDeleted());
					
					tipocolegioprofeLocal.setGeneralEntityOriginal(tipocolegioprofe.getGeneralEntityOriginal());
					
					tipocolegioprofeLocal.setId(tipocolegioprofe.getId());	
					tipocolegioprofeLocal.setVersionRow(tipocolegioprofe.getVersionRow());	
					tipocolegioprofeLocal.setid_empresa(tipocolegioprofe.getid_empresa());	
					tipocolegioprofeLocal.setcodigo(tipocolegioprofe.getcodigo());	
					tipocolegioprofeLocal.setnombre(tipocolegioprofe.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipocolegioprofe.getIsDeleted()) {
				if(!existe) {
					tipocolegioprofes.add(tipocolegioprofe);
				}
			} else {
				if(tipocolegioprofeEncontrado!=null && permiteQuitar)  {
					tipocolegioprofes.remove(tipocolegioprofeEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoColegioProfe tipocolegioprofe,List<TipoColegioProfe> tipocolegioprofes) throws Exception {
		try	{			
			for(TipoColegioProfe tipocolegioprofeLocal:tipocolegioprofes) {
				if(tipocolegioprofeLocal.getId().equals(tipocolegioprofe.getId())) {
					tipocolegioprofeLocal.setIsSelected(tipocolegioprofe.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoColegioProfe(List<TipoColegioProfe> tipocolegioprofesAux) throws Exception {
		//this.tipocolegioprofesAux=tipocolegioprofesAux;
		
		for(TipoColegioProfe tipocolegioprofeAux:tipocolegioprofesAux) {
			if(tipocolegioprofeAux.getIsChanged()) {
				tipocolegioprofeAux.setIsChanged(false);
			}		
			
			if(tipocolegioprofeAux.getIsNew()) {
				tipocolegioprofeAux.setIsNew(false);
			}	
			
			if(tipocolegioprofeAux.getIsDeleted()) {
				tipocolegioprofeAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoColegioProfe(TipoColegioProfe tipocolegioprofeAux) throws Exception {
		//this.tipocolegioprofeAux=tipocolegioprofeAux;
		
			if(tipocolegioprofeAux.getIsChanged()) {
				tipocolegioprofeAux.setIsChanged(false);
			}		
			
			if(tipocolegioprofeAux.getIsNew()) {
				tipocolegioprofeAux.setIsNew(false);
			}	
			
			if(tipocolegioprofeAux.getIsDeleted()) {
				tipocolegioprofeAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoColegioProfe tipocolegioprofeAsignar,TipoColegioProfe tipocolegioprofe) throws Exception {
		tipocolegioprofeAsignar.setId(tipocolegioprofe.getId());	
		tipocolegioprofeAsignar.setVersionRow(tipocolegioprofe.getVersionRow());	
		tipocolegioprofeAsignar.setid_empresa(tipocolegioprofe.getid_empresa());
		tipocolegioprofeAsignar.setempresa_descripcion(tipocolegioprofe.getempresa_descripcion());	
		tipocolegioprofeAsignar.setcodigo(tipocolegioprofe.getcodigo());	
		tipocolegioprofeAsignar.setnombre(tipocolegioprofe.getnombre());	
	}
	
	public static void inicializarTipoColegioProfe(TipoColegioProfe tipocolegioprofe) throws Exception {
		try {
				tipocolegioprofe.setId(0L);	
					
				tipocolegioprofe.setid_empresa(-1L);	
				tipocolegioprofe.setcodigo("");	
				tipocolegioprofe.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoColegioProfe(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoColegioProfeConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoColegioProfeConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoColegioProfeConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoColegioProfe(String sTipo,Row row,Workbook workbook,TipoColegioProfe tipocolegioprofe,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocolegioprofe.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocolegioprofe.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocolegioprofe.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoColegioProfe=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoColegioProfe() {
		return this.sFinalQueryTipoColegioProfe;
	}
	
	public void setsFinalQueryTipoColegioProfe(String sFinalQueryTipoColegioProfe) {
		this.sFinalQueryTipoColegioProfe= sFinalQueryTipoColegioProfe;
	}
	
	public Border resaltarSeleccionarTipoColegioProfe=null;
	
	public Border setResaltarSeleccionarTipoColegioProfe(ParametroGeneralUsuario parametroGeneralUsuario/*TipoColegioProfeBeanSwingJInternalFrame tipocolegioprofeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipocolegioprofeBeanSwingJInternalFrame.jTtoolBarTipoColegioProfe.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoColegioProfe= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoColegioProfe() {
		return this.resaltarSeleccionarTipoColegioProfe;
	}
	
	public void setResaltarSeleccionarTipoColegioProfe(Border borderResaltarSeleccionarTipoColegioProfe) {
		this.resaltarSeleccionarTipoColegioProfe= borderResaltarSeleccionarTipoColegioProfe;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoColegioProfe=null;
	public Boolean mostraridTipoColegioProfe=true;
	public Boolean activaridTipoColegioProfe=true;

	public Border resaltarid_empresaTipoColegioProfe=null;
	public Boolean mostrarid_empresaTipoColegioProfe=true;
	public Boolean activarid_empresaTipoColegioProfe=true;
	public Boolean cargarid_empresaTipoColegioProfe=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoColegioProfe=false;//ConEventDepend=true

	public Border resaltarcodigoTipoColegioProfe=null;
	public Boolean mostrarcodigoTipoColegioProfe=true;
	public Boolean activarcodigoTipoColegioProfe=true;

	public Border resaltarnombreTipoColegioProfe=null;
	public Boolean mostrarnombreTipoColegioProfe=true;
	public Boolean activarnombreTipoColegioProfe=true;

	
	

	public Border setResaltaridTipoColegioProfe(ParametroGeneralUsuario parametroGeneralUsuario/*TipoColegioProfeBeanSwingJInternalFrame tipocolegioprofeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocolegioprofeBeanSwingJInternalFrame.jTtoolBarTipoColegioProfe.setBorder(borderResaltar);
		
		this.resaltaridTipoColegioProfe= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoColegioProfe() {
		return this.resaltaridTipoColegioProfe;
	}

	public void setResaltaridTipoColegioProfe(Border borderResaltar) {
		this.resaltaridTipoColegioProfe= borderResaltar;
	}

	public Boolean getMostraridTipoColegioProfe() {
		return this.mostraridTipoColegioProfe;
	}

	public void setMostraridTipoColegioProfe(Boolean mostraridTipoColegioProfe) {
		this.mostraridTipoColegioProfe= mostraridTipoColegioProfe;
	}

	public Boolean getActivaridTipoColegioProfe() {
		return this.activaridTipoColegioProfe;
	}

	public void setActivaridTipoColegioProfe(Boolean activaridTipoColegioProfe) {
		this.activaridTipoColegioProfe= activaridTipoColegioProfe;
	}

	public Border setResaltarid_empresaTipoColegioProfe(ParametroGeneralUsuario parametroGeneralUsuario/*TipoColegioProfeBeanSwingJInternalFrame tipocolegioprofeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocolegioprofeBeanSwingJInternalFrame.jTtoolBarTipoColegioProfe.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoColegioProfe= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoColegioProfe() {
		return this.resaltarid_empresaTipoColegioProfe;
	}

	public void setResaltarid_empresaTipoColegioProfe(Border borderResaltar) {
		this.resaltarid_empresaTipoColegioProfe= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoColegioProfe() {
		return this.mostrarid_empresaTipoColegioProfe;
	}

	public void setMostrarid_empresaTipoColegioProfe(Boolean mostrarid_empresaTipoColegioProfe) {
		this.mostrarid_empresaTipoColegioProfe= mostrarid_empresaTipoColegioProfe;
	}

	public Boolean getActivarid_empresaTipoColegioProfe() {
		return this.activarid_empresaTipoColegioProfe;
	}

	public void setActivarid_empresaTipoColegioProfe(Boolean activarid_empresaTipoColegioProfe) {
		this.activarid_empresaTipoColegioProfe= activarid_empresaTipoColegioProfe;
	}

	public Boolean getCargarid_empresaTipoColegioProfe() {
		return this.cargarid_empresaTipoColegioProfe;
	}

	public void setCargarid_empresaTipoColegioProfe(Boolean cargarid_empresaTipoColegioProfe) {
		this.cargarid_empresaTipoColegioProfe= cargarid_empresaTipoColegioProfe;
	}

	public Border setResaltarcodigoTipoColegioProfe(ParametroGeneralUsuario parametroGeneralUsuario/*TipoColegioProfeBeanSwingJInternalFrame tipocolegioprofeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocolegioprofeBeanSwingJInternalFrame.jTtoolBarTipoColegioProfe.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoColegioProfe= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoColegioProfe() {
		return this.resaltarcodigoTipoColegioProfe;
	}

	public void setResaltarcodigoTipoColegioProfe(Border borderResaltar) {
		this.resaltarcodigoTipoColegioProfe= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoColegioProfe() {
		return this.mostrarcodigoTipoColegioProfe;
	}

	public void setMostrarcodigoTipoColegioProfe(Boolean mostrarcodigoTipoColegioProfe) {
		this.mostrarcodigoTipoColegioProfe= mostrarcodigoTipoColegioProfe;
	}

	public Boolean getActivarcodigoTipoColegioProfe() {
		return this.activarcodigoTipoColegioProfe;
	}

	public void setActivarcodigoTipoColegioProfe(Boolean activarcodigoTipoColegioProfe) {
		this.activarcodigoTipoColegioProfe= activarcodigoTipoColegioProfe;
	}

	public Border setResaltarnombreTipoColegioProfe(ParametroGeneralUsuario parametroGeneralUsuario/*TipoColegioProfeBeanSwingJInternalFrame tipocolegioprofeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocolegioprofeBeanSwingJInternalFrame.jTtoolBarTipoColegioProfe.setBorder(borderResaltar);
		
		this.resaltarnombreTipoColegioProfe= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoColegioProfe() {
		return this.resaltarnombreTipoColegioProfe;
	}

	public void setResaltarnombreTipoColegioProfe(Border borderResaltar) {
		this.resaltarnombreTipoColegioProfe= borderResaltar;
	}

	public Boolean getMostrarnombreTipoColegioProfe() {
		return this.mostrarnombreTipoColegioProfe;
	}

	public void setMostrarnombreTipoColegioProfe(Boolean mostrarnombreTipoColegioProfe) {
		this.mostrarnombreTipoColegioProfe= mostrarnombreTipoColegioProfe;
	}

	public Boolean getActivarnombreTipoColegioProfe() {
		return this.activarnombreTipoColegioProfe;
	}

	public void setActivarnombreTipoColegioProfe(Boolean activarnombreTipoColegioProfe) {
		this.activarnombreTipoColegioProfe= activarnombreTipoColegioProfe;
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
		
		
		this.setMostraridTipoColegioProfe(esInicial);
		this.setMostrarid_empresaTipoColegioProfe(esInicial);
		this.setMostrarcodigoTipoColegioProfe(esInicial);
		this.setMostrarnombreTipoColegioProfe(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoColegioProfeConstantesFunciones.ID)) {
				this.setMostraridTipoColegioProfe(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoColegioProfeConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoColegioProfe(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoColegioProfeConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoColegioProfe(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoColegioProfeConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoColegioProfe(esAsigna);
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
		
		
		this.setActivaridTipoColegioProfe(esInicial);
		this.setActivarid_empresaTipoColegioProfe(esInicial);
		this.setActivarcodigoTipoColegioProfe(esInicial);
		this.setActivarnombreTipoColegioProfe(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoColegioProfeConstantesFunciones.ID)) {
				this.setActivaridTipoColegioProfe(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoColegioProfeConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoColegioProfe(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoColegioProfeConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoColegioProfe(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoColegioProfeConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoColegioProfe(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoColegioProfeBeanSwingJInternalFrame tipocolegioprofeBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoColegioProfe(esInicial);
		this.setResaltarid_empresaTipoColegioProfe(esInicial);
		this.setResaltarcodigoTipoColegioProfe(esInicial);
		this.setResaltarnombreTipoColegioProfe(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoColegioProfeConstantesFunciones.ID)) {
				this.setResaltaridTipoColegioProfe(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoColegioProfeConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoColegioProfe(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoColegioProfeConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoColegioProfe(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoColegioProfeConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoColegioProfe(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoColegioProfeBeanSwingJInternalFrame tipocolegioprofeBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaTipoColegioProfe=true;

	public Boolean getMostrarFK_IdEmpresaTipoColegioProfe() {
		return this.mostrarFK_IdEmpresaTipoColegioProfe;
	}

	public void setMostrarFK_IdEmpresaTipoColegioProfe(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoColegioProfe= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTipoColegioProfe=true;

	public Boolean getActivarFK_IdEmpresaTipoColegioProfe() {
		return this.activarFK_IdEmpresaTipoColegioProfe;
	}

	public void setActivarFK_IdEmpresaTipoColegioProfe(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoColegioProfe= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTipoColegioProfe=null;

	public Border getResaltarFK_IdEmpresaTipoColegioProfe() {
		return this.resaltarFK_IdEmpresaTipoColegioProfe;
	}

	public void setResaltarFK_IdEmpresaTipoColegioProfe(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoColegioProfe= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoColegioProfe(ParametroGeneralUsuario parametroGeneralUsuario/*TipoColegioProfeBeanSwingJInternalFrame tipocolegioprofeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoColegioProfe= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}