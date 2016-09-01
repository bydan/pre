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
package com.bydan.erp.inventario.util;

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


import com.bydan.erp.inventario.util.EmpaqueConstantesFunciones;
import com.bydan.erp.inventario.util.EmpaqueParameterReturnGeneral;
//import com.bydan.erp.inventario.util.EmpaqueParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class EmpaqueConstantesFunciones extends EmpaqueConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Empaque";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Empaque"+EmpaqueConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="EmpaqueHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="EmpaqueHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=EmpaqueConstantesFunciones.SCHEMA+"_"+EmpaqueConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/EmpaqueHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=EmpaqueConstantesFunciones.SCHEMA+"_"+EmpaqueConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=EmpaqueConstantesFunciones.SCHEMA+"_"+EmpaqueConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/EmpaqueHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=EmpaqueConstantesFunciones.SCHEMA+"_"+EmpaqueConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmpaqueConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EmpaqueHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmpaqueConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmpaqueConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/EmpaqueHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+EmpaqueConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=EmpaqueConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+EmpaqueConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=EmpaqueConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+EmpaqueConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Empaques";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Empaque";
	public static final String SCLASSWEBTITULO_LOWER="Empaque";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Empaque";
	public static final String OBJECTNAME="empaque";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="empaque";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select empaque from "+EmpaqueConstantesFunciones.SPERSISTENCENAME+" empaque";
	public static String QUERYSELECTNATIVE="select "+EmpaqueConstantesFunciones.SCHEMA+"."+EmpaqueConstantesFunciones.TABLENAME+".id,"+EmpaqueConstantesFunciones.SCHEMA+"."+EmpaqueConstantesFunciones.TABLENAME+".version_row,"+EmpaqueConstantesFunciones.SCHEMA+"."+EmpaqueConstantesFunciones.TABLENAME+".id_empresa,"+EmpaqueConstantesFunciones.SCHEMA+"."+EmpaqueConstantesFunciones.TABLENAME+".valor,"+EmpaqueConstantesFunciones.SCHEMA+"."+EmpaqueConstantesFunciones.TABLENAME+".descripcion from "+EmpaqueConstantesFunciones.SCHEMA+"."+EmpaqueConstantesFunciones.TABLENAME;//+" as "+EmpaqueConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected EmpaqueConstantesFuncionesAdditional empaqueConstantesFuncionesAdditional=null;
	
	public EmpaqueConstantesFuncionesAdditional getEmpaqueConstantesFuncionesAdditional() {
		return this.empaqueConstantesFuncionesAdditional;
	}
	
	public void setEmpaqueConstantesFuncionesAdditional(EmpaqueConstantesFuncionesAdditional empaqueConstantesFuncionesAdditional) {
		try {
			this.empaqueConstantesFuncionesAdditional=empaqueConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String VALOR= "valor";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getEmpaqueLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(EmpaqueConstantesFunciones.IDEMPRESA)) {sLabelColumna=EmpaqueConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(EmpaqueConstantesFunciones.VALOR)) {sLabelColumna=EmpaqueConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(EmpaqueConstantesFunciones.DESCRIPCION)) {sLabelColumna=EmpaqueConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getEmpaqueDescripcion(Empaque empaque) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(empaque !=null/* && empaque.getId()!=0*/) {
			sDescripcion=empaque.getdescripcion();//empaqueempaque.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getEmpaqueDescripcionDetallado(Empaque empaque) {
		String sDescripcion="";
			
		sDescripcion+=EmpaqueConstantesFunciones.ID+"=";
		sDescripcion+=empaque.getId().toString()+",";
		sDescripcion+=EmpaqueConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=empaque.getVersionRow().toString()+",";
		sDescripcion+=EmpaqueConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=empaque.getid_empresa().toString()+",";
		sDescripcion+=EmpaqueConstantesFunciones.VALOR+"=";
		sDescripcion+=empaque.getvalor().toString()+",";
		sDescripcion+=EmpaqueConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=empaque.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setEmpaqueDescripcion(Empaque empaque,String sValor) throws Exception {			
		if(empaque !=null) {
			empaque.setdescripcion(sValor);//empaqueempaque.getId().toString();
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
	
	
	
	
	
	
	public static void quitarEspaciosEmpaque(Empaque empaque,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		empaque.setdescripcion(empaque.getdescripcion().trim());
	}
	
	public static void quitarEspaciosEmpaques(List<Empaque> empaques,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Empaque empaque: empaques) {
			empaque.setdescripcion(empaque.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEmpaque(Empaque empaque,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && empaque.getConCambioAuxiliar()) {
			empaque.setIsDeleted(empaque.getIsDeletedAuxiliar());	
			empaque.setIsNew(empaque.getIsNewAuxiliar());	
			empaque.setIsChanged(empaque.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			empaque.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			empaque.setIsDeletedAuxiliar(false);	
			empaque.setIsNewAuxiliar(false);	
			empaque.setIsChangedAuxiliar(false);
			
			empaque.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresEmpaques(List<Empaque> empaques,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Empaque empaque : empaques) {
			if(conAsignarBase && empaque.getConCambioAuxiliar()) {
				empaque.setIsDeleted(empaque.getIsDeletedAuxiliar());	
				empaque.setIsNew(empaque.getIsNewAuxiliar());	
				empaque.setIsChanged(empaque.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				empaque.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				empaque.setIsDeletedAuxiliar(false);	
				empaque.setIsNewAuxiliar(false);	
				empaque.setIsChangedAuxiliar(false);
				
				empaque.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresEmpaque(Empaque empaque,Boolean conEnteros) throws Exception  {
		empaque.setvalor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresEmpaques(List<Empaque> empaques,Boolean conEnteros) throws Exception  {
		
		for(Empaque empaque: empaques) {
			empaque.setvalor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaEmpaque(List<Empaque> empaques,Empaque empaqueAux) throws Exception  {
		EmpaqueConstantesFunciones.InicializarValoresEmpaque(empaqueAux,true);
		
		for(Empaque empaque: empaques) {
			if(empaque.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			empaqueAux.setvalor(empaqueAux.getvalor()+empaque.getvalor());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesEmpaque(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=EmpaqueConstantesFunciones.getArrayColumnasGlobalesEmpaque(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesEmpaque(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(EmpaqueConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(EmpaqueConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoEmpaque(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Empaque> empaques,Empaque empaque,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Empaque empaqueAux: empaques) {
			if(empaqueAux!=null && empaque!=null) {
				if((empaqueAux.getId()==null && empaque.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(empaqueAux.getId()!=null && empaque.getId()!=null){
					if(empaqueAux.getId().equals(empaque.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaEmpaque(List<Empaque> empaques) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valorTotal=0.0;
	
		for(Empaque empaque: empaques) {			
			if(empaque.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valorTotal+=empaque.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(EmpaqueConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(EmpaqueConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaEmpaque() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,EmpaqueConstantesFunciones.LABEL_ID, EmpaqueConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpaqueConstantesFunciones.LABEL_VERSIONROW, EmpaqueConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpaqueConstantesFunciones.LABEL_IDEMPRESA, EmpaqueConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpaqueConstantesFunciones.LABEL_VALOR, EmpaqueConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,EmpaqueConstantesFunciones.LABEL_DESCRIPCION, EmpaqueConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasEmpaque() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=EmpaqueConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpaqueConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpaqueConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpaqueConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=EmpaqueConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEmpaque() throws Exception  {
		return EmpaqueConstantesFunciones.getTiposSeleccionarEmpaque(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEmpaque(Boolean conFk) throws Exception  {
		return EmpaqueConstantesFunciones.getTiposSeleccionarEmpaque(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarEmpaque(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpaqueConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(EmpaqueConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpaqueConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(EmpaqueConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(EmpaqueConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(EmpaqueConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesEmpaque(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesEmpaque(Empaque empaqueAux) throws Exception {
		
			empaqueAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(empaqueAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesEmpaque(List<Empaque> empaquesTemp) throws Exception {
		for(Empaque empaqueAux:empaquesTemp) {
			
			empaqueAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(empaqueAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfEmpaque(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfEmpaque(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfEmpaque(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return EmpaqueConstantesFunciones.getClassesRelationshipsOfEmpaque(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEmpaque(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DetaNotaCredito.class));
				classes.add(new Classe(DetalleProforma.class));
				classes.add(new Classe(DetaNotaCreditoSoli.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DetaNotaCredito.class)) {
						classes.add(new Classe(DetaNotaCredito.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleProforma.class)) {
						classes.add(new Classe(DetalleProforma.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DetaNotaCreditoSoli.class)) {
						classes.add(new Classe(DetaNotaCreditoSoli.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEmpaque(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return EmpaqueConstantesFunciones.getClassesRelationshipsFromStringsOfEmpaque(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfEmpaque(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DetaNotaCredito.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetaNotaCredito.class)); continue;
					}

					if(DetalleProforma.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleProforma.class)); continue;
					}

					if(DetaNotaCreditoSoli.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetaNotaCreditoSoli.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DetaNotaCredito.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetaNotaCredito.class)); continue;
					}

					if(DetalleProforma.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleProforma.class)); continue;
					}

					if(DetaNotaCreditoSoli.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetaNotaCreditoSoli.class)); continue;
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
	public static void actualizarLista(Empaque empaque,List<Empaque> empaques,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Empaque empaqueEncontrado=null;
			
			for(Empaque empaqueLocal:empaques) {
				if(empaqueLocal.getId().equals(empaque.getId())) {
					empaqueEncontrado=empaqueLocal;
					
					empaqueLocal.setIsChanged(empaque.getIsChanged());
					empaqueLocal.setIsNew(empaque.getIsNew());
					empaqueLocal.setIsDeleted(empaque.getIsDeleted());
					
					empaqueLocal.setGeneralEntityOriginal(empaque.getGeneralEntityOriginal());
					
					empaqueLocal.setId(empaque.getId());	
					empaqueLocal.setVersionRow(empaque.getVersionRow());	
					empaqueLocal.setid_empresa(empaque.getid_empresa());	
					empaqueLocal.setvalor(empaque.getvalor());	
					empaqueLocal.setdescripcion(empaque.getdescripcion());	
					
					
					empaqueLocal.setDetaNotaCreditoSolis(empaque.getDetaNotaCreditoSolis());
					empaqueLocal.setDetalleProformas(empaque.getDetalleProformas());
					
					existe=true;
					break;
				}
			}
			
			if(!empaque.getIsDeleted()) {
				if(!existe) {
					empaques.add(empaque);
				}
			} else {
				if(empaqueEncontrado!=null && permiteQuitar)  {
					empaques.remove(empaqueEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Empaque empaque,List<Empaque> empaques) throws Exception {
		try	{			
			for(Empaque empaqueLocal:empaques) {
				if(empaqueLocal.getId().equals(empaque.getId())) {
					empaqueLocal.setIsSelected(empaque.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesEmpaque(List<Empaque> empaquesAux) throws Exception {
		//this.empaquesAux=empaquesAux;
		
		for(Empaque empaqueAux:empaquesAux) {
			if(empaqueAux.getIsChanged()) {
				empaqueAux.setIsChanged(false);
			}		
			
			if(empaqueAux.getIsNew()) {
				empaqueAux.setIsNew(false);
			}	
			
			if(empaqueAux.getIsDeleted()) {
				empaqueAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesEmpaque(Empaque empaqueAux) throws Exception {
		//this.empaqueAux=empaqueAux;
		
			if(empaqueAux.getIsChanged()) {
				empaqueAux.setIsChanged(false);
			}		
			
			if(empaqueAux.getIsNew()) {
				empaqueAux.setIsNew(false);
			}	
			
			if(empaqueAux.getIsDeleted()) {
				empaqueAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Empaque empaqueAsignar,Empaque empaque) throws Exception {
		empaqueAsignar.setId(empaque.getId());	
		empaqueAsignar.setVersionRow(empaque.getVersionRow());	
		empaqueAsignar.setid_empresa(empaque.getid_empresa());
		empaqueAsignar.setempresa_descripcion(empaque.getempresa_descripcion());	
		empaqueAsignar.setvalor(empaque.getvalor());	
		empaqueAsignar.setdescripcion(empaque.getdescripcion());	
	}
	
	public static void inicializarEmpaque(Empaque empaque) throws Exception {
		try {
				empaque.setId(0L);	
					
				empaque.setid_empresa(-1L);	
				empaque.setvalor(0.0);	
				empaque.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderEmpaque(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpaqueConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpaqueConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(EmpaqueConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataEmpaque(String sTipo,Row row,Workbook workbook,Empaque empaque,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(empaque.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empaque.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(empaque.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryEmpaque=Constantes.SFINALQUERY;
	
	public String getsFinalQueryEmpaque() {
		return this.sFinalQueryEmpaque;
	}
	
	public void setsFinalQueryEmpaque(String sFinalQueryEmpaque) {
		this.sFinalQueryEmpaque= sFinalQueryEmpaque;
	}
	
	public Border resaltarSeleccionarEmpaque=null;
	
	public Border setResaltarSeleccionarEmpaque(ParametroGeneralUsuario parametroGeneralUsuario/*EmpaqueBeanSwingJInternalFrame empaqueBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//empaqueBeanSwingJInternalFrame.jTtoolBarEmpaque.setBorder(borderResaltar);
		
		this.resaltarSeleccionarEmpaque= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarEmpaque() {
		return this.resaltarSeleccionarEmpaque;
	}
	
	public void setResaltarSeleccionarEmpaque(Border borderResaltarSeleccionarEmpaque) {
		this.resaltarSeleccionarEmpaque= borderResaltarSeleccionarEmpaque;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridEmpaque=null;
	public Boolean mostraridEmpaque=true;
	public Boolean activaridEmpaque=true;

	public Border resaltarid_empresaEmpaque=null;
	public Boolean mostrarid_empresaEmpaque=true;
	public Boolean activarid_empresaEmpaque=true;
	public Boolean cargarid_empresaEmpaque=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaEmpaque=false;//ConEventDepend=true

	public Border resaltarvalorEmpaque=null;
	public Boolean mostrarvalorEmpaque=true;
	public Boolean activarvalorEmpaque=true;

	public Border resaltardescripcionEmpaque=null;
	public Boolean mostrardescripcionEmpaque=true;
	public Boolean activardescripcionEmpaque=true;

	
	

	public Border setResaltaridEmpaque(ParametroGeneralUsuario parametroGeneralUsuario/*EmpaqueBeanSwingJInternalFrame empaqueBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empaqueBeanSwingJInternalFrame.jTtoolBarEmpaque.setBorder(borderResaltar);
		
		this.resaltaridEmpaque= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridEmpaque() {
		return this.resaltaridEmpaque;
	}

	public void setResaltaridEmpaque(Border borderResaltar) {
		this.resaltaridEmpaque= borderResaltar;
	}

	public Boolean getMostraridEmpaque() {
		return this.mostraridEmpaque;
	}

	public void setMostraridEmpaque(Boolean mostraridEmpaque) {
		this.mostraridEmpaque= mostraridEmpaque;
	}

	public Boolean getActivaridEmpaque() {
		return this.activaridEmpaque;
	}

	public void setActivaridEmpaque(Boolean activaridEmpaque) {
		this.activaridEmpaque= activaridEmpaque;
	}

	public Border setResaltarid_empresaEmpaque(ParametroGeneralUsuario parametroGeneralUsuario/*EmpaqueBeanSwingJInternalFrame empaqueBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empaqueBeanSwingJInternalFrame.jTtoolBarEmpaque.setBorder(borderResaltar);
		
		this.resaltarid_empresaEmpaque= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaEmpaque() {
		return this.resaltarid_empresaEmpaque;
	}

	public void setResaltarid_empresaEmpaque(Border borderResaltar) {
		this.resaltarid_empresaEmpaque= borderResaltar;
	}

	public Boolean getMostrarid_empresaEmpaque() {
		return this.mostrarid_empresaEmpaque;
	}

	public void setMostrarid_empresaEmpaque(Boolean mostrarid_empresaEmpaque) {
		this.mostrarid_empresaEmpaque= mostrarid_empresaEmpaque;
	}

	public Boolean getActivarid_empresaEmpaque() {
		return this.activarid_empresaEmpaque;
	}

	public void setActivarid_empresaEmpaque(Boolean activarid_empresaEmpaque) {
		this.activarid_empresaEmpaque= activarid_empresaEmpaque;
	}

	public Boolean getCargarid_empresaEmpaque() {
		return this.cargarid_empresaEmpaque;
	}

	public void setCargarid_empresaEmpaque(Boolean cargarid_empresaEmpaque) {
		this.cargarid_empresaEmpaque= cargarid_empresaEmpaque;
	}

	public Border setResaltarvalorEmpaque(ParametroGeneralUsuario parametroGeneralUsuario/*EmpaqueBeanSwingJInternalFrame empaqueBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empaqueBeanSwingJInternalFrame.jTtoolBarEmpaque.setBorder(borderResaltar);
		
		this.resaltarvalorEmpaque= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorEmpaque() {
		return this.resaltarvalorEmpaque;
	}

	public void setResaltarvalorEmpaque(Border borderResaltar) {
		this.resaltarvalorEmpaque= borderResaltar;
	}

	public Boolean getMostrarvalorEmpaque() {
		return this.mostrarvalorEmpaque;
	}

	public void setMostrarvalorEmpaque(Boolean mostrarvalorEmpaque) {
		this.mostrarvalorEmpaque= mostrarvalorEmpaque;
	}

	public Boolean getActivarvalorEmpaque() {
		return this.activarvalorEmpaque;
	}

	public void setActivarvalorEmpaque(Boolean activarvalorEmpaque) {
		this.activarvalorEmpaque= activarvalorEmpaque;
	}

	public Border setResaltardescripcionEmpaque(ParametroGeneralUsuario parametroGeneralUsuario/*EmpaqueBeanSwingJInternalFrame empaqueBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//empaqueBeanSwingJInternalFrame.jTtoolBarEmpaque.setBorder(borderResaltar);
		
		this.resaltardescripcionEmpaque= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionEmpaque() {
		return this.resaltardescripcionEmpaque;
	}

	public void setResaltardescripcionEmpaque(Border borderResaltar) {
		this.resaltardescripcionEmpaque= borderResaltar;
	}

	public Boolean getMostrardescripcionEmpaque() {
		return this.mostrardescripcionEmpaque;
	}

	public void setMostrardescripcionEmpaque(Boolean mostrardescripcionEmpaque) {
		this.mostrardescripcionEmpaque= mostrardescripcionEmpaque;
	}

	public Boolean getActivardescripcionEmpaque() {
		return this.activardescripcionEmpaque;
	}

	public void setActivardescripcionEmpaque(Boolean activardescripcionEmpaque) {
		this.activardescripcionEmpaque= activardescripcionEmpaque;
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
		
		
		this.setMostraridEmpaque(esInicial);
		this.setMostrarid_empresaEmpaque(esInicial);
		this.setMostrarvalorEmpaque(esInicial);
		this.setMostrardescripcionEmpaque(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EmpaqueConstantesFunciones.ID)) {
				this.setMostraridEmpaque(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpaqueConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaEmpaque(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpaqueConstantesFunciones.VALOR)) {
				this.setMostrarvalorEmpaque(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpaqueConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionEmpaque(esAsigna);
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
		
		
		this.setActivaridEmpaque(esInicial);
		this.setActivarid_empresaEmpaque(esInicial);
		this.setActivarvalorEmpaque(esInicial);
		this.setActivardescripcionEmpaque(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EmpaqueConstantesFunciones.ID)) {
				this.setActivaridEmpaque(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpaqueConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaEmpaque(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpaqueConstantesFunciones.VALOR)) {
				this.setActivarvalorEmpaque(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpaqueConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionEmpaque(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,EmpaqueBeanSwingJInternalFrame empaqueBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridEmpaque(esInicial);
		this.setResaltarid_empresaEmpaque(esInicial);
		this.setResaltarvalorEmpaque(esInicial);
		this.setResaltardescripcionEmpaque(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(EmpaqueConstantesFunciones.ID)) {
				this.setResaltaridEmpaque(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpaqueConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaEmpaque(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpaqueConstantesFunciones.VALOR)) {
				this.setResaltarvalorEmpaque(esAsigna);
				continue;
			}

			if(campo.clase.equals(EmpaqueConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionEmpaque(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDetalleProformaEmpaque=null;

	public Border getResaltarDetalleProformaEmpaque() {
		return this.resaltarDetalleProformaEmpaque;
	}

	public void setResaltarDetalleProformaEmpaque(Border borderResaltarDetalleProforma) {
		if(borderResaltarDetalleProforma!=null) {
			this.resaltarDetalleProformaEmpaque= borderResaltarDetalleProforma;
		}
	}

	public Border setResaltarDetalleProformaEmpaque(ParametroGeneralUsuario parametroGeneralUsuario/*EmpaqueBeanSwingJInternalFrame empaqueBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleProforma=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//empaqueBeanSwingJInternalFrame.jTtoolBarEmpaque.setBorder(borderResaltarDetalleProforma);
			
		this.resaltarDetalleProformaEmpaque= borderResaltarDetalleProforma;

		 return borderResaltarDetalleProforma;
	}



	public Boolean mostrarDetalleProformaEmpaque=true;

	public Boolean getMostrarDetalleProformaEmpaque() {
		return this.mostrarDetalleProformaEmpaque;
	}

	public void setMostrarDetalleProformaEmpaque(Boolean visibilidadResaltarDetalleProforma) {
		this.mostrarDetalleProformaEmpaque= visibilidadResaltarDetalleProforma;
	}



	public Boolean activarDetalleProformaEmpaque=true;

	public Boolean gethabilitarResaltarDetalleProformaEmpaque() {
		return this.activarDetalleProformaEmpaque;
	}

	public void setActivarDetalleProformaEmpaque(Boolean habilitarResaltarDetalleProforma) {
		this.activarDetalleProformaEmpaque= habilitarResaltarDetalleProforma;
	}


	public Border resaltarDetaNotaCreditoSoliEmpaque=null;

	public Border getResaltarDetaNotaCreditoSoliEmpaque() {
		return this.resaltarDetaNotaCreditoSoliEmpaque;
	}

	public void setResaltarDetaNotaCreditoSoliEmpaque(Border borderResaltarDetaNotaCreditoSoli) {
		if(borderResaltarDetaNotaCreditoSoli!=null) {
			this.resaltarDetaNotaCreditoSoliEmpaque= borderResaltarDetaNotaCreditoSoli;
		}
	}

	public Border setResaltarDetaNotaCreditoSoliEmpaque(ParametroGeneralUsuario parametroGeneralUsuario/*EmpaqueBeanSwingJInternalFrame empaqueBeanSwingJInternalFrame*/) {
		Border borderResaltarDetaNotaCreditoSoli=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//empaqueBeanSwingJInternalFrame.jTtoolBarEmpaque.setBorder(borderResaltarDetaNotaCreditoSoli);
			
		this.resaltarDetaNotaCreditoSoliEmpaque= borderResaltarDetaNotaCreditoSoli;

		 return borderResaltarDetaNotaCreditoSoli;
	}



	public Boolean mostrarDetaNotaCreditoSoliEmpaque=true;

	public Boolean getMostrarDetaNotaCreditoSoliEmpaque() {
		return this.mostrarDetaNotaCreditoSoliEmpaque;
	}

	public void setMostrarDetaNotaCreditoSoliEmpaque(Boolean visibilidadResaltarDetaNotaCreditoSoli) {
		this.mostrarDetaNotaCreditoSoliEmpaque= visibilidadResaltarDetaNotaCreditoSoli;
	}



	public Boolean activarDetaNotaCreditoSoliEmpaque=true;

	public Boolean gethabilitarResaltarDetaNotaCreditoSoliEmpaque() {
		return this.activarDetaNotaCreditoSoliEmpaque;
	}

	public void setActivarDetaNotaCreditoSoliEmpaque(Boolean habilitarResaltarDetaNotaCreditoSoli) {
		this.activarDetaNotaCreditoSoliEmpaque= habilitarResaltarDetaNotaCreditoSoli;
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

		this.setMostrarDetalleProformaEmpaque(esInicial);
		this.setMostrarDetaNotaCreditoSoliEmpaque(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleProforma.class)) {
				this.setMostrarDetalleProformaEmpaque(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetaNotaCreditoSoli.class)) {
				this.setMostrarDetaNotaCreditoSoliEmpaque(esAsigna);
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

		this.setActivarDetalleProformaEmpaque(esInicial);
		this.setActivarDetaNotaCreditoSoliEmpaque(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleProforma.class)) {
				this.setActivarDetalleProformaEmpaque(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetaNotaCreditoSoli.class)) {
				this.setActivarDetaNotaCreditoSoliEmpaque(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,EmpaqueBeanSwingJInternalFrame empaqueBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDetalleProformaEmpaque(esInicial);
		this.setResaltarDetaNotaCreditoSoliEmpaque(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleProforma.class)) {
				this.setResaltarDetalleProformaEmpaque(esAsigna);
				continue;
			}

			if(clase.clas.equals(DetaNotaCreditoSoli.class)) {
				this.setResaltarDetaNotaCreditoSoliEmpaque(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaEmpaque=true;

	public Boolean getMostrarFK_IdEmpresaEmpaque() {
		return this.mostrarFK_IdEmpresaEmpaque;
	}

	public void setMostrarFK_IdEmpresaEmpaque(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaEmpaque= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaEmpaque=true;

	public Boolean getActivarFK_IdEmpresaEmpaque() {
		return this.activarFK_IdEmpresaEmpaque;
	}

	public void setActivarFK_IdEmpresaEmpaque(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaEmpaque= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaEmpaque=null;

	public Border getResaltarFK_IdEmpresaEmpaque() {
		return this.resaltarFK_IdEmpresaEmpaque;
	}

	public void setResaltarFK_IdEmpresaEmpaque(Border borderResaltar) {
		this.resaltarFK_IdEmpresaEmpaque= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaEmpaque(ParametroGeneralUsuario parametroGeneralUsuario/*EmpaqueBeanSwingJInternalFrame empaqueBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaEmpaque= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}