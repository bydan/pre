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
package com.bydan.erp.tesoreria.util;

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


import com.bydan.erp.tesoreria.util.TipoCodigoSriBancoConstantesFunciones;
import com.bydan.erp.tesoreria.util.TipoCodigoSriBancoParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.TipoCodigoSriBancoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;








//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.tesoreria.business.dataaccess.*;
//import com.bydan.erp.tesoreria.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoCodigoSriBancoConstantesFunciones extends TipoCodigoSriBancoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoCodigoSriBanco";
	public static final String SPATHOPCION="Tesoreria";	
	public static final String SPATHMODULO="tesoreria/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoCodigoSriBanco"+TipoCodigoSriBancoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoCodigoSriBancoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoCodigoSriBancoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoCodigoSriBancoConstantesFunciones.SCHEMA+"_"+TipoCodigoSriBancoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoCodigoSriBancoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoCodigoSriBancoConstantesFunciones.SCHEMA+"_"+TipoCodigoSriBancoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoCodigoSriBancoConstantesFunciones.SCHEMA+"_"+TipoCodigoSriBancoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoCodigoSriBancoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoCodigoSriBancoConstantesFunciones.SCHEMA+"_"+TipoCodigoSriBancoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCodigoSriBancoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoCodigoSriBancoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCodigoSriBancoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCodigoSriBancoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoCodigoSriBancoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCodigoSriBancoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoCodigoSriBancoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoCodigoSriBancoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoCodigoSriBancoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoCodigoSriBancoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="As";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="A";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Codigo Sri Banco";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoCodigoSriBanco";
	public static final String OBJECTNAME="tipocodigosribanco";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_TESORERIA;	
	public static final String TABLENAME="tipo_codigo_sri_banco";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipocodigosribanco from "+TipoCodigoSriBancoConstantesFunciones.SPERSISTENCENAME+" tipocodigosribanco";
	public static String QUERYSELECTNATIVE="select "+TipoCodigoSriBancoConstantesFunciones.SCHEMA+"."+TipoCodigoSriBancoConstantesFunciones.TABLENAME+".id,"+TipoCodigoSriBancoConstantesFunciones.SCHEMA+"."+TipoCodigoSriBancoConstantesFunciones.TABLENAME+".version_row,"+TipoCodigoSriBancoConstantesFunciones.SCHEMA+"."+TipoCodigoSriBancoConstantesFunciones.TABLENAME+".codigo,"+TipoCodigoSriBancoConstantesFunciones.SCHEMA+"."+TipoCodigoSriBancoConstantesFunciones.TABLENAME+".nombre from "+TipoCodigoSriBancoConstantesFunciones.SCHEMA+"."+TipoCodigoSriBancoConstantesFunciones.TABLENAME;//+" as "+TipoCodigoSriBancoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoCodigoSriBancoConstantesFuncionesAdditional tipocodigosribancoConstantesFuncionesAdditional=null;
	
	public TipoCodigoSriBancoConstantesFuncionesAdditional getTipoCodigoSriBancoConstantesFuncionesAdditional() {
		return this.tipocodigosribancoConstantesFuncionesAdditional;
	}
	
	public void setTipoCodigoSriBancoConstantesFuncionesAdditional(TipoCodigoSriBancoConstantesFuncionesAdditional tipocodigosribancoConstantesFuncionesAdditional) {
		try {
			this.tipocodigosribancoConstantesFuncionesAdditional=tipocodigosribancoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTipoCodigoSriBancoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoCodigoSriBancoConstantesFunciones.CODIGO)) {sLabelColumna=TipoCodigoSriBancoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoCodigoSriBancoConstantesFunciones.NOMBRE)) {sLabelColumna=TipoCodigoSriBancoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoCodigoSriBancoDescripcion(TipoCodigoSriBanco tipocodigosribanco) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipocodigosribanco !=null/* && tipocodigosribanco.getId()!=0*/) {
			sDescripcion=tipocodigosribanco.getcodigo();//tipocodigosribancotipocodigosribanco.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoCodigoSriBancoDescripcionDetallado(TipoCodigoSriBanco tipocodigosribanco) {
		String sDescripcion="";
			
		sDescripcion+=TipoCodigoSriBancoConstantesFunciones.ID+"=";
		sDescripcion+=tipocodigosribanco.getId().toString()+",";
		sDescripcion+=TipoCodigoSriBancoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipocodigosribanco.getVersionRow().toString()+",";
		sDescripcion+=TipoCodigoSriBancoConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipocodigosribanco.getcodigo()+",";
		sDescripcion+=TipoCodigoSriBancoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipocodigosribanco.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoCodigoSriBancoDescripcion(TipoCodigoSriBanco tipocodigosribanco,String sValor) throws Exception {			
		if(tipocodigosribanco !=null) {
			tipocodigosribanco.setcodigo(sValor);;//tipocodigosribancotipocodigosribanco.getcodigo().trim();
		}		
	}
	
		
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoCodigoSriBanco(TipoCodigoSriBanco tipocodigosribanco,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipocodigosribanco.setcodigo(tipocodigosribanco.getcodigo().trim());
		tipocodigosribanco.setnombre(tipocodigosribanco.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoCodigoSriBancos(List<TipoCodigoSriBanco> tipocodigosribancos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoCodigoSriBanco tipocodigosribanco: tipocodigosribancos) {
			tipocodigosribanco.setcodigo(tipocodigosribanco.getcodigo().trim());
			tipocodigosribanco.setnombre(tipocodigosribanco.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoCodigoSriBanco(TipoCodigoSriBanco tipocodigosribanco,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipocodigosribanco.getConCambioAuxiliar()) {
			tipocodigosribanco.setIsDeleted(tipocodigosribanco.getIsDeletedAuxiliar());	
			tipocodigosribanco.setIsNew(tipocodigosribanco.getIsNewAuxiliar());	
			tipocodigosribanco.setIsChanged(tipocodigosribanco.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipocodigosribanco.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipocodigosribanco.setIsDeletedAuxiliar(false);	
			tipocodigosribanco.setIsNewAuxiliar(false);	
			tipocodigosribanco.setIsChangedAuxiliar(false);
			
			tipocodigosribanco.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoCodigoSriBancos(List<TipoCodigoSriBanco> tipocodigosribancos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoCodigoSriBanco tipocodigosribanco : tipocodigosribancos) {
			if(conAsignarBase && tipocodigosribanco.getConCambioAuxiliar()) {
				tipocodigosribanco.setIsDeleted(tipocodigosribanco.getIsDeletedAuxiliar());	
				tipocodigosribanco.setIsNew(tipocodigosribanco.getIsNewAuxiliar());	
				tipocodigosribanco.setIsChanged(tipocodigosribanco.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipocodigosribanco.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipocodigosribanco.setIsDeletedAuxiliar(false);	
				tipocodigosribanco.setIsNewAuxiliar(false);	
				tipocodigosribanco.setIsChangedAuxiliar(false);
				
				tipocodigosribanco.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoCodigoSriBanco(TipoCodigoSriBanco tipocodigosribanco,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoCodigoSriBancos(List<TipoCodigoSriBanco> tipocodigosribancos,Boolean conEnteros) throws Exception  {
		
		for(TipoCodigoSriBanco tipocodigosribanco: tipocodigosribancos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoCodigoSriBanco(List<TipoCodigoSriBanco> tipocodigosribancos,TipoCodigoSriBanco tipocodigosribancoAux) throws Exception  {
		TipoCodigoSriBancoConstantesFunciones.InicializarValoresTipoCodigoSriBanco(tipocodigosribancoAux,true);
		
		for(TipoCodigoSriBanco tipocodigosribanco: tipocodigosribancos) {
			if(tipocodigosribanco.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoCodigoSriBanco(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoCodigoSriBancoConstantesFunciones.getArrayColumnasGlobalesTipoCodigoSriBanco(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoCodigoSriBanco(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoCodigoSriBanco(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoCodigoSriBanco> tipocodigosribancos,TipoCodigoSriBanco tipocodigosribanco,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoCodigoSriBanco tipocodigosribancoAux: tipocodigosribancos) {
			if(tipocodigosribancoAux!=null && tipocodigosribanco!=null) {
				if((tipocodigosribancoAux.getId()==null && tipocodigosribanco.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipocodigosribancoAux.getId()!=null && tipocodigosribanco.getId()!=null){
					if(tipocodigosribancoAux.getId().equals(tipocodigosribanco.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoCodigoSriBanco(List<TipoCodigoSriBanco> tipocodigosribancos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoCodigoSriBanco tipocodigosribanco: tipocodigosribancos) {			
			if(tipocodigosribanco.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoCodigoSriBanco() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoCodigoSriBancoConstantesFunciones.LABEL_ID, TipoCodigoSriBancoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCodigoSriBancoConstantesFunciones.LABEL_VERSIONROW, TipoCodigoSriBancoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCodigoSriBancoConstantesFunciones.LABEL_CODIGO, TipoCodigoSriBancoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCodigoSriBancoConstantesFunciones.LABEL_NOMBRE, TipoCodigoSriBancoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoCodigoSriBanco() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoCodigoSriBancoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCodigoSriBancoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCodigoSriBancoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCodigoSriBancoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCodigoSriBanco() throws Exception  {
		return TipoCodigoSriBancoConstantesFunciones.getTiposSeleccionarTipoCodigoSriBanco(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCodigoSriBanco(Boolean conFk) throws Exception  {
		return TipoCodigoSriBancoConstantesFunciones.getTiposSeleccionarTipoCodigoSriBanco(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCodigoSriBanco(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoCodigoSriBancoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoCodigoSriBancoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoCodigoSriBancoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoCodigoSriBancoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoCodigoSriBanco(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoCodigoSriBanco(TipoCodigoSriBanco tipocodigosribancoAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoCodigoSriBanco(List<TipoCodigoSriBanco> tipocodigosribancosTemp) throws Exception {
		for(TipoCodigoSriBanco tipocodigosribancoAux:tipocodigosribancosTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoCodigoSriBanco(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoCodigoSriBanco(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoCodigoSriBanco(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoCodigoSriBancoConstantesFunciones.getClassesRelationshipsOfTipoCodigoSriBanco(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoCodigoSriBanco(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoCodigoSriBanco(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoCodigoSriBancoConstantesFunciones.getClassesRelationshipsFromStringsOfTipoCodigoSriBanco(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoCodigoSriBanco(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoCodigoSriBanco tipocodigosribanco,List<TipoCodigoSriBanco> tipocodigosribancos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoCodigoSriBanco tipocodigosribancoEncontrado=null;
			
			for(TipoCodigoSriBanco tipocodigosribancoLocal:tipocodigosribancos) {
				if(tipocodigosribancoLocal.getId().equals(tipocodigosribanco.getId())) {
					tipocodigosribancoEncontrado=tipocodigosribancoLocal;
					
					tipocodigosribancoLocal.setIsChanged(tipocodigosribanco.getIsChanged());
					tipocodigosribancoLocal.setIsNew(tipocodigosribanco.getIsNew());
					tipocodigosribancoLocal.setIsDeleted(tipocodigosribanco.getIsDeleted());
					
					tipocodigosribancoLocal.setGeneralEntityOriginal(tipocodigosribanco.getGeneralEntityOriginal());
					
					tipocodigosribancoLocal.setId(tipocodigosribanco.getId());	
					tipocodigosribancoLocal.setVersionRow(tipocodigosribanco.getVersionRow());	
					tipocodigosribancoLocal.setcodigo(tipocodigosribanco.getcodigo());	
					tipocodigosribancoLocal.setnombre(tipocodigosribanco.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipocodigosribanco.getIsDeleted()) {
				if(!existe) {
					tipocodigosribancos.add(tipocodigosribanco);
				}
			} else {
				if(tipocodigosribancoEncontrado!=null && permiteQuitar)  {
					tipocodigosribancos.remove(tipocodigosribancoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoCodigoSriBanco tipocodigosribanco,List<TipoCodigoSriBanco> tipocodigosribancos) throws Exception {
		try	{			
			for(TipoCodigoSriBanco tipocodigosribancoLocal:tipocodigosribancos) {
				if(tipocodigosribancoLocal.getId().equals(tipocodigosribanco.getId())) {
					tipocodigosribancoLocal.setIsSelected(tipocodigosribanco.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoCodigoSriBanco(List<TipoCodigoSriBanco> tipocodigosribancosAux) throws Exception {
		//this.tipocodigosribancosAux=tipocodigosribancosAux;
		
		for(TipoCodigoSriBanco tipocodigosribancoAux:tipocodigosribancosAux) {
			if(tipocodigosribancoAux.getIsChanged()) {
				tipocodigosribancoAux.setIsChanged(false);
			}		
			
			if(tipocodigosribancoAux.getIsNew()) {
				tipocodigosribancoAux.setIsNew(false);
			}	
			
			if(tipocodigosribancoAux.getIsDeleted()) {
				tipocodigosribancoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoCodigoSriBanco(TipoCodigoSriBanco tipocodigosribancoAux) throws Exception {
		//this.tipocodigosribancoAux=tipocodigosribancoAux;
		
			if(tipocodigosribancoAux.getIsChanged()) {
				tipocodigosribancoAux.setIsChanged(false);
			}		
			
			if(tipocodigosribancoAux.getIsNew()) {
				tipocodigosribancoAux.setIsNew(false);
			}	
			
			if(tipocodigosribancoAux.getIsDeleted()) {
				tipocodigosribancoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoCodigoSriBanco tipocodigosribancoAsignar,TipoCodigoSriBanco tipocodigosribanco) throws Exception {
		tipocodigosribancoAsignar.setId(tipocodigosribanco.getId());	
		tipocodigosribancoAsignar.setVersionRow(tipocodigosribanco.getVersionRow());	
		tipocodigosribancoAsignar.setcodigo(tipocodigosribanco.getcodigo());	
		tipocodigosribancoAsignar.setnombre(tipocodigosribanco.getnombre());	
	}
	
	public static void inicializarTipoCodigoSriBanco(TipoCodigoSriBanco tipocodigosribanco) throws Exception {
		try {
				tipocodigosribanco.setId(0L);	
					
				tipocodigosribanco.setcodigo("");	
				tipocodigosribanco.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoCodigoSriBanco(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoCodigoSriBancoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoCodigoSriBancoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoCodigoSriBanco(String sTipo,Row row,Workbook workbook,TipoCodigoSriBanco tipocodigosribanco,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocodigosribanco.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocodigosribanco.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoCodigoSriBanco=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoCodigoSriBanco() {
		return this.sFinalQueryTipoCodigoSriBanco;
	}
	
	public void setsFinalQueryTipoCodigoSriBanco(String sFinalQueryTipoCodigoSriBanco) {
		this.sFinalQueryTipoCodigoSriBanco= sFinalQueryTipoCodigoSriBanco;
	}
	
	public Border resaltarSeleccionarTipoCodigoSriBanco=null;
	
	public Border setResaltarSeleccionarTipoCodigoSriBanco(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCodigoSriBancoBeanSwingJInternalFrame tipocodigosribancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipocodigosribancoBeanSwingJInternalFrame.jTtoolBarTipoCodigoSriBanco.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoCodigoSriBanco= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoCodigoSriBanco() {
		return this.resaltarSeleccionarTipoCodigoSriBanco;
	}
	
	public void setResaltarSeleccionarTipoCodigoSriBanco(Border borderResaltarSeleccionarTipoCodigoSriBanco) {
		this.resaltarSeleccionarTipoCodigoSriBanco= borderResaltarSeleccionarTipoCodigoSriBanco;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoCodigoSriBanco=null;
	public Boolean mostraridTipoCodigoSriBanco=true;
	public Boolean activaridTipoCodigoSriBanco=true;

	public Border resaltarcodigoTipoCodigoSriBanco=null;
	public Boolean mostrarcodigoTipoCodigoSriBanco=true;
	public Boolean activarcodigoTipoCodigoSriBanco=true;

	public Border resaltarnombreTipoCodigoSriBanco=null;
	public Boolean mostrarnombreTipoCodigoSriBanco=true;
	public Boolean activarnombreTipoCodigoSriBanco=true;

	
	

	public Border setResaltaridTipoCodigoSriBanco(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCodigoSriBancoBeanSwingJInternalFrame tipocodigosribancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocodigosribancoBeanSwingJInternalFrame.jTtoolBarTipoCodigoSriBanco.setBorder(borderResaltar);
		
		this.resaltaridTipoCodigoSriBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoCodigoSriBanco() {
		return this.resaltaridTipoCodigoSriBanco;
	}

	public void setResaltaridTipoCodigoSriBanco(Border borderResaltar) {
		this.resaltaridTipoCodigoSriBanco= borderResaltar;
	}

	public Boolean getMostraridTipoCodigoSriBanco() {
		return this.mostraridTipoCodigoSriBanco;
	}

	public void setMostraridTipoCodigoSriBanco(Boolean mostraridTipoCodigoSriBanco) {
		this.mostraridTipoCodigoSriBanco= mostraridTipoCodigoSriBanco;
	}

	public Boolean getActivaridTipoCodigoSriBanco() {
		return this.activaridTipoCodigoSriBanco;
	}

	public void setActivaridTipoCodigoSriBanco(Boolean activaridTipoCodigoSriBanco) {
		this.activaridTipoCodigoSriBanco= activaridTipoCodigoSriBanco;
	}

	public Border setResaltarcodigoTipoCodigoSriBanco(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCodigoSriBancoBeanSwingJInternalFrame tipocodigosribancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocodigosribancoBeanSwingJInternalFrame.jTtoolBarTipoCodigoSriBanco.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoCodigoSriBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoCodigoSriBanco() {
		return this.resaltarcodigoTipoCodigoSriBanco;
	}

	public void setResaltarcodigoTipoCodigoSriBanco(Border borderResaltar) {
		this.resaltarcodigoTipoCodigoSriBanco= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoCodigoSriBanco() {
		return this.mostrarcodigoTipoCodigoSriBanco;
	}

	public void setMostrarcodigoTipoCodigoSriBanco(Boolean mostrarcodigoTipoCodigoSriBanco) {
		this.mostrarcodigoTipoCodigoSriBanco= mostrarcodigoTipoCodigoSriBanco;
	}

	public Boolean getActivarcodigoTipoCodigoSriBanco() {
		return this.activarcodigoTipoCodigoSriBanco;
	}

	public void setActivarcodigoTipoCodigoSriBanco(Boolean activarcodigoTipoCodigoSriBanco) {
		this.activarcodigoTipoCodigoSriBanco= activarcodigoTipoCodigoSriBanco;
	}

	public Border setResaltarnombreTipoCodigoSriBanco(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCodigoSriBancoBeanSwingJInternalFrame tipocodigosribancoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocodigosribancoBeanSwingJInternalFrame.jTtoolBarTipoCodigoSriBanco.setBorder(borderResaltar);
		
		this.resaltarnombreTipoCodigoSriBanco= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoCodigoSriBanco() {
		return this.resaltarnombreTipoCodigoSriBanco;
	}

	public void setResaltarnombreTipoCodigoSriBanco(Border borderResaltar) {
		this.resaltarnombreTipoCodigoSriBanco= borderResaltar;
	}

	public Boolean getMostrarnombreTipoCodigoSriBanco() {
		return this.mostrarnombreTipoCodigoSriBanco;
	}

	public void setMostrarnombreTipoCodigoSriBanco(Boolean mostrarnombreTipoCodigoSriBanco) {
		this.mostrarnombreTipoCodigoSriBanco= mostrarnombreTipoCodigoSriBanco;
	}

	public Boolean getActivarnombreTipoCodigoSriBanco() {
		return this.activarnombreTipoCodigoSriBanco;
	}

	public void setActivarnombreTipoCodigoSriBanco(Boolean activarnombreTipoCodigoSriBanco) {
		this.activarnombreTipoCodigoSriBanco= activarnombreTipoCodigoSriBanco;
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
		
		
		this.setMostraridTipoCodigoSriBanco(esInicial);
		this.setMostrarcodigoTipoCodigoSriBanco(esInicial);
		this.setMostrarnombreTipoCodigoSriBanco(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoCodigoSriBancoConstantesFunciones.ID)) {
				this.setMostraridTipoCodigoSriBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCodigoSriBancoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoCodigoSriBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCodigoSriBancoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoCodigoSriBanco(esAsigna);
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
		
		
		this.setActivaridTipoCodigoSriBanco(esInicial);
		this.setActivarcodigoTipoCodigoSriBanco(esInicial);
		this.setActivarnombreTipoCodigoSriBanco(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoCodigoSriBancoConstantesFunciones.ID)) {
				this.setActivaridTipoCodigoSriBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCodigoSriBancoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoCodigoSriBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCodigoSriBancoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoCodigoSriBanco(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoCodigoSriBancoBeanSwingJInternalFrame tipocodigosribancoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoCodigoSriBanco(esInicial);
		this.setResaltarcodigoTipoCodigoSriBanco(esInicial);
		this.setResaltarnombreTipoCodigoSriBanco(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoCodigoSriBancoConstantesFunciones.ID)) {
				this.setResaltaridTipoCodigoSriBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCodigoSriBancoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoCodigoSriBanco(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCodigoSriBancoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoCodigoSriBanco(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoCodigoSriBancoBeanSwingJInternalFrame tipocodigosribancoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	
	//CONTROL_FUNCION2
}