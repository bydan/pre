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
package com.bydan.erp.cartera.util;

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


import com.bydan.erp.cartera.util.TipoSexoConstantesFunciones;
import com.bydan.erp.cartera.util.TipoSexoParameterReturnGeneral;
//import com.bydan.erp.cartera.util.TipoSexoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoSexoConstantesFunciones extends TipoSexoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoSexo";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoSexo"+TipoSexoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoSexoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoSexoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoSexoConstantesFunciones.SCHEMA+"_"+TipoSexoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoSexoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoSexoConstantesFunciones.SCHEMA+"_"+TipoSexoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoSexoConstantesFunciones.SCHEMA+"_"+TipoSexoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoSexoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoSexoConstantesFunciones.SCHEMA+"_"+TipoSexoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoSexoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoSexoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoSexoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoSexoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoSexoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoSexoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoSexoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoSexoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoSexoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoSexoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Sexos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Sexo";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Sexo";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoSexo";
	public static final String OBJECTNAME="tiposexo";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="tipo_sexo";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tiposexo from "+TipoSexoConstantesFunciones.SPERSISTENCENAME+" tiposexo";
	public static String QUERYSELECTNATIVE="select "+TipoSexoConstantesFunciones.SCHEMA+"."+TipoSexoConstantesFunciones.TABLENAME+".id,"+TipoSexoConstantesFunciones.SCHEMA+"."+TipoSexoConstantesFunciones.TABLENAME+".version_row,"+TipoSexoConstantesFunciones.SCHEMA+"."+TipoSexoConstantesFunciones.TABLENAME+".id_empresa,"+TipoSexoConstantesFunciones.SCHEMA+"."+TipoSexoConstantesFunciones.TABLENAME+".codigo,"+TipoSexoConstantesFunciones.SCHEMA+"."+TipoSexoConstantesFunciones.TABLENAME+".nombre from "+TipoSexoConstantesFunciones.SCHEMA+"."+TipoSexoConstantesFunciones.TABLENAME;//+" as "+TipoSexoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoSexoConstantesFuncionesAdditional tiposexoConstantesFuncionesAdditional=null;
	
	public TipoSexoConstantesFuncionesAdditional getTipoSexoConstantesFuncionesAdditional() {
		return this.tiposexoConstantesFuncionesAdditional;
	}
	
	public void setTipoSexoConstantesFuncionesAdditional(TipoSexoConstantesFuncionesAdditional tiposexoConstantesFuncionesAdditional) {
		try {
			this.tiposexoConstantesFuncionesAdditional=tiposexoConstantesFuncionesAdditional;
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
	
	public static String getTipoSexoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoSexoConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoSexoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoSexoConstantesFunciones.CODIGO)) {sLabelColumna=TipoSexoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoSexoConstantesFunciones.NOMBRE)) {sLabelColumna=TipoSexoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoSexoDescripcion(TipoSexo tiposexo) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tiposexo !=null/* && tiposexo.getId()!=0*/) {
			sDescripcion=tiposexo.getcodigo();//tiposexotiposexo.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoSexoDescripcionDetallado(TipoSexo tiposexo) {
		String sDescripcion="";
			
		sDescripcion+=TipoSexoConstantesFunciones.ID+"=";
		sDescripcion+=tiposexo.getId().toString()+",";
		sDescripcion+=TipoSexoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tiposexo.getVersionRow().toString()+",";
		sDescripcion+=TipoSexoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tiposexo.getid_empresa().toString()+",";
		sDescripcion+=TipoSexoConstantesFunciones.CODIGO+"=";
		sDescripcion+=tiposexo.getcodigo()+",";
		sDescripcion+=TipoSexoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tiposexo.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoSexoDescripcion(TipoSexo tiposexo,String sValor) throws Exception {			
		if(tiposexo !=null) {
			tiposexo.setcodigo(sValor);;//tiposexotiposexo.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoSexo(TipoSexo tiposexo,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tiposexo.setcodigo(tiposexo.getcodigo().trim());
		tiposexo.setnombre(tiposexo.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoSexos(List<TipoSexo> tiposexos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoSexo tiposexo: tiposexos) {
			tiposexo.setcodigo(tiposexo.getcodigo().trim());
			tiposexo.setnombre(tiposexo.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoSexo(TipoSexo tiposexo,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tiposexo.getConCambioAuxiliar()) {
			tiposexo.setIsDeleted(tiposexo.getIsDeletedAuxiliar());	
			tiposexo.setIsNew(tiposexo.getIsNewAuxiliar());	
			tiposexo.setIsChanged(tiposexo.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tiposexo.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tiposexo.setIsDeletedAuxiliar(false);	
			tiposexo.setIsNewAuxiliar(false);	
			tiposexo.setIsChangedAuxiliar(false);
			
			tiposexo.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoSexos(List<TipoSexo> tiposexos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoSexo tiposexo : tiposexos) {
			if(conAsignarBase && tiposexo.getConCambioAuxiliar()) {
				tiposexo.setIsDeleted(tiposexo.getIsDeletedAuxiliar());	
				tiposexo.setIsNew(tiposexo.getIsNewAuxiliar());	
				tiposexo.setIsChanged(tiposexo.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tiposexo.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tiposexo.setIsDeletedAuxiliar(false);	
				tiposexo.setIsNewAuxiliar(false);	
				tiposexo.setIsChangedAuxiliar(false);
				
				tiposexo.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoSexo(TipoSexo tiposexo,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoSexos(List<TipoSexo> tiposexos,Boolean conEnteros) throws Exception  {
		
		for(TipoSexo tiposexo: tiposexos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoSexo(List<TipoSexo> tiposexos,TipoSexo tiposexoAux) throws Exception  {
		TipoSexoConstantesFunciones.InicializarValoresTipoSexo(tiposexoAux,true);
		
		for(TipoSexo tiposexo: tiposexos) {
			if(tiposexo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoSexo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoSexoConstantesFunciones.getArrayColumnasGlobalesTipoSexo(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoSexo(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoSexoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoSexoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoSexo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoSexo> tiposexos,TipoSexo tiposexo,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoSexo tiposexoAux: tiposexos) {
			if(tiposexoAux!=null && tiposexo!=null) {
				if((tiposexoAux.getId()==null && tiposexo.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tiposexoAux.getId()!=null && tiposexo.getId()!=null){
					if(tiposexoAux.getId().equals(tiposexo.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoSexo(List<TipoSexo> tiposexos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoSexo tiposexo: tiposexos) {			
			if(tiposexo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoSexo() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoSexoConstantesFunciones.LABEL_ID, TipoSexoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoSexoConstantesFunciones.LABEL_VERSIONROW, TipoSexoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoSexoConstantesFunciones.LABEL_IDEMPRESA, TipoSexoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoSexoConstantesFunciones.LABEL_CODIGO, TipoSexoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoSexoConstantesFunciones.LABEL_NOMBRE, TipoSexoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoSexo() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoSexoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoSexoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoSexoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoSexoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoSexoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoSexo() throws Exception  {
		return TipoSexoConstantesFunciones.getTiposSeleccionarTipoSexo(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoSexo(Boolean conFk) throws Exception  {
		return TipoSexoConstantesFunciones.getTiposSeleccionarTipoSexo(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoSexo(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoSexoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoSexoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoSexoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoSexoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoSexoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoSexoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoSexo(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoSexo(TipoSexo tiposexoAux) throws Exception {
		
			tiposexoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tiposexoAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoSexo(List<TipoSexo> tiposexosTemp) throws Exception {
		for(TipoSexo tiposexoAux:tiposexosTemp) {
			
			tiposexoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tiposexoAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoSexo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoSexo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoSexo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoSexoConstantesFunciones.getClassesRelationshipsOfTipoSexo(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoSexo(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoSexo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoSexoConstantesFunciones.getClassesRelationshipsFromStringsOfTipoSexo(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoSexo(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoSexo tiposexo,List<TipoSexo> tiposexos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoSexo tiposexoEncontrado=null;
			
			for(TipoSexo tiposexoLocal:tiposexos) {
				if(tiposexoLocal.getId().equals(tiposexo.getId())) {
					tiposexoEncontrado=tiposexoLocal;
					
					tiposexoLocal.setIsChanged(tiposexo.getIsChanged());
					tiposexoLocal.setIsNew(tiposexo.getIsNew());
					tiposexoLocal.setIsDeleted(tiposexo.getIsDeleted());
					
					tiposexoLocal.setGeneralEntityOriginal(tiposexo.getGeneralEntityOriginal());
					
					tiposexoLocal.setId(tiposexo.getId());	
					tiposexoLocal.setVersionRow(tiposexo.getVersionRow());	
					tiposexoLocal.setid_empresa(tiposexo.getid_empresa());	
					tiposexoLocal.setcodigo(tiposexo.getcodigo());	
					tiposexoLocal.setnombre(tiposexo.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tiposexo.getIsDeleted()) {
				if(!existe) {
					tiposexos.add(tiposexo);
				}
			} else {
				if(tiposexoEncontrado!=null && permiteQuitar)  {
					tiposexos.remove(tiposexoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoSexo tiposexo,List<TipoSexo> tiposexos) throws Exception {
		try	{			
			for(TipoSexo tiposexoLocal:tiposexos) {
				if(tiposexoLocal.getId().equals(tiposexo.getId())) {
					tiposexoLocal.setIsSelected(tiposexo.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoSexo(List<TipoSexo> tiposexosAux) throws Exception {
		//this.tiposexosAux=tiposexosAux;
		
		for(TipoSexo tiposexoAux:tiposexosAux) {
			if(tiposexoAux.getIsChanged()) {
				tiposexoAux.setIsChanged(false);
			}		
			
			if(tiposexoAux.getIsNew()) {
				tiposexoAux.setIsNew(false);
			}	
			
			if(tiposexoAux.getIsDeleted()) {
				tiposexoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoSexo(TipoSexo tiposexoAux) throws Exception {
		//this.tiposexoAux=tiposexoAux;
		
			if(tiposexoAux.getIsChanged()) {
				tiposexoAux.setIsChanged(false);
			}		
			
			if(tiposexoAux.getIsNew()) {
				tiposexoAux.setIsNew(false);
			}	
			
			if(tiposexoAux.getIsDeleted()) {
				tiposexoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoSexo tiposexoAsignar,TipoSexo tiposexo) throws Exception {
		tiposexoAsignar.setId(tiposexo.getId());	
		tiposexoAsignar.setVersionRow(tiposexo.getVersionRow());	
		tiposexoAsignar.setid_empresa(tiposexo.getid_empresa());
		tiposexoAsignar.setempresa_descripcion(tiposexo.getempresa_descripcion());	
		tiposexoAsignar.setcodigo(tiposexo.getcodigo());	
		tiposexoAsignar.setnombre(tiposexo.getnombre());	
	}
	
	public static void inicializarTipoSexo(TipoSexo tiposexo) throws Exception {
		try {
				tiposexo.setId(0L);	
					
				tiposexo.setid_empresa(-1L);	
				tiposexo.setcodigo("");	
				tiposexo.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoSexo(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoSexoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoSexoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoSexoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoSexo(String sTipo,Row row,Workbook workbook,TipoSexo tiposexo,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tiposexo.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tiposexo.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tiposexo.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoSexo=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoSexo() {
		return this.sFinalQueryTipoSexo;
	}
	
	public void setsFinalQueryTipoSexo(String sFinalQueryTipoSexo) {
		this.sFinalQueryTipoSexo= sFinalQueryTipoSexo;
	}
	
	public Border resaltarSeleccionarTipoSexo=null;
	
	public Border setResaltarSeleccionarTipoSexo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoSexoBeanSwingJInternalFrame tiposexoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tiposexoBeanSwingJInternalFrame.jTtoolBarTipoSexo.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoSexo= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoSexo() {
		return this.resaltarSeleccionarTipoSexo;
	}
	
	public void setResaltarSeleccionarTipoSexo(Border borderResaltarSeleccionarTipoSexo) {
		this.resaltarSeleccionarTipoSexo= borderResaltarSeleccionarTipoSexo;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoSexo=null;
	public Boolean mostraridTipoSexo=true;
	public Boolean activaridTipoSexo=true;

	public Border resaltarid_empresaTipoSexo=null;
	public Boolean mostrarid_empresaTipoSexo=true;
	public Boolean activarid_empresaTipoSexo=true;
	public Boolean cargarid_empresaTipoSexo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoSexo=false;//ConEventDepend=true

	public Border resaltarcodigoTipoSexo=null;
	public Boolean mostrarcodigoTipoSexo=true;
	public Boolean activarcodigoTipoSexo=true;

	public Border resaltarnombreTipoSexo=null;
	public Boolean mostrarnombreTipoSexo=true;
	public Boolean activarnombreTipoSexo=true;

	
	

	public Border setResaltaridTipoSexo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoSexoBeanSwingJInternalFrame tiposexoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiposexoBeanSwingJInternalFrame.jTtoolBarTipoSexo.setBorder(borderResaltar);
		
		this.resaltaridTipoSexo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoSexo() {
		return this.resaltaridTipoSexo;
	}

	public void setResaltaridTipoSexo(Border borderResaltar) {
		this.resaltaridTipoSexo= borderResaltar;
	}

	public Boolean getMostraridTipoSexo() {
		return this.mostraridTipoSexo;
	}

	public void setMostraridTipoSexo(Boolean mostraridTipoSexo) {
		this.mostraridTipoSexo= mostraridTipoSexo;
	}

	public Boolean getActivaridTipoSexo() {
		return this.activaridTipoSexo;
	}

	public void setActivaridTipoSexo(Boolean activaridTipoSexo) {
		this.activaridTipoSexo= activaridTipoSexo;
	}

	public Border setResaltarid_empresaTipoSexo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoSexoBeanSwingJInternalFrame tiposexoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiposexoBeanSwingJInternalFrame.jTtoolBarTipoSexo.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoSexo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoSexo() {
		return this.resaltarid_empresaTipoSexo;
	}

	public void setResaltarid_empresaTipoSexo(Border borderResaltar) {
		this.resaltarid_empresaTipoSexo= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoSexo() {
		return this.mostrarid_empresaTipoSexo;
	}

	public void setMostrarid_empresaTipoSexo(Boolean mostrarid_empresaTipoSexo) {
		this.mostrarid_empresaTipoSexo= mostrarid_empresaTipoSexo;
	}

	public Boolean getActivarid_empresaTipoSexo() {
		return this.activarid_empresaTipoSexo;
	}

	public void setActivarid_empresaTipoSexo(Boolean activarid_empresaTipoSexo) {
		this.activarid_empresaTipoSexo= activarid_empresaTipoSexo;
	}

	public Boolean getCargarid_empresaTipoSexo() {
		return this.cargarid_empresaTipoSexo;
	}

	public void setCargarid_empresaTipoSexo(Boolean cargarid_empresaTipoSexo) {
		this.cargarid_empresaTipoSexo= cargarid_empresaTipoSexo;
	}

	public Border setResaltarcodigoTipoSexo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoSexoBeanSwingJInternalFrame tiposexoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiposexoBeanSwingJInternalFrame.jTtoolBarTipoSexo.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoSexo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoSexo() {
		return this.resaltarcodigoTipoSexo;
	}

	public void setResaltarcodigoTipoSexo(Border borderResaltar) {
		this.resaltarcodigoTipoSexo= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoSexo() {
		return this.mostrarcodigoTipoSexo;
	}

	public void setMostrarcodigoTipoSexo(Boolean mostrarcodigoTipoSexo) {
		this.mostrarcodigoTipoSexo= mostrarcodigoTipoSexo;
	}

	public Boolean getActivarcodigoTipoSexo() {
		return this.activarcodigoTipoSexo;
	}

	public void setActivarcodigoTipoSexo(Boolean activarcodigoTipoSexo) {
		this.activarcodigoTipoSexo= activarcodigoTipoSexo;
	}

	public Border setResaltarnombreTipoSexo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoSexoBeanSwingJInternalFrame tiposexoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiposexoBeanSwingJInternalFrame.jTtoolBarTipoSexo.setBorder(borderResaltar);
		
		this.resaltarnombreTipoSexo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoSexo() {
		return this.resaltarnombreTipoSexo;
	}

	public void setResaltarnombreTipoSexo(Border borderResaltar) {
		this.resaltarnombreTipoSexo= borderResaltar;
	}

	public Boolean getMostrarnombreTipoSexo() {
		return this.mostrarnombreTipoSexo;
	}

	public void setMostrarnombreTipoSexo(Boolean mostrarnombreTipoSexo) {
		this.mostrarnombreTipoSexo= mostrarnombreTipoSexo;
	}

	public Boolean getActivarnombreTipoSexo() {
		return this.activarnombreTipoSexo;
	}

	public void setActivarnombreTipoSexo(Boolean activarnombreTipoSexo) {
		this.activarnombreTipoSexo= activarnombreTipoSexo;
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
		
		
		this.setMostraridTipoSexo(esInicial);
		this.setMostrarid_empresaTipoSexo(esInicial);
		this.setMostrarcodigoTipoSexo(esInicial);
		this.setMostrarnombreTipoSexo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoSexoConstantesFunciones.ID)) {
				this.setMostraridTipoSexo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoSexoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoSexo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoSexoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoSexo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoSexoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoSexo(esAsigna);
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
		
		
		this.setActivaridTipoSexo(esInicial);
		this.setActivarid_empresaTipoSexo(esInicial);
		this.setActivarcodigoTipoSexo(esInicial);
		this.setActivarnombreTipoSexo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoSexoConstantesFunciones.ID)) {
				this.setActivaridTipoSexo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoSexoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoSexo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoSexoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoSexo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoSexoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoSexo(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoSexoBeanSwingJInternalFrame tiposexoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoSexo(esInicial);
		this.setResaltarid_empresaTipoSexo(esInicial);
		this.setResaltarcodigoTipoSexo(esInicial);
		this.setResaltarnombreTipoSexo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoSexoConstantesFunciones.ID)) {
				this.setResaltaridTipoSexo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoSexoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoSexo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoSexoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoSexo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoSexoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoSexo(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoSexoBeanSwingJInternalFrame tiposexoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaTipoSexo=true;

	public Boolean getMostrarFK_IdEmpresaTipoSexo() {
		return this.mostrarFK_IdEmpresaTipoSexo;
	}

	public void setMostrarFK_IdEmpresaTipoSexo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoSexo= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTipoSexo=true;

	public Boolean getActivarFK_IdEmpresaTipoSexo() {
		return this.activarFK_IdEmpresaTipoSexo;
	}

	public void setActivarFK_IdEmpresaTipoSexo(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoSexo= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTipoSexo=null;

	public Border getResaltarFK_IdEmpresaTipoSexo() {
		return this.resaltarFK_IdEmpresaTipoSexo;
	}

	public void setResaltarFK_IdEmpresaTipoSexo(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoSexo= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoSexo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoSexoBeanSwingJInternalFrame tiposexoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoSexo= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}