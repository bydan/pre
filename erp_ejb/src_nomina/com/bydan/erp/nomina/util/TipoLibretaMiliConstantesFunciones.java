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


import com.bydan.erp.nomina.util.TipoLibretaMiliConstantesFunciones;
import com.bydan.erp.nomina.util.TipoLibretaMiliParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TipoLibretaMiliParameterGeneral;

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
final public class TipoLibretaMiliConstantesFunciones extends TipoLibretaMiliConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoLibretaMili";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoLibretaMili"+TipoLibretaMiliConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoLibretaMiliHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoLibretaMiliHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoLibretaMiliConstantesFunciones.SCHEMA+"_"+TipoLibretaMiliConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoLibretaMiliHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoLibretaMiliConstantesFunciones.SCHEMA+"_"+TipoLibretaMiliConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoLibretaMiliConstantesFunciones.SCHEMA+"_"+TipoLibretaMiliConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoLibretaMiliHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoLibretaMiliConstantesFunciones.SCHEMA+"_"+TipoLibretaMiliConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoLibretaMiliConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoLibretaMiliHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoLibretaMiliConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoLibretaMiliConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoLibretaMiliHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoLibretaMiliConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoLibretaMiliConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoLibretaMiliConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoLibretaMiliConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoLibretaMiliConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Libreta Milis";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Libreta Mili";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Libreta Mili";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoLibretaMili";
	public static final String OBJECTNAME="tipolibretamili";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="tipo_libreta_mili";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipolibretamili from "+TipoLibretaMiliConstantesFunciones.SPERSISTENCENAME+" tipolibretamili";
	public static String QUERYSELECTNATIVE="select "+TipoLibretaMiliConstantesFunciones.SCHEMA+"."+TipoLibretaMiliConstantesFunciones.TABLENAME+".id,"+TipoLibretaMiliConstantesFunciones.SCHEMA+"."+TipoLibretaMiliConstantesFunciones.TABLENAME+".version_row,"+TipoLibretaMiliConstantesFunciones.SCHEMA+"."+TipoLibretaMiliConstantesFunciones.TABLENAME+".id_empresa,"+TipoLibretaMiliConstantesFunciones.SCHEMA+"."+TipoLibretaMiliConstantesFunciones.TABLENAME+".codigo,"+TipoLibretaMiliConstantesFunciones.SCHEMA+"."+TipoLibretaMiliConstantesFunciones.TABLENAME+".nombre from "+TipoLibretaMiliConstantesFunciones.SCHEMA+"."+TipoLibretaMiliConstantesFunciones.TABLENAME;//+" as "+TipoLibretaMiliConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoLibretaMiliConstantesFuncionesAdditional tipolibretamiliConstantesFuncionesAdditional=null;
	
	public TipoLibretaMiliConstantesFuncionesAdditional getTipoLibretaMiliConstantesFuncionesAdditional() {
		return this.tipolibretamiliConstantesFuncionesAdditional;
	}
	
	public void setTipoLibretaMiliConstantesFuncionesAdditional(TipoLibretaMiliConstantesFuncionesAdditional tipolibretamiliConstantesFuncionesAdditional) {
		try {
			this.tipolibretamiliConstantesFuncionesAdditional=tipolibretamiliConstantesFuncionesAdditional;
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
	
	public static String getTipoLibretaMiliLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoLibretaMiliConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoLibretaMiliConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoLibretaMiliConstantesFunciones.CODIGO)) {sLabelColumna=TipoLibretaMiliConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoLibretaMiliConstantesFunciones.NOMBRE)) {sLabelColumna=TipoLibretaMiliConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoLibretaMiliDescripcion(TipoLibretaMili tipolibretamili) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipolibretamili !=null/* && tipolibretamili.getId()!=0*/) {
			sDescripcion=tipolibretamili.getcodigo();//tipolibretamilitipolibretamili.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoLibretaMiliDescripcionDetallado(TipoLibretaMili tipolibretamili) {
		String sDescripcion="";
			
		sDescripcion+=TipoLibretaMiliConstantesFunciones.ID+"=";
		sDescripcion+=tipolibretamili.getId().toString()+",";
		sDescripcion+=TipoLibretaMiliConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipolibretamili.getVersionRow().toString()+",";
		sDescripcion+=TipoLibretaMiliConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipolibretamili.getid_empresa().toString()+",";
		sDescripcion+=TipoLibretaMiliConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipolibretamili.getcodigo()+",";
		sDescripcion+=TipoLibretaMiliConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipolibretamili.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoLibretaMiliDescripcion(TipoLibretaMili tipolibretamili,String sValor) throws Exception {			
		if(tipolibretamili !=null) {
			tipolibretamili.setcodigo(sValor);;//tipolibretamilitipolibretamili.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoLibretaMili(TipoLibretaMili tipolibretamili,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipolibretamili.setcodigo(tipolibretamili.getcodigo().trim());
		tipolibretamili.setnombre(tipolibretamili.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoLibretaMilis(List<TipoLibretaMili> tipolibretamilis,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoLibretaMili tipolibretamili: tipolibretamilis) {
			tipolibretamili.setcodigo(tipolibretamili.getcodigo().trim());
			tipolibretamili.setnombre(tipolibretamili.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoLibretaMili(TipoLibretaMili tipolibretamili,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipolibretamili.getConCambioAuxiliar()) {
			tipolibretamili.setIsDeleted(tipolibretamili.getIsDeletedAuxiliar());	
			tipolibretamili.setIsNew(tipolibretamili.getIsNewAuxiliar());	
			tipolibretamili.setIsChanged(tipolibretamili.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipolibretamili.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipolibretamili.setIsDeletedAuxiliar(false);	
			tipolibretamili.setIsNewAuxiliar(false);	
			tipolibretamili.setIsChangedAuxiliar(false);
			
			tipolibretamili.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoLibretaMilis(List<TipoLibretaMili> tipolibretamilis,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoLibretaMili tipolibretamili : tipolibretamilis) {
			if(conAsignarBase && tipolibretamili.getConCambioAuxiliar()) {
				tipolibretamili.setIsDeleted(tipolibretamili.getIsDeletedAuxiliar());	
				tipolibretamili.setIsNew(tipolibretamili.getIsNewAuxiliar());	
				tipolibretamili.setIsChanged(tipolibretamili.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipolibretamili.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipolibretamili.setIsDeletedAuxiliar(false);	
				tipolibretamili.setIsNewAuxiliar(false);	
				tipolibretamili.setIsChangedAuxiliar(false);
				
				tipolibretamili.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoLibretaMili(TipoLibretaMili tipolibretamili,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoLibretaMilis(List<TipoLibretaMili> tipolibretamilis,Boolean conEnteros) throws Exception  {
		
		for(TipoLibretaMili tipolibretamili: tipolibretamilis) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoLibretaMili(List<TipoLibretaMili> tipolibretamilis,TipoLibretaMili tipolibretamiliAux) throws Exception  {
		TipoLibretaMiliConstantesFunciones.InicializarValoresTipoLibretaMili(tipolibretamiliAux,true);
		
		for(TipoLibretaMili tipolibretamili: tipolibretamilis) {
			if(tipolibretamili.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoLibretaMili(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoLibretaMiliConstantesFunciones.getArrayColumnasGlobalesTipoLibretaMili(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoLibretaMili(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoLibretaMiliConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoLibretaMiliConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoLibretaMili(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoLibretaMili> tipolibretamilis,TipoLibretaMili tipolibretamili,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoLibretaMili tipolibretamiliAux: tipolibretamilis) {
			if(tipolibretamiliAux!=null && tipolibretamili!=null) {
				if((tipolibretamiliAux.getId()==null && tipolibretamili.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipolibretamiliAux.getId()!=null && tipolibretamili.getId()!=null){
					if(tipolibretamiliAux.getId().equals(tipolibretamili.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoLibretaMili(List<TipoLibretaMili> tipolibretamilis) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoLibretaMili tipolibretamili: tipolibretamilis) {			
			if(tipolibretamili.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoLibretaMili() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoLibretaMiliConstantesFunciones.LABEL_ID, TipoLibretaMiliConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoLibretaMiliConstantesFunciones.LABEL_VERSIONROW, TipoLibretaMiliConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoLibretaMiliConstantesFunciones.LABEL_IDEMPRESA, TipoLibretaMiliConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoLibretaMiliConstantesFunciones.LABEL_CODIGO, TipoLibretaMiliConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoLibretaMiliConstantesFunciones.LABEL_NOMBRE, TipoLibretaMiliConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoLibretaMili() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoLibretaMiliConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoLibretaMiliConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoLibretaMiliConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoLibretaMiliConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoLibretaMiliConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoLibretaMili() throws Exception  {
		return TipoLibretaMiliConstantesFunciones.getTiposSeleccionarTipoLibretaMili(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoLibretaMili(Boolean conFk) throws Exception  {
		return TipoLibretaMiliConstantesFunciones.getTiposSeleccionarTipoLibretaMili(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoLibretaMili(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoLibretaMiliConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoLibretaMiliConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoLibretaMiliConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoLibretaMiliConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoLibretaMiliConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoLibretaMiliConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoLibretaMili(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoLibretaMili(TipoLibretaMili tipolibretamiliAux) throws Exception {
		
			tipolibretamiliAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipolibretamiliAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoLibretaMili(List<TipoLibretaMili> tipolibretamilisTemp) throws Exception {
		for(TipoLibretaMili tipolibretamiliAux:tipolibretamilisTemp) {
			
			tipolibretamiliAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipolibretamiliAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoLibretaMili(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoLibretaMili(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoLibretaMili(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoLibretaMiliConstantesFunciones.getClassesRelationshipsOfTipoLibretaMili(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoLibretaMili(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DatoGeneralEmpleado.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DatoGeneralEmpleado.class)) {
						classes.add(new Classe(DatoGeneralEmpleado.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoLibretaMili(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoLibretaMiliConstantesFunciones.getClassesRelationshipsFromStringsOfTipoLibretaMili(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoLibretaMili(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DatoGeneralEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DatoGeneralEmpleado.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DatoGeneralEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DatoGeneralEmpleado.class)); continue;
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
	public static void actualizarLista(TipoLibretaMili tipolibretamili,List<TipoLibretaMili> tipolibretamilis,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoLibretaMili tipolibretamiliEncontrado=null;
			
			for(TipoLibretaMili tipolibretamiliLocal:tipolibretamilis) {
				if(tipolibretamiliLocal.getId().equals(tipolibretamili.getId())) {
					tipolibretamiliEncontrado=tipolibretamiliLocal;
					
					tipolibretamiliLocal.setIsChanged(tipolibretamili.getIsChanged());
					tipolibretamiliLocal.setIsNew(tipolibretamili.getIsNew());
					tipolibretamiliLocal.setIsDeleted(tipolibretamili.getIsDeleted());
					
					tipolibretamiliLocal.setGeneralEntityOriginal(tipolibretamili.getGeneralEntityOriginal());
					
					tipolibretamiliLocal.setId(tipolibretamili.getId());	
					tipolibretamiliLocal.setVersionRow(tipolibretamili.getVersionRow());	
					tipolibretamiliLocal.setid_empresa(tipolibretamili.getid_empresa());	
					tipolibretamiliLocal.setcodigo(tipolibretamili.getcodigo());	
					tipolibretamiliLocal.setnombre(tipolibretamili.getnombre());	
					
					
					tipolibretamiliLocal.setDatoGeneralEmpleados(tipolibretamili.getDatoGeneralEmpleados());
					
					existe=true;
					break;
				}
			}
			
			if(!tipolibretamili.getIsDeleted()) {
				if(!existe) {
					tipolibretamilis.add(tipolibretamili);
				}
			} else {
				if(tipolibretamiliEncontrado!=null && permiteQuitar)  {
					tipolibretamilis.remove(tipolibretamiliEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoLibretaMili tipolibretamili,List<TipoLibretaMili> tipolibretamilis) throws Exception {
		try	{			
			for(TipoLibretaMili tipolibretamiliLocal:tipolibretamilis) {
				if(tipolibretamiliLocal.getId().equals(tipolibretamili.getId())) {
					tipolibretamiliLocal.setIsSelected(tipolibretamili.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoLibretaMili(List<TipoLibretaMili> tipolibretamilisAux) throws Exception {
		//this.tipolibretamilisAux=tipolibretamilisAux;
		
		for(TipoLibretaMili tipolibretamiliAux:tipolibretamilisAux) {
			if(tipolibretamiliAux.getIsChanged()) {
				tipolibretamiliAux.setIsChanged(false);
			}		
			
			if(tipolibretamiliAux.getIsNew()) {
				tipolibretamiliAux.setIsNew(false);
			}	
			
			if(tipolibretamiliAux.getIsDeleted()) {
				tipolibretamiliAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoLibretaMili(TipoLibretaMili tipolibretamiliAux) throws Exception {
		//this.tipolibretamiliAux=tipolibretamiliAux;
		
			if(tipolibretamiliAux.getIsChanged()) {
				tipolibretamiliAux.setIsChanged(false);
			}		
			
			if(tipolibretamiliAux.getIsNew()) {
				tipolibretamiliAux.setIsNew(false);
			}	
			
			if(tipolibretamiliAux.getIsDeleted()) {
				tipolibretamiliAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoLibretaMili tipolibretamiliAsignar,TipoLibretaMili tipolibretamili) throws Exception {
		tipolibretamiliAsignar.setId(tipolibretamili.getId());	
		tipolibretamiliAsignar.setVersionRow(tipolibretamili.getVersionRow());	
		tipolibretamiliAsignar.setid_empresa(tipolibretamili.getid_empresa());
		tipolibretamiliAsignar.setempresa_descripcion(tipolibretamili.getempresa_descripcion());	
		tipolibretamiliAsignar.setcodigo(tipolibretamili.getcodigo());	
		tipolibretamiliAsignar.setnombre(tipolibretamili.getnombre());	
	}
	
	public static void inicializarTipoLibretaMili(TipoLibretaMili tipolibretamili) throws Exception {
		try {
				tipolibretamili.setId(0L);	
					
				tipolibretamili.setid_empresa(-1L);	
				tipolibretamili.setcodigo("");	
				tipolibretamili.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoLibretaMili(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoLibretaMiliConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoLibretaMiliConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoLibretaMiliConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoLibretaMili(String sTipo,Row row,Workbook workbook,TipoLibretaMili tipolibretamili,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipolibretamili.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipolibretamili.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipolibretamili.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoLibretaMili=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoLibretaMili() {
		return this.sFinalQueryTipoLibretaMili;
	}
	
	public void setsFinalQueryTipoLibretaMili(String sFinalQueryTipoLibretaMili) {
		this.sFinalQueryTipoLibretaMili= sFinalQueryTipoLibretaMili;
	}
	
	public Border resaltarSeleccionarTipoLibretaMili=null;
	
	public Border setResaltarSeleccionarTipoLibretaMili(ParametroGeneralUsuario parametroGeneralUsuario/*TipoLibretaMiliBeanSwingJInternalFrame tipolibretamiliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipolibretamiliBeanSwingJInternalFrame.jTtoolBarTipoLibretaMili.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoLibretaMili= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoLibretaMili() {
		return this.resaltarSeleccionarTipoLibretaMili;
	}
	
	public void setResaltarSeleccionarTipoLibretaMili(Border borderResaltarSeleccionarTipoLibretaMili) {
		this.resaltarSeleccionarTipoLibretaMili= borderResaltarSeleccionarTipoLibretaMili;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoLibretaMili=null;
	public Boolean mostraridTipoLibretaMili=true;
	public Boolean activaridTipoLibretaMili=true;

	public Border resaltarid_empresaTipoLibretaMili=null;
	public Boolean mostrarid_empresaTipoLibretaMili=true;
	public Boolean activarid_empresaTipoLibretaMili=true;
	public Boolean cargarid_empresaTipoLibretaMili=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoLibretaMili=false;//ConEventDepend=true

	public Border resaltarcodigoTipoLibretaMili=null;
	public Boolean mostrarcodigoTipoLibretaMili=true;
	public Boolean activarcodigoTipoLibretaMili=true;

	public Border resaltarnombreTipoLibretaMili=null;
	public Boolean mostrarnombreTipoLibretaMili=true;
	public Boolean activarnombreTipoLibretaMili=true;

	
	

	public Border setResaltaridTipoLibretaMili(ParametroGeneralUsuario parametroGeneralUsuario/*TipoLibretaMiliBeanSwingJInternalFrame tipolibretamiliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipolibretamiliBeanSwingJInternalFrame.jTtoolBarTipoLibretaMili.setBorder(borderResaltar);
		
		this.resaltaridTipoLibretaMili= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoLibretaMili() {
		return this.resaltaridTipoLibretaMili;
	}

	public void setResaltaridTipoLibretaMili(Border borderResaltar) {
		this.resaltaridTipoLibretaMili= borderResaltar;
	}

	public Boolean getMostraridTipoLibretaMili() {
		return this.mostraridTipoLibretaMili;
	}

	public void setMostraridTipoLibretaMili(Boolean mostraridTipoLibretaMili) {
		this.mostraridTipoLibretaMili= mostraridTipoLibretaMili;
	}

	public Boolean getActivaridTipoLibretaMili() {
		return this.activaridTipoLibretaMili;
	}

	public void setActivaridTipoLibretaMili(Boolean activaridTipoLibretaMili) {
		this.activaridTipoLibretaMili= activaridTipoLibretaMili;
	}

	public Border setResaltarid_empresaTipoLibretaMili(ParametroGeneralUsuario parametroGeneralUsuario/*TipoLibretaMiliBeanSwingJInternalFrame tipolibretamiliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipolibretamiliBeanSwingJInternalFrame.jTtoolBarTipoLibretaMili.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoLibretaMili= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoLibretaMili() {
		return this.resaltarid_empresaTipoLibretaMili;
	}

	public void setResaltarid_empresaTipoLibretaMili(Border borderResaltar) {
		this.resaltarid_empresaTipoLibretaMili= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoLibretaMili() {
		return this.mostrarid_empresaTipoLibretaMili;
	}

	public void setMostrarid_empresaTipoLibretaMili(Boolean mostrarid_empresaTipoLibretaMili) {
		this.mostrarid_empresaTipoLibretaMili= mostrarid_empresaTipoLibretaMili;
	}

	public Boolean getActivarid_empresaTipoLibretaMili() {
		return this.activarid_empresaTipoLibretaMili;
	}

	public void setActivarid_empresaTipoLibretaMili(Boolean activarid_empresaTipoLibretaMili) {
		this.activarid_empresaTipoLibretaMili= activarid_empresaTipoLibretaMili;
	}

	public Boolean getCargarid_empresaTipoLibretaMili() {
		return this.cargarid_empresaTipoLibretaMili;
	}

	public void setCargarid_empresaTipoLibretaMili(Boolean cargarid_empresaTipoLibretaMili) {
		this.cargarid_empresaTipoLibretaMili= cargarid_empresaTipoLibretaMili;
	}

	public Border setResaltarcodigoTipoLibretaMili(ParametroGeneralUsuario parametroGeneralUsuario/*TipoLibretaMiliBeanSwingJInternalFrame tipolibretamiliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipolibretamiliBeanSwingJInternalFrame.jTtoolBarTipoLibretaMili.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoLibretaMili= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoLibretaMili() {
		return this.resaltarcodigoTipoLibretaMili;
	}

	public void setResaltarcodigoTipoLibretaMili(Border borderResaltar) {
		this.resaltarcodigoTipoLibretaMili= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoLibretaMili() {
		return this.mostrarcodigoTipoLibretaMili;
	}

	public void setMostrarcodigoTipoLibretaMili(Boolean mostrarcodigoTipoLibretaMili) {
		this.mostrarcodigoTipoLibretaMili= mostrarcodigoTipoLibretaMili;
	}

	public Boolean getActivarcodigoTipoLibretaMili() {
		return this.activarcodigoTipoLibretaMili;
	}

	public void setActivarcodigoTipoLibretaMili(Boolean activarcodigoTipoLibretaMili) {
		this.activarcodigoTipoLibretaMili= activarcodigoTipoLibretaMili;
	}

	public Border setResaltarnombreTipoLibretaMili(ParametroGeneralUsuario parametroGeneralUsuario/*TipoLibretaMiliBeanSwingJInternalFrame tipolibretamiliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipolibretamiliBeanSwingJInternalFrame.jTtoolBarTipoLibretaMili.setBorder(borderResaltar);
		
		this.resaltarnombreTipoLibretaMili= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoLibretaMili() {
		return this.resaltarnombreTipoLibretaMili;
	}

	public void setResaltarnombreTipoLibretaMili(Border borderResaltar) {
		this.resaltarnombreTipoLibretaMili= borderResaltar;
	}

	public Boolean getMostrarnombreTipoLibretaMili() {
		return this.mostrarnombreTipoLibretaMili;
	}

	public void setMostrarnombreTipoLibretaMili(Boolean mostrarnombreTipoLibretaMili) {
		this.mostrarnombreTipoLibretaMili= mostrarnombreTipoLibretaMili;
	}

	public Boolean getActivarnombreTipoLibretaMili() {
		return this.activarnombreTipoLibretaMili;
	}

	public void setActivarnombreTipoLibretaMili(Boolean activarnombreTipoLibretaMili) {
		this.activarnombreTipoLibretaMili= activarnombreTipoLibretaMili;
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
		
		
		this.setMostraridTipoLibretaMili(esInicial);
		this.setMostrarid_empresaTipoLibretaMili(esInicial);
		this.setMostrarcodigoTipoLibretaMili(esInicial);
		this.setMostrarnombreTipoLibretaMili(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoLibretaMiliConstantesFunciones.ID)) {
				this.setMostraridTipoLibretaMili(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoLibretaMiliConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoLibretaMili(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoLibretaMiliConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoLibretaMili(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoLibretaMiliConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoLibretaMili(esAsigna);
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
		
		
		this.setActivaridTipoLibretaMili(esInicial);
		this.setActivarid_empresaTipoLibretaMili(esInicial);
		this.setActivarcodigoTipoLibretaMili(esInicial);
		this.setActivarnombreTipoLibretaMili(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoLibretaMiliConstantesFunciones.ID)) {
				this.setActivaridTipoLibretaMili(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoLibretaMiliConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoLibretaMili(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoLibretaMiliConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoLibretaMili(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoLibretaMiliConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoLibretaMili(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoLibretaMiliBeanSwingJInternalFrame tipolibretamiliBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoLibretaMili(esInicial);
		this.setResaltarid_empresaTipoLibretaMili(esInicial);
		this.setResaltarcodigoTipoLibretaMili(esInicial);
		this.setResaltarnombreTipoLibretaMili(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoLibretaMiliConstantesFunciones.ID)) {
				this.setResaltaridTipoLibretaMili(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoLibretaMiliConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoLibretaMili(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoLibretaMiliConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoLibretaMili(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoLibretaMiliConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoLibretaMili(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDatoGeneralEmpleadoTipoLibretaMili=null;

	public Border getResaltarDatoGeneralEmpleadoTipoLibretaMili() {
		return this.resaltarDatoGeneralEmpleadoTipoLibretaMili;
	}

	public void setResaltarDatoGeneralEmpleadoTipoLibretaMili(Border borderResaltarDatoGeneralEmpleado) {
		if(borderResaltarDatoGeneralEmpleado!=null) {
			this.resaltarDatoGeneralEmpleadoTipoLibretaMili= borderResaltarDatoGeneralEmpleado;
		}
	}

	public Border setResaltarDatoGeneralEmpleadoTipoLibretaMili(ParametroGeneralUsuario parametroGeneralUsuario/*TipoLibretaMiliBeanSwingJInternalFrame tipolibretamiliBeanSwingJInternalFrame*/) {
		Border borderResaltarDatoGeneralEmpleado=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipolibretamiliBeanSwingJInternalFrame.jTtoolBarTipoLibretaMili.setBorder(borderResaltarDatoGeneralEmpleado);
			
		this.resaltarDatoGeneralEmpleadoTipoLibretaMili= borderResaltarDatoGeneralEmpleado;

		 return borderResaltarDatoGeneralEmpleado;
	}



	public Boolean mostrarDatoGeneralEmpleadoTipoLibretaMili=true;

	public Boolean getMostrarDatoGeneralEmpleadoTipoLibretaMili() {
		return this.mostrarDatoGeneralEmpleadoTipoLibretaMili;
	}

	public void setMostrarDatoGeneralEmpleadoTipoLibretaMili(Boolean visibilidadResaltarDatoGeneralEmpleado) {
		this.mostrarDatoGeneralEmpleadoTipoLibretaMili= visibilidadResaltarDatoGeneralEmpleado;
	}



	public Boolean activarDatoGeneralEmpleadoTipoLibretaMili=true;

	public Boolean gethabilitarResaltarDatoGeneralEmpleadoTipoLibretaMili() {
		return this.activarDatoGeneralEmpleadoTipoLibretaMili;
	}

	public void setActivarDatoGeneralEmpleadoTipoLibretaMili(Boolean habilitarResaltarDatoGeneralEmpleado) {
		this.activarDatoGeneralEmpleadoTipoLibretaMili= habilitarResaltarDatoGeneralEmpleado;
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

		this.setMostrarDatoGeneralEmpleadoTipoLibretaMili(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DatoGeneralEmpleado.class)) {
				this.setMostrarDatoGeneralEmpleadoTipoLibretaMili(esAsigna);
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

		this.setActivarDatoGeneralEmpleadoTipoLibretaMili(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DatoGeneralEmpleado.class)) {
				this.setActivarDatoGeneralEmpleadoTipoLibretaMili(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoLibretaMiliBeanSwingJInternalFrame tipolibretamiliBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDatoGeneralEmpleadoTipoLibretaMili(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DatoGeneralEmpleado.class)) {
				this.setResaltarDatoGeneralEmpleadoTipoLibretaMili(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaTipoLibretaMili=true;

	public Boolean getMostrarFK_IdEmpresaTipoLibretaMili() {
		return this.mostrarFK_IdEmpresaTipoLibretaMili;
	}

	public void setMostrarFK_IdEmpresaTipoLibretaMili(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoLibretaMili= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTipoLibretaMili=true;

	public Boolean getActivarFK_IdEmpresaTipoLibretaMili() {
		return this.activarFK_IdEmpresaTipoLibretaMili;
	}

	public void setActivarFK_IdEmpresaTipoLibretaMili(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoLibretaMili= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTipoLibretaMili=null;

	public Border getResaltarFK_IdEmpresaTipoLibretaMili() {
		return this.resaltarFK_IdEmpresaTipoLibretaMili;
	}

	public void setResaltarFK_IdEmpresaTipoLibretaMili(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoLibretaMili= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoLibretaMili(ParametroGeneralUsuario parametroGeneralUsuario/*TipoLibretaMiliBeanSwingJInternalFrame tipolibretamiliBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoLibretaMili= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}