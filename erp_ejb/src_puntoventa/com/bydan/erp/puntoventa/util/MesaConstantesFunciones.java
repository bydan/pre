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
package com.bydan.erp.puntoventa.util;

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


import com.bydan.erp.puntoventa.util.MesaConstantesFunciones;
import com.bydan.erp.puntoventa.util.MesaParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.MesaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class MesaConstantesFunciones extends MesaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Mesa";
	public static final String SPATHOPCION="PuntoVenta";	
	public static final String SPATHMODULO="puntoventa/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Mesa"+MesaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="MesaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="MesaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=MesaConstantesFunciones.SCHEMA+"_"+MesaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/MesaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=MesaConstantesFunciones.SCHEMA+"_"+MesaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=MesaConstantesFunciones.SCHEMA+"_"+MesaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/MesaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=MesaConstantesFunciones.SCHEMA+"_"+MesaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MesaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/MesaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MesaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MesaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/MesaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MesaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=MesaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+MesaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=MesaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+MesaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Mesas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Mesa";
	public static final String SCLASSWEBTITULO_LOWER="Mesa";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Mesa";
	public static final String OBJECTNAME="mesa";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PUNTOVENTA;	
	public static final String TABLENAME="mesa";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select mesa from "+MesaConstantesFunciones.SPERSISTENCENAME+" mesa";
	public static String QUERYSELECTNATIVE="select "+MesaConstantesFunciones.SCHEMA+"."+MesaConstantesFunciones.TABLENAME+".id,"+MesaConstantesFunciones.SCHEMA+"."+MesaConstantesFunciones.TABLENAME+".version_row,"+MesaConstantesFunciones.SCHEMA+"."+MesaConstantesFunciones.TABLENAME+".id_empresa,"+MesaConstantesFunciones.SCHEMA+"."+MesaConstantesFunciones.TABLENAME+".id_sucursal,"+MesaConstantesFunciones.SCHEMA+"."+MesaConstantesFunciones.TABLENAME+".nombre,"+MesaConstantesFunciones.SCHEMA+"."+MesaConstantesFunciones.TABLENAME+".numero from "+MesaConstantesFunciones.SCHEMA+"."+MesaConstantesFunciones.TABLENAME;//+" as "+MesaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected MesaConstantesFuncionesAdditional mesaConstantesFuncionesAdditional=null;
	
	public MesaConstantesFuncionesAdditional getMesaConstantesFuncionesAdditional() {
		return this.mesaConstantesFuncionesAdditional;
	}
	
	public void setMesaConstantesFuncionesAdditional(MesaConstantesFuncionesAdditional mesaConstantesFuncionesAdditional) {
		try {
			this.mesaConstantesFuncionesAdditional=mesaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String NOMBRE= "nombre";
    public static final String NUMERO= "numero";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_NUMERO= "Numero";
		public static final String LABEL_NUMERO_LOWER= "Numero";
	
		
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getMesaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(MesaConstantesFunciones.IDEMPRESA)) {sLabelColumna=MesaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(MesaConstantesFunciones.IDSUCURSAL)) {sLabelColumna=MesaConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(MesaConstantesFunciones.NOMBRE)) {sLabelColumna=MesaConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(MesaConstantesFunciones.NUMERO)) {sLabelColumna=MesaConstantesFunciones.LABEL_NUMERO;}
		
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
	
	
	
			
			
			
			
			
			
	
	public static String getMesaDescripcion(Mesa mesa) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(mesa !=null/* && mesa.getId()!=0*/) {
			sDescripcion=mesa.getnombre();//mesamesa.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getMesaDescripcionDetallado(Mesa mesa) {
		String sDescripcion="";
			
		sDescripcion+=MesaConstantesFunciones.ID+"=";
		sDescripcion+=mesa.getId().toString()+",";
		sDescripcion+=MesaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=mesa.getVersionRow().toString()+",";
		sDescripcion+=MesaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=mesa.getid_empresa().toString()+",";
		sDescripcion+=MesaConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=mesa.getid_sucursal().toString()+",";
		sDescripcion+=MesaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=mesa.getnombre()+",";
		sDescripcion+=MesaConstantesFunciones.NUMERO+"=";
		sDescripcion+=mesa.getnumero().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setMesaDescripcion(Mesa mesa,String sValor) throws Exception {			
		if(mesa !=null) {
			mesa.setnombre(sValor);;//mesamesa.getnombre().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getSucursalDescripcion(Sucursal sucursal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(sucursal!=null/*&&sucursal.getId()>0*/) {
			sDescripcion=SucursalConstantesFunciones.getSucursalDescripcion(sucursal);
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
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
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

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosMesa(Mesa mesa,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		mesa.setnombre(mesa.getnombre().trim());
	}
	
	public static void quitarEspaciosMesas(List<Mesa> mesas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Mesa mesa: mesas) {
			mesa.setnombre(mesa.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresMesa(Mesa mesa,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && mesa.getConCambioAuxiliar()) {
			mesa.setIsDeleted(mesa.getIsDeletedAuxiliar());	
			mesa.setIsNew(mesa.getIsNewAuxiliar());	
			mesa.setIsChanged(mesa.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			mesa.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			mesa.setIsDeletedAuxiliar(false);	
			mesa.setIsNewAuxiliar(false);	
			mesa.setIsChangedAuxiliar(false);
			
			mesa.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresMesas(List<Mesa> mesas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Mesa mesa : mesas) {
			if(conAsignarBase && mesa.getConCambioAuxiliar()) {
				mesa.setIsDeleted(mesa.getIsDeletedAuxiliar());	
				mesa.setIsNew(mesa.getIsNewAuxiliar());	
				mesa.setIsChanged(mesa.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				mesa.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				mesa.setIsDeletedAuxiliar(false);	
				mesa.setIsNewAuxiliar(false);	
				mesa.setIsChangedAuxiliar(false);
				
				mesa.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresMesa(Mesa mesa,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
			mesa.setnumero(0);
		}
	}		
	
	public static void InicializarValoresMesas(List<Mesa> mesas,Boolean conEnteros) throws Exception  {
		
		for(Mesa mesa: mesas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
				mesa.setnumero(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaMesa(List<Mesa> mesas,Mesa mesaAux) throws Exception  {
		MesaConstantesFunciones.InicializarValoresMesa(mesaAux,true);
		
		for(Mesa mesa: mesas) {
			if(mesa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			mesaAux.setnumero(mesaAux.getnumero()+mesa.getnumero());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesMesa(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=MesaConstantesFunciones.getArrayColumnasGlobalesMesa(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesMesa(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(MesaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(MesaConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(MesaConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(MesaConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoMesa(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Mesa> mesas,Mesa mesa,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Mesa mesaAux: mesas) {
			if(mesaAux!=null && mesa!=null) {
				if((mesaAux.getId()==null && mesa.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(mesaAux.getId()!=null && mesa.getId()!=null){
					if(mesaAux.getId().equals(mesa.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaMesa(List<Mesa> mesas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(Mesa mesa: mesas) {			
			if(mesa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaMesa() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,MesaConstantesFunciones.LABEL_ID, MesaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MesaConstantesFunciones.LABEL_VERSIONROW, MesaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MesaConstantesFunciones.LABEL_IDEMPRESA, MesaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MesaConstantesFunciones.LABEL_IDSUCURSAL, MesaConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MesaConstantesFunciones.LABEL_NOMBRE, MesaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MesaConstantesFunciones.LABEL_NUMERO, MesaConstantesFunciones.NUMERO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasMesa() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=MesaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MesaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MesaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MesaConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MesaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MesaConstantesFunciones.NUMERO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarMesa() throws Exception  {
		return MesaConstantesFunciones.getTiposSeleccionarMesa(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarMesa(Boolean conFk) throws Exception  {
		return MesaConstantesFunciones.getTiposSeleccionarMesa(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarMesa(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MesaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(MesaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MesaConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(MesaConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MesaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(MesaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MesaConstantesFunciones.LABEL_NUMERO);
			reporte.setsDescripcion(MesaConstantesFunciones.LABEL_NUMERO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesMesa(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesMesa(Mesa mesaAux) throws Exception {
		
			mesaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(mesaAux.getEmpresa()));
			mesaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(mesaAux.getSucursal()));		
	}
	
	public static void refrescarForeignKeysDescripcionesMesa(List<Mesa> mesasTemp) throws Exception {
		for(Mesa mesaAux:mesasTemp) {
			
			mesaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(mesaAux.getEmpresa()));
			mesaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(mesaAux.getSucursal()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfMesa(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Sucursal.class)) {
						classes.add(new Classe(Sucursal.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfMesa(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfMesa(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return MesaConstantesFunciones.getClassesRelationshipsOfMesa(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfMesa(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(PedidoPuntoVenta.class));
				classes.add(new Classe(FacturaPuntoVenta.class));
				classes.add(new Classe(NotaCreditoPuntoVenta.class));
				classes.add(new Classe(CajeroTurno.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(PedidoPuntoVenta.class)) {
						classes.add(new Classe(PedidoPuntoVenta.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(FacturaPuntoVenta.class)) {
						classes.add(new Classe(FacturaPuntoVenta.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(NotaCreditoPuntoVenta.class)) {
						classes.add(new Classe(NotaCreditoPuntoVenta.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CajeroTurno.class)) {
						classes.add(new Classe(CajeroTurno.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfMesa(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return MesaConstantesFunciones.getClassesRelationshipsFromStringsOfMesa(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfMesa(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(PedidoPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PedidoPuntoVenta.class)); continue;
					}

					if(FacturaPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FacturaPuntoVenta.class)); continue;
					}

					if(NotaCreditoPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NotaCreditoPuntoVenta.class)); continue;
					}

					if(CajeroTurno.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CajeroTurno.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(PedidoPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PedidoPuntoVenta.class)); continue;
					}

					if(FacturaPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(FacturaPuntoVenta.class)); continue;
					}

					if(NotaCreditoPuntoVenta.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(NotaCreditoPuntoVenta.class)); continue;
					}

					if(CajeroTurno.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CajeroTurno.class)); continue;
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
	public static void actualizarLista(Mesa mesa,List<Mesa> mesas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Mesa mesaEncontrado=null;
			
			for(Mesa mesaLocal:mesas) {
				if(mesaLocal.getId().equals(mesa.getId())) {
					mesaEncontrado=mesaLocal;
					
					mesaLocal.setIsChanged(mesa.getIsChanged());
					mesaLocal.setIsNew(mesa.getIsNew());
					mesaLocal.setIsDeleted(mesa.getIsDeleted());
					
					mesaLocal.setGeneralEntityOriginal(mesa.getGeneralEntityOriginal());
					
					mesaLocal.setId(mesa.getId());	
					mesaLocal.setVersionRow(mesa.getVersionRow());	
					mesaLocal.setid_empresa(mesa.getid_empresa());	
					mesaLocal.setid_sucursal(mesa.getid_sucursal());	
					mesaLocal.setnombre(mesa.getnombre());	
					mesaLocal.setnumero(mesa.getnumero());	
					
					
					mesaLocal.setPedidoPuntoVentas(mesa.getPedidoPuntoVentas());
					mesaLocal.setFacturaPuntoVentas(mesa.getFacturaPuntoVentas());
					mesaLocal.setNotaCreditoPuntoVentas(mesa.getNotaCreditoPuntoVentas());
					mesaLocal.setCajeroTurnos(mesa.getCajeroTurnos());
					
					existe=true;
					break;
				}
			}
			
			if(!mesa.getIsDeleted()) {
				if(!existe) {
					mesas.add(mesa);
				}
			} else {
				if(mesaEncontrado!=null && permiteQuitar)  {
					mesas.remove(mesaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Mesa mesa,List<Mesa> mesas) throws Exception {
		try	{			
			for(Mesa mesaLocal:mesas) {
				if(mesaLocal.getId().equals(mesa.getId())) {
					mesaLocal.setIsSelected(mesa.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesMesa(List<Mesa> mesasAux) throws Exception {
		//this.mesasAux=mesasAux;
		
		for(Mesa mesaAux:mesasAux) {
			if(mesaAux.getIsChanged()) {
				mesaAux.setIsChanged(false);
			}		
			
			if(mesaAux.getIsNew()) {
				mesaAux.setIsNew(false);
			}	
			
			if(mesaAux.getIsDeleted()) {
				mesaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesMesa(Mesa mesaAux) throws Exception {
		//this.mesaAux=mesaAux;
		
			if(mesaAux.getIsChanged()) {
				mesaAux.setIsChanged(false);
			}		
			
			if(mesaAux.getIsNew()) {
				mesaAux.setIsNew(false);
			}	
			
			if(mesaAux.getIsDeleted()) {
				mesaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Mesa mesaAsignar,Mesa mesa) throws Exception {
		mesaAsignar.setId(mesa.getId());	
		mesaAsignar.setVersionRow(mesa.getVersionRow());	
		mesaAsignar.setid_empresa(mesa.getid_empresa());
		mesaAsignar.setempresa_descripcion(mesa.getempresa_descripcion());	
		mesaAsignar.setid_sucursal(mesa.getid_sucursal());
		mesaAsignar.setsucursal_descripcion(mesa.getsucursal_descripcion());	
		mesaAsignar.setnombre(mesa.getnombre());	
		mesaAsignar.setnumero(mesa.getnumero());	
	}
	
	public static void inicializarMesa(Mesa mesa) throws Exception {
		try {
				mesa.setId(0L);	
					
				mesa.setid_empresa(-1L);	
				mesa.setid_sucursal(-1L);	
				mesa.setnombre("");	
				mesa.setnumero(0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderMesa(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(MesaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MesaConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MesaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MesaConstantesFunciones.LABEL_NUMERO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataMesa(String sTipo,Row row,Workbook workbook,Mesa mesa,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(mesa.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(mesa.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(mesa.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(mesa.getnumero());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryMesa=Constantes.SFINALQUERY;
	
	public String getsFinalQueryMesa() {
		return this.sFinalQueryMesa;
	}
	
	public void setsFinalQueryMesa(String sFinalQueryMesa) {
		this.sFinalQueryMesa= sFinalQueryMesa;
	}
	
	public Border resaltarSeleccionarMesa=null;
	
	public Border setResaltarSeleccionarMesa(ParametroGeneralUsuario parametroGeneralUsuario/*MesaBeanSwingJInternalFrame mesaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//mesaBeanSwingJInternalFrame.jTtoolBarMesa.setBorder(borderResaltar);
		
		this.resaltarSeleccionarMesa= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarMesa() {
		return this.resaltarSeleccionarMesa;
	}
	
	public void setResaltarSeleccionarMesa(Border borderResaltarSeleccionarMesa) {
		this.resaltarSeleccionarMesa= borderResaltarSeleccionarMesa;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridMesa=null;
	public Boolean mostraridMesa=true;
	public Boolean activaridMesa=true;

	public Border resaltarid_empresaMesa=null;
	public Boolean mostrarid_empresaMesa=true;
	public Boolean activarid_empresaMesa=true;
	public Boolean cargarid_empresaMesa=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaMesa=false;//ConEventDepend=true

	public Border resaltarid_sucursalMesa=null;
	public Boolean mostrarid_sucursalMesa=true;
	public Boolean activarid_sucursalMesa=true;
	public Boolean cargarid_sucursalMesa=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalMesa=false;//ConEventDepend=true

	public Border resaltarnombreMesa=null;
	public Boolean mostrarnombreMesa=true;
	public Boolean activarnombreMesa=true;

	public Border resaltarnumeroMesa=null;
	public Boolean mostrarnumeroMesa=true;
	public Boolean activarnumeroMesa=true;

	
	

	public Border setResaltaridMesa(ParametroGeneralUsuario parametroGeneralUsuario/*MesaBeanSwingJInternalFrame mesaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mesaBeanSwingJInternalFrame.jTtoolBarMesa.setBorder(borderResaltar);
		
		this.resaltaridMesa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridMesa() {
		return this.resaltaridMesa;
	}

	public void setResaltaridMesa(Border borderResaltar) {
		this.resaltaridMesa= borderResaltar;
	}

	public Boolean getMostraridMesa() {
		return this.mostraridMesa;
	}

	public void setMostraridMesa(Boolean mostraridMesa) {
		this.mostraridMesa= mostraridMesa;
	}

	public Boolean getActivaridMesa() {
		return this.activaridMesa;
	}

	public void setActivaridMesa(Boolean activaridMesa) {
		this.activaridMesa= activaridMesa;
	}

	public Border setResaltarid_empresaMesa(ParametroGeneralUsuario parametroGeneralUsuario/*MesaBeanSwingJInternalFrame mesaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mesaBeanSwingJInternalFrame.jTtoolBarMesa.setBorder(borderResaltar);
		
		this.resaltarid_empresaMesa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaMesa() {
		return this.resaltarid_empresaMesa;
	}

	public void setResaltarid_empresaMesa(Border borderResaltar) {
		this.resaltarid_empresaMesa= borderResaltar;
	}

	public Boolean getMostrarid_empresaMesa() {
		return this.mostrarid_empresaMesa;
	}

	public void setMostrarid_empresaMesa(Boolean mostrarid_empresaMesa) {
		this.mostrarid_empresaMesa= mostrarid_empresaMesa;
	}

	public Boolean getActivarid_empresaMesa() {
		return this.activarid_empresaMesa;
	}

	public void setActivarid_empresaMesa(Boolean activarid_empresaMesa) {
		this.activarid_empresaMesa= activarid_empresaMesa;
	}

	public Boolean getCargarid_empresaMesa() {
		return this.cargarid_empresaMesa;
	}

	public void setCargarid_empresaMesa(Boolean cargarid_empresaMesa) {
		this.cargarid_empresaMesa= cargarid_empresaMesa;
	}

	public Border setResaltarid_sucursalMesa(ParametroGeneralUsuario parametroGeneralUsuario/*MesaBeanSwingJInternalFrame mesaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mesaBeanSwingJInternalFrame.jTtoolBarMesa.setBorder(borderResaltar);
		
		this.resaltarid_sucursalMesa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalMesa() {
		return this.resaltarid_sucursalMesa;
	}

	public void setResaltarid_sucursalMesa(Border borderResaltar) {
		this.resaltarid_sucursalMesa= borderResaltar;
	}

	public Boolean getMostrarid_sucursalMesa() {
		return this.mostrarid_sucursalMesa;
	}

	public void setMostrarid_sucursalMesa(Boolean mostrarid_sucursalMesa) {
		this.mostrarid_sucursalMesa= mostrarid_sucursalMesa;
	}

	public Boolean getActivarid_sucursalMesa() {
		return this.activarid_sucursalMesa;
	}

	public void setActivarid_sucursalMesa(Boolean activarid_sucursalMesa) {
		this.activarid_sucursalMesa= activarid_sucursalMesa;
	}

	public Boolean getCargarid_sucursalMesa() {
		return this.cargarid_sucursalMesa;
	}

	public void setCargarid_sucursalMesa(Boolean cargarid_sucursalMesa) {
		this.cargarid_sucursalMesa= cargarid_sucursalMesa;
	}

	public Border setResaltarnombreMesa(ParametroGeneralUsuario parametroGeneralUsuario/*MesaBeanSwingJInternalFrame mesaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mesaBeanSwingJInternalFrame.jTtoolBarMesa.setBorder(borderResaltar);
		
		this.resaltarnombreMesa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreMesa() {
		return this.resaltarnombreMesa;
	}

	public void setResaltarnombreMesa(Border borderResaltar) {
		this.resaltarnombreMesa= borderResaltar;
	}

	public Boolean getMostrarnombreMesa() {
		return this.mostrarnombreMesa;
	}

	public void setMostrarnombreMesa(Boolean mostrarnombreMesa) {
		this.mostrarnombreMesa= mostrarnombreMesa;
	}

	public Boolean getActivarnombreMesa() {
		return this.activarnombreMesa;
	}

	public void setActivarnombreMesa(Boolean activarnombreMesa) {
		this.activarnombreMesa= activarnombreMesa;
	}

	public Border setResaltarnumeroMesa(ParametroGeneralUsuario parametroGeneralUsuario/*MesaBeanSwingJInternalFrame mesaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//mesaBeanSwingJInternalFrame.jTtoolBarMesa.setBorder(borderResaltar);
		
		this.resaltarnumeroMesa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumeroMesa() {
		return this.resaltarnumeroMesa;
	}

	public void setResaltarnumeroMesa(Border borderResaltar) {
		this.resaltarnumeroMesa= borderResaltar;
	}

	public Boolean getMostrarnumeroMesa() {
		return this.mostrarnumeroMesa;
	}

	public void setMostrarnumeroMesa(Boolean mostrarnumeroMesa) {
		this.mostrarnumeroMesa= mostrarnumeroMesa;
	}

	public Boolean getActivarnumeroMesa() {
		return this.activarnumeroMesa;
	}

	public void setActivarnumeroMesa(Boolean activarnumeroMesa) {
		this.activarnumeroMesa= activarnumeroMesa;
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
		
		
		this.setMostraridMesa(esInicial);
		this.setMostrarid_empresaMesa(esInicial);
		this.setMostrarid_sucursalMesa(esInicial);
		this.setMostrarnombreMesa(esInicial);
		this.setMostrarnumeroMesa(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(MesaConstantesFunciones.ID)) {
				this.setMostraridMesa(esAsigna);
				continue;
			}

			if(campo.clase.equals(MesaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaMesa(esAsigna);
				continue;
			}

			if(campo.clase.equals(MesaConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalMesa(esAsigna);
				continue;
			}

			if(campo.clase.equals(MesaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreMesa(esAsigna);
				continue;
			}

			if(campo.clase.equals(MesaConstantesFunciones.NUMERO)) {
				this.setMostrarnumeroMesa(esAsigna);
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
		
		
		this.setActivaridMesa(esInicial);
		this.setActivarid_empresaMesa(esInicial);
		this.setActivarid_sucursalMesa(esInicial);
		this.setActivarnombreMesa(esInicial);
		this.setActivarnumeroMesa(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(MesaConstantesFunciones.ID)) {
				this.setActivaridMesa(esAsigna);
				continue;
			}

			if(campo.clase.equals(MesaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaMesa(esAsigna);
				continue;
			}

			if(campo.clase.equals(MesaConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalMesa(esAsigna);
				continue;
			}

			if(campo.clase.equals(MesaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreMesa(esAsigna);
				continue;
			}

			if(campo.clase.equals(MesaConstantesFunciones.NUMERO)) {
				this.setActivarnumeroMesa(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,MesaBeanSwingJInternalFrame mesaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridMesa(esInicial);
		this.setResaltarid_empresaMesa(esInicial);
		this.setResaltarid_sucursalMesa(esInicial);
		this.setResaltarnombreMesa(esInicial);
		this.setResaltarnumeroMesa(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(MesaConstantesFunciones.ID)) {
				this.setResaltaridMesa(esAsigna);
				continue;
			}

			if(campo.clase.equals(MesaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaMesa(esAsigna);
				continue;
			}

			if(campo.clase.equals(MesaConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalMesa(esAsigna);
				continue;
			}

			if(campo.clase.equals(MesaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreMesa(esAsigna);
				continue;
			}

			if(campo.clase.equals(MesaConstantesFunciones.NUMERO)) {
				this.setResaltarnumeroMesa(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarPedidoPuntoVentaMesa=null;

	public Border getResaltarPedidoPuntoVentaMesa() {
		return this.resaltarPedidoPuntoVentaMesa;
	}

	public void setResaltarPedidoPuntoVentaMesa(Border borderResaltarPedidoPuntoVenta) {
		if(borderResaltarPedidoPuntoVenta!=null) {
			this.resaltarPedidoPuntoVentaMesa= borderResaltarPedidoPuntoVenta;
		}
	}

	public Border setResaltarPedidoPuntoVentaMesa(ParametroGeneralUsuario parametroGeneralUsuario/*MesaBeanSwingJInternalFrame mesaBeanSwingJInternalFrame*/) {
		Border borderResaltarPedidoPuntoVenta=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//mesaBeanSwingJInternalFrame.jTtoolBarMesa.setBorder(borderResaltarPedidoPuntoVenta);
			
		this.resaltarPedidoPuntoVentaMesa= borderResaltarPedidoPuntoVenta;

		 return borderResaltarPedidoPuntoVenta;
	}



	public Boolean mostrarPedidoPuntoVentaMesa=true;

	public Boolean getMostrarPedidoPuntoVentaMesa() {
		return this.mostrarPedidoPuntoVentaMesa;
	}

	public void setMostrarPedidoPuntoVentaMesa(Boolean visibilidadResaltarPedidoPuntoVenta) {
		this.mostrarPedidoPuntoVentaMesa= visibilidadResaltarPedidoPuntoVenta;
	}



	public Boolean activarPedidoPuntoVentaMesa=true;

	public Boolean gethabilitarResaltarPedidoPuntoVentaMesa() {
		return this.activarPedidoPuntoVentaMesa;
	}

	public void setActivarPedidoPuntoVentaMesa(Boolean habilitarResaltarPedidoPuntoVenta) {
		this.activarPedidoPuntoVentaMesa= habilitarResaltarPedidoPuntoVenta;
	}


	public Border resaltarFacturaPuntoVentaMesa=null;

	public Border getResaltarFacturaPuntoVentaMesa() {
		return this.resaltarFacturaPuntoVentaMesa;
	}

	public void setResaltarFacturaPuntoVentaMesa(Border borderResaltarFacturaPuntoVenta) {
		if(borderResaltarFacturaPuntoVenta!=null) {
			this.resaltarFacturaPuntoVentaMesa= borderResaltarFacturaPuntoVenta;
		}
	}

	public Border setResaltarFacturaPuntoVentaMesa(ParametroGeneralUsuario parametroGeneralUsuario/*MesaBeanSwingJInternalFrame mesaBeanSwingJInternalFrame*/) {
		Border borderResaltarFacturaPuntoVenta=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//mesaBeanSwingJInternalFrame.jTtoolBarMesa.setBorder(borderResaltarFacturaPuntoVenta);
			
		this.resaltarFacturaPuntoVentaMesa= borderResaltarFacturaPuntoVenta;

		 return borderResaltarFacturaPuntoVenta;
	}



	public Boolean mostrarFacturaPuntoVentaMesa=true;

	public Boolean getMostrarFacturaPuntoVentaMesa() {
		return this.mostrarFacturaPuntoVentaMesa;
	}

	public void setMostrarFacturaPuntoVentaMesa(Boolean visibilidadResaltarFacturaPuntoVenta) {
		this.mostrarFacturaPuntoVentaMesa= visibilidadResaltarFacturaPuntoVenta;
	}



	public Boolean activarFacturaPuntoVentaMesa=true;

	public Boolean gethabilitarResaltarFacturaPuntoVentaMesa() {
		return this.activarFacturaPuntoVentaMesa;
	}

	public void setActivarFacturaPuntoVentaMesa(Boolean habilitarResaltarFacturaPuntoVenta) {
		this.activarFacturaPuntoVentaMesa= habilitarResaltarFacturaPuntoVenta;
	}


	public Border resaltarNotaCreditoPuntoVentaMesa=null;

	public Border getResaltarNotaCreditoPuntoVentaMesa() {
		return this.resaltarNotaCreditoPuntoVentaMesa;
	}

	public void setResaltarNotaCreditoPuntoVentaMesa(Border borderResaltarNotaCreditoPuntoVenta) {
		if(borderResaltarNotaCreditoPuntoVenta!=null) {
			this.resaltarNotaCreditoPuntoVentaMesa= borderResaltarNotaCreditoPuntoVenta;
		}
	}

	public Border setResaltarNotaCreditoPuntoVentaMesa(ParametroGeneralUsuario parametroGeneralUsuario/*MesaBeanSwingJInternalFrame mesaBeanSwingJInternalFrame*/) {
		Border borderResaltarNotaCreditoPuntoVenta=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//mesaBeanSwingJInternalFrame.jTtoolBarMesa.setBorder(borderResaltarNotaCreditoPuntoVenta);
			
		this.resaltarNotaCreditoPuntoVentaMesa= borderResaltarNotaCreditoPuntoVenta;

		 return borderResaltarNotaCreditoPuntoVenta;
	}



	public Boolean mostrarNotaCreditoPuntoVentaMesa=true;

	public Boolean getMostrarNotaCreditoPuntoVentaMesa() {
		return this.mostrarNotaCreditoPuntoVentaMesa;
	}

	public void setMostrarNotaCreditoPuntoVentaMesa(Boolean visibilidadResaltarNotaCreditoPuntoVenta) {
		this.mostrarNotaCreditoPuntoVentaMesa= visibilidadResaltarNotaCreditoPuntoVenta;
	}



	public Boolean activarNotaCreditoPuntoVentaMesa=true;

	public Boolean gethabilitarResaltarNotaCreditoPuntoVentaMesa() {
		return this.activarNotaCreditoPuntoVentaMesa;
	}

	public void setActivarNotaCreditoPuntoVentaMesa(Boolean habilitarResaltarNotaCreditoPuntoVenta) {
		this.activarNotaCreditoPuntoVentaMesa= habilitarResaltarNotaCreditoPuntoVenta;
	}


	public Border resaltarCajeroTurnoMesa=null;

	public Border getResaltarCajeroTurnoMesa() {
		return this.resaltarCajeroTurnoMesa;
	}

	public void setResaltarCajeroTurnoMesa(Border borderResaltarCajeroTurno) {
		if(borderResaltarCajeroTurno!=null) {
			this.resaltarCajeroTurnoMesa= borderResaltarCajeroTurno;
		}
	}

	public Border setResaltarCajeroTurnoMesa(ParametroGeneralUsuario parametroGeneralUsuario/*MesaBeanSwingJInternalFrame mesaBeanSwingJInternalFrame*/) {
		Border borderResaltarCajeroTurno=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//mesaBeanSwingJInternalFrame.jTtoolBarMesa.setBorder(borderResaltarCajeroTurno);
			
		this.resaltarCajeroTurnoMesa= borderResaltarCajeroTurno;

		 return borderResaltarCajeroTurno;
	}



	public Boolean mostrarCajeroTurnoMesa=true;

	public Boolean getMostrarCajeroTurnoMesa() {
		return this.mostrarCajeroTurnoMesa;
	}

	public void setMostrarCajeroTurnoMesa(Boolean visibilidadResaltarCajeroTurno) {
		this.mostrarCajeroTurnoMesa= visibilidadResaltarCajeroTurno;
	}



	public Boolean activarCajeroTurnoMesa=true;

	public Boolean gethabilitarResaltarCajeroTurnoMesa() {
		return this.activarCajeroTurnoMesa;
	}

	public void setActivarCajeroTurnoMesa(Boolean habilitarResaltarCajeroTurno) {
		this.activarCajeroTurnoMesa= habilitarResaltarCajeroTurno;
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

		this.setMostrarPedidoPuntoVentaMesa(esInicial);
		this.setMostrarFacturaPuntoVentaMesa(esInicial);
		this.setMostrarNotaCreditoPuntoVentaMesa(esInicial);
		this.setMostrarCajeroTurnoMesa(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(PedidoPuntoVenta.class)) {
				this.setMostrarPedidoPuntoVentaMesa(esAsigna);
				continue;
			}

			if(clase.clas.equals(FacturaPuntoVenta.class)) {
				this.setMostrarFacturaPuntoVentaMesa(esAsigna);
				continue;
			}

			if(clase.clas.equals(NotaCreditoPuntoVenta.class)) {
				this.setMostrarNotaCreditoPuntoVentaMesa(esAsigna);
				continue;
			}

			if(clase.clas.equals(CajeroTurno.class)) {
				this.setMostrarCajeroTurnoMesa(esAsigna);
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

		this.setActivarPedidoPuntoVentaMesa(esInicial);
		this.setActivarFacturaPuntoVentaMesa(esInicial);
		this.setActivarNotaCreditoPuntoVentaMesa(esInicial);
		this.setActivarCajeroTurnoMesa(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(PedidoPuntoVenta.class)) {
				this.setActivarPedidoPuntoVentaMesa(esAsigna);
				continue;
			}

			if(clase.clas.equals(FacturaPuntoVenta.class)) {
				this.setActivarFacturaPuntoVentaMesa(esAsigna);
				continue;
			}

			if(clase.clas.equals(NotaCreditoPuntoVenta.class)) {
				this.setActivarNotaCreditoPuntoVentaMesa(esAsigna);
				continue;
			}

			if(clase.clas.equals(CajeroTurno.class)) {
				this.setActivarCajeroTurnoMesa(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,MesaBeanSwingJInternalFrame mesaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarPedidoPuntoVentaMesa(esInicial);
		this.setResaltarFacturaPuntoVentaMesa(esInicial);
		this.setResaltarNotaCreditoPuntoVentaMesa(esInicial);
		this.setResaltarCajeroTurnoMesa(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(PedidoPuntoVenta.class)) {
				this.setResaltarPedidoPuntoVentaMesa(esAsigna);
				continue;
			}

			if(clase.clas.equals(FacturaPuntoVenta.class)) {
				this.setResaltarFacturaPuntoVentaMesa(esAsigna);
				continue;
			}

			if(clase.clas.equals(NotaCreditoPuntoVenta.class)) {
				this.setResaltarNotaCreditoPuntoVentaMesa(esAsigna);
				continue;
			}

			if(clase.clas.equals(CajeroTurno.class)) {
				this.setResaltarCajeroTurnoMesa(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaMesa=true;

	public Boolean getMostrarFK_IdEmpresaMesa() {
		return this.mostrarFK_IdEmpresaMesa;
	}

	public void setMostrarFK_IdEmpresaMesa(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaMesa= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalMesa=true;

	public Boolean getMostrarFK_IdSucursalMesa() {
		return this.mostrarFK_IdSucursalMesa;
	}

	public void setMostrarFK_IdSucursalMesa(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalMesa= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaMesa=true;

	public Boolean getActivarFK_IdEmpresaMesa() {
		return this.activarFK_IdEmpresaMesa;
	}

	public void setActivarFK_IdEmpresaMesa(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaMesa= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalMesa=true;

	public Boolean getActivarFK_IdSucursalMesa() {
		return this.activarFK_IdSucursalMesa;
	}

	public void setActivarFK_IdSucursalMesa(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalMesa= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaMesa=null;

	public Border getResaltarFK_IdEmpresaMesa() {
		return this.resaltarFK_IdEmpresaMesa;
	}

	public void setResaltarFK_IdEmpresaMesa(Border borderResaltar) {
		this.resaltarFK_IdEmpresaMesa= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaMesa(ParametroGeneralUsuario parametroGeneralUsuario/*MesaBeanSwingJInternalFrame mesaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaMesa= borderResaltar;
	}

	public Border resaltarFK_IdSucursalMesa=null;

	public Border getResaltarFK_IdSucursalMesa() {
		return this.resaltarFK_IdSucursalMesa;
	}

	public void setResaltarFK_IdSucursalMesa(Border borderResaltar) {
		this.resaltarFK_IdSucursalMesa= borderResaltar;
	}

	public void setResaltarFK_IdSucursalMesa(ParametroGeneralUsuario parametroGeneralUsuario/*MesaBeanSwingJInternalFrame mesaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalMesa= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}