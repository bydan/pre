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


import com.bydan.erp.puntoventa.util.TarjetaCreditoDescuentoConstantesFunciones;
import com.bydan.erp.puntoventa.util.TarjetaCreditoDescuentoParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.TarjetaCreditoDescuentoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TarjetaCreditoDescuentoConstantesFunciones extends TarjetaCreditoDescuentoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TarjetaCreditoDescuento";
	public static final String SPATHOPCION="PuntoVenta";	
	public static final String SPATHMODULO="puntoventa/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TarjetaCreditoDescuento"+TarjetaCreditoDescuentoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TarjetaCreditoDescuentoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TarjetaCreditoDescuentoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TarjetaCreditoDescuentoConstantesFunciones.SCHEMA+"_"+TarjetaCreditoDescuentoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TarjetaCreditoDescuentoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TarjetaCreditoDescuentoConstantesFunciones.SCHEMA+"_"+TarjetaCreditoDescuentoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TarjetaCreditoDescuentoConstantesFunciones.SCHEMA+"_"+TarjetaCreditoDescuentoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TarjetaCreditoDescuentoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TarjetaCreditoDescuentoConstantesFunciones.SCHEMA+"_"+TarjetaCreditoDescuentoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TarjetaCreditoDescuentoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TarjetaCreditoDescuentoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TarjetaCreditoDescuentoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TarjetaCreditoDescuentoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TarjetaCreditoDescuentoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TarjetaCreditoDescuentoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TarjetaCreditoDescuentoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TarjetaCreditoDescuentoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TarjetaCreditoDescuentoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TarjetaCreditoDescuentoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tarjeta Credito Descuentos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tarjeta Credito Descuento";
	public static final String SCLASSWEBTITULO_LOWER="Tarjeta Credito Descuento";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TarjetaCreditoDescuento";
	public static final String OBJECTNAME="tarjetacreditodescuento";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PUNTOVENTA;	
	public static final String TABLENAME="tarjeta_credito_descuento";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tarjetacreditodescuento from "+TarjetaCreditoDescuentoConstantesFunciones.SPERSISTENCENAME+" tarjetacreditodescuento";
	public static String QUERYSELECTNATIVE="select "+TarjetaCreditoDescuentoConstantesFunciones.SCHEMA+"."+TarjetaCreditoDescuentoConstantesFunciones.TABLENAME+".id,"+TarjetaCreditoDescuentoConstantesFunciones.SCHEMA+"."+TarjetaCreditoDescuentoConstantesFunciones.TABLENAME+".version_row,"+TarjetaCreditoDescuentoConstantesFunciones.SCHEMA+"."+TarjetaCreditoDescuentoConstantesFunciones.TABLENAME+".id_empresa,"+TarjetaCreditoDescuentoConstantesFunciones.SCHEMA+"."+TarjetaCreditoDescuentoConstantesFunciones.TABLENAME+".id_sucursal,"+TarjetaCreditoDescuentoConstantesFunciones.SCHEMA+"."+TarjetaCreditoDescuentoConstantesFunciones.TABLENAME+".id_tarjeta_credito,"+TarjetaCreditoDescuentoConstantesFunciones.SCHEMA+"."+TarjetaCreditoDescuentoConstantesFunciones.TABLENAME+".porcentaje,"+TarjetaCreditoDescuentoConstantesFunciones.SCHEMA+"."+TarjetaCreditoDescuentoConstantesFunciones.TABLENAME+".numero_meses,"+TarjetaCreditoDescuentoConstantesFunciones.SCHEMA+"."+TarjetaCreditoDescuentoConstantesFunciones.TABLENAME+".es_corriente,"+TarjetaCreditoDescuentoConstantesFunciones.SCHEMA+"."+TarjetaCreditoDescuentoConstantesFunciones.TABLENAME+".con_interes from "+TarjetaCreditoDescuentoConstantesFunciones.SCHEMA+"."+TarjetaCreditoDescuentoConstantesFunciones.TABLENAME;//+" as "+TarjetaCreditoDescuentoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TarjetaCreditoDescuentoConstantesFuncionesAdditional tarjetacreditodescuentoConstantesFuncionesAdditional=null;
	
	public TarjetaCreditoDescuentoConstantesFuncionesAdditional getTarjetaCreditoDescuentoConstantesFuncionesAdditional() {
		return this.tarjetacreditodescuentoConstantesFuncionesAdditional;
	}
	
	public void setTarjetaCreditoDescuentoConstantesFuncionesAdditional(TarjetaCreditoDescuentoConstantesFuncionesAdditional tarjetacreditodescuentoConstantesFuncionesAdditional) {
		try {
			this.tarjetacreditodescuentoConstantesFuncionesAdditional=tarjetacreditodescuentoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDTARJETACREDITO= "id_tarjeta_credito";
    public static final String PORCENTAJE= "porcentaje";
    public static final String NUMEROMESES= "numero_meses";
    public static final String ESCORRIENTE= "es_corriente";
    public static final String CONINTERES= "con_interes";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDTARJETACREDITO= "Tarjeta Credito";
		public static final String LABEL_IDTARJETACREDITO_LOWER= "Tarjeta Credito";
    	public static final String LABEL_PORCENTAJE= "Porcentaje";
		public static final String LABEL_PORCENTAJE_LOWER= "Porcentaje";
    	public static final String LABEL_NUMEROMESES= "Numero Meses";
		public static final String LABEL_NUMEROMESES_LOWER= "Numero Meses";
    	public static final String LABEL_ESCORRIENTE= "Es Corriente";
		public static final String LABEL_ESCORRIENTE_LOWER= "Es Corriente";
    	public static final String LABEL_CONINTERES= "Con Interes";
		public static final String LABEL_CONINTERES_LOWER= "Con Interes";
	
		
		
		
		
		
		
		
		
		
	
	public static String getTarjetaCreditoDescuentoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TarjetaCreditoDescuentoConstantesFunciones.IDEMPRESA)) {sLabelColumna=TarjetaCreditoDescuentoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TarjetaCreditoDescuentoConstantesFunciones.IDSUCURSAL)) {sLabelColumna=TarjetaCreditoDescuentoConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(TarjetaCreditoDescuentoConstantesFunciones.IDTARJETACREDITO)) {sLabelColumna=TarjetaCreditoDescuentoConstantesFunciones.LABEL_IDTARJETACREDITO;}
		if(sNombreColumna.equals(TarjetaCreditoDescuentoConstantesFunciones.PORCENTAJE)) {sLabelColumna=TarjetaCreditoDescuentoConstantesFunciones.LABEL_PORCENTAJE;}
		if(sNombreColumna.equals(TarjetaCreditoDescuentoConstantesFunciones.NUMEROMESES)) {sLabelColumna=TarjetaCreditoDescuentoConstantesFunciones.LABEL_NUMEROMESES;}
		if(sNombreColumna.equals(TarjetaCreditoDescuentoConstantesFunciones.ESCORRIENTE)) {sLabelColumna=TarjetaCreditoDescuentoConstantesFunciones.LABEL_ESCORRIENTE;}
		if(sNombreColumna.equals(TarjetaCreditoDescuentoConstantesFunciones.CONINTERES)) {sLabelColumna=TarjetaCreditoDescuentoConstantesFunciones.LABEL_CONINTERES;}
		
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
	
	
	
			
			
			
			
			
			
			
		
	public static String getes_corrienteDescripcion(TarjetaCreditoDescuento tarjetacreditodescuento) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!tarjetacreditodescuento.getes_corriente()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_corrienteHtmlDescripcion(TarjetaCreditoDescuento tarjetacreditodescuento) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(tarjetacreditodescuento.getId(),tarjetacreditodescuento.getes_corriente());

		return sDescripcion;
	}	
		
	public static String getcon_interesDescripcion(TarjetaCreditoDescuento tarjetacreditodescuento) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!tarjetacreditodescuento.getcon_interes()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_interesHtmlDescripcion(TarjetaCreditoDescuento tarjetacreditodescuento) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(tarjetacreditodescuento.getId(),tarjetacreditodescuento.getcon_interes());

		return sDescripcion;
	}	
	
	public static String getTarjetaCreditoDescuentoDescripcion(TarjetaCreditoDescuento tarjetacreditodescuento) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tarjetacreditodescuento !=null/* && tarjetacreditodescuento.getId()!=0*/) {
			if(tarjetacreditodescuento.getId()!=null) {
				sDescripcion=tarjetacreditodescuento.getId().toString();
			}//tarjetacreditodescuentotarjetacreditodescuento.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getTarjetaCreditoDescuentoDescripcionDetallado(TarjetaCreditoDescuento tarjetacreditodescuento) {
		String sDescripcion="";
			
		sDescripcion+=TarjetaCreditoDescuentoConstantesFunciones.ID+"=";
		sDescripcion+=tarjetacreditodescuento.getId().toString()+",";
		sDescripcion+=TarjetaCreditoDescuentoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tarjetacreditodescuento.getVersionRow().toString()+",";
		sDescripcion+=TarjetaCreditoDescuentoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tarjetacreditodescuento.getid_empresa().toString()+",";
		sDescripcion+=TarjetaCreditoDescuentoConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=tarjetacreditodescuento.getid_sucursal().toString()+",";
		sDescripcion+=TarjetaCreditoDescuentoConstantesFunciones.IDTARJETACREDITO+"=";
		sDescripcion+=tarjetacreditodescuento.getid_tarjeta_credito().toString()+",";
		sDescripcion+=TarjetaCreditoDescuentoConstantesFunciones.PORCENTAJE+"=";
		sDescripcion+=tarjetacreditodescuento.getporcentaje().toString()+",";
		sDescripcion+=TarjetaCreditoDescuentoConstantesFunciones.NUMEROMESES+"=";
		sDescripcion+=tarjetacreditodescuento.getnumero_meses().toString()+",";
		sDescripcion+=TarjetaCreditoDescuentoConstantesFunciones.ESCORRIENTE+"=";
		sDescripcion+=tarjetacreditodescuento.getes_corriente().toString()+",";
		sDescripcion+=TarjetaCreditoDescuentoConstantesFunciones.CONINTERES+"=";
		sDescripcion+=tarjetacreditodescuento.getcon_interes().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setTarjetaCreditoDescuentoDescripcion(TarjetaCreditoDescuento tarjetacreditodescuento,String sValor) throws Exception {			
		if(tarjetacreditodescuento !=null) {
			//tarjetacreditodescuentotarjetacreditodescuento.getId().toString();
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

	public static String getTarjetaCreditoDescripcion(TarjetaCredito tarjetacredito) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tarjetacredito!=null/*&&tarjetacredito.getId()>0*/) {
			sDescripcion=TarjetaCreditoConstantesFunciones.getTarjetaCreditoDescripcion(tarjetacredito);
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
		} else if(sNombreIndice.equals("FK_IdTarjetaCredito")) {
			sNombreIndice="Tipo=  Por Tarjeta Credito";
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

	public static String getDetalleIndiceFK_IdTarjetaCredito(Long id_tarjeta_credito) {
		String sDetalleIndice=" Parametros->";
		if(id_tarjeta_credito!=null) {sDetalleIndice+=" Codigo Unico De Tarjeta Credito="+id_tarjeta_credito.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTarjetaCreditoDescuento(TarjetaCreditoDescuento tarjetacreditodescuento,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosTarjetaCreditoDescuentos(List<TarjetaCreditoDescuento> tarjetacreditodescuentos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TarjetaCreditoDescuento tarjetacreditodescuento: tarjetacreditodescuentos) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTarjetaCreditoDescuento(TarjetaCreditoDescuento tarjetacreditodescuento,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tarjetacreditodescuento.getConCambioAuxiliar()) {
			tarjetacreditodescuento.setIsDeleted(tarjetacreditodescuento.getIsDeletedAuxiliar());	
			tarjetacreditodescuento.setIsNew(tarjetacreditodescuento.getIsNewAuxiliar());	
			tarjetacreditodescuento.setIsChanged(tarjetacreditodescuento.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tarjetacreditodescuento.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tarjetacreditodescuento.setIsDeletedAuxiliar(false);	
			tarjetacreditodescuento.setIsNewAuxiliar(false);	
			tarjetacreditodescuento.setIsChangedAuxiliar(false);
			
			tarjetacreditodescuento.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTarjetaCreditoDescuentos(List<TarjetaCreditoDescuento> tarjetacreditodescuentos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TarjetaCreditoDescuento tarjetacreditodescuento : tarjetacreditodescuentos) {
			if(conAsignarBase && tarjetacreditodescuento.getConCambioAuxiliar()) {
				tarjetacreditodescuento.setIsDeleted(tarjetacreditodescuento.getIsDeletedAuxiliar());	
				tarjetacreditodescuento.setIsNew(tarjetacreditodescuento.getIsNewAuxiliar());	
				tarjetacreditodescuento.setIsChanged(tarjetacreditodescuento.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tarjetacreditodescuento.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tarjetacreditodescuento.setIsDeletedAuxiliar(false);	
				tarjetacreditodescuento.setIsNewAuxiliar(false);	
				tarjetacreditodescuento.setIsChangedAuxiliar(false);
				
				tarjetacreditodescuento.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTarjetaCreditoDescuento(TarjetaCreditoDescuento tarjetacreditodescuento,Boolean conEnteros) throws Exception  {
		tarjetacreditodescuento.setporcentaje(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			tarjetacreditodescuento.setnumero_meses(0);
		}
	}		
	
	public static void InicializarValoresTarjetaCreditoDescuentos(List<TarjetaCreditoDescuento> tarjetacreditodescuentos,Boolean conEnteros) throws Exception  {
		
		for(TarjetaCreditoDescuento tarjetacreditodescuento: tarjetacreditodescuentos) {
			tarjetacreditodescuento.setporcentaje(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				tarjetacreditodescuento.setnumero_meses(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaTarjetaCreditoDescuento(List<TarjetaCreditoDescuento> tarjetacreditodescuentos,TarjetaCreditoDescuento tarjetacreditodescuentoAux) throws Exception  {
		TarjetaCreditoDescuentoConstantesFunciones.InicializarValoresTarjetaCreditoDescuento(tarjetacreditodescuentoAux,true);
		
		for(TarjetaCreditoDescuento tarjetacreditodescuento: tarjetacreditodescuentos) {
			if(tarjetacreditodescuento.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			tarjetacreditodescuentoAux.setporcentaje(tarjetacreditodescuentoAux.getporcentaje()+tarjetacreditodescuento.getporcentaje());			
			tarjetacreditodescuentoAux.setnumero_meses(tarjetacreditodescuentoAux.getnumero_meses()+tarjetacreditodescuento.getnumero_meses());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTarjetaCreditoDescuento(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TarjetaCreditoDescuentoConstantesFunciones.getArrayColumnasGlobalesTarjetaCreditoDescuento(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTarjetaCreditoDescuento(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TarjetaCreditoDescuentoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TarjetaCreditoDescuentoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TarjetaCreditoDescuentoConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TarjetaCreditoDescuentoConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTarjetaCreditoDescuento(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TarjetaCreditoDescuento> tarjetacreditodescuentos,TarjetaCreditoDescuento tarjetacreditodescuento,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TarjetaCreditoDescuento tarjetacreditodescuentoAux: tarjetacreditodescuentos) {
			if(tarjetacreditodescuentoAux!=null && tarjetacreditodescuento!=null) {
				if((tarjetacreditodescuentoAux.getId()==null && tarjetacreditodescuento.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tarjetacreditodescuentoAux.getId()!=null && tarjetacreditodescuento.getId()!=null){
					if(tarjetacreditodescuentoAux.getId().equals(tarjetacreditodescuento.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTarjetaCreditoDescuento(List<TarjetaCreditoDescuento> tarjetacreditodescuentos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double porcentajeTotal=0.0;
	
		for(TarjetaCreditoDescuento tarjetacreditodescuento: tarjetacreditodescuentos) {			
			if(tarjetacreditodescuento.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			porcentajeTotal+=tarjetacreditodescuento.getporcentaje();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TarjetaCreditoDescuentoConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(TarjetaCreditoDescuentoConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTarjetaCreditoDescuento() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TarjetaCreditoDescuentoConstantesFunciones.LABEL_ID, TarjetaCreditoDescuentoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TarjetaCreditoDescuentoConstantesFunciones.LABEL_VERSIONROW, TarjetaCreditoDescuentoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TarjetaCreditoDescuentoConstantesFunciones.LABEL_IDEMPRESA, TarjetaCreditoDescuentoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TarjetaCreditoDescuentoConstantesFunciones.LABEL_IDSUCURSAL, TarjetaCreditoDescuentoConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TarjetaCreditoDescuentoConstantesFunciones.LABEL_IDTARJETACREDITO, TarjetaCreditoDescuentoConstantesFunciones.IDTARJETACREDITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TarjetaCreditoDescuentoConstantesFunciones.LABEL_PORCENTAJE, TarjetaCreditoDescuentoConstantesFunciones.PORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TarjetaCreditoDescuentoConstantesFunciones.LABEL_NUMEROMESES, TarjetaCreditoDescuentoConstantesFunciones.NUMEROMESES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TarjetaCreditoDescuentoConstantesFunciones.LABEL_ESCORRIENTE, TarjetaCreditoDescuentoConstantesFunciones.ESCORRIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TarjetaCreditoDescuentoConstantesFunciones.LABEL_CONINTERES, TarjetaCreditoDescuentoConstantesFunciones.CONINTERES,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTarjetaCreditoDescuento() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TarjetaCreditoDescuentoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TarjetaCreditoDescuentoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TarjetaCreditoDescuentoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TarjetaCreditoDescuentoConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TarjetaCreditoDescuentoConstantesFunciones.IDTARJETACREDITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TarjetaCreditoDescuentoConstantesFunciones.PORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TarjetaCreditoDescuentoConstantesFunciones.NUMEROMESES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TarjetaCreditoDescuentoConstantesFunciones.ESCORRIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TarjetaCreditoDescuentoConstantesFunciones.CONINTERES;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTarjetaCreditoDescuento() throws Exception  {
		return TarjetaCreditoDescuentoConstantesFunciones.getTiposSeleccionarTarjetaCreditoDescuento(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTarjetaCreditoDescuento(Boolean conFk) throws Exception  {
		return TarjetaCreditoDescuentoConstantesFunciones.getTiposSeleccionarTarjetaCreditoDescuento(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTarjetaCreditoDescuento(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TarjetaCreditoDescuentoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TarjetaCreditoDescuentoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TarjetaCreditoDescuentoConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(TarjetaCreditoDescuentoConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TarjetaCreditoDescuentoConstantesFunciones.LABEL_IDTARJETACREDITO);
			reporte.setsDescripcion(TarjetaCreditoDescuentoConstantesFunciones.LABEL_IDTARJETACREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TarjetaCreditoDescuentoConstantesFunciones.LABEL_PORCENTAJE);
			reporte.setsDescripcion(TarjetaCreditoDescuentoConstantesFunciones.LABEL_PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TarjetaCreditoDescuentoConstantesFunciones.LABEL_NUMEROMESES);
			reporte.setsDescripcion(TarjetaCreditoDescuentoConstantesFunciones.LABEL_NUMEROMESES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TarjetaCreditoDescuentoConstantesFunciones.LABEL_ESCORRIENTE);
			reporte.setsDescripcion(TarjetaCreditoDescuentoConstantesFunciones.LABEL_ESCORRIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TarjetaCreditoDescuentoConstantesFunciones.LABEL_CONINTERES);
			reporte.setsDescripcion(TarjetaCreditoDescuentoConstantesFunciones.LABEL_CONINTERES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTarjetaCreditoDescuento(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTarjetaCreditoDescuento(TarjetaCreditoDescuento tarjetacreditodescuentoAux) throws Exception {
		
			tarjetacreditodescuentoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tarjetacreditodescuentoAux.getEmpresa()));
			tarjetacreditodescuentoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(tarjetacreditodescuentoAux.getSucursal()));
			tarjetacreditodescuentoAux.settarjetacredito_descripcion(TarjetaCreditoConstantesFunciones.getTarjetaCreditoDescripcion(tarjetacreditodescuentoAux.getTarjetaCredito()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTarjetaCreditoDescuento(List<TarjetaCreditoDescuento> tarjetacreditodescuentosTemp) throws Exception {
		for(TarjetaCreditoDescuento tarjetacreditodescuentoAux:tarjetacreditodescuentosTemp) {
			
			tarjetacreditodescuentoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tarjetacreditodescuentoAux.getEmpresa()));
			tarjetacreditodescuentoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(tarjetacreditodescuentoAux.getSucursal()));
			tarjetacreditodescuentoAux.settarjetacredito_descripcion(TarjetaCreditoConstantesFunciones.getTarjetaCreditoDescripcion(tarjetacreditodescuentoAux.getTarjetaCredito()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTarjetaCreditoDescuento(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(TarjetaCredito.class));
				
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

				for(Classe clas:classesP) {
					if(clas.clas.equals(TarjetaCredito.class)) {
						classes.add(new Classe(TarjetaCredito.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTarjetaCreditoDescuento(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(TarjetaCredito.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TarjetaCredito.class)); continue;
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

					if(TarjetaCredito.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TarjetaCredito.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTarjetaCreditoDescuento(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TarjetaCreditoDescuentoConstantesFunciones.getClassesRelationshipsOfTarjetaCreditoDescuento(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTarjetaCreditoDescuento(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTarjetaCreditoDescuento(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TarjetaCreditoDescuentoConstantesFunciones.getClassesRelationshipsFromStringsOfTarjetaCreditoDescuento(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTarjetaCreditoDescuento(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TarjetaCreditoDescuento tarjetacreditodescuento,List<TarjetaCreditoDescuento> tarjetacreditodescuentos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TarjetaCreditoDescuento tarjetacreditodescuentoEncontrado=null;
			
			for(TarjetaCreditoDescuento tarjetacreditodescuentoLocal:tarjetacreditodescuentos) {
				if(tarjetacreditodescuentoLocal.getId().equals(tarjetacreditodescuento.getId())) {
					tarjetacreditodescuentoEncontrado=tarjetacreditodescuentoLocal;
					
					tarjetacreditodescuentoLocal.setIsChanged(tarjetacreditodescuento.getIsChanged());
					tarjetacreditodescuentoLocal.setIsNew(tarjetacreditodescuento.getIsNew());
					tarjetacreditodescuentoLocal.setIsDeleted(tarjetacreditodescuento.getIsDeleted());
					
					tarjetacreditodescuentoLocal.setGeneralEntityOriginal(tarjetacreditodescuento.getGeneralEntityOriginal());
					
					tarjetacreditodescuentoLocal.setId(tarjetacreditodescuento.getId());	
					tarjetacreditodescuentoLocal.setVersionRow(tarjetacreditodescuento.getVersionRow());	
					tarjetacreditodescuentoLocal.setid_empresa(tarjetacreditodescuento.getid_empresa());	
					tarjetacreditodescuentoLocal.setid_sucursal(tarjetacreditodescuento.getid_sucursal());	
					tarjetacreditodescuentoLocal.setid_tarjeta_credito(tarjetacreditodescuento.getid_tarjeta_credito());	
					tarjetacreditodescuentoLocal.setporcentaje(tarjetacreditodescuento.getporcentaje());	
					tarjetacreditodescuentoLocal.setnumero_meses(tarjetacreditodescuento.getnumero_meses());	
					tarjetacreditodescuentoLocal.setes_corriente(tarjetacreditodescuento.getes_corriente());	
					tarjetacreditodescuentoLocal.setcon_interes(tarjetacreditodescuento.getcon_interes());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tarjetacreditodescuento.getIsDeleted()) {
				if(!existe) {
					tarjetacreditodescuentos.add(tarjetacreditodescuento);
				}
			} else {
				if(tarjetacreditodescuentoEncontrado!=null && permiteQuitar)  {
					tarjetacreditodescuentos.remove(tarjetacreditodescuentoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TarjetaCreditoDescuento tarjetacreditodescuento,List<TarjetaCreditoDescuento> tarjetacreditodescuentos) throws Exception {
		try	{			
			for(TarjetaCreditoDescuento tarjetacreditodescuentoLocal:tarjetacreditodescuentos) {
				if(tarjetacreditodescuentoLocal.getId().equals(tarjetacreditodescuento.getId())) {
					tarjetacreditodescuentoLocal.setIsSelected(tarjetacreditodescuento.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTarjetaCreditoDescuento(List<TarjetaCreditoDescuento> tarjetacreditodescuentosAux) throws Exception {
		//this.tarjetacreditodescuentosAux=tarjetacreditodescuentosAux;
		
		for(TarjetaCreditoDescuento tarjetacreditodescuentoAux:tarjetacreditodescuentosAux) {
			if(tarjetacreditodescuentoAux.getIsChanged()) {
				tarjetacreditodescuentoAux.setIsChanged(false);
			}		
			
			if(tarjetacreditodescuentoAux.getIsNew()) {
				tarjetacreditodescuentoAux.setIsNew(false);
			}	
			
			if(tarjetacreditodescuentoAux.getIsDeleted()) {
				tarjetacreditodescuentoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTarjetaCreditoDescuento(TarjetaCreditoDescuento tarjetacreditodescuentoAux) throws Exception {
		//this.tarjetacreditodescuentoAux=tarjetacreditodescuentoAux;
		
			if(tarjetacreditodescuentoAux.getIsChanged()) {
				tarjetacreditodescuentoAux.setIsChanged(false);
			}		
			
			if(tarjetacreditodescuentoAux.getIsNew()) {
				tarjetacreditodescuentoAux.setIsNew(false);
			}	
			
			if(tarjetacreditodescuentoAux.getIsDeleted()) {
				tarjetacreditodescuentoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TarjetaCreditoDescuento tarjetacreditodescuentoAsignar,TarjetaCreditoDescuento tarjetacreditodescuento) throws Exception {
		tarjetacreditodescuentoAsignar.setId(tarjetacreditodescuento.getId());	
		tarjetacreditodescuentoAsignar.setVersionRow(tarjetacreditodescuento.getVersionRow());	
		tarjetacreditodescuentoAsignar.setid_empresa(tarjetacreditodescuento.getid_empresa());
		tarjetacreditodescuentoAsignar.setempresa_descripcion(tarjetacreditodescuento.getempresa_descripcion());	
		tarjetacreditodescuentoAsignar.setid_sucursal(tarjetacreditodescuento.getid_sucursal());
		tarjetacreditodescuentoAsignar.setsucursal_descripcion(tarjetacreditodescuento.getsucursal_descripcion());	
		tarjetacreditodescuentoAsignar.setid_tarjeta_credito(tarjetacreditodescuento.getid_tarjeta_credito());
		tarjetacreditodescuentoAsignar.settarjetacredito_descripcion(tarjetacreditodescuento.gettarjetacredito_descripcion());	
		tarjetacreditodescuentoAsignar.setporcentaje(tarjetacreditodescuento.getporcentaje());	
		tarjetacreditodescuentoAsignar.setnumero_meses(tarjetacreditodescuento.getnumero_meses());	
		tarjetacreditodescuentoAsignar.setes_corriente(tarjetacreditodescuento.getes_corriente());	
		tarjetacreditodescuentoAsignar.setcon_interes(tarjetacreditodescuento.getcon_interes());	
	}
	
	public static void inicializarTarjetaCreditoDescuento(TarjetaCreditoDescuento tarjetacreditodescuento) throws Exception {
		try {
				tarjetacreditodescuento.setId(0L);	
					
				tarjetacreditodescuento.setid_empresa(-1L);	
				tarjetacreditodescuento.setid_sucursal(-1L);	
				tarjetacreditodescuento.setid_tarjeta_credito(-1L);	
				tarjetacreditodescuento.setporcentaje(0.0);	
				tarjetacreditodescuento.setnumero_meses(0);	
				tarjetacreditodescuento.setes_corriente(false);	
				tarjetacreditodescuento.setcon_interes(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTarjetaCreditoDescuento(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TarjetaCreditoDescuentoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TarjetaCreditoDescuentoConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TarjetaCreditoDescuentoConstantesFunciones.LABEL_IDTARJETACREDITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TarjetaCreditoDescuentoConstantesFunciones.LABEL_PORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TarjetaCreditoDescuentoConstantesFunciones.LABEL_NUMEROMESES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TarjetaCreditoDescuentoConstantesFunciones.LABEL_ESCORRIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TarjetaCreditoDescuentoConstantesFunciones.LABEL_CONINTERES);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTarjetaCreditoDescuento(String sTipo,Row row,Workbook workbook,TarjetaCreditoDescuento tarjetacreditodescuento,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tarjetacreditodescuento.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tarjetacreditodescuento.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tarjetacreditodescuento.gettarjetacredito_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tarjetacreditodescuento.getporcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tarjetacreditodescuento.getnumero_meses());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(tarjetacreditodescuento.getes_corriente()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(tarjetacreditodescuento.getcon_interes()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTarjetaCreditoDescuento=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTarjetaCreditoDescuento() {
		return this.sFinalQueryTarjetaCreditoDescuento;
	}
	
	public void setsFinalQueryTarjetaCreditoDescuento(String sFinalQueryTarjetaCreditoDescuento) {
		this.sFinalQueryTarjetaCreditoDescuento= sFinalQueryTarjetaCreditoDescuento;
	}
	
	public Border resaltarSeleccionarTarjetaCreditoDescuento=null;
	
	public Border setResaltarSeleccionarTarjetaCreditoDescuento(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetaCreditoDescuentoBeanSwingJInternalFrame tarjetacreditodescuentoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tarjetacreditodescuentoBeanSwingJInternalFrame.jTtoolBarTarjetaCreditoDescuento.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTarjetaCreditoDescuento= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTarjetaCreditoDescuento() {
		return this.resaltarSeleccionarTarjetaCreditoDescuento;
	}
	
	public void setResaltarSeleccionarTarjetaCreditoDescuento(Border borderResaltarSeleccionarTarjetaCreditoDescuento) {
		this.resaltarSeleccionarTarjetaCreditoDescuento= borderResaltarSeleccionarTarjetaCreditoDescuento;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTarjetaCreditoDescuento=null;
	public Boolean mostraridTarjetaCreditoDescuento=true;
	public Boolean activaridTarjetaCreditoDescuento=true;

	public Border resaltarid_empresaTarjetaCreditoDescuento=null;
	public Boolean mostrarid_empresaTarjetaCreditoDescuento=true;
	public Boolean activarid_empresaTarjetaCreditoDescuento=true;
	public Boolean cargarid_empresaTarjetaCreditoDescuento=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTarjetaCreditoDescuento=false;//ConEventDepend=true

	public Border resaltarid_sucursalTarjetaCreditoDescuento=null;
	public Boolean mostrarid_sucursalTarjetaCreditoDescuento=true;
	public Boolean activarid_sucursalTarjetaCreditoDescuento=true;
	public Boolean cargarid_sucursalTarjetaCreditoDescuento=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalTarjetaCreditoDescuento=false;//ConEventDepend=true

	public Border resaltarid_tarjeta_creditoTarjetaCreditoDescuento=null;
	public Boolean mostrarid_tarjeta_creditoTarjetaCreditoDescuento=true;
	public Boolean activarid_tarjeta_creditoTarjetaCreditoDescuento=true;
	public Boolean cargarid_tarjeta_creditoTarjetaCreditoDescuento=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tarjeta_creditoTarjetaCreditoDescuento=false;//ConEventDepend=true

	public Border resaltarporcentajeTarjetaCreditoDescuento=null;
	public Boolean mostrarporcentajeTarjetaCreditoDescuento=true;
	public Boolean activarporcentajeTarjetaCreditoDescuento=true;

	public Border resaltarnumero_mesesTarjetaCreditoDescuento=null;
	public Boolean mostrarnumero_mesesTarjetaCreditoDescuento=true;
	public Boolean activarnumero_mesesTarjetaCreditoDescuento=true;

	public Border resaltares_corrienteTarjetaCreditoDescuento=null;
	public Boolean mostrares_corrienteTarjetaCreditoDescuento=true;
	public Boolean activares_corrienteTarjetaCreditoDescuento=true;

	public Border resaltarcon_interesTarjetaCreditoDescuento=null;
	public Boolean mostrarcon_interesTarjetaCreditoDescuento=true;
	public Boolean activarcon_interesTarjetaCreditoDescuento=true;

	
	

	public Border setResaltaridTarjetaCreditoDescuento(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetaCreditoDescuentoBeanSwingJInternalFrame tarjetacreditodescuentoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tarjetacreditodescuentoBeanSwingJInternalFrame.jTtoolBarTarjetaCreditoDescuento.setBorder(borderResaltar);
		
		this.resaltaridTarjetaCreditoDescuento= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTarjetaCreditoDescuento() {
		return this.resaltaridTarjetaCreditoDescuento;
	}

	public void setResaltaridTarjetaCreditoDescuento(Border borderResaltar) {
		this.resaltaridTarjetaCreditoDescuento= borderResaltar;
	}

	public Boolean getMostraridTarjetaCreditoDescuento() {
		return this.mostraridTarjetaCreditoDescuento;
	}

	public void setMostraridTarjetaCreditoDescuento(Boolean mostraridTarjetaCreditoDescuento) {
		this.mostraridTarjetaCreditoDescuento= mostraridTarjetaCreditoDescuento;
	}

	public Boolean getActivaridTarjetaCreditoDescuento() {
		return this.activaridTarjetaCreditoDescuento;
	}

	public void setActivaridTarjetaCreditoDescuento(Boolean activaridTarjetaCreditoDescuento) {
		this.activaridTarjetaCreditoDescuento= activaridTarjetaCreditoDescuento;
	}

	public Border setResaltarid_empresaTarjetaCreditoDescuento(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetaCreditoDescuentoBeanSwingJInternalFrame tarjetacreditodescuentoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tarjetacreditodescuentoBeanSwingJInternalFrame.jTtoolBarTarjetaCreditoDescuento.setBorder(borderResaltar);
		
		this.resaltarid_empresaTarjetaCreditoDescuento= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTarjetaCreditoDescuento() {
		return this.resaltarid_empresaTarjetaCreditoDescuento;
	}

	public void setResaltarid_empresaTarjetaCreditoDescuento(Border borderResaltar) {
		this.resaltarid_empresaTarjetaCreditoDescuento= borderResaltar;
	}

	public Boolean getMostrarid_empresaTarjetaCreditoDescuento() {
		return this.mostrarid_empresaTarjetaCreditoDescuento;
	}

	public void setMostrarid_empresaTarjetaCreditoDescuento(Boolean mostrarid_empresaTarjetaCreditoDescuento) {
		this.mostrarid_empresaTarjetaCreditoDescuento= mostrarid_empresaTarjetaCreditoDescuento;
	}

	public Boolean getActivarid_empresaTarjetaCreditoDescuento() {
		return this.activarid_empresaTarjetaCreditoDescuento;
	}

	public void setActivarid_empresaTarjetaCreditoDescuento(Boolean activarid_empresaTarjetaCreditoDescuento) {
		this.activarid_empresaTarjetaCreditoDescuento= activarid_empresaTarjetaCreditoDescuento;
	}

	public Boolean getCargarid_empresaTarjetaCreditoDescuento() {
		return this.cargarid_empresaTarjetaCreditoDescuento;
	}

	public void setCargarid_empresaTarjetaCreditoDescuento(Boolean cargarid_empresaTarjetaCreditoDescuento) {
		this.cargarid_empresaTarjetaCreditoDescuento= cargarid_empresaTarjetaCreditoDescuento;
	}

	public Border setResaltarid_sucursalTarjetaCreditoDescuento(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetaCreditoDescuentoBeanSwingJInternalFrame tarjetacreditodescuentoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tarjetacreditodescuentoBeanSwingJInternalFrame.jTtoolBarTarjetaCreditoDescuento.setBorder(borderResaltar);
		
		this.resaltarid_sucursalTarjetaCreditoDescuento= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalTarjetaCreditoDescuento() {
		return this.resaltarid_sucursalTarjetaCreditoDescuento;
	}

	public void setResaltarid_sucursalTarjetaCreditoDescuento(Border borderResaltar) {
		this.resaltarid_sucursalTarjetaCreditoDescuento= borderResaltar;
	}

	public Boolean getMostrarid_sucursalTarjetaCreditoDescuento() {
		return this.mostrarid_sucursalTarjetaCreditoDescuento;
	}

	public void setMostrarid_sucursalTarjetaCreditoDescuento(Boolean mostrarid_sucursalTarjetaCreditoDescuento) {
		this.mostrarid_sucursalTarjetaCreditoDescuento= mostrarid_sucursalTarjetaCreditoDescuento;
	}

	public Boolean getActivarid_sucursalTarjetaCreditoDescuento() {
		return this.activarid_sucursalTarjetaCreditoDescuento;
	}

	public void setActivarid_sucursalTarjetaCreditoDescuento(Boolean activarid_sucursalTarjetaCreditoDescuento) {
		this.activarid_sucursalTarjetaCreditoDescuento= activarid_sucursalTarjetaCreditoDescuento;
	}

	public Boolean getCargarid_sucursalTarjetaCreditoDescuento() {
		return this.cargarid_sucursalTarjetaCreditoDescuento;
	}

	public void setCargarid_sucursalTarjetaCreditoDescuento(Boolean cargarid_sucursalTarjetaCreditoDescuento) {
		this.cargarid_sucursalTarjetaCreditoDescuento= cargarid_sucursalTarjetaCreditoDescuento;
	}

	public Border setResaltarid_tarjeta_creditoTarjetaCreditoDescuento(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetaCreditoDescuentoBeanSwingJInternalFrame tarjetacreditodescuentoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tarjetacreditodescuentoBeanSwingJInternalFrame.jTtoolBarTarjetaCreditoDescuento.setBorder(borderResaltar);
		
		this.resaltarid_tarjeta_creditoTarjetaCreditoDescuento= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tarjeta_creditoTarjetaCreditoDescuento() {
		return this.resaltarid_tarjeta_creditoTarjetaCreditoDescuento;
	}

	public void setResaltarid_tarjeta_creditoTarjetaCreditoDescuento(Border borderResaltar) {
		this.resaltarid_tarjeta_creditoTarjetaCreditoDescuento= borderResaltar;
	}

	public Boolean getMostrarid_tarjeta_creditoTarjetaCreditoDescuento() {
		return this.mostrarid_tarjeta_creditoTarjetaCreditoDescuento;
	}

	public void setMostrarid_tarjeta_creditoTarjetaCreditoDescuento(Boolean mostrarid_tarjeta_creditoTarjetaCreditoDescuento) {
		this.mostrarid_tarjeta_creditoTarjetaCreditoDescuento= mostrarid_tarjeta_creditoTarjetaCreditoDescuento;
	}

	public Boolean getActivarid_tarjeta_creditoTarjetaCreditoDescuento() {
		return this.activarid_tarjeta_creditoTarjetaCreditoDescuento;
	}

	public void setActivarid_tarjeta_creditoTarjetaCreditoDescuento(Boolean activarid_tarjeta_creditoTarjetaCreditoDescuento) {
		this.activarid_tarjeta_creditoTarjetaCreditoDescuento= activarid_tarjeta_creditoTarjetaCreditoDescuento;
	}

	public Boolean getCargarid_tarjeta_creditoTarjetaCreditoDescuento() {
		return this.cargarid_tarjeta_creditoTarjetaCreditoDescuento;
	}

	public void setCargarid_tarjeta_creditoTarjetaCreditoDescuento(Boolean cargarid_tarjeta_creditoTarjetaCreditoDescuento) {
		this.cargarid_tarjeta_creditoTarjetaCreditoDescuento= cargarid_tarjeta_creditoTarjetaCreditoDescuento;
	}

	public Border setResaltarporcentajeTarjetaCreditoDescuento(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetaCreditoDescuentoBeanSwingJInternalFrame tarjetacreditodescuentoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tarjetacreditodescuentoBeanSwingJInternalFrame.jTtoolBarTarjetaCreditoDescuento.setBorder(borderResaltar);
		
		this.resaltarporcentajeTarjetaCreditoDescuento= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentajeTarjetaCreditoDescuento() {
		return this.resaltarporcentajeTarjetaCreditoDescuento;
	}

	public void setResaltarporcentajeTarjetaCreditoDescuento(Border borderResaltar) {
		this.resaltarporcentajeTarjetaCreditoDescuento= borderResaltar;
	}

	public Boolean getMostrarporcentajeTarjetaCreditoDescuento() {
		return this.mostrarporcentajeTarjetaCreditoDescuento;
	}

	public void setMostrarporcentajeTarjetaCreditoDescuento(Boolean mostrarporcentajeTarjetaCreditoDescuento) {
		this.mostrarporcentajeTarjetaCreditoDescuento= mostrarporcentajeTarjetaCreditoDescuento;
	}

	public Boolean getActivarporcentajeTarjetaCreditoDescuento() {
		return this.activarporcentajeTarjetaCreditoDescuento;
	}

	public void setActivarporcentajeTarjetaCreditoDescuento(Boolean activarporcentajeTarjetaCreditoDescuento) {
		this.activarporcentajeTarjetaCreditoDescuento= activarporcentajeTarjetaCreditoDescuento;
	}

	public Border setResaltarnumero_mesesTarjetaCreditoDescuento(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetaCreditoDescuentoBeanSwingJInternalFrame tarjetacreditodescuentoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tarjetacreditodescuentoBeanSwingJInternalFrame.jTtoolBarTarjetaCreditoDescuento.setBorder(borderResaltar);
		
		this.resaltarnumero_mesesTarjetaCreditoDescuento= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_mesesTarjetaCreditoDescuento() {
		return this.resaltarnumero_mesesTarjetaCreditoDescuento;
	}

	public void setResaltarnumero_mesesTarjetaCreditoDescuento(Border borderResaltar) {
		this.resaltarnumero_mesesTarjetaCreditoDescuento= borderResaltar;
	}

	public Boolean getMostrarnumero_mesesTarjetaCreditoDescuento() {
		return this.mostrarnumero_mesesTarjetaCreditoDescuento;
	}

	public void setMostrarnumero_mesesTarjetaCreditoDescuento(Boolean mostrarnumero_mesesTarjetaCreditoDescuento) {
		this.mostrarnumero_mesesTarjetaCreditoDescuento= mostrarnumero_mesesTarjetaCreditoDescuento;
	}

	public Boolean getActivarnumero_mesesTarjetaCreditoDescuento() {
		return this.activarnumero_mesesTarjetaCreditoDescuento;
	}

	public void setActivarnumero_mesesTarjetaCreditoDescuento(Boolean activarnumero_mesesTarjetaCreditoDescuento) {
		this.activarnumero_mesesTarjetaCreditoDescuento= activarnumero_mesesTarjetaCreditoDescuento;
	}

	public Border setResaltares_corrienteTarjetaCreditoDescuento(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetaCreditoDescuentoBeanSwingJInternalFrame tarjetacreditodescuentoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tarjetacreditodescuentoBeanSwingJInternalFrame.jTtoolBarTarjetaCreditoDescuento.setBorder(borderResaltar);
		
		this.resaltares_corrienteTarjetaCreditoDescuento= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_corrienteTarjetaCreditoDescuento() {
		return this.resaltares_corrienteTarjetaCreditoDescuento;
	}

	public void setResaltares_corrienteTarjetaCreditoDescuento(Border borderResaltar) {
		this.resaltares_corrienteTarjetaCreditoDescuento= borderResaltar;
	}

	public Boolean getMostrares_corrienteTarjetaCreditoDescuento() {
		return this.mostrares_corrienteTarjetaCreditoDescuento;
	}

	public void setMostrares_corrienteTarjetaCreditoDescuento(Boolean mostrares_corrienteTarjetaCreditoDescuento) {
		this.mostrares_corrienteTarjetaCreditoDescuento= mostrares_corrienteTarjetaCreditoDescuento;
	}

	public Boolean getActivares_corrienteTarjetaCreditoDescuento() {
		return this.activares_corrienteTarjetaCreditoDescuento;
	}

	public void setActivares_corrienteTarjetaCreditoDescuento(Boolean activares_corrienteTarjetaCreditoDescuento) {
		this.activares_corrienteTarjetaCreditoDescuento= activares_corrienteTarjetaCreditoDescuento;
	}

	public Border setResaltarcon_interesTarjetaCreditoDescuento(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetaCreditoDescuentoBeanSwingJInternalFrame tarjetacreditodescuentoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tarjetacreditodescuentoBeanSwingJInternalFrame.jTtoolBarTarjetaCreditoDescuento.setBorder(borderResaltar);
		
		this.resaltarcon_interesTarjetaCreditoDescuento= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_interesTarjetaCreditoDescuento() {
		return this.resaltarcon_interesTarjetaCreditoDescuento;
	}

	public void setResaltarcon_interesTarjetaCreditoDescuento(Border borderResaltar) {
		this.resaltarcon_interesTarjetaCreditoDescuento= borderResaltar;
	}

	public Boolean getMostrarcon_interesTarjetaCreditoDescuento() {
		return this.mostrarcon_interesTarjetaCreditoDescuento;
	}

	public void setMostrarcon_interesTarjetaCreditoDescuento(Boolean mostrarcon_interesTarjetaCreditoDescuento) {
		this.mostrarcon_interesTarjetaCreditoDescuento= mostrarcon_interesTarjetaCreditoDescuento;
	}

	public Boolean getActivarcon_interesTarjetaCreditoDescuento() {
		return this.activarcon_interesTarjetaCreditoDescuento;
	}

	public void setActivarcon_interesTarjetaCreditoDescuento(Boolean activarcon_interesTarjetaCreditoDescuento) {
		this.activarcon_interesTarjetaCreditoDescuento= activarcon_interesTarjetaCreditoDescuento;
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
		
		
		this.setMostraridTarjetaCreditoDescuento(esInicial);
		this.setMostrarid_empresaTarjetaCreditoDescuento(esInicial);
		this.setMostrarid_sucursalTarjetaCreditoDescuento(esInicial);
		this.setMostrarid_tarjeta_creditoTarjetaCreditoDescuento(esInicial);
		this.setMostrarporcentajeTarjetaCreditoDescuento(esInicial);
		this.setMostrarnumero_mesesTarjetaCreditoDescuento(esInicial);
		this.setMostrares_corrienteTarjetaCreditoDescuento(esInicial);
		this.setMostrarcon_interesTarjetaCreditoDescuento(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TarjetaCreditoDescuentoConstantesFunciones.ID)) {
				this.setMostraridTarjetaCreditoDescuento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoDescuentoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTarjetaCreditoDescuento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoDescuentoConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalTarjetaCreditoDescuento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoDescuentoConstantesFunciones.IDTARJETACREDITO)) {
				this.setMostrarid_tarjeta_creditoTarjetaCreditoDescuento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoDescuentoConstantesFunciones.PORCENTAJE)) {
				this.setMostrarporcentajeTarjetaCreditoDescuento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoDescuentoConstantesFunciones.NUMEROMESES)) {
				this.setMostrarnumero_mesesTarjetaCreditoDescuento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoDescuentoConstantesFunciones.ESCORRIENTE)) {
				this.setMostrares_corrienteTarjetaCreditoDescuento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoDescuentoConstantesFunciones.CONINTERES)) {
				this.setMostrarcon_interesTarjetaCreditoDescuento(esAsigna);
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
		
		
		this.setActivaridTarjetaCreditoDescuento(esInicial);
		this.setActivarid_empresaTarjetaCreditoDescuento(esInicial);
		this.setActivarid_sucursalTarjetaCreditoDescuento(esInicial);
		this.setActivarid_tarjeta_creditoTarjetaCreditoDescuento(esInicial);
		this.setActivarporcentajeTarjetaCreditoDescuento(esInicial);
		this.setActivarnumero_mesesTarjetaCreditoDescuento(esInicial);
		this.setActivares_corrienteTarjetaCreditoDescuento(esInicial);
		this.setActivarcon_interesTarjetaCreditoDescuento(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TarjetaCreditoDescuentoConstantesFunciones.ID)) {
				this.setActivaridTarjetaCreditoDescuento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoDescuentoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTarjetaCreditoDescuento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoDescuentoConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalTarjetaCreditoDescuento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoDescuentoConstantesFunciones.IDTARJETACREDITO)) {
				this.setActivarid_tarjeta_creditoTarjetaCreditoDescuento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoDescuentoConstantesFunciones.PORCENTAJE)) {
				this.setActivarporcentajeTarjetaCreditoDescuento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoDescuentoConstantesFunciones.NUMEROMESES)) {
				this.setActivarnumero_mesesTarjetaCreditoDescuento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoDescuentoConstantesFunciones.ESCORRIENTE)) {
				this.setActivares_corrienteTarjetaCreditoDescuento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoDescuentoConstantesFunciones.CONINTERES)) {
				this.setActivarcon_interesTarjetaCreditoDescuento(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TarjetaCreditoDescuentoBeanSwingJInternalFrame tarjetacreditodescuentoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTarjetaCreditoDescuento(esInicial);
		this.setResaltarid_empresaTarjetaCreditoDescuento(esInicial);
		this.setResaltarid_sucursalTarjetaCreditoDescuento(esInicial);
		this.setResaltarid_tarjeta_creditoTarjetaCreditoDescuento(esInicial);
		this.setResaltarporcentajeTarjetaCreditoDescuento(esInicial);
		this.setResaltarnumero_mesesTarjetaCreditoDescuento(esInicial);
		this.setResaltares_corrienteTarjetaCreditoDescuento(esInicial);
		this.setResaltarcon_interesTarjetaCreditoDescuento(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TarjetaCreditoDescuentoConstantesFunciones.ID)) {
				this.setResaltaridTarjetaCreditoDescuento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoDescuentoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTarjetaCreditoDescuento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoDescuentoConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalTarjetaCreditoDescuento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoDescuentoConstantesFunciones.IDTARJETACREDITO)) {
				this.setResaltarid_tarjeta_creditoTarjetaCreditoDescuento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoDescuentoConstantesFunciones.PORCENTAJE)) {
				this.setResaltarporcentajeTarjetaCreditoDescuento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoDescuentoConstantesFunciones.NUMEROMESES)) {
				this.setResaltarnumero_mesesTarjetaCreditoDescuento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoDescuentoConstantesFunciones.ESCORRIENTE)) {
				this.setResaltares_corrienteTarjetaCreditoDescuento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TarjetaCreditoDescuentoConstantesFunciones.CONINTERES)) {
				this.setResaltarcon_interesTarjetaCreditoDescuento(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TarjetaCreditoDescuentoBeanSwingJInternalFrame tarjetacreditodescuentoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaTarjetaCreditoDescuento=true;

	public Boolean getMostrarFK_IdEmpresaTarjetaCreditoDescuento() {
		return this.mostrarFK_IdEmpresaTarjetaCreditoDescuento;
	}

	public void setMostrarFK_IdEmpresaTarjetaCreditoDescuento(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTarjetaCreditoDescuento= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalTarjetaCreditoDescuento=true;

	public Boolean getMostrarFK_IdSucursalTarjetaCreditoDescuento() {
		return this.mostrarFK_IdSucursalTarjetaCreditoDescuento;
	}

	public void setMostrarFK_IdSucursalTarjetaCreditoDescuento(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalTarjetaCreditoDescuento= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTarjetaCreditoTarjetaCreditoDescuento=true;

	public Boolean getMostrarFK_IdTarjetaCreditoTarjetaCreditoDescuento() {
		return this.mostrarFK_IdTarjetaCreditoTarjetaCreditoDescuento;
	}

	public void setMostrarFK_IdTarjetaCreditoTarjetaCreditoDescuento(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTarjetaCreditoTarjetaCreditoDescuento= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTarjetaCreditoDescuento=true;

	public Boolean getActivarFK_IdEmpresaTarjetaCreditoDescuento() {
		return this.activarFK_IdEmpresaTarjetaCreditoDescuento;
	}

	public void setActivarFK_IdEmpresaTarjetaCreditoDescuento(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTarjetaCreditoDescuento= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalTarjetaCreditoDescuento=true;

	public Boolean getActivarFK_IdSucursalTarjetaCreditoDescuento() {
		return this.activarFK_IdSucursalTarjetaCreditoDescuento;
	}

	public void setActivarFK_IdSucursalTarjetaCreditoDescuento(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalTarjetaCreditoDescuento= habilitarResaltar;
	}

	public Boolean activarFK_IdTarjetaCreditoTarjetaCreditoDescuento=true;

	public Boolean getActivarFK_IdTarjetaCreditoTarjetaCreditoDescuento() {
		return this.activarFK_IdTarjetaCreditoTarjetaCreditoDescuento;
	}

	public void setActivarFK_IdTarjetaCreditoTarjetaCreditoDescuento(Boolean habilitarResaltar) {
		this.activarFK_IdTarjetaCreditoTarjetaCreditoDescuento= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTarjetaCreditoDescuento=null;

	public Border getResaltarFK_IdEmpresaTarjetaCreditoDescuento() {
		return this.resaltarFK_IdEmpresaTarjetaCreditoDescuento;
	}

	public void setResaltarFK_IdEmpresaTarjetaCreditoDescuento(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTarjetaCreditoDescuento= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTarjetaCreditoDescuento(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetaCreditoDescuentoBeanSwingJInternalFrame tarjetacreditodescuentoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTarjetaCreditoDescuento= borderResaltar;
	}

	public Border resaltarFK_IdSucursalTarjetaCreditoDescuento=null;

	public Border getResaltarFK_IdSucursalTarjetaCreditoDescuento() {
		return this.resaltarFK_IdSucursalTarjetaCreditoDescuento;
	}

	public void setResaltarFK_IdSucursalTarjetaCreditoDescuento(Border borderResaltar) {
		this.resaltarFK_IdSucursalTarjetaCreditoDescuento= borderResaltar;
	}

	public void setResaltarFK_IdSucursalTarjetaCreditoDescuento(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetaCreditoDescuentoBeanSwingJInternalFrame tarjetacreditodescuentoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalTarjetaCreditoDescuento= borderResaltar;
	}

	public Border resaltarFK_IdTarjetaCreditoTarjetaCreditoDescuento=null;

	public Border getResaltarFK_IdTarjetaCreditoTarjetaCreditoDescuento() {
		return this.resaltarFK_IdTarjetaCreditoTarjetaCreditoDescuento;
	}

	public void setResaltarFK_IdTarjetaCreditoTarjetaCreditoDescuento(Border borderResaltar) {
		this.resaltarFK_IdTarjetaCreditoTarjetaCreditoDescuento= borderResaltar;
	}

	public void setResaltarFK_IdTarjetaCreditoTarjetaCreditoDescuento(ParametroGeneralUsuario parametroGeneralUsuario/*TarjetaCreditoDescuentoBeanSwingJInternalFrame tarjetacreditodescuentoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTarjetaCreditoTarjetaCreditoDescuento= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}