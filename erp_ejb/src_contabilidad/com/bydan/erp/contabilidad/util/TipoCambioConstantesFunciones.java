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


import com.bydan.erp.contabilidad.util.TipoCambioConstantesFunciones;
import com.bydan.erp.contabilidad.util.TipoCambioParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.TipoCambioParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.sris.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.sris.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoCambioConstantesFunciones extends TipoCambioConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoCambio";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoCambio"+TipoCambioConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoCambioHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoCambioHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoCambioConstantesFunciones.SCHEMA+"_"+TipoCambioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoCambioHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoCambioConstantesFunciones.SCHEMA+"_"+TipoCambioConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoCambioConstantesFunciones.SCHEMA+"_"+TipoCambioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoCambioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoCambioConstantesFunciones.SCHEMA+"_"+TipoCambioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCambioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoCambioHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCambioConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCambioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoCambioHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoCambioConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoCambioConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoCambioConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoCambioConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoCambioConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Cambios";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Cambio";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Cambio";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoCambio";
	public static final String OBJECTNAME="tipocambio";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="tipo_cambio";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipocambio from "+TipoCambioConstantesFunciones.SPERSISTENCENAME+" tipocambio";
	public static String QUERYSELECTNATIVE="select "+TipoCambioConstantesFunciones.SCHEMA+"."+TipoCambioConstantesFunciones.TABLENAME+".id,"+TipoCambioConstantesFunciones.SCHEMA+"."+TipoCambioConstantesFunciones.TABLENAME+".version_row,"+TipoCambioConstantesFunciones.SCHEMA+"."+TipoCambioConstantesFunciones.TABLENAME+".id_empresa,"+TipoCambioConstantesFunciones.SCHEMA+"."+TipoCambioConstantesFunciones.TABLENAME+".id_moneda,"+TipoCambioConstantesFunciones.SCHEMA+"."+TipoCambioConstantesFunciones.TABLENAME+".valor_compra,"+TipoCambioConstantesFunciones.SCHEMA+"."+TipoCambioConstantesFunciones.TABLENAME+".valor_venta,"+TipoCambioConstantesFunciones.SCHEMA+"."+TipoCambioConstantesFunciones.TABLENAME+".fecha from "+TipoCambioConstantesFunciones.SCHEMA+"."+TipoCambioConstantesFunciones.TABLENAME;//+" as "+TipoCambioConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoCambioConstantesFuncionesAdditional tipocambioConstantesFuncionesAdditional=null;
	
	public TipoCambioConstantesFuncionesAdditional getTipoCambioConstantesFuncionesAdditional() {
		return this.tipocambioConstantesFuncionesAdditional;
	}
	
	public void setTipoCambioConstantesFuncionesAdditional(TipoCambioConstantesFuncionesAdditional tipocambioConstantesFuncionesAdditional) {
		try {
			this.tipocambioConstantesFuncionesAdditional=tipocambioConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDMONEDA= "id_moneda";
    public static final String VALORCOMPRA= "valor_compra";
    public static final String VALORVENTA= "valor_venta";
    public static final String FECHA= "fecha";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDMONEDA= "Moneda";
		public static final String LABEL_IDMONEDA_LOWER= "Moneda";
    	public static final String LABEL_VALORCOMPRA= "Valor Compra";
		public static final String LABEL_VALORCOMPRA_LOWER= "Valor Compra";
    	public static final String LABEL_VALORVENTA= "Valor Venta";
		public static final String LABEL_VALORVENTA_LOWER= "Valor Venta";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
	
		
		
		
		
		
		
		
	
	public static String getTipoCambioLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoCambioConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoCambioConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoCambioConstantesFunciones.IDMONEDA)) {sLabelColumna=TipoCambioConstantesFunciones.LABEL_IDMONEDA;}
		if(sNombreColumna.equals(TipoCambioConstantesFunciones.VALORCOMPRA)) {sLabelColumna=TipoCambioConstantesFunciones.LABEL_VALORCOMPRA;}
		if(sNombreColumna.equals(TipoCambioConstantesFunciones.VALORVENTA)) {sLabelColumna=TipoCambioConstantesFunciones.LABEL_VALORVENTA;}
		if(sNombreColumna.equals(TipoCambioConstantesFunciones.FECHA)) {sLabelColumna=TipoCambioConstantesFunciones.LABEL_FECHA;}
		
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
	
	
	
			
			
			
			
			
			
			
	
	public static String getTipoCambioDescripcion(TipoCambio tipocambio) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipocambio !=null/* && tipocambio.getId()!=0*/) {
			if(tipocambio.getId()!=null) {
				sDescripcion=tipocambio.getId().toString();
			}//tipocambiotipocambio.getId().toString().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoCambioDescripcionDetallado(TipoCambio tipocambio) {
		String sDescripcion="";
			
		sDescripcion+=TipoCambioConstantesFunciones.ID+"=";
		sDescripcion+=tipocambio.getId().toString()+",";
		sDescripcion+=TipoCambioConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipocambio.getVersionRow().toString()+",";
		sDescripcion+=TipoCambioConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipocambio.getid_empresa().toString()+",";
		sDescripcion+=TipoCambioConstantesFunciones.IDMONEDA+"=";
		sDescripcion+=tipocambio.getid_moneda().toString()+",";
		sDescripcion+=TipoCambioConstantesFunciones.VALORCOMPRA+"=";
		sDescripcion+=tipocambio.getvalor_compra().toString()+",";
		sDescripcion+=TipoCambioConstantesFunciones.VALORVENTA+"=";
		sDescripcion+=tipocambio.getvalor_venta().toString()+",";
		sDescripcion+=TipoCambioConstantesFunciones.FECHA+"=";
		sDescripcion+=tipocambio.getfecha().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoCambioDescripcion(TipoCambio tipocambio,String sValor) throws Exception {			
		if(tipocambio !=null) {
			;//tipocambiotipocambio.getId().toString().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getMonedaDescripcion(Moneda moneda) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(moneda!=null/*&&moneda.getId()>0*/) {
			sDescripcion=MonedaConstantesFunciones.getMonedaDescripcion(moneda);
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
		} else if(sNombreIndice.equals("FK_IdMoneda")) {
			sNombreIndice="Tipo=  Por Moneda";
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

	public static String getDetalleIndiceFK_IdMoneda(Long id_moneda) {
		String sDetalleIndice=" Parametros->";
		if(id_moneda!=null) {sDetalleIndice+=" Codigo Unico De Moneda="+id_moneda.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoCambio(TipoCambio tipocambio,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosTipoCambios(List<TipoCambio> tipocambios,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoCambio tipocambio: tipocambios) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoCambio(TipoCambio tipocambio,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipocambio.getConCambioAuxiliar()) {
			tipocambio.setIsDeleted(tipocambio.getIsDeletedAuxiliar());	
			tipocambio.setIsNew(tipocambio.getIsNewAuxiliar());	
			tipocambio.setIsChanged(tipocambio.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipocambio.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipocambio.setIsDeletedAuxiliar(false);	
			tipocambio.setIsNewAuxiliar(false);	
			tipocambio.setIsChangedAuxiliar(false);
			
			tipocambio.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoCambios(List<TipoCambio> tipocambios,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoCambio tipocambio : tipocambios) {
			if(conAsignarBase && tipocambio.getConCambioAuxiliar()) {
				tipocambio.setIsDeleted(tipocambio.getIsDeletedAuxiliar());	
				tipocambio.setIsNew(tipocambio.getIsNewAuxiliar());	
				tipocambio.setIsChanged(tipocambio.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipocambio.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipocambio.setIsDeletedAuxiliar(false);	
				tipocambio.setIsNewAuxiliar(false);	
				tipocambio.setIsChangedAuxiliar(false);
				
				tipocambio.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoCambio(TipoCambio tipocambio,Boolean conEnteros) throws Exception  {
		tipocambio.setvalor_compra(0.0);
		tipocambio.setvalor_venta(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoCambios(List<TipoCambio> tipocambios,Boolean conEnteros) throws Exception  {
		
		for(TipoCambio tipocambio: tipocambios) {
			tipocambio.setvalor_compra(0.0);
			tipocambio.setvalor_venta(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoCambio(List<TipoCambio> tipocambios,TipoCambio tipocambioAux) throws Exception  {
		TipoCambioConstantesFunciones.InicializarValoresTipoCambio(tipocambioAux,true);
		
		for(TipoCambio tipocambio: tipocambios) {
			if(tipocambio.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			tipocambioAux.setvalor_compra(tipocambioAux.getvalor_compra()+tipocambio.getvalor_compra());			
			tipocambioAux.setvalor_venta(tipocambioAux.getvalor_venta()+tipocambio.getvalor_venta());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoCambio(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoCambioConstantesFunciones.getArrayColumnasGlobalesTipoCambio(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoCambio(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoCambioConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoCambioConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoCambioConstantesFunciones.IDMONEDA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoCambioConstantesFunciones.IDMONEDA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoCambio(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoCambio> tipocambios,TipoCambio tipocambio,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoCambio tipocambioAux: tipocambios) {
			if(tipocambioAux!=null && tipocambio!=null) {
				if((tipocambioAux.getId()==null && tipocambio.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipocambioAux.getId()!=null && tipocambio.getId()!=null){
					if(tipocambioAux.getId().equals(tipocambio.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoCambio(List<TipoCambio> tipocambios) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valor_compraTotal=0.0;
		Double valor_ventaTotal=0.0;
	
		for(TipoCambio tipocambio: tipocambios) {			
			if(tipocambio.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valor_compraTotal+=tipocambio.getvalor_compra();
			valor_ventaTotal+=tipocambio.getvalor_venta();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TipoCambioConstantesFunciones.VALORCOMPRA);
		datoGeneral.setsDescripcion(TipoCambioConstantesFunciones.LABEL_VALORCOMPRA);
		datoGeneral.setdValorDouble(valor_compraTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TipoCambioConstantesFunciones.VALORVENTA);
		datoGeneral.setsDescripcion(TipoCambioConstantesFunciones.LABEL_VALORVENTA);
		datoGeneral.setdValorDouble(valor_ventaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoCambio() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoCambioConstantesFunciones.LABEL_ID, TipoCambioConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCambioConstantesFunciones.LABEL_VERSIONROW, TipoCambioConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCambioConstantesFunciones.LABEL_IDEMPRESA, TipoCambioConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCambioConstantesFunciones.LABEL_IDMONEDA, TipoCambioConstantesFunciones.IDMONEDA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCambioConstantesFunciones.LABEL_VALORCOMPRA, TipoCambioConstantesFunciones.VALORCOMPRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCambioConstantesFunciones.LABEL_VALORVENTA, TipoCambioConstantesFunciones.VALORVENTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoCambioConstantesFunciones.LABEL_FECHA, TipoCambioConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoCambio() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoCambioConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCambioConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCambioConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCambioConstantesFunciones.IDMONEDA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCambioConstantesFunciones.VALORCOMPRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCambioConstantesFunciones.VALORVENTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoCambioConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCambio() throws Exception  {
		return TipoCambioConstantesFunciones.getTiposSeleccionarTipoCambio(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCambio(Boolean conFk) throws Exception  {
		return TipoCambioConstantesFunciones.getTiposSeleccionarTipoCambio(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoCambio(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoCambioConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoCambioConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoCambioConstantesFunciones.LABEL_IDMONEDA);
			reporte.setsDescripcion(TipoCambioConstantesFunciones.LABEL_IDMONEDA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoCambioConstantesFunciones.LABEL_VALORCOMPRA);
			reporte.setsDescripcion(TipoCambioConstantesFunciones.LABEL_VALORCOMPRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoCambioConstantesFunciones.LABEL_VALORVENTA);
			reporte.setsDescripcion(TipoCambioConstantesFunciones.LABEL_VALORVENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoCambioConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(TipoCambioConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoCambio(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoCambio(TipoCambio tipocambioAux) throws Exception {
		
			tipocambioAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipocambioAux.getEmpresa()));
			tipocambioAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(tipocambioAux.getMoneda()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoCambio(List<TipoCambio> tipocambiosTemp) throws Exception {
		for(TipoCambio tipocambioAux:tipocambiosTemp) {
			
			tipocambioAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipocambioAux.getEmpresa()));
			tipocambioAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(tipocambioAux.getMoneda()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoCambio(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Moneda.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Moneda.class)) {
						classes.add(new Classe(Moneda.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoCambio(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Moneda.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Moneda.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Moneda.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Moneda.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoCambio(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoCambioConstantesFunciones.getClassesRelationshipsOfTipoCambio(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoCambio(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoCambio(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoCambioConstantesFunciones.getClassesRelationshipsFromStringsOfTipoCambio(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoCambio(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(TipoCambio tipocambio,List<TipoCambio> tipocambios,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoCambio tipocambioEncontrado=null;
			
			for(TipoCambio tipocambioLocal:tipocambios) {
				if(tipocambioLocal.getId().equals(tipocambio.getId())) {
					tipocambioEncontrado=tipocambioLocal;
					
					tipocambioLocal.setIsChanged(tipocambio.getIsChanged());
					tipocambioLocal.setIsNew(tipocambio.getIsNew());
					tipocambioLocal.setIsDeleted(tipocambio.getIsDeleted());
					
					tipocambioLocal.setGeneralEntityOriginal(tipocambio.getGeneralEntityOriginal());
					
					tipocambioLocal.setId(tipocambio.getId());	
					tipocambioLocal.setVersionRow(tipocambio.getVersionRow());	
					tipocambioLocal.setid_empresa(tipocambio.getid_empresa());	
					tipocambioLocal.setid_moneda(tipocambio.getid_moneda());	
					tipocambioLocal.setvalor_compra(tipocambio.getvalor_compra());	
					tipocambioLocal.setvalor_venta(tipocambio.getvalor_venta());	
					tipocambioLocal.setfecha(tipocambio.getfecha());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipocambio.getIsDeleted()) {
				if(!existe) {
					tipocambios.add(tipocambio);
				}
			} else {
				if(tipocambioEncontrado!=null && permiteQuitar)  {
					tipocambios.remove(tipocambioEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoCambio tipocambio,List<TipoCambio> tipocambios) throws Exception {
		try	{			
			for(TipoCambio tipocambioLocal:tipocambios) {
				if(tipocambioLocal.getId().equals(tipocambio.getId())) {
					tipocambioLocal.setIsSelected(tipocambio.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoCambio(List<TipoCambio> tipocambiosAux) throws Exception {
		//this.tipocambiosAux=tipocambiosAux;
		
		for(TipoCambio tipocambioAux:tipocambiosAux) {
			if(tipocambioAux.getIsChanged()) {
				tipocambioAux.setIsChanged(false);
			}		
			
			if(tipocambioAux.getIsNew()) {
				tipocambioAux.setIsNew(false);
			}	
			
			if(tipocambioAux.getIsDeleted()) {
				tipocambioAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoCambio(TipoCambio tipocambioAux) throws Exception {
		//this.tipocambioAux=tipocambioAux;
		
			if(tipocambioAux.getIsChanged()) {
				tipocambioAux.setIsChanged(false);
			}		
			
			if(tipocambioAux.getIsNew()) {
				tipocambioAux.setIsNew(false);
			}	
			
			if(tipocambioAux.getIsDeleted()) {
				tipocambioAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoCambio tipocambioAsignar,TipoCambio tipocambio) throws Exception {
		tipocambioAsignar.setId(tipocambio.getId());	
		tipocambioAsignar.setVersionRow(tipocambio.getVersionRow());	
		tipocambioAsignar.setid_empresa(tipocambio.getid_empresa());
		tipocambioAsignar.setempresa_descripcion(tipocambio.getempresa_descripcion());	
		tipocambioAsignar.setid_moneda(tipocambio.getid_moneda());
		tipocambioAsignar.setmoneda_descripcion(tipocambio.getmoneda_descripcion());	
		tipocambioAsignar.setvalor_compra(tipocambio.getvalor_compra());	
		tipocambioAsignar.setvalor_venta(tipocambio.getvalor_venta());	
		tipocambioAsignar.setfecha(tipocambio.getfecha());	
	}
	
	public static void inicializarTipoCambio(TipoCambio tipocambio) throws Exception {
		try {
				tipocambio.setId(0L);	
					
				tipocambio.setid_empresa(-1L);	
				tipocambio.setid_moneda(-1L);	
				tipocambio.setvalor_compra(0.0);	
				tipocambio.setvalor_venta(0.0);	
				tipocambio.setfecha(new Date());	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoCambio(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoCambioConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoCambioConstantesFunciones.LABEL_IDMONEDA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoCambioConstantesFunciones.LABEL_VALORCOMPRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoCambioConstantesFunciones.LABEL_VALORVENTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoCambioConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoCambio(String sTipo,Row row,Workbook workbook,TipoCambio tipocambio,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocambio.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocambio.getmoneda_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocambio.getvalor_compra());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocambio.getvalor_venta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipocambio.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoCambio=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoCambio() {
		return this.sFinalQueryTipoCambio;
	}
	
	public void setsFinalQueryTipoCambio(String sFinalQueryTipoCambio) {
		this.sFinalQueryTipoCambio= sFinalQueryTipoCambio;
	}
	
	public Border resaltarSeleccionarTipoCambio=null;
	
	public Border setResaltarSeleccionarTipoCambio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCambioBeanSwingJInternalFrame tipocambioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipocambioBeanSwingJInternalFrame.jTtoolBarTipoCambio.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoCambio= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoCambio() {
		return this.resaltarSeleccionarTipoCambio;
	}
	
	public void setResaltarSeleccionarTipoCambio(Border borderResaltarSeleccionarTipoCambio) {
		this.resaltarSeleccionarTipoCambio= borderResaltarSeleccionarTipoCambio;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoCambio=null;
	public Boolean mostraridTipoCambio=true;
	public Boolean activaridTipoCambio=true;

	public Border resaltarid_empresaTipoCambio=null;
	public Boolean mostrarid_empresaTipoCambio=true;
	public Boolean activarid_empresaTipoCambio=true;
	public Boolean cargarid_empresaTipoCambio=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoCambio=false;//ConEventDepend=true

	public Border resaltarid_monedaTipoCambio=null;
	public Boolean mostrarid_monedaTipoCambio=true;
	public Boolean activarid_monedaTipoCambio=true;
	public Boolean cargarid_monedaTipoCambio=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_monedaTipoCambio=false;//ConEventDepend=true

	public Border resaltarvalor_compraTipoCambio=null;
	public Boolean mostrarvalor_compraTipoCambio=true;
	public Boolean activarvalor_compraTipoCambio=true;

	public Border resaltarvalor_ventaTipoCambio=null;
	public Boolean mostrarvalor_ventaTipoCambio=true;
	public Boolean activarvalor_ventaTipoCambio=true;

	public Border resaltarfechaTipoCambio=null;
	public Boolean mostrarfechaTipoCambio=true;
	public Boolean activarfechaTipoCambio=true;

	
	

	public Border setResaltaridTipoCambio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCambioBeanSwingJInternalFrame tipocambioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocambioBeanSwingJInternalFrame.jTtoolBarTipoCambio.setBorder(borderResaltar);
		
		this.resaltaridTipoCambio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoCambio() {
		return this.resaltaridTipoCambio;
	}

	public void setResaltaridTipoCambio(Border borderResaltar) {
		this.resaltaridTipoCambio= borderResaltar;
	}

	public Boolean getMostraridTipoCambio() {
		return this.mostraridTipoCambio;
	}

	public void setMostraridTipoCambio(Boolean mostraridTipoCambio) {
		this.mostraridTipoCambio= mostraridTipoCambio;
	}

	public Boolean getActivaridTipoCambio() {
		return this.activaridTipoCambio;
	}

	public void setActivaridTipoCambio(Boolean activaridTipoCambio) {
		this.activaridTipoCambio= activaridTipoCambio;
	}

	public Border setResaltarid_empresaTipoCambio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCambioBeanSwingJInternalFrame tipocambioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocambioBeanSwingJInternalFrame.jTtoolBarTipoCambio.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoCambio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoCambio() {
		return this.resaltarid_empresaTipoCambio;
	}

	public void setResaltarid_empresaTipoCambio(Border borderResaltar) {
		this.resaltarid_empresaTipoCambio= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoCambio() {
		return this.mostrarid_empresaTipoCambio;
	}

	public void setMostrarid_empresaTipoCambio(Boolean mostrarid_empresaTipoCambio) {
		this.mostrarid_empresaTipoCambio= mostrarid_empresaTipoCambio;
	}

	public Boolean getActivarid_empresaTipoCambio() {
		return this.activarid_empresaTipoCambio;
	}

	public void setActivarid_empresaTipoCambio(Boolean activarid_empresaTipoCambio) {
		this.activarid_empresaTipoCambio= activarid_empresaTipoCambio;
	}

	public Boolean getCargarid_empresaTipoCambio() {
		return this.cargarid_empresaTipoCambio;
	}

	public void setCargarid_empresaTipoCambio(Boolean cargarid_empresaTipoCambio) {
		this.cargarid_empresaTipoCambio= cargarid_empresaTipoCambio;
	}

	public Border setResaltarid_monedaTipoCambio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCambioBeanSwingJInternalFrame tipocambioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocambioBeanSwingJInternalFrame.jTtoolBarTipoCambio.setBorder(borderResaltar);
		
		this.resaltarid_monedaTipoCambio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_monedaTipoCambio() {
		return this.resaltarid_monedaTipoCambio;
	}

	public void setResaltarid_monedaTipoCambio(Border borderResaltar) {
		this.resaltarid_monedaTipoCambio= borderResaltar;
	}

	public Boolean getMostrarid_monedaTipoCambio() {
		return this.mostrarid_monedaTipoCambio;
	}

	public void setMostrarid_monedaTipoCambio(Boolean mostrarid_monedaTipoCambio) {
		this.mostrarid_monedaTipoCambio= mostrarid_monedaTipoCambio;
	}

	public Boolean getActivarid_monedaTipoCambio() {
		return this.activarid_monedaTipoCambio;
	}

	public void setActivarid_monedaTipoCambio(Boolean activarid_monedaTipoCambio) {
		this.activarid_monedaTipoCambio= activarid_monedaTipoCambio;
	}

	public Boolean getCargarid_monedaTipoCambio() {
		return this.cargarid_monedaTipoCambio;
	}

	public void setCargarid_monedaTipoCambio(Boolean cargarid_monedaTipoCambio) {
		this.cargarid_monedaTipoCambio= cargarid_monedaTipoCambio;
	}

	public Border setResaltarvalor_compraTipoCambio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCambioBeanSwingJInternalFrame tipocambioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocambioBeanSwingJInternalFrame.jTtoolBarTipoCambio.setBorder(borderResaltar);
		
		this.resaltarvalor_compraTipoCambio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_compraTipoCambio() {
		return this.resaltarvalor_compraTipoCambio;
	}

	public void setResaltarvalor_compraTipoCambio(Border borderResaltar) {
		this.resaltarvalor_compraTipoCambio= borderResaltar;
	}

	public Boolean getMostrarvalor_compraTipoCambio() {
		return this.mostrarvalor_compraTipoCambio;
	}

	public void setMostrarvalor_compraTipoCambio(Boolean mostrarvalor_compraTipoCambio) {
		this.mostrarvalor_compraTipoCambio= mostrarvalor_compraTipoCambio;
	}

	public Boolean getActivarvalor_compraTipoCambio() {
		return this.activarvalor_compraTipoCambio;
	}

	public void setActivarvalor_compraTipoCambio(Boolean activarvalor_compraTipoCambio) {
		this.activarvalor_compraTipoCambio= activarvalor_compraTipoCambio;
	}

	public Border setResaltarvalor_ventaTipoCambio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCambioBeanSwingJInternalFrame tipocambioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocambioBeanSwingJInternalFrame.jTtoolBarTipoCambio.setBorder(borderResaltar);
		
		this.resaltarvalor_ventaTipoCambio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_ventaTipoCambio() {
		return this.resaltarvalor_ventaTipoCambio;
	}

	public void setResaltarvalor_ventaTipoCambio(Border borderResaltar) {
		this.resaltarvalor_ventaTipoCambio= borderResaltar;
	}

	public Boolean getMostrarvalor_ventaTipoCambio() {
		return this.mostrarvalor_ventaTipoCambio;
	}

	public void setMostrarvalor_ventaTipoCambio(Boolean mostrarvalor_ventaTipoCambio) {
		this.mostrarvalor_ventaTipoCambio= mostrarvalor_ventaTipoCambio;
	}

	public Boolean getActivarvalor_ventaTipoCambio() {
		return this.activarvalor_ventaTipoCambio;
	}

	public void setActivarvalor_ventaTipoCambio(Boolean activarvalor_ventaTipoCambio) {
		this.activarvalor_ventaTipoCambio= activarvalor_ventaTipoCambio;
	}

	public Border setResaltarfechaTipoCambio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCambioBeanSwingJInternalFrame tipocambioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipocambioBeanSwingJInternalFrame.jTtoolBarTipoCambio.setBorder(borderResaltar);
		
		this.resaltarfechaTipoCambio= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaTipoCambio() {
		return this.resaltarfechaTipoCambio;
	}

	public void setResaltarfechaTipoCambio(Border borderResaltar) {
		this.resaltarfechaTipoCambio= borderResaltar;
	}

	public Boolean getMostrarfechaTipoCambio() {
		return this.mostrarfechaTipoCambio;
	}

	public void setMostrarfechaTipoCambio(Boolean mostrarfechaTipoCambio) {
		this.mostrarfechaTipoCambio= mostrarfechaTipoCambio;
	}

	public Boolean getActivarfechaTipoCambio() {
		return this.activarfechaTipoCambio;
	}

	public void setActivarfechaTipoCambio(Boolean activarfechaTipoCambio) {
		this.activarfechaTipoCambio= activarfechaTipoCambio;
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
		
		
		this.setMostraridTipoCambio(esInicial);
		this.setMostrarid_empresaTipoCambio(esInicial);
		this.setMostrarid_monedaTipoCambio(esInicial);
		this.setMostrarvalor_compraTipoCambio(esInicial);
		this.setMostrarvalor_ventaTipoCambio(esInicial);
		this.setMostrarfechaTipoCambio(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoCambioConstantesFunciones.ID)) {
				this.setMostraridTipoCambio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCambioConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoCambio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCambioConstantesFunciones.IDMONEDA)) {
				this.setMostrarid_monedaTipoCambio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCambioConstantesFunciones.VALORCOMPRA)) {
				this.setMostrarvalor_compraTipoCambio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCambioConstantesFunciones.VALORVENTA)) {
				this.setMostrarvalor_ventaTipoCambio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCambioConstantesFunciones.FECHA)) {
				this.setMostrarfechaTipoCambio(esAsigna);
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
		
		
		this.setActivaridTipoCambio(esInicial);
		this.setActivarid_empresaTipoCambio(esInicial);
		this.setActivarid_monedaTipoCambio(esInicial);
		this.setActivarvalor_compraTipoCambio(esInicial);
		this.setActivarvalor_ventaTipoCambio(esInicial);
		this.setActivarfechaTipoCambio(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoCambioConstantesFunciones.ID)) {
				this.setActivaridTipoCambio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCambioConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoCambio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCambioConstantesFunciones.IDMONEDA)) {
				this.setActivarid_monedaTipoCambio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCambioConstantesFunciones.VALORCOMPRA)) {
				this.setActivarvalor_compraTipoCambio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCambioConstantesFunciones.VALORVENTA)) {
				this.setActivarvalor_ventaTipoCambio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCambioConstantesFunciones.FECHA)) {
				this.setActivarfechaTipoCambio(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoCambioBeanSwingJInternalFrame tipocambioBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoCambio(esInicial);
		this.setResaltarid_empresaTipoCambio(esInicial);
		this.setResaltarid_monedaTipoCambio(esInicial);
		this.setResaltarvalor_compraTipoCambio(esInicial);
		this.setResaltarvalor_ventaTipoCambio(esInicial);
		this.setResaltarfechaTipoCambio(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoCambioConstantesFunciones.ID)) {
				this.setResaltaridTipoCambio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCambioConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoCambio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCambioConstantesFunciones.IDMONEDA)) {
				this.setResaltarid_monedaTipoCambio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCambioConstantesFunciones.VALORCOMPRA)) {
				this.setResaltarvalor_compraTipoCambio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCambioConstantesFunciones.VALORVENTA)) {
				this.setResaltarvalor_ventaTipoCambio(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoCambioConstantesFunciones.FECHA)) {
				this.setResaltarfechaTipoCambio(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoCambioBeanSwingJInternalFrame tipocambioBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaTipoCambio=true;

	public Boolean getMostrarFK_IdEmpresaTipoCambio() {
		return this.mostrarFK_IdEmpresaTipoCambio;
	}

	public void setMostrarFK_IdEmpresaTipoCambio(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoCambio= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdMonedaTipoCambio=true;

	public Boolean getMostrarFK_IdMonedaTipoCambio() {
		return this.mostrarFK_IdMonedaTipoCambio;
	}

	public void setMostrarFK_IdMonedaTipoCambio(Boolean visibilidadResaltar) {
		this.mostrarFK_IdMonedaTipoCambio= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTipoCambio=true;

	public Boolean getActivarFK_IdEmpresaTipoCambio() {
		return this.activarFK_IdEmpresaTipoCambio;
	}

	public void setActivarFK_IdEmpresaTipoCambio(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoCambio= habilitarResaltar;
	}

	public Boolean activarFK_IdMonedaTipoCambio=true;

	public Boolean getActivarFK_IdMonedaTipoCambio() {
		return this.activarFK_IdMonedaTipoCambio;
	}

	public void setActivarFK_IdMonedaTipoCambio(Boolean habilitarResaltar) {
		this.activarFK_IdMonedaTipoCambio= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTipoCambio=null;

	public Border getResaltarFK_IdEmpresaTipoCambio() {
		return this.resaltarFK_IdEmpresaTipoCambio;
	}

	public void setResaltarFK_IdEmpresaTipoCambio(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoCambio= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoCambio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCambioBeanSwingJInternalFrame tipocambioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoCambio= borderResaltar;
	}

	public Border resaltarFK_IdMonedaTipoCambio=null;

	public Border getResaltarFK_IdMonedaTipoCambio() {
		return this.resaltarFK_IdMonedaTipoCambio;
	}

	public void setResaltarFK_IdMonedaTipoCambio(Border borderResaltar) {
		this.resaltarFK_IdMonedaTipoCambio= borderResaltar;
	}

	public void setResaltarFK_IdMonedaTipoCambio(ParametroGeneralUsuario parametroGeneralUsuario/*TipoCambioBeanSwingJInternalFrame tipocambioBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdMonedaTipoCambio= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}