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


import com.bydan.erp.nomina.util.TipoSeguroConstantesFunciones;
import com.bydan.erp.nomina.util.TipoSeguroParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TipoSeguroParameterGeneral;

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
final public class TipoSeguroConstantesFunciones extends TipoSeguroConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoSeguro";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoSeguro"+TipoSeguroConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoSeguroHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoSeguroHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoSeguroConstantesFunciones.SCHEMA+"_"+TipoSeguroConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoSeguroHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoSeguroConstantesFunciones.SCHEMA+"_"+TipoSeguroConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoSeguroConstantesFunciones.SCHEMA+"_"+TipoSeguroConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoSeguroHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoSeguroConstantesFunciones.SCHEMA+"_"+TipoSeguroConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoSeguroConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoSeguroHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoSeguroConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoSeguroConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoSeguroHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoSeguroConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoSeguroConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoSeguroConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoSeguroConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoSeguroConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Seguros";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Seguro";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Seguro";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoSeguro";
	public static final String OBJECTNAME="tiposeguro";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="tipo_seguro";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tiposeguro from "+TipoSeguroConstantesFunciones.SPERSISTENCENAME+" tiposeguro";
	public static String QUERYSELECTNATIVE="select "+TipoSeguroConstantesFunciones.SCHEMA+"."+TipoSeguroConstantesFunciones.TABLENAME+".id,"+TipoSeguroConstantesFunciones.SCHEMA+"."+TipoSeguroConstantesFunciones.TABLENAME+".version_row,"+TipoSeguroConstantesFunciones.SCHEMA+"."+TipoSeguroConstantesFunciones.TABLENAME+".id_empresa,"+TipoSeguroConstantesFunciones.SCHEMA+"."+TipoSeguroConstantesFunciones.TABLENAME+".codigo,"+TipoSeguroConstantesFunciones.SCHEMA+"."+TipoSeguroConstantesFunciones.TABLENAME+".nombre from "+TipoSeguroConstantesFunciones.SCHEMA+"."+TipoSeguroConstantesFunciones.TABLENAME;//+" as "+TipoSeguroConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoSeguroConstantesFuncionesAdditional tiposeguroConstantesFuncionesAdditional=null;
	
	public TipoSeguroConstantesFuncionesAdditional getTipoSeguroConstantesFuncionesAdditional() {
		return this.tiposeguroConstantesFuncionesAdditional;
	}
	
	public void setTipoSeguroConstantesFuncionesAdditional(TipoSeguroConstantesFuncionesAdditional tiposeguroConstantesFuncionesAdditional) {
		try {
			this.tiposeguroConstantesFuncionesAdditional=tiposeguroConstantesFuncionesAdditional;
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
	
	public static String getTipoSeguroLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoSeguroConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoSeguroConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoSeguroConstantesFunciones.CODIGO)) {sLabelColumna=TipoSeguroConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoSeguroConstantesFunciones.NOMBRE)) {sLabelColumna=TipoSeguroConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoSeguroDescripcion(TipoSeguro tiposeguro) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tiposeguro !=null/* && tiposeguro.getId()!=0*/) {
			sDescripcion=tiposeguro.getcodigo();//tiposegurotiposeguro.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoSeguroDescripcionDetallado(TipoSeguro tiposeguro) {
		String sDescripcion="";
			
		sDescripcion+=TipoSeguroConstantesFunciones.ID+"=";
		sDescripcion+=tiposeguro.getId().toString()+",";
		sDescripcion+=TipoSeguroConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tiposeguro.getVersionRow().toString()+",";
		sDescripcion+=TipoSeguroConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tiposeguro.getid_empresa().toString()+",";
		sDescripcion+=TipoSeguroConstantesFunciones.CODIGO+"=";
		sDescripcion+=tiposeguro.getcodigo()+",";
		sDescripcion+=TipoSeguroConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tiposeguro.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoSeguroDescripcion(TipoSeguro tiposeguro,String sValor) throws Exception {			
		if(tiposeguro !=null) {
			tiposeguro.setcodigo(sValor);;//tiposegurotiposeguro.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoSeguro(TipoSeguro tiposeguro,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tiposeguro.setcodigo(tiposeguro.getcodigo().trim());
		tiposeguro.setnombre(tiposeguro.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoSeguros(List<TipoSeguro> tiposeguros,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoSeguro tiposeguro: tiposeguros) {
			tiposeguro.setcodigo(tiposeguro.getcodigo().trim());
			tiposeguro.setnombre(tiposeguro.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoSeguro(TipoSeguro tiposeguro,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tiposeguro.getConCambioAuxiliar()) {
			tiposeguro.setIsDeleted(tiposeguro.getIsDeletedAuxiliar());	
			tiposeguro.setIsNew(tiposeguro.getIsNewAuxiliar());	
			tiposeguro.setIsChanged(tiposeguro.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tiposeguro.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tiposeguro.setIsDeletedAuxiliar(false);	
			tiposeguro.setIsNewAuxiliar(false);	
			tiposeguro.setIsChangedAuxiliar(false);
			
			tiposeguro.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoSeguros(List<TipoSeguro> tiposeguros,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoSeguro tiposeguro : tiposeguros) {
			if(conAsignarBase && tiposeguro.getConCambioAuxiliar()) {
				tiposeguro.setIsDeleted(tiposeguro.getIsDeletedAuxiliar());	
				tiposeguro.setIsNew(tiposeguro.getIsNewAuxiliar());	
				tiposeguro.setIsChanged(tiposeguro.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tiposeguro.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tiposeguro.setIsDeletedAuxiliar(false);	
				tiposeguro.setIsNewAuxiliar(false);	
				tiposeguro.setIsChangedAuxiliar(false);
				
				tiposeguro.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoSeguro(TipoSeguro tiposeguro,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoSeguros(List<TipoSeguro> tiposeguros,Boolean conEnteros) throws Exception  {
		
		for(TipoSeguro tiposeguro: tiposeguros) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoSeguro(List<TipoSeguro> tiposeguros,TipoSeguro tiposeguroAux) throws Exception  {
		TipoSeguroConstantesFunciones.InicializarValoresTipoSeguro(tiposeguroAux,true);
		
		for(TipoSeguro tiposeguro: tiposeguros) {
			if(tiposeguro.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoSeguro(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoSeguroConstantesFunciones.getArrayColumnasGlobalesTipoSeguro(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoSeguro(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoSeguroConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoSeguroConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoSeguro(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoSeguro> tiposeguros,TipoSeguro tiposeguro,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoSeguro tiposeguroAux: tiposeguros) {
			if(tiposeguroAux!=null && tiposeguro!=null) {
				if((tiposeguroAux.getId()==null && tiposeguro.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tiposeguroAux.getId()!=null && tiposeguro.getId()!=null){
					if(tiposeguroAux.getId().equals(tiposeguro.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoSeguro(List<TipoSeguro> tiposeguros) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoSeguro tiposeguro: tiposeguros) {			
			if(tiposeguro.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoSeguro() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoSeguroConstantesFunciones.LABEL_ID, TipoSeguroConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoSeguroConstantesFunciones.LABEL_VERSIONROW, TipoSeguroConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoSeguroConstantesFunciones.LABEL_IDEMPRESA, TipoSeguroConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoSeguroConstantesFunciones.LABEL_CODIGO, TipoSeguroConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoSeguroConstantesFunciones.LABEL_NOMBRE, TipoSeguroConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoSeguro() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoSeguroConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoSeguroConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoSeguroConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoSeguroConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoSeguroConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoSeguro() throws Exception  {
		return TipoSeguroConstantesFunciones.getTiposSeleccionarTipoSeguro(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoSeguro(Boolean conFk) throws Exception  {
		return TipoSeguroConstantesFunciones.getTiposSeleccionarTipoSeguro(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoSeguro(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoSeguroConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoSeguroConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoSeguroConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoSeguroConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoSeguroConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoSeguroConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoSeguro(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoSeguro(TipoSeguro tiposeguroAux) throws Exception {
		
			tiposeguroAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tiposeguroAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoSeguro(List<TipoSeguro> tiposegurosTemp) throws Exception {
		for(TipoSeguro tiposeguroAux:tiposegurosTemp) {
			
			tiposeguroAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tiposeguroAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoSeguro(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoSeguro(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoSeguro(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoSeguroConstantesFunciones.getClassesRelationshipsOfTipoSeguro(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoSeguro(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoSeguro(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoSeguroConstantesFunciones.getClassesRelationshipsFromStringsOfTipoSeguro(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoSeguro(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoSeguro tiposeguro,List<TipoSeguro> tiposeguros,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoSeguro tiposeguroEncontrado=null;
			
			for(TipoSeguro tiposeguroLocal:tiposeguros) {
				if(tiposeguroLocal.getId().equals(tiposeguro.getId())) {
					tiposeguroEncontrado=tiposeguroLocal;
					
					tiposeguroLocal.setIsChanged(tiposeguro.getIsChanged());
					tiposeguroLocal.setIsNew(tiposeguro.getIsNew());
					tiposeguroLocal.setIsDeleted(tiposeguro.getIsDeleted());
					
					tiposeguroLocal.setGeneralEntityOriginal(tiposeguro.getGeneralEntityOriginal());
					
					tiposeguroLocal.setId(tiposeguro.getId());	
					tiposeguroLocal.setVersionRow(tiposeguro.getVersionRow());	
					tiposeguroLocal.setid_empresa(tiposeguro.getid_empresa());	
					tiposeguroLocal.setcodigo(tiposeguro.getcodigo());	
					tiposeguroLocal.setnombre(tiposeguro.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tiposeguro.getIsDeleted()) {
				if(!existe) {
					tiposeguros.add(tiposeguro);
				}
			} else {
				if(tiposeguroEncontrado!=null && permiteQuitar)  {
					tiposeguros.remove(tiposeguroEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoSeguro tiposeguro,List<TipoSeguro> tiposeguros) throws Exception {
		try	{			
			for(TipoSeguro tiposeguroLocal:tiposeguros) {
				if(tiposeguroLocal.getId().equals(tiposeguro.getId())) {
					tiposeguroLocal.setIsSelected(tiposeguro.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoSeguro(List<TipoSeguro> tiposegurosAux) throws Exception {
		//this.tiposegurosAux=tiposegurosAux;
		
		for(TipoSeguro tiposeguroAux:tiposegurosAux) {
			if(tiposeguroAux.getIsChanged()) {
				tiposeguroAux.setIsChanged(false);
			}		
			
			if(tiposeguroAux.getIsNew()) {
				tiposeguroAux.setIsNew(false);
			}	
			
			if(tiposeguroAux.getIsDeleted()) {
				tiposeguroAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoSeguro(TipoSeguro tiposeguroAux) throws Exception {
		//this.tiposeguroAux=tiposeguroAux;
		
			if(tiposeguroAux.getIsChanged()) {
				tiposeguroAux.setIsChanged(false);
			}		
			
			if(tiposeguroAux.getIsNew()) {
				tiposeguroAux.setIsNew(false);
			}	
			
			if(tiposeguroAux.getIsDeleted()) {
				tiposeguroAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoSeguro tiposeguroAsignar,TipoSeguro tiposeguro) throws Exception {
		tiposeguroAsignar.setId(tiposeguro.getId());	
		tiposeguroAsignar.setVersionRow(tiposeguro.getVersionRow());	
		tiposeguroAsignar.setid_empresa(tiposeguro.getid_empresa());
		tiposeguroAsignar.setempresa_descripcion(tiposeguro.getempresa_descripcion());	
		tiposeguroAsignar.setcodigo(tiposeguro.getcodigo());	
		tiposeguroAsignar.setnombre(tiposeguro.getnombre());	
	}
	
	public static void inicializarTipoSeguro(TipoSeguro tiposeguro) throws Exception {
		try {
				tiposeguro.setId(0L);	
					
				tiposeguro.setid_empresa(-1L);	
				tiposeguro.setcodigo("");	
				tiposeguro.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoSeguro(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoSeguroConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoSeguroConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoSeguroConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoSeguro(String sTipo,Row row,Workbook workbook,TipoSeguro tiposeguro,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tiposeguro.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tiposeguro.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tiposeguro.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoSeguro=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoSeguro() {
		return this.sFinalQueryTipoSeguro;
	}
	
	public void setsFinalQueryTipoSeguro(String sFinalQueryTipoSeguro) {
		this.sFinalQueryTipoSeguro= sFinalQueryTipoSeguro;
	}
	
	public Border resaltarSeleccionarTipoSeguro=null;
	
	public Border setResaltarSeleccionarTipoSeguro(ParametroGeneralUsuario parametroGeneralUsuario/*TipoSeguroBeanSwingJInternalFrame tiposeguroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tiposeguroBeanSwingJInternalFrame.jTtoolBarTipoSeguro.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoSeguro= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoSeguro() {
		return this.resaltarSeleccionarTipoSeguro;
	}
	
	public void setResaltarSeleccionarTipoSeguro(Border borderResaltarSeleccionarTipoSeguro) {
		this.resaltarSeleccionarTipoSeguro= borderResaltarSeleccionarTipoSeguro;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoSeguro=null;
	public Boolean mostraridTipoSeguro=true;
	public Boolean activaridTipoSeguro=true;

	public Border resaltarid_empresaTipoSeguro=null;
	public Boolean mostrarid_empresaTipoSeguro=true;
	public Boolean activarid_empresaTipoSeguro=true;
	public Boolean cargarid_empresaTipoSeguro=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoSeguro=false;//ConEventDepend=true

	public Border resaltarcodigoTipoSeguro=null;
	public Boolean mostrarcodigoTipoSeguro=true;
	public Boolean activarcodigoTipoSeguro=true;

	public Border resaltarnombreTipoSeguro=null;
	public Boolean mostrarnombreTipoSeguro=true;
	public Boolean activarnombreTipoSeguro=true;

	
	

	public Border setResaltaridTipoSeguro(ParametroGeneralUsuario parametroGeneralUsuario/*TipoSeguroBeanSwingJInternalFrame tiposeguroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiposeguroBeanSwingJInternalFrame.jTtoolBarTipoSeguro.setBorder(borderResaltar);
		
		this.resaltaridTipoSeguro= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoSeguro() {
		return this.resaltaridTipoSeguro;
	}

	public void setResaltaridTipoSeguro(Border borderResaltar) {
		this.resaltaridTipoSeguro= borderResaltar;
	}

	public Boolean getMostraridTipoSeguro() {
		return this.mostraridTipoSeguro;
	}

	public void setMostraridTipoSeguro(Boolean mostraridTipoSeguro) {
		this.mostraridTipoSeguro= mostraridTipoSeguro;
	}

	public Boolean getActivaridTipoSeguro() {
		return this.activaridTipoSeguro;
	}

	public void setActivaridTipoSeguro(Boolean activaridTipoSeguro) {
		this.activaridTipoSeguro= activaridTipoSeguro;
	}

	public Border setResaltarid_empresaTipoSeguro(ParametroGeneralUsuario parametroGeneralUsuario/*TipoSeguroBeanSwingJInternalFrame tiposeguroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiposeguroBeanSwingJInternalFrame.jTtoolBarTipoSeguro.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoSeguro= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoSeguro() {
		return this.resaltarid_empresaTipoSeguro;
	}

	public void setResaltarid_empresaTipoSeguro(Border borderResaltar) {
		this.resaltarid_empresaTipoSeguro= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoSeguro() {
		return this.mostrarid_empresaTipoSeguro;
	}

	public void setMostrarid_empresaTipoSeguro(Boolean mostrarid_empresaTipoSeguro) {
		this.mostrarid_empresaTipoSeguro= mostrarid_empresaTipoSeguro;
	}

	public Boolean getActivarid_empresaTipoSeguro() {
		return this.activarid_empresaTipoSeguro;
	}

	public void setActivarid_empresaTipoSeguro(Boolean activarid_empresaTipoSeguro) {
		this.activarid_empresaTipoSeguro= activarid_empresaTipoSeguro;
	}

	public Boolean getCargarid_empresaTipoSeguro() {
		return this.cargarid_empresaTipoSeguro;
	}

	public void setCargarid_empresaTipoSeguro(Boolean cargarid_empresaTipoSeguro) {
		this.cargarid_empresaTipoSeguro= cargarid_empresaTipoSeguro;
	}

	public Border setResaltarcodigoTipoSeguro(ParametroGeneralUsuario parametroGeneralUsuario/*TipoSeguroBeanSwingJInternalFrame tiposeguroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiposeguroBeanSwingJInternalFrame.jTtoolBarTipoSeguro.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoSeguro= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoSeguro() {
		return this.resaltarcodigoTipoSeguro;
	}

	public void setResaltarcodigoTipoSeguro(Border borderResaltar) {
		this.resaltarcodigoTipoSeguro= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoSeguro() {
		return this.mostrarcodigoTipoSeguro;
	}

	public void setMostrarcodigoTipoSeguro(Boolean mostrarcodigoTipoSeguro) {
		this.mostrarcodigoTipoSeguro= mostrarcodigoTipoSeguro;
	}

	public Boolean getActivarcodigoTipoSeguro() {
		return this.activarcodigoTipoSeguro;
	}

	public void setActivarcodigoTipoSeguro(Boolean activarcodigoTipoSeguro) {
		this.activarcodigoTipoSeguro= activarcodigoTipoSeguro;
	}

	public Border setResaltarnombreTipoSeguro(ParametroGeneralUsuario parametroGeneralUsuario/*TipoSeguroBeanSwingJInternalFrame tiposeguroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiposeguroBeanSwingJInternalFrame.jTtoolBarTipoSeguro.setBorder(borderResaltar);
		
		this.resaltarnombreTipoSeguro= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoSeguro() {
		return this.resaltarnombreTipoSeguro;
	}

	public void setResaltarnombreTipoSeguro(Border borderResaltar) {
		this.resaltarnombreTipoSeguro= borderResaltar;
	}

	public Boolean getMostrarnombreTipoSeguro() {
		return this.mostrarnombreTipoSeguro;
	}

	public void setMostrarnombreTipoSeguro(Boolean mostrarnombreTipoSeguro) {
		this.mostrarnombreTipoSeguro= mostrarnombreTipoSeguro;
	}

	public Boolean getActivarnombreTipoSeguro() {
		return this.activarnombreTipoSeguro;
	}

	public void setActivarnombreTipoSeguro(Boolean activarnombreTipoSeguro) {
		this.activarnombreTipoSeguro= activarnombreTipoSeguro;
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
		
		
		this.setMostraridTipoSeguro(esInicial);
		this.setMostrarid_empresaTipoSeguro(esInicial);
		this.setMostrarcodigoTipoSeguro(esInicial);
		this.setMostrarnombreTipoSeguro(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoSeguroConstantesFunciones.ID)) {
				this.setMostraridTipoSeguro(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoSeguroConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoSeguro(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoSeguroConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoSeguro(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoSeguroConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoSeguro(esAsigna);
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
		
		
		this.setActivaridTipoSeguro(esInicial);
		this.setActivarid_empresaTipoSeguro(esInicial);
		this.setActivarcodigoTipoSeguro(esInicial);
		this.setActivarnombreTipoSeguro(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoSeguroConstantesFunciones.ID)) {
				this.setActivaridTipoSeguro(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoSeguroConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoSeguro(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoSeguroConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoSeguro(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoSeguroConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoSeguro(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoSeguroBeanSwingJInternalFrame tiposeguroBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoSeguro(esInicial);
		this.setResaltarid_empresaTipoSeguro(esInicial);
		this.setResaltarcodigoTipoSeguro(esInicial);
		this.setResaltarnombreTipoSeguro(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoSeguroConstantesFunciones.ID)) {
				this.setResaltaridTipoSeguro(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoSeguroConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoSeguro(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoSeguroConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoSeguro(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoSeguroConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoSeguro(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoSeguroBeanSwingJInternalFrame tiposeguroBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaTipoSeguro=true;

	public Boolean getMostrarFK_IdEmpresaTipoSeguro() {
		return this.mostrarFK_IdEmpresaTipoSeguro;
	}

	public void setMostrarFK_IdEmpresaTipoSeguro(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoSeguro= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTipoSeguro=true;

	public Boolean getActivarFK_IdEmpresaTipoSeguro() {
		return this.activarFK_IdEmpresaTipoSeguro;
	}

	public void setActivarFK_IdEmpresaTipoSeguro(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoSeguro= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTipoSeguro=null;

	public Border getResaltarFK_IdEmpresaTipoSeguro() {
		return this.resaltarFK_IdEmpresaTipoSeguro;
	}

	public void setResaltarFK_IdEmpresaTipoSeguro(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoSeguro= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoSeguro(ParametroGeneralUsuario parametroGeneralUsuario/*TipoSeguroBeanSwingJInternalFrame tiposeguroBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoSeguro= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}