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


import com.bydan.erp.inventario.util.MedidaProduConstantesFunciones;
import com.bydan.erp.inventario.util.MedidaProduParameterReturnGeneral;
//import com.bydan.erp.inventario.util.MedidaProduParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class MedidaProduConstantesFunciones extends MedidaProduConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="MedidaProdu";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="MedidaProdu"+MedidaProduConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="MedidaProduHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="MedidaProduHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=MedidaProduConstantesFunciones.SCHEMA+"_"+MedidaProduConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/MedidaProduHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=MedidaProduConstantesFunciones.SCHEMA+"_"+MedidaProduConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=MedidaProduConstantesFunciones.SCHEMA+"_"+MedidaProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/MedidaProduHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=MedidaProduConstantesFunciones.SCHEMA+"_"+MedidaProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MedidaProduConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/MedidaProduHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MedidaProduConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MedidaProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/MedidaProduHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MedidaProduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=MedidaProduConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+MedidaProduConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=MedidaProduConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+MedidaProduConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Medida Produs";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Medida Produ";
	public static final String SCLASSWEBTITULO_LOWER="Medida Produ";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="MedidaProdu";
	public static final String OBJECTNAME="medidaprodu";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="medida_produ";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select medidaprodu from "+MedidaProduConstantesFunciones.SPERSISTENCENAME+" medidaprodu";
	public static String QUERYSELECTNATIVE="select "+MedidaProduConstantesFunciones.SCHEMA+"."+MedidaProduConstantesFunciones.TABLENAME+".id,"+MedidaProduConstantesFunciones.SCHEMA+"."+MedidaProduConstantesFunciones.TABLENAME+".version_row,"+MedidaProduConstantesFunciones.SCHEMA+"."+MedidaProduConstantesFunciones.TABLENAME+".id_empresa,"+MedidaProduConstantesFunciones.SCHEMA+"."+MedidaProduConstantesFunciones.TABLENAME+".nombre from "+MedidaProduConstantesFunciones.SCHEMA+"."+MedidaProduConstantesFunciones.TABLENAME;//+" as "+MedidaProduConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected MedidaProduConstantesFuncionesAdditional medidaproduConstantesFuncionesAdditional=null;
	
	public MedidaProduConstantesFuncionesAdditional getMedidaProduConstantesFuncionesAdditional() {
		return this.medidaproduConstantesFuncionesAdditional;
	}
	
	public void setMedidaProduConstantesFuncionesAdditional(MedidaProduConstantesFuncionesAdditional medidaproduConstantesFuncionesAdditional) {
		try {
			this.medidaproduConstantesFuncionesAdditional=medidaproduConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getMedidaProduLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(MedidaProduConstantesFunciones.IDEMPRESA)) {sLabelColumna=MedidaProduConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(MedidaProduConstantesFunciones.NOMBRE)) {sLabelColumna=MedidaProduConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getMedidaProduDescripcion(MedidaProdu medidaprodu) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(medidaprodu !=null/* && medidaprodu.getId()!=0*/) {
			sDescripcion=medidaprodu.getnombre();//medidaprodumedidaprodu.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getMedidaProduDescripcionDetallado(MedidaProdu medidaprodu) {
		String sDescripcion="";
			
		sDescripcion+=MedidaProduConstantesFunciones.ID+"=";
		sDescripcion+=medidaprodu.getId().toString()+",";
		sDescripcion+=MedidaProduConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=medidaprodu.getVersionRow().toString()+",";
		sDescripcion+=MedidaProduConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=medidaprodu.getid_empresa().toString()+",";
		sDescripcion+=MedidaProduConstantesFunciones.NOMBRE+"=";
		sDescripcion+=medidaprodu.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setMedidaProduDescripcion(MedidaProdu medidaprodu,String sValor) throws Exception {			
		if(medidaprodu !=null) {
			medidaprodu.setnombre(sValor);;//medidaprodumedidaprodu.getnombre().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosMedidaProdu(MedidaProdu medidaprodu,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		medidaprodu.setnombre(medidaprodu.getnombre().trim());
	}
	
	public static void quitarEspaciosMedidaProdus(List<MedidaProdu> medidaprodus,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(MedidaProdu medidaprodu: medidaprodus) {
			medidaprodu.setnombre(medidaprodu.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresMedidaProdu(MedidaProdu medidaprodu,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && medidaprodu.getConCambioAuxiliar()) {
			medidaprodu.setIsDeleted(medidaprodu.getIsDeletedAuxiliar());	
			medidaprodu.setIsNew(medidaprodu.getIsNewAuxiliar());	
			medidaprodu.setIsChanged(medidaprodu.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			medidaprodu.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			medidaprodu.setIsDeletedAuxiliar(false);	
			medidaprodu.setIsNewAuxiliar(false);	
			medidaprodu.setIsChangedAuxiliar(false);
			
			medidaprodu.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresMedidaProdus(List<MedidaProdu> medidaprodus,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(MedidaProdu medidaprodu : medidaprodus) {
			if(conAsignarBase && medidaprodu.getConCambioAuxiliar()) {
				medidaprodu.setIsDeleted(medidaprodu.getIsDeletedAuxiliar());	
				medidaprodu.setIsNew(medidaprodu.getIsNewAuxiliar());	
				medidaprodu.setIsChanged(medidaprodu.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				medidaprodu.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				medidaprodu.setIsDeletedAuxiliar(false);	
				medidaprodu.setIsNewAuxiliar(false);	
				medidaprodu.setIsChangedAuxiliar(false);
				
				medidaprodu.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresMedidaProdu(MedidaProdu medidaprodu,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresMedidaProdus(List<MedidaProdu> medidaprodus,Boolean conEnteros) throws Exception  {
		
		for(MedidaProdu medidaprodu: medidaprodus) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaMedidaProdu(List<MedidaProdu> medidaprodus,MedidaProdu medidaproduAux) throws Exception  {
		MedidaProduConstantesFunciones.InicializarValoresMedidaProdu(medidaproduAux,true);
		
		for(MedidaProdu medidaprodu: medidaprodus) {
			if(medidaprodu.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesMedidaProdu(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=MedidaProduConstantesFunciones.getArrayColumnasGlobalesMedidaProdu(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesMedidaProdu(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(MedidaProduConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(MedidaProduConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoMedidaProdu(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<MedidaProdu> medidaprodus,MedidaProdu medidaprodu,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(MedidaProdu medidaproduAux: medidaprodus) {
			if(medidaproduAux!=null && medidaprodu!=null) {
				if((medidaproduAux.getId()==null && medidaprodu.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(medidaproduAux.getId()!=null && medidaprodu.getId()!=null){
					if(medidaproduAux.getId().equals(medidaprodu.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaMedidaProdu(List<MedidaProdu> medidaprodus) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(MedidaProdu medidaprodu: medidaprodus) {			
			if(medidaprodu.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaMedidaProdu() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,MedidaProduConstantesFunciones.LABEL_ID, MedidaProduConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MedidaProduConstantesFunciones.LABEL_VERSIONROW, MedidaProduConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MedidaProduConstantesFunciones.LABEL_IDEMPRESA, MedidaProduConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MedidaProduConstantesFunciones.LABEL_NOMBRE, MedidaProduConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasMedidaProdu() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=MedidaProduConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MedidaProduConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MedidaProduConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MedidaProduConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarMedidaProdu() throws Exception  {
		return MedidaProduConstantesFunciones.getTiposSeleccionarMedidaProdu(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarMedidaProdu(Boolean conFk) throws Exception  {
		return MedidaProduConstantesFunciones.getTiposSeleccionarMedidaProdu(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarMedidaProdu(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MedidaProduConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(MedidaProduConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MedidaProduConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(MedidaProduConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesMedidaProdu(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesMedidaProdu(MedidaProdu medidaproduAux) throws Exception {
		
			medidaproduAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(medidaproduAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesMedidaProdu(List<MedidaProdu> medidaprodusTemp) throws Exception {
		for(MedidaProdu medidaproduAux:medidaprodusTemp) {
			
			medidaproduAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(medidaproduAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfMedidaProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfMedidaProdu(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfMedidaProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return MedidaProduConstantesFunciones.getClassesRelationshipsOfMedidaProdu(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfMedidaProdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfMedidaProdu(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return MedidaProduConstantesFunciones.getClassesRelationshipsFromStringsOfMedidaProdu(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfMedidaProdu(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(MedidaProdu medidaprodu,List<MedidaProdu> medidaprodus,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			MedidaProdu medidaproduEncontrado=null;
			
			for(MedidaProdu medidaproduLocal:medidaprodus) {
				if(medidaproduLocal.getId().equals(medidaprodu.getId())) {
					medidaproduEncontrado=medidaproduLocal;
					
					medidaproduLocal.setIsChanged(medidaprodu.getIsChanged());
					medidaproduLocal.setIsNew(medidaprodu.getIsNew());
					medidaproduLocal.setIsDeleted(medidaprodu.getIsDeleted());
					
					medidaproduLocal.setGeneralEntityOriginal(medidaprodu.getGeneralEntityOriginal());
					
					medidaproduLocal.setId(medidaprodu.getId());	
					medidaproduLocal.setVersionRow(medidaprodu.getVersionRow());	
					medidaproduLocal.setid_empresa(medidaprodu.getid_empresa());	
					medidaproduLocal.setnombre(medidaprodu.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!medidaprodu.getIsDeleted()) {
				if(!existe) {
					medidaprodus.add(medidaprodu);
				}
			} else {
				if(medidaproduEncontrado!=null && permiteQuitar)  {
					medidaprodus.remove(medidaproduEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(MedidaProdu medidaprodu,List<MedidaProdu> medidaprodus) throws Exception {
		try	{			
			for(MedidaProdu medidaproduLocal:medidaprodus) {
				if(medidaproduLocal.getId().equals(medidaprodu.getId())) {
					medidaproduLocal.setIsSelected(medidaprodu.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesMedidaProdu(List<MedidaProdu> medidaprodusAux) throws Exception {
		//this.medidaprodusAux=medidaprodusAux;
		
		for(MedidaProdu medidaproduAux:medidaprodusAux) {
			if(medidaproduAux.getIsChanged()) {
				medidaproduAux.setIsChanged(false);
			}		
			
			if(medidaproduAux.getIsNew()) {
				medidaproduAux.setIsNew(false);
			}	
			
			if(medidaproduAux.getIsDeleted()) {
				medidaproduAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesMedidaProdu(MedidaProdu medidaproduAux) throws Exception {
		//this.medidaproduAux=medidaproduAux;
		
			if(medidaproduAux.getIsChanged()) {
				medidaproduAux.setIsChanged(false);
			}		
			
			if(medidaproduAux.getIsNew()) {
				medidaproduAux.setIsNew(false);
			}	
			
			if(medidaproduAux.getIsDeleted()) {
				medidaproduAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(MedidaProdu medidaproduAsignar,MedidaProdu medidaprodu) throws Exception {
		medidaproduAsignar.setId(medidaprodu.getId());	
		medidaproduAsignar.setVersionRow(medidaprodu.getVersionRow());	
		medidaproduAsignar.setid_empresa(medidaprodu.getid_empresa());
		medidaproduAsignar.setempresa_descripcion(medidaprodu.getempresa_descripcion());	
		medidaproduAsignar.setnombre(medidaprodu.getnombre());	
	}
	
	public static void inicializarMedidaProdu(MedidaProdu medidaprodu) throws Exception {
		try {
				medidaprodu.setId(0L);	
					
				medidaprodu.setid_empresa(-1L);	
				medidaprodu.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderMedidaProdu(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(MedidaProduConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MedidaProduConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataMedidaProdu(String sTipo,Row row,Workbook workbook,MedidaProdu medidaprodu,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(medidaprodu.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(medidaprodu.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryMedidaProdu=Constantes.SFINALQUERY;
	
	public String getsFinalQueryMedidaProdu() {
		return this.sFinalQueryMedidaProdu;
	}
	
	public void setsFinalQueryMedidaProdu(String sFinalQueryMedidaProdu) {
		this.sFinalQueryMedidaProdu= sFinalQueryMedidaProdu;
	}
	
	public Border resaltarSeleccionarMedidaProdu=null;
	
	public Border setResaltarSeleccionarMedidaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*MedidaProduBeanSwingJInternalFrame medidaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//medidaproduBeanSwingJInternalFrame.jTtoolBarMedidaProdu.setBorder(borderResaltar);
		
		this.resaltarSeleccionarMedidaProdu= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarMedidaProdu() {
		return this.resaltarSeleccionarMedidaProdu;
	}
	
	public void setResaltarSeleccionarMedidaProdu(Border borderResaltarSeleccionarMedidaProdu) {
		this.resaltarSeleccionarMedidaProdu= borderResaltarSeleccionarMedidaProdu;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridMedidaProdu=null;
	public Boolean mostraridMedidaProdu=true;
	public Boolean activaridMedidaProdu=true;

	public Border resaltarid_empresaMedidaProdu=null;
	public Boolean mostrarid_empresaMedidaProdu=true;
	public Boolean activarid_empresaMedidaProdu=true;
	public Boolean cargarid_empresaMedidaProdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaMedidaProdu=false;//ConEventDepend=true

	public Border resaltarnombreMedidaProdu=null;
	public Boolean mostrarnombreMedidaProdu=true;
	public Boolean activarnombreMedidaProdu=true;

	
	

	public Border setResaltaridMedidaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*MedidaProduBeanSwingJInternalFrame medidaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//medidaproduBeanSwingJInternalFrame.jTtoolBarMedidaProdu.setBorder(borderResaltar);
		
		this.resaltaridMedidaProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridMedidaProdu() {
		return this.resaltaridMedidaProdu;
	}

	public void setResaltaridMedidaProdu(Border borderResaltar) {
		this.resaltaridMedidaProdu= borderResaltar;
	}

	public Boolean getMostraridMedidaProdu() {
		return this.mostraridMedidaProdu;
	}

	public void setMostraridMedidaProdu(Boolean mostraridMedidaProdu) {
		this.mostraridMedidaProdu= mostraridMedidaProdu;
	}

	public Boolean getActivaridMedidaProdu() {
		return this.activaridMedidaProdu;
	}

	public void setActivaridMedidaProdu(Boolean activaridMedidaProdu) {
		this.activaridMedidaProdu= activaridMedidaProdu;
	}

	public Border setResaltarid_empresaMedidaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*MedidaProduBeanSwingJInternalFrame medidaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//medidaproduBeanSwingJInternalFrame.jTtoolBarMedidaProdu.setBorder(borderResaltar);
		
		this.resaltarid_empresaMedidaProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaMedidaProdu() {
		return this.resaltarid_empresaMedidaProdu;
	}

	public void setResaltarid_empresaMedidaProdu(Border borderResaltar) {
		this.resaltarid_empresaMedidaProdu= borderResaltar;
	}

	public Boolean getMostrarid_empresaMedidaProdu() {
		return this.mostrarid_empresaMedidaProdu;
	}

	public void setMostrarid_empresaMedidaProdu(Boolean mostrarid_empresaMedidaProdu) {
		this.mostrarid_empresaMedidaProdu= mostrarid_empresaMedidaProdu;
	}

	public Boolean getActivarid_empresaMedidaProdu() {
		return this.activarid_empresaMedidaProdu;
	}

	public void setActivarid_empresaMedidaProdu(Boolean activarid_empresaMedidaProdu) {
		this.activarid_empresaMedidaProdu= activarid_empresaMedidaProdu;
	}

	public Boolean getCargarid_empresaMedidaProdu() {
		return this.cargarid_empresaMedidaProdu;
	}

	public void setCargarid_empresaMedidaProdu(Boolean cargarid_empresaMedidaProdu) {
		this.cargarid_empresaMedidaProdu= cargarid_empresaMedidaProdu;
	}

	public Border setResaltarnombreMedidaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*MedidaProduBeanSwingJInternalFrame medidaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//medidaproduBeanSwingJInternalFrame.jTtoolBarMedidaProdu.setBorder(borderResaltar);
		
		this.resaltarnombreMedidaProdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreMedidaProdu() {
		return this.resaltarnombreMedidaProdu;
	}

	public void setResaltarnombreMedidaProdu(Border borderResaltar) {
		this.resaltarnombreMedidaProdu= borderResaltar;
	}

	public Boolean getMostrarnombreMedidaProdu() {
		return this.mostrarnombreMedidaProdu;
	}

	public void setMostrarnombreMedidaProdu(Boolean mostrarnombreMedidaProdu) {
		this.mostrarnombreMedidaProdu= mostrarnombreMedidaProdu;
	}

	public Boolean getActivarnombreMedidaProdu() {
		return this.activarnombreMedidaProdu;
	}

	public void setActivarnombreMedidaProdu(Boolean activarnombreMedidaProdu) {
		this.activarnombreMedidaProdu= activarnombreMedidaProdu;
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
		
		
		this.setMostraridMedidaProdu(esInicial);
		this.setMostrarid_empresaMedidaProdu(esInicial);
		this.setMostrarnombreMedidaProdu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(MedidaProduConstantesFunciones.ID)) {
				this.setMostraridMedidaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(MedidaProduConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaMedidaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(MedidaProduConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreMedidaProdu(esAsigna);
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
		
		
		this.setActivaridMedidaProdu(esInicial);
		this.setActivarid_empresaMedidaProdu(esInicial);
		this.setActivarnombreMedidaProdu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(MedidaProduConstantesFunciones.ID)) {
				this.setActivaridMedidaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(MedidaProduConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaMedidaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(MedidaProduConstantesFunciones.NOMBRE)) {
				this.setActivarnombreMedidaProdu(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,MedidaProduBeanSwingJInternalFrame medidaproduBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridMedidaProdu(esInicial);
		this.setResaltarid_empresaMedidaProdu(esInicial);
		this.setResaltarnombreMedidaProdu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(MedidaProduConstantesFunciones.ID)) {
				this.setResaltaridMedidaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(MedidaProduConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaMedidaProdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(MedidaProduConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreMedidaProdu(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,MedidaProduBeanSwingJInternalFrame medidaproduBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaMedidaProdu=true;

	public Boolean getMostrarFK_IdEmpresaMedidaProdu() {
		return this.mostrarFK_IdEmpresaMedidaProdu;
	}

	public void setMostrarFK_IdEmpresaMedidaProdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaMedidaProdu= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaMedidaProdu=true;

	public Boolean getActivarFK_IdEmpresaMedidaProdu() {
		return this.activarFK_IdEmpresaMedidaProdu;
	}

	public void setActivarFK_IdEmpresaMedidaProdu(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaMedidaProdu= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaMedidaProdu=null;

	public Border getResaltarFK_IdEmpresaMedidaProdu() {
		return this.resaltarFK_IdEmpresaMedidaProdu;
	}

	public void setResaltarFK_IdEmpresaMedidaProdu(Border borderResaltar) {
		this.resaltarFK_IdEmpresaMedidaProdu= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaMedidaProdu(ParametroGeneralUsuario parametroGeneralUsuario/*MedidaProduBeanSwingJInternalFrame medidaproduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaMedidaProdu= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}