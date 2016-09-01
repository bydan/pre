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
package com.bydan.erp.activosfijos.util;

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


import com.bydan.erp.activosfijos.util.PartidaPresuConstantesFunciones;
import com.bydan.erp.activosfijos.util.PartidaPresuParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.PartidaPresuParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.activosfijos.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.activosfijos.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.activosfijos.business.dataaccess.*;
//import com.bydan.erp.activosfijos.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class PartidaPresuConstantesFunciones extends PartidaPresuConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="PartidaPresu";
	public static final String SPATHOPCION="ActivosFijos";	
	public static final String SPATHMODULO="activosfijos/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="PartidaPresu"+PartidaPresuConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="PartidaPresuHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="PartidaPresuHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=PartidaPresuConstantesFunciones.SCHEMA+"_"+PartidaPresuConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/PartidaPresuHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=PartidaPresuConstantesFunciones.SCHEMA+"_"+PartidaPresuConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=PartidaPresuConstantesFunciones.SCHEMA+"_"+PartidaPresuConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/PartidaPresuHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=PartidaPresuConstantesFunciones.SCHEMA+"_"+PartidaPresuConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PartidaPresuConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PartidaPresuHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PartidaPresuConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PartidaPresuConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PartidaPresuHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PartidaPresuConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=PartidaPresuConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+PartidaPresuConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=PartidaPresuConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+PartidaPresuConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Partida Presupuestarias";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Partida Presupuestaria";
	public static final String SCLASSWEBTITULO_LOWER="Partida Presu";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="PartidaPresu";
	public static final String OBJECTNAME="partidapresu";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_ACTIVOSFIJOS;	
	public static final String TABLENAME="partida_presu";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select partidapresu from "+PartidaPresuConstantesFunciones.SPERSISTENCENAME+" partidapresu";
	public static String QUERYSELECTNATIVE="select "+PartidaPresuConstantesFunciones.SCHEMA+"."+PartidaPresuConstantesFunciones.TABLENAME+".id,"+PartidaPresuConstantesFunciones.SCHEMA+"."+PartidaPresuConstantesFunciones.TABLENAME+".version_row,"+PartidaPresuConstantesFunciones.SCHEMA+"."+PartidaPresuConstantesFunciones.TABLENAME+".id_empresa,"+PartidaPresuConstantesFunciones.SCHEMA+"."+PartidaPresuConstantesFunciones.TABLENAME+".codigo,"+PartidaPresuConstantesFunciones.SCHEMA+"."+PartidaPresuConstantesFunciones.TABLENAME+".nombre from "+PartidaPresuConstantesFunciones.SCHEMA+"."+PartidaPresuConstantesFunciones.TABLENAME;//+" as "+PartidaPresuConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected PartidaPresuConstantesFuncionesAdditional partidapresuConstantesFuncionesAdditional=null;
	
	public PartidaPresuConstantesFuncionesAdditional getPartidaPresuConstantesFuncionesAdditional() {
		return this.partidapresuConstantesFuncionesAdditional;
	}
	
	public void setPartidaPresuConstantesFuncionesAdditional(PartidaPresuConstantesFuncionesAdditional partidapresuConstantesFuncionesAdditional) {
		try {
			this.partidapresuConstantesFuncionesAdditional=partidapresuConstantesFuncionesAdditional;
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
	
	public static String getPartidaPresuLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(PartidaPresuConstantesFunciones.IDEMPRESA)) {sLabelColumna=PartidaPresuConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(PartidaPresuConstantesFunciones.CODIGO)) {sLabelColumna=PartidaPresuConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(PartidaPresuConstantesFunciones.NOMBRE)) {sLabelColumna=PartidaPresuConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getPartidaPresuDescripcion(PartidaPresu partidapresu) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(partidapresu !=null/* && partidapresu.getId()!=0*/) {
			sDescripcion=partidapresu.getcodigo();//partidapresupartidapresu.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getPartidaPresuDescripcionDetallado(PartidaPresu partidapresu) {
		String sDescripcion="";
			
		sDescripcion+=PartidaPresuConstantesFunciones.ID+"=";
		sDescripcion+=partidapresu.getId().toString()+",";
		sDescripcion+=PartidaPresuConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=partidapresu.getVersionRow().toString()+",";
		sDescripcion+=PartidaPresuConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=partidapresu.getid_empresa().toString()+",";
		sDescripcion+=PartidaPresuConstantesFunciones.CODIGO+"=";
		sDescripcion+=partidapresu.getcodigo()+",";
		sDescripcion+=PartidaPresuConstantesFunciones.NOMBRE+"=";
		sDescripcion+=partidapresu.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setPartidaPresuDescripcion(PartidaPresu partidapresu,String sValor) throws Exception {			
		if(partidapresu !=null) {
			partidapresu.setcodigo(sValor);;//partidapresupartidapresu.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosPartidaPresu(PartidaPresu partidapresu,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		partidapresu.setcodigo(partidapresu.getcodigo().trim());
		partidapresu.setnombre(partidapresu.getnombre().trim());
	}
	
	public static void quitarEspaciosPartidaPresus(List<PartidaPresu> partidapresus,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PartidaPresu partidapresu: partidapresus) {
			partidapresu.setcodigo(partidapresu.getcodigo().trim());
			partidapresu.setnombre(partidapresu.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPartidaPresu(PartidaPresu partidapresu,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && partidapresu.getConCambioAuxiliar()) {
			partidapresu.setIsDeleted(partidapresu.getIsDeletedAuxiliar());	
			partidapresu.setIsNew(partidapresu.getIsNewAuxiliar());	
			partidapresu.setIsChanged(partidapresu.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			partidapresu.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			partidapresu.setIsDeletedAuxiliar(false);	
			partidapresu.setIsNewAuxiliar(false);	
			partidapresu.setIsChangedAuxiliar(false);
			
			partidapresu.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPartidaPresus(List<PartidaPresu> partidapresus,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(PartidaPresu partidapresu : partidapresus) {
			if(conAsignarBase && partidapresu.getConCambioAuxiliar()) {
				partidapresu.setIsDeleted(partidapresu.getIsDeletedAuxiliar());	
				partidapresu.setIsNew(partidapresu.getIsNewAuxiliar());	
				partidapresu.setIsChanged(partidapresu.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				partidapresu.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				partidapresu.setIsDeletedAuxiliar(false);	
				partidapresu.setIsNewAuxiliar(false);	
				partidapresu.setIsChangedAuxiliar(false);
				
				partidapresu.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresPartidaPresu(PartidaPresu partidapresu,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresPartidaPresus(List<PartidaPresu> partidapresus,Boolean conEnteros) throws Exception  {
		
		for(PartidaPresu partidapresu: partidapresus) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaPartidaPresu(List<PartidaPresu> partidapresus,PartidaPresu partidapresuAux) throws Exception  {
		PartidaPresuConstantesFunciones.InicializarValoresPartidaPresu(partidapresuAux,true);
		
		for(PartidaPresu partidapresu: partidapresus) {
			if(partidapresu.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPartidaPresu(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=PartidaPresuConstantesFunciones.getArrayColumnasGlobalesPartidaPresu(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesPartidaPresu(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PartidaPresuConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PartidaPresuConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoPartidaPresu(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PartidaPresu> partidapresus,PartidaPresu partidapresu,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PartidaPresu partidapresuAux: partidapresus) {
			if(partidapresuAux!=null && partidapresu!=null) {
				if((partidapresuAux.getId()==null && partidapresu.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(partidapresuAux.getId()!=null && partidapresu.getId()!=null){
					if(partidapresuAux.getId().equals(partidapresu.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPartidaPresu(List<PartidaPresu> partidapresus) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(PartidaPresu partidapresu: partidapresus) {			
			if(partidapresu.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaPartidaPresu() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,PartidaPresuConstantesFunciones.LABEL_ID, PartidaPresuConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PartidaPresuConstantesFunciones.LABEL_VERSIONROW, PartidaPresuConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PartidaPresuConstantesFunciones.LABEL_IDEMPRESA, PartidaPresuConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PartidaPresuConstantesFunciones.LABEL_CODIGO, PartidaPresuConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PartidaPresuConstantesFunciones.LABEL_NOMBRE, PartidaPresuConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasPartidaPresu() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=PartidaPresuConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PartidaPresuConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PartidaPresuConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PartidaPresuConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PartidaPresuConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPartidaPresu() throws Exception  {
		return PartidaPresuConstantesFunciones.getTiposSeleccionarPartidaPresu(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPartidaPresu(Boolean conFk) throws Exception  {
		return PartidaPresuConstantesFunciones.getTiposSeleccionarPartidaPresu(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPartidaPresu(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PartidaPresuConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(PartidaPresuConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PartidaPresuConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(PartidaPresuConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PartidaPresuConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(PartidaPresuConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesPartidaPresu(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesPartidaPresu(PartidaPresu partidapresuAux) throws Exception {
		
			partidapresuAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(partidapresuAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesPartidaPresu(List<PartidaPresu> partidapresusTemp) throws Exception {
		for(PartidaPresu partidapresuAux:partidapresusTemp) {
			
			partidapresuAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(partidapresuAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfPartidaPresu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfPartidaPresu(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfPartidaPresu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return PartidaPresuConstantesFunciones.getClassesRelationshipsOfPartidaPresu(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPartidaPresu(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DetalleActivoFijo.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleActivoFijo.class)) {
						classes.add(new Classe(DetalleActivoFijo.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPartidaPresu(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return PartidaPresuConstantesFunciones.getClassesRelationshipsFromStringsOfPartidaPresu(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPartidaPresu(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleActivoFijo.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleActivoFijo.class)); continue;
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
	public static void actualizarLista(PartidaPresu partidapresu,List<PartidaPresu> partidapresus,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			PartidaPresu partidapresuEncontrado=null;
			
			for(PartidaPresu partidapresuLocal:partidapresus) {
				if(partidapresuLocal.getId().equals(partidapresu.getId())) {
					partidapresuEncontrado=partidapresuLocal;
					
					partidapresuLocal.setIsChanged(partidapresu.getIsChanged());
					partidapresuLocal.setIsNew(partidapresu.getIsNew());
					partidapresuLocal.setIsDeleted(partidapresu.getIsDeleted());
					
					partidapresuLocal.setGeneralEntityOriginal(partidapresu.getGeneralEntityOriginal());
					
					partidapresuLocal.setId(partidapresu.getId());	
					partidapresuLocal.setVersionRow(partidapresu.getVersionRow());	
					partidapresuLocal.setid_empresa(partidapresu.getid_empresa());	
					partidapresuLocal.setcodigo(partidapresu.getcodigo());	
					partidapresuLocal.setnombre(partidapresu.getnombre());	
					
					
					partidapresuLocal.setDetalleActivoFijos(partidapresu.getDetalleActivoFijos());
					
					existe=true;
					break;
				}
			}
			
			if(!partidapresu.getIsDeleted()) {
				if(!existe) {
					partidapresus.add(partidapresu);
				}
			} else {
				if(partidapresuEncontrado!=null && permiteQuitar)  {
					partidapresus.remove(partidapresuEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(PartidaPresu partidapresu,List<PartidaPresu> partidapresus) throws Exception {
		try	{			
			for(PartidaPresu partidapresuLocal:partidapresus) {
				if(partidapresuLocal.getId().equals(partidapresu.getId())) {
					partidapresuLocal.setIsSelected(partidapresu.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesPartidaPresu(List<PartidaPresu> partidapresusAux) throws Exception {
		//this.partidapresusAux=partidapresusAux;
		
		for(PartidaPresu partidapresuAux:partidapresusAux) {
			if(partidapresuAux.getIsChanged()) {
				partidapresuAux.setIsChanged(false);
			}		
			
			if(partidapresuAux.getIsNew()) {
				partidapresuAux.setIsNew(false);
			}	
			
			if(partidapresuAux.getIsDeleted()) {
				partidapresuAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesPartidaPresu(PartidaPresu partidapresuAux) throws Exception {
		//this.partidapresuAux=partidapresuAux;
		
			if(partidapresuAux.getIsChanged()) {
				partidapresuAux.setIsChanged(false);
			}		
			
			if(partidapresuAux.getIsNew()) {
				partidapresuAux.setIsNew(false);
			}	
			
			if(partidapresuAux.getIsDeleted()) {
				partidapresuAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(PartidaPresu partidapresuAsignar,PartidaPresu partidapresu) throws Exception {
		partidapresuAsignar.setId(partidapresu.getId());	
		partidapresuAsignar.setVersionRow(partidapresu.getVersionRow());	
		partidapresuAsignar.setid_empresa(partidapresu.getid_empresa());
		partidapresuAsignar.setempresa_descripcion(partidapresu.getempresa_descripcion());	
		partidapresuAsignar.setcodigo(partidapresu.getcodigo());	
		partidapresuAsignar.setnombre(partidapresu.getnombre());	
	}
	
	public static void inicializarPartidaPresu(PartidaPresu partidapresu) throws Exception {
		try {
				partidapresu.setId(0L);	
					
				partidapresu.setid_empresa(-1L);	
				partidapresu.setcodigo("");	
				partidapresu.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderPartidaPresu(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(PartidaPresuConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PartidaPresuConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PartidaPresuConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataPartidaPresu(String sTipo,Row row,Workbook workbook,PartidaPresu partidapresu,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(partidapresu.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(partidapresu.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(partidapresu.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryPartidaPresu=Constantes.SFINALQUERY;
	
	public String getsFinalQueryPartidaPresu() {
		return this.sFinalQueryPartidaPresu;
	}
	
	public void setsFinalQueryPartidaPresu(String sFinalQueryPartidaPresu) {
		this.sFinalQueryPartidaPresu= sFinalQueryPartidaPresu;
	}
	
	public Border resaltarSeleccionarPartidaPresu=null;
	
	public Border setResaltarSeleccionarPartidaPresu(ParametroGeneralUsuario parametroGeneralUsuario/*PartidaPresuBeanSwingJInternalFrame partidapresuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//partidapresuBeanSwingJInternalFrame.jTtoolBarPartidaPresu.setBorder(borderResaltar);
		
		this.resaltarSeleccionarPartidaPresu= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarPartidaPresu() {
		return this.resaltarSeleccionarPartidaPresu;
	}
	
	public void setResaltarSeleccionarPartidaPresu(Border borderResaltarSeleccionarPartidaPresu) {
		this.resaltarSeleccionarPartidaPresu= borderResaltarSeleccionarPartidaPresu;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridPartidaPresu=null;
	public Boolean mostraridPartidaPresu=true;
	public Boolean activaridPartidaPresu=true;

	public Border resaltarid_empresaPartidaPresu=null;
	public Boolean mostrarid_empresaPartidaPresu=true;
	public Boolean activarid_empresaPartidaPresu=true;
	public Boolean cargarid_empresaPartidaPresu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaPartidaPresu=false;//ConEventDepend=true

	public Border resaltarcodigoPartidaPresu=null;
	public Boolean mostrarcodigoPartidaPresu=true;
	public Boolean activarcodigoPartidaPresu=true;

	public Border resaltarnombrePartidaPresu=null;
	public Boolean mostrarnombrePartidaPresu=true;
	public Boolean activarnombrePartidaPresu=true;

	
	

	public Border setResaltaridPartidaPresu(ParametroGeneralUsuario parametroGeneralUsuario/*PartidaPresuBeanSwingJInternalFrame partidapresuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//partidapresuBeanSwingJInternalFrame.jTtoolBarPartidaPresu.setBorder(borderResaltar);
		
		this.resaltaridPartidaPresu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridPartidaPresu() {
		return this.resaltaridPartidaPresu;
	}

	public void setResaltaridPartidaPresu(Border borderResaltar) {
		this.resaltaridPartidaPresu= borderResaltar;
	}

	public Boolean getMostraridPartidaPresu() {
		return this.mostraridPartidaPresu;
	}

	public void setMostraridPartidaPresu(Boolean mostraridPartidaPresu) {
		this.mostraridPartidaPresu= mostraridPartidaPresu;
	}

	public Boolean getActivaridPartidaPresu() {
		return this.activaridPartidaPresu;
	}

	public void setActivaridPartidaPresu(Boolean activaridPartidaPresu) {
		this.activaridPartidaPresu= activaridPartidaPresu;
	}

	public Border setResaltarid_empresaPartidaPresu(ParametroGeneralUsuario parametroGeneralUsuario/*PartidaPresuBeanSwingJInternalFrame partidapresuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//partidapresuBeanSwingJInternalFrame.jTtoolBarPartidaPresu.setBorder(borderResaltar);
		
		this.resaltarid_empresaPartidaPresu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaPartidaPresu() {
		return this.resaltarid_empresaPartidaPresu;
	}

	public void setResaltarid_empresaPartidaPresu(Border borderResaltar) {
		this.resaltarid_empresaPartidaPresu= borderResaltar;
	}

	public Boolean getMostrarid_empresaPartidaPresu() {
		return this.mostrarid_empresaPartidaPresu;
	}

	public void setMostrarid_empresaPartidaPresu(Boolean mostrarid_empresaPartidaPresu) {
		this.mostrarid_empresaPartidaPresu= mostrarid_empresaPartidaPresu;
	}

	public Boolean getActivarid_empresaPartidaPresu() {
		return this.activarid_empresaPartidaPresu;
	}

	public void setActivarid_empresaPartidaPresu(Boolean activarid_empresaPartidaPresu) {
		this.activarid_empresaPartidaPresu= activarid_empresaPartidaPresu;
	}

	public Boolean getCargarid_empresaPartidaPresu() {
		return this.cargarid_empresaPartidaPresu;
	}

	public void setCargarid_empresaPartidaPresu(Boolean cargarid_empresaPartidaPresu) {
		this.cargarid_empresaPartidaPresu= cargarid_empresaPartidaPresu;
	}

	public Border setResaltarcodigoPartidaPresu(ParametroGeneralUsuario parametroGeneralUsuario/*PartidaPresuBeanSwingJInternalFrame partidapresuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//partidapresuBeanSwingJInternalFrame.jTtoolBarPartidaPresu.setBorder(borderResaltar);
		
		this.resaltarcodigoPartidaPresu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoPartidaPresu() {
		return this.resaltarcodigoPartidaPresu;
	}

	public void setResaltarcodigoPartidaPresu(Border borderResaltar) {
		this.resaltarcodigoPartidaPresu= borderResaltar;
	}

	public Boolean getMostrarcodigoPartidaPresu() {
		return this.mostrarcodigoPartidaPresu;
	}

	public void setMostrarcodigoPartidaPresu(Boolean mostrarcodigoPartidaPresu) {
		this.mostrarcodigoPartidaPresu= mostrarcodigoPartidaPresu;
	}

	public Boolean getActivarcodigoPartidaPresu() {
		return this.activarcodigoPartidaPresu;
	}

	public void setActivarcodigoPartidaPresu(Boolean activarcodigoPartidaPresu) {
		this.activarcodigoPartidaPresu= activarcodigoPartidaPresu;
	}

	public Border setResaltarnombrePartidaPresu(ParametroGeneralUsuario parametroGeneralUsuario/*PartidaPresuBeanSwingJInternalFrame partidapresuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//partidapresuBeanSwingJInternalFrame.jTtoolBarPartidaPresu.setBorder(borderResaltar);
		
		this.resaltarnombrePartidaPresu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombrePartidaPresu() {
		return this.resaltarnombrePartidaPresu;
	}

	public void setResaltarnombrePartidaPresu(Border borderResaltar) {
		this.resaltarnombrePartidaPresu= borderResaltar;
	}

	public Boolean getMostrarnombrePartidaPresu() {
		return this.mostrarnombrePartidaPresu;
	}

	public void setMostrarnombrePartidaPresu(Boolean mostrarnombrePartidaPresu) {
		this.mostrarnombrePartidaPresu= mostrarnombrePartidaPresu;
	}

	public Boolean getActivarnombrePartidaPresu() {
		return this.activarnombrePartidaPresu;
	}

	public void setActivarnombrePartidaPresu(Boolean activarnombrePartidaPresu) {
		this.activarnombrePartidaPresu= activarnombrePartidaPresu;
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
		
		
		this.setMostraridPartidaPresu(esInicial);
		this.setMostrarid_empresaPartidaPresu(esInicial);
		this.setMostrarcodigoPartidaPresu(esInicial);
		this.setMostrarnombrePartidaPresu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PartidaPresuConstantesFunciones.ID)) {
				this.setMostraridPartidaPresu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PartidaPresuConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaPartidaPresu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PartidaPresuConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoPartidaPresu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PartidaPresuConstantesFunciones.NOMBRE)) {
				this.setMostrarnombrePartidaPresu(esAsigna);
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
		
		
		this.setActivaridPartidaPresu(esInicial);
		this.setActivarid_empresaPartidaPresu(esInicial);
		this.setActivarcodigoPartidaPresu(esInicial);
		this.setActivarnombrePartidaPresu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PartidaPresuConstantesFunciones.ID)) {
				this.setActivaridPartidaPresu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PartidaPresuConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaPartidaPresu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PartidaPresuConstantesFunciones.CODIGO)) {
				this.setActivarcodigoPartidaPresu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PartidaPresuConstantesFunciones.NOMBRE)) {
				this.setActivarnombrePartidaPresu(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,PartidaPresuBeanSwingJInternalFrame partidapresuBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridPartidaPresu(esInicial);
		this.setResaltarid_empresaPartidaPresu(esInicial);
		this.setResaltarcodigoPartidaPresu(esInicial);
		this.setResaltarnombrePartidaPresu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PartidaPresuConstantesFunciones.ID)) {
				this.setResaltaridPartidaPresu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PartidaPresuConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaPartidaPresu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PartidaPresuConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoPartidaPresu(esAsigna);
				continue;
			}

			if(campo.clase.equals(PartidaPresuConstantesFunciones.NOMBRE)) {
				this.setResaltarnombrePartidaPresu(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDetalleActivoFijoPartidaPresu=null;

	public Border getResaltarDetalleActivoFijoPartidaPresu() {
		return this.resaltarDetalleActivoFijoPartidaPresu;
	}

	public void setResaltarDetalleActivoFijoPartidaPresu(Border borderResaltarDetalleActivoFijo) {
		if(borderResaltarDetalleActivoFijo!=null) {
			this.resaltarDetalleActivoFijoPartidaPresu= borderResaltarDetalleActivoFijo;
		}
	}

	public Border setResaltarDetalleActivoFijoPartidaPresu(ParametroGeneralUsuario parametroGeneralUsuario/*PartidaPresuBeanSwingJInternalFrame partidapresuBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleActivoFijo=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//partidapresuBeanSwingJInternalFrame.jTtoolBarPartidaPresu.setBorder(borderResaltarDetalleActivoFijo);
			
		this.resaltarDetalleActivoFijoPartidaPresu= borderResaltarDetalleActivoFijo;

		 return borderResaltarDetalleActivoFijo;
	}



	public Boolean mostrarDetalleActivoFijoPartidaPresu=true;

	public Boolean getMostrarDetalleActivoFijoPartidaPresu() {
		return this.mostrarDetalleActivoFijoPartidaPresu;
	}

	public void setMostrarDetalleActivoFijoPartidaPresu(Boolean visibilidadResaltarDetalleActivoFijo) {
		this.mostrarDetalleActivoFijoPartidaPresu= visibilidadResaltarDetalleActivoFijo;
	}



	public Boolean activarDetalleActivoFijoPartidaPresu=true;

	public Boolean gethabilitarResaltarDetalleActivoFijoPartidaPresu() {
		return this.activarDetalleActivoFijoPartidaPresu;
	}

	public void setActivarDetalleActivoFijoPartidaPresu(Boolean habilitarResaltarDetalleActivoFijo) {
		this.activarDetalleActivoFijoPartidaPresu= habilitarResaltarDetalleActivoFijo;
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

		this.setMostrarDetalleActivoFijoPartidaPresu(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleActivoFijo.class)) {
				this.setMostrarDetalleActivoFijoPartidaPresu(esAsigna);
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

		this.setActivarDetalleActivoFijoPartidaPresu(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleActivoFijo.class)) {
				this.setActivarDetalleActivoFijoPartidaPresu(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,PartidaPresuBeanSwingJInternalFrame partidapresuBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDetalleActivoFijoPartidaPresu(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleActivoFijo.class)) {
				this.setResaltarDetalleActivoFijoPartidaPresu(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaPartidaPresu=true;

	public Boolean getMostrarFK_IdEmpresaPartidaPresu() {
		return this.mostrarFK_IdEmpresaPartidaPresu;
	}

	public void setMostrarFK_IdEmpresaPartidaPresu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaPartidaPresu= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaPartidaPresu=true;

	public Boolean getActivarFK_IdEmpresaPartidaPresu() {
		return this.activarFK_IdEmpresaPartidaPresu;
	}

	public void setActivarFK_IdEmpresaPartidaPresu(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaPartidaPresu= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaPartidaPresu=null;

	public Border getResaltarFK_IdEmpresaPartidaPresu() {
		return this.resaltarFK_IdEmpresaPartidaPresu;
	}

	public void setResaltarFK_IdEmpresaPartidaPresu(Border borderResaltar) {
		this.resaltarFK_IdEmpresaPartidaPresu= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaPartidaPresu(ParametroGeneralUsuario parametroGeneralUsuario/*PartidaPresuBeanSwingJInternalFrame partidapresuBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaPartidaPresu= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}